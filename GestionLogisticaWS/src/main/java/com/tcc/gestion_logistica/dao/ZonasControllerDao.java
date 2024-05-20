package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.ZonasInterfaceDao;
import com.tcc.gestion_logistica.model.Zonas;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class ZonasControllerDao implements ZonasInterfaceDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Zonas> listadoZonas() throws SQLException {
		ArrayList<Zonas> listaclientes = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarZonas", parameters, resultSet -> {
			while (resultSet.next()) {
				Zonas datos = new Zonas();
				datos.setZON_ID(resultSet.getInt(1));
				datos.setZON_NOMBRE(resultSet.getString(2));
				datos.setZON_DESCRIPCION(resultSet.getString(3));
				
				listaclientes.add(datos);
			}
		});
		return listaclientes;
	}
	
	public String crearZonas(Zonas cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { cli.getZON_NOMBRE(),cli.getZON_DESCRIPCION()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarZonas", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarZonas(Zonas cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { ""+cli.getZON_ID(),cli.getZON_NOMBRE(),cli.getZON_DESCRIPCION() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarZonas", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarZonas(Zonas cli) throws SQLException {
		log.warn("nuevo Roles : " + cli );
		String[] parameters = { ""+cli.getZON_ID() };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarZonas", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public Zonas buscarZonasXNombre(Zonas cli) throws SQLException {
		 Zonas datos = new Zonas();
			String[] parameters = { cli.getZON_NOMBRE() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarZonasNombre", parameters, resultSet -> {
				while (resultSet.next()) {
			
					datos.setZON_ID(resultSet.getInt(1));
					datos.setZON_NOMBRE(resultSet.getString(2));
					datos.setZON_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
	 public Zonas buscarZonasXId(Zonas cli) throws SQLException {
		 Zonas datos = new Zonas();
			String[] parameters = { ""+cli.getZON_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarZonasId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setZON_ID(resultSet.getInt(1));
					datos.setZON_NOMBRE(resultSet.getString(2));
					datos.setZON_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
}
