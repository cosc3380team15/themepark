<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-8">
		<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/ManageEmployees?empid=${empRecord.get('emp_id')}">
			<div class="row">
				<div class="col-9">
					<h1>Employee Details</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="firstName">First name</label>
					<input type="text" name="firstName" required value="${empRecord.get('first_name')}"/>
				</div>
				<div class="col-4">
					<label for="lastName">Last name</label>
					<input type="text" name="lastName" required value="${empRecord.get('last_name')}"/>
				</div>
				<div class="col-4">
					<label for="department">Department</label>
					<select name="department">
						<c:forEach var="dept" items="${deptNamesList}">
							<c:if test="${dept == empRecord.get('dept_name')}">
								<option value="${dept}" selected><c:out value="${dept}"/></option>
							</c:if>
							<c:if test="${dept != empRecord.get('dept_name')}">
								<option value="${dept}"><c:out value="${dept}"/></option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="address">Address</label>
					<input type="text" name="address" required value="${empRecord.get('street_address')}"/>
				</div>
				<div class="col-4">
					<label for="phoneNumber">Phone number</label>
					<input type="tel" name="phoneNumber" required pattern="\d{3}[\-]\d{3}[\-]\d{4}" value="${empRecPhoneFormatted}"/>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="city">City</label>
					<input type="text" name="city" value="${empRecord.get('city')}"/>
				</div>
				<div class="col-4">
					<label for="state">State</label>
					<input type="text" name="state" required pattern="\b([A-Z]{2})\b" value="${empRecord.get('state')}"/>
				</div>
				<div class="col-4">
					<label for="zip">Zip code</label>
					<input type="text" name="zip" required pattern="(\d{5}([\-]\d{4})?)" value="${empRecord.get('zip')}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="dobMonth">Date of birth</label>
					<select name="dobMonth">
						<c:forEach var="month" items="${monthList}">
							<c:if test="${month == empRecDobMonth}">
								<option value="${month}" selected><c:out value="${month}"/></option>
							</c:if>
							<c:if test="${month != empRecDobMonth}">
								<option value="${month}"><c:out value="${month}"/></option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				<div class="col-4">
					<label for="dobDay">Day</label>
					<input type="text" name="dobDay" value="${empRecDobDay}"/>
				</div>
				<div class="col-4">
					<label for="dobYear">Year</label>
					<input type="text" name="dobYear" value="${empRecDobYear}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-4 submitButtonColumn">
					<input class="button" type="submit" value="Save"/>
				</div>
				<div class="col-8"></div>
			</div>
		</form>
	</div>
	<div class="col-4">
		<div class=" row">
			<div class="col-10 white-panel-look">
				<article class="small-title">Manager</article>
				<span><c:out value="${not empty empRecord.get('manager') ? empRecord.get('manager'):'-'}"/></span>
				<article class="small-title">Hire date</article>
				<span><c:out value="${empRecord.get('hire_date')}"/></span>
				<article class="small-title">Termination date</article>
				<span><c:out value="${not empty empRecord.get('termination_date') ? empRecord.get('termination_date'):'-'}"/></span>
			</div>
			<div class="col-2"></div>
		</div>
		<div class="clearing-row"></div>
	</div>
</div>
<div class="row">
	<c:if test="${not empty viewEmployeePageMsg}">
		<div class="col-12">
			<span class="messageBox">
				<c:out value="${viewEmployeePageMsg}"/>
			</span>
		</div>
	</c:if>
</div>