<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <header>
       <hgroup>
       <div id = "mainTitle">
		   <h1>Page Title</h1>
		</div>
		<div id= "subTitle">
		   <h2> Page SubTitle</h2>
		</div>
		</hgroup>
	 </header>	
	 
		<nav id="top_menu">
		   <ul>
		      <li> <a href="index.jsp">Home</a></li>
		      <li class = "dropbox"> 
		      	<a id="etc" href="#">게시판</a>
			      <span class = "dropmenu">
				      <span> <a href="img1.html" class="btn">자유게시판</a></span>
				      <span> <a href="table.html" class="btn">문의게시판</a></span>
				      <span> <a href="booklist.do" class="btn">bookList</a></span>
				      <span> <a href="#" class="btn">Link 4</a></span>
				      <span> <a href="#" class="btn">Link 5</a></span>
			      </span>
		      </li>
		      <li> <a href="#">Tutorials</a></li>
		      <li> <a href="#">About</a></li>
		     <c:if test="${empty login}">
				<li><a href="./login.jsp">login</a></li>
			</c:if>
		     <c:if test="${!empty login}">
				<li><a href="./logout.do">Logout</a></li>
			</c:if>
		   </ul>
		</nav>