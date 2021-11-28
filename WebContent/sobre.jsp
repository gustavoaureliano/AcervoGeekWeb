<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sobre - ACERVO GEEK</title>
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
                    <h1>Sobre</h1>
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
                <div class="sobre">
                    <p>
                        O site foi desenvolvido pelos
                        alunos Gustavo Rocha e Aaron
                        Ferraz, alunos de Escola Técnica Estadual
                        de São Paulo.
                    </p>
                    <p>
                        Façam bom proveito :-)
                    </p>
                </div>
                <div class="espacamento"></div>
            </div>
        </div>
    </body>
</html>