<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/button.css">
<link rel="stylesheet" href="css/layout.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="common/header.jsp" %>

<div id="output">
<section>

<h3>menu 클릭하세요</h3>
<div>

<c:if test="${empty login}">
	<h2><a href="./login.jsp">LOGIN</a></h2>
</c:if>
	
<c:if test="${!empty login}">
	<h2><a href="./logout.do">LOGOUT</a></h2>
	<h2><a href="./bookform.jsp">도서등록 폼</a></h2>
	<h2><a href="./listBook.do">도서목록</a></h2>
</c:if>

</div>

</section>
</div>

<%@include file="common/footer.jsp" %>

</body>
</html>