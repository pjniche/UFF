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
                %>
		        <h4>Cadastrar nova conta</h4>
                <form method="POST" action="Controller_Account">
                    <div class="mb-3">
                        <label for="id_usuario" class="form-label">Id Usuário</label>
                        <input type="number" maxlength="11" class="form-control" id="id_usuario" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="nome_conta">Nome da Conta</label>
                        <input type="text" maxlength="20" class="form-control" id="nome_conta" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="banco">Banco</label>
                        <input type="text" maxlength="3" class="form-control" id="banco" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="agencia">Agência</label>
                        <input type="text" maxlength="6" class="form-control" id="agencia" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="conta_corrente">Conta Corrente</label>
                        <input type="text" maxlength="6" class="form-control" id="conta_corrente" placeholder="Digite aqui." required>
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
