<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="col">
		<span class="medium-heading">Ride Activity | <small>Report</small></span>
	</div>
</div>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/Statistics/Rides">
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
		<table class="clean-look">
			<tr>
				<th></th>
				<c:forEach var="mn" items="${monthList}">
					<th><c:out value="${fn:substring(mn, 0, 3)}"/></th>
				</c:forEach>
			</tr>
			<c:forEach var="ride" items="${ridesList}">
				<tr>
					<td><c:out value="${ride}"/></td>
					<c:forEach var="i" begin="0" end="11">
						<td>
							<c:set var="cellVal" value="-"/>
							<c:forEach var="record" items="${viewRideActivity}">
								<c:if test="${record.get('Month') eq monthList[i] and record.get('Ride') eq ride}">
									<c:set var="cellVal" value="${record.get('Riders')}"/>
								</c:if>
							</c:forEach>
							<c:out value="${cellVal}"/>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col" style="width: 325px;">
		<div class="panel-white">
			<div class="panel-body">
				<span class="small-heading">Year</span>
				<span><c:out value="${filterYear}"/></span>
				<span class="small-heading small-margin-above">Top 3 rides</span>
				<c:forEach var="x" begin="0" end="2">
					<span><c:out value="${not empty viewRideActivityYearly[x].get('Ride') ? viewRideActivityYearly[x].get('Ride') : '-'}"/></span>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

