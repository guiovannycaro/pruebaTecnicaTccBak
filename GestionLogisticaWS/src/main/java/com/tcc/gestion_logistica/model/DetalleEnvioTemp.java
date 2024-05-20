package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al cliente
@ApiModel(value = "DetalleEnvioTemp", description = "Esta clase representa la informacion del cliente")
public class DetalleEnvioTemp {
	@ApiModelProperty(value = "ENVDT_PROD_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
String ENVDT_PROD_ID;
	@ApiModelProperty(value = "ENVDT_CANTIDAD", required = true, dataType = "Integer", example = "00000000", position = 2)
	String ENVDT_CANTIDAD;
	@ApiModelProperty(value = "ENVDT_PRECIO", required = true, dataType = "double", example = "00000000", position = 3)
	String ENVDT_PRECIO;
	@ApiModelProperty(value = "ENVDT_TOTAL", required = true, dataType = "double", example = "00000000", position = 4)
	String ENVDT_TOTAL;
	@ApiModelProperty(value = "ENVDT_ID", required = true, dataType = "double", example = "00000000", position = 5)
	String ENVDT_ID;
	@ApiModelProperty(value = "ENVDT_IDP", required = true, dataType = "double", example = "00000000", position = 6)
	Integer 	ENVDT_IDP;


 public DetalleEnvioTemp() {
	
	}


public DetalleEnvioTemp(String eNVDT_PROD_ID, String eNVDT_CANTIDAD, String eNVDT_PRECIO, String eNVDT_TOTAL,
		String eNVDT_ID, Integer eNVDT_IDP) {

	ENVDT_PROD_ID = eNVDT_PROD_ID;
	ENVDT_CANTIDAD = eNVDT_CANTIDAD;
	ENVDT_PRECIO = eNVDT_PRECIO;
	ENVDT_TOTAL = eNVDT_TOTAL;
	ENVDT_ID = eNVDT_ID;
	ENVDT_IDP = eNVDT_IDP;
}


public String getENVDT_PROD_ID() {
	return ENVDT_PROD_ID;
}


public void setENVDT_PROD_ID(String eNVDT_PROD_ID) {
	ENVDT_PROD_ID = eNVDT_PROD_ID;
}


public String getENVDT_CANTIDAD() {
	return ENVDT_CANTIDAD;
}


public void setENVDT_CANTIDAD(String eNVDT_CANTIDAD) {
	ENVDT_CANTIDAD = eNVDT_CANTIDAD;
}


public String getENVDT_PRECIO() {
	return ENVDT_PRECIO;
}


public void setENVDT_PRECIO(String eNVDT_PRECIO) {
	ENVDT_PRECIO = eNVDT_PRECIO;
}


public String getENVDT_TOTAL() {
	return ENVDT_TOTAL;
}


public void setENVDT_TOTAL(String eNVDT_TOTAL) {
	ENVDT_TOTAL = eNVDT_TOTAL;
}


public String getENVDT_ID() {
	return ENVDT_ID;
}


public void setENVDT_ID(String eNVDT_ID) {
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
