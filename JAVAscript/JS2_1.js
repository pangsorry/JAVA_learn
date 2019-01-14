function run() {
    console.log("run start");
    setTimeout ( function() {
        var msg = "hello codesquad";
        console.log(msg);
        console.log("run......ing");
    } , 1000);
    console.log("run end");
    }

function runInterval() {
    console.log("Interval start");
    setInterval ( function() {
        var msg2= "hello pangsorry";
        console.log(msg2);
    }, 3000);
}

console.log("execute before");
runInterval ();
console.log("execute after");