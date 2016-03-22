<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${param.title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
	<jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/pages/${param.content}.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/pages/footer.jsp"></jsp:include>
</body>
</html>