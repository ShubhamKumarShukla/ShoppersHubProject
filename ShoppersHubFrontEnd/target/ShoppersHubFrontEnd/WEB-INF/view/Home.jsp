<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>ShoppersHub</title>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
 <jsp:include page="carousel2.jsp"></jsp:include> 
	 <div class="bodybackground">
		<c:if test="${isUserClickedLogin==true}">
			<jsp:include page="LoginForm.jsp"></jsp:include>
		</c:if>
		
	<%--	<c:if test="${isUserClickedRegister==true}">
			<jsp:include page="register.jsp"></jsp:include>
		</c:if> --%>
	</div>  
</body>
</html>