package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.DeralleEnvioTempinterfaceDao;
import com.tcc.gestion_logistica.model.DatosEnvioD;
import com.tcc.gestion_logistica.model.DetalleEnvioTemp;
import com.tcc.gestion_logistica.model.Productos;
import com.tcc.gestion_logistica.model.Usuarios;
import com.tcc.gestion_logistica.util.ProcedureUtil;

import io.swagger.annotations.ApiModelProperty;

public class DetalleEnvioControllerTempDao implements DeralleEnvioTempinterfaceDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<DetalleEnvioTemp> listadoDetalleEnvioTemp() throws SQLException {
		ArrayList<DetalleEnvioTemp> listadetallee = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarDetalleEnvioTemp", parameters, resultSet -> {
			while (resultSet.next()) {
				DetalleEnvioTemp datos = new DetalleEnvioTemp();
				datos.setENVDT_PROD_ID(resultSet.getString(1));
				datos.setENVDT_CANTIDAD(resultSet.getString(2));	
				datos.setENVDT_PRECIO(resultSet.getString(3));		
				datos.setENVDT_TOTAL(resultSet.getString(4));	
				datos.setENVDT_ID(resultSet.getString(5));	
				datos.setENVDT_IDP(resultSet.getInt(6));	
			
				listadetallee.add(datos);
			}
		});
		return listadetallee;
	}
	
	public String crearDetalleEnvioTemp(DatosEnvioD cli) throws SQLException {
		
		log.warn("nuevo cliente : " + cli );
		
		ProductoControllerDao pr = new ProductoControllerDao();
        
		Productos p = pr.buscarProductoXId(cli.getDATENV_ID());
		System.err.println("viene front crear detalle envio " + " "+ cli.getDATENV_ID() + " " +cli.getDATENV_CANTIDAD() + " " +p.getPROD_VALOR());
		
		int total = Integer.parseInt(p.getPROD_VALOR()) * cli.getDATENV_CANTIDAD();
		
		
		
System.err.println("viene front " + " "+ cli.getDATENV_ID() + " " +cli.getDATENV_CANTIDAD() + " " +p.getPROD_VALOR() + " " +total  + " " +cli.getDATENV_REF()) ;
		
		String[] parameters = { ""+cli.getDATENV_ID(),""+cli.getDATENV_CANTIDAD(),""+p.getPROD_VALOR(),""+total,""+cli.getDATENV_REF()};
		
		ProcedureUtil.executeUpdateGestion("GL_PInsertarDetalleEnvioTempD", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarDetalleEnvioTemp(DetalleEnvioTemp cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli.getENVDT_PROD_ID(),""+cli.getENVDT_CANTIDAD(),""+cli.getENVDT_PRECIO(),""+cli.getENVDT_PRECIO(),""+cli.getENVDT_TOTAL(),
				""+cli.getENVDT_ID()};
		ProcedureUtil.executeUpdateGestion("GL_PEditarDetalleEnvioTemp", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarDetalleEnvioTemp(int cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarDetalleEnvioTemp", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public DetalleEnvioTemp buscarDetalleEnvioTempXNombreProducto(DetalleEnvioTemp cli) throws SQLException {
		 DetalleEnvioTemp datos = new DetalleEnvioTemp();
			String[] parameters = { ""+cli.getENVDT_PROD_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarDetalleEnvioTempProducto", parameters, resultSet -> {
				while (resultSet.next()) {
					
					datos.setENVDT_PROD_ID(resultSet.getString(1));
					datos.setENVDT_CANTIDAD(resultSet.getString(2));	
					datos.setENVDT_PRECIO(resultSet.getString(3));		
					datos.setENVDT_TOTAL(resultSet.getString(4));	
					datos.setENVDT_ID(resultSet.getString(5));	
					datos.setENVDT_IDP(resultSet.getInt(6));	
				}
			});
			return datos;
		}
	
	
	 public List<DetalleEnvioTemp> buscarDetalleEnvioTempXId(int cli) throws SQLException {
			ArrayList<DetalleEnvioTemp> listadetallee = new ArrayList<>();
		
			String[] parameters = { ""+cli };
			ProcedureUtil.executeSelectGestion("GL_PBuscarDetalleEnvioTempId", parameters, resultSet -> {
				while (resultSet.next()) {
					 DetalleEnvioTemp datos = new DetalleEnvioTemp();
					datos.setENVDT_PROD_ID(resultSet.getString(1));
					datos.setENVDT_CANTIDAD(resultSet.getString(2));	
					datos.setENVDT_PRECIO(resultSet.getString(3));		
					datos.setENVDT_TOTAL(resultSet.getString(4));	
					datos.setENVDT_ID(resultSet.getString(5));	
					datos.setENVDT_IDP(resultSet.getInt(6));	
					listadetallee.add(datos);
				}
			});
			return listadetallee;
		}
	 


	


	
	
}
