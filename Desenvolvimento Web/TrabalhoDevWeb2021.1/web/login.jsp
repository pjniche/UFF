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
            <%@include file="menu-home.jsp" %>

            <!-- Conteúdo aqui -->
		    <h3>Acessar o Sistema</h3>
		    <form method="POST" action="ValidarLogin" name="ValidaForm">
			    
                <div class="form-group">
				    <label for="cpf">CPF</label>
				    <input type="text" class="form-control cpf" id="cpf" placeholder="Ex: xxx.xxx.xxx-xx">
			    </div>

			    <div class="form-group">
				    <label for="senha">Senha</label>
				    <input type="password" maxlength="255" class="form-control" id="senha" placeholder="Digite a sua senha.">
			    </div>

			    <button type="submit" class="btn btn-primary">Login</button>
		    </form>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
