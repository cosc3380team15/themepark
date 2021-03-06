<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>Department</th>
		<th>Employees</th>
		<th>Manager</th>
	</tr>
	<c:forEach var="record" items="${departmentsInfo}">
		<tr>
			<td>
				<a href="${pageContext.request.contextPath}/Portal/ManageDepartments?deptid=${record.get('dept_id')}">
					<c:out value="${record.get('dept_name')}"/>
				</a>
			</td>
			<td>
				<c:out value="${record.get('num_emps')}"/>
			</td>
			<td>
				<c:set var="outputMgr" value="-"/>
				<c:forEach var="mngr" items="${managers}">
					<c:if test="${mngr.get('DeptName') eq record.get('dept_name')}">
						<c:set var="outputMgr" value="${mngr.get('manager')}"/>
					</c:if>
				</c:forEach>
				<c:out value="${outputMgr}"/>
			</td>
		</tr>
	</c:forEach>
</table>