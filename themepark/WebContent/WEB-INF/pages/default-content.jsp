<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Welcome to Duff Gardens</h2>
<h3><small>Where roaming gangs aren't a big problem anymore!</small></h3>
<br />
<div class="row">
	<div class="col-4" style="text-align: center">
		<h4>RIDES</h4>
		<hr style="color: red;"/>
		<img class="panel-img-300" src="${pageContext.request.contextPath}/images/rides.png">
		<hr style="color: red;"/>
		<ul style="list-style: none;">
			<li><a href="/themepark/RiverRide.jsp">River Ride</a></li>
			<li><a href="/themepark/FerrisWheelRide.jsp">Ferris Wheel</a></li>
			<li><a href="/themepark/RollerCoasterRide.jsp">Roller Coaster</a></li>
		</ul>
	</div>
	<div class="col-4" style="text-align: center">
		<h4>THINGS TO DO</h4>
		<hr style="color: red;"/>
		<img class="panel-img-300" src="${pageContext.request.contextPath}/images/things-to-do.png">
		<hr style="color: red;"/>
		<ul style="list-style: none;">
			<li><a href="/themepark/ParadeAttraction.jsp">Float Parade</a></li>
			<li><a href="/themepark/ShamuAttraction.jsp">Fish Show</a></li>
			<li><a href="/themepark/BellyDancingAttraction.jsp">Belly Dancing</a></li>
		</ul>
	</div>
	<div class="col-4" style="text-align: center">
		<h4>FOOD & DRINK</h4>
		<hr style="color: red;"/>
		<img class="panel-img-300" src="${pageContext.request.contextPath}/images/food-and-drink.png">
		<hr style="color: red;"/>
		<ul style="list-style: none;">
			<li><a href="/themepark/BeerGarden.jsp">Duff Beer Garden</a></li>
			<li><a href="/themepark/Sushi.jsp">Sushi</a></li>
			<li><a href="/themepark/WineBar.jsp">Wine Bar</a></li>
		</ul>
	</div>
</div>
