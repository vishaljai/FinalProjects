<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Delete Book</title>
		<link rel='stylesheet' type='text/css' href="../res/css/base.css">
	</head>
	<body>
			<c:if test="${!empty param.btn}">
				<c:if test="${param.btn.equals('yes')}">
					<jsp:useBean id="bookDao" class="cyb.cybnet.dao.impl.BookDAOImpl"></jsp:useBean>
					<jsp:useBean id="book" class="cyb.cybnet.dto.Book"></jsp:useBean>
					<jsp:setProperty property="bookId" name="book"/>
					${bookDao.deleteBook(book)}
				</c:if>
				<c:redirect url="../index.jsp" ></c:redirect>
			</c:if>
			<br><br><br><br><br><br><br><br><br><br><br><br>
			<form method='post' action='#'>
				<div style='text-align: center'>
					<h1>Are you sure?</h1><br>
					<p>Are you sure that you want to delete this book?</p>
					<br>
					<input type='hidden' value='request.getParameter(id)'>
					<input class='subbtn' type='submit' name='btn' value='yes'>&nbsp;&nbsp;&nbsp;<input class='subbtn' type='submit' name='btn' value='no'>
				</div>
			</form>
				
	</body>
</html>