package com.modelo.model;

public class Cliente {
	int id;
	String nom;
	String direccion;
	String estado;
	String dni;
    
	public Cliente() {}
	
	public Cliente(int id, String nom,String direccion, String estado, String dni) {
		this.direccion=direccion;
		this.dni=dni;
		this.estado=estado;
		this.id=id;
		this.nom=nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


}
