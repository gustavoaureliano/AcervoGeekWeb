<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Coleções - ACERVO GEEK</title>
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
                    <h1>Colecionaveis</h1>
                </div>
                <div class="espacamento"></div>
                <div class="container">
                    <form id="searchBox" class="searchBox" action="controller.do" method="post">
                            <input class="inputText" type="search" name="chave" id="chave">
                            <label class="btnSearch" for="search"></label>
                            <input type="hidden" name="opcao" value="colecao">
                            <input type="hidden" name="idUsuario" value="${usuario.idUsuario}">
                        	<button id="search" type="submit" name="command" value="Listar"> Pesquisar </button>
                    </form>
                </div>
            </header>
            <div class="home">
                <nav class="menu">
                	<a href="controller.do?command=ExibirPerfil&idUsuario=${usuario.idUsuario}&pagina=colecao">
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
                    <div class="container opcoes">
                        <a href="addColecao.jsp">
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
                        <div class="espacamento"></div>
                    </div>
                </nav>
                <div class="listItens">
					<c:forEach var="colecao" items="${colecoes}">
	                    <div class="container item">
	                        <div class="content">
	                        	<a href="controller.do?command=Listar&opcao=item&idColecao=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">
			                        <div class="container">
			                            <h2>${colecao.nome}</h2>
			                        </div>
			                        <div class="img">
			                            <img src="controller.do?command=ExibirImagem&opcao=colecao&id=${colecao.idColecao}" alt="">
			                        </div>
			                	</a>
	                    	</div>
	                        <div class="container alterar">
	                        	<a class="btn" href="controller.do?command=ExibirEditar&opcao=colecao&idColecao=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">Editar</a>
                            	<a class="btn showExcluir">Excluir</a>
                            	<div class="back">
                                   <div class="popup">
                                       <div class="container row btnClose">
                                           <p>Excluir ${colecao.nome}</p>
                                           <button class="btn">X</button>
                                       </div>
                                       <div class="container">
                                           <p>Tem certeza que deseja excluir a coleção?</p>
                                           <div class="container row confirma"> 
	                            				<a class="btn" href="controller.do?command=Excluir&opcao=colecao&id=${colecao.idColecao}&idUsuario=${usuario.idUsuario}">Sim</a>
	                                           	<a class="btn">Não</a>
                                           </div>
                                       </div>
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
    </body>
</html>