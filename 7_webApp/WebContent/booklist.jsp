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

<h3>Book List</h3>

<form action="deleteBook.do" method="get">
<table class = "tablea">
<tr><th>bookid</th><th>bookname</th><th>publisher</th><th>price</th>
	<th><input type="submit" id="del" value="삭제"  onclick="return f1()"></th></tr>

<c:forEach var = "data" items="${booklist}">
	<tr>
		<td> ${data.bookid} </td>
		<td><a href = "viewBook.do?bookid=${data.bookid}"> ${data.bookname} </td>
		<td><a href = "viewpublisher.do?publisher=${data.publisher}"> ${data.publisher} </a></td>
		<td> ${data.price} </td>
		<td> <input type="checkbox" id="" name="bookid" value="${data.bookid}"> </td>
	</tr>
</c:forEach>


</table>
</form>
</section>
</div>

<%@include file="common/footer.jsp" %>

<script>
function f1(){
	return confirm("정말 삭제 할거니?");
}
</script>

</body>
</html>