<%@page import="aplication.User"%>
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
                    User usuarioLogado = (User)session.getAttribute("usuarioLogado");
                    if (usuarioLogado == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }
                %>
                <form method="POST" action="Controller_Transaction">
                    <input type="hidden" maxlength="11" class="form-control" name="id_conta" id="id_conta" value="" required>
                    <div class="form-group">
                        <label for="id_categoria">Categoria <-- Falta implementar!</label>
                        <select class="form-control" name="id_categoria" id="id_categoria" required>
                            <option>fazer um "for"</option>
                            <option>da lista de categorias</option>
                            <option>aqui!</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="valor">Valor</label>
                        <input type="text" maxlength="10" class="form-control money2" name="valor" id="valor" placeholder="Digite aqui o valor." required>
                    </div>
                    <div class="form-group">
                        <label for="operacao">Operação</label>
                        <input type="text" maxlength="1" class="form-control" name="operacao" id="operacao" placeholder="'C' para Crédito ou 'D' para Débito." required>
                    </div>
                    <div class="form-group">
                        <label for="data">Data <-- Falta implementar!</label>
                        <input type="text" maxlength="" class="form-control" name="data" id="data" placeholder="Digite aqui." required>
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
    </body>
</html>
