<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Review</title>
<link rel='stylesheet' type='text/css' href="res/css/addbook.css">
</head>
<body>
	<div class='maindiv'>
		<a href='/CybageNet_JSP/'>
			<div class='logodiv'>
				<span class='logo'>Cybage Net - Review Page</span>
			</div>
		</a>
	</div>
	<center>
		<br> <br> <br> 
		<jsp:useBean id="bookDao" class="cyb.cybnet.dao.impl.BookDAOImpl"></jsp:useBean>
		<jsp:useBean id="book" class="cyb.cybnet.dto.Book"></jsp:useBean>
		<jsp:setProperty property="bookId" name="book"/>
		
		<c:set var="book" value="${bookDao.getBook(book)}"></c:set>
		<form action='AddReviewServlet' method='post'>
			<table class='addbooktable'>
				<input type='hidden' name='bk_id' value="${book.bookId}">
				<tr>
					<td>Title</td>
					<td><span class='element'>${book.bookTitle}</span></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><span class='element'>${book.bookAuthor}</span></td>
				</tr>
				<tr>
					<td>Publication</td>
					<td><span class='element'>${book.bookPublication}</span></td>
				</tr>
				<tr>
					<td>Genre</td>
					<td><span class='element'>${book.bookGenre}</span></td>
				</tr>
				<tr>
					<td>Review</td>
					<td><textarea cols='100' rows='10' name='review' required='required'></textarea></td>
				</tr>
				<tr>
					<td colspan='2'><input class='btn' type='submit' value='save'>
						<input class='btn' type='reset' value='clear'></td>
				</tr>
			</table>
		</form>
	</center>


</body>
</html>