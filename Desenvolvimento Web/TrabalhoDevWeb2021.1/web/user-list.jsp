<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
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
               ArrayList<User> lista = (ArrayList<User>)request.getAttribute("usuarios");
            %>
		    <h4>Suspender usuário</h4>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Suspenso?</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < lista.size(); i++) { %>
                    <tr>
                        <td><%=lista.get(i).getNome()%></td>
                        <td><%=lista.get(i).getCpf()%></td>
                        <td><%=lista.get(i).getSuspenso()%></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
