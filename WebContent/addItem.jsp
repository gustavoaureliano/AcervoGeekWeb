<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Adicionar Item - ACERVO GEEK</title>
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
                    <h1>Adicionar Item</h1>
                </div>
                <div class="espacamento"></div>
                <div class="container">
                    <form id="searchBox" class="searchBox" action="controller.do" method="post">
                        <input class="inputText" type="search" name="chave" id="chave">
                        <label class="btnSearch" for="search"></label>
                        <input type="hidden" name="opcao" value="item">
                        <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                        <input type="hidden" name="idColecao" value="${colecao.idColecao}">
                       	<button id="search" type="submit" name="command" value="Listar"> Pesquisar </button>
                       	<select class="categorias" name="categoria" id="categoria" form="searchBox">
                            <option value="0">Nenhuma</option>
                            <c:forEach var="categoria" items="${categorias}">
                                <c:choose>
								    <c:when test="${categoria.idCategoria == categoriaSelecionada.idCategoria}">
                                   		<option value="${categoria.idCategoria}" selected>${categoria.nome}</option>
								    </c:when>    
								    <c:otherwise>
                                   		<option value="${categoria.idCategoria}">${categoria.nome}</option>
								    </c:otherwise>
								</c:choose>
                            </c:forEach>
                        </select>
                    </form>
                </div>
            </header>
            <div class="card">
                <div class="espacamento"></div>
                <div class="addItem boxCat">
                    <form action="controller.do" enctype="multipart/form-data" method="post">
                        <div class="container">
                            <label for="nome">Nome</label>
                            <input class="inputText" type="text" name="nome" id="nome">
                        </div>
                        <div class="container">
                            <img class="imgFile" src="" alt="">
                            <label class="btn" for="imagem">Escolher Imagem</label>
                            <input type="file" name="imagem" id="imagem">
                        </div>
                        <div class="container">
                            <label for="descricao">Descrição</label>
                            <textarea name="descricao" id="descricao"></textarea>
                        </div>
                        <div class="container row">
                            <label class="lblCategoria" for="categoria">Categoria: </label>
                            <select class="categorias" name="categoria" id="categoria">
                                <option value="0">Nenhuma</option>
                                <c:forEach var="categoria" items="${categorias}">
                                    <option value="${categoria.idCategoria}">${categoria.nome}</option>
                                </c:forEach>
                            </select>
	                        <div class="container showAddCat">
	                            <img id="btnCat" src="imagens/btnAdd.png" alt="">
	                        </div>
                        </div>
                        <div class="container row">
                            <input type="hidden" name="opcao" value="item">
                            <input type="hidden" name="id" value="${colecao.idColecao}">
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                        	<button class="btn" type="submit" name="command" value="Adicionar"> Adicionar </button>
                        </div>
                    </form>
                    <div class="back">
                        <div class="popup">
                            <div class="container row btnClose">
								<p>Categoria</p>
                                <button class="btn">X</button>
                            </div>
                            <div class="container row">
                                <button class="btnOpcao selected" id="opcaoAdd">Nova</button>
                                <button class="btnOpcao" id="opcaoEdit">Editar</button>
                            </div>
                            <div class="container boxAdd show">
                                <form class="container" action="controller.do" method="post">
                                	<div class="container">
	                                    <label for="inputCategoria">Nome da Categoria</label>
	                                    <input class="inputText" type="text" name="nome" id="inputCategoria">
                                	</div>
			                    	<div class="container">
                            			<input type="hidden" name="opcao" value="addItem">
	                        			<input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
	                        			<input type="hidden" name="idColecao" value="${colecao.idColecao}">
				                        <button class="btnAddCat" type="submit" name="command" value=AddCategoria> Adicionar </button>
			                    	</div>
                                </form>
                            </div>
                            <div class="container boxEdit">
                                <form class="container" action="controller.do" method="post">
                                	<div class="container">
								        <p>Selecionar Categoria</p>
                                        <select class="categorias" name="categoria" id="categoria">
                                            <option value="0">Nenhuma</option>
                                            <c:forEach var="categoria" items="${categorias}">
                                                <option value="${categoria.idCategoria}">${categoria.nome}</option>
                                            </c:forEach>
                                        </select>
                                	</div>
                                    <div class="container">
	                                    <label for="inputCategoria">Nome da Categoria</label>
	                                    <input class="inputText" type="text" name="nome" id="inputCategoria">
                                	</div>
                                    <div class="container row separaBtn">
                                        <input type="hidden" name="opcao" value="addItem">
                                        <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                                        <input type="hidden" name="idColecao" value="${colecao.idColecao}">
                                        <button class="btn" type="submit" name="command" value="EditCategoria"> Salvar </button>
                                        <button class="btn" type="submit" name="command" value="ExcluirCategoria"> Excluir </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="espacamento"></div>
            </div>
        </div>
		<div class="dropbox">
			<h3>Solte uma imagem aqui</h3>
		</div>
		<script src="js/showCategoria.js"></script>>
		<script src="js/showDescricao.js"></script>
		<script src="js/dragdrop.js"></script>
    </body>
</html>