<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reign in wild: authorization</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/script.js"></script>

</head>

<c:url value="/login" var="login" />
<form action="${pageContext.request.contextPath}/login" method="post">


	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<table>
		<tr>
			<td width="50%">Username</td>
			<td width="50%"><input id="j_username" name="username"
				placeholder="Username" size="20" maxlength="30" type="text" /></td>
		</tr>

		<tr>
			<td width="50%">Password</td>
			<td width="50%"><input id="j_password" name="password"
				placeholder="Password" size="20" maxlength="30" type="password" />
			</td>
		</tr>
	</table>

	<input type="submit" value="Submit">
</form>

<body>

</body>
</html>