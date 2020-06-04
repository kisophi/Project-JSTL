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
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" autofocus="autofocus" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Log in"/></td>
				<td></td>
			</tr>
		</table>
	</form>

</body>
</html>