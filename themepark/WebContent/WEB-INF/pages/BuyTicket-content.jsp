<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col">
		<span class="large-heading">Purchase Duff Gardens Tickets</span>
	</div>
</div>

<form class="clean-look" method="POST" action="BuyTicket">
	<div class="row">
		<div class="col">
			<label for="first">First name</label>
			<input type="text" name="first" required/>
		</div>
		<div class="col">
			<label for="last">Last name</label>
			<input type="text" name="last" required/>
		</div>
	</div>

	<div class="row">
		<div class="col">
			<label for="email">Email address</label>
			<input type="text" name="email" required/>
		</div>
		<div class="col">
			<label for="phone">Phone number</label>
			<input type="text" name="phone" required pattern="\d{3}[\-]\d{3}[\-]\d{4}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="ticketTypeId">Ticket type:</label>
			<select name="ticketTypeId" required>
				<c:forEach var="record" items="${ticketPriceInfo}">
					<option value="${record.get('ticket_price_id')}">
						<c:out value="${record.get('type')}"/>
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="col">
			<label for="ticketCount">How many?</label>
			<select name="ticketCount" required>
				<option value="1" selected>1</option>
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
	</div>
	
	<div class="row">
		<div class="col submitButtonColumn">
			<input class="button" type="submit" value="Submit"/>
		</div>
	</div>
	
	<c:if test="${buyTicketMsg != null}">
		<div class="row">
			<div class="col">
				<span class="messageBox">
					<c:out value="${buyTicketMsg}"/>
				</span>
			</div>
		</div>
	</c:if>
</form>

<div class="row">
	<hr>
</div>

<div class="row">
	<div class="col">
		<span class="large-heading">Check Purchase History</span>
	</div>
</div>

<form class="clean-look" method="POST" action="OnlinePurchaseHistory">
	<div class="row">
		<div class="col">
			<label for="phEmail">Email address</label>
			<input type="text" name="phEmail"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<label for="phLast">Phone number</label>
			<input type="text" name="phPhone" required pattern="\d{3}[\-]\d{3}[\-]\d{4}"/>
		</div>
	</div>
	
	<div class="row">
		<div class="col submitButtonColumn">
			<input class="button" type="submit" value="Submit"/>
		</div>
	</div>
</form>

