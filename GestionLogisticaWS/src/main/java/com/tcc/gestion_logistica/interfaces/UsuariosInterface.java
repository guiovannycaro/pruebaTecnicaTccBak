package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Usuarios;

public interface UsuariosInterface {

	List<Usuarios> devolverListaUsuarios() throws Exception;

	List<Usuarios> devolverUsuariosById(int id)  throws Exception;

	Usuarios buscarUsuariosPorDato(Usuarios datos)  throws Exception;
	 
	String agregarUsuario(Usuarios datos)  throws Exception;

	String actualizarUsuario(Usuarios datos)  throws Exception;

	String eliminarUsuario(int id)  throws Exception;


}
