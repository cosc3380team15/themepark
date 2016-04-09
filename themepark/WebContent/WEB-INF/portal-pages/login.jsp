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
			<div class="container-60">
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
				<div class="row">
					<div class="col-12">
						<input class="button" type="submit" value="Login"/>
					</div>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-12">
				<c:if test="${sessionScope.loginPageMsg != null}">
					<c:out value="${sessionScope.loginPageMsg}"/>
				</c:if>
				<c:if test="${sessionScope.loginPageMsg == null}">
					<c:out value=""/>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>