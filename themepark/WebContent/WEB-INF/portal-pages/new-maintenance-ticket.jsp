<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ONLY ALLOW CONTENT PAST THIS POINT IF A VALID SESSION EXISTS -->
<c:if test="${sessionScope.user == null}">
	<c:redirect url="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/Login"/>
</c:if>

<jsp:include page="/WEB-INF/portal-pages/template.jsp">
	<jsp:param name="content" value="new-maintenance-ticket-content"/>
	<jsp:param name="title" value="Duff Gardens Employee Portal - New Maintenance Ticket"/>
</jsp:include>