<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ONLY ALLOW CONTENT PAST THIS POINT IF A VALID SESSION EXISTS -->
<c:if test="${sessionScope.user == null}">
	<jsp:forward page="/Login">
		<jsp:param name="loginErrorMsg" value="${sessionScope.loginErrorMessage}"/>
	</jsp:forward>
</c:if>

<jsp:include page="/WEB-INF/portal-pages/template.jsp">
	<jsp:param name="content" value="default-content"/>
	<jsp:param name="title" value="Duff Gardens Employee Portal"/>
</jsp:include>