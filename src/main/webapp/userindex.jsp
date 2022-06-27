<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>ABC Company-Home Page</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-info border-bottom box-shadow mb-3">
		<div class="container">
			<a class="navbar-brand text-light">ABC Company</a>
			<div class="navbar-collapse collapse d-sm-inline-flex ">
				<ul class="navbar-nav flex-grow-1">
					<li class="nav-item"><a class="nav-link text-white"
						href="userindex.jsp">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div
		style="background-color: #00D1D1; width: 100%; padding-left: 100px; padding-right: 100px; padding-top: 30px; padding-bottom: 30px">
		<h3 style="color:white">Welcome To ABC Company!</h3>
	</div>
	<div class="container p-2">
		<div class="container">
			<div class="row">
				<div class="col justify-content-center p-5">
					<a href="user_registration.jsp"
						class="btn btn-outline-info btn-lg btn-block" role="button">Register</a>
				</div>
			</div>
			<div class="row">
				<div class="col justify-content-center p-5">
					<a href="user_login.jsp"
						class="btn btn-outline-info btn-lg btn-block" role="button">Login</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>