<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	</style>

</head>
<body>

	<h1>Cadastro de Livro</h1>
	
	<form action="controller?cmd=salvar" method="post">
		<div class="container"> 
			<label for="titulo">Título:</label>
			<input type="text" name="titulo" id="titulo"/>
		</div>
		
		<div class="container"> 
			<label for="isbn">ISBN:</label>
			<input type="text" name="isbn" id="isbn"/>
		</div>
		
		<div class="container"> 
			<label for="autor">Autor:</label>
			<input type="text" name="autor" id="autor"/>
		</div>
		
		<div class="container"> 
			<label for="editora">Editora:</label>
			<input type="text" name="editora" id="editora"/>
		</div>
		
		<button class="btn-estilo container" type="submit">
			Salvar
		</button>
	
	</form>

</body>
</html>