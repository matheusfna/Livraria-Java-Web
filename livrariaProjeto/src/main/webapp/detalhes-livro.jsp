<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="livraria.model.Livro"
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Livraria Java Web - MVC 2</title>

	<style>
	
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
			margin: 20px;			
		}
		
		.container-button{
			margin-top: 20px;			
		}
	
	
	</style>
	

</head>
<body>
		
		<% 
			Livro livro = (Livro) request.getAttribute("livro");			
		%>

	<h1> Detalhes do Livro - <%= livro.getId() %></h1>
	
	<form>
		<div class="container"> 
			<label for="nome">Título:</label>
			<input type="text" name="titulo" id="titulo" value="<%=  livro.getTitulo() %>  " readonly />
		</div>
		
		<div class="container"> 
			<label for="isbn">ISBN:</label>
			<input type="text" name="isbn" id="isbn" value="<%=  livro.getIsbn() %>  " readonly />
		</div>
		
		<div class="container"> 
			<label for="autor">Autor:</label>
			<input type="text" name="autor" id="autor" value="<%=  livro.getAutor() %>  " readonly />
		</div>
		
		<div class="container"> 
			<label for="editora">Editora:</label>
			<input type="text" name="editora" id="editora" value="<%=  livro.getEditora() %>  " readonly />
		</div>
	
	</form>
	
	<div class="container-button">
		<a class="btn-estilo" href="controller?cmd=listar"> Listar todos os Livros</a>
	</div>

</body>
</html>