package com.tcc.gestion_logistica.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Envio", description = "Esta clase representa la informacion del cliente")
public class Envio {
	@ApiModelProperty(value = "ENV_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer ENV_ID;
	@ApiModelProperty(value = "ENV_CLIE_ID", required = true, dataType = "Integer", example = "00000000", position = 2)
	Integer ENV_CLIE_ID;
	@ApiModelProperty(value = "ENV_TELEFONO", required = true, dataType = "String", example = "00000000", position = 3)
	String ENV_TELEFONO;
	@ApiModelProperty(value = "ENV_BOD_ID", required = true, dataType = "Integer", example = "00000000", position = 4)
	Integer ENV_BOD_ID;
	@ApiModelProperty(value = "ENV_FECHA_ENTREGA", required = true, dataType = "Date", example = "00000000", position = 5)
	String ENV_FECHA_ENTREGA;
	@ApiModelProperty(value = "ENV_FECHA_ENVIO", required = true, dataType = "Date", example = "00000000", position = 6)
	String ENV_FECHA_ENVIO;
	@ApiModelProperty(value = "ENV_ORIG_CIU_ID", required = true, dataType = "Integer", example = "00000000", position = 7)
	Integer ENV_ORIG_CIU_ID;
	@ApiModelProperty(value = "ENV_DEST_CIU_ID", required = true, dataType = "Integer", example = "00000000", position = 8)
	Integer ENV_DEST_CIU_ID;
	@ApiModelProperty(value = "ENV_ESTADO", required = true, dataType = "Integer", example = "00000000", position = 9)
	Integer ENV_ESTADO;
	@ApiModelProperty(value = "ENV_REFERENCIA", required = true, dataType = "String", example = "00000000", position = 9)
	String ENV_REFERENCIA;
	
	public Envio() {

	}


	

	public Envio(Integer eNV_ID, Integer eNV_CLIE_ID, String eNV_TELEFONO, Integer eNV_BOD_ID, String eNV_FECHA_ENTREGA,
			String eNV_FECHA_ENVIO, Integer eNV_ORIG_CIU_ID, Integer eNV_DEST_CIU_ID, Integer eNV_ESTADO,
			String eNV_REFERENCIA) {
		ENV_ID = eNV_ID;
		ENV_CLIE_ID = eNV_CLIE_ID;
		ENV_TELEFONO = eNV_TELEFONO;
		ENV_BOD_ID = eNV_BOD_ID;
		ENV_FECHA_ENTREGA = eNV_FECHA_ENTREGA;
		ENV_FECHA_ENVIO = eNV_FECHA_ENVIO;
		ENV_ORIG_CIU_ID = eNV_ORIG_CIU_ID;
		ENV_DEST_CIU_ID = eNV_DEST_CIU_ID;
		ENV_ESTADO = eNV_ESTADO;
		ENV_REFERENCIA = eNV_REFERENCIA;
	}




	public Integer getENV_ID() {
		return ENV_ID;
	}


	public void setENV_ID(Integer eNV_ID) {
		ENV_ID = eNV_ID;
	}


	public Integer getENV_CLIE_ID() {
		return ENV_CLIE_ID;
	}


	public void setENV_CLIE_ID(Integer eNV_CLIE_ID) {
		ENV_CLIE_ID = eNV_CLIE_ID;
	}


	public String getENV_TELEFONO() {
		return ENV_TELEFONO;
	}


	public void setENV_TELEFONO(String eNV_TELEFONO) {
		ENV_TELEFONO = eNV_TELEFONO;
	}


	public Integer getENV_BOD_ID() {
		return ENV_BOD_ID;
	}


	public void setENV_BOD_ID(Integer eNV_BOD_ID) {
		ENV_BOD_ID = eNV_BOD_ID;
	}


	public String getENV_FECHA_ENTREGA() {
		return ENV_FECHA_ENTREGA;
	}


	public void setENV_FECHA_ENTREGA(String eNV_FECHA_ENTREGA) {
		ENV_FECHA_ENTREGA = eNV_FECHA_ENTREGA;
	}


	public String getENV_FECHA_ENVIO() {
		return ENV_FECHA_ENVIO;
	}


	public void setENV_FECHA_ENVIO(String eNV_FECHA_ENVIO) {
		ENV_FECHA_ENVIO = eNV_FECHA_ENVIO;
	}


	public Integer getENV_ORIG_CIU_ID() {
		return ENV_ORIG_CIU_ID;
	}


	public void setENV_ORIG_CIU_ID(Integer eNV_ORIG_CIU_ID) {
		ENV_ORIG_CIU_ID = eNV_ORIG_CIU_ID;
	}


	public Integer getENV_DEST_CIU_ID() {
		return ENV_DEST_CIU_ID;
	}


	public void setENV_DEST_CIU_ID(Integer eNV_DEST_CIU_ID) {
		ENV_DEST_CIU_ID = eNV_DEST_CIU_ID;
	}


	public Integer getENV_ESTADO() {
		return ENV_ESTADO;
	}


	public void setENV_ESTADO(Integer eNV_ESTADO) {
		ENV_ESTADO = eNV_ESTADO;
	}


	public String getENV_REFERENCIA() {
		return ENV_REFERENCIA;
	}


	public void setENV_REFERENCIA(String eNV_REFERENCIA) {
		ENV_REFERENCIA = eNV_REFERENCIA;
	}


	@Override
	public String toString() {
		return "Envio [ENV_ID=" + ENV_ID + ", ENV_CLIE_ID=" + ENV_CLIE_ID + ", ENV_TELEFONO=" + ENV_TELEFONO
				+ ", ENV_BOD_ID=" + ENV_BOD_ID + ", ENV_FECHA_ENTREGA=" + ENV_FECHA_ENTREGA + ", ENV_FECHA_ENVIO="
				+ ENV_FECHA_ENVIO + ", ENV_ORIG_CIU_ID=" + ENV_ORIG_CIU_ID + ", ENV_DEST_CIU_ID=" + ENV_DEST_CIU_ID
				+ ", ENV_ESTADO=" + ENV_ESTADO + ", ENV_REFERENCIA=" + ENV_REFERENCIA + "]";
	}



	
	
}
