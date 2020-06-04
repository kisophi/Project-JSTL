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
	

	<table title="New User">
	  	<tr>
	    	<td><a href="userController?action=addUser">New User</a> </td>
	  	</tr>
	</table>
	
	<form action="userController" method="get">
		<table title="Find Users by Name">
		  	<tr>
		    	<td><input type="text" name="name"/></td>
		    	<td><input type="submit" name="action" value="findByName"/></td>
		  	</tr>
		</table>
	</form>


	<form action="userController" method="get" title="List of Users">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Login</th>
				<th>Password</th>
				<td></td>
				<td></td>
			</tr>

			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.userid}</td>
					<td>${u.name}</td>
					<td>${u.login}</td>
					<td>${u.pass}</td>
					<td><a href="userController?action=deleteUser&userid=${u.userid}" onclick="return confirm('Are you sure you want to delete?');">Delete</a></td>
					<td><a href="userController?action=updateUser&userid=${u.userid}">Update</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<table>
			<tr>
				<td>Name : </td>
				<th>${userSessionLogin.name}</th>
			</tr>
		</table>

	</form>
</body>
</html>