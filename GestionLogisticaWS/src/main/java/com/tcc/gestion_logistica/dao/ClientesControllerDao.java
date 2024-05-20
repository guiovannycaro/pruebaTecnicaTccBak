package com.tcc.gestion_logistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tcc.gestion_logistica.interfaces.ClientesInterfaceDao;
import com.tcc.gestion_logistica.model.Clientes;
import com.tcc.gestion_logistica.util.ProcedureUtil;

public class ClientesControllerDao implements ClientesInterfaceDao{

	protected final Log log = LogFactory.getLog(this.getClass());
	
	
	public List<Clientes> listadoDeClientes() throws SQLException {
		ArrayList<Clientes> listaclientes = new ArrayList<>();
		String[] parameters = {};
		ProcedureUtil.executeSelectGestion("GL_PListarClientes", parameters, resultSet -> {
			while (resultSet.next()) {
				Clientes datos = new Clientes();
				datos.setCLI_ID(resultSet.getInt(1));
				datos.setCLI_NOMBRES(resultSet.getString(2));
				datos.setCLI_TIPODOCUMENTO(resultSet.getInt(3));
				datos.setCLI_CEDULA(resultSet.getString(4));
				datos.setCLI_CORREO(resultSet.getString(5));
				datos.setCLI_CELULAR(resultSet.getString(6));
				datos.setCLI_DIRECCION(resultSet.getString(7));
				datos.setCLI_CIUDAD_ID(resultSet.getInt(8));
				datos.setCLI_ESTADO(resultSet.getString(9));
				listaclientes.add(datos);
			}
		});
		return listaclientes;
	}
	
	public String crearCliente(Clientes cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { cli.getCLI_NOMBRES(),""+cli.getCLI_TIPODOCUMENTO(),cli.getCLI_CEDULA(),cli.getCLI_CORREO(),cli.getCLI_CELULAR(),cli.getCLI_DIRECCION()
				,""+cli.getCLI_CIUDAD_ID(),""+cli.getCLI_ESTADO()};
		ProcedureUtil.executeUpdateGestion("GL_PInsertarCliente", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
	}
	
	public String editarCliente(Clientes cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli.getCLI_ID(),cli.getCLI_NOMBRES(),""+cli.getCLI_TIPODOCUMENTO(),cli.getCLI_CEDULA(),cli.getCLI_CORREO(),cli.getCLI_CELULAR(),cli.getCLI_DIRECCION()
				,""+cli.getCLI_CIUDAD_ID(),""+cli.getCLI_ESTADO() };
		ProcedureUtil.executeUpdateGestion("GL_PEditarCliente", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue editado De Manera Correcta\"}";
	}
	
	public String eliminarCliente(int cli) throws SQLException {
		log.warn("nuevo cliente : " + cli );
		String[] parameters = { ""+cli };
		ProcedureUtil.executeUpdateGestion("GL_PEliminarCliente", parameters);
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
	}
	
	 public Clientes buscarClienteXNombre(Clientes cli) throws SQLException {
		 Clientes datos = new Clientes();
			String[] parameters = { cli.getCLI_NOMBRES() };
			ProcedureUtil.executeSelectGestion("GL_PBuscarClienteNombre", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setCLI_ID(resultSet.getInt(1));
					datos.setCLI_NOMBRES(resultSet.getString(2));
					datos.setCLI_TIPODOCUMENTO(resultSet.getInt(3));
					datos.setCLI_CEDULA(resultSet.getString(4));
					datos.setCLI_CORREO(resultSet.getString(5));
					datos.setCLI_CELULAR(resultSet.getString(6));
					datos.setCLI_DIRECCION(resultSet.getString(7));
					datos.setCLI_CIUDAD_ID(resultSet.getInt(8));
					datos.setCLI_ESTADO(resultSet.getString(9));
					
					
					
				}
			});
			return datos;
		}
	
	
	 public Clientes buscarClienteXId(int cli) throws SQLException {
		 Clientes datos = new Clientes();
			String[] parameters = { ""+cli };
			ProcedureUtil.executeSelectGestion("GL_PBuscarClienteId", parameters, resultSet -> {
				while (resultSet.next()) {
					datos.setCLI_ID(resultSet.getInt(1));
					datos.setCLI_NOMBRES(resultSet.getString(2));
					datos.setCLI_TIPODOCUMENTO(resultSet.getInt(3));
					datos.setCLI_CEDULA(resultSet.getString(4));
					datos.setCLI_CORREO(resultSet.getString(5));
					datos.setCLI_CELULAR(resultSet.getString(6));
					datos.setCLI_DIRECCION(resultSet.getString(7));
					datos.setCLI_CIUDAD_ID(resultSet.getInt(8));
					datos.setCLI_ESTADO(resultSet.getString(9));
					
					
					
				}
			});
			return datos;
		}
	
	
}
