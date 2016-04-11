<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Welcome to Duff Gardens</h2>
<h3><small>Where roaming gangs aren't a big problem anymore!</small></h3>

<div class="col-4">
	<article class="small-title center-text">RIDES</article>
	<img class="responsive-300" src="${pageContext.request.contextPath}/images/rides.png">
	<ul class="blank-style">
		<li><a href="/themepark/RiverRide.jsp">River Ride</a></li>
		<li><a href="/themepark/FerrisWheelRide.jsp">Ferris Wheel</a></li>
		<li><a href="/themepark/RollerCoasterRide.jsp">Roller Coaster</a></li>
	</ul>
</div>
<div class="col-4">
	<article class="small-title center-text">THINGS TO DO</article>
	<img class="responsive-300" src="${pageContext.request.contextPath}/images/things-to-do.png">
	<ul class="blank-style">
		<li><a href="/themepark/ParadeAttraction.jsp">Float Parade</a></li>
		<li><a href="/themepark/ShamuAttraction.jsp">Fish Show</a></li>
		<li><a href="/themepark/BellyDancingAttraction.jsp">Belly Dancing</a></li>
	</ul>
</div>
<div class="col-4">
	<article class="small-title center-text">FOOD & DRINK</article>
	<img class="responsive-300" src="${pageContext.request.contextPath}/images/food-and-drink.png">
	<ul class="blank-style">
		<li><a href="/themepark/BeerGarden.jsp">Duff Beer Garden</a></li>
		<li><a href="/themepark/Sushi.jsp">Sushi</a></li>
		<li><a href="/themepark/WineBar.jsp">Wine Bar</a></li>
	</ul>
</div>

<div class="clearing-row"></div>
