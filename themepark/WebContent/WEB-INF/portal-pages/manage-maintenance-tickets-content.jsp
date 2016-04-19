<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/ManageMaintenanceTickets">
	<div class="row">
		<div class="col">
			<select name="filterTickets">
				<c:forEach var="filt" items="${filterChoices}">
					<c:if test="${selectedFilter == filt}">
						<option value="${filt}" selected><c:out value="${filt}"/></option>
					</c:if>
					<c:if test="${selectedFilter != filt}">
						<option value="${filt}"><c:out value="${filt}"/></option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="col">
			<input class="button" type="submit" value="Apply"/>
		</div>
	</div>
</form>

<table class="small-margin-above">
	<tr>
		<th>ID</th>
		<th>Created</th>
		<th>Completed</th>
		<th>Status</th>
		<th>Type</th>
		<th>Ride</th>
		<th>Problem</th>
		<th>Resolution</th>
		<th>Created By</th>
	</tr>
	<c:forEach var="record" items="${maintenanceTickets}">
		<tr>
			<td>
				<c:out value="${record.get('ID')}"/>
			</td>
			<td>
				<c:out value="${record.get('Created')}"/>
			</td>
			<td>
				<c:out value="${record.get('Completed')}"/>
			</td>
			<td>
				<c:out value="${record.get('Status')}"/>
			</td>
			<td>
				<c:out value="${record.get('Type')}"/>
			</td>
			<td>
				<c:out value="${record.get('Ride')}"/>
			</td>
			<td>
				<c:set var="problemStr" value="${record.get('Problem')}"/>
				<c:out value="${fn:length(problemStr) >= 25 ? fn:substring(problemStr, 0, 21) += '...' : problemStr}"/>
			</td>
			<td>
				<c:set var="resolutionStr" value="${record.get('Resolution')}"/>
				<c:out value="${fn:length(resolutionStr) >= 25 ? fn:substring(resolutionStr, 0, 21) += '...' : resolutionStr}"/>
			</td>
			<td>
				<c:out value="${record.get('Created By')}"/>
			</td>
		</tr>
	</c:forEach>
</table>