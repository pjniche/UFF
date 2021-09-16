<%@page import="aplication.User"%>
<%@page import="aplication.Account"%>
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
                    Account aux = (Account)request.getAttribute("conta");
                    User user = (User)session.getAttribute("usuarioLogado");
                %>
                <form method="POST" action="Controller_Account">
                    <input type="hidden" maxlength="11" class="form-control" name="id_usuario" id="id_usuario" value="<% user.getId(); %>" required>
                    <div class="form-group">
                        <label for="nome_conta">Nome da Conta</label>
                        <input type="text" maxlength="20" class="form-control" name="nome_conta" id="nome_conta" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="banco">Banco</label>
                        <input type="text" maxlength="3" class="form-control" name="banco" id="banco" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="agencia">Agência</label>
                        <input type="text" maxlength="6" class="form-control" name="agencia" id="agencia" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="conta_corrente">Conta Corrente</label>
                        <input type="text" maxlength="6" class="form-control" name="conta_corrente" id="conta_corrente" placeholder="Digite aqui." required>
                    </div>
                    <button type="submit" class="btn btn-info">Cadastrar Conta Corrente</button>
                </form>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
