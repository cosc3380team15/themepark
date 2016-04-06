<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<p>user: <c:out value="${sessionScope.user}"/></p>
<p>department: <c:out value="${sessionScope.dept}"/></p>
<p>contextpath: ${pageContext.request.contextPath}</p>
<nav>
	<ul id="drop-nav">
		<c:forEach var="parent" items="${sessionScope.navItems}">
			<li>
				<a href="${parent.sectionLink}"><c:out value="${parent.sectionName}"/></a>
				<ul>
					<c:forEach var="child" items="${parent.links}">
						<li><a href="${pageContext.request.contextPath}${child.link}"><c:out value="${child.name}"/></a></li>
					</c:forEach>
				</ul>
			</li>
		</c:forEach>
	</ul>
</nav>