package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.TipoDocumentoImplementsDao;
import com.tcc.gestion_logistica.model.TipoDocumento;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class TipoDocumentoControllerDao implements TipoDocumentoImplementsDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<TipoDocumento> listadoTipoDocumento() throws SQLException {
		ArrayList<TipoDocumento> listaclientes = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarTipoDocumento", parameters, resultSet -> {
			while (resultSet.next()) {
				TipoDocumento datos = new TipoDocumento();
				datos.setTDOC_ID(resultSet.getInt(1));
				datos.setTDOC_NOMBRE(resultSet.getString(2));
				datos.setTDOC_DESCRIPCION(resultSet.getString(3));
				
				listaclientes.add(datos);
			}
		});
		return listaclientes;
	}
	
	public String crearTipoDocumento(TipoDocumento cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { cli.getTDOC_NOMBRE(),cli.getTDOC_DESCRIPCION()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarTipoDocumento", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarTipoDocumento(TipoDocumento cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { ""+cli.getTDOC_ID(),cli.getTDOC_NOMBRE(),cli.getTDOC_DESCRIPCION() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarTipoDocumento", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarTipoDocumento(TipoDocumento cli) throws SQLException {
		log.warn("nuevo Roles : " + cli );
		String[] parameters = { ""+cli.getTDOC_ID() };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarTipoDocumento", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public TipoDocumento buscarTipoDocumentoXNombre(TipoDocumento cli) throws SQLException {
		 TipoDocumento datos = new TipoDocumento();
			String[] parameters = { cli.getTDOC_NOMBRE() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarTipoDocumentoNombre", parameters, resultSet -> {
				while (resultSet.next()) {
			
					datos.setTDOC_ID(resultSet.getInt(1));
					datos.setTDOC_NOMBRE(resultSet.getString(2));
					datos.setTDOC_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
	 public TipoDocumento buscarTipoDocumentoXId(TipoDocumento cli) throws SQLException {
		 TipoDocumento datos = new TipoDocumento();
			String[] parameters = { ""+cli.getTDOC_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarTipoDocumentoId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setTDOC_ID(resultSet.getInt(1));
					datos.setTDOC_NOMBRE(resultSet.getString(2));
					datos.setTDOC_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
}
