package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.DatosEnvioD;
import com.tcc.gestion_logistica.model.DetalleEnvioTemp;

public interface DeralleEnvioTempinterfaceDao {

	public List<DetalleEnvioTemp> listadoDetalleEnvioTemp() throws SQLException;
	
	public String crearDetalleEnvioTemp(DatosEnvioD cli) throws SQLException;
	
	public String editarDetalleEnvioTemp(DetalleEnvioTemp cli) throws SQLException;
	
	public String eliminarDetalleEnvioTemp(int cli) throws SQLException; 
	
	
	public DetalleEnvioTemp buscarDetalleEnvioTempXNombreProducto(DetalleEnvioTemp cli) throws SQLException; 
	
	 public List<DetalleEnvioTemp> buscarDetalleEnvioTempXId(int cli) throws SQLException;
	
	
}
