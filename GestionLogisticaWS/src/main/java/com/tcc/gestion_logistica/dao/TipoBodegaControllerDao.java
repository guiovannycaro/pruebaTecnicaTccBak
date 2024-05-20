package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.TipoBodegaImplementsDao;
import com.tcc.gestion_logistica.model.TipoBodega;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class TipoBodegaControllerDao implements TipoBodegaImplementsDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<TipoBodega> listadoTipoBodega() throws SQLException {
		ArrayList<TipoBodega> listaclientes = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarTipoBodega", parameters, resultSet -> {
			while (resultSet.next()) {
				TipoBodega datos = new TipoBodega();
				datos.setTIPOB_ID(resultSet.getInt(1));
				datos.setTIPOB_NOMBRE(resultSet.getString(2));
				datos.setTIPOB_DESCRIPCION(resultSet.getString(3));
				
				listaclientes.add(datos);
			}
		});
		return listaclientes;
	}
	
	public String crearTipoBodega(TipoBodega cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { cli.getTIPOB_NOMBRE(),cli.getTIPOB_DESCRIPCION()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarTipoBodega", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarTipoBodega(TipoBodega cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { ""+cli.getTIPOB_ID(),cli.getTIPOB_NOMBRE(),cli.getTIPOB_DESCRIPCION() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarTipoBodega", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarTipoBodega(TipoBodega cli) throws SQLException {
		log.warn("nuevo Roles : " + cli );
		String[] parameters = { ""+cli.getTIPOB_ID() };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarTipoBodega", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public TipoBodega buscarTipoBodegaXNombre(TipoBodega cli) throws SQLException {
		 TipoBodega datos = new TipoBodega();
			String[] parameters = { cli.getTIPOB_NOMBRE() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarTipoBodegaNombre", parameters, resultSet -> {
				while (resultSet.next()) {
			
					datos.setTIPOB_ID(resultSet.getInt(1));
					datos.setTIPOB_NOMBRE(resultSet.getString(2));
					datos.setTIPOB_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
	 public TipoBodega buscarTipoBodegaXId(TipoBodega cli) throws SQLException {
		 TipoBodega datos = new TipoBodega();
			String[] parameters = { ""+cli.getTIPOB_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarTipoBodegaId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setTIPOB_ID(resultSet.getInt(1));
					datos.setTIPOB_NOMBRE(resultSet.getString(2));
					datos.setTIPOB_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
}
