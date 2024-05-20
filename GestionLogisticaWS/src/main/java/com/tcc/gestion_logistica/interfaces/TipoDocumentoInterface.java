package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.TipoDocumento;


public interface TipoDocumentoInterface {

	List<TipoDocumento> devolverListaTipoDocumento() throws Exception;

	List<TipoDocumento> devolverTipoDocumentoById(int id)  throws Exception;

	TipoDocumento buscarTipoDocumentoPorDato(TipoDocumento datos)  throws Exception;
	 
	String agregarTipoDocumento(TipoDocumento datos)  throws Exception;

	String actualizarTipoDocumento(TipoDocumento datos)  throws Exception;

	String eliminarTipoDocumento(int id)  throws Exception;

}
