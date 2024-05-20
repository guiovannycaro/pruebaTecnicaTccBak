package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.Productos;

public interface ProductoInterfaseDao {
	public List<Productos> listadoProducto() throws SQLException;
	public String crearProducto(Productos cli) throws SQLException;
	public String editarProducto(Productos cli) throws SQLException;
	public String eliminarProducto(int id) throws SQLException;
	 public Productos buscarProductoXNombre(Productos cli) throws SQLException;
	 public Productos buscarProductoXId(int id) throws SQLException;
}
