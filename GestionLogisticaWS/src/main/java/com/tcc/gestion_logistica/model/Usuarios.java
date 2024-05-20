package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Usuarios", description = "Esta clase representa la informacion del Usuarios")
public class Usuarios {
	@ApiModelProperty(value = "USU_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer USU_ID;
	@ApiModelProperty(value = "USU_NOMBRES", required = true, dataType = "String", example = "00000000", position = 2)
	String USU_NOMBRES;
	@ApiModelProperty(value = "USU_DIRECCION", required = true, dataType = "String", example = "00000000", position = 3)
	String USU_DIRECCION;
	@ApiModelProperty(value = "USU_TELEFONO", required = true, dataType = "String", example = "00000000", position = 4)
	String USU_TELEFONO;
	@ApiModelProperty(value = "USU_CORREO", required = true, dataType = "String", example = "00000000", position = 5)
	String USU_CORREO;
	@ApiModelProperty(value = "USU_NUMDOCUMENTO", required = true, dataType = "String", example = "00000000", position = 6)
	String USU_NUMDOCUMENTO;
	@ApiModelProperty(value = "USU_PASSWORD", required = true, dataType = "String", example = "00000000", position = 7)
	String USU_PASSWORD;
	@ApiModelProperty(value = "USU_TDOC_ID", required = true, dataType = "Integer", example = "00000000", position = 8)
	Integer USU_TDOC_ID;
	@ApiModelProperty(value = "USU_ROL_ID", required = true, dataType = "Integer", example = "00000000", position = 9)
	Integer USU_ROL_ID;
	@ApiModelProperty(value = "USU_ESTADO", required = true, dataType = "Integer", example = "00000000", position = 10)
	Integer USU_ESTADO;

	public Usuarios() {
	}

	public Integer getUSU_ID() {
		return USU_ID;
	}

	public void setUSU_ID(Integer uSU_ID) {
		USU_ID = uSU_ID;
	}

	public String getUSU_NOMBRES() {
		return USU_NOMBRES;
	}

	public void setUSU_NOMBRES(String uSU_NOMBRES) {
		USU_NOMBRES = uSU_NOMBRES;
	}

	public String getUSU_DIRECCION() {
		return USU_DIRECCION;
	}

	public void setUSU_DIRECCION(String uSU_DIRECCION) {
		USU_DIRECCION = uSU_DIRECCION;
	}

	public String getUSU_TELEFONO() {
		return USU_TELEFONO;
	}

	public void setUSU_TELEFONO(String uSU_TELEFONO) {
		USU_TELEFONO = uSU_TELEFONO;
	}

	public String getUSU_CORREO() {
		return USU_CORREO;
	}

	public void setUSU_CORREO(String uSU_CORREO) {
		USU_CORREO = uSU_CORREO;
	}

	public String getUSU_NUMDOCUMENTO() {
		return USU_NUMDOCUMENTO;
	}

	public void setUSU_NUMDOCUMENTO(String uSU_NUMDOCUMENTO) {
		USU_NUMDOCUMENTO = uSU_NUMDOCUMENTO;
	}

	public String getUSU_PASSWORD() {
		return USU_PASSWORD;
	}

	public void setUSU_PASSWORD(String uSU_PASSWORD) {
		USU_PASSWORD = uSU_PASSWORD;
	}

	public Integer getUSU_TDOC_ID() {
		return USU_TDOC_ID;
	}

	public void setUSU_TDOC_ID(Integer uSU_TDOC_ID) {
		USU_TDOC_ID = uSU_TDOC_ID;
	}

	public Integer getUSU_ROL_ID() {
		return USU_ROL_ID;
	}

	public void setUSU_ROL_ID(Integer uSU_ROL_ID) {
		USU_ROL_ID = uSU_ROL_ID;
	}

	public Integer getUSU_ESTADO() {
		return USU_ESTADO;
	}

	public void setUSU_ESTADO(Integer uSU_ESTADO) {
		USU_ESTADO = uSU_ESTADO;
	}

	public Usuarios(Integer uSU_ID, String uSU_NOMBRES, String uSU_DIRECCION, String uSU_TELEFONO, String uSU_CORREO,
			String uSU_NUMDOCUMENTO, String uSU_PASSWORD, Integer uSU_TDOC_ID, Integer uSU_ROL_ID, Integer uSU_ESTADO) {
		
		USU_ID = uSU_ID;
		USU_NOMBRES = uSU_NOMBRES;
		USU_DIRECCION = uSU_DIRECCION;
		USU_TELEFONO = uSU_TELEFONO;
		USU_CORREO = uSU_CORREO;
		USU_NUMDOCUMENTO = uSU_NUMDOCUMENTO;
		USU_PASSWORD = uSU_PASSWORD;
		USU_TDOC_ID = uSU_TDOC_ID;
		USU_ROL_ID = uSU_ROL_ID;
		USU_ESTADO = uSU_ESTADO;
	}

	@Override
	public String toString() {
		return "Usuarios [USU_ID=" + USU_ID + ", USU_NOMBRES=" + USU_NOMBRES + ", USU_DIRECCION=" + USU_DIRECCION
				+ ", USU_TELEFONO=" + USU_TELEFONO + ", USU_CORREO=" + USU_CORREO + ", USU_NUMDOCUMENTO="
				+ USU_NUMDOCUMENTO + ", USU_PASSWORD=" + USU_PASSWORD + ", USU_TDOC_ID=" + USU_TDOC_ID + ", USU_ROL_ID="
				+ USU_ROL_ID + ", USU_ESTADO=" + USU_ESTADO + "]";
	}

	
	
	
	
	

}
