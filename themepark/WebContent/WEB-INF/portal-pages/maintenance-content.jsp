<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Average Ride/Attraction Breakdown and Maintenance</h3>
<table class="clean-look">
	<tr>
		<th>Month</th>
		<th>Breakdown/Maintenance Count</th>
	</tr>
	<c:forEach var="maintenance" items="${avgMaintenance}">
		<tr>
			<td>
				<c:out value="${maintenance.get('Month')}"/>
			</td>
			<td>
				<c:out value="${maintenance.get('Average_Maintenance_Count')}"/>
			</td>
		</tr>
	</c:forEach>
</table>

<%-- <table class="clean-look">
	<tr>
		<th>Creation Timestamp</th>
		<th>Severity</th>
		<th>Issue</th>
		<th>Maintenance Task</th>
		<th>Completion Timestamp</th>
	</tr>
	<c:forEach var="maintenance" items="${maintenance}">
		<tr>
			<td>
				<c:out value="${maintenance.get('creation_timestamp')}"/>
			</td>
			<td>
				<c:out value="${maintenance.get('type')}"/>
			</td>
			<td>
				<c:out value="${maintenance.get('problem_description')}"/>
			</td>
			<td>
				<c:out value="${maintenance.get('resolution_description')}"/>
			</td>
			<td>
				<c:out value="${maintenance.get('completion_timestamp')}"/>
			</td>
		</tr>
	</c:forEach>
</table> --%>