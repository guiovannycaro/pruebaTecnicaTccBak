package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.Usuarios;

public interface UsuariosInterfacerDao {
	public List<Usuarios> listadoUsuarios() throws SQLException;
	public String crearUsuarios(Usuarios cli) throws SQLException;
	public String editarUsuarios(Usuarios cli) throws SQLException;
	public String eliminarUsuarios(Integer id) throws SQLException;
	 public Usuarios buscarUsuariosXNombre(Usuarios cli) throws SQLException;
	 public Usuarios buscarUsuariosXId(Integer id) throws SQLException; 
}
