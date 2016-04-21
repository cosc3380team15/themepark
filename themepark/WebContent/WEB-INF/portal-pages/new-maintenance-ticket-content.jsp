<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col">
		<span class="medium-heading">New Maintenance Ticket</span>
	</div>
</div>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/NewMaintenanceTicket">
	<div class="row">
		<div class="col">
			<label for="maintenanceType">Maintenance type</label>
			<select name="maintenanceType">
				<c:forEach var="recMT" items="${maintenanceTypes}">
					<option value="${recMT.get('ride_maintenance_type_id')}">
						<c:out value="${recMT.get('type')}"/>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="ride">Ride</label>
			<select name="ride">
				<c:forEach var="record" items="${rides}">
					<option value="${record.get('ride_id')}">
						<c:out value="${record.get('name')}"/>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="problem">Problem description</label>
			<textarea class="larger-box" name="problem" maxlength="1000" required></textarea>
		</div>
		<div class="col">
			<label for="resolution">Resolution description</label>
			<textarea class="larger-box" name="resolution" maxlength="1000"></textarea>
		</div>
	</div>
	
	<div class="row">
		<div class="col submitButtonColumn">
			<input class="button" type="submit" value="Create Ticket"/>
		</div>
	</div>
</form>

<c:if test="${not empty newMaintTicketMsg}">
	<div class="row">
		<div class="col messageBox">
			<c:out value="${newMaintTicketMsg}"/>
		</div>
	</div>
</c:if>