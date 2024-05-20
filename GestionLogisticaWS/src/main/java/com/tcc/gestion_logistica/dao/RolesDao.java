package com.tcc.gestion_logistica.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tcc.gestion_logistica.interfaces.RolesInterface;
import com.tcc.gestion_logistica.model.Roles;
import com.tcc.gestion_logistica.util.executeQueryBD;

public class RolesDao implements RolesInterface{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	@Override
	public List<Roles> devolverListaRoles() throws Exception {
		ArrayList<Roles> list = new ArrayList<>();
		String sql = "select * from roles";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Roles rol = new Roles();
			rol.setROL_ID(resulSelect.getInt("rol_id"));
			rol.setROL_NOMBRE(resulSelect.getString("rol_nombre"));
			rol.setROL_DESCRIPCION(resulSelect.getString("rol_descripcion"));
			
			list.add(rol);
		}
		return list;
	}

	@Override
	public List<Roles> devolverRolesById(int id) throws Exception {
		ArrayList<Roles> list = new ArrayList<>();
		String sql = "select * from roles where rol_id = "+ id +"";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Roles rol = new Roles();
			rol.setROL_ID(resulSelect.getInt("rol_id"));
			rol.setROL_NOMBRE(resulSelect.getString("rol_nombre"));
			rol.setROL_DESCRIPCION(resulSelect.getString("rol_descripcion"));
			
			list.add(rol);
		}
		return list;
	}

	@Override
	public Roles buscarRolesPorDato(Roles datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String agregarRoles(Roles rol) throws Exception {
		String validaIngreso;
		String sql = "insert into  roles (rol_nombres,rol_descripcion) "
			    + " values ('" + rol.getROL_NOMBRE() + "','" + rol.getROL_DESCRIPCION() + "')  ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String actualizarRoles(Roles rol) throws Exception {
		String validaIngreso;
		String sql = "Update   roles SET "
				+ "rol_nombres = '" + rol.getROL_NOMBRE() + "',"
				+ "rol_descripcion = '" + rol.getROL_DESCRIPCION() + "'"
				+ " WHERE rol_id = " + rol.getROL_ID() + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue EDITADO De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue EDITADO De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String eliminarRoles(int id) throws Exception {
		String validaIngreso;
		String sql = "Delete from  roles "
				+ " WHERE rol_id = " + id + " ";

		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue eliminado De Manera Correcta\"}";
		}
		return validaIngreso;
	}
	
}
