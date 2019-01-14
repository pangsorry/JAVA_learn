var el=document.querySelector("#outside");
var el2=document.querySelector("#outside2");


el.addEventListener("click", function(evt) {
    var target=evt.target;
    
    console.log('clicked');
    console.log(target.nodeName, target.id);
    console.log(target.innerText);
});

function random(maxnum){
    return (Math.random()*1000)%255;
}

function bgChange(e){
    var rndCol='rgb('+random(255)+','+random(255)+','+random(255)+')';
    e.target.style.backgroundColor=rndCol;
    console.log(e);   
}

el2.addEventListener('click', bgChange);
