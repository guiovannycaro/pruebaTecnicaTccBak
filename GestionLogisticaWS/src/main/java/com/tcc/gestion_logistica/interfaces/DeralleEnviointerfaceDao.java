package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.DatosEnvio;
import com.tcc.gestion_logistica.model.DetalleEnvio;

public interface DeralleEnviointerfaceDao {

	public List<DetalleEnvio> listadoDetalleEnvio() throws SQLException;
	
	public String crearDetalleEnvio(DatosEnvio cli)  throws SQLException;
	
	public String editarDetalleEnvio(DetalleEnvio cli) throws SQLException;
	
	public String eliminarDetalleEnvio(int cli) throws SQLException; 
	
	
	public DetalleEnvio buscarDetalleEnvioXNombreProducto(DetalleEnvio cli) throws SQLException; 
	
	public DetalleEnvio buscarDetalleEnvioXId(int cli) throws SQLException;
	
	
}
