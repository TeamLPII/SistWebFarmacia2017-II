<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Login - SysFarma</title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilos.css">
	<link rel="stylesheet" href="css/extras.css">
</head>
<body>

	<header class="container-fluid">
		<div class="header row bg-info">
			<div class="col text-center">
				<h1 class="text-white">Bienvenido a SysFarma</h1>
			</div>
		</div>
	</header>

	

	<div class="container pt-3">
		<div class="row justify-content-sm-center">
			<div class="col-sm-10 col-md-6">
				<div class="card border-info">
					<div class="card-header">Inicie sesión para ingresar al sistema</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-4 text-center">
<!-- 								<img src="https://placeimg.com/128/128/tech/sepia"> -->
								<img id="login-icon" src="img/color/users-2.svg">
<!-- 								<h4 class="text-center">Hunger & Debt Ltd</h4> -->
							</div>
							<div class="col-md-8">
								<form class="form-signin" action="ServletEmpleado?tipo=login" method="post">
									<input type="text" class="form-control mb-2"
										placeholder="Usuario" name="txtusuario" required autofocus> 
									<input type="password" class="form-control mb-2"
										placeholder="Contraseña" name="txtclave" required>
									<button class="btn btn-lg btn-primary btn-block mb-1"
										type="submit" id="btnlogin" >Iniciar</button>
									 
								</form>
							</div>
							<!-- Mensaje de error -->
							<%
							if (request.getAttribute("msg") != null){ %>
								<div class="col-md-12 pt mt-2">
									<div class="alert alert-danger">
										<strong>Error!</strong> ${requestScope.msg}
									</div>
								</div>
							<%
							} %>
							
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>

	<!-- FOOOTER -->
    <footer class="container-fluid">
        <div class="footer row align-items-center bg-secondary">
        <div class="col pb-2">
            <h2 class="text-white">SysFarma | 2017 | Cibertec - SJL</h2>
        </div>
        </div>
    </footer>
    <!-- END FOOOTER -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.js"></script>
<!--     <script type="text/javascript" src="js/jquery.validate.min.js"></script> -->
<!-- 	<script type="text/javascript" src="js/validacion.js"></script> -->

</body>
</html>
	