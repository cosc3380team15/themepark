<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Employee Portal Login</title>
</head>
<body>
	<form class="login-box" method="POST" action="Login">
	<div class="container-60" style="margin-top: 20px;">
		<div class="row">
			<div class="col-12">
				<label for="user">Username</label>
				<input type="text" name="user"/>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<label for="pwd">Password</label>
				<input type="password" name="pwd"/>
			</div>
		</div>
		<!-- 
		<p>
			<c:out value="replace with login err msg"/>
		</p>
		-->
		<div class="row">
			<div class="col-12">
				<input class="button" type="submit" value="Login"/>
			</div>
		</div>
	</div>
	</form>
</body>
</html>