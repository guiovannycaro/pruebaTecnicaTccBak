package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.DetalleEnvio;


public interface DetalleEnvioInterface {

	List<DetalleEnvio> devolverListaDetalleEnvio() throws Exception;

	List<DetalleEnvio> devolverDetalleEnvioById(int id)  throws Exception;

	DetalleEnvio buscarTipoDetalleEnvioPorDato(DetalleEnvio datos)  throws Exception;
	 
	String agregarDetalleEnvio(int idcliente,DetalleEnvio datos)  throws Exception;


	String eliminarDetalleEnvio(int id)  throws Exception;

}
