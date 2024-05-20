package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.TipoBodega;


public interface TipoBodegaInterface {

	List<TipoBodega> devolverListaTipoBodega() throws Exception;

	List<TipoBodega> devolverTipoBodegaById(int id)  throws Exception;

	TipoBodega buscarTipoBodegaPorDato(TipoBodega datos)  throws Exception;
	 
	String agregarTipoBodega(TipoBodega datos)  throws Exception;

	String actualizarTipoBodega(TipoBodega datos)  throws Exception;

	String eliminarTipoBodega(int id)  throws Exception;

}
