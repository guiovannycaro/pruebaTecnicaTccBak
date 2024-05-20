package com.tcc.gestion_logistica.interfaces;

import java.util.List;

import com.tcc.gestion_logistica.model.Roles;


public interface RolesInterface {

	List<Roles> devolverListaRoles() throws Exception;

	List<Roles> devolverRolesById(int id)  throws Exception;

	Roles buscarRolesPorDato(Roles datos)  throws Exception;
	 
	String agregarRoles(Roles datos)  throws Exception;

	String actualizarRoles(Roles datos)  throws Exception;

	String eliminarRoles(int id)  throws Exception;

}
