package com.leysoft.jdbcsproject.model;

import javax.validation.constraints.NotNull;

public class Producto {
	
	@NotNull
	private int id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private double precio;
	
	private TipoProducto tipoProducto;
	
	public Producto(String nombre, double precio, TipoProducto tipoProducto) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
	}
	
	public Producto(int id, String nombre, double precio, TipoProducto tipoProducto) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
}
