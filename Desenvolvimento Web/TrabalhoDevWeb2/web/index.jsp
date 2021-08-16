<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Meta tags Obrigatórias, Bootstrap CSS -->
        <%@include file="header.html" %>
    </head>
    <body>
        <div class="container">
            <!-- Menu de navegação -->
            <%@include file="menu-home.jsp" %>

		    <!-- Conteúdo aqui -->
		    <div class="card text-center">
			    <div class="card-header">Trabalho de Desenvolvimento Web – 2021.1 - Paulo Jr. Niche</div>
			    <div class="card-body">
				    <h5 class="card-title">Sistema de Controle de Lançamentos de Créditos e Débitos</h5>
				    <p class="card-text">
					    O sistema funciona como uma conta corrente de um banco tradicional, apresentando os lançamentos
					    financeiros em uma lista.
				    </p>
				    <a href="login.jsp" class="btn btn-primary">Acessar</a>
			    </div>
			    <div class="card-footer text-muted">Universidade Federal Fluminense</div>
		    </div>
	    </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
