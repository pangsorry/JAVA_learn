<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



${number1 } + ${number2 } = ${resultvalue}     <%-- EL code --%>

<br><br>

<%
	int v1 = (Integer)request.getAttribute("number1");
	int v2 = (Integer)request.getAttribute("number2");
	int result = (Integer)request.getAttribute("resultvalue");
%>

<%=v1 %> + <%=v2 %> = <%=result %> <br>
<%=v1 %> + <%=v2 %> = <%=v1+v2 %>

</body>
</html>