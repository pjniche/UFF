<%@page import="aplication.User"%>
<%@page import="aplication.Account"%>
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
            <%@include file="navbar-user.jsp" %>

		    <!-- Conteúdo aqui -->
            <div class="col-8 mt-5">
                <%
                    Account conta = (Account)request.getAttribute("conta");
                    ArrayList<Category> listaCategorias = (ArrayList<Category>)request.getAttribute("categorias");
                %>
                <form method="POST" action="Controller_Transaction">
                    <input type="hidden" maxlength="11" class="form-control" name="id" id="id" value="0" required>
                    <input type="hidden" maxlength="11" class="form-control" name="id_conta" id="id_conta" value="<%=conta.getId()%>" required>
                    <div class="form-group">
                        <label for="id_categoria">Categoria</label>
                        <select class="form-control" name="id_categoria" id="id_categoria" required>
                            <% for (int i = 0; i < listaCategorias.size(); i++) { %>
                                <option><%=listaCategorias.get(i).getId()%> - <%=listaCategorias.get(i).getDescricao()%></option>
                            <% } %>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor</label>
                        <input type="text" maxlength="10" class="form-control money2" name="valor" id="valor" placeholder="Digite aqui o valor." required>
                    </div>
                    <div class="form-group">
                        <label for="operacao">Operação</label>
                        <input type="text" maxlength="1" class="form-control" name="operacao" id="operacao" placeholder="'C' para Crédito ou 'D' para Débito." onkeydown="upperCaseF(this)" required>
                    </div>
                    <div class="form-group">
                        <label for="data">Data</label>
                        <input type="date" class="form-control" name="date" id="date" required>
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição (Opcional)</label>
                        <textarea type="text" maxlength="100" class="form-control" name="descricao" id="descricao" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-info">Adicionar Lançamento</button>
                </form>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
        <script>
            function upperCaseF(key){
                setTimeout(function(){
                    key.value = key.value.toUpperCase();
                }, 1);
            }
        </script>
    </body>
</html>
