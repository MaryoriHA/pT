package com.modelo.model;

public class Producto {
    int id;
  	String nom;
  	String prec;
  	String stock;
  	String estado;
  	
  	public Producto() {
  		
  	}
  	
  	public Producto(int id, String nom,String prec,String stock,String estado) {
  		this.id=id;
  		this.nom=nom;
  		this.prec=prec;
  		this.stock=stock;
  		this.estado=estado;
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

	public String getPrec() {
		return prec;
	}

	public void setPrec(String prec) {
		this.prec = prec;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
  	
  	
}
