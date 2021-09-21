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
            <div class="col-8 mt-5">
                <%
                    User usuarioLogado = (User)session.getAttribute("usuarioLogado");
                    if (usuarioLogado == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                %>
                <form method="POST" action="Controller_Account">
                    <input type="hidden" maxlength="11" class="form-control" name="id" id="id" value="0" required>
                    <input type="hidden" maxlength="11" class="form-control" name="id_usuario" id="id_usuario" value="<%=usuarioLogado.getId()%>" required>
                    <div class="form-group">
                        <label for="nome_conta">Nome da Conta</label>
                        <input type="text" maxlength="20" class="form-control" name="nome_conta" id="nome_conta" placeholder="Digite um nome para a conta." required>
                    </div>
                    <div class="form-group">
                        <label for="banco">Banco</label>
                        <input type="text" maxlength="3" class="form-control" name="banco" id="banco" placeholder="Digite o número do banco." required>
                    </div>
                    <div class="form-group">
                        <label for="agencia">Agência</label>
                        <input type="text" maxlength="6" class="form-control" name="agencia" id="agencia" placeholder="Digite o número da agência." required>
                    </div>
                    <div class="form-group">
                        <label for="conta_corrente">Conta Corrente</label>
                        <input type="text" maxlength="6" class="form-control" name="conta_corrente" id="conta_corrente" placeholder="Digite o número da conta corrente." required>
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
