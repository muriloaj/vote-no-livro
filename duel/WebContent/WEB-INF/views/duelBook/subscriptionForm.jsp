<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>@muriloaj - Duel Book</title>
<script src="resources/js/jquery.js"></script>
<link rel="stylesheet" href="resources/css/estilos.css">
</head>
<body>
	<div>
		<p>Cadastre-se e mantenha-se sempre informado.</p>
		<form action="enroll" method="post">
			<p>
				<label for="name">Nome:</label> <input type="text" name="name" />
				<form:errors path="user.name" />
			</p>
			<p>
				<label for="email">E-mail:</label> <input type="text" name="email" />
				<form:errors path="user.email" />
			</p>
			<div style="margin-left: 150px;">
				<input type="submit" value="Enviar..." />
			</div>
		</form>
	</div>

	<div align="right" style="margin-right: 50px;">
		<hr />
		<sub> Developed by: @muriloaj - https://github.com/muriloaj/vote-no-livro </sub>
	</div>
</body>
</html>