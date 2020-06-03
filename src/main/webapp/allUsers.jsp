<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
</head>
<body>

	<form action="userController" method="get">
		<table border="3">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Login</th>
				<th>Password</th>
			</tr>


			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.userid}</td>
					<td>${u.name}</td>
					<td>${u.login}</td>
					<td>${u.pass}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>