package com.tcc.gestion_logistica.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Cliente", description = "Esta clase representa la informacion del cliente")
public class Clientes {

	@ApiModelProperty(value = "CLI_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer CLI_ID;
	@ApiModelProperty(value = "CLI_NOMBRES", required = true, dataType = "String", example = "000", position = 2)
	String CLI_NOMBRES;
	@ApiModelProperty(value = "CLI_TIPODOCUMENTO", required = true, dataType = "Integer", example = "true", position = 3)
	Integer CLI_TIPODOCUMENTO;
	@ApiModelProperty(value = "CLI_CEDULA", required = true, dataType = "Integer", example = "000", position = 4)
	String CLI_CEDULA;
	@ApiModelProperty(value = "CLI_CORREO", required = true, dataType = "String", example = "000", position = 5)
	String CLI_CORREO;
	
	@ApiModelProperty(value = "CLI_CELULAR", required = true, dataType = "String", example = "000", position = 6)
	String CLI_CELULAR;
	
	@ApiModelProperty(value = "CLI_DIRECCION", required = true, dataType = "String", example = "000", position = 7)
	String CLI_DIRECCION;
	@ApiModelProperty(value = "CLI_CIUDAD_ID", required = true, dataType = "Integer", example = "000", position = 8)
	Integer CLI_CIUDAD_ID;
	@ApiModelProperty(value = "CLI_ESTADO", required = true, dataType = "Boolean", example = "true", position = 9)
	String CLI_ESTADO;

	
	public Clientes() {
	}


	public Clientes(Integer cLI_ID, String cLI_NOMBRES, Integer cLI_TIPODOCUMENTO, String cLI_CEDULA, String cLI_CORREO,
			String cLI_CELULAR, String cLI_DIRECCION, Integer cLI_CIUDAD_ID, String cLI_ESTADO) {
		super();
		CLI_ID = cLI_ID;
		CLI_NOMBRES = cLI_NOMBRES;
		CLI_TIPODOCUMENTO = cLI_TIPODOCUMENTO;
		CLI_CEDULA = cLI_CEDULA;
		CLI_CORREO = cLI_CORREO;
		CLI_CELULAR = cLI_CELULAR;
		CLI_DIRECCION = cLI_DIRECCION;
		CLI_CIUDAD_ID = cLI_CIUDAD_ID;
		CLI_ESTADO = cLI_ESTADO;
	}


	public Integer getCLI_ID() {
		return CLI_ID;
	}


	public void setCLI_ID(Integer cLI_ID) {
		CLI_ID = cLI_ID;
	}


	public String getCLI_NOMBRES() {
		return CLI_NOMBRES;
	}


	public void setCLI_NOMBRES(String cLI_NOMBRES) {
		CLI_NOMBRES = cLI_NOMBRES;
	}


	public Integer getCLI_TIPODOCUMENTO() {
		return CLI_TIPODOCUMENTO;
	}


	public void setCLI_TIPODOCUMENTO(Integer cLI_TIPODOCUMENTO) {
		CLI_TIPODOCUMENTO = cLI_TIPODOCUMENTO;
	}


	public String getCLI_CEDULA() {
		return CLI_CEDULA;
	}


	public void setCLI_CEDULA(String cLI_CEDULA) {
		CLI_CEDULA = cLI_CEDULA;
	}


	public String getCLI_CORREO() {
		return CLI_CORREO;
	}


	public void setCLI_CORREO(String cLI_CORREO) {
		CLI_CORREO = cLI_CORREO;
	}


	public String getCLI_CELULAR() {
		return CLI_CELULAR;
	}


	public void setCLI_CELULAR(String cLI_CELULAR) {
		CLI_CELULAR = cLI_CELULAR;
	}


	public String getCLI_DIRECCION() {
		return CLI_DIRECCION;
	}


	public void setCLI_DIRECCION(String cLI_DIRECCION) {
		CLI_DIRECCION = cLI_DIRECCION;
	}


	public Integer getCLI_CIUDAD_ID() {
		return CLI_CIUDAD_ID;
	}


	public void setCLI_CIUDAD_ID(Integer cLI_CIUDAD_ID) {
		CLI_CIUDAD_ID = cLI_CIUDAD_ID;
	}


	public String getCLI_ESTADO() {
		return CLI_ESTADO;
	}


	public void setCLI_ESTADO(String cLI_ESTADO) {
		CLI_ESTADO = cLI_ESTADO;
	}


	@Override
	public String toString() {
		return "Clientes [CLI_ID=" + CLI_ID + ", CLI_NOMBRES=" + CLI_NOMBRES + ", CLI_TIPODOCUMENTO="
				+ CLI_TIPODOCUMENTO + ", CLI_CEDULA=" + CLI_CEDULA + ", CLI_CORREO=" + CLI_CORREO + ", CLI_CELULAR="
				+ CLI_CELULAR + ", CLI_DIRECCION=" + CLI_DIRECCION + ", CLI_CIUDAD_ID=" + CLI_CIUDAD_ID
				+ ", CLI_ESTADO=" + CLI_ESTADO + "]";
	}


	
}
