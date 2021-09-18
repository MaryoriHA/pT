package com.config.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection jdbcConnection;
    private String jdbcURL="jdbc:mysql://localhost:3306/bd_ventas";
    private String jdbcUsername="root";
    private String jdbcPassword="root";
    
	public Connection conectar() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
		return jdbcConnection;
    }
     
    public void desconectar() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

	public Connection getJdbcConnection() {
		return jdbcConnection;
	}  

}
	
	/*
public class Conexion {
	
	Connection con;
	String url="jdbc:mysql://localhost::3306/bd_ventas";
	String user="root";
	String pass="root";
	public Connection Conexion(){
		try {/*realizar una conexion*/
	/*		Class.forName("com.mysql.cj.jdbc.Driver");//direccion
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("Hola Mundo");
		} catch (Exception e) {
			
		}
		return con;
	}
} */