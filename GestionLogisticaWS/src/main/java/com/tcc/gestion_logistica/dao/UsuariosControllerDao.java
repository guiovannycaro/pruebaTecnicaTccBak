package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.UsuariosInterfacerDao;
import com.tcc.gestion_logistica.model.Usuarios;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class UsuariosControllerDao implements UsuariosInterfacerDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Usuarios> listadoUsuarios() throws SQLException {
		ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarUsuarios", parameters, resultSet -> {
			while (resultSet.next()) {
				Usuarios datos = new Usuarios();
				datos.setUSU_ID(resultSet.getInt(1));
				datos.setUSU_NOMBRES(resultSet.getString(2));
				datos.setUSU_DIRECCION(resultSet.getString(3));
				datos.setUSU_TELEFONO(resultSet.getString(4));
				datos.setUSU_CORREO(resultSet.getString(5));
				datos.setUSU_NUMDOCUMENTO(resultSet.getString(6));
				datos.setUSU_PASSWORD(resultSet.getString(7));
				datos.setUSU_TDOC_ID(resultSet.getInt(8));
				datos.setUSU_ROL_ID(resultSet.getInt(9));
				datos.setUSU_ESTADO(resultSet.getInt(10));
				listaUsuarios.add(datos);
			}
		});
		return listaUsuarios;
	}
	
	public String crearUsuarios(Usuarios cli) throws SQLException {
		log.warn("nuevo Usuarios : " + cli );
		String[] parameters = { cli.getUSU_NOMBRES(),""+cli.getUSU_DIRECCION(),cli.getUSU_TELEFONO(),cli.getUSU_CORREO(),cli.getUSU_NUMDOCUMENTO()
				,cli.getUSU_PASSWORD(),""+cli.getUSU_TDOC_ID(),""+cli.getUSU_ROL_ID(),""+cli.getUSU_ESTADO() };
		ProcedureUtil.executeUpdateGestion("GL_PInsertarUsuarios", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarUsuarios(Usuarios cli) throws SQLException {
		log.warn("nuevo Usuarios : " + cli );
		String[] parameters = { ""+cli.getUSU_ID(),cli.getUSU_NOMBRES(),""+cli.getUSU_DIRECCION(),cli.getUSU_TELEFONO(),cli.getUSU_CORREO(),cli.getUSU_NUMDOCUMENTO()
				,cli.getUSU_PASSWORD()
				,""+cli.getUSU_TDOC_ID(),""+cli.getUSU_ROL_ID(),""+cli.getUSU_ESTADO() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarUsuarios", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarUsuarios(Integer id) throws SQLException {
		System.err.println("elimina Usuarios : " + id );
		String[] parameters = { ""+id };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarUsuarios", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public Usuarios buscarUsuariosXNombre(Usuarios cli) throws SQLException {
		 Usuarios datos = new Usuarios();
			String[] parameters = { cli.getUSU_NOMBRES() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarUsuariosNombre", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setUSU_ID(resultSet.getInt(1));
					datos.setUSU_NOMBRES(resultSet.getString(2));
					datos.setUSU_DIRECCION(resultSet.getString(3));
					datos.setUSU_TELEFONO(resultSet.getString(4));
					datos.setUSU_CORREO(resultSet.getString(5));
					datos.setUSU_NUMDOCUMENTO(resultSet.getString(6));
					datos.setUSU_PASSWORD(resultSet.getString(7));
					datos.setUSU_TDOC_ID(resultSet.getInt(8));
					datos.setUSU_ROL_ID(resultSet.getInt(9));
					datos.setUSU_ESTADO(resultSet.getInt(10));
					
					
					
				}
			});
			return datos;
		}
	
	
	 public Usuarios buscarUsuariosXId(Integer id) throws SQLException {
		 Usuarios datos = new Usuarios();
			String[] parameters = { ""+id };
			ProcedureUtil.executeSelectGestion("GL_PBuscarUsuariosId", parameters, resultSet -> {
				while (resultSet.next()) {
				
					datos.setUSU_ID(resultSet.getInt(1));
					datos.setUSU_NOMBRES(resultSet.getString(2));
					datos.setUSU_DIRECCION(resultSet.getString(3));
					datos.setUSU_TELEFONO(resultSet.getString(4));
					datos.setUSU_CORREO(resultSet.getString(5));
					datos.setUSU_NUMDOCUMENTO(resultSet.getString(6));
					datos.setUSU_PASSWORD(resultSet.getString(7));
					datos.setUSU_TDOC_ID(resultSet.getInt(8));
					datos.setUSU_ROL_ID(resultSet.getInt(9));
					datos.setUSU_ESTADO(resultSet.getInt(10));
			
					
					
					
				}
			});
			return datos;
		}
	
	
}
