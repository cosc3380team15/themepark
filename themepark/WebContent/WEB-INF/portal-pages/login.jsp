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
	<div id="login-box">
		<form method="POST" action="Login">
			<div class="row">
				<div class="col-10">
					<label for="user">Username</label>
					<input type="text" name="user"/>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row">
				<div class="col-10">
					<label for="pwd">Password</label>
					<input type="password" name="pwd"/>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row">
				<div class="col-10 submitButtonColumn">
					<input class="button" type="submit" value="Login"/>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row">
				<c:if test="${loginPageMsg != null}">
						<div class="col-10">
							<span class="messageBox">
								<c:out value="${loginPageMsg}"/>
							</span>
						</div>
						<div class="col-2"></div>
				</c:if>
			</div>
		</form>
		<div class="row"></div>
	</div>
</body>
</html>