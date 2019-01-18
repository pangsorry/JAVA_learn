<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>

<%
	pageContext.setAttribute("p1", "value of pagescope");
	request.setAttribute("r1", "value of request");
	session.setAttribute("s1", "value of session");
	application.setAttribute("a1", "value of application");
	
	request.setAttribute("r2", 10);
	request.setAttribute("r3", true);

%>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

pageContext.getAttribute("p1") : 
<%= pageContext.getAttribute("p1") %>  ${pageScope.p1} <br>

request.getAttribute("r1") :  ${requestScope.r1}<br>
session.getAttribute("s1") :  ${sessionScope.s1}<br>
application.getAttribute("a1") :  ${applicationScope.a1}<br>
request.getAttribute("r1") :  ${r1}<br>
session.getAttribute("s1") :  ${s1}<br>
application.getAttribute("a1") :  ${a1}<br>

r2 : ${r2 }<br>
r2+5 : ${r2+5 }<br>
r2-5 : ${r2-5 }<br>
r2/5 : ${r2 div 5 }<br>
r2*5 : ${r2*5 }<br>
r2%5 : ${r2 mod 5 }<br>
<br>
r2 > 5 : ${r2 > 5 } ${r2 gt 5 }<br>
r2 < 5 : ${r2 < 5 } ${r2 lt 5 }<br>
r2 >= 10 : ${r2 >= 10 } ${r2 ge 10 }<br>
r2 <= 10 : ${r2 <= 10 } ${r2 le 10 }<br>
<br>
r3 : ${r3 }<br>
!r3 : ${!r3 }<br>
r3==r2 < 5 : ${r3== r2 > 5 }<br>
r3!=r2 <= 10 : ${r3!= r2 le 10 }<br>


</body>
</html>