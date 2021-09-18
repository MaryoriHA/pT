<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Ventas</title>
        <style >
           @media print{
             .parte01, .btn , .accion{
                 display:none;
             }
           }
        </style>
</head>
<body>
   <label class="font-weight-bold" style="font-size: 25px; margin-left:400px;">GENERAR NUEVA VENTA</label>
   <div class="d-flex">
        <div class= "col-lg-5 parte01" >
            <div class="card">
                <form action="Controlador?menu=NuevaVenta" method="post">
                  <div class="card-body">
                       <div class="form-group font-weight-bold">
                            <label>Datos del Cliente</label>
                       </div>
                       <div class="form-group d-flex">
                           <div class="col-sm-4 ">
                               <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                               
                           </div>
                           <div class="col-sm-2.5">
                               <button type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info ">Buscar </button>
                           </div>
                           <div class="col-sm-6">
                             <input type="text" name="nombrescliente" value="${c.getNom()}" placeholder="Datos Cliente" class="form-control" >                          
                           </div>                        
                       </div>
                       <div class="form-group font-weight-bold">
                       <label>Datos Producto</label>
                       </div>
                       <div class="form-group d-flex">
                           <div class="col-sm-4 ">
                               <input type="text" name="codigoproducto"  value="${producto.getId()}" class="form-control" placeholder="Codigo">
                           </div>
                           <div class="col-sm-4.5">
                               <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info "> Buscar </button>
                           </div>
                           <div class="col-sm-6">
                             <input type="text" name="nomproducto" value="${producto.getNom()}" placeholder="Datos Producto" class="form-control" >                          
                           </div> 
                       </div>
                       <div class="form-group d-flex">
                           <div class="col-sm-6">
                               <input type="text" name="precio"  value="${producto.getPrec()}" class="form-control" placeholder="S/. 0.00">
                           </div>
                           <div class="col-sm-3">
                               <input type="number" name="cant" value="1" placeholder="" class="form-control">
                           </div>
                           <div class="col-sm-3">
                             <input type="text" name="stock"  value="${producto.getStock()}" placeholder="Stock" class="form-control" >                          
                           </div> 
                       </div>
                       <!---AGREGAR PRODUCTO AL REGISTRO--->
                       <div class="form-group d-flex">
                         <div class="col sm">
                            <button type="submit"  name="accion" value="Agregar" class="btn btn-info">Agregar Producto </button>
                         </div>
                       </div>
                  </div>
               </form>   
            </div>
        </div>
        <div class="col-sm-7">
            <div class="card">
                 <div class="card-body">
                     <div class="d-flex col-sm-5 ml-auto" >
                       <label>Nro.Serie: </label>
                       <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                       <br></br>
                     </div> 
                     <table class="table table-hover">
                          <thead class="thead-light">
                               <tr>
                                 <th>Nro</th>
                                 <th>Codigo</th>
                                 <th>Descripcion</th>
                                 <th>Precio</th>
                                 <th>Cantidad</th>
                                 <th>SubTotal</th>
                                 <th class="accion">Acciones</th>
                               </tr>
                          </thead>
                          <tbody>
                             <c:forEach var="list" items="${lista}">
                              <tr>
                                 <td>${list.getItem()}</td>
                                 <td>${list.getIdproducto()}</td>
                                 <td>${list.getDescripcionP()}</td>
                                 <td>${list.getPrecio()}</td>
                                 <td>${list.getCantidad()}</td>
                                 <td>${list.getSubtotal()}</td>
                                 <td class="">
                                    <a href="#" class="btn btn-warning" style="height: 35px" >Editar</a>
                                    <p></p>
                                    <a href="#" class="btn btn-danger" style="height: 35px">Delete</a>
                                 </td>
                              </tr>
                              </c:forEach>
                          </tbody>
                     </table>                
                 </div>
                 <div class="card-footer d-flex">
                        <div class="col-sm-6">
                          <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                          <a href="Controlador?menu=NuevaVenta&accion=Cancelar" class="btn btn-danger">Cancelar</a>
                        </div>
                        <div class="col-sm-4 ml-auto">
                           <input type="text" name="txtTotal" value="S/.${totalpagar}" class="form-control text-center font-weight-bold">
                        </div>
                 </div>
            </div>

        </div>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
		   
   </div>
</body>
</html>