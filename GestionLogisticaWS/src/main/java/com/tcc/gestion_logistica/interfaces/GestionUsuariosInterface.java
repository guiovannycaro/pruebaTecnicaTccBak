package com.tcc.gestion_logistica.interfaces;

import com.tcc.gestion_logistica.model.Usuarios;

public interface GestionUsuariosInterface {
	boolean validarUsuarios(String useremail,String password)   throws Exception;
	
	String cambiarContrasena(String usuario, String clave)  throws Exception;
	
	String recordarContrasena(String usuario)  throws Exception;
	
	String getPerfil(String usuario) throws Exception;

}
