<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin's Dashboard</title>
<link rel='stylesheet' type='text/css' href='../res/css/addbook.css'>
</head>
<body>
	<div class='maindiv'>
			<a href="/CybageNet_JSP/index.jsp">
			<div class='logodiv'>
				<span class='logo'>Cybage Net - Add Book</span>
			</div>
			</a>
		</div>
	<center>
	<br>
	<br>
	<br>
	<form action="#" method="post">
	<table class="addbooktable">
		<tr>
			<td>Title</td>
			<td><input type="text" name="bookTitle" required="required"></td>
		</tr>
		<tr>
			<td>Author</td>
			<td><input type="text" name="bookAuthor" required="required"></td>
		</tr>
		<tr>
			<td>ISBN Code</td>
			<td><input type="number" name="bookISBN" required="required"></td>
		</tr>
		<tr>
			<td>Number of pages</td>
			<td><input type="number" name="bookNOP" required="required"></td>
		</tr>
		<tr>
			<td>Publication</td>
			<td><input type="text" name="bookPublication" required="required"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea cols="100" rows="5" name="bookDescription" required="required"></textarea></td>
		</tr>
		<tr>
			<td>Genre</td>
			<td><input type="text" name="bookGenre" required="required"></td>
		</tr>
		<tr>
			<td>
				<input class="btn" type="submit" value="Add Book">
				<input class="btn" type="reset" value="clear">
			</td>
		</tr>
	</table>
	</form>
	</center>
	<c:if test="${param.bookTitle!=null && !param.bookTitle.isEmpty()}">
		<jsp:useBean id="bookBean" class="cyb.cybnet.dto.Book"></jsp:useBean>
		<jsp:setProperty property="*" name="bookBean"/>
	 	<jsp:useBean id="dao" class="cyb.cybnet.dao.impl.BookDAOImpl"></jsp:useBean>
		${dao.addBook(bookBean)}
		<center>
			<span style="color:green">Book added successfully!</span>
		</center> 
	</c:if> 
	
</body>
</html>