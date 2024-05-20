package com.tcc.gestion_logistica.config.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.Serializable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.tcc.gestion_logistica.util.ExceptionUtil;
import com.tcc.gestion_logistica.util.SerialClone;


public class Propiedad {


	Properties propVersion = new Properties();
	Properties propGlobal = new Properties();

	private static Propiedad p = null;

	private Propiedad() {
		try {
			InputStream in = this.getClass()
					.getResourceAsStream("/com/tcc/gestion_logistica/config//properties/version.properties");
			propVersion.load(in);
			in.close();

			in = this.getClass().getResourceAsStream("/com/tcc/gestion_logistica/config/properties/param.properties");
			propGlobal.load(in);
			in.close();

			

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static Propiedad getCurrentInstance() {
		if (p == null) {
			p = new Propiedad();
		}
		return p;
	}

	public String getVersion() {
		return propVersion.getProperty("VERSION");
	}

	public String getBDJdbc() {
		return propGlobal.getProperty("BD.JDBC");
	}

	public String getBDUsuario() {
		return propGlobal.getProperty("BD.USUARIO");
	}

	public String getBDClave() {
		return propGlobal.getProperty("BD.CLAVE");
	}

	public String getPathTmp() {
		return propGlobal.getProperty("PATH_TMP");
	}
	
	
	public String getGestionDriverORA() {
		return propGlobal.getProperty("GESTION.ORADRIVER");
	}

	public String getGestionJdbcORA() {
		return propGlobal.getProperty("GESTION.ORAJDBC");
	}

	public String getGestionUsuarioORA() {
		return propGlobal.getProperty("GESTION.ORAUSUARIO");
	}

	public String getGestionClaveORA() {
		return propGlobal.getProperty("GESTION.ORACLAVE");
	}
	
	
	

	public static void main(String args[]) {
		System.out.println("PARAM="
				+ Propiedad.getCurrentInstance().getVersion() + " " + Propiedad.getCurrentInstance().getBDJdbc() + " " + Propiedad.getCurrentInstance().getBDUsuario() + " " + Propiedad.getCurrentInstance().getBDClave());
	}
}
