package com.tcc.gestion_logistica.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tcc.gestion_logistica.interfaces.DetalleEnvioInterface;
import com.tcc.gestion_logistica.model.Clientes;
import com.tcc.gestion_logistica.model.DetalleEnvio;
import com.tcc.gestion_logistica.model.Envio;
import com.tcc.gestion_logistica.model.Operaciones;
import com.tcc.gestion_logistica.model.Productos;
import com.tcc.gestion_logistica.util.executeQueryBD;

public class DetalleEnvioDao implements DetalleEnvioInterface{

	
	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;

	EnvioDao envio = null;
	ProductoDao prod = null;
	@Override
	public List<DetalleEnvio> devolverListaDetalleEnvio() throws Exception {
		ArrayList<DetalleEnvio> list = new ArrayList<>();
		String sql = "select * from detalleenvio";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			DetalleEnvio cli = new DetalleEnvio();
			cli.setENVD_ID(resulSelect.getInt("envd_id"));
			cli.setENVD_PROD_ID(resulSelect.getInt("envd_prod_id"));
			cli.setENVD_CANTIDAD(resulSelect.getInt("envd_cantidad"));
			cli.setENVD_PRECIO(resulSelect.getDouble("envd_precio"));
			cli.setENVD_SUBTOTAL(resulSelect.getDouble("envd_subtotal"));
			cli.setENVD_IVA(resulSelect.getInt("envd_iva"));
			cli.setENVD_DESCUENTO(resulSelect.getDouble("envd_descuento"));
			cli.setENVD_TOTAL(resulSelect.getDouble("envd_total"));
			cli.setENVD_ENV_ID(resulSelect.getInt("envd_env_id"));
			list.add(cli);

		}
		return list;
	}

	@Override
	public List<DetalleEnvio> devolverDetalleEnvioById(int id) throws Exception {
		ArrayList<DetalleEnvio> list = new ArrayList<>();
		String sql = "select * from detalleenvio where envd_id = " + id 
				
				+ "";
		resulSelect = query.executeSelectBd(sql);
		while (resulSelect.next()) {
			DetalleEnvio cli = new DetalleEnvio();
			cli.setENVD_ID(resulSelect.getInt("envd_id"));
			cli.setENVD_PROD_ID(resulSelect.getInt("envd_prod_id"));
			cli.setENVD_CANTIDAD(resulSelect.getInt("envd_cantidad"));
			cli.setENVD_PRECIO(resulSelect.getDouble("envd_precio"));
			cli.setENVD_SUBTOTAL(resulSelect.getDouble("envd_subtotal"));
			cli.setENVD_IVA(resulSelect.getInt("envd_iva"));
			cli.setENVD_DESCUENTO(resulSelect.getDouble("envd_descuento"));
			cli.setENVD_TOTAL(resulSelect.getDouble("envd_total"));
			cli.setENVD_ENV_ID(resulSelect.getInt("envd_env_id"));
			list.add(cli);

		}
		return list;
	}

	@Override
	public DetalleEnvio buscarTipoDetalleEnvioPorDato(DetalleEnvio datos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String agregarDetalleEnvio(int idcliente,DetalleEnvio datos) throws Exception {
		// TODO Auto-generated method stub
		Envio dtenvio = envio.validarEnvioById(idcliente);
		
		datos.getENVD_ID();
		datos.getENVD_PROD_ID();
		datos.getENVD_CANTIDAD();
		datos.getENVD_PRECIO();
		
	     dtenvio.getENV_ID();
	

		Productos p = prod.validarProductoById(datos.getENVD_PROD_ID());

		if (p == null) {
			System.out.println("el producto no existe");
		}

		double vunitario =   Double.parseDouble(p.getPROD_VALOR());
		double vcantidad = datos.getENVD_CANTIDAD();
		

		double valneto = vunitario * vcantidad;
		
		Operaciones  po  = realisarOperaciones(vunitario,vcantidad,valneto);
		

		datos.getENVD_SUBTOTAL();
		datos.getENVD_IVA();
		datos.getENVD_DESCUENTO();
		datos.getENVD_TOTAL();
		
		
		String validaIngreso;
		String sql = "insert into  detalleenvio (envd_prod_id,envd_cantidad,envd_precio,envd_sutotal"
				+ ",envd_iva,envd_descuento,envd_total,envd_env_id) values "
				+ "(  " + datos.getENVD_PROD_ID() + ","
					+ "'" + datos.getENVD_CANTIDAD() + "',"
					+ "'" + datos.getENVD_PRECIO() + "',"
					+ "" + "" + datos.getENVD_SUBTOTAL() + ","
					+ "" + datos.getENVD_IVA() + ","
					+ "'" + datos.getENVD_DESCUENTO() + "',"
					+ "" + datos.getENVD_TOTAL() +" ,"
					+ "" + dtenvio.getENV_ID() +")  ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
	}



	@Override
	public String eliminarDetalleEnvio(int id) throws Exception {
		String validaIngreso;
		String sql = "Delete from  detalleenvio "
				+ " WHERE envd_id = " + id + " ";

		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue eliminado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	public Operaciones realisarOperaciones(double vunitario,double vcantidad,double valneto) {
		
		double subtotal = 0;
		double subtotald = 0;
		double subtotalt = 0;
		double viva = 0;
		double total = 0;
		double descuento = 0;
		Operaciones op = new Operaciones();
		
		if (vcantidad >= 10 ) {
			descuento = valneto * 5 / 100;
			subtotald = valneto - descuento;
		}

		if (vcantidad >= 10 ) {
			descuento = valneto * 3 / 100;
			subtotalt = valneto - descuento;
		}

		if (subtotald > 0) {
			subtotal = subtotald;
		} else {
			subtotal = valneto;
		}

		if (subtotalt > 0) {
			subtotal = subtotalt;
		} else {
			subtotal = valneto;
		}

		viva = subtotal * 19 / 100;

		total = viva + subtotal;
       
		op.setDescuento(descuento);
		op.setSubtotal(subtotal);
		op.setViva(viva);
		op.setTotal(total);
		
		
		return op;
	}
}
