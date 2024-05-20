package com.tcc.gestion_logistica.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tcc.gestion_logistica.interfaces.ClientesInterface2;
import com.tcc.gestion_logistica.model.Clientes;
import com.tcc.gestion_logistica.util.executeQueryBD;

public class ClientesDao implements ClientesInterface2 {

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	@Override
	public List<Clientes> devolverListaClientes() throws Exception {
		ArrayList<Clientes> list = new ArrayList<>();
		String sql = "select * from clientes";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Clientes cli = new Clientes();
			cli.setCLI_ID(resulSelect.getInt("cli_id"));
			cli.setCLI_NOMBRES(resulSelect.getString("cli_nombres"));
			cli.setCLI_CORREO(resulSelect.getString("cli_correo"));
			cli.setCLI_CELULAR(resulSelect.getString("cli_celular"));
			cli.setCLI_DIRECCION(resulSelect.getString("cli_direccion"));
			cli.setCLI_CIUDAD_ID(resulSelect.getInt("cli_ciudad"));
			cli.setCLI_ESTADO(resulSelect.getString("cli_estado"));
			list.add(cli);
		}
		return list;
	}

	@Override
	public List<Clientes> devolverClienteById(int id) throws Exception {
		ArrayList<Clientes> list = new ArrayList<>();
		String sql = "select * from clientes where cli_id = '" + id + "' ";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			Clientes cli = new Clientes();
			cli.setCLI_ID(resulSelect.getInt("cli_id"));
			cli.setCLI_NOMBRES(resulSelect.getString("cli_nombres"));
			cli.setCLI_CORREO(resulSelect.getString("cli_correo"));
			cli.setCLI_CELULAR(resulSelect.getString("cli_celular"));
			cli.setCLI_DIRECCION(resulSelect.getString("cli_direccion"));
			cli.setCLI_CIUDAD_ID(resulSelect.getInt("cli_ciudad"));
			cli.setCLI_ESTADO(resulSelect.getString("cli_estado"));
			list.add(cli);
		}
		return list;
	}

	@Override
	public Clientes buscarClientePorDato(Clientes datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String agregarCliente(Clientes cli) throws Exception {
		String validaIngreso;
		String sql = "insert into  clientes (cli_nombres,cli_correo,cli_celular,cli_direccion"
				+ ",cli_ciudad,cli_estado) " + "values('" + cli.getCLI_NOMBRES() + "','" + cli.getCLI_CORREO() + "','"
				+ cli.getCLI_CELULAR() + "'," + "'" + cli.getCLI_DIRECCION() + "'," + cli.getCLI_CIUDAD_ID() + ","
				+ cli.getCLI_ESTADO() + ")  ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String actualizarCliente(Clientes cli) throws Exception {
		String validaIngreso;
		String sql = "Update   clientes SET "
				+ "cli_nombres = '" + cli.getCLI_NOMBRES() + "',"
				+ "cli_correo = '" + cli.getCLI_CORREO() + "',"
				+ "cli_celular = '" + cli.getCLI_CELULAR() + "',"
				+ "cli_direccion = '" + cli.getCLI_DIRECCION() + "',"
				+ "cli_ciudad = '" + cli.getCLI_CIUDAD_ID() + "',"
				+ "cli_estado = '" + cli.getCLI_ESTADO() + "' "
				+ " WHERE cli_id = " + cli.getCLI_ID() + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue EDITADO De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue EDITADO De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String eliminarCliente(int id) throws Exception {
		String validaIngreso;
		String sql = "Delete from  clientes "
				+ " WHERE cli_id = " + id + " ";

		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue eliminado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public Clientes buscarClienteXId(Clientes cli) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
