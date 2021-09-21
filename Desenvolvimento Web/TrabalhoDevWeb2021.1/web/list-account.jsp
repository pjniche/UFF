<%@page import="aplication.User"%>
<%@page import="aplication.Account"%>
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
            <%@include file="navbar-user.jsp" %>

            <!-- Conteúdo aqui -->
            <div class="col-12 mt-5">
                <%
                    User usuarioLogado = (User)session.getAttribute("usuarioLogado");
                    if (usuarioLogado == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    } else {
                        ArrayList<Account> lista = (ArrayList<Account>)request.getAttribute("contas");
                %>
                <h4>Conta Corrente</h4>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome da Conta</th>
                            <th scope="col">Banco</th>
                            <th scope="col">Agência</th>
                            <th scope="col">Conta Corrente</th>
                            <th scope="col">Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getId_usuario() == usuarioLogado.getId()) {
                        %>
                                <tr>
                                    <td><%=lista.get(i).getId()%></td>
                                    <td><%=lista.get(i).getNome_conta()%></td>
                                    <td><%=lista.get(i).getBanco()%></td>
                                    <td><%=lista.get(i).getAgencia()%></td>
                                    <td><%=lista.get(i).getConta_corrente()%></td>
                                    <td>
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                            <a type="button" class="btn btn-danger" href="Controller_Account?option=excluir&id_conta=<%=lista.get(i).getId()%>">Excluir</a>
                                        </div>
                                    </td>
                                </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>
                <% } %>
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a type="button" class="btn btn-info" href="Controller_Account?option=adicionar">Cadastrar</a>
                </div>
            </div>
        </div>
        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
