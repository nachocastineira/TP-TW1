<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<form:form action="obtener-resultado-erroneo" method="POST" modelAttribute="suma">
			<div class="container">
				<form:input path="valor1" type="text" placeholder="Numero 1"/>
				<form:input path="valor2" type="text" placeholder="Numero 2"/>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Calcular</button>
			</div>
		</form:form>
	</div>

</body>
</html>