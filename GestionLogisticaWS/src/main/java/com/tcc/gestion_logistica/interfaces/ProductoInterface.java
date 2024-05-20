package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Productos;

public interface ProductoInterface {

	List<Productos> devolverListaProductos() throws Exception;

	List<Productos> devolverProductoById(int id)  throws Exception;

	Productos buscarProductosPorDato(Productos datos)  throws Exception;
	 
	String agregarProductos(Productos clientes)  throws Exception;

	String actualizarProductos(Productos clientes)  throws Exception;

	String eliminarProductos(int id)  throws Exception;
	
	Productos   validarProductoById(int id)  throws Exception;

}
