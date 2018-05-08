<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div id="mainOffers" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#mainOffers" data-slide-to="0" class="active"></li>
			<li data-target="#mainOffers" data-slide-to="1"></li>
			<li data-target="#mainOffers" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img  src="resources/images/Temp1.jpg" alt="First slide"> <!-- class="d-block w-100" -->
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="resources/images/Temp2.jpg" alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="resources/images/Temp3.jpg" alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="mainOffers" role="button" data-slide="prev">
	    	<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
	    	<span class="sr-only">Previous</span>
		</a> 
		<a class="carousel-control-next" href="mainOffers" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> 
			<span class="sr-only">Next</span>
		</a>
	</div>


</body>
</html>