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
	<header>
		<jsp:include page="/WEB-INF/pages/header.jsp"/>
	</header>
	<body class="wavy-red-background">
		<div class="container container-body yellow-background">
			<jsp:include page="/WEB-INF/pages/${param.content}.jsp"/>
		</div>
	</body>
	<footer class="red-background">
		<hr>
		<div class="container yellow-background" style="border: 2px solid #000;">
			<jsp:include page="/WEB-INF/pages/footer.jsp"/>
		</div>
	</footer>
</html>