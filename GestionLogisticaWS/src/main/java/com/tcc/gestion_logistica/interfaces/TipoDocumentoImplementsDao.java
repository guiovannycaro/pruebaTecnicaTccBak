package com.tcc.gestion_logistica.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.tcc.gestion_logistica.model.TipoDocumento;

public interface TipoDocumentoImplementsDao {
	public List<TipoDocumento> listadoTipoDocumento() throws SQLException;
	public String crearTipoDocumento(TipoDocumento cli) throws SQLException;
	public String editarTipoDocumento(TipoDocumento cli) throws SQLException;
	public String eliminarTipoDocumento(TipoDocumento cli) throws SQLException;
	public TipoDocumento buscarTipoDocumentoXNombre(TipoDocumento cli) throws SQLException;
	public TipoDocumento buscarTipoDocumentoXId(TipoDocumento cli) throws SQLException;
}
