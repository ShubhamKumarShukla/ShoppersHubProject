<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Header</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css"	href="resources/css/HeaderStyle.css">
</head>


<body>
	<div class="header">
	<nav class="navbar navbar-inverse" style="background-color: #041633;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>
        		<span class="icon-bar"></span>                        
      		</button>
			<a class="navbar-brand" href="http://localhost:8080/ShoppersHubFrontEnd/"></a>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Sign Up</a></li>
			<li><a href="login">Login</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
		</ul>
		</div>
	</div>
	</nav>
	</div>
</body>

</html>