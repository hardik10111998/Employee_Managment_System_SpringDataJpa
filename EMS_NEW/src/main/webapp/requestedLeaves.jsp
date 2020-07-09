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
      <li ><a href="/admin/home">Home</a></li>
      <li><a href="/admin/payroll">Generate Salaries For All</a></li> 
      <li class="active"><a href="/admin/allLeaveRequest">Show All LeaveRequest</a></li> 
      <li><a href="/logout">logout</a></li>  
    </ul>
  </div>
</nav>
<div class="container">
 <h2 alihn="center">Leaves:</h2><br>
<div class="table-responsive">
<table class="table table-hover">
<tr>
<th>LeaveId</th>
<th>LeaveSubject</th>
<th>LeaveMessage</th>
<th>LeaveFrom</th>
<th>LeaveTo</th>
<th>Employee ID</th>
<th>Employee Name</th>
<th colspan="2">Actions</th>
</tr>
<c:forEach var="leave" items="${leaves }">
<tr>
<td><c:out value="${leave.leaveId }"></c:out></td>
<td><c:out value="${leave.leaveSubject }"></c:out></td>
<td><c:out value="${leave.leaveMessage }"></c:out></td>
<td><c:out value="${leave.leaveFrom }"></c:out></td>
<td><c:out value="${leave.leaveTo }"></c:out></td>
<td><c:out value="${leave.employee.id }"></c:out></td>
<td><c:out value="${leave.employee.username }"></c:out></td>
<td><button type="button" class="btn btn-success" onclick="location.href='grantLeave?leaveId=${leave.leaveId}'">Approve</button>
<td><button type="button" class="btn btn-danger" onclick="location.href='rejectLeave?leaveId=${leave.leaveId}'">Reject</button>
</tr>
</c:forEach>
</table>
</div>
</div>


<br>
<br>
<br>
<br>

<br>
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