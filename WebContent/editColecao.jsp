<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Coleção - ACERVO GEEK</title>
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
                    <h1>Editar Coleção</h1>
                </div>
                <div class="espacamento"></div>
                <div class="container">
                    <form id="searchBox" class="searchBox" action="controller.do" method="post">
                            <input class="inputText" type="search" name="chave" id="chave">
                            <label class="btnSearch" for="search"></label>
                            <input type="hidden" name="opcao" value="colecoes">
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                        	<button id="search" type="submit" name="command" value="Listar"> Pesquisar </button>
                    </form>
                </div>
            </header>
            <div class="card">
                <div class="espacamento"></div>
                <div class="addItem">
                    <form action="controller.do" enctype="multipart/form-data" method="post">
                        <div class="container">
                            <label for="nome">Nome</label>
                            <input class="inputText" type="text" name="nome" id="nome" value="${colecao.nome}">
                        </div>
                        <div class="container">
                            <img  class="imgFile" src="controller.do?command=ExibirImagem&opcao=colecao&id=${colecao.idColecao}" alt="">
                            <label class="btn" for="imagem">Escolher Imagem</label>
                            <input type="file" name="imagem" id="imagem">
                        </div>
                        <div class="container">
                            <label for="descricao">Descrição</label>
                            <textarea name="descricao" id="descricao">${colecao.descricao}</textarea>
                        </div>
                        <div class="container row">
                            <input type="hidden" name="opcao" value="colecao">
                            <input type="hidden" name="id" value="${colecao.idColecao}">
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
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