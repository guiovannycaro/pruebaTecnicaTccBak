package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "TipoProducto", description = "Esta clase representa la informacion del TipoProducto")
public class TipoProducto {
	@ApiModelProperty(value = "TIPOPR_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer TIPOPR_ID;
	@ApiModelProperty(value = "TIPOPR_NOMBRE", required = true, dataType = "String", example = "00000000", position = 2)
	String TIPOPR_NOMBRE;
	@ApiModelProperty(value = "TIPOPR_DESCRIPCION", required = true, dataType = "String", example = "00000000", position = 3)
	String TIPOPR_DESCRIPCION;

	
	public TipoProducto() {
	}


	public TipoProducto(Integer tIPOPR_ID, String tIPOPR_NOMBRE, String tIPOPR_DESCRIPCION) {
		super();
		TIPOPR_ID = tIPOPR_ID;
		TIPOPR_NOMBRE = tIPOPR_NOMBRE;
		TIPOPR_DESCRIPCION = tIPOPR_DESCRIPCION;
	}


	public Integer getTIPOPR_ID() {
		return TIPOPR_ID;
	}


	public void setTIPOPR_ID(Integer tIPOPR_ID) {
		TIPOPR_ID = tIPOPR_ID;
	}


	public String getTIPOPR_NOMBRE() {
		return TIPOPR_NOMBRE;
	}


	public void setTIPOPR_NOMBRE(String tIPOPR_NOMBRE) {
		TIPOPR_NOMBRE = tIPOPR_NOMBRE;
	}


	public String getTIPOPR_DESCRIPCION() {
		return TIPOPR_DESCRIPCION;
	}


	public void setTIPOPR_DESCRIPCION(String tIPOPR_DESCRIPCION) {
		TIPOPR_DESCRIPCION = tIPOPR_DESCRIPCION;
	}


	@Override
	public String toString() {
		return "TipoProducto [TIPOPR_ID=" + TIPOPR_ID + ", TIPOPR_NOMBRE=" + TIPOPR_NOMBRE + ", TIPOPR_DESCRIPCION="
				+ TIPOPR_DESCRIPCION + "]";
	}
	
	
	
	
}
