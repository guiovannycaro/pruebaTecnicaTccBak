package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.Zonas;

public interface ZonasInterfaceDao {
	public List<Zonas> listadoZonas() throws SQLException;
	public String crearZonas(Zonas cli) throws SQLException;
	public String editarZonas(Zonas cli) throws SQLException;
	public String eliminarZonas(Zonas cli) throws SQLException;
	public Zonas buscarZonasXNombre(Zonas cli) throws SQLException;
	public Zonas buscarZonasXId(Zonas cli) throws SQLException;
}
