<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, java.util.Iterator, livraria.model.Livro"
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Livraria Java Web - MVC 2</title>

	<style>
		table, th, td {
			border: 1px solid black;		
		}
		
		.btn-estilo{
			background-color: #199319;
			colow: white;
			padding: 15px 25px;
			text-decoration: nome;
		}
		
		.btn-estilo:hover{
			background-color: #223094;
		}
		
		.container{
			margin: 20px 5px;			
		}
	
	
	</style>

</head>
<body>

<h1>Lista de Livros</h1>

<div class="container">
	<a class="btn-estilo" href="cadastrar-livro.jsp">Novo Livro</a>
</div>


<table>
	<tr>		
		<th>Título</th>
		<th>ISBN</th>
		<th>Autor</th>
		<th>Editora</th>
		<th>Opções</th>		
	</tr>
	
	<%
	List livros = (List) request.getAttribute("livrosLista");
	
	for(Iterator i = livros.iterator(); i.hasNext(); ) {
		
		Livro livro = (Livro) i.next();

	%>

	
	
	<tr>
		<td> 
			<a href="controller?cmd=mostrar&titulo=<%= livro.getTitulo() %>"> <%= livro.getTitulo() %> </a>
		 </td>		
		<td> <%= livro.getIsbn() %> </td>
		<td> <%= livro.getAutor() %> </td>
		<td> <%= livro.getEditora() %> </td>
		<td>
			<a href="controller?cmd=excluir&id=<%= livro.getId() %>"> Excluir</a>
		</td>	
	</tr>
	
	<%
	}
	%>

</table>


</body>
</html>