package com.modelo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.model.Conexion;

public class ClienteDAO {

	Conexion cn=new Conexion();
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	int r;//respuesta
	
	public Cliente buscar(String dni) {
		Cliente c=new Cliente();
		String sql="Select * from cliente where Dni="+dni;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			 while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setDni(rs.getString(2));
				c.setNom(rs.getString(3));
				c.setDireccion(rs.getString(4));
				c.setEstado(rs.getString(5)) ;
				 
			 }
		}catch (Exception e) {
			
		}
		
		return c;
	}
	
	//operaciones CRUD
	
	public List listar(){
		String sql="select * from cliente";
		List<Cliente>lista=new ArrayList<>();
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Cliente em = new Cliente();
				em.setId(rs.getInt(1));
				em.setDni(rs.getString(2));
				em.setNom(rs.getString(3));
				em.setDireccion(rs.getString(4));
				em.setEstado(rs.getString(5)) ;
				lista.add(em);
			}
		} catch (Exception e) {
			
		}
		return lista;
	}
	
	public int agregar(Cliente em) {
		String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getDni());
			ps.setString(2, em.getNom());
			ps.setString(3, em.getDireccion());
			ps.setString(4, em.getEstado());
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}

	
	public Cliente listarId(int id) {
		Cliente emp = new Cliente();
		String sql= "select * from cliente where IdCliente="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp.setDni(rs.getString(2));
				emp.setNom(rs.getString(3));
				emp.setDireccion(rs.getString(4));
				emp.setEstado(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return emp;
	}
	
	public int actualizar(Cliente em) {
		String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getDni());
			ps.setString(2, em.getNom());
			ps.setString(3, em.getDireccion());
			ps.setString(4, em.getEstado());
			ps.setInt(5, em.getId());
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}
	
	public void delete(int id) {
		String sql="delete from cliente where IdCliente="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
