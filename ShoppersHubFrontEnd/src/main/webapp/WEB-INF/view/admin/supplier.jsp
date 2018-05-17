<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
</head>
<body>

<br><br>


	<div class="container">
	  <form>
	  <div class="col-md-6 form-line">
		<div class="form-group">
		  <label for="mail">Email ID</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fa fa-envelope" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="emailID" placeholder="Email ID" 
			   		id="mail" value= "${selectedSupplier.emailID}">
			</div>	 
		</div>
		
		
		<div class="form-group">
		  <label for="sname" >Name</label>
			<div class="input-group">	   
			<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="name" placeholder="Name" 
					id="sname" value= "${selectedSupplier.name}">
			</div>	 
		</div>
		
		
		<div class="form-group">
		  <label for="pass">Password</label>
			<div class="input-group">	   
			<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
		 	<input type="password" class="form-control" name="password" placeholder="Password" 
			   		id="pass" value= "${selectedSupplier.pass}">
			</div>	 
		</div>   
	</div>	   
		
	<div class="col-md-6">
		<div class="form-group">	   
		  <label for="cpass">Confirm Password</label>
		  	<div class="input-group">	   
			<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
			<input type="password" class="form-control" name="cpassword" placeholder="Confirm Password" id="cpass" >
		  	</div>	 
		</div>   
			   
		
		<div class="form-group">	   
		  <label for="mob">Mobile</label>
		    <div class="input-group">	   
			<span class="input-group-addon"><i class="fas fa-mobile-alt" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="mobile" placeholder="Mobile" 
			   id="mob" value= "${selectedSupplier.mobile}">
			</div>	 
		</div> 
			   
		
		<div class="form-group">	   
		  <label for="addr">Address</label>
		  	<div class="input-group">	   
			<span class="input-group-addon"><i class="fa fa-address-card" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="address" placeholder="Address" 
			   id="addr" value= "${selectedSupplier.address}">
			</div>	 
		</div>
	</div>	
		
		<div align="center">
			<button type="submit" class="btn btn-success">Submit</button>
			<button type="reset" class="btn btn-warning">Reset</button>
		</div>
	</form>
	</div>
	
	<br><br>
	<h3 align="center">LIST OF SUPPLIERS</h3>
	<div class="container">
	<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
		<tr>
			<th>Email ID</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Address</th>
			<th>Date</th>
			<th>Action</th>
		</tr>
	  </thead>
	  
	  <tbody>
		<c:forEach var="supplier" items="${suppliers}">
		  <tr>
			<td>${supplier.emailID}</td>
			<td>${supplier.name}</td>
			<td>${supplier.mobile}</td>
			<td>${supplier.address}</td>
			<td>${supplier.added_date}</td>
			<td>
			<a href="#" class="btn btn-sm btn-info"><i class="fas fa-edit"></i> Edit</a>
			<a href="#" class="btn btn-sm btn-danger"><i class="fas fa-trash"></i> Delete</a>
			</td>
		  </tr>
		</c:forEach>
	  </tbody>	
	</table>
	</div>
	</div>
</body>
</html>












