package com.tcc.gestion_logistica.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tcc.gestion_logistica.interfaces.GestionUsuariosInterface;
import com.tcc.gestion_logistica.model.Usuarios;
import com.tcc.gestion_logistica.util.executeQueryBD;

public class GestionUsuariosDao implements  GestionUsuariosInterface{


	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	
	@Override
	public boolean validarUsuarios(String useremail,String password) throws Exception {
		
		System.err.println("consulta " + useremail);
		 String sql = "select usu_correo,usu_password from usuarios usuarios where usu_correo  = '" + useremail
				 
				 + "'"
                 + " and usu_password ='" + password + "'";
		 System.err.println("consulta " + sql);
		 String vusuario ="";
		 String vcontrasena="";
		 resulSelect = query.executeSelectBd(sql);
		 while (resulSelect.next()) {
		    vusuario = resulSelect.getString("usu_correo");
			vcontrasena = resulSelect.getString("usu_password");

         } 
		 
		 if(vusuario.equals("") && vcontrasena.equals("")) {
			 return false;
		 }
		 return true;

	}

	@Override
	public String cambiarContrasena(String usuario, String clave) throws Exception {
		String validaIngreso;
		String sql = "Update   usuarios SET "
				+ "usu_password = '" + clave + "' "
				+ " WHERE usu_correo = " + usuario + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"la contraseña se modifico  De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"la contraseña no se modifico  De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String recordarContrasena(String usuario) throws Exception {
		String contrasena = null;
		String sql = "select * from usuarios where usu_correo = "+ usuario +" ";
		resulSelect = query.executeSelectBd(sql);
		
		while (resulSelect.next()) {
			Usuarios us = new Usuarios();
			contrasena =	resulSelect.getString("usu_password");
		}
		return contrasena;
	}

	@Override
	public String getPerfil(String usuario) throws Exception {
		String perfil = null;
		String sql = "select usu_rol_id from usuarios where usu_correo = "+ usuario +" ";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Usuarios us = new Usuarios();
			perfil =	resulSelect.getString("usu_rol_id");
		}
		return perfil;
	}
}
