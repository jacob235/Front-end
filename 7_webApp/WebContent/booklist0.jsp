<%@page import="vo.BookVO"%>
<%@page import="dao.BookDao"%>
<%@page import="java.util.List"%>
<%@page import="service.BookServiceImpl"%>
<%@page import="service.BookService"%>
<%@page import="dao.BookDao_Oracle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<body>

<h3>Book List</h3>

<table class = "tablea">
<tr><th>bookid</th><th>bookname</th><th>publisher</th><th>price</th></tr>

<%
// BookDao dao = new BookDao();
// BookService service = new BookServiceImpl(dao);
// List<BookVO> list = service.bookList();

List<BookVO> list = (List<BookVO>)request.getAttribute("booklist");
for(BookVO data: list){
	%>
	<tr>
	<td><%=data.getBookid() %></td>
	<td><%=data.getBookname() %></td>
	<td><%= data.getPublisher() %></td> 
	<td><%=data.getPrice() %></td>
	</tr>
	
<% } %>

</table>


</body>
</html>