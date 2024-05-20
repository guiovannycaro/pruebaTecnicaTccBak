package com.tcc.gestion_logistica.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tcc.gestion_logistica.interfaces.TipoDocumentoInterface;
import com.tcc.gestion_logistica.model.TipoDocumento;
import com.tcc.gestion_logistica.util.executeQueryBD;

public class TipoDocumentoDao implements   TipoDocumentoInterface{

	executeQueryBD query = new executeQueryBD();
	ResultSet resulSelect;
	@Override
	public List<TipoDocumento> devolverListaTipoDocumento() throws Exception {
		
		ArrayList<TipoDocumento> list = new ArrayList<>();
		String sql = "select * from tipodocumento";
		resulSelect = query.executeSelectBd(sql);
		
		while (resulSelect.next()) {
			TipoDocumento td = new TipoDocumento();
			td.setTDOC_ID(resulSelect.getInt("tdoc_id"));
			td.setTDOC_NOMBRE(resulSelect.getString("tdoc_nombre"));
			td.setTDOC_DESCRIPCION(resulSelect.getString("tdoc_descripcion"));
			
			list.add(td);
		}
		return list;
	}

	@Override
	public List<TipoDocumento> devolverTipoDocumentoById(int id) throws Exception {
		
		ArrayList<TipoDocumento> list = new ArrayList<>();
		String sql = "select * from tipodocumento where tdoc_id = "+id+"";
		resulSelect = query.executeSelectBd(sql);
		
		while (resulSelect.next()) {
			TipoDocumento td = new TipoDocumento();
			td.setTDOC_ID(resulSelect.getInt("tdoc_id"));
			td.setTDOC_NOMBRE(resulSelect.getString("tdoc_nombre"));
			td.setTDOC_DESCRIPCION(resulSelect.getString("tdoc_descripcion"));
			
			list.add(td);
		}
		return list;
	}

	@Override
	public TipoDocumento buscarTipoDocumentoPorDato(TipoDocumento datos) throws Exception {
		// TODO Auto-generated method stub
		TipoDocumento list = null ;
		String sql = "select * from tipodocumento where tdoc_id = "+datos+"";
		resulSelect = query.executeSelectBd(sql);
		
		while (resulSelect.next()) {
			TipoDocumento td = new TipoDocumento();
			td.setTDOC_ID(resulSelect.getInt("tdoc_id"));
			td.setTDOC_NOMBRE(resulSelect.getString("tdoc_nombre"));
			td.setTDOC_DESCRIPCION(resulSelect.getString("tdoc_descripcion"));
			
			list = td;
		}
		return list;
	}

	@Override
	public String agregarTipoDocumento(TipoDocumento tp) throws Exception {
		String validaIngreso;
		String sql = "insert into  tipodocumento (tdoc_nombres,tdoc_descripcion) "
			    + " values ('" + tp.getTDOC_NOMBRE() + "','" + tp.getTDOC_DESCRIPCION() + "')  ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue ingresado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String actualizarTipoDocumento(TipoDocumento tp) throws Exception {
		
		String validaIngreso;
		String sql = "Update   tipodocumento SET "
				+ "tdoc_nombres = '" + tp.getTDOC_NOMBRE() + "',"
				+ "tdoc_descripcion = '" + tp.getTDOC_DESCRIPCION() + "'"
				+ " WHERE tdoc_id = " + tp.getTDOC_ID() + " ";
		
		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue EDITADO De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue EDITADO De Manera Correcta\"}";
		}
		return validaIngreso;
	}

	@Override
	public String eliminarTipoDocumento(int id) throws Exception {
		String validaIngreso;
		String sql = "Delete from  tipodocumento "
				+ " WHERE tdoc_id = " + id + " ";

		boolean rpt = query.executeUpdateBd(sql);
		if (rpt = true) {
			validaIngreso = "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue eliminado De Manera Correcta\"}";
		} else {
			validaIngreso = "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue eliminado De Manera Correcta\"}";
		}
		return validaIngreso;
	}

}
