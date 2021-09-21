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
            <%@include file="navbar-admin.jsp" %>

		    <!-- Conteúdo aqui -->
            <div class="col-8 mt-5">
                <%
                    User usuarioLogado = (User)session.getAttribute("usuarioLogado");
                    if (usuarioLogado == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    } User aux = (User)request.getAttribute("usuario");
                %>
                <form method="POST" action="Controller_User">
                    <div class="mb-3">
                        <label for="nome" class="form-label"><h5>ID: <%=aux.getId()%></h5></label>
                        <input type="hidden" maxlength="11" class="form-control" name="id" id="id" value="<%=aux.getId()%>" required>
                        <br>
                        <label for="nome" class="form-label">Usuário: <%=aux.getNome()%></label>
                        <input type="text" maxlength="20" class="form-control" name="nome" id="nome" placeholder="Digite o NOVO nome do usuário." required>
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF: <%=aux.getCpf()%></label>
                        <input type="hidden" class="form-control cpf" name="cpf" id="cpf" value="<%=aux.getCpf()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha: <%=aux.getSenha()%></label>
                        <input type="password" maxlength="255" class="form-control" name="senha" id="senha" placeholder="Digite a NOVA senha do usuário." required>
                    </div>
                    <div class="form-group">
                        <label for="suspenso">Acesso Suspenso? <%=aux.getSuspenso()%></label>
                        <input type="text" maxlength="1" class="form-control" name="suspenso" id="suspenso" placeholder="'S' para Suspenso ou 'N' para Não Suspenso." onkeydown="upperCaseF(this)" required>
                    </div>
                    <button type="submit" class="btn btn-info">Editar Usuário Cadastrado</button>
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
