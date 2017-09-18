package com.leysoft.jdbcsproject.service.implem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leysoft.jdbcsproject.model.TipoProducto;
import com.leysoft.jdbcsproject.repository.interf.TipoProductoRepositoryInt;
import com.leysoft.jdbcsproject.service.interf.TipoProductoServiceInt;

@Service("tipoProductoServiceJDBC")
public class TipoProductoService implements TipoProductoServiceInt {
	
	@Autowired @Qualifier("tipoProductoRepositoryJDBC")
	private TipoProductoRepositoryInt tipoProductoRepository;
	
	@Override
	public void save(TipoProducto tipoProducto) {
		tipoProductoRepository.save(tipoProducto);
	}
	
	@Override
	public TipoProducto findById(int id) {
		return tipoProductoRepository.findById(id);
	}
	
	@Override
	public List<TipoProducto> findAll() {
		return tipoProductoRepository.findAll();
	}

	@Override
	public void update(TipoProducto tipoProducto) {
		tipoProductoRepository.update(tipoProducto);
	}

	@Override
	public void delete(int id) {
		tipoProductoRepository.delete(id);
	}
}
