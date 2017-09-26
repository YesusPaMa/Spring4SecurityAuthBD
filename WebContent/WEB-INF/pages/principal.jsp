<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bienvenido</title>
</head>
<body>
	<h2>${saludos}</h2>
	
	<br/>
	<div>
		<sec:authorize access="hasRole('USER')">
			<h1>Eres un simple MORTAL con permisos de USER</h1>
			<br>
			<a href="<c:url value="/logout" />">Cerrar sesión</a>
		</sec:authorize>
	</div>
	
	<br/>
	<div>
		<sec:authorize access="hasRole('ADMIN')">
			<label><a href="<c:url value="/admin" />">Edita esta página</a> | Esta parte sólo es visible para ADMIN</label>
		</sec:authorize>
	</div>

	<br/>
	<div>
		<sec:authorize access="hasRole('ADMIN') and hasRole('DBA')">
			<label><a href="<c:url value="/db" />">Iniciar copia de seguridad</a> | Esta parte es visible sólo para quien es ADMIN y DBA</label>
		</sec:authorize>
	</div>
</body>
</html>