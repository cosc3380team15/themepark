<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-12">
		<h2>Purchase Duff Gardens Tickets</h2>
		<form class="clean-look" method="POST" action="BuyTicket">
			<div class="row">
				<div class="col-4">
					<label for="first">First name</label>
					<input type="text" name="first"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="last">Last name</label>
					<input type="text" name="last"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="email">Email address</label>
					<input type="text" name="email"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4">
					one-day tickets:
					<select name="oneday">
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
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4 submitButtonColumn">
					<input class="button" type="submit" value="Submit"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-12">
					<hr>
				</div>
			</div>
		</form>
	</div>
</div>

<div class="row">
	<div class="col-12">
		<h2>Check Existing Reservation</h2>
		<form class="clean-look" method="POST" action="PurchaseHistory"> <!-- edit this later -->
			<div class="col-4">
				<label for="phFirst">First Name</label>
				<input type="text" name="phFirst"/>
			</div>
			<div class="col-8"></div>
			<div class="clearing-row"></div>
			<div class="col-4">
				<label for="phLast">Last Name</label>
				<input type="text" name="phLast"/>
			</div>
			<div class="col-8"></div>
			<div class="clearing-row"></div>
			<div class="col-4">
				<label for="phEmail">Email Address</label>
				<input type="text" name="phEmail"/>
			</div>
			<div class="col-8"></div>
			<div class="clearing-row"></div>
			<div class="col-4 submitButtonColumn">
				<input class="button" type="submit" value="Submit"/>
			</div>
			<div class="col-8"></div>
			<div class="clearing-row"></div>
		</form>
	</div>
</div>
<div class="row">
	<c:if test="${buyTicketMsg != null}">
		<div class="col-12">
			<span class="messageBox">
				<c:out value="${buyTicketMsg}"/>
			</span>
		</div>
	</c:if>
</div>
