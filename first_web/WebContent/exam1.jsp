<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSP주석 
	jsp가 서블릿으로 변환될 때 걸러짐--%>
<!-- HTML주석 
	브라우저에서 걸러짐-->
<%
//java 주석
/*
java 주석 여러줄도가능
서블렛에서 걸러짐*/
%>
id : <%=getID() %>
<%!
	String id = "u001";
	public String getID(){
		return id;
	}
%>
<%
	for(int i=1;i<=5;i++){
%>
<H<%=i %>>아름다운 한글</H<%=i %>>
<%} %>


</body>
</html>