<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col">
		<span class="medium-heading">New Employee Form</span>
	</div>
</div>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/NewEmployee">
	<div class="row">
		<div class="col">
			<label for="firstName">First name</label>
			<input type="text" name="firstName" required/>
		</div>
		<div class="col">
			<label for="lastName">Last name</label>
			<input type="text" name="lastName" required/>
		</div>
		<div class="col">
			<label for="department">Department</label>
			<select name="department">
				<c:forEach var="dept" items="${departmentNamesList}">
					<option value="${dept}"><c:out value="${dept}"/></option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="address">Address</label>
			<input type="text" name="address" required/>
		</div>
		<div class="col">
			<label for="phoneNumber">Phone number</label>
			<input type="tel" name="phoneNumber" placeholder="ex: 595-555-5555" required pattern="\d{3}[\-]\d{3}[\-]\d{4}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="city">City</label>
			<input type="text" name="city" required/>
		</div>
		<div class="col">
			<label for="state">State</label>
			<input type="text" name="state" placeholder="ex: TX" required pattern="\b([A-Z]{2})\b"/>
		</div>
		<div class="col">
			<label for="zip">Zip code</label>
			<input type="text" name="zip" required pattern="(\d{5}([\-]\d{4})?)"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="dobMonth">Date of birth</label>
			<select name="dobMonth">
				<option value="1">January</option>
				<option value="2">February</option>
				<option value="3">March</option>
				<option value="4">April</option>
				<option value="5">May</option>
				<option value="6">June</option>
				<option value="7">July</option>
				<option value="8">August</option>
				<option value="9">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December</option>
			</select>
		</div>
		<div class="col">
			<label for="dobDay">Day</label>
			<input type="text" name="dobDay" placeholder="ex: 7" required/>
		</div>
		<div class="col">
			<label for="dobYear">Year</label>
			<input type="text" name="dobYear" placeholder="ex: 1995" required/>
		</div>
	</div>
	
	<div class="row">
		<div class="col submitButtonColumn">
			<input class="button" type="submit" value="Submit"/>
		</div>
	</div>
</form>
<c:if test="${newEmployeePageMsg != null}">
	<div class="row">
		<div class="col">
			<span class="messageBox">
				<c:out value="${newEmployeePageMsg}"/>
			</span>
		</div>
	</div>
</c:if>