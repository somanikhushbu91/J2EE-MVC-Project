<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<% String table = (String) request.getAttribute("table"); %>
<title>Admin Reports</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-info border-bottom box-shadow mb-3">
		<div class="container">
			<a class="navbar-brand text-white">ABC Company</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target=".navbar-collapse"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-collapse collapse d-sm-inline-flex ">
				<ul class="navbar-nav flex-grow-1">
					<li class="nav-item"><a class="nav-link text-white"
						href="AdminHomeController">Home</a></li>
				</ul>
				<ul class="navbar-nav flex-grow-1">
					<li class="nav-item"><a class="nav-link text-white"
						href="adminindex.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container p-2">
		<div class="row">
			<div class="col">
				<h4>
					Report
				</h4>
			</div>
			
		</div>
		
		<div class="row">
			<%= table %>
		</div>
	
	</div>

</body>
</html>