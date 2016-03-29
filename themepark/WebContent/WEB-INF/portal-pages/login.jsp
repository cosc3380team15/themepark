<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Portal Login</title>
</head>
<body>
	<form method="POST" action="Login">
		<p>Username: <input type="text" name="user"/></p>
		<p>Password: <input type="password" name="pwd"/></p>
		<p>
			<c:out value="replace with login err msg"/>
		</p>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>