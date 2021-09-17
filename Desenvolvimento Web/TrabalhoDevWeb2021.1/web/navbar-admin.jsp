<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Menu de navegacao apos logado no sistema -->
<p>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="dashboard-admin.jsp">Início</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
        			<li class="nav-item">
						<a class="nav-link" href="Controller_User?option=listar">Usuários Cadastrados</a>
        			</li>
					<li class="nav-item">
          				<a class="nav-link" href="Controller_Category?option=adicionar">Cadastrar Categoria</a>
        			</li>
					<li class="nav-item">
						<a class="nav-link" href="Controller_User?option=adicionar">Cadastrar Usuário</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="Controller_Admin?option=adicionar">Cadastrar Administrador</a>
        			</li>
					<li class="nav-item">
          				<a class="nav-link" href="Logout">Logout</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>
</p>
<!-- Tratar as requisições GET! -->
