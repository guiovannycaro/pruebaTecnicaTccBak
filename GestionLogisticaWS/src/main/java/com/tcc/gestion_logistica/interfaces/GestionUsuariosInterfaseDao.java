package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;

import com.tcc.gestion_logistica.model.User;
import com.tcc.gestion_logistica.model.Usuarios;

public interface GestionUsuariosInterfaseDao {
	public boolean validarUsuarios(User use) throws SQLException;
	
	public String cambiarContrasena(String usuario, String clave) throws SQLException;
	
	public Usuarios recordarContrasena(String usuario) throws SQLException; 
	
	public Usuarios getPerfil(String usuario) throws Exception;
}
