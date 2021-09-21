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
					<li class="nav-item dropdown">
        				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cadastrar</a>
        				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
          					<a class="dropdown-item" href="Controller_Category?option=adicionar">Categoria</a>
          					<a class="dropdown-item" href="Controller_User?option=adicionar">Usuário</a>
          					<div class="dropdown-divider"></div>
          					<a class="dropdown-item" href="Controller_Admin?option=adicionar">Administrador</a>
        				</div>
      				</li>
					<li class="nav-item">
						<a class="nav-link" href="Controller_Category?option=listar">Categorias</a>
        			</li>
					<li class="nav-item">
						<a class="nav-link" href="Controller_User?option=listar">Usuários</a>
        			</li>
					<li class="nav-item">
						<a class="nav-link" href="Controller_Admin?option=listar">Administradores</a>
        			</li>
					<li class="nav-item">
          				<a class="nav-link" href="Logout">Logout</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>
</p>
