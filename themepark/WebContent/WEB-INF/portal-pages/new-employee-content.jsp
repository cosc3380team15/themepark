<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="POST" action="${pageContext.request.contextPath}/Portal/HumanResources/NewEmployee">
	<div class="row">
		<div class="col-12">
			<h1>New Employee Form</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-5">
			<label for="firstName">First name</label>
			<input type="text" name="firstName"/>
		</div>
		<div class="col-5">
			<label for="lastName">Last name</label>
			<input type="text" name="lastName"/>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<input type="submit" value="Submit"/>
		</div>
	</div>
</form>