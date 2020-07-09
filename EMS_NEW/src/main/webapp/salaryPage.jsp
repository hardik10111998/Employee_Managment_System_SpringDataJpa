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
</head>
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
      <li class="active"><a href="/admin/home">Home</a></li>
      <!-- <li><a href="/payroll">Generate Salaries For All</a></li> --> 
      <li><a href="/logout">logout</a></li>  
    </ul>
  </div>
</nav>
  
  <div class="container">
  <h2 align="center">Admin Page</h2><br>
  <hr>
  <div align="center">
  	<form  action="/admin/search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
   </div>
  
  <br>
  <h3>All Employee Details With This Month salary To Pay:</h3><br>
<div  align="center" class="table-responsive" border="1px">
<table class="table table-hover">
<tr>
	<th>Employee ID</th>
	<th>Employee Name</th>
	<th>Employee Email</th>
	<th>Employee Department</th>
	<th>Employee Salary Per Month</th>
	<th>Employee WorkingDaysOfThisMonth</th>
	<th>Total  Salary For this Month</th>
	<th>Action</th>
</tr>
<c:forEach var="Employee" items="${empList}">
<tr>
<td><c:out value="${Employee.id}"></c:out></td>
<td><c:out value="${Employee.username}"></c:out></td>
<td><c:out value="${Employee.email}"></c:out></td>
<td><c:out value="${Employee.department}"></c:out></td>
<td><c:out value="${Employee.salary}"></c:out></td>
<td><c:out value="${Employee.workingDaysOfThisMonth}"></c:out></td>
<td><c:out value="${(Employee.salary/30)*Employee.workingDaysOfThisMonth}"></c:out></td>
<td><a href="/admin/sendMoney?empId=${Employee.id}&salary=${(Employee.salary/30)*Employee.workingDaysOfThisMonth}" class="btn btn-info" role="button">Transfer Amount</a>

</tr>
</c:forEach>
</table>
</div>
</div>
<br>



<br>
<br>
<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>
</body>
</html>