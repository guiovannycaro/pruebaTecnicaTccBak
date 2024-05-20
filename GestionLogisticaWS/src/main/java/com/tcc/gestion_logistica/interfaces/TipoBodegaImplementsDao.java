package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.TipoBodega;

public interface TipoBodegaImplementsDao {
	public List<TipoBodega> listadoTipoBodega() throws SQLException;
	public String crearTipoBodega(TipoBodega cli) throws SQLException;
	public String editarTipoBodega(TipoBodega cli) throws SQLException;
	public String eliminarTipoBodega(TipoBodega cli) throws SQLException;
	public TipoBodega buscarTipoBodegaXNombre(TipoBodega cli) throws SQLException;
	public TipoBodega buscarTipoBodegaXId(TipoBodega cli) throws SQLException; 
}
