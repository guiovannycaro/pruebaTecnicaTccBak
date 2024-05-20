package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.TipoProducto;

public interface  TipoProductoInterfaceDao {
	public List<TipoProducto> listadoTipoProducto() throws SQLException;
	public String crearTipoProducto(TipoProducto cli) throws SQLException;
	public String editarTipoProducto(TipoProducto cli) throws SQLException;
	public String eliminarTipoProducto(TipoProducto cli) throws SQLException;
	 public TipoProducto buscarTipoProductoXNombre(TipoProducto cli) throws SQLException;
	 public TipoProducto buscarTipoProductoXId(TipoProducto cli) throws SQLException;
}
