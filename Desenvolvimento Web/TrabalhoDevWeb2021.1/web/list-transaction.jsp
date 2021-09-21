<%@page import="aplication.User"%>
<%@page import="aplication.Account"%>
<%@page import="aplication.Category"%>
<%@page import="aplication.Transaction"%>
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
                        ArrayList<Transaction> listaLancamentos = (ArrayList<Transaction>)request.getAttribute("lancamentos");
                        ArrayList<Category> listaCategorias = (ArrayList<Category>)request.getAttribute("categorias");
                        ArrayList<Account> listaContas = (ArrayList<Account>)request.getAttribute("contas");
                        String nomeCategoria = new String();
                        String nomeOperacao = new String();
                        String porcentagem = new String();
                        Double totalCredito = 0.0;
                        Double totalDebito = 0.0;
                        Double subtotal = 0.0;
                %>
                    <h4>Extrato</h4>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Data</th>
                                <th scope="col">Operação</th>
                                <th scope="col">Valor</th>
                                <th scope="col">Categoria</th>
                                <th scope="col">Descrição</th>
                                <th scope="col">Percentual</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%  for (int i = 0; i < listaLancamentos.size(); i++) {
                                    if (listaLancamentos.get(i).getOperacao().equals("C")) {
                                        totalCredito += listaLancamentos.get(i).getValor();
                                    } else {
                                        totalDebito += listaLancamentos.get(i).getValor();
                                    }
                                }
                                for (int i = 0; i < listaLancamentos.size(); i++) {
                                    for (int j = 0; j < listaCategorias.size(); j++) {
                                        if (listaLancamentos.get(i).getId_categoria() == listaCategorias.get(j).getId()) {
                                            nomeCategoria = listaCategorias.get(j).getDescricao();
                                        }
                                    }
                                    if (listaLancamentos.get(i).getOperacao().equals("C")) {
                                        nomeOperacao = "Crédito";
                                        porcentagem = String.format("%.2f", (100 / totalCredito) * listaLancamentos.get(i).getValor());
                                        porcentagem += "% dos Créditos.";
                                        subtotal += listaLancamentos.get(i).getValor();
                                    } else {
                                        nomeOperacao = "Débito";
                                        porcentagem = String.format("%.2f", (100 / totalDebito) * listaLancamentos.get(i).getValor());
                                        porcentagem += "% dos Débitos.";
                                        subtotal -= listaLancamentos.get(i).getValor();
                                    }
                            %>
                                <tr>
                                    <td><%=listaLancamentos.get(i).getData()%></td>
                                    <td><%=nomeOperacao%></td>
                                    <td>R$: <%=listaLancamentos.get(i).getValor()%></td>
                                    <td><%=nomeCategoria%></td>
                                    <td><%=listaLancamentos.get(i).getDescricao()%></td>
                                    <td ><%=porcentagem%></td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>

                    <!-- Novo lançamento -->
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <a type="button" class="btn btn-info" href="Controller_Transaction?option=adicionar&id_usuario=<%=usuarioLogado.getId()%>">Novo Lançamento</a>
                    </div>
                    <p></p>

                    <!-- Subtotal e alerta de saldo negativo -->
                    <% if (subtotal < 0) { %>
                        <div class="alert alert-danger" role="alert">
                            <h1>R$: <%=subtotal%></h1>
                            <h3>Alerta: Saldo Negativo!<h3>
                        </div>
                    <%  } else { %>
                        <div class="alert alert-secondary" role="alert">
                            <h1>R$: <%=subtotal%></h1>
                        </div>
                    <%  } %>            
                <%  } %>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
