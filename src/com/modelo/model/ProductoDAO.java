package com.modelo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.model.Conexion;

public class ProductoDAO {
	Conexion cn=new Conexion();
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	int r;//respuesta
	public List listar(){
		String sql="select * from producto";
		List<Producto>lista=new ArrayList<>();
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Producto pr = new Producto();
				pr.setId(rs.getInt(1));
				pr.setNom(rs.getString(2));
				pr.setPrec(rs.getString(3));
				pr.setStock(rs.getString(4));
				pr.setEstado(rs.getString(5)) ;
				lista.add(pr);
			}
		} catch (Exception e) {
			
		}
		return lista;
	}
	
	public int agregar(Producto em) {
		String sql="insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getNom());
			ps.setString(2, em.getPrec());
			ps.setString(3, em.getStock());
			ps.setString(4, em.getEstado());
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}
	
	public Producto listarId(int id) {
		Producto emp = new Producto();
		String sql= "select * from producto where IdProducto="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setNom(rs.getString(2));
				emp.setPrec(rs.getString(3));
				emp.setStock(rs.getString(4));
				emp.setEstado(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return emp;
	}
	public int actualizar(Producto em) {
		String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getNom());
			ps.setString(2, em.getPrec());
			ps.setString(3, em.getStock());
			ps.setString(4, em.getEstado());
			ps.setInt(5, em.getId());
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}
	
	public void delete(int id) {
		String sql="delete from producto where IdProducto="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	public Producto buscar(int id) {
		Producto emp = new Producto();
		String sql= "select * from producto where IdProducto="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setNom(rs.getString(2));
				emp.setPrec(rs.getString(3));
				emp.setStock(rs.getString(4));
				emp.setEstado(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return emp;
	}

	public int actualizarstock(int id, int stock) {
		String sql="update producto set Stock=? where IdProducto=?";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}


}
