<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>AdminEditPage</title>
</head>
<body>
<div align="center">
	<header style="background-color: #666;  padding: 30px;  text-align: center;  font-size: 35px;  color: white;">
	Employee Management System</header>
</div>
<br>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Employee Management System</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/admin/home">Home</a></li>
      <li><a href="/logout">logout</a></li>  
    </ul>
  </div>
</nav>

<div  align="center">
<h1 align="center">Edit User:</h1>
<br>
<hr>
<br>
<form action="/admin/edit" method="post">
<c:forEach var="Employee" items="${empList}">

<table border="2px" cellspacing="5px" cellpadding="3px" width="500px" >
<tr>
		<th><label>Employee ID: </label></th>
		<td><input type="text" name="id" value="${Employee.id }" readonly="readonly"></td>
	</tr>
	
	<tr>
		<th><label>Employee Name: </label></th>
		<td><input type="text" name="username" value="${Employee.username }" readonly="readonly" ></td>
	</tr>
	
	<tr>
		<th><label>Employee IsActive:</label></th>
		<td><input type="text" name="active" value="${Employee.active }"> </td>
	</tr>
	
	<tr>
		<th><label>Employee Roles:</label></th>
		<td><input type="text" name="roles" value="${Employee.roles }"></td>
	</tr>
	<tr>
		<th><label>Employee Roles:</label></th>
		<td><input type="text" name="age" value="${Employee.age }"></td>
	</tr>
	<tr>
		<th><label>Employee Roles:</label></th>
		<td><input type="text" name="email" value="${Employee.email }"></td>
	</tr>
	<tr>
		<th><label>Employee Roles:</label></th>
		<td><input type="text" name="salary" value="${Employee.salary }"></td>
	</tr>
	<tr>
		<th><label>Employee Department:</label></th>
		<td><input type="text" name="department" value="${Employee.department }"></td>
	</tr>
<tr>
	<td></td>
	<td><input type="hidden" name="password" value="${Employee.password }"></td></tr>
<tr>
	<th></th>
	<td><button type="submit" class="btn btn-default">Submit</button></td>
</tr>
</table>
</c:forEach>
</form>
</div>
<br>
<br>
<br>
<br>

<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>

</body>
</html>