package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.EnvioInterfaceDao;
import com.tcc.gestion_logistica.model.Envio;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class EnvioControllerDao implements EnvioInterfaceDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Envio> listadoEnvio() throws SQLException {
		ArrayList<Envio> listaclientes = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarEnvio", parameters, resultSet -> {
			while (resultSet.next()) {
				Envio datos = new Envio();
				datos.setENV_ID(resultSet.getInt(1));
				datos.setENV_CLIE_ID(resultSet.getInt(2));
				datos.setENV_TELEFONO(resultSet.getString(3));
				datos.setENV_BOD_ID(resultSet.getInt(4));
				datos.setENV_FECHA_ENTREGA(resultSet.getString(5));
				datos.setENV_FECHA_ENVIO(resultSet.getString(6));
				datos.setENV_ORIG_CIU_ID(resultSet.getInt(7));
				datos.setENV_DEST_CIU_ID(resultSet.getInt(8));
				datos.setENV_ESTADO(resultSet.getInt(9));
				datos.setENV_REFERENCIA(resultSet.getString(10));
				listaclientes.add(datos);
			}
		});
		return listaclientes;
	}
	
	public String crearEnvio(Envio cli) throws SQLException {
		log.warn("nuevo Envio : " + cli );
		String[] parameters = { ""+cli.getENV_CLIE_ID(),cli.getENV_TELEFONO(),""+cli.getENV_BOD_ID(),
				""+cli.getENV_FECHA_ENTREGA(),""+cli.getENV_FECHA_ENVIO(),""+cli.getENV_ORIG_CIU_ID()
				,""+cli.getENV_DEST_CIU_ID(),""+cli.getENV_ESTADO(),cli.getENV_REFERENCIA()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarEnvio", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	
	public String envioEnvioTemporal(Envio cli) throws SQLException {
		log.warn("nuevo Envio : " + cli );
		
		cli.getENV_REFERENCIA();
		String[] parameters = { cli.getENV_REFERENCIA()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarEnvioDetalleTemporal", parameters);
		limpiarDetalleEnvio(cli);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	
	public String limpiarDetalleEnvio(Envio cli) throws SQLException {
		log.warn("nuevo Envio : " + cli );
		
		cli.getENV_REFERENCIA();
		String[] parameters = { cli.getENV_REFERENCIA()};
		ProcedureUtil.executeUpdateGestion("GL_PlimpiarEnvioDetalle", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	
	public String editarEnvio(Envio cli) throws SQLException {
		log.warn("nuevo Envio : " + cli );
		String[] parameters = { ""+cli.getENV_ID(),""+cli.getENV_CLIE_ID(),cli.getENV_TELEFONO(),""+cli.getENV_BOD_ID(),
				""+cli.getENV_FECHA_ENTREGA(),""+cli.getENV_FECHA_ENVIO(),""+cli.getENV_ORIG_CIU_ID()
				,""+cli.getENV_DEST_CIU_ID(),""+cli.getENV_ESTADO() };
		
		ProcedureUtil.executeUpdateGestion("GL_PEditarEnvio", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarEnvio(int id) throws SQLException {
		log.warn("nuevo Envioe : " + id );
		String[] parameters = { ""+id };
		
		ProcedureUtil.executeUpdateGestion("GL_PEliminarEnvio", parameters);
		
		eliminarEnvioTemp(id);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
		
	}
	
	public String eliminarEnvioTemp(int id) throws SQLException {
		log.warn("nuevo Envioe : " + id );
		String[] parameters = { ""+id };
		
		
		ProcedureUtil.executeUpdateGestion("GL_PEliminarEnvioDetallTem", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	
	 public Envio buscarEnvioXCliente(Envio cli) throws SQLException {
		 Envio datos = new Envio();
			String[] parameters = { ""+cli.getENV_CLIE_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarEnvioCliente", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setENV_ID(resultSet.getInt(1));
					datos.setENV_CLIE_ID(resultSet.getInt(2));
					datos.setENV_TELEFONO(resultSet.getString(3));
					datos.setENV_BOD_ID(resultSet.getInt(4));
					datos.setENV_FECHA_ENTREGA(resultSet.getString(5));
					datos.setENV_FECHA_ENVIO(resultSet.getString(6));
					datos.setENV_ORIG_CIU_ID(resultSet.getInt(7));
					datos.setENV_DEST_CIU_ID(resultSet.getInt(8));
					datos.setENV_ESTADO(resultSet.getInt(9));
					datos.setENV_REFERENCIA(resultSet.getString(10));
					
					
				}
			});
			return datos;
		}
	
	
	 public Envio buscarEnvioXId(int id) throws SQLException {
		 Envio datos = new Envio();
			String[] parameters = { ""+id };
			ProcedureUtil.executeSelectGestion("GL_PBuscarEnvioId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setENV_ID(resultSet.getInt(1));
					datos.setENV_CLIE_ID(resultSet.getInt(2));
					datos.setENV_TELEFONO(resultSet.getString(3));
					datos.setENV_BOD_ID(resultSet.getInt(4));
					datos.setENV_FECHA_ENTREGA(resultSet.getString(5));
					datos.setENV_FECHA_ENVIO(resultSet.getString(6));
					datos.setENV_ORIG_CIU_ID(resultSet.getInt(7));
					datos.setENV_DEST_CIU_ID(resultSet.getInt(8));
					datos.setENV_ESTADO(resultSet.getInt(9));
					datos.setENV_REFERENCIA(resultSet.getString(10));
					
					
				}
			});
			return datos;
		}


	
	
}
