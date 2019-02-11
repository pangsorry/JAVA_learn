var a = [1,2,3,"hello",null, true, [[{1:0}]]]
a[1000] = 3;

a.push(5);  //배열 맨 뒤에 추가되는 함수

console.log(a.length);  
console.log(a[500]);   // 넣은게 없으므로 undefined

console.log(a.indexOf(null)); // 배열 4번째에 null이 있음으로 4 출력
console.log(a.indexOf(false)); //배열 안에 false가 없음으로 -1 출
console.log(a.indexOf(5)); //배열 안에 false가 없음으로 -1 출력

var b = [1,3,2,4,6];
var result = b.concat(2,3);   //b에 2,3 합침
var resultES = [...b, 4, 5];  //



console.log(result);   
console.log(resultES);   

console.log(resultES.join()); //배열을 string화
console.log("-----------");  


b.forEach(function(value,index,array){
    console.log(value);
})

var mapped = b.map(function(v) {
    return v * 2;
})

console.log(b);
console.log(mapped);
