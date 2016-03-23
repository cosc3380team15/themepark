<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Welcome to Duff Gardens <small>Where roaming gangs aren't a big problem anymore!</small></h2>
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
				<article>Ride 1</article>
				<article>Ride 2</article>
				<article>Ride 3</article>
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
				<article>Activity 1</article>
				<article>Activity 2</article>
				<article>Activity 3</article>
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
				<article>Restaurant 1</article>
				<article>Restaurant 2</article>
				<article>Restaurant 3</article>
			</div>
		</div>
	</div>
</div>