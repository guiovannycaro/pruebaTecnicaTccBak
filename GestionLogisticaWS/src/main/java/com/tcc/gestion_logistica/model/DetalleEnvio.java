package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "Cliente", description = "Esta clase representa la informacion del cliente")
public class DetalleEnvio {
	@ApiModelProperty(value = "ENVD_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
Integer ENVD_ID;
	@ApiModelProperty(value = "ENVD_PROD_ID", required = true, dataType = "Integer", example = "00000000", position = 2)
Integer  ENVD_PROD_ID;
	@ApiModelProperty(value = "ENVD_CANTIDAD", required = true, dataType = "double", example = "00000000", position = 3)
 double ENVD_CANTIDAD;
	@ApiModelProperty(value = "ENVD_PRECIO", required = true, dataType = "double", example = "00000000", position = 4)
 double ENVD_PRECIO;
	@ApiModelProperty(value = "ENVD_SUBTOTAL", required = true, dataType = "double", example = "00000000", position = 5)
 double ENVD_SUBTOTAL;
	@ApiModelProperty(value = "ENVD_IVA", required = true, dataType = "double", example = "00000000", position = 6)
 double ENVD_IVA;
	@ApiModelProperty(value = "ENVD_TOTAL", required = true, dataType = "double", example = "00000000", position = 7)
 double ENVD_TOTAL;
	@ApiModelProperty(value = "CLIENVD_DESCUENTO", required = true, dataType = "double", example = "00000000", position = 8)
 double ENVD_DESCUENTO;
	@ApiModelProperty(value = "ENVD_ENV_ID", required = true, dataType = "Integer", example = "00000000", position = 9)
 Integer  ENVD_ENV_ID;

 public DetalleEnvio() {
	
	}
	 
public DetalleEnvio(Integer eNVD_ID, Integer eNVD_PROD_ID, double eNVD_CANTIDAD, double eNVD_PRECIO,
		double eNVD_SUBTOTAL, double eNVD_IVA, double eNVD_TOTAL, double eNVD_DESCUENTO, Integer eNVD_ENV_ID) {
	ENVD_ID = eNVD_ID;
	ENVD_PROD_ID = eNVD_PROD_ID;
	ENVD_CANTIDAD = eNVD_CANTIDAD;
	ENVD_PRECIO = eNVD_PRECIO;
	ENVD_SUBTOTAL = eNVD_SUBTOTAL;
	ENVD_IVA = eNVD_IVA;
	ENVD_TOTAL = eNVD_TOTAL;
	ENVD_DESCUENTO = eNVD_DESCUENTO;
	ENVD_ENV_ID = eNVD_ENV_ID;
}

public Integer getENVD_ID() {
	return ENVD_ID;
}

public void setENVD_ID(Integer eNVD_ID) {
	ENVD_ID = eNVD_ID;
}

public Integer getENVD_PROD_ID() {
	return ENVD_PROD_ID;
}

public void setENVD_PROD_ID(Integer eNVD_PROD_ID) {
	ENVD_PROD_ID = eNVD_PROD_ID;
}

public double getENVD_CANTIDAD() {
	return ENVD_CANTIDAD;
}

public void setENVD_CANTIDAD(double eNVD_CANTIDAD) {
	ENVD_CANTIDAD = eNVD_CANTIDAD;
}

public double getENVD_PRECIO() {
	return ENVD_PRECIO;
}

public void setENVD_PRECIO(double eNVD_PRECIO) {
	ENVD_PRECIO = eNVD_PRECIO;
}

public double getENVD_SUBTOTAL() {
	return ENVD_SUBTOTAL;
}

public void setENVD_SUBTOTAL(double eNVD_SUBTOTAL) {
	ENVD_SUBTOTAL = eNVD_SUBTOTAL;
}

public double getENVD_IVA() {
	return ENVD_IVA;
}

public void setENVD_IVA(double eNVD_IVA) {
	ENVD_IVA = eNVD_IVA;
}

public double getENVD_TOTAL() {
	return ENVD_TOTAL;
}

public void setENVD_TOTAL(double eNVD_TOTAL) {
	ENVD_TOTAL = eNVD_TOTAL;
}

public double getENVD_DESCUENTO() {
	return ENVD_DESCUENTO;
}

public void setENVD_DESCUENTO(double eNVD_DESCUENTO) {
	ENVD_DESCUENTO = eNVD_DESCUENTO;
}

public Integer getENVD_ENV_ID() {
	return ENVD_ENV_ID;
}

public void setENVD_ENV_ID(Integer eNVD_ENV_ID) {
	ENVD_ENV_ID = eNVD_ENV_ID;
}

@Override
public String toString() {
	return "DetalleEnvio [ENVD_ID=" + ENVD_ID + ", ENVD_PROD_ID=" + ENVD_PROD_ID + ", ENVD_CANTIDAD=" + ENVD_CANTIDAD
			+ ", ENVD_PRECIO=" + ENVD_PRECIO + ", ENVD_SUBTOTAL=" + ENVD_SUBTOTAL + ", ENVD_IVA=" + ENVD_IVA
			+ ", ENVD_TOTAL=" + ENVD_TOTAL + ", ENVD_DESCUENTO=" + ENVD_DESCUENTO + ", ENVD_ENV_ID=" + ENVD_ENV_ID
			+ "]";
}
 

 
 
 
}
