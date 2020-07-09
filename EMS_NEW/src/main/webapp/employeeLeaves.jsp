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
      <li ><a href="/user/home">Home</a></li>
      <li class="active"><a href="/user/leaves">All Leaves</a></li>
      <li><a href="/logout">logout</a></li>
  		<!-- <li><a float="left" href="/logout-success"><button class="btn btn-danger navbar-btn">logout</button></a></li> -->
    </ul>
  </div>
</nav>

 <div class="container">
	 <h2 align="center">Your Leaves:</h2><br>
	<div class="table-responsive">
		<table class="table table-hover">
			<tr>
				<th>LeaveID</th>
				<th>Subject</th>
				<th>Message</th>
				<th>From</th>
				<th>To</th>
				<th>Status</th>
			</tr>
				<c:forEach var="leave" items="${leaves }">
			<tr>
				<td><c:out value="${leave.leaveId }"></c:out></td>
				<td><c:out value="${leave.leaveSubject }"></c:out></td>
				<td><c:out value="${leave.leaveMessage }"></c:out></td>
				<td><c:out value="${leave.leaveFrom }"></c:out></td>
				<td><c:out value="${leave.leaveTo }"></c:out></td>
				<c:choose>
					<c:when test="${leave.status eq 0 }">
						<td><button class="btn btn-warning" ><c:out value="Pending"></c:out></button></td>
					</c:when>
					<c:when test="${leave.status eq 1 }">
						<td><button class="btn btn-success" ><c:out value="Approved"></c:out></button></td>
					</c:when>
					<c:when test="${leave.status eq 2}">
						<td><button class="btn btn-danger" ><c:out value="Rejected"></c:out></button></td>
					</c:when>
				</c:choose>
			<%-- <td><c:out value="${leave.status }"></c:out></td> --%>
			</tr>
			 </c:forEach>
		 </table>
		 <button onclick="location.href='applyLeaves'">Apply for leave</button>
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
<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>
</body>
</html>