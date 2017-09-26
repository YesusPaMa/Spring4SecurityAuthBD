<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login page</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    	<link href="<c:url value='/static/css/bootstrap-theme.css' />" rel="stylesheet"></link>
    	<link href="<c:url value='/static/css/login.css' />" rel="stylesheet"></link>
	</head>
 
    <body>
		<div id="container">
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="post" class="form-signin">
				<h2 class="form-signin-heading">Spring Security 4</h2>
				<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
				<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="form-actions">
					<input type="submit" class="btn btn-lg btn-primary btn-block" value="Iniciar sesión">
				</div>
				<br>
				<c:if test="${param.error != null}">
				<div class="alert alert-danger">
				    <p>Nombre de usuario y contraseña inválidos.</p>
				</div>
				</c:if>
				<c:if test="${param.logout != null}">
				    <div class="alert alert-success">
				        <p>Se ha cerrado la sesión con éxito.</p>
				    </div>
				</c:if>
			</form>
		</div>
    </body>
</html>