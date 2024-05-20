package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Bodega;


public interface BodegaInterface {

	public List<Bodega> listadoDeBodega() throws Exception;

	public String crearBodega(Bodega datos) throws Exception;

	public String editarBodega(Bodega datos)  throws Exception;
	 
	public String eliminarBodega(Bodega cli)  throws Exception;

	public Bodega buscarBodegaXNombre(Bodega cli)  throws Exception;

	 public Bodega buscarBodegaXId(Bodega cli)  throws Exception;

}
