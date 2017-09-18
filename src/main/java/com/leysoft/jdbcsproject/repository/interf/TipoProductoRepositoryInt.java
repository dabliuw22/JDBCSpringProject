package com.leysoft.jdbcsproject.repository.interf;

import java.util.List;

import com.leysoft.jdbcsproject.model.TipoProducto;

public interface TipoProductoRepositoryInt {
	
	public void save(TipoProducto tipoProducto);
	
	public TipoProducto findById(int id);
	
	public List<TipoProducto> findAll();
	
	public void update(TipoProducto tipoProducto);
	
	public void delete(int id);
}
