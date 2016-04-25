<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row">
	<div class="col">
		<span class="medium-heading">Change Password</span>
	</div>
</div>

<form class="clean-look" method="POST" action="${pageContext.request.contextPath}/Portal/ChangePassword">
	<div class="row">
		<div class="col">
			<label for="currentPw">Current password</label>
			<input type="password" name="currentPw" required/>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<label for="newPw">New password</label>
			<input type="password" name="newPw" required/>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<label for="newPwConfirm">New password (confirm)</label>
			<input type="password" name="newPwConfirm" required/>
		</div>
	</div>
	
	<div class="row">
		<div class="col submitButtonColumn">
			<input class="button" type="submit" value="Submit"/>
		</div>
	</div>
</form>
<c:if test="${changePwMsg != null}">
	<div class="row">
		<div class="col">
			<span class="messageBox">
				<c:out value="${changePwMsg}"/>
			</span>
		</div>
	</div>
</c:if>