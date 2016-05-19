<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="res/css/base.css" >
</head>

<body>
	<br><br><br><br><br>
	<center>
	<div class="center">
		<span class="logo" style="font-size : 60px;">Cybage Net</span>
		<form method="post" action="LoginServlet">
			<table class="login-form" align="center">
				<tr>
					<td>Username</td>
					<td><input type="text" name="user" required="required"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" style="padding-top: 15px"><input class="subbtn" type="submit" value="login">
					<input class="subbtn" type="reset" value="clear"></td>
				</tr>
			</table>
		</form>
	</div>
	</center>
</body>
</html>