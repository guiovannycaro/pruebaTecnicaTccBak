package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Clientes;

public interface ClientesInterfaceDao {

	public List<Clientes> listadoDeClientes() throws Exception;

	public String crearCliente(Clientes cli) throws Exception;

	public String editarCliente(Clientes cli)  throws Exception;
	 
	public String eliminarCliente(int cli)  throws Exception;

	public Clientes buscarClienteXNombre(Clientes cli)  throws Exception;

	public Clientes buscarClienteXId(int cli)  throws Exception;

}
