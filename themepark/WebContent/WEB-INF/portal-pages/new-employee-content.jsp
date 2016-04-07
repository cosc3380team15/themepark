<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="POST" action="${pageContext.request.contextPath}/Portal/HumanResources/NewEmployee">
	<div class="row">
		<div class="col-9">
			<h1>New Employee Form</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-3">
			<label for="firstName">First name</label>
			<input type="text" name="firstName"/>
		</div>
		<div class="col-3">
			<label for="lastName">Last name</label>
			<input type="text" name="lastName"/>
		</div>
		<div class="col-3">
			<label for="department">Department</label>
			<select name="department">
				<c:forEach var="dept" items="${sessionScope.departmentNamesList}">
					<option val="${dept}"><c:out value="${dept}"/></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="row">
		<div class="col-3">
			<label for="address">Address</label>
			<input type="text" name="address"/>
		</div>
		<div class="col-3">
			<label for="phoneNumber">Phone number</label>
			<input type="text" name="phoneNumber"/>
		</div>
	</div>
	<div class="row">
		<div class="col-3">
			<label for="city">City</label>
			<input type="text" name="city"/>
		</div>
		<div class="col-3">
			<label for="state">State</label>
			<input type="text" name="state"/>
		</div>
		<div class="col-3">
			<label for="zip">Zip code</label>
			<input type="text" name="zip"/>
		</div>
	</div>
	<div class="row">
		<div class="col-3">
			<label for="dobMonth">DOB</label>
			<select name="dobMonth">
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>
			</select>
		</div>
		<div class="col-3">
			<label for="dobDay">Day</label>
			<input type="text" name="dobDay"/>
		</div>
		<div class="col-3">
			<label for="dobYear">Year</label>
			<input type="text" name="dobYear"/>
		</div>
	</div>
	<div class="row">
		<div class="col-9">
			<input class="button" type="submit" value="Submit"/>
		</div>
	</div>
</form>