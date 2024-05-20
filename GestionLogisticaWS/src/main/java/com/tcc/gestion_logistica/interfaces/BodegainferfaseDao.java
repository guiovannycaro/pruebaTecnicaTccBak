package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.Bodega;

public interface BodegainferfaseDao {
	public List<Bodega> listadoDeBodega() throws SQLException;
	
	public String crearBodega(Bodega datos) throws SQLException;
	
	public String editarBodega(Bodega datos) throws SQLException;
	
	public String eliminarBodega(int cli) throws SQLException;
	
	public Bodega buscarBodegaXNombre(Bodega cli) throws SQLException;
	
	 public Bodega buscarBodegaXId(int cli) throws SQLException;
	
}
