package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.Roles;

public interface RolesInterfacerDao {
	public List<Roles> listadoRoles() throws SQLException;
	public String crearRoles(Roles cli) throws SQLException;
	public String editarRoles(Roles cli) throws SQLException;
	public String eliminarRoles(Roles cli) throws SQLException;
	public Roles buscarRolesXNombre(Roles cli) throws SQLException;
	public Roles buscarRolesXId(Roles cli) throws SQLException;
}
