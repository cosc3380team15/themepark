<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.title}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
		
		<!-- Style tag which will override small, default customizations of bootstrap.css -->
		<style type="text/css">
			body { background-color: #CC1517; }
			ul li a { color: #7D6710 !important; }
			ul li a:hover {
				color: #FFF !important;
				background-color: #7D6710 !important;			
			}
			nav { background-color: #FACE21 !important;	}
			a.employee-portal { color: #FFF !important; }
			a.employee-portal:hover { color: #FACE21 !important; }
		</style>
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