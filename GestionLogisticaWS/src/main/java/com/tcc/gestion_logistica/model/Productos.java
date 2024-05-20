package com.tcc.gestion_logistica.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Productos", description = "Esta clase representa la informacion del Productos")
public class Productos {
	@ApiModelProperty(value = "PRO_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer PRO_ID;
	@ApiModelProperty(value = "PRO_NOMBRES", required = true, dataType = "String", example = "00000000", position = 2)
	String PRO_NOMBRES;
	@ApiModelProperty(value = "PRO_DESCRIPCION", required = true, dataType = "String", example = "00000000", position = 3)
	String PRO_DESCRIPCION;
	@ApiModelProperty(value = "PRO_OBSERVACION", required = true, dataType = "String", example = "00000000", position = 4)
	String PRO_OBSERVACION;
	@ApiModelProperty(value = "PROD_VALOR", required = true, dataType = "String", example = "00000000", position = 5)
	String PROD_VALOR;
	@ApiModelProperty(value = "PROD_CANTIDAD", required = true, dataType = "String", example = "00000000", position = 6)
	String PROD_CANTIDAD;
	@ApiModelProperty(value = "PRO_ESTADO", required = true, dataType = "Integer", example = "00000000", position = 7)
	Integer PRO_ESTADO;
	
	public Productos() {
	}

	public Productos(Integer pRO_ID, String pRO_NOMBRES, String pRO_DESCRIPCION, String pRO_OBSERVACION,
			String  pROD_VALOR, String  pROD_CANTIDAD, Integer pRO_ESTADO) {
		super();
		PRO_ID = pRO_ID;
		PRO_NOMBRES = pRO_NOMBRES;
		PRO_DESCRIPCION = pRO_DESCRIPCION;
		PRO_OBSERVACION = pRO_OBSERVACION;
		PROD_VALOR = pROD_VALOR;
		PROD_CANTIDAD = pROD_CANTIDAD;
		PRO_ESTADO = pRO_ESTADO;
	}



	public Integer getPRO_ID() {
		return PRO_ID;
	}

	public void setPRO_ID(Integer pRO_ID) {
		PRO_ID = pRO_ID;
	}

	public String getPRO_NOMBRES() {
		return PRO_NOMBRES;
	}

	public void setPRO_NOMBRES(String pRO_NOMBRES) {
		PRO_NOMBRES = pRO_NOMBRES;
	}

	public String getPRO_DESCRIPCION() {
		return PRO_DESCRIPCION;
	}

	public void setPRO_DESCRIPCION(String pRO_DESCRIPCION) {
		PRO_DESCRIPCION = pRO_DESCRIPCION;
	}

	public String getPRO_OBSERVACION() {
		return PRO_OBSERVACION;
	}

	public void setPRO_OBSERVACION(String pRO_OBSERVACION) {
		PRO_OBSERVACION = pRO_OBSERVACION;
	}



	public String  getPROD_VALOR() {
		return PROD_VALOR;
	}

	public void setPROD_VALOR(String  pROD_VALOR) {
		PROD_VALOR = pROD_VALOR;
	}

	public String  getPROD_CANTIDAD() {
		return PROD_CANTIDAD;
	}

	public void setPROD_CANTIDAD(String  pROD_CANTIDAD) {
		PROD_CANTIDAD = pROD_CANTIDAD;
	}

	public Integer getPRO_ESTADO() {
		return PRO_ESTADO;
	}

	public void setPRO_ESTADO(Integer pRO_ESTADO) {
		PRO_ESTADO = pRO_ESTADO;
	}

	@Override
	public String toString() {
		return "Productos [PRO_ID=" + PRO_ID + ", PRO_NOMBRES=" + PRO_NOMBRES + ", PRO_DESCRIPCION=" + PRO_DESCRIPCION
				+ ", PRO_OBSERVACION=" + PRO_OBSERVACION + ", PROD_VALOR=" + PROD_VALOR + ", PROD_CANTIDAD="
				+ PROD_CANTIDAD + ", PRO_ESTADO=" + PRO_ESTADO + "]";
	}

	
}
