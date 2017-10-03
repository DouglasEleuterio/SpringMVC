<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<div class="container">
		<h1>Cadastro de Usuários</h1>
		<hr>
		<div>
			<spring:url value="/usuario/todos" var="home"/>
			<a class="btn btn-default" href="${home }">Home</a>
		</div>
		<hr>
		<div>
			<!-- Atalho até o Controller que usaremos, caso usassemos o Link, teria que passar toda URL HTTp...UltimoPath -->
			<spring:url value="/usuario/save" var="save" /> <!-- /Usuario(RequestMapping) nosso controle / Save o Metodo de Usuario -->
			<!--  Classe de Dominio USUARIO -->
			<form:form modelAttribute="usuario" action="${save }" method="post">

				<div class="form-group">
					<label for="nome">Nome: </label>
					<!-- PAth faz a ligação entre o formulário e Objeto de Dominio -->
					<form:input path="nome" class="form-control" />
				</div>
				
				<div class="form-group">
					<label for="sobrenome">Sobrenome: </label>
					<form:input path="sobrenome" class="form-control" />
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Confirmar</button>
				</div>
			</form:form>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2017 DevMedia</p>
		</footer>
	</div>
</body>
</html>