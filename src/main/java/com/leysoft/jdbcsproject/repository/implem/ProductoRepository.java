package com.leysoft.jdbcsproject.repository.implem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.leysoft.jdbcsproject.model.Producto;
import com.leysoft.jdbcsproject.model.TipoProducto;
import com.leysoft.jdbcsproject.repository.interf.ProductoRepositoryInt;
import com.leysoft.jdbcsproject.repository.mapper.ProductoMapper;
import com.leysoft.jdbcsproject.service.interf.TipoProductoServiceInt;

@Repository("productoRepositoryJDBC")
public class ProductoRepository implements ProductoRepositoryInt {
	private static final String PRODUCTO_SAVE = "INSERT INTO productos (nombre, precio, tipo_producto_id) VALUES (?, ?, ?)";
	private static final String PRODUCTO_FIND_ID = "SELECT nombre, precio, tipo_producto_id FROM productos WHERE id = ?";
	private static final String PRODUCTO_FIND_ALL = "SELECT nombre, precio, tipo_producto_id FROM productos";
	private static final String PRODUCTO_UPDATE = "UPDATE productos SET nombre = ?, precio = ?, tipo_producto_id = ? WHERE id = ?";
	private static final String PRODUCTO_DELETE = "DELETE FROM productos WHERE id = ?";
	private static final String PRODUCTO_FIND_ALL_ID = "SELECT id, nombre, precio FROM productos WHERE tipo_producto_id = ?";
	
	@Autowired @Qualifier("tipoProductoServiceJDBC")
	private TipoProductoServiceInt tipoProductoService;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSourse(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Producto producto) {
		jdbcTemplate.update(PRODUCTO_SAVE, producto.getNombre(), producto.getPrecio(), producto.getTipoProducto().getId());
	}

	@Override
	public Producto findById(int id) {
		return jdbcTemplate.queryForObject(PRODUCTO_FIND_ID, new ProductoMapper(), id);
	}

	@Override
	public List<Producto> findAll() {
		return jdbcTemplate.query(PRODUCTO_FIND_ALL, new ProductoMapper());
	}

	@Override
	public void update(Producto producto) {
		jdbcTemplate.update(PRODUCTO_UPDATE, producto.getNombre(), producto.getPrecio(), producto.getTipoProducto().getId(), producto.getId());
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update(PRODUCTO_DELETE, id);
	}

	@Override
	public List<Producto> findAllById(int id) {
		return jdbcTemplate.query(PRODUCTO_FIND_ALL_ID, new RowMapper<Producto>() {
			
			TipoProducto tipoProducto = tipoProductoService.findById(id);
			
			@Override
			public Producto mapRow(ResultSet resultSet, int arg1) throws SQLException {
				Producto producto = new Producto(resultSet.getString("nombre"), 
						resultSet.getDouble("precio"), tipoProducto);
				producto.setId(resultSet.getInt("id"));
				return producto;
			}
		}, id);
	}
}
