<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {font-family: Arial, Helvetica, sans-serif;}


input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

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
      <li class="active"><a href="/user/raiseQuery">Raise a Query</a></li>
      <li><a href="/logout" >logout</a></li>
  		<!-- <li><a float="left" href="/logout-success"><button class="btn btn-danger navbar-btn">logout</button></a></li> -->
    </ul>
    
  </div>
</nav>
<hr>

<div align="center">
<h3>Raise Query by filling Form</h3>

<div class="container">
	<form:form action="raiseQuery" method="post" modelAttribute="userQuery">
	
		<div>
			<form:label path="querySubject">Subject:</form:label>
			<form:input path="querySubject" />
			<form:errors path="querySubject" cssClass="error" />
		</div>
		<div>
			<form:label path="comments" >Comments:</form:label>
			<form:textarea path="comments" />
			<form:errors path="comments" cssClass="error" />
		</div>
		<div>
			<div></div>
			<div>
			<form:button class="btn btn-primary">Raise Query</form:button>
			</div>
			<div></div>
		</div>
	</form:form>
 </div>
 
 <div class="container">
	 <h2 align="center">Your Previous Raised Queries:</h2><br>
	<div class="table-responsive">
		<table class="table table-hover">
			<tr>
				<th>QueryId</th>
				<th>Subject</th>
				<th>Comments</th>
				<th>RaisedOn</th>
				<th>Reply</th>
				<th>Status</th>
			</tr>
				<c:forEach var="query" items="${userQueries }">
			<tr>
				<td><c:out value="${query.queryId }"></c:out></td>
				<td><c:out value="${query.querySubject }"></c:out></td>
				<td><c:out value="${query.comments }"></c:out></td>
				<td><c:out value="${query.raisedOn }"></c:out></td>
				<td><c:out value="${query.reply }"></c:out></td>
				<c:choose>
					<c:when test="${query.status eq false }">
						<td><button class="btn btn-warning" ><c:out value="Raised"></c:out></button></td>
					</c:when>
					<c:when test="${query.status eq true }">
						<td><button class="btn btn-success" ><c:out value="Answered"></c:out></button></td>
					</c:when>
				</c:choose>
			</tr>
			 </c:forEach>
		 </table>
	
	 </div>
 </div>
 </div>
<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>
</body>
</html>
