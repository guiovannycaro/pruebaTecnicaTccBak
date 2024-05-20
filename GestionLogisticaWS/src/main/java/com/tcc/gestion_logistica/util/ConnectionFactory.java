package com.tcc.gestion_logistica.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tcc.gestion_logistica.config.properties.Propiedad;

public class ConnectionFactory {

	public static Connection connectToBD() throws SQLException {
	
		String connString = Propiedad.getCurrentInstance().getBDJdbc();
		
		String username = Propiedad.getCurrentInstance().getBDUsuario();
	
		String password = Propiedad.getCurrentInstance().getBDClave();
		
		return DriverManager.getConnection(connString, username, password);
	}
	
	public static Connection connectToGestionOra() throws SQLException {
		String connString = Propiedad.getCurrentInstance().getGestionJdbcORA();
		String username = Propiedad.getCurrentInstance().getGestionUsuarioORA();
		String password = Propiedad.getCurrentInstance().getGestionClaveORA();
		System.out.println(connString + " - " + username + "/" + password);
		return DriverManager.getConnection(connString, username, password);
	}

}
