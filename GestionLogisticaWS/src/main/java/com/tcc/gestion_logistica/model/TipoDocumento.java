package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "TipoDocumento", description = "Esta clase representa la informacion del TipoBodega")
public class TipoDocumento {
	@ApiModelProperty(value = "TDOC_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer TDOC_ID;
	@ApiModelProperty(value = "TDOC_NOMBRE", required = true, dataType = "String", example = "00000000", position = 2)
	String TDOC_NOMBRE;
	@ApiModelProperty(value = "TDOC_DESCRIPCION", required = true, dataType = "String", example = "00000000", position = 3)
	String TDOC_DESCRIPCION;

	
	public TipoDocumento() {
	}


	public TipoDocumento(Integer tDOC_ID, String tDOC_NOMBRE, String tDOC_DESCRIPCION) {
		TDOC_ID = tDOC_ID;
		TDOC_NOMBRE = tDOC_NOMBRE;
		TDOC_DESCRIPCION = tDOC_DESCRIPCION;
	}


	public Integer getTDOC_ID() {
		return TDOC_ID;
	}


	public void setTDOC_ID(Integer tDOC_ID) {
		TDOC_ID = tDOC_ID;
	}


	public String getTDOC_NOMBRE() {
		return TDOC_NOMBRE;
	}


	public void setTDOC_NOMBRE(String tDOC_NOMBRE) {
		TDOC_NOMBRE = tDOC_NOMBRE;
	}


	public String getTDOC_DESCRIPCION() {
		return TDOC_DESCRIPCION;
	}


	public void setTDOC_DESCRIPCION(String tDOC_DESCRIPCION) {
		TDOC_DESCRIPCION = tDOC_DESCRIPCION;
	}


	@Override
	public String toString() {
		return "TipoDocumento [TDOC_ID=" + TDOC_ID + ", TDOC_NOMBRE=" + TDOC_NOMBRE + ", TDOC_DESCRIPCION="
				+ TDOC_DESCRIPCION + "]";
	}



	
	
	
}
