<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	</head>
	<body>
		<header>
			<jsp:include page="/WEB-INF/portal-pages/header.jsp"/>
		</header>
		
		<div class="container container-body">
			<jsp:include page="/WEB-INF/portal-pages/${param.content}.jsp"/>
		</div>
	</body>
	<hr>
	<footer>
		<div class="container">
			<jsp:include page="/WEB-INF/portal-pages/footer.jsp"/>
		</div>
	</footer>
</html>