<%@page import="aplication.User"%>
<%@page import="aplication.Category"%>
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
            <div class="col-12 mt-5">
                <%
                    User usuarioLogado = (User)session.getAttribute("usuarioLogado");
                    if (usuarioLogado == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    } else {
                        ArrayList<Category> lista = (ArrayList<Category>)request.getAttribute("categorias");
                %>
                <h4>Categorias</h4>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < lista.size(); i++) { %>
                        <tr>
                            <td><%=lista.get(i).getId()%></td>
                            <td><%=lista.get(i).getDescricao()%></td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <a type="button" class="btn btn-info" href="Controller_Category?option=editar&id_categoria=<%=lista.get(i).getId()%>">Editar</a>
                                    <a type="button" class="btn btn-danger" href="Controller_Category?option=excluir&id_categoria=<%=lista.get(i).getId()%>">Excluir</a>
                                </div>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
                <% } %>
            </div>
        </div>
        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
