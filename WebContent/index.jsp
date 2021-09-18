<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	  <style>
    body  {
        background-image:url("https://hdwallsource.com/img/2014/9/blur-26347-27038-hd-wallpapers.jpg"); background-repeat:no-repeat; background-position:center; background-size:cover; padding:10px;}
</style>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<title>Index</title>
	</head>
	<body>
		<div class="container mt-4 col-lg-4"> <!-- mt=margin top col-lg:tamaño de columna-->
			<div class="card col-sm-10"> <!-- columna -->
				<div class="card-body">
					<form class="form-sign" action="Validar" method="POST">
						<div class="form-group text-center" > <!-- texto centrado -->
							<h3>Login</h3>
							<img alt="70" width="170" src="img/logo.jpg">
							<label>Bienvendos al Sistema</label>
						</div>
						<div class="form-group">
							<label>Usuario:</label>
							<input type="text" name="txtuser" class="form-control">
						</div>
						<div class="form-group">
							<label>Password:</label>
							<input type="password" name="txtpass" class="form-control"> 
						</div>
						<input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
					</form>
				</div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	</body>
</html>