<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ONLY ALLOW CONTENT PAST THIS POINT IF A VALID SESSION EXISTS -->
<c:if test="${sessionScope.user == null}">
	<c:redirect url="/Login"/>
</c:if>

<jsp:include page="/WEB-INF/portal-pages/template.jsp">
	<jsp:param name="content" value="view-employee-content"/>
	<jsp:param name="title" value="Duff Gardens Employee Portal - View Employee"/>
</jsp:include>