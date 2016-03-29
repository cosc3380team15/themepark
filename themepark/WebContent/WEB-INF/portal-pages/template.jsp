<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/portal-pages/header.jsp"></jsp:include>
		
		<div class="container" style="background-color: #F3F3F3; min-height: 500px;">
			<jsp:include page="/WEB-INF/portal-pages/${param.content}.jsp"></jsp:include>
		</div>
		<hr>
		<div class="container" style="background-color: #F3F3F3;">
			<jsp:include page="/WEB-INF/portal-pages/footer.jsp"></jsp:include>
		</div>
	</body>
</html>