<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>First name</th>
		<th>Last name</th>
		<th>Department</th>
		<th>Hire date</th>
		<th>Termination date</th>
		<th>Details</th>
	</tr>
	<c:forEach var="record" items="${employeeInfoList}">
		<tr>
			<td>
				<c:out value="${record.get('first_name')}"/>
			</td>
			<td>
				<c:out value="${record.get('last_name')}"/>
			</td>
			<td>
				<c:out value="${record.get('dept_name')}"/>
			</td>
			<td>
				<c:out value="${record.get('hire_date')}"/>
			</td>
			<td>
				<c:out value="${record.get('termination_date')}"/>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/Portal/ManageEmployees?empid=${record.get('emp_id')}">View</a>
			</td>
		</tr>
	</c:forEach>
</table>