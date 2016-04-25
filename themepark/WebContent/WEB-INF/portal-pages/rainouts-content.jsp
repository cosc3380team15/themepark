<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="col">
		<span class="large-heading">Rainouts | <small>Report</small></span>
	</div>
</div>

<div class="row">
<div class="col" style="width: 800px;">
<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/Statistics/Rainouts">
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
</div>
<div class="col" style="width: 325px;">
		<div class="panel-white">
			<div class="panel-heading">Quick Stats<hr style="width: 95%;"></div>
			<div class="panel-body">
				<span class="small-heading">Year</span>
				<span><c:out value="${filterYear}"/></span>
				<span class="small-heading small-margin-above">Highest cause for closures</span>
				<span><c:out value="${viewRideClosuresYearlyStats.get(0).get('Weather Condition')}"></c:out></span>
				<span class="small-heading small-margin-above">Top 3 ride closures</span>
				<c:forEach var="x" begin="0" end="2">
					<span><c:out value="${not empty viewRideClosuresPerRide[x].get('Ride') ? viewRideClosuresPerRide[x].get('Ride') : '-'}"/></span>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col" style="width: 98%;">
		<table class="clean-look">
			<tr>
				<th></th>
				<c:forEach var="mn" items="${monthList}">
					<th><c:out value="${fn:substring(mn, 0, 3)}"/></th>
				</c:forEach>
			</tr>
			<c:forEach var="weather" items="${weatherConditions}">
				<tr>
					<td><c:out value="${weather}"/></td>
					<c:forEach var="i" begin="0" end="11">
						<td>
							<c:set var="cellVal" value="-"/>
							<c:forEach var="record" items="${viewRideClosures}">
								<c:if test="${record.get('Month') eq monthList[i] and record.get('Weather Condition') eq weather}">
									<c:set var="cellVal" value="${record.get('Closures')}"/>
								</c:if>
							</c:forEach>
							<c:out value="${cellVal}"/>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
