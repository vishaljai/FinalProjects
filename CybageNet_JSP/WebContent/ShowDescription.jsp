<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Description</title>
<link rel='stylesheet' type='text/css' href="res/css/addbook.css">
<link rel='stylesheet' type='text/css' href="res/css/review.css">
</head>
<body>
	<div class='maindiv'>
		<a href='/CybageNet_JSP/'>
			<div class='logodiv'>
				<span class='logo'>Cybage Net - Book Description</span>
			</div>
		</a>
	</div>
	
	<jsp:useBean id="dao" class="cyb.cybnet.dao.impl.BookDAOImpl"></jsp:useBean>
	<jsp:useBean id="myBook" class="cyb.cybnet.dto.Book"></jsp:useBean>
	<jsp:setProperty property="bookId" name="myBook" />
	<c:set var="book" value="${dao.getBook(myBook)}"></c:set>
	
	<jsp:useBean id="userDao" class="cyb.cybnet.dao.impl.UserDAOImpl"></jsp:useBean>
	<jsp:useBean id="revDao" class="cyb.cybnet.dao.impl.ReviewDAOImpl"></jsp:useBean>
	
	<br>
	<div class='reviewHome'>
		<h1>Book Details</h1>
	</div>
	<center>
		<table class='addbooktable' border='1'>
			<tr>
				<td>Title</td>
				<td><span class='element'>${book.bookTitle}</span></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><span class='element'>${book.bookAuthor}</span></td>
			</tr>
			<tr>
				<td>ISBN Code</td>
				<td><span class='element'>${book.bookISBN}</span></td>
			</tr>
			<tr>
				<td>Number of pages</td>
				<td><span class='element'>${book.bookNOP}</span></td>
			</tr>
			<tr>
				<td>Publication</td>
				<td><span class='element'>${book.bookPublication}</span></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><span class='element'>${book.bookDescription}</span></td>
			</tr>
			<tr>
				<td>Genre</td>
				<td><span class='element'>${book.bookGenre}</span></td>
			</tr>
		</table>
	</center>

	<c:set var="revList" value="${revDao.getReviewListByBook(book)}"></c:set>
	<div class='revMain'>
		<h1>Reviews</h1>
		<c:if test="${empty revList}">
			No reviews have been given for this book
		</c:if>
		<c:forEach var="rev" items="${revList}">
				<jsp:useBean id="user" class="cyb.cybnet.dto.User"></jsp:useBean>
				<jsp:setProperty property="userId" name="user" value="${rev.reviewBy}"/>				
				<div class='revPane'>
					<div class='revby'>${userDao.getUserById(user).userName}</div>
			        <div class='revCont'><pre>${rev.reviewReview}</pre></div>
		        </div>
		</c:forEach>
	</div>
</body>
</html>