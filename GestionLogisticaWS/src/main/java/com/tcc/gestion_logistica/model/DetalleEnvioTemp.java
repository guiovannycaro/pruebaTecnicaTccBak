package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "DetalleEnvioTemp", description = "Esta clase representa la informacion del cliente")
public class DetalleEnvioTemp {
	@ApiModelProperty(value = "ENVDT_PROD_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
Integer ENVDT_PROD_ID;
	@ApiModelProperty(value = "ENVDT_CANTIDAD", required = true, dataType = "Integer", example = "00000000", position = 2)
Integer  ENVDT_CANTIDAD;
	@ApiModelProperty(value = "ENVDT_PRECIO", required = true, dataType = "double", example = "00000000", position = 3)
 double ENVDT_PRECIO;
	@ApiModelProperty(value = "ENVDT_TOTAL", required = true, dataType = "double", example = "00000000", position = 4)
 double ENVDT_TOTAL;
	@ApiModelProperty(value = "ENVDT_ID", required = true, dataType = "double", example = "00000000", position = 5)
 double ENVDT_ID;
	@ApiModelProperty(value = "ENVDT_IDP", required = true, dataType = "double", example = "00000000", position = 6)
	Integer 	ENVDT_IDP;


 public DetalleEnvioTemp() {
	
	}


public DetalleEnvioTemp(Integer eNVDT_PROD_ID, Integer eNVDT_CANTIDAD, double eNVDT_PRECIO, double eNVDT_TOTAL,
		double eNVDT_ID, Integer eNVDT_IDP) {
	super();
	ENVDT_PROD_ID = eNVDT_PROD_ID;
	ENVDT_CANTIDAD = eNVDT_CANTIDAD;
	ENVDT_PRECIO = eNVDT_PRECIO;
	ENVDT_TOTAL = eNVDT_TOTAL;
	ENVDT_ID = eNVDT_ID;
	ENVDT_IDP = eNVDT_IDP;
}


public Integer getENVDT_PROD_ID() {
	return ENVDT_PROD_ID;
}


public void setENVDT_PROD_ID(Integer eNVDT_PROD_ID) {
	ENVDT_PROD_ID = eNVDT_PROD_ID;
}


public Integer getENVDT_CANTIDAD() {
	return ENVDT_CANTIDAD;
}


public void setENVDT_CANTIDAD(Integer eNVDT_CANTIDAD) {
	ENVDT_CANTIDAD = eNVDT_CANTIDAD;
}


public double getENVDT_PRECIO() {
	return ENVDT_PRECIO;
}


public void setENVDT_PRECIO(double eNVDT_PRECIO) {
	ENVDT_PRECIO = eNVDT_PRECIO;
}


public double getENVDT_TOTAL() {
	return ENVDT_TOTAL;
}


public void setENVDT_TOTAL(double eNVDT_TOTAL) {
	ENVDT_TOTAL = eNVDT_TOTAL;
}


public double getENVDT_ID() {
	return ENVDT_ID;
}


public void setENVDT_ID(double eNVDT_ID) {
	ENVDT_ID = eNVDT_ID;
}


public Integer getENVDT_IDP() {
	return ENVDT_IDP;
}


public void setENVDT_IDP(Integer eNVDT_IDP) {
	ENVDT_IDP = eNVDT_IDP;
}


@Override
public String toString() {
	return "DetalleEnvioTemp [ENVDT_PROD_ID=" + ENVDT_PROD_ID + ", ENVDT_CANTIDAD=" + ENVDT_CANTIDAD + ", ENVDT_PRECIO="
			+ ENVDT_PRECIO + ", ENVDT_TOTAL=" + ENVDT_TOTAL + ", ENVDT_ID=" + ENVDT_ID + ", ENVDT_IDP=" + ENVDT_IDP
			+ "]";
}

 
}
