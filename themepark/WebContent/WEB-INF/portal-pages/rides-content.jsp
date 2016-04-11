<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Ride Statistics</title>
</head>
<body>
<h2>Ride log for the past 30 days</h2>
<table class="clean-look">
	<tr >
		<th>Date</th>
		<th>Ride Name</th>
		<th>Ride Count</th>
	</tr>
    <c:forEach items="${rides}" var="ride">
        <tr>
        	<td><c:out value="${ride.date}">Null</c:out></td>
            <td><c:out value="${ride.rideName}">Null</c:out></td>
            <td><c:out value="${ride.rideCount}">Null</c:out></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>