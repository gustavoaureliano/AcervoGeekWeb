<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Itens - ACERVO GEEK</title>
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
                    <a href="colecoes.html">
                        <img src="imagens/logo.png" alt="">
                    </a>
                </div>
                <div class="container espacamento">
                    <h1>Coleção - ${colecao.nome}</h1>
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
            <div class="home">
                <nav class="menu">
                    <div class="container row usuario">
	                	<a href="controller.do?command=ExibirPerfil&idUsuario=${usuario.idUsuario}">
		                    <div class="container row usuario">
		                        <img src="controller.do?command=ExibirImagem&opcao=usuario&id=${usuario.idUsuario}" alt="">
		                        <p>${usuario.nome}</p>
		                    </div>                	
	                	</a>
                    </div>
                    <div class="container opcoes">
                        <a href="addItem.jsp">
                            <div class="container row opcao">
                                <img src="imagens/btnAdd.png" alt="">
                                <h3>Adicionar coleção</h2>
                            </div>
                        </a>
                        <div class="container row opcao alt">
                            <img src="imagens/btnAlterar.png" alt="">
                            <h3>Alterar coleção</h2>
                        </div>
                        <a href="sobre.jsp">
	                        <div class="container row opcao">
	                            <img src="imagens/btnSobre.png" alt="">
	                            <h3>Acervo Geek</h2>
	                        </div>
                        </a>
                    </div>
                    <div class="container data">
                        <div class="container">
                            <h3>Ultima Alteração</h3>
                            <p>99/99/9999</p>
                        </div>
                        <div class="container">
                            <h3>Ultima Alteração</h3>
                            <p>99/99/9999</p>
                        </div>
                    </div>
                </nav>
                <div class="listItens">
	               <c:forEach var="item" items="${itens}">
	                    <div class="container item">
	                        <div class="container">
	                            <h2>${item.nome}</h2>
	                        </div>
	                        <div class="img">
	                            <img src="controller.do?command=ExibirImagem&opcao=item&id=${item.idItem}" alt="">
	                        </div>
	                        <div class="container alterar">
	                            <a class="btn" href="controller.do?command=ExibirEditar&opcao=item&id=${item.idItem}&idColecao=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">Editar</a>
	                            <a class="btn" href="controller.do?command=Excluir&opcao=item&id=${item.idItem}&idColecao=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">Excluir</a>
	                        </div>
	                    </div>
					</c:forEach>
                </div>
            </div>
        </div>
		<script src="js/script.js"></script>
    </body>
</html>