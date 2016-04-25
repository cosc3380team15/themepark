<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Favicon.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Employee Portal Login</title>
</head>
<body>
<div align = "right"><span style = "background-color: #8ed9f6"><a href="/themepark">Back To Duff Gardens</a></span></div>

	<div id="login-box">
		<form class="clean-look center-form" method="POST" action="Login">
			<div class="row">
				<div class="col">
					<label for="user">Username</label>
					<input type="text" name="user"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="pwd">Password</label>
					<input type="password" name="pwd"/>
				</div>
			</div>
			
			<div class="row">
				<div class="col submitButtonColumn">
					<input class="button" type="submit" value="Login"/>
				</div>
			</div>
			
			<c:if test="${loginPageMsg != null}">
				<div class="row">
					<div class="col">
						<span class="messageBox">
							<c:out value="${loginPageMsg}"/>
						</span>
					</div>
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>