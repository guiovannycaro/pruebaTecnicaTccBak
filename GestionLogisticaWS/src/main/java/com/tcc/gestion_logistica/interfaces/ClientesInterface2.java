package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Clientes;

public interface ClientesInterface2 {

	public List<Clientes> devolverListaClientes() throws Exception;

	public List<Clientes> devolverClienteById(int id) throws Exception;

	public Clientes buscarClientePorDato(Clientes datos)  throws Exception;
	 
	public String agregarCliente(Clientes cli) throws Exception;

	public String eliminarCliente(int id) throws Exception;

	public Clientes buscarClienteXId(Clientes cli)  throws Exception;
	
	public String actualizarCliente(Clientes cli) throws Exception;

}
