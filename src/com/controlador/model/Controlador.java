package com.controlador.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.model.Empleado;
import com.modelo.model.EmpleadoDAO;

import com.modelo.model.Producto;
import com.modelo.model.ProductoDAO;

import com.modelo.model.Cliente;
import com.modelo.model.ClienteDAO;

import com.modelo.model.Venta;
import com.modelo.model.VentaDAO;
import com.config.model.GenerarSerie;
/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	
	Empleado em=new Empleado();
	EmpleadoDAO edao=new EmpleadoDAO();
	Producto pr=new Producto();
	ProductoDAO pdao= new ProductoDAO();
	Cliente cl= new Cliente();
	ClienteDAO cdao= new ClienteDAO();
	
	int ide;
	int idc;
	int idp;
	Venta v=new Venta();
	List<Venta>lista=new ArrayList<>();
	
	int item;
	int cod;
	String descripcion;
	Double precio;
	int cant;
	double subtotal;
	double totalPagar;
	
	String numeroserie;
	VentaDAO vdao=new VentaDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menu=request.getParameter("menu");
		String accion = request.getParameter("accion");
		if(menu.equals("Principal")) {
			request.getRequestDispatcher("Principal.jsp").forward(request, response);}
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");

		if(menu.equals("Principal")) {
			request.getRequestDispatcher("Principal.jsp").forward(request, response);}		

		if(menu.equals("Cliente")) {
			switch (accion) {
			case "Listar":
				List lista = cdao.listar();
				request.setAttribute("clientes", lista);
				break;
				
			case "Agregar":
				String nom=request.getParameter("txtNombre");
				String dni=request.getParameter("txtDni");
				String dir=request.getParameter("txtDireccion");
				String est=request.getParameter("txtEstado");
				cl.setNom(nom);
				cl.setDni(dni);
				cl.setDireccion(dir);
				cl.setEstado(est);
				cdao.agregar(cl);
		 		request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;

			case "Editar":
				ide=Integer.parseInt(request.getParameter("id"));
				Cliente e=cdao.listarId(ide);
				request.setAttribute("cliente", e);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
				
			case "Actualizar":
				String nom1=request.getParameter("txtNombre");
				String dni1=request.getParameter("txtDni");
				String dir1=request.getParameter("txtDireccion");
				String est1=request.getParameter("txtEstado");
				cl.setNom(nom1);
				cl.setDni(dni1);
				cl.setDireccion(dir1);
				cl.setEstado(est1);
				cl.setId(ide);
				cdao.actualizar(cl);
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;
				
			case "Delete":
				ide=Integer.parseInt(request.getParameter("id"));
				cdao.delete(ide);	
				request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
				break;

			default:
				break;
			}
			request.getRequestDispatcher("Clientes.jsp").forward(request, response);
		}
		if(menu.equals("Producto")) {

			switch (accion) {
			case "Listar":
				List lista = pdao.listar();
				request.setAttribute("productos", lista);
				break;
				
			case "Agregar":
				String nom=request.getParameter("txtNombre");
				String prec=request.getParameter("txtPrecio");
				String stock=request.getParameter("txtStock");
				String est=request.getParameter("txtEstado");
				pr.setNom(nom);
				pr.setPrec(prec);
				pr.setStock(stock);
				pr.setEstado(est);
				pdao.agregar(pr);
		 		request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			case "Editar":
				ide=Integer.parseInt(request.getParameter("id"));
				Producto e=pdao.listarId(ide);
				request.setAttribute("producto", e);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;
				
			case "Actualizar":
				String nom1=request.getParameter("txtNombre");
				String prec1=request.getParameter("txtPrecio");
				String stock1=request.getParameter("txtStock");
				String est1=request.getParameter("txtEstado");
				pr.setNom(nom1);
				pr.setPrec(prec1);
				pr.setStock(stock1);
				pr.setEstado(est1);
				pr.setId(ide);
				pdao.actualizar(pr);
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;
				
			case "Delete":
				ide=Integer.parseInt(request.getParameter("id"));
				pdao.delete(ide);	
				request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
				break;

			default:
				break;
			}
			
			request.getRequestDispatcher("Producto.jsp").forward(request, response);
		}
		if(menu.equals("NuevaVenta")) {
			switch(accion) {
			    case "BuscarCliente":
			    	String dni=request.getParameter("codigocliente");
			    	cl.setDni(dni);
			    	cl=cdao.buscar(dni);
			    	request.setAttribute("c", cl);
			    	numeroserie=vdao.GenerarSerie();
			    	if(numeroserie==null) {
			    		numeroserie="00000001";
			    		request.setAttribute("nserie", numeroserie);
			    	}
			    	else {
			    		int incrementar=Integer.parseInt(numeroserie);
			    		GenerarSerie gs= new GenerarSerie();
			    		numeroserie=gs.NumeroSerie(incrementar);
			    		request.setAttribute("nserie", numeroserie);		
			    	}
			    break;
			    case "BuscarProducto":
			    	String dni1=request.getParameter("codigocliente");
			    	cl.setDni(dni1);
			    	cl=cdao.buscar(dni1);
			    	request.setAttribute("c", cl);
			    	int id=Integer.parseInt(request.getParameter("codigoproducto"));
			    	pr=pdao.listarId(id);
			    	request.setAttribute("producto", pr);
			    	request.setAttribute("totalpagar", totalPagar);
			    	request.setAttribute("lista", lista);
			    	numeroserie=vdao.GenerarSerie();
			    	if(numeroserie==null) {
			    		numeroserie="00000001";
			    		request.setAttribute("nserie", numeroserie);
			    	}
			    	else {
			    		int incrementar=Integer.parseInt(numeroserie);
			    		GenerarSerie gs= new GenerarSerie();
			    		numeroserie=gs.NumeroSerie(incrementar);
			    		request.setAttribute("nserie", numeroserie);		
			    	}
			    	break;
			    case "Agregar":
			    	String dni12=request.getParameter("codigocliente");
			    	cl.setDni(dni12);
			    	cl=cdao.buscar(dni12);
			    	request.setAttribute("c", cl);
			    	totalPagar=0.0;
			    	item=item+1;
			    	cod=pr.getId();
			    	descripcion=request.getParameter("nomproducto");
			    	precio=Double.parseDouble(request.getParameter("precio"));
			    	cant=Integer.parseInt(request.getParameter("cant"));
			    	subtotal=precio*cant;
			    	v=new Venta();
			    	v.setItem(item);
			    	v.setIdproducto(cod);
			    	v.setDescripcionP(descripcion);
			    	v.setPrecio(precio);
			    	v.setCantidad(cant);
			    	v.setSubtotal(subtotal);
			    	lista.add(v);
			    	for(int i=0;i<lista.size();i++) {
			    		totalPagar+=lista.get(i).getSubtotal();
			    	}
			    	request.setAttribute("totalpagar", totalPagar);
			    	request.setAttribute("lista", lista);
			    	numeroserie=vdao.GenerarSerie();
			    	if(numeroserie==null) {
			    		numeroserie="00000001";
			    		request.setAttribute("nserie", numeroserie);
			    	}
			    	else {
			    		int incrementar=Integer.parseInt(numeroserie);
			    		GenerarSerie gs= new GenerarSerie();
			    		numeroserie=gs.NumeroSerie(incrementar);
			    		request.setAttribute("nserie", numeroserie);		
			    	}
			    	break;
			    	
		    case "cancelar":

		    	lista.clear();
		    	break;
					
					/*ide=Integer.parseInt(request.getParameter("item"));
					for(int i=0;i<lista.size();i++) {
						if(lista.get(i).getItem()== ide) {
							lista.remove(i);
							break;
						}
			    	}

					break;
*/					
			    case "GenerarVenta":
			    	//actualizar stock
			    	for( int i=0; i< lista.size();i++)
			    	{
			    		Producto pr=new Producto();
			    		int cantidad= lista.get(i).getCantidad();
			    		int idproducto=lista.get(i).getIdproducto();
			    	    ProductoDAO ao= new ProductoDAO();
			    	    pr=ao.buscar(idproducto);
			    	    int numStock = Integer.parseInt(pr.getStock());
			    	    int sac= (numStock- cantidad);
			    	    ao.actualizarstock(idproducto, sac);
			    	}
			    	
			    	//guardar venta
			    	v.setIdcliente(cl.getId());
			    	v.setIdempleado(1);
			    	v.setNumserie(numeroserie);
			    	v.setFecha("2020-08-17");
			    	v.setEstado("1");
			    	vdao.guardarVenta(v);
			    	//guardar detalle ventas
			    	int idv=Integer.parseInt(vdao.IdVentas());
			    	for( int i=0; i< lista.size();i++)
			    	{
			    		v=new Venta();
			    		v.setId(idv);
			    		v.setIdproducto(lista.get(i).getIdproducto());
			    		v.setCantidad(lista.get(i).getCantidad());
			    		v.setPrecio(lista.get(i).getPrecio());
			    		vdao.guardarDetalleventas(v);
			    	}
			    	lista.clear();
			    	break;
			    default:
			    	//numero de serie 
			    	numeroserie=vdao.GenerarSerie();
			    	if(numeroserie==null) {
			    		numeroserie="00000001";
			    		request.setAttribute("nserie", numeroserie);
			    	}
			    	else {
			    		int incrementar=Integer.parseInt(numeroserie);
			    		GenerarSerie gs= new GenerarSerie();
			    		numeroserie=gs.NumeroSerie(incrementar);
			    		request.setAttribute("nserie", numeroserie);		
			    	}
			    
					request.getRequestDispatcher("venta.jsp").forward(request, response);
			}
			request.getRequestDispatcher("venta.jsp").forward(request, response);
		}
		if(menu.equals("Empleado")) {
				switch (accion) {
				case "Listar":
					List lista = edao.listar();
					request.setAttribute("empleados", lista);
					break;
					
				case "Agregar":
					String dni=request.getParameter("txtDni");
					String nom=request.getParameter("txtNombres");
					String tel=request.getParameter("txtTel");
					String est=request.getParameter("txtEstado");
					String user=request.getParameter("txtUser");
					em.setDni(dni);
					em.setNom(nom);
					em.setTel(tel);
					em.setEstado(est);
					em.setUser(user);
					edao.agregar(em);
			 		request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;

				case "Editar":
					ide=Integer.parseInt(request.getParameter("id"));
					Empleado e=edao.listarId(ide);
					request.setAttribute("empleado", e);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
					
				case "Actualizar":
					String dni1=request.getParameter("txtDni");
					String nom1=request.getParameter("txtNombres");
					String tel1=request.getParameter("txtTel");
					String est1=request.getParameter("txtEstado");
					String user1=request.getParameter("txtUser");
					em.setDni(dni1);
					em.setNom(nom1);
					em.setTel(tel1);
					em.setEstado(est1);
					em.setUser(user1);
					em.setId(ide);
					edao.actualizar(em);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
					
				case "Delete":
					ide=Integer.parseInt(request.getParameter("id"));
					edao.delete(ide);	
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;

				default:
					break;
				}
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			}
		
	}}
