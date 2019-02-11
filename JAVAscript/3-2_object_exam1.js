const data = {
    "debug": "on",
    "window": {
        "title": "Sample Konfabulator Widget",
        "name": "main_window",
        "width": 500,
        "height": 500
    },
    "image": { 
        "src": "Images/Sun.png",
        "name": "sun1",
        "hOffset": 250,
        "vOffset": 250,
        "alignment": "center"
    },
    "text": {
        "data": "Click Here",
        "size": 36,
        "style": "bold",
        "name": "text1",
        "hOffset": 250,
        "vOffset": 100,
        "alignment": "center",
        "onMouseUp": "sun1.opacity = (sun1.opacity / 100) * 90;"
    }
}

//const data에서 value가 숫자인 요소만 뽑아내보자.

var array = [];

function searchnum(array, obj){
    for(key in obj){
        if(typeof(obj[key])==='number')
            array.push(key);
        else if(typeof(obj[key])==='object')
            searchnum(array, obj[key]);
    }
}

searchnum(array, data);
console.log(array);