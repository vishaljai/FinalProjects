<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
<link rel='stylesheet' type='text/css' href="res/css/subbase.css">
</head>
<body>
	<div class='maindiv'>
		<form method='get' action='#'>
			<a href='/CybageNet_JSP/'>
				<div class="logodiv">
					<span class='logo'>Cybage Net</span>
				</div>
			</a>
			<input autofocus="autofocus" class='base-size search' type='text' placeholder='type name here ...' name='title'>
			<input class='base-size' type='submit' value='search'>
		</form>
	</div>
	<jsp:useBean id="dao" class="cyb.cybnet.dao.impl.BookDAOImpl"></jsp:useBean>
	<c:set var="list" value="${dao.getBookListByName(param.title)}"></c:set>
	<center>
		<table border='1px solid' >
			<tr>
				<th>Title</th>
				<th>Author</th>
				<th>Publication</th>
				<th>Genre</th>
				<th>Options</th>
			</tr>
			<c:if test="${empty list}">
			<tr>
					<td colspan="5">Sorry, no such book found!</td>
			</tr>
			</c:if>
			<c:forEach var="book" items="${list}">
				<tr>
					<td>${book.bookTitle}</td>
					<td>${book.bookAuthor}</td>
					<td>${book.bookPublication}</td>
					<td>${book.bookGenre}</td>
					<td>
					<a class='btn' href='ShowDescription.jsp?bookId=${book.bookId}'>description</a>
					<a class='btn' href='AddReview.jsp?bookId=${book.bookId}'>write review</a>
					<c:if test="${sessionScope.user.userRole.equals('admin')}">
						<a class='btn' href='admin/DeleteBook.jsp?bookId=${book.bookId}'>Delete</a>
					</c:if>	
				</td>
			</tr>
			</c:forEach>
			</table>
		

</body>
</html>