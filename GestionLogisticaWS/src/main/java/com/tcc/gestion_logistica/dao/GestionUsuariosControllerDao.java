package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.GestionUsuariosInterfaseDao;
import com.tcc.gestion_logistica.model.User;
import com.tcc.gestion_logistica.model.Usuarios;

import com.tcc.gestion_logistica.util.ProcedureUtil;

public class GestionUsuariosControllerDao implements GestionUsuariosInterfaseDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	 String vusuario ="";
	String vcontrasena="";
	
	public boolean validarUsuarios(User use) throws SQLException {
		String[] parameters = {use.getUsername(),use.getPassword() };
		 
		ProcedureUtil.executeSelectGestion("GL_PValidarUsuario", parameters, resultSet -> {
			while (resultSet.next()) {
				 vusuario = resultSet.getString("usu_correo");
			     vcontrasena = resultSet.getString("usu_password");
			}
		});
		if(vusuario.equals("") && vcontrasena.equals("")) {
			 return false;
		 }
		 return true;
	}
	
	public String cambiarContrasena(String usuario, String clave) throws SQLException {
	
		String[] parameters = { usuario,clave};
		ProcedureUtil.executeUpdateGestion("GL_PCambiarContrasena", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue actualizado De Manera Correcta\"}";
	}
	
	public Usuarios recordarContrasena(String usuario) throws SQLException {
		 Usuarios datos = new Usuarios();
		String[] parameters = { usuario };
		ProcedureUtil.executeSelectGestion("GL_PRecordarContrasena", parameters, resultSet -> {
			while (resultSet.next()) {
				datos.setUSU_PASSWORD(resultSet.getString(7));
			}
		});
		
		return datos;
	}
	
	public Usuarios getPerfil(String usuario) throws Exception {
		 Usuarios datos = new Usuarios();
		String[] parameters = { usuario };
	
		ProcedureUtil.executeSelectGestion("GL_PMostrarPerfil", parameters, resultSet -> {
			while (resultSet.next()) {
				datos.setUSU_ROL_ID(resultSet.getInt(9));
			}
		});
		
		return datos;
	}
	
	
}
