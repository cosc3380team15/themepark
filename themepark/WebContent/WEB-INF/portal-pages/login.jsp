<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Portal Login</title>
</head>
<body>
	<form method="POST" action="LoginServlet">
		<p>Username: <input type="text" name="user"/></p>
		<p>Password: <input type="password" name="pwd"/></p>
		<br>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>