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
			<label for="cname">Category Name</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-box" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="name" placeholder="Category Name" 
				   id="cname" value= "${selectedCategory.name}">
			</div>
		</div>
		</div>
		
		<div class="col-md-6">
		<div class="form-group">
			<label for="cdesc">Category Description</label>
			<div class="input-group">
			<span class="input-group-addon"><i class="fas fa-clipboard" aria-hidden="true"></i></span>
			<input type="text" class="form-control" name="description" placeholder="Category Description" 
		       id="cdesc" value = "${selectedCategory.description}" >
		    </div>
		</div>
		</div>
		
		<div align="center">
			<button type="submit" class="btn btn-success">Submit</button>
			<button type="reset" class="btn btn-warning">Reset</button>
		</div>
		
	</form> 
	</div>
	
	<br><br><br><br>
	<h3 align="center">LIST OF CATEGORIES</h3>
	<div class="container">
	<div class="table-responsive">
	<table class="table table-striped">
	  <thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Date</th>
			<th class="text-center">Action</th>
		</tr>
	  </thead>	
			
	  <!--   display all the categories -->
		<tbody>
		  <c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.name}</td>
				<td>${category.description}</td>
				<td>${category.added_date}</td>
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