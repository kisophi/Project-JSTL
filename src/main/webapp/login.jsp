<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="loginController" method="post">
		<table title="Form Login and Password">
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" autofocus="autofocus" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Log in" /></td>
				<td></td>
			</tr>
		</table>

	</form>
	
		<table title="invalid login msg">
			<tr>
				<td> 
					<c:if test="${not empty invalidLogin}">
						<c:out value="${invalidLogin}"/>
					</c:if> 
				</td>
			</tr>
		</table>
</body>
</html>