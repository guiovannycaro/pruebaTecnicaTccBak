package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.TipoProducto;

public interface TipoProductoInterface {

	List<TipoProducto> devolverListaTipoProducto() throws Exception;

	List<TipoProducto> devolverTipoProductoById(int id)  throws Exception;

	TipoProducto buscarTipoProductoPorDato(TipoProducto datos)  throws Exception;
	 
	String agregarTipoProducto(TipoProducto datos)  throws Exception;

	String actualizarTipoProducto(TipoProducto datos)  throws Exception;

	String eliminarTipoProducto(int id)  throws Exception;

}
