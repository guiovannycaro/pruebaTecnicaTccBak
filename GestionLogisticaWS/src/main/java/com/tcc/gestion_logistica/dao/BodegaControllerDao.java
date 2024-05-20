package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.BodegainferfaseDao;
import com.tcc.gestion_logistica.model.Bodega;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class BodegaControllerDao implements BodegainferfaseDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Bodega> listadoDeBodega() throws SQLException {
		ArrayList<Bodega> lista = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarBodega", parameters, resultSet -> {
			while (resultSet.next()) {
				Bodega datos = new Bodega();
				datos.setBOD_ID(resultSet.getInt(1));
				datos.setBOD_NOMBRES(resultSet.getString(2));
				datos.setBOD_DIRECCION(resultSet.getString(3));
				datos.setBOD_TELEFONO(resultSet.getString(4));
				datos.setBOD_ID_TIPO(resultSet.getInt(5));
				datos.setBOD_CIUDAD_ID(resultSet.getInt(6));
				datos.setBOD_ZONA_ID(resultSet.getInt(7));
				datos.setBOD_ESTADO(resultSet.getInt(8));
				lista.add(datos);
			}
		});
		return lista;
	}
	
	public String crearBodega(Bodega datos) throws SQLException {
		log.warn("nuevo cliente : " + datos );
		String[] parameters = { 
				datos.getBOD_NOMBRES(),
				datos.getBOD_DIRECCION(),
				datos.getBOD_TELEFONO(),
				""+datos.getBOD_ID_TIPO(),
				""+datos.getBOD_CIUDAD_ID(),
				""+datos.getBOD_ZONA_ID(),
				""+datos.getBOD_ESTADO()
		};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarBodega", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarBodega(Bodega datos) throws SQLException {
		log.warn("nuevo cliente : " + datos );
		String[] parameters = { 
				""+datos.getBOD_ID(),
				datos.getBOD_NOMBRES(),
				datos.getBOD_DIRECCION(),
				datos.getBOD_TELEFONO(),
				""+datos.getBOD_ID_TIPO(),
				""+datos.getBOD_CIUDAD_ID(),
				""+datos.getBOD_ZONA_ID(),
				""+datos.getBOD_ESTADO()
		};
		ProcedureUtil.executeUpdateGestion("GL_PEditarBodega", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarBodega(int cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarBodega", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public Bodega buscarBodegaXNombre(Bodega cli) throws SQLException {
		 Bodega datos = new Bodega();
			String[] parameters = { cli.getBOD_NOMBRES() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarBodegaNombre", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setBOD_ID(resultSet.getInt(1));
					datos.setBOD_NOMBRES(resultSet.getString(2));
					datos.setBOD_DIRECCION(resultSet.getString(3));
					datos.setBOD_TELEFONO(resultSet.getString(4));
					datos.setBOD_ID_TIPO(resultSet.getInt(5));
					datos.setBOD_CIUDAD_ID(resultSet.getInt(6));
					datos.setBOD_ZONA_ID(resultSet.getInt(7));
					datos.setBOD_ESTADO(resultSet.getInt(8));
				}
			});
			return datos;
		}
	
	
	 public Bodega buscarBodegaXId(int cli) throws SQLException {
		 Bodega datos = new Bodega();
			String[] parameters = { ""+cli };
			ProcedureUtil.executeSelectGestion("GL_PBuscarBodegaId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setBOD_ID(resultSet.getInt(1));
					datos.setBOD_NOMBRES(resultSet.getString(2));
					datos.setBOD_DIRECCION(resultSet.getString(3));
					datos.setBOD_TELEFONO(resultSet.getString(4));
					datos.setBOD_ID_TIPO(resultSet.getInt(5));
					datos.setBOD_CIUDAD_ID(resultSet.getInt(6));
					datos.setBOD_ZONA_ID(resultSet.getInt(7));
					datos.setBOD_ESTADO(resultSet.getInt(8));
				}
			});
			return datos;
		}
	
	
}
