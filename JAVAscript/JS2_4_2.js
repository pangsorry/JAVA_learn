var request = null;
function createRequest(){
 try{
  request = new XMLHttpRequest();
 } catch(trymicrosoft){
  try{
   request = new ActiveXObject("Msxml2.XMLHTTP");
  } catch(othermicrosoft){
   try{
    request = new ActiveXObject("Microsoft.XMLHTTP");
   } catch(failed){
    request = null;
   }
  }
 }
 
 if(request == null) location.reload();
}

function ajaxPostSend(){
    var url = "ajax_post.asp";
    var postString = "";
    
    postString   = "userId=" + encodeURIComponent(document.getElementById("userId").value);
    postString += "&pwd=" + encodeURIComponent(document.getElementById("pwd").value);
    postString += "&userName=" + encodeURIComponent(document.getElementById("userName").value);
    
    request.open("POST",url,true);   
    request.onreadystatechange = ajaxPostRequest;
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=euc-kr");
    request.send(postString);
   }

/*
post 방식은 요청body에 데이터를 받아서 보낸다.
따라서 이 정보가 어디 있는지도 알려줘야 한다.
postString에 보낼 변수를 담는다.
데이터 전송시에는 ascii코드로 전송해야하며 그렇기때문에 인코딩이 필요하다.
인코딩 방식에는 escape, encodeURI, encodeURIComponent가 있다.
encodeURIComponent 함수는 모든 문자를 인코딩한다. 
그래서 한글이 깨질 수 도 있다.
한글을 위해선 escape()로 고치면 깨지지 않는다.
escape()는 아스키문자 이외의 문자열을 유니코드형식으로 변환한다.


send로 만든 것을 보낸다.
get방식은 send에 null이 들어가지만 post방식은 postString을 보내기에 넣어준다.
*/

function ajaxPostRequest(){
    if(request.readyState == 4){
     if(request.status == 200){
      var strText = request.responseText;
      document.getElementById("requestResult").innerHTML = strText;
     }
    }
   }
/*
text를 받은 후 그 텍스트를
[requestResult] ID를 가진 태그의 innerHTML로 바꾸는 과정.
*/



createRequest();

/*<% Session.CodePage = 949 %>
<%
Response.CharSet = "euc-kr"
Response.AddHeader "Pragma","no-cache"
Response.AddHeader "Expires","0"

response.write "사용자아이디 : " & request("userId") &"<br>"
response.write "사용자비번 : " & request("pwd")&"<br>"
response.write "사용자이름 : " & request("userName")
%>*/