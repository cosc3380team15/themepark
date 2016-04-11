<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty historyResults}">
	<table>
		<tr>
			<th>Purchase Date</th>
			<th>Ticket Type</th>
			<th>Ticket Quantity</th>
			<th>Total Price</th>
		</tr>
		<c:forEach var="record" items="${historyResults}">
			<tr>
				<td>
					<c:out value="${record.get('purchase_date')}"/>
				</td>
				<td>
					<c:out value="${record.get('type')}"/>
				</td>
				<td>
					<c:out value="${record.get('tickets_purchased')}"/>
				</td>
				<td>
					<c:out value="${record.get('order_total_price')}"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${empty historyResults}">
	<div class="row">
		<div class="col-4">
			<c:out value="${purchaseHistoryMsg}"/>
		</div>
		<div class="col-8"></div>
	</div>
	<div class="row"></div>
</c:if>