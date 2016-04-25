<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/Vendors/ManageVendors">
	<div class="row">
		<div class="col">
			<select name="concessionFilter">
				<c:forEach var="type" items="${vendType}">
					<c:if test="${concessTypeFilter == type}">
						<option value="${type}" selected><c:out value="${type}"/></option>
					</c:if>
					<c:if test="${concessTypeFilter != type}">
						<option value="${type}"><c:out value="${type}"/></option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="col">
			<input class="button" type="submit" value="Apply Filter"/>
		</div>
	</div>
</form>

<table>
	<tr>
		<th>Vendor</th>
		<th>Type</th>
		<th>Description</th>
		<th>Contract Start</th>
		<th>Contract End</th>
	</tr>
	<c:forEach var="vendor" items="${vendFilter}">
		<tr>
			<td>
				<c:out value="${vendor.get('name')}"/>
			</td>
			<td>
				<c:out value="${vendor.get('type')}"/>
			</td>
			<td>
				<c:out value="${vendor.get('description')}"/>
			</td>
			<td>
				<c:out value="${vendor.get('contract_start_date')}"/>
			</td>
			<td>
				<c:out value="${vendor.get('contract_end_date')}"/>
			</td>
		</tr>
	</c:forEach>
</table>