    var oReq = new XMLHttpRequest();



    oReq.addEventListener("load", function(){
        console.log(this.responseText);
    });
    oReq.open("GET", "./JS2_4.json");
    oReq.send();
