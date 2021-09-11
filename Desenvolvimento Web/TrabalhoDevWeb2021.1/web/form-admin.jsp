<%@page import="model.Admin"%>
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
            <%@include file="navbar-admin.jsp" %>

		    <!-- Conteúdo aqui -->
            <%
               Admin aux = (Admin)request.getAttribute("admin");
            %>
		    <h4>Cadastrar administrador</h4>
		    <form method="POST" action="Controller_Admin">
			    <div class="mb-3">
				    <label for="Nome" class="form-label">Nome</label>
				    <input type="text" maxlength="20" class="form-control" name="nome" placeholder="Digite seu nome." required>
			    </div>
			    <div class="form-group">
				    <label for="cpf">CPF</label>
				    <input type="text" class="form-control cpf" name="cpf" placeholder="Ex: xxx.xxx.xxx-xx" required>
			    </div>
			    <div class="form-group">
				    <label for="senha">Senha</label>
				    <input type="password" maxlength="255" class="form-control" name="senha" placeholder="Digite a sua senha." required>
			    </div>
			    <button type="submit" class="btn btn-primary">Cadastrar</button>
		    </form>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
