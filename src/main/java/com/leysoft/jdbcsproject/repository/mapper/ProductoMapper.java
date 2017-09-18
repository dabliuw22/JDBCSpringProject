package com.leysoft.jdbcsproject.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.leysoft.jdbcsproject.model.Producto;
import com.leysoft.jdbcsproject.service.interf.TipoProductoServiceInt;

public class ProductoMapper implements RowMapper<Producto> {
	
	@Autowired
	private TipoProductoServiceInt tipoProductoService;

	@Override
	public Producto mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Producto producto = new Producto(resultSet.getString("nombre"), 
				resultSet.getDouble("precio"), 
				tipoProductoService.findById(resultSet.getInt("tipo_producto_id")));
		return producto;
	}
}
