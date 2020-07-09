<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
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
      <a class="navbar-brand" href="#">Welcome ${pageContext.request.userPrincipal.name}</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/user/home">Home</a></li>
      <li><a href="/logout">logout</a></li>  
    </ul>
  </div>
  </nav>
  
	<div align="center">
	<h2 align="center">Edit Your Details </h2>
	<br>
	<hr>
	<br>
	<form action="/user/edit" method="post">
	<table border="2px" cellspacing="5px" cellpadding="3px" width="500px" >
	<tr>
		<th><label>Employee ID: </label></th>
		<td><input type="text" name="id" value="${userDetail.id }" readonly="readonly"></td>
	</tr>
	
	<tr>
		<th><label>Employee Name: </label></th>
		<td><input type="text" name="username" value="${userDetail.username }" readonly="readonly" ></td>
	</tr>
	
	<tr>
		<th><label>Employee Password:</label></th>
		<td><input type="text" name="password" value="${userDetail.password }"></td>
	</tr>
	
	<tr>
		<th><label>Employee IsActive:</label></th>
		<td><input type="text" name="active" value="${userDetail.active }"> </td>
	</tr>
	
	<tr>
		<th><label>Employee Roles:</label></th>
		<td><input type="text" name="roles" value="${userDetail.roles }" readonly="readonly" ></td>
	</tr>
	<tr>
		<th><label>Employee Age:</label></th>
		<td><input type="text" name="age" value="${userDetail.age }"></td>
	</tr>
	<tr>
		<th><label>Employee Email:</label></th>
		<td><input type="text" name="email" value="${userDetail.email }"></td>
	</tr>
	<tr>
		<th><label>Employee Salary:</label></th>
		<td><input type="text" name="salary" value="${userDetail.salary }"></td>
	</tr>
	<tr>
		<th><label>WorkingDays Of ThisMonth:</label></th>
		<td><input type="text" name="workingDaysOfThisMonth" value="${userDetail.workingDaysOfThisMonth }"></td>
	</tr>
	<tr>
		<th></th>
		<td><input type="submit" class="btn btn-primary" value="submit"></td>
	</tr>
	
	</table>	
	</form>
	  
	</div>
  <br>

<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>
  
</body>
</html>