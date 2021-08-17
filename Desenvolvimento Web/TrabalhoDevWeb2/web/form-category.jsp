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
            <h4>Cadastrar nova categoria</h4>
            <form method="POST" action="">
                <input type="hidden" maxlength="11" id="id" value="">
                
                <div class="mb-3">
                    <input type="text" maxlength="20" class="form-control" id="categoria" placeholder="Digite o nome da categoria.">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <!-- JavaScript (Opcional) -->
        <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
	    <%@include file="scripts.html" %>
    </body>
</html>
