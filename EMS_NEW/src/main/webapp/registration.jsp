	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registration Page</title>
<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

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
<br>

	<div align="center">
			<h2>Employee Registration</h2>
	<form:form action="registration" method="post" modelAttribute="employee">
	
		<div>
			<form:label path="username">Employee Name:</form:label>
			<form:input path="username" />
			<form:errors path="username" cssClass="error" />
		</div>
		
		<div>
			<form:label path="password">Employee Password:</form:label>
			<form:password path="password"/>
			<form:errors path="password" cssClass="error" />
		</div>
	
		<div>
			<form:label path="email">Employee E-mail:</form:label>
			<form:input type="email" path="email" />
			<form:errors path="email" cssClass="error" />
		</div>
	
		<div>
			<form:label path="active">Employee Active(1/0):</form:label>
			<form:radiobutton path="active" value="true"/>Active
			<form:radiobutton path="active" value="false"/>Non Active
			<form:errors path="active" cssClass="error" />
		</div>
	
		<div>
			<form:label path="department">Select Department:</form:label>	
			 <form:select path="department">
			 <c:forEach items="${departmentList}" var="dep" varStatus="status">
	       		<option value="${dep.deptId}">${dep.deptName}</option>
	    	 </c:forEach>
			 </form:select>
			<form:errors path="department" cssClass="error" />
		</div>
	
		<div>
			<form:label path="roles">Employee Role(ADMIN/USER):</form:label>
			<form:radiobutton path="roles" value="ADMIN"/>ADMIN
			<form:radiobutton path="roles" value="USER"/>USER
			<form:errors path="roles" cssClass="error" />
		</div>
	
		<div>
			<form:label path="age">Employee Age:</form:label>
			<form:input path="age"/>
			<form:errors path="age" cssClass="error" />
		</div>
		
		<div>
			<form:label path="salary">Employee Salary:</form:label>
			<form:input path="salary"/>
			<form:errors path="salary" cssClass="error" />
		</div>
		
		<br>
	
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

<hr>

	<div align="center">
	<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
	</div>
</body>

</html>