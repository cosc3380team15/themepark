<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row col-cnt-1">
	<div class="col">
		<span class="large-heading">Welcome to Duff Gardens</span>
		<span class="small-heading">Where roaming gangs aren't a big problem anymore!</span>
	</div>
</div>

<div class="row center-text large-margin-above">
	<div class="col panel-white">
		<div class="panel-heading">RIDES</div>
		<div class="panel-body">
			<span><img class="medium-pic" src="${pageContext.request.contextPath}/images/rides.png"></span>
			<ul class="blank-style">
				<li><a href="/themepark/RiverRide.jsp">River Ride</a></li>
				<li><a href="/themepark/FerrisWheelRide.jsp">Ferris Wheel</a></li>
				<li><a href="/themepark/RollerCoasterRide.jsp">Roller Coaster</a></li>
			</ul>
		</div>
	</div>
	<div class="col panel-white">
		<div class="panel-heading">THINGS TO DO</div>
		<div class="panel-body">
			<span><img class ="medium-pic" src="${pageContext.request.contextPath}/images/things-to-do.png"></span>
			<ul class="blank-style">
				<li><a href="/themepark/ParadeAttraction.jsp">Float Parade</a></li>
				<li><a href="/themepark/ShamuAttraction.jsp">Fish Show</a></li>
				<li><a href="/themepark/BellyDancingAttraction.jsp">Belly Dancing</a></li>
			</ul>
		</div>
	</div>
	<div class="col panel-white">
		<span class="panel-heading">FOOD & DRINK</span>
		<div class="panel-body">
			<span><img class="medium-pic" src="${pageContext.request.contextPath}/images/food-and-drink.png"></span>
			<ul class="blank-style">
				<li><a href="/themepark/BeerGarden.jsp">Duff Beer Garden</a></li>
				<li><a href="/themepark/Sushi.jsp">Sushi</a></li>
				<li><a href="/themepark/WineBar.jsp">Wine Bar</a></li>
			</ul>
		</div>
	</div>
</div>

