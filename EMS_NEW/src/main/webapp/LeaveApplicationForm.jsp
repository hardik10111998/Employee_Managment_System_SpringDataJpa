	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>LeaveApplicationForm</title>

<style type="text/css">
	
	button {
		padding: 10px;
	}
	.error {
		color: red;
		font-style: italic;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 5px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 5px;
	}

	form div div {
		display: table-cell;
	}	
</style>


</head>
<body>

<div align="center">
<header style="background-color: #666;  padding: 30px;  text-align: center;  font-size: 35px;  color: white;">
Employee Management System</header>
</div>

<hr>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <p class="navbar-brand" >Welcome ${pageContext.request.userPrincipal.name}<p>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="/user/home">Home</a></li>
      <li class="active"><a href="/user/leaves">show All Leaves</a></li>
      <li><a href="/logout">logout</a></li>
  		<!-- <li><a float="left" href="/logout-success"><button class="btn btn-danger navbar-btn">logout</button></a></li> -->
    </ul>
  </div>
</nav>

  <div class="container" align="center">
	  <h2 align="center">Apply for Leave:</h2>
	  <hr>	 
	 	<c:if test="${message != null }">
	  	<div class="alert alert-danger alert-dismissible fade in">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		    <strong><c:out value=" ${message} "></c:out>!</strong>
  		</div> 	
  		</c:if>  	  
	  <hr>
	  
	<form:form action="applyLeaves" method="post" modelAttribute="leave">
	
		<div>
			<form:label path="leaveSubject">Subject:</form:label>
			<form:input path="leaveSubject" />
			<form:errors path="leaveSubject" cssClass="error" />
		</div>
		
		<div>
			<form:label path="leaveMessage">Reason:</form:label>
			<form:input path="leaveMessage" />
			<form:errors path="leaveMessage" cssClass="error" />
		</div>
		
		<div>
			<form:label path="leaveFrom">From Date:</form:label>
			<form:input type="date" path="leaveFrom"/>
			<form:errors path="leaveFrom" cssClass="error" />
		</div>
		
		<div>
			<form:label path="leaveTo">To Date:</form:label>
			<form:input type="date" path="leaveTo"/>
			<form:errors path="leaveTo" cssClass="error" />
		</div>
		
		<div>
			<div></div>
			<div>
			<form:button class="btn btn-primary">Register</form:button>
			</div>
			<div></div>
		</div>
	</form:form>
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