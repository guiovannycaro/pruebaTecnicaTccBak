package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Zonas", description = "Esta clase representa la informacion del Zonas")
public class Zonas {
	@ApiModelProperty(value = "ZON_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer ZON_ID;
	@ApiModelProperty(value = "ZON_NOMBRE", required = true, dataType = "Integer", example = "00000000", position = 2)
	String ZON_NOMBRE;
	@ApiModelProperty(value = "ZON_DESCRIPCION", required = true, dataType = "Integer", example = "00000000", position = 3)
	String ZON_DESCRIPCION;

	
	public Zonas() {
	}


	public Zonas(Integer zON_ID, String zON_NOMBRE, String zON_DESCRIPCION) {
		ZON_ID = zON_ID;
		ZON_NOMBRE = zON_NOMBRE;
		ZON_DESCRIPCION = zON_DESCRIPCION;
	}


	public Integer getZON_ID() {
		return ZON_ID;
	}


	public void setZON_ID(Integer zON_ID) {
		ZON_ID = zON_ID;
	}


	public String getZON_NOMBRE() {
		return ZON_NOMBRE;
	}


	public void setZON_NOMBRE(String zON_NOMBRE) {
		ZON_NOMBRE = zON_NOMBRE;
	}


	public String getZON_DESCRIPCION() {
		return ZON_DESCRIPCION;
	}


	public void setZON_DESCRIPCION(String zON_DESCRIPCION) {
		ZON_DESCRIPCION = zON_DESCRIPCION;
	}


	@Override
	public String toString() {
		return "Zonas [ZON_ID=" + ZON_ID + ", ZON_NOMBRE=" + ZON_NOMBRE + ", ZON_DESCRIPCION=" + ZON_DESCRIPCION + "]";
	}

	
	
	
}
