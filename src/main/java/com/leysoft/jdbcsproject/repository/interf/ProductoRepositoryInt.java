package com.leysoft.jdbcsproject.repository.interf;

import java.util.List;

import com.leysoft.jdbcsproject.model.Producto;

public interface ProductoRepositoryInt {
	
	public void save(Producto producto);
	
	public Producto findById(int id);
	
	public List<Producto> findAll();
	
	public void update(Producto producto);
	
	public void delete(int id);
	
	public List<Producto> findAllById(int id);
}
