<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Reserve Duff Gardens Tickets</h2>
<br />
<body align="center">
<div class="panel panel-default">
			<div class="panel-body">
			<div class="col-sm-4">
	<div id="login-box">
		<form method="POST" action="Login">
			<div class="container-60">
				<div class="row">
					<div class="col-12">
						<label for="user"> First Name</label>
						<input type="text" name="first"/>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-12">
						<label for="user"> Last Name</label>
						<input type="text" name="last"/>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-12">
						<label for="user"> Email Address</label>
						<input type="text" name="email"/>
					</div>
				</div>
				<br/>
				<b>Number of Tickets</b>
				<br/>
				
				 one-day: <select name="oneday">
				 <option value="0">0</option>
    			 <option value="1">1</option>
			    <option value="2">2</option>
			    <option value="3">3</option>
			    <option value="4">4</option>
			    <option value="5">5</option>
			    <option value="6">6</option>
			    <option value="7">7</option>
			    <option value="8">8</option>
			    <option value="9">9</option>
			    <option value="10">10</option>
  </select>
  <!-- 
  seasonal: <select name="seasonal">
  <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
  </select>
  -->
			<br/>	
			
<!-- Date not needed?
			<!-- THIS IS AN ERROR  -/->
			<label>Date: (Does not seem to showing up properly? TO FIX)</label>
			<input name="date" type="date"/>
-->
			
				<br/>
				<div class="row">
					<div class="col-12 submitButtonColumn">
						<input class="button" type="submit" value="Submit"/>
					</div>
				</div>
				
				
				
			</div>
		</form>
		</div>
		</div>
		</div>
		
		
		<!-- comment out, is originally from the portal-pages/login.jsp folder, this might be able to be changed to fit our servelett
		<c:if test="${loginPageMsg != null}">
			<div class="row">
				<div class="col-12">
					<span class="messageBox">
						<c:out value="${loginPageMsg}"/>
					</span>
				</div>
			</div>
		</c:if>
		-->
		
	</div>
	
	<hr>
	
	<!-- Check If you Already have Tickets -->
	
	<h2>Check Existing Reservation</h2>
	<br />
<body align="center">
<div class="panel panel-default">
			<div class="panel-body">
			<div class="col-sm-4">
	<div id="login-box">
		<form method="POST" action="Login">
			<div class="container-60">
				<div class="row">
					<div class="col-12">
						<label for="user"> First Name</label>
						<input type="text" name="user"/>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-12">
						<label for="user"> Last Name</label>
						<input type="text" name="user"/>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-12">
						<label for="user"> Email Address</label>
						<input type="text" name="pwd"/>
					</div>
				</div>
				
				<!-- DO NOT NEED?
				<br/>
				<b>Number of Tickets</b>
				<br/>
				
				 <select name="one-day">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
  </select>

			<br/>
			
			<!-- THIS IS AN ERROR  -/->
			<label>Date: (Does not seem to showing up properly? TO FIX)</label>
			<input name="datetime" type="datetime-local"/>
-->
			
				<br/>
				<div class="row">
					<div class="col-12 submitButtonColumn">
						<input class="button" type="submit" value="Submit"/>
					</div>
				</div>
				
				
				
			</div>
		</form>
		</div>
		</div>
		</div>