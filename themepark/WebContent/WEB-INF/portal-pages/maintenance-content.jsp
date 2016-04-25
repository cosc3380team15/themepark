<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col">
		<span class="medium-heading">Ride/Attraction Breakdown and Maintenance | <small>Report</small></span>
	</div>
</div>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/Statistics/Maintenance">
	<div class="row">
		<div class="col">
			<select name="selFilterYear">
				<c:forEach var="filt" items="${dropDownYears}">
					<c:if test="${filterYear == filt}">
						<option value="${filt}" selected><c:out value="${filt}"/></option>
					</c:if>
					<c:if test="${filterYear != filt}">
						<option value="${filt}"><c:out value="${filt}"/></option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="col">
			<input class="button" type="submit" value="Apply Filter"/>
		</div>
	</div>
</form>

<div class="row">
	<div class="col" style="width: 800px;">
		<table>
			<tr>
				<th>Year</th>
				<th>Month</th>
				<th>Maintenance</th>
				<th>Breakdowns</th>
				<th>Total</th>
			</tr>
			<c:forEach var="record" items="${viewMaintTicketStats}">
				<c:if test="${record.get('Year') == filterYear}">
					<tr>
						<td><c:out value="${record.get('Year')}"/></td>
						<td><c:out value="${record.get('Month')}"/></td>
						<td><c:out value="${record.get('Maintenance')}"/></td>
						<td><c:out value="${record.get('Breakdowns')}"/></td>
						<td><c:out value="${record.get('Total')}"/></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<div class="col" style="width: 325px;">
		<div class="panel-white">
			<div class="panel-body">
				<span class="small-heading">Year</span>
				<span><c:out value="${filterYear}"/></span>
				<span class="small-heading small-margin-above">Average maintenance per month</span>
				<span><c:out value="${avgMaintTicketVals.get('Average Maintenance')}"/></span>
				<span class="small-heading small-margin-above">Average breakdowns per month</span>
				<span><c:out value="${avgMaintTicketVals.get('Average Breakdowns')}"/></span>
				<span class="small-heading small-margin-above">Worst in maintenance</span>
				<span><c:out value="${worstMinorRide}"/></span>
				<span class="small-heading small-margin-above">Worst in breakdowns</span>
				<span><c:out value="${worstMajorRide}"/></span>
			</div>
		</div>
	</div>
</div>