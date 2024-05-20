package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.RolesInterfacerDao;
import com.tcc.gestion_logistica.model.Roles;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class RolesControllerDao implements RolesInterfacerDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Roles> listadoRoles() throws SQLException {
		ArrayList<Roles> listaclientes = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarRoles", parameters, resultSet -> {
			while (resultSet.next()) {
				Roles datos = new Roles();
				datos.setROL_ID(resultSet.getInt(1));
				datos.setROL_NOMBRE(resultSet.getString(2));
				datos.setROL_DESCRIPCION(resultSet.getString(3));
				
				listaclientes.add(datos);
			}
		});
		return listaclientes;
	}
	
	public String crearRoles(Roles cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { cli.getROL_NOMBRE(),cli.getROL_DESCRIPCION()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarRol", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarRoles(Roles cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { ""+cli.getROL_ID(),cli.getROL_NOMBRE(),cli.getROL_DESCRIPCION() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarRol", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarRoles(Roles cli) throws SQLException {
		log.warn("nuevo Roles : " + cli );
		String[] parameters = { ""+cli.getROL_ID() };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarRol", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public Roles buscarRolesXNombre(Roles cli) throws SQLException {
			Roles datos = new Roles();
			String[] parameters = { cli.getROL_NOMBRE() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarRolesNombre", parameters, resultSet -> {
				while (resultSet.next()) {
			
					datos.setROL_ID(resultSet.getInt(1));
					datos.setROL_NOMBRE(resultSet.getString(2));
					datos.setROL_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
	 public Roles buscarRolesXId(Roles cli) throws SQLException {
			Roles datos = new Roles();
			String[] parameters = { ""+cli.getROL_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarRolesId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setROL_ID(resultSet.getInt(1));
					datos.setROL_NOMBRE(resultSet.getString(2));
					datos.setROL_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
}
