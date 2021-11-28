<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil - ACERVO GEEK</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="main">
            <header>
                <div class="espacamento"></div>
                <div class="container espacamento">
                    <a href="colecoes.jsp">
                        <img src="imagens/logo.png" alt="">
                    </a>
                </div>
                <div class="container espacamento">
                    <h1>Perfil</h1>
                </div>
                <div class="espacamento"></div>
                <div class="container">
                    <form id="searchBox" class="searchBox" action="controller.do" method="post">
                            <input class="inputText" type="search" name="chave" id="chave">
                            <label class="btnSearch" for="search"></label>
                            <input id="search" type="submit" value="Pesquisar">
                            <select class="categorias" name="categoria" id="categoria" form="searchBox">
                                <option value="">Nenhuma</option>
                                <option value="cat1">cat1</option>
                                <option value="cat2">cat2</option>
                                <option value="cat3">cat3</option>
                                <option value="cat4">cat4</option>
                              </select>
                    </form>
                </div>
            </header>
            <div class="card">
                <div class="espacamento"></div>
                <div class="perfil">
                    <form action="controller.do" enctype="multipart/form-data" method="post">
                        <div class="container">
                            <img class="imgFile" src="controller.do?command=ExibirImagem&opcao=usuario&id=${usuario.idUsuario}" alt="">
                            <label class="btn" for="imagem">Escolher Imagem</label>
                            <input type="file" name="imagem" id="imagem">
                        </div>
                        <div class="container">
                            <label for="nome">Nome</label>
                            <input class="inputText" type="text" name="nome" id="nome" value="${usuario.nome}">
                        </div>
                        <div class="container">
                            <label for="usuario">Usuario</label>
                            <input class="inputText" type="text" name="usuario" id="usuario" value="${usuario.usuario}">
                        </div>
                        <div class="container">
                            <label for="senha">Senha</label>
                            <input class="inputText" placeholder="Nova senha" type="password" name="senha" id="senha">   
                        </div>
                        <div class="container">
                        	<input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                        	<input type="hidden" name="opcao" value="usuario">
                            <button class="btn" type="submit" name="command" value="Editar"> Salvar </button>
                        </div>
                    </form>
                </div>
                <div class="espacamento"></div>
            </div>
        </div>
		<div class="dropbox">
			<h3>Solte uma imagem aqui</h3>
		</div>
		<script src="js/dragdrop.js"></script>
    </body>
</html>