var a;

//Request 객체 만들기
if (window.XMLHttpRequest) { // Mozilla, Safari, Chrome...
     a = new XMLHttpRequest();
} else if (window.ActiveXObject) { // IE
    try {
        a = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e) {
        try {
            a = new ActiveXObject("Microsoft.XMLHTTP");
        }
        catch (e) {}
    }
}
//try-catch로 분기를 타는 이유는 
//브라우저마다 XMLHttpRequest객체를 만드는 방법이 다르기 때문


//응답처리 콜백함수 등록
//클라의 요청에 대한 서버의 응답에 대응해 onreadystatechage에 등록한
//함수가 호출됨.
a.onreadystatechange = function(){
 
    if(a.readyState === 4){
        // 응답 처리
        if (a.status === 200) {
            alert(a.responseText);
        } else {
            alert('There was a problem with the request.');
        }
 
    } else {
        // 대기중
    }

/** readyState의 정보
 * 0 : Request객체 생성 완료
 * 1 : connection open한 상태
 * 2 : 데이터 send 완료
 * 3 : 서버 측 데이터 수신 중
 * 4 : 수신 완료 */


//open으로 커넥션을 열고 send로 서버에 요청을 전송한다.
a.open("GET", "./JS2_4.json");
a.send();

//post방식은 서버의 응답으로 인해 나의 html화면이 변경이 있을 경우 쓴다.
//그를 위해 컨텐츠타입을 지정해줘야한다.