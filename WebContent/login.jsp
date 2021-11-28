<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - ACERVO GEEK</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="main row">
            <div class="imagem imgLogin"></div>
            <div class="formulario">
                <div class="container">
                    <h1>Insira seus dados de login</h1>
                </div>
                <form action="controller.do" method="post">
                    <div class="container">
                        <label for="usuario">Usuario</label>
                        <input class="inputText" type="text" name="usuario" id="usuario">
                    </div>
                    <div class="container">
                        <label for="senha">Senha</label>
                        <input class="inputText" type="password" name="senha" id="senha">
                        <p class="perguntaRedirect">Ainda não se cadastrou? <a class="small" href="index.jsp">Cadastro</a></p>
                    </div>
                    <div class="container">
                        <button class="btn" type="submit" name="command" value="Login"> Login </button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>