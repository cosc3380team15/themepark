<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col" style="min-width: 780px;">
		<table>
			<tr>
				<th>Department employees</th>
			</tr>
			<c:forEach var="record" items="${departmentEmployees}">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/Portal/ManageEmployees?empid=${record.get('emp_id')}">
							<c:out value="${record.get('full_name')}"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col">
		<div class="panel-white">
			<div class="panel-body">
				<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/ManageDepartments?deptid=${deptId}&prevdeptmgrid=${curDeptMgrId}">
						<div class="row">
							<div class="col">
								<label for="departmentManager">Department manager</label>
								<select name="departmentManager">
									<c:forEach var="emp" items="${departmentEmployees}">
										<c:if test="${emp.get('emp_id') == deptMgrRec.get('emp_id')}">
											<option value="${emp.get('emp_id')}" selected><c:out value="${emp.get('full_name')}"/></option>
										</c:if>
										<c:if test="${emp.get('emp_id') != deptMgrRec.get('emp_id')}">
											<option value="${emp.get('emp_id')}"><c:out value="${emp.get('full_name')}"/></option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="row">
							<div class="col submitButtonColumn">
								<input class="button" type="submit" value="Save"/>
							</div>
						</div>
				</form>
				<c:if test="${viewDepartmentPageMsg != null}">
					<div class="row">
						<div class="col">
							<span class="messageBox">
								<c:out value="${viewDepartmentPageMsg}"/>
							</span>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>