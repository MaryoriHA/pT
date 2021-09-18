<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html" ;charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
		<title>CLIENTES </title>
	</head>
	<body>
	  <label class="font-weight-bold" style="font-size: 25px; margin-left:300px;">VISUALIZAR,EDITAR Y AGREGAR CLIENTES</label>
	<nav>
		<div class="d-flex">
			<div class="card col-som-6"style="width: 125%;">
				<div class="card-body">
					<form action="Controlador?menu=Cliente" method="POST">
                       <div class="form-row">
                           <div class="form-group col-md-3">
                              <label>NOMBRE: </label>
                              <input type="text" value="${cliente.getNom()}" name="txtNombre" class="form-control" >
                           </div>
                              <div class="form-group col-md-3">
                              <label >DNI: </label>
                              <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                           </div>
                           <div class="form-group col-md-2">
                              <label >DIRECCION:</label>
                              <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control" >
                           </div>
                           <div class="form-group col-md-2">
                              <label>ESTADO:</label>
                              <input type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control" >
                           </div>
                           <div class="form-group mb-2">
                              <div style="padding: .5em" class="parrafo"><p><p/>
                              </div>
                           <input type="submit"  name="accion" value="Agregar" class="btn btn-info">
						   <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
						</div>
                        </div>
                      </form>
				</div>
			</div>
			</nav>
			<div>
			<table class="table">
 			 <thead class="thead-light">
 			   <tr>
 			     <th scope="col">ID</th>
 			     <th scope="col">NOMBRE</th>
 			     <th scope="col">DNI</th>
 			     <th scope="col">DIRECCION</th>
 			     <th scope="col">ESTADO</th>
 			     <th scope="col">ACCIONES</th>
 			   </tr>
 			 </thead>
             <tbody>
				<c:forEach var="cl" items="${clientes}">
				<tr>
					<td>${cl.getId()}</td>
					<td>${cl.getNom()}</td>
					<td>${cl.getDni()}</td>
					<td>${cl.getDireccion()}</td>
					<td>${cl.getEstado()}</td>
					<td>
						<a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=<c:out value="${cl.getId()}"/>">Editar</a>
						<a class="btn btn-danger"href="Controlador?menu=Cliente&accion=Delete&id=<c:out value="${cl.getId()}"/>">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
			</div>
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
		</div>
	</body>
</html>