<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
		
		<!-- Style tag which will override small, default customizations of style.css -->
		<style type="text/css">
			body {
				background-image: url("../themepark/images/red-bubbles-background.jpg") !important;
				background-repeat: repeat;
			}
		</style>
	</head>
	<body>
		<header>
			<jsp:include page="/WEB-INF/pages/header.jsp"/>
		</header>
		
		<div class="container container-body">
			<jsp:include page="/WEB-INF/pages/${param.content}.jsp"/>
		</div>
	</body>
	<hr>
	<footer>
		<div class="container" style="background-color: #F3F3F3;">
			<jsp:include page="/WEB-INF/pages/footer.jsp"/>
		</div>
	</footer>
</html>