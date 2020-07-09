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
      <p class="navbar-brand" >Welcome ${pageContext.request.userPrincipal.name}<p>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/user/home">Home</a></li>
      <li ><a href="/user/applyLeaves">Apply For Leaves</a></li>
      <li ><a href="/user/leaves">Check Leave Status</a></li>
      <li ><a href="/user/raiseQuery">Raise a Query</a></li>
       <li><a href="/logout" >logout</a></li>
      <!-- <li><a href="/logout-success" >logout</a></li> -->
  		<!-- <li><a float="left" href="/logout-success"><button class="btn btn-danger navbar-btn">logout</button></a></li> -->
    </ul>
    
  </div>
</nav>
 <div class="container">
 <h2 align="center">Your Profile</h2><br>
<div class="table-responsive">
<table class="table table-hover">
<tr>
	<th>Employee ID</th>
	<th>Employee Name</th>
	<th>Employee Password</th>
	<th>Employee IsActive</th>
	<th>Employee Roles</th>
	<th>Employee Age</th>
	<th>Employee Email</th>
	<th>Employee Salary</th>
	<th>WorkingDaysOf ThisMonth</th>
	<th>Employee Department</th>
	<th colspan="2">Actions</th>
</tr>
<c:forEach var="Employee" items="${userList}">
<tr>
	<td><c:out value="${Employee.id}"></c:out></td>
	<td><c:out value="${Employee.username}"></c:out></td>
	<td><c:out value="${Employee.password}"></c:out></td>
	<td><c:out value="${Employee.active}"></c:out></td>
	<td><c:out value="${Employee.roles}"></c:out></td>
	<td><c:out value="${Employee.age}"></c:out></td>
	<td><c:out value="${Employee.email}"></c:out></td>
	<td><c:out value="${Employee.salary}"></c:out></td>
	<td><c:out value="${Employee.workingDaysOfThisMonth}"></c:out></td>
	<td><c:out value="${Employee.department.deptName}"></c:out></td>
	<td><a href="/user/edit?userId=${Employee.id }"  class="btn btn-info" role="button">Edit</a>
	<td><a href="/user/delete/${Employee.id }" class="btn btn-danger" role="button">Delete</a>
</tr>
</c:forEach>
</table>
</div>
</div>

<hr>
<div align="center">
	<form action="/user/attendance">
		<label for="appt">Choose a time for your In and Out:</label>
		<br>
		<small>Office hours are 9am to 6pm</small>
		<br><br>	
		In Time :<input type="time" id="appt" name="inTime" min="09:00" max="18:00" required>
		<br><br>
		Out Time :<input type="time" id="appt" name="outTime" min="09:00" max="18:00" required>	
		<br><br>
		<input type="submit" value="Submit Timeting Details" /> 
	
	</form>
</div>
<hr>

<br>

<br>
<br>
<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>

</body>
</html>