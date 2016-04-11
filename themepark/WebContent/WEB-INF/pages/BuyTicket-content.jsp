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
					<input type="text" name="first" required/>
				</div>
				<div class="col-4">
					<label for="last">Last name</label>
					<input type="text" name="last" required/>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="email">Email address</label>
					<input type="text" name="email" required/>
				</div>
				<div class="col-4">
					<label for="phone">Phone number</label>
					<input type="text" name="phone" required pattern="\d{3}[\-]\d{3}[\-]\d{4}"/>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row">
				<div class="col-4">
					<select name="ticketTypeId" required>
						<c:forEach var="record" items="${ticketPriceInfo}">
							<option value="${record[0]}">
								<c:out value="${record[1]}"/>
							</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4">
					How many?
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
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4 submitButtonColumn">
					<input class="button" type="submit" value="Submit"/>
				</div>
				<div class="col-8"></div>
			</div>
			<c:if test="${buyTicketMsg != null}">
				<div class="row">
					<div class="col-4">
						<span class="messageBox">
							<c:out value="${buyTicketMsg}"/>
						</span>
					</div>
					<div class="col-4"></div>
					<div class="col-4"></div>
				</div>
			</c:if>
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
		<h2>Check Purchase History</h2>
		<form class="clean-look" method="POST" action="OnlinePurchaseHistory">
			<div class="row">
				<div class="col-4">
					<label for="phEmail">Email address</label>
					<input type="text" name="phEmail"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4">
					<label for="phLast">Phone number</label>
					<input type="text" name="phPhone" required pattern="\d{3}[\-]\d{3}[\-]\d{4}"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row">
				<div class="col-4 submitButtonColumn">
					<input class="button" type="submit" value="Submit"/>
				</div>
				<div class="col-8"></div>
			</div>
			<div class="row"></div>
		</form>
	</div>
</div>
<div class="row"></div>
