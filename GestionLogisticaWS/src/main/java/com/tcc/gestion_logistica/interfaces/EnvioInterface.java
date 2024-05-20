package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Envio;

public interface EnvioInterface {

	List<Envio> devolverListaEnvio() throws Exception;

	List<Envio> devolverEnvioById(int id)  throws Exception;

	Envio buscarTipoDetalleEnvioPorDato(Envio datos)  throws Exception;
	 
	String agregarEnvio(Envio datos)  throws Exception;

	String actualizarEnvio(Envio datos)  throws Exception;

	String eliminarEnvio(int id)  throws Exception;
	
	Envio validarEnvioById(int idcliente)  throws Exception;
}
