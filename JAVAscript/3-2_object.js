var obj = {name : "pangsorry", age : 27,
    addition : [
        {key:"value", id:"vvv"}
    ]};

console.log(obj.name);
console.log(obj["name"]);
console.log(obj.addition[0].key);

for(name in obj){
    console.log(obj[name]);
}


console.log("0000000");
console.log("0000000");


console.log(Object.keys(obj)); //객체의 키 출력

Object.keys(obj).forEach(function(v) { //키들을 받아 밸류 출력
    console.log(obj[v]);
});
