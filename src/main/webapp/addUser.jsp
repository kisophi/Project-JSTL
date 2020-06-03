<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>

		<form action="userController" method="post">
		<table>
			<tr>
				<th>ID</th>
				<th><input type="text" name="userid" value="0" disabled="disabled"/></th>
			</tr>
			<tr>
				<th>Name</th>
				<th><input type="text" name="name" /></th>
			</tr>
			<tr>
				<th>Login</th>
				<th><input type="text" name="login" /></th>
			</tr>
			<tr>
				<th>Pass</th>
				<th><input type="text" name="pass" /></th>
			</tr>
			<tr>
				<th><input type="submit" name="" value="Salvar" /></th>
				<td></td>
			</tr>
		</table>
	</form>

</body>
</html>