package com.leysoft.jdbcsproject.model;

public class TipoProducto {
	private int id;
	private String nombre;

	public TipoProducto(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoProducto(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
