<%@page import="aplication.User"%>
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
            <div class="col-8 mt-5">
                <%
                    User usuarioLogado = (User)session.getAttribute("usuarioLogado");
                    if (usuarioLogado == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    } else {
                        User aux = (User)request.getAttribute("user");
                    }
                %>
                <form method="POST" action="Controller_User">
                    <div class="mb-3">
                        <label for="nome" class="form-label">Usuário</label>
                        <input type="text" maxlength="20" class="form-control" name="nome" id="nome" placeholder="Digite o nome do usuário." required>
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF</label>
                        <input type="text" class="form-control cpf" name="cpf" id="cpf" placeholder="Ex: xxx.xxx.xxx-xx" required>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha</label>
                        <input type="password" maxlength="255" class="form-control" name="senha" id="senha" placeholder="Digite a senha do usuário." required>
                    </div>
                    <div class="form-group">
                        <label for="suspenso">Suspenso?</label>
                        <input type="text" maxlength="1" class="form-control" name="suspenso" id="suspenso" placeholder="'S' para Suspenso ou 'N' para Não Suspenso." required>
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar Usuário</button>
                </form>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
