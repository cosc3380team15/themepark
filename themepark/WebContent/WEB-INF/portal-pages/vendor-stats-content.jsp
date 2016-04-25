<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="col">
		<span class="large-heading">Vendor | <small>Report</small></span>
	</div>
</div>

<div class="row">
<div class="col" style="width: 800px;">
<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/Statistics/VendorStats">
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
				<span class="small-heading small-margin-above">Highest revenue vendor</span>
				<span><c:out value="${highestRevVendor}"></c:out></span>
				<span class="small-heading small-margin-above">Lowest revenue vendor</span>
				<span><c:out value="${lowestRevVendor}"></c:out></span>
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
			<c:forEach var="vendor" items="${vendors}">
				<tr>
					<td><c:out value="${vendor}"/></td>
					<c:forEach var="i" begin="0" end="11">
						<td>
							<c:set var="cellVal" value="-"/>
							<c:forEach var="record" items="${viewVendorRevenueMonthly}">
								<c:if test="${record.get('Month') eq monthList[i] and record.get('Name') eq vendor}">
									<c:set var="cellVal" value="${record.get('Total Revenue')}"/>
								</c:if>
							</c:forEach>
							$<c:out value="${cellVal}"/>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>