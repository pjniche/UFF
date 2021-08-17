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
            <%@include file="menu-admin.jsp" %>

		    <!-- Conteúdo aqui -->
		    <h4>Cadastrar novo usuário</h4>
            <form method="POST" action="">
                <input type="hidden" maxlength="11" id="id" value="">

                <div class="mb-3">
                    <label for="Nome" class="form-label">Nome</label>
                    <input type="text" maxlength="20" class="form-control" id="nome" placeholder="Digite seu nome.">
                </div>
                <div class="form-group">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control cpf" id="cpf" placeholder="Ex: xxx.xxx.xxx-xx">
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" maxlength="255" class="form-control" id="senha" placeholder="Digite a sua senha.">
                </div>
                <div class="form-group">
                    <label for="suspenso">Suspenso?</label>
                    <input type="text" maxlength="1" class="form-control" id="suspenso"
                        placeholder="'S' para Suspenso ou 'N' para Não Suspenso.">
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
