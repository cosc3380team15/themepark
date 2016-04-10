<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Welcome to Duff Gardens</h2>
<h3> <small>Where roaming gangs aren't a big problem anymore!</small></h3>
<br />
<br />
<br />
<div class="row">
	<div class="col-sm-4">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="well well-sm text-center"><b>RIDES</b></div>
				<img class="img-responsive" src="${pageContext.request.contextPath}/images/rides.png">
			</div>
			<div class="panel-body">
				<article><a href="/themepark/RiverRide.jsp" class="left"><font color="blue"> River Ride</font></a></article>
	<article><a href="/themepark/FerrisWheelRide.jsp" class="left"><font color="blue"> Ferris Wheel</font></a></article>
<article><a href="/themepark/RollerCoasterRide.jsp" class="left"><font color="blue"> Roller Coaster</font></a></article>
			</div>
		</div>
	</div>
	<div class="col-sm-4">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="well well-sm text-center"><b>THINGS TO DO</b></div>
				<img class="img-responsive" src="${pageContext.request.contextPath}/images/things-to-do.png">
			</div>
			<div class="panel-body">
				<article><a href="/themepark/ParadeAttraction.jsp" class="left"><font color="blue"> Float Parade</font></a></article>
				<article><a href="/themepark/ShamuAttraction.jsp" class="left"><font color="blue"> Fish Show</font></a></article>
				<article><a href="/themepark/BellyDancingAttraction.jsp" class="left"><font color="blue"> Belly Dancing</font></a></article>
				
			</div>
		</div>
	</div>
	<div class="col-sm-4">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="well well-sm text-center"><b>FOOD & DRINK</b></div>
				<img class="img-responsive" src="${pageContext.request.contextPath}/images/food-and-drink.png">
			</div>
			<div class="panel-body">
				<article><a href="/themepark/BeerGarden.jsp" class="left"><font color="blue"> Duff Beer Garden</font></a></article>
				<article><a href="/themepark/Sushi.jsp" class="left"><font color="blue"> Sushi</font></a></article>
				<article><a href="/themepark/WineBar.jsp" class="left"><font color="blue"> Wine Bar</font></a></article>
							</div>
		</div>
	</div>
</div>
