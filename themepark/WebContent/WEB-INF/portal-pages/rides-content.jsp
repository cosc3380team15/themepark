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
<%@ page import="java.util.*"%>
<%@ page import="models.Ride"%>
<table>
	<tr>
		<td>Activity ID</td>
		<td>Ride Name</td>
		<td>Ride ID</td>
		<td>Date</td>
		<td>Ride Count</td>
	</tr>
<% List<Ride> ride = (List<Ride>)request.getAttribute("rides");%>

    <c:forEach items="${rides}" var="ride">
        <tr>
            <td><c:out value="${ride.activityID}">Null</c:out></td>
            <td><c:out value="${ride.rideName}">Null</c:out></td>
            <td><c:out value="${ride.rideID}">Null</c:out></td>
            <td><c:out value="${ride.date}">Null</c:out></td>
            <td><c:out value="${ride.rideCount}">Null</c:out></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>