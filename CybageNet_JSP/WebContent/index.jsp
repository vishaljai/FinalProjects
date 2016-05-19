<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="cyb.cybnet.listeners.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cybage Net</title>
<link rel="stylesheet" type="text/css" href="res/css/base.css" >
</head>
<body>
	<div class="topright">
		<c:set var="user" value="${sessionScope.user}"></c:set>
		
		<c:if test="${empty user}"> 
			<a class="top-option" href="Login.jsp" >Login</a>
		</c:if>	
			
		<c:if test="${user.userRole.equals('admin')}">
			<a class='top-option' href='admin/AddBook.jsp' >Add new book</a>
			<a class='top-option left' href='log.txt' >Show Logs</a>
		</c:if>
		
		<c:if test="${!empty user}">
			<span class='top-option-disabled'>Hello, ${user.userName}</span>
			<a class='top-option' href='LogoutServlet' >Logout</a>
		</c:if>		
		
	</div>
	
	<div >
		<c:if test="${!empty cookie.visits.value}">
			<div class='notif'>This is your : ${cookie.visits.value} visit</div>
		</c:if>
		<c:if test="${user.userRole.equals('admin')}">
			<div class='notif'>Currently Logged in : <%=MySessionListener.getSessionCount()%> users</div>
		</c:if>
	</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
	<div class="center">
		<span class="logo" >Cybage Net</span>
		<br>
		<span class="sublogo" >books . reviews . fun</span>
		<br>
		<form method="get" action="Search.jsp">
			<br>
			<input class="base-size search" type="text" placeholder="type name here ..." name="title" autofocus="autofocus" autocomplete="on"><br>
			<br>
			<input class="base-size" type="submit" value="search">
		</form>
	</div>
</body>
</html>