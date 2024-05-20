package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Roles", description = "Esta clase representa la informacion del Roles")
public class Roles {
	@ApiModelProperty(value = "ROL_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer ROL_ID;
	@ApiModelProperty(value = "ROL_NOMBRE", required = true, dataType = "String", example = "00000000", position = 2)
	String ROL_NOMBRE;
	@ApiModelProperty(value = "ROL_DESCRIPCION", required = true, dataType = "String", example = "00000000", position = 3)
	String ROL_DESCRIPCION;

	public Roles() {
	}

	public Roles(Integer rOL_ID, String rOL_NOMBRE, String rOL_DESCRIPCION) {
		ROL_ID = rOL_ID;
		ROL_NOMBRE = rOL_NOMBRE;
		ROL_DESCRIPCION = rOL_DESCRIPCION;
	}

	public Integer getROL_ID() {
		return ROL_ID;
	}

	public void setROL_ID(Integer rOL_ID) {
		ROL_ID = rOL_ID;
	}

	public String getROL_NOMBRE() {
		return ROL_NOMBRE;
	}

	public void setROL_NOMBRE(String rOL_NOMBRE) {
		ROL_NOMBRE = rOL_NOMBRE;
	}

	public String getROL_DESCRIPCION() {
		return ROL_DESCRIPCION;
	}

	public void setROL_DESCRIPCION(String rOL_DESCRIPCION) {
		ROL_DESCRIPCION = rOL_DESCRIPCION;
	}

	@Override
	public String toString() {
		return "Roles [ROL_ID=" + ROL_ID + ", ROL_NOMBRE=" + ROL_NOMBRE + ", ROL_DESCRIPCION=" + ROL_DESCRIPCION + "]";
	}


	

	

}
