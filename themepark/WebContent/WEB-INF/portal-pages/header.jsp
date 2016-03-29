<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<c:forEach var="item" items="${navItems}">
		<li><c:out value="${item}"/></li>
	</c:forEach>
</ul>