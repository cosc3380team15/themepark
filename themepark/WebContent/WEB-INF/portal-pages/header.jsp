<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="red-background" style="width: 100%;">
	<div class="container">
		<div class="row">
			<div class="left-float">
				<img class="img-responsive" src="${pageContext.request.contextPath}/images/duff-gardens-logo-emp.png">
			</div>
			<div class="right-float">
				<c:out value="${sessionScope.user}"/> | <a class="employee-portal" href="${pageContext.request.contextPath}/Portal/ChangePassword">Change Password</a> | <a class="employee-portal" href="${pageContext.request.contextPath}/Logout">Logout</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>

<nav>
	<div class="nav-wrapper">
		<ul id="drop-nav">
			<c:forEach var="section" items="${sessionScope.navMenu.sections}">
				<li>
					<a href="${not empty section.titleLink ? section.titleLink:'#'}"><c:out value="${section.title}"/></a>
					<ul>
						<c:forEach var="sectionLink" items="${section.links}">
							<li><a href="${pageContext.request.contextPath}${sectionLink.link}"><c:out value="${sectionLink.name}"/></a></li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
</nav>