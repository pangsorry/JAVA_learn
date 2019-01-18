<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="value1" scope="request" value="pang"></c:set>

<%
	request.setAttribute("n1",11);

	List<String> list = new ArrayList<>();
	list.add("hello");
	list.add("world");
	list.add("!!!!");
	list.add("hello");
	list.add("world");
	list.add("!!!!");
	request.setAttribute("list", list);
%>
<c:set var="n2" scope="request" value="12"/>
<c:import url="http://localhost:8080/first_web/exam1.jsp" var="urlValue" scope="request"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

닉네임 : ${requestScope.value1 }<br>

<c:remove var="value1" scope="request"/>
닉네임 : ${value1 }<br>

<br>

<c:if test="${n1==10 }">
	n과 10은 같습니다.<br>
</c:if>
<c:if test="${n2==12 }">
	n2와 12는 같습니다.<br>
</c:if>

<br>

<c:choose>
 <c:when test="${n1==10 }">
 	n1은 10이다<br>
 </c:when>
 <c:when test="${n2==12 }">
 	n2는 12이다.<br>
 </c:when>
 <c:otherwise>
 	<br><br>
 </c:otherwise>
</c:choose>

<br>

<c:forEach items="${list }" var="item" begin="1" end="3">
	${item }<br>
</c:forEach>

<br>

${urlValue }

<br>
</body>
</html>