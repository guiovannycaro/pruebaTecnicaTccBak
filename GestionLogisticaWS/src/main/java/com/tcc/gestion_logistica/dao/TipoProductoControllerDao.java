package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.TipoProductoInterfaceDao;
import com.tcc.gestion_logistica.model.TipoProducto;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class TipoProductoControllerDao implements TipoProductoInterfaceDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<TipoProducto> listadoTipoProducto() throws SQLException {
		ArrayList<TipoProducto> list = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarTipoProducto", parameters, resultSet -> {
			while (resultSet.next()) {
				TipoProducto datos = new TipoProducto();
				datos.setTIPOPR_ID(resultSet.getInt(1));
				datos.setTIPOPR_NOMBRE(resultSet.getString(2));
				datos.setTIPOPR_DESCRIPCION(resultSet.getString(3));
				
				list.add(datos);
			}
		});
		return list;
	}
	
	public String crearTipoProducto(TipoProducto cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { cli.getTIPOPR_NOMBRE(),cli.getTIPOPR_DESCRIPCION()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarTipoProducto", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarTipoProducto(TipoProducto cli) throws SQLException {
		log.warn("nuevo Rol : " + cli );
		String[] parameters = { ""+cli.getTIPOPR_ID(),cli.getTIPOPR_NOMBRE(),cli.getTIPOPR_DESCRIPCION() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarTipoProducto", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarTipoProducto(TipoProducto cli) throws SQLException {
		log.warn("nuevo Roles : " + cli );
		String[] parameters = { ""+cli.getTIPOPR_ID() };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarTipoProducto", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public TipoProducto buscarTipoProductoXNombre(TipoProducto cli) throws SQLException {
		 TipoProducto datos = new TipoProducto();
			String[] parameters = { cli.getTIPOPR_NOMBRE() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarTipoProductoNombre", parameters, resultSet -> {
				while (resultSet.next()) {
			
					datos.setTIPOPR_ID(resultSet.getInt(1));
					datos.setTIPOPR_NOMBRE(resultSet.getString(2));
					datos.setTIPOPR_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
	 public TipoProducto buscarTipoProductoXId(TipoProducto cli) throws SQLException {
		 TipoProducto datos = new TipoProducto();
			String[] parameters = { ""+cli.getTIPOPR_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarTipoProductoId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setTIPOPR_ID(resultSet.getInt(1));
					datos.setTIPOPR_NOMBRE(resultSet.getString(2));
					datos.setTIPOPR_DESCRIPCION(resultSet.getString(3));
					
					
					
					
				}
			});
			return datos;
		}
	
	
}
