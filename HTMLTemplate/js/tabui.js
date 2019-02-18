
function sendAjax(url, name){
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function(){
        var data= JSON.parse(oReq.responseText);
        makeTemplate(data, name);
    });
    oReq.open("GET", url);
    oReq.send();
}

function makeTemplate(data, name){
    var tab = document.querySelector("#tabtem");
    var baseText = tab.innerHTML;

    var resultText="";
    //console.log(data);
    //console.log(baseText);
    for(var i=0,len=data.length; i<len;i++){
        if(data[i].name==name){
            resultText += baseText.replace("{key}", data[i].name)
                                .replace("{level}",data[i].level);
            break;
        }
    }
    console.log(resultText);
    document.querySelector(".content").innerHTML=resultText;
}

var tabmenu = document.querySelector(".tabmenu");
tabmenu.addEventListener("click", function(evt){
    //console.log(evt.target.innerText);
    var name = evt.target.innerText;
    //console.log(name);
    sendAjax("./json.txt", name);
})