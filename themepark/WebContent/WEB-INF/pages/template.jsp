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
			a.employee-portal { 
				color: #FFF !important;
			}
			a.employee-portal:hover { color: #FACE21 !important; }
		</style>
	</head>
	<body>
		<jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>
		
		<div class="container-80" style="background-color: #F3F3F3; min-height: 500px;">
			<jsp:include page="/WEB-INF/pages/${param.content}.jsp"></jsp:include>
		</div>
	</body>
	<hr>
	<footer>
		<div class="container-80" style="background-color: #F3F3F3;">
			<jsp:include page="/WEB-INF/pages/footer.jsp"></jsp:include>
		</div>
	</footer>
</html>