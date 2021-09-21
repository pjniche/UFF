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
                    } Category aux = (Category)request.getAttribute("categoria");
                %>
                <form method="POST" action="Controller_Category">
                    <div class="mb-3">
                        <label for="nome" class="form-label"><h5>ID: <%=aux.getId()%></h5></label>
                        <input type="hidden" maxlength="11" class="form-control" name="id" id="id" value="<%=aux.getId()%>" required>
                        <br>
                        <label for="nome" class="form-label">Categoria: <%=aux.getDescricao()%></label>
                        <input type="text" maxlength="20" class="form-control" name="categoria" id="categoria" placeholder="Digite o NOVO nome da categoria." required>
                    </div>
                    <button type="submit" class="btn btn-info">Editar Categoria Cadastrada</button>
                </form>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
