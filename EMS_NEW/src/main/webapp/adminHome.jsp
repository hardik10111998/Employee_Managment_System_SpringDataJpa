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

<nav class="navbar navbar-default ">
  <div class="container-fluid">
    <div class="navbar-header">
      <p class="navbar-brand" >Welcome ${pageContext.request.userPrincipal.name}<p>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/admin/home">Home</a></li>
      <li><a href="/admin/payroll">Generate Salaries For All</a></li> 
      <li><a href="/admin/allLeaveRequest">Show All LeaveRequest</a></li> 
      <li><a href="/admin/allUserQueries">Show All queries</a></li> 
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
         <button type="submit" class="btn btn-info">
      		<span class="glyphicon glyphicon-search"></span> Search
    	</button>
    </form>
   </div>
  <hr>
  
  
  <div align="center">
  <h5>Dynamic Search</h5>
  	<form  action="/admin/employees">
  	<table class="table table-hover">
	<tr>
	    <td>From Date  [yyyy/MM/dd]<input type="text" name="fromDate" /></td>
	    <td>To Date  [yyyy/MM/dd]<input type="text" name="toDate" /> </td>
	    <td>Name<input type="text" name="name" /> </td>
    </tr>
    <tr>
	    <td>Page<input type="text" name="page" /> </td>
	    <td>PageSize<input type="text" name="size" /></td>
	    <td><input type="submit" value="Search between Date and Name" /></td>
     </tr>
     </table>
    </form>
   </div>
   
  <hr>
  <br>
  <h3>All Employee Details :</h3><br>
    <p>Type something in the input field to search the table for All Fields:</p>  
  <input class="form-control" id="myInput" type="text" placeholder="Search..">
  
  <hr>
  <br>
<div  align="center" class="table-responsive" border="1px">
<table class="table table-hover">
<thead>
<tr>
	<th>Employee ID</th>
	<th><a href="sortBy?property=username">Employee Username</a></th>
	<th><a href="sortBy?property=active">Employee IsActive</a></th>
	<th ><a href="sortBy?property=roles">Employee Roles</a></th>
	<th ><a href="sortBy?property=age">Employee Age</a></th>
	<th ><a href="sortBy?property=email">Employee Email</a></th>
	<th ><a href="sortBy?property=salary">Employee Salary</a></th>
	<th ><a href="sortBy?property=department">Employee department</a></th>
	<th ><a href="sortBy?property=dateOfJoining">Employee DateOfJoining</a></th>
	<th colspan="2">Action</th>
</tr>
</thead>
<tbody  id="myTable">
<c:forEach var="Employee" items="${empList}">
<tr>
<td><c:out value="${Employee.id}"></c:out></td>
<td><c:out value="${Employee.username}"></c:out></td>
<td><c:out value="${Employee.active}"></c:out></td>
<td><c:out value="${Employee.roles}"></c:out></td>
<td><c:out value="${Employee.age}"></c:out></td>
<td><c:out value="${Employee.email}"></c:out></td>
<td><c:out value="${Employee.salary}"></c:out></td>
<td><c:out value="${Employee.department}"></c:out></td>
<td><c:out value="${Employee.dateOfJoining}"></c:out></td>
<td><a href="/admin/edit?empId=${Employee.id }"  class="btn btn-info" role="button">Edit</a>
<td><a href="/admin/delete/${Employee.id }" class="btn btn-danger" role="button">Delete</a>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
<br>

<hr>
 
  <div align="center">
  	<%	
	 	int pages=(int)request.getAttribute("totalRecords")/4; 
	 	for(int i=0;i<=pages;i++){
 		%>
		<a href="/admin/home?page=<%=i%>"><%=i+1 %></a>
		<%} %> 
	<br>
	<br>
  	<form  action="/admin/home">  
  		
   		Go To Page<input type="text" name="page" />&nbsp;
	    <!-- <td>No. Of Record To display<input type="text" name="size" /></td> -->
	   <input type="submit" value="Get Page Record" />   
    </form>
    		
	
    </div>
 	
   
  <hr>

<br>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

<br>
<hr>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>
</body>
</html>