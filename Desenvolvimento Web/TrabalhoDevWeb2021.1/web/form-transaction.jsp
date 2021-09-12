<%@page import="aplication.Transaction"%>
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
                    Transaction aux = (Transaction)request.getAttribute("lancamento");
                %>
		        <h4>Adicionar lançamento</h4>
                <form method="POST" action="Controller_Transaction">
                    <div class="mb-3">
                        <label for="id_conta" class="form-label">Id Conta</label>
                        <input type="number" maxlength="11" class="form-control" id="id_conta" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="id_categoria">Id Categoria</label>
                        <input type="number" maxlength="11" class="form-control" id="id_categoria" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor</label>
                        <input type="" maxlength="" class="form-control" id="valor" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="operacao">Operação</label>
                        <input type="text" maxlength="1" class="form-control" id="operacao" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="data">Data</label>
                        <input type="" maxlength="" class="form-control" id="data" placeholder="Digite aqui." required>
                    </div>
                    <div class="form-group">
                        <label for="descricao">Descrição</label>
                        <input type="" maxlength="" class="form-control" id="descricao" placeholder="Digite aqui. (Opcional)">
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
