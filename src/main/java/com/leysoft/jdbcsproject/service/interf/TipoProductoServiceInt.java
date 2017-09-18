package com.leysoft.jdbcsproject.service.interf;

import java.util.List;

import com.leysoft.jdbcsproject.model.TipoProducto;

public interface TipoProductoServiceInt {
	
	public void save(TipoProducto tipoProducto);
	
	public TipoProducto findById(int id);
	
	public List<TipoProducto> findAll();
	
	public void update(TipoProducto tipoProducto);
	
	public void delete(int id);
}
