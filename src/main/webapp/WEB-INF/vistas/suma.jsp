<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" >
	    
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<form:form action="mi-suma" method="POST" modelAttribute="suma">
				<h3 class="form-signin-heading">Calcular suma</h3>
				<hr class="colorgraph"><br>
				<form:input path="valor1" type="text" placeholder="Numero 1" class="form-control"/>
				<form:input path="valor2" type="text" placeholder="Numero 2" class="form-control"/>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Calcular</button>
			</form:form>
			<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		    </c:if>		
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
</body>
</html>