//type이 sk인, name으로 구성된 배열을 
//json파일에서 추출해 출력해보자.

var data;
var fso=new ActiveXObject("Scripting.FileSystemObject");
var filename="3-2_object_exam2_json.json"

var array = [];
var emptyarray = [];

function loadfile(){
    if(!fso.fileExists(filename))
        fso.CreateTextFile(filename,true);
    
    var f=fso.OpenTextFile(filename,1);
    data=f.ReadAll();
    f.Close();
}

data = JSON.parse(fso.responseText);

function searchsk(array, obj){
    var name = obj.name;
    if(obj.type=='sk')
        array.push(obj.name);
    
    if(obj.childnode!=emptyarray)
        searchsk(array, obj.childnode);
}


searchsk(array, data);
console.log(array);