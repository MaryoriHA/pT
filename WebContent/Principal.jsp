<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<title>Welcome</title>
		<meta name ="viewport" content ="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src ="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src ="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>
	
      <div class="row">
           <div >
           <nav class ="navbar bg-dark" style="width: 230px;height: 620px;">		
		    <ul class="navbar-nav">
				  <div class="nav-item">
				  <li class="nav-item">
		            <a style="margin-left:-30px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;" class="btn btn-outline-light " href="#" >${usuario.getNom()}</a>
		              </li>
		            <li class="nav-item">
		            <a style="margin-left:15px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;" class="btn btn-outline-light " href="#" >${usuario.getUser()}</a>
		            </li>
		            <li class="nav-item" href="#" style="margin-left:60px;border:none height: 50px;">
				    	<img alt="100" width="100" src="img/user2.png">
				    </li>
		            <li class="nav-item">
		            <a style="margin-left:-30px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 2.5px;" class="btn btn-outline-light " href="#" >${usuario.getUser()}@gmail.com</a>
		            </li>				    
				    <div class="nav-item"></div>
				    
				  </div>
		      <li class="nav-item active">
		        <a style="margin-left:-20px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;" class="btn btn-outline-light " href="home.jsp" target="myFrame" >Home</a>
		      </li>
		      <li class="nav-item">
		        <a style="margin-left:-20px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
		      </li>
		      <li class="nav-item">
		        <a style="margin-left:-20px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;"  class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
		      </li>
		      <li class="nav-item">
		        <a style="margin-left:-20px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
		      </li>
		      <li class="nav-item">
		        <a style="margin-left:-20px;height: 50px;border:none;text-indent: 50px;text-align:justify;letter-spacing: 3px;" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
		      </li>
		      <form action="Validar" method="POST">
				    	<button name="accion" value="salir" class="nav-item" style="margin-left:40px;height: 50px;border:none;text-indent: 5px;text-align:justify;letter-spacing: 3px;" href="#">Salir</button>
				    </form>
		    </ul>
		</nav>
		</div>
		<div class="col-9" style="margin-left:-10px;">
		    <p></p>
			<iframe name="myFrame" style="height: 100%; width: 1100px;border:none;"></iframe>
		</div>
		</div>
		
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	</body>
</html>