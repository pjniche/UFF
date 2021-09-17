<%@page import="aplication.User"%>
<%@page import="aplication.Category"%>
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
                        Category aux = (Category)request.getAttribute("categoria");
                    }
                %>
                <form method="POST" action="Controller_Category">
                    <div class="mb-3">
                        <label for="categoria" class="form-label">Categoria</label>
                        <input type="text" maxlength="20" class="form-control" name="categoria" id="categoria" placeholder="Digite o nome da nova categoria." required>
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar Categoria</button>
                </form>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
