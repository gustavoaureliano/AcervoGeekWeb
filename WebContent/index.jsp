<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ACERVO GEEK</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="main row">
            <div class="imagem imgCadastro"></div>
            <div class="formulario">
                <div class="container">
                    <h1>Seja bem vindo ao <strong>ACERVO GEEK</strong>!</h1>
                    <p>Crie uma conta hoje e organize sua coleção pessoal!</p>
                </div>
                <form action="controller.do" method="post">
                    <div class="container">
                        <label for="nome">Nome</label>
                        <input class="inputText" type="text" name="nome" id="nome">
                    </div>
                    <div class="container">
                        <label for="usuario">Usuario</label>
                        <input class="inputText" type="text" name="usuario" id="usuario">
                    </div>
                    <div class="container">
                        <label for="senha">Senha</label>
                        <input class="inputText" type="password" name="senha" id="senha">
                        <p class="perguntaRedirect">Já está cadastrado? <a class="small" href="login.jsp">Login</a></p>
                    </div>
                    <div class="container">
                        <button class="btn" type="submit" name="command" value="CadastrarUsuario"> Cadastrar </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>