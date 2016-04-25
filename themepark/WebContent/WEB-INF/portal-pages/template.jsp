<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/Favicon.ico"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	</head>
	<body class="wavy-red-background">
		<header>
			<jsp:include page="/WEB-INF/portal-pages/header.jsp"/>
		</header>
		
		<div class="container container-body yellow-background">
			<jsp:include page="/WEB-INF/portal-pages/${param.content}.jsp"/>
		</div>
		<hr>
		<footer>
			<div class="container">
				<jsp:include page="/WEB-INF/portal-pages/footer.jsp"/>
			</div>
		</footer>
	</body>
</html>