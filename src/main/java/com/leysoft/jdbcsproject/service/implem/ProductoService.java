package com.leysoft.jdbcsproject.service.implem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leysoft.jdbcsproject.model.Producto;
import com.leysoft.jdbcsproject.repository.interf.ProductoRepositoryInt;
import com.leysoft.jdbcsproject.service.interf.ProductoServiceInt;

@Service("productoServiceJDBC")
public class ProductoService implements ProductoServiceInt {
	
	@Autowired @Qualifier("productoRepositoryJDBC")
	private ProductoRepositoryInt productoRepository;

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public Producto findById(int id) {
		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public void update(Producto producto) {
		productoRepository.update(producto);
	}

	@Override
	public void delete(int id) {
		productoRepository.delete(id);
	}

	@Override
	public List<Producto> findAllById(int id) {
		return productoRepository.findAllById(id);
	}
}
