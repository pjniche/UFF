<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Menu de navegacao apos logado no sistema -->
<p>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">Home</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
        			<li class="nav-item">
          				<a class="nav-link" href="Controller_Admin?option=adicionar">Adicionar Administrador</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="form-user.jsp">Adicionar Usuário</a>
        			</li>
        			<li class="nav-item">
          				<a class="nav-link" href="form-category.jsp">Adicionar Categoria</a>
        			</li>
					<li class="nav-item">
          				<a class="nav-link" href="#">Logout</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	</nav>
</p>