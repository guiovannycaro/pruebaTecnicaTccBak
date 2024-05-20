package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.Envio;

public interface EnvioInterfaceDao {

	public List<Envio> listadoEnvio() throws SQLException; 
	
	public String crearEnvio(Envio cli) throws SQLException; 
	
	public String editarEnvio(Envio cli) throws SQLException;
	
	public String eliminarEnvio(int id) throws SQLException;
	
	public Envio buscarEnvioXCliente(Envio cli) throws SQLException; 
	
	 public Envio buscarEnvioXId(int id) throws SQLException;
	 public String eliminarEnvioTemp(int id) throws SQLException;
}
