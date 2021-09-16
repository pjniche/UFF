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
            <%@include file="navbar-user.jsp" %>

            <!-- Conteúdo aqui -->
            <%
                User usuarioLogado = (User)session.getAttribute("usuarioLogado");
            %>
                <div class="alert alert-info" role="alert">
                        Usuário: <%=usuarioLogado.getNome()%> - CPF: <%=usuarioLogado.getCpf()%> - ID: <%=usuarioLogado.getId()%>
                </div>
            <%
                if (request.getAttribute("mensagem") != null) {
                    String mensagem = (String)request.getAttribute("mensagem");
            %>
                    <script>
                        alert("<%=mensagem%>");
                    </script>
            <% } %>
	    </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
