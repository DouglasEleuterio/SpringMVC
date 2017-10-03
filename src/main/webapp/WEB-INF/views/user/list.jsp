<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Ususarios</title>
</head>
<body>
	<div class="container">
		<h1>Lista de Usuários</h1>
		<hr>
		<div>

			<spring:url value="/usuario/cadastro" var="cadastro"/>
			<a class="btn btn-default" href="${cadastro }">Novo Usuário</a>
		</div>
		<hr>

		<div class="panel-default">

			<div class="panel-heading">
				<span>${message == null ? '&nbsp;' : message}</span>
			</div>

			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>AÇÃO</th>
					</tr>
				</thead>
				<tbody>
					<!-- Tabela onde exibiremos os usuarios
					ForEach para exibir todos os itens da tabela
					1 Lista de Items que iremos percorrer, o metodo escolhido precisa retornar uma lista 
					2 Após estar com a lista nos items, informamos a variavel que será nossa variavél 
					Resumindo, para cada item da lista de Usuarios, vou recuperar um Usuario
					-->
					<c:forEach var="usuario" items="${usuarios }">
						<tr>
							<!-- Usando a EL recupero a variável.nome do atributo -->
							<td>${usuario.id }</td>
							<td>${usuario.nome }&nbsp;${usuario.sobrenome }</td>
							<td><a class="btn btn-info" href="#">Editar</a> <a
								class="btn btn-danger" href="#">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2017 DevMedia</p>
		</footer>
	</div>
</body>
</html>