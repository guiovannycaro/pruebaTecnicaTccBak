package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.ProductoInterfaseDao;
import com.tcc.gestion_logistica.model.Productos;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class ProductoControllerDao implements ProductoInterfaseDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Productos> listadoProducto() throws SQLException {
		ArrayList<Productos> listaProductos = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarProductos", parameters, resultSet -> {
			while (resultSet.next()) {
				Productos datos = new Productos();
				datos.setPRO_ID(resultSet.getInt(1));
				datos.setPRO_NOMBRES(resultSet.getString(2));
				datos.setPRO_DESCRIPCION(resultSet.getString(3));
				datos.setPRO_OBSERVACION(resultSet.getString(4));
				datos.setPROD_VALOR(resultSet.getString(5));
				datos.setPROD_CANTIDAD(resultSet.getString(6));
				datos.setPRO_ESTADO(resultSet.getInt(7));
				
				listaProductos.add(datos);
			}
		});
		return listaProductos;
	}
	
	public String crearProducto(Productos cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		
		System.out.println(cli.getPRO_NOMBRES() + " " + cli.getPRO_DESCRIPCION() + " " + cli.getPRO_OBSERVACION()
		+ " " + " "+ cli.getPROD_VALOR() + " " + cli.getPROD_CANTIDAD() + " " +cli.getPRO_ESTADO());
		
		
		
		String[] parameters = { cli.getPRO_NOMBRES(),""+cli.getPRO_DESCRIPCION(),cli.getPRO_OBSERVACION()
				,""+cli.getPROD_VALOR(),""+cli.getPROD_CANTIDAD(),""+cli.getPRO_ESTADO()
				};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarProductos", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarProducto(Productos cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli.getPRO_ID(),cli.getPRO_NOMBRES(),""+cli.getPRO_DESCRIPCION(),cli.getPRO_OBSERVACION()
				,""+cli.getPROD_VALOR(),""+cli.getPROD_CANTIDAD(),""+cli.getPRO_ESTADO()
				};
		ProcedureUtil.executeUpdateGestion("GL_PEditarProductos", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarProducto(int id) throws SQLException {
		log.warn("nuevo cliente : " + id );
		String[] parameters = { ""+id };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarProductos", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public Productos buscarProductoXNombre(Productos cli) throws SQLException {
		 Productos datos = new Productos();
			String[] parameters = { cli.getPRO_NOMBRES() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarProductosNombre", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setPRO_ID(resultSet.getInt(1));
					datos.setPRO_NOMBRES(resultSet.getString(2));
					datos.setPRO_DESCRIPCION(resultSet.getString(3));
					datos.setPRO_OBSERVACION(resultSet.getString(4));
					datos.setPROD_VALOR(resultSet.getString(5));
					datos.setPROD_CANTIDAD(resultSet.getString(6));
					datos.setPRO_ESTADO(resultSet.getInt(7));

				}
			});
			return datos;
		}
	
	
	 public Productos buscarProductoXId(int id) throws SQLException {
		 Productos datos = new Productos();
			String[] parameters = { ""+id };
			ProcedureUtil.executeSelectGestion("GL_PBuscarProductosId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setPRO_ID(resultSet.getInt(1));
					datos.setPRO_NOMBRES(resultSet.getString(2));
					datos.setPRO_DESCRIPCION(resultSet.getString(3));
					datos.setPRO_OBSERVACION(resultSet.getString(4));
					datos.setPROD_VALOR(resultSet.getString(5));
					datos.setPROD_CANTIDAD(resultSet.getString(6));
					datos.setPRO_ESTADO(resultSet.getInt(7));

				}
			});
			return datos;
		}
	
	
}
