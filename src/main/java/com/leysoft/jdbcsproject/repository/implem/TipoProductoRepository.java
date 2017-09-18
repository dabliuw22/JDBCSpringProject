package com.leysoft.jdbcsproject.repository.implem;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.leysoft.jdbcsproject.model.TipoProducto;
import com.leysoft.jdbcsproject.repository.interf.TipoProductoRepositoryInt;
import com.leysoft.jdbcsproject.repository.mapper.TipoProductoMapper;

@Repository("tipoProductoRepositoryJDBC")
public class TipoProductoRepository implements TipoProductoRepositoryInt {
	private static final String TIPO_PRODUCTO_SAVE = "INSERT INTO tipos_producto (nombre) VALUES(?)";
	private static final String TIPO_PRODUCTO_FIND_ID = "SELECT nombre FROM tipos_producto WHERE id = ? ";
	private static final String TIPO_PRODUCTO_FIND_ALL = "SELECT nombre FROM tipos_producto";
	private static final String TIPO_PRODUCTO_UPDATE = "UPDATE tipos_producto SET nombre = ? WHERE id = ?";
	private static final String TIPO_PRODUCTO_DELETE = "DELETE FROM tipos_producto WHERE id = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(TipoProducto tipoProducto) {
		jdbcTemplate.update(TIPO_PRODUCTO_SAVE, tipoProducto.getNombre());
	}
	
	@Override
	public TipoProducto findById(int id) {
		return jdbcTemplate.queryForObject(TIPO_PRODUCTO_FIND_ID, new TipoProductoMapper(), id);
	}

	@Override
	public List<TipoProducto> findAll() {
		return jdbcTemplate.query(TIPO_PRODUCTO_FIND_ALL, new TipoProductoMapper());
	}

	@Override
	public void update(TipoProducto tipoProducto) {
		jdbcTemplate.update(TIPO_PRODUCTO_UPDATE, tipoProducto.getNombre(), tipoProducto.getId());
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update(TIPO_PRODUCTO_DELETE, id);
	}
}
