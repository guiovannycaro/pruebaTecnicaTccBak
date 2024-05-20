package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "TipoBodega", description = "Esta clase representa la informacion del TipoBodega")
public class TipoBodega {
	@ApiModelProperty(value = "TIPOB_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer TIPOB_ID;
	@ApiModelProperty(value = "TIPOB_NOMBRE", required = true, dataType = "String", example = "00000000", position = 2)
	String TIPOB_NOMBRE;
	@ApiModelProperty(value = "TIPOB_DESCRIPCION", required = true, dataType = "String", example = "00000000", position = 3)
	String TIPOB_DESCRIPCION;
	
	
	public TipoBodega() {
	}


	public TipoBodega(Integer tIPOB_ID, String tIPOB_NOMBRE, String tIPOB_DESCRIPCION) {
		super();
		TIPOB_ID = tIPOB_ID;
		TIPOB_NOMBRE = tIPOB_NOMBRE;
		TIPOB_DESCRIPCION = tIPOB_DESCRIPCION;
	}


	public Integer getTIPOB_ID() {
		return TIPOB_ID;
	}


	public void setTIPOB_ID(Integer tIPOB_ID) {
		TIPOB_ID = tIPOB_ID;
	}


	public String getTIPOB_NOMBRE() {
		return TIPOB_NOMBRE;
	}


	public void setTIPOB_NOMBRE(String tIPOB_NOMBRE) {
		TIPOB_NOMBRE = tIPOB_NOMBRE;
	}


	public String getTIPOB_DESCRIPCION() {
		return TIPOB_DESCRIPCION;
	}


	public void setTIPOB_DESCRIPCION(String tIPOB_DESCRIPCION) {
		TIPOB_DESCRIPCION = tIPOB_DESCRIPCION;
	}


	@Override
	public String toString() {
		return "TipoBodega [TIPOB_ID=" + TIPOB_ID + ", TIPOB_NOMBRE=" + TIPOB_NOMBRE + ", TIPOB_DESCRIPCION="
				+ TIPOB_DESCRIPCION + "]";
	}
	
	
	
}
