<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="clean-look">
	<tr>
		<th>Date</th>
		<th>Attendance Count</th>
	</tr>
	<c:forEach var="count" items="${attendance}">
		<tr>
			<td>
				<c:out value="${count.get('Purchase_Date')}"/>
			</td>
			<td>
				<c:out value="${count.get('Attendance_Count')}"/>
			</td>
		</tr>
	</c:forEach>
</table>