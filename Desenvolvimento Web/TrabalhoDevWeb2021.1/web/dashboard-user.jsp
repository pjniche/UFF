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
            <%@include file="navbar-user.jsp" %>

            <!-- Conteúdo aqui -->
            <%
                String usuario = (String)session.getAttribute("usuario");
                if (usuario == null) {
                    response.sendRedirect("index.jsp");
                }
            %>
            <%
                if (request.getAttribute("mensagem") != null) {
                    String mensagem = (String) request.getAttribute("mensagem");
            %>
                    <div class="alert alert-success" role="alert">
                        <%=mensagem%>
                    </div>
            <%
                }
            %>
	    </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
