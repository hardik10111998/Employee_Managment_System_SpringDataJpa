	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->
   
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</head>
<body>
<div align="center">
	<header style="background-color: #666;  padding: 30px;  text-align: center;  font-size: 35px;  color: white;">
	Employee Management System</header>
</div>
<br>
<hr>
<div align="center">
<h1>Please Login First </h1>
</div>

<div align="center">
	<div >
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message != null}">
		<p style="color:red">${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
		</c:if>
	</div>
 <form action="login" method="post">
 <table border="1px">
 <tr>
 <th><label>User Name</label></th>
 <td><input type="text" class="form-control" placeholder="Employee Name" name="username"></td>
 </tr>
 <tr>
 <th><label>Password</label></th>
 <td><input type="password" class="form-control" placeholder="Password" name="password"></td>
 </tr>
  <tr>
  <td>
  </td>
  <td><button type="submit" class="btn btn-info">Login</button></td>
  </tr> 
 </table>
 </form>
 <br>
 <br>

 New Employee? <button  class="btn btn-primary" onclick="location.href='/registration'">Register</button>
</div>

<br><br><br><br><hr><br>
<div align="center">
<footer style="background-color: #777;padding: 10px;  text-align: center;  color: white;">Devloped BY @Hardik</footer>
</div>
</body>
</html>