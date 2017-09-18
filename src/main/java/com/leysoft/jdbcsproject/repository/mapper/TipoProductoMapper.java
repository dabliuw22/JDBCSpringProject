package com.leysoft.jdbcsproject.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.leysoft.jdbcsproject.model.TipoProducto;

public class TipoProductoMapper implements RowMapper<TipoProducto> {

	@Override
	public TipoProducto mapRow(ResultSet resultSet, int arg1) throws SQLException {
		TipoProducto tipoProducto = new TipoProducto(resultSet.getString("nombre"));
		return tipoProducto;
	}
}
