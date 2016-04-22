<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col">
		<span class="medium-heading">Maintenance Ticket Details | <small><c:out value="${ticketRecord.get('ID')}"/></small></span>
	</div>
</div>

<table class="invisible-table">
	<tr>
		<td>
			<span class="small-heading">Created</span>
			<span><c:out value="${ticketRecord.get('Created')}"/></span>
		</td>
		<td>
			<span class="small-heading">Completed</span>
			<span><c:out value="${not empty ticketRecord.get('Completed') ? ticketRecord.get('Completed'):'-'}"/></span>
		</td>
		<td>
			<span class="small-heading">Status</span>
			<span><c:out value="${ticketRecord.get('Status')}"/></span>
		</td>
	</tr>
	<tr>
		<td>
			<span class="small-heading">Type</span>
			<span><c:out value="${ticketRecord.get('Type')}"/></span>
		</td>
		<td>
			<span class="small-heading">Ride</span>
			<span><c:out value="${ticketRecord.get('Ride')}"/></span>
		</td>
		<td>
			<span class="small-heading">Created By</span>
			<span><c:out value="${ticketRecord.get('Created By')}"/></span>
		</td>
	</tr>
</table>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/ManageMaintenanceTickets?update=1&ticketId=${ticketRecord.get('ID')}">
	<div class="row">
		<div class="col">
			<label for="problem">Problem description</label>
			<textarea class="larger-box" name="problem" readonly><c:out value="${ticketRecord.get('Problem')}"/></textarea>
		</div>
		<div class="col">
			<label for="resolution">Resolution description</label>
			<c:if test="${ticketRecord.get('Status') == 'Open'}">
				<textarea class="larger-box" name="resolution" maxlength="1000" required></textarea>
			</c:if>
			<c:if test="${ticketRecord.get('Status') == 'Closed'}">
				<textarea class="larger-box" name="resolution" read-only><c:out value="${ticketRecord.get('Resolution')}"/></textarea>
			</c:if>
		</div>
	</div>
	
	<div class="row">
		<div class="col submitButtonColumn">
			<c:if test="${ticketRecord.get('Status') == 'Open'}">
				<input class="button" type="submit" value="Save"/>
			</c:if>
			<c:if test="${ticketRecord.get('Status') == 'Closed'}">
				<input class="button" type="submit" value="Save" disabled/>
			</c:if>
		</div>
	</div>
</form>

<c:if test="${not empty viewMaintTicketPageMsg}">
	<div class="row">
		<div class="col">
			<span class="messageBox">
				<c:out value="${viewMaintTicketPageMsg}"/>
			</span>
		</div>
	</div>
</c:if>