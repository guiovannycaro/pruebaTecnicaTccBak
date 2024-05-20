package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.DeralleEnviointerfaceDao;
import com.tcc.gestion_logistica.model.DatosEnvio;
import com.tcc.gestion_logistica.model.DetalleEnvio;
import com.tcc.gestion_logistica.model.Productos;
import com.tcc.gestion_logistica.util.ProcedureUtil;

import io.swagger.annotations.ApiModelProperty;

public class DetalleEnvioControllerDao implements DeralleEnviointerfaceDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<DetalleEnvio> listadoDetalleEnvio() throws SQLException {
		ArrayList<DetalleEnvio> listadetallee = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarDetalleEnvio", parameters, resultSet -> {
			while (resultSet.next()) {
				DetalleEnvio datos = new DetalleEnvio();
				datos.setENVD_ID(resultSet.getInt(1));
				datos.setENVD_PROD_ID(resultSet.getInt(2));	
				datos.setENVD_CANTIDAD(resultSet.getInt(3));		
				datos.setENVD_PRECIO(resultSet.getInt(4));	
				datos.setENVD_SUBTOTAL(resultSet.getInt(5));	
				datos.setENVD_IVA(resultSet.getInt(6));	
				datos.setENVD_TOTAL(resultSet.getInt(7));	
				datos.setENVD_DESCUENTO(resultSet.getInt(8));	
				datos.setENVD_ENV_ID(resultSet.getInt(9));
				 
			
				listadetallee.add(datos);
			}
		});
		return listadetallee;
	}
	
	public String crearDetalleEnvio(DatosEnvio cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		ProductoControllerDao pr = new ProductoControllerDao();
		        
		Productos p = pr.buscarProductoXId(cli.getDATENV_ID());
		
		System.err.println("viene front " + " "+ cli.getDATENV_ID() + " " +cli.getDATENV_CANTIDAD() + " " +p.getPROD_VALOR());
		
		int total = Integer.parseInt(p.getPROD_VALOR()) * cli.getDATENV_CANTIDAD();
		
		System.err.println("viene front 2 " + " "+ cli.getDATENV_ID() + " " +cli.getDATENV_CANTIDAD() + " " +p.getPROD_VALOR() + " " +total + " "+cli.getDATENV_REF()) ;
		
		String[] parameters = { ""+cli.getDATENV_ID(),
				""+cli.getDATENV_CANTIDAD(),
				""+p.getPROD_VALOR(),
				""+total ,
				""+cli.getDATENV_REF()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarDetalleEnvioTemp", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarDetalleEnvio(DetalleEnvio cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli.getENVD_ID(),""+cli.getENVD_PROD_ID(),""+cli.getENVD_CANTIDAD(),""+cli.getENVD_PRECIO(),""+cli.getENVD_SUBTOTAL(),""+cli.getENVD_IVA(),
				""+cli.getENVD_TOTAL(),""+cli.getENVD_DESCUENTO(),""+cli.getENVD_ENV_ID() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarDetalleEnvio", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarDetalleEnvio(int cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		System.out.println("dato a enviar al procedimiento" + cli);
		String[] parameters = { ""+cli };
		
		ProcedureUtil.executeUpdateGestion("GL_PEliminarDetalleEnvio", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public DetalleEnvio buscarDetalleEnvioXNombreProducto(DetalleEnvio cli) throws SQLException {
		 DetalleEnvio datos = new DetalleEnvio();
			String[] parameters = { ""+cli.getENVD_PROD_ID() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarDetalleEnvioProducto", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setENVD_ID(resultSet.getInt(1));
					datos.setENVD_PROD_ID(resultSet.getInt(2));	
					datos.setENVD_CANTIDAD(resultSet.getInt(3));		
					datos.setENVD_PRECIO(resultSet.getInt(4));	
					datos.setENVD_SUBTOTAL(resultSet.getInt(5));	
					datos.setENVD_IVA(resultSet.getInt(6));	
					datos.setENVD_TOTAL(resultSet.getInt(7));	
					datos.setENVD_DESCUENTO(resultSet.getInt(8));	
					datos.setENVD_ENV_ID(resultSet.getInt(9));
					 
					
					
					
				}
			});
			return datos;
		}
	
	
	 public DetalleEnvio buscarDetalleEnvioXId(int cli) throws SQLException {
		 DetalleEnvio datos = new DetalleEnvio();
			String[] parameters = { ""+cli };
			ProcedureUtil.executeSelectGestion("GL_PBuscarDetalleEnvioId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setENVD_ID(resultSet.getInt(1));
					datos.setENVD_PROD_ID(resultSet.getInt(2));	
					datos.setENVD_CANTIDAD(resultSet.getInt(3));		
					datos.setENVD_PRECIO(resultSet.getInt(4));	
					datos.setENVD_SUBTOTAL(resultSet.getInt(5));	
					datos.setENVD_IVA(resultSet.getInt(6));	
					datos.setENVD_TOTAL(resultSet.getInt(7));	
					datos.setENVD_DESCUENTO(resultSet.getInt(8));	
					datos.setENVD_ENV_ID(resultSet.getInt(9));
					 
					
					
					
				}
			});
			return datos;
		}
	
	
}
