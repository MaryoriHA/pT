package com.modelo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.config.model.Conexion;
//dao esta asemejado como base de datos
public class EmpleadoDAO {
	Conexion cn=new Conexion();
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	int r;//respuesta
	
	public Empleado validar(String user, String dni) {
		Empleado em=new Empleado();
		String sql="SELECT * FROM empleado where User=? and Dni=? ";//consulta sql
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1,user);
			ps.setString(2,dni);
			rs=ps.executeQuery();
			while(rs.next()) {
				em.setId(rs.getInt("IdEmpleado"));
				em.setUser(rs.getString("User"));
				em.setDni(rs.getString("Dni"));
				em.setNom(rs.getString("Nombres"));
		
			}
		} catch (Exception e) {
		}
		return em;
	}
	
	//operaciones CRUD
	
	public List listar(){
		String sql="select * from empleado";
		List<Empleado>lista=new ArrayList<>();
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Empleado em = new Empleado();
				em.setId(rs.getInt(1));
				em.setDni(rs.getString(2));
				em.setNom(rs.getString(3));
				em.setTel(rs.getString(4));
				em.setEstado(rs.getString(5)) ;
				em.setUser(rs.getString(6));
				lista.add(em);
			}
		} catch (Exception e) {
			
		}
		return lista;
	}
	
	public int agregar(Empleado em) {
		String sql="insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getDni());
			ps.setString(2, em.getNom());
			ps.setString(3, em.getTel());
			ps.setString(4, em.getEstado());
			ps.setString(5, em.getUser());
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}

	
	public Empleado listarId(int id) {
		Empleado emp = new Empleado();
		String sql= "select * from empleado where IdEmpleado="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				emp.setDni(rs.getString(2));
				emp.setNom(rs.getString(3));
				emp.setTel(rs.getString(4));
				emp.setEstado(rs.getString(5));
				emp.setUser(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return emp;
	}
	
	public int actualizar(Empleado em) {
		String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getDni());
			ps.setString(2, em.getNom());
			ps.setString(3, em.getTel());
			ps.setString(4, em.getEstado());
			ps.setString(5, em.getUser());
			ps.setInt(6, em.getId());
			ps.executeUpdate();
		} catch (Exception e ) {
			// TODO: handle exception
		}
		return r;//retorna respuesta
	}
	
	public void delete(int id) {
		String sql="delete from empleado where IdEmpleado="+id;
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
