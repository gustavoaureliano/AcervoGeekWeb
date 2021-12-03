
<%@page import="service.ColecaoService"%>
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
                    <a href="colecoes.jsp">
                        <img src="imagens/logo.png" alt="">
                    </a>
                </div>
                <div class="container espacamento">
                    <h1>Coleção - ${colecao.nome}</h1>
                </div>
                <div class="espacamento"></div>
                <div class="container boxCat">
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
                        <div class="container showAddCat">
                            <img id="btnCat" src="imagens/btnAdd.png" alt="">
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
	                        			<input type="hidden" name="opcao" value="item">
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
                                        <input type="hidden" name="opcao" value="item">
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
            </header>
            <div class="home">
                <nav class="menu">
                    <div class="container row usuario">
	                	<a href="controller.do?command=ExibirPerfil&idUsuario=${usuario.idUsuario}&pagina=item&idColecao=${colecao.idColecao}">
		                    <div class="container row usuario">
		                    	<div class="usuarioImg">
			                    	<c:choose>
									    <c:when test="${usuario.foto != null}">
		                        			<img src="controller.do?command=ExibirImagem&opcao=usuario&id=${usuario.idUsuario}" alt="">
									    </c:when>    
									    <c:otherwise>
		                        			<img src="imagens/usuario.jpg" alt="">
									    </c:otherwise>
									</c:choose>
		                    	</div>
		                        <p>${usuario.nome}</p>
		                    </div>                	
	                	</a>
                    </div>
                    <div class="container opcoes">
                        <a href="addItem.jsp">
                            <div class="container row opcao">
                                <img src="imagens/btnAdd.png" alt="">
                                <h3>Adicionar item</h2>
                            </div>
                        </a>
                        <div class="container row opcao alt">
                            <img src="imagens/btnAlterar.png" alt="">
                            <h3>Alterar item</h2>
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
                            <h3>Data de criação</h3>
                            <p>${colecao.data_criacao}</p>
                        </div>
                        <div class="container">
                            <h3>Ultima Alteração</h3>
                            <p>${colecao.data_alteracao}</p>
                        </div>
                    </div>
                    <div class="container">
                    	<div class="container row sobreDesc">
                            <img src="imagens/btnDescColecao.png" alt="">
                            <h3>${colecao.nome}</h2>
                        </div>
                    	<div class="back">
                        	<div class="popup">
                        		<div class="container row btnClose">
                        			<p>Descrição</p>
                                	<button class="btn">X</button>
                        		</div>
                        		<div class="container">
                                	<p>${colecao.descricao}</p>
                        		</div>
                        	</div>
                        </div>
                    </div>
                </nav>
                <div class="listItens">
	               <c:forEach var="item" items="${itens}">
	                    <div class="container item">
	                    	<div class="content">
		                        <div class="container">
		                            <h2>${item.nome}</h2>
		                        </div>
		                        <div class="img">
		                            <img src="controller.do?command=ExibirImagem&opcao=item&id=${item.idItem}" alt="">
		                        </div>
	                    	</div>
	                        <div class="container alterar">
	                            <a class="btn" href="controller.do?command=ExibirEditar&opcao=item&id=${item.idItem}&idColecao=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">Editar</a>
                                <a class="btn showExcluir">Excluir</a>
                                <div class="back">
                                    <div class="popup">
                                        <div class="container row btnClose">
                                            <p>Excluir ${item.nome}</p>
                                            <button class="btn">X</button>
                                        </div>
                                        <div class="container">
                                            <p>Tem certeza que deseja excluir o item?</p>
                                            <div class="container row confirma"> 
                                            	<a class="btn" href="controller.do?command=Excluir&opcao=item&id=${item.idItem}&idColecao=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">Sim</a>
                                            	<a class="btn">Não</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
	                        </div>
	                        <div class="back">
	                        	<div class="popup">
	                        		<div class="container row btnClose">
	                        			<p>Descrição</p>
                                    	<button class="btn">X</button>
	                        		</div>
	                        		<div class="container">
                                    	<p>${item.descricao}</p>
	                        		</div>
                                </div>
	                        </div>
	                    </div>
					</c:forEach>
                </div>
            </div>
        </div>
		<script src="js/script.js"></script>
		<script src="js/showDescricao.js"></script>
		<script src="js/showCategoria.js"></script>
    </body>
</html>