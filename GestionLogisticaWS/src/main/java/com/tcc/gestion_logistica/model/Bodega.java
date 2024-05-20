
package com.tcc.gestion_logistica.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("all") // Nombres a utilizar en los objetos JSON a enviar al Bodega
@ApiModel(value = "Bodega", description = "Esta clase representa la informacion del Bodega")
public class Bodega {

	@ApiModelProperty(value = "BOD_ID", required = true, dataType = "Integer", example = "00000000", position = 1)
	Integer BOD_ID;
	@ApiModelProperty(value = "BOD_NOMBRES", required = true, dataType = "String", example = "00000000", position = 2)
	String BOD_NOMBRES;
	@ApiModelProperty(value = "BOD_DIRECCION", required = true, dataType = "String", example = "00000000", position = 3)
	String BOD_DIRECCION;
	@ApiModelProperty(value = "BOD_TELEFONO", required = true, dataType = "String", example = "00000000", position = 4)
	String BOD_TELEFONO;
	@ApiModelProperty(value = "BOD_ID_TIPO", required = true, dataType = "Integer", example = "00000000", position = 5)
	Integer BOD_ID_TIPO;
	@ApiModelProperty(value = "BOD_CIUDAD_ID", required = true, dataType = "Integer", example = "00000000", position = 6)
	Integer BOD_CIUDAD_ID;
	@ApiModelProperty(value = "BOD_ZONA_ID", required = true, dataType = "Integer", example = "00000000", position = 7)
	Integer BOD_ZONA_ID;
	@ApiModelProperty(value = "BOD_ESTADO", required = true, dataType = "Integer", example = "00000000", position = 8)
	Integer BOD_ESTADO;

	public Bodega() {
		
	}

	public Bodega(Integer bOD_ID, String bOD_NOMBRES, String bOD_DIRECCION, String bOD_TELEFONO, Integer bOD_ID_TIPO,
			Integer bOD_CIUDAD_ID, Integer bOD_ZONA_ID, Integer bOD_ESTADO) {
		super();
		BOD_ID = bOD_ID;
		BOD_NOMBRES = bOD_NOMBRES;
		BOD_DIRECCION = bOD_DIRECCION;
		BOD_TELEFONO = bOD_TELEFONO;
		BOD_ID_TIPO = bOD_ID_TIPO;
		BOD_CIUDAD_ID = bOD_CIUDAD_ID;
		BOD_ZONA_ID = bOD_ZONA_ID;
		BOD_ESTADO = bOD_ESTADO;
	}

	public Integer getBOD_ID() {
		return BOD_ID;
	}

	public void setBOD_ID(Integer bOD_ID) {
		BOD_ID = bOD_ID;
	}

	public String getBOD_NOMBRES() {
		return BOD_NOMBRES;
	}

	public void setBOD_NOMBRES(String bOD_NOMBRES) {
		BOD_NOMBRES = bOD_NOMBRES;
	}

	public String getBOD_DIRECCION() {
		return BOD_DIRECCION;
	}

	public void setBOD_DIRECCION(String bOD_DIRECCION) {
		BOD_DIRECCION = bOD_DIRECCION;
	}

	public String getBOD_TELEFONO() {
		return BOD_TELEFONO;
	}

	public void setBOD_TELEFONO(String bOD_TELEFONO) {
		BOD_TELEFONO = bOD_TELEFONO;
	}

	public Integer getBOD_ID_TIPO() {
		return BOD_ID_TIPO;
	}

	public void setBOD_ID_TIPO(Integer bOD_ID_TIPO) {
		BOD_ID_TIPO = bOD_ID_TIPO;
	}

	public Integer getBOD_CIUDAD_ID() {
		return BOD_CIUDAD_ID;
	}

	public void setBOD_CIUDAD_ID(Integer bOD_CIUDAD_ID) {
		BOD_CIUDAD_ID = bOD_CIUDAD_ID;
	}

	public Integer getBOD_ZONA_ID() {
		return BOD_ZONA_ID;
	}

	public void setBOD_ZONA_ID(Integer bOD_ZONA_ID) {
		BOD_ZONA_ID = bOD_ZONA_ID;
	}

	public Integer getBOD_ESTADO() {
		return BOD_ESTADO;
	}

	public void setBOD_ESTADO(Integer bOD_ESTADO) {
		BOD_ESTADO = bOD_ESTADO;
	}

	@Override
	public String toString() {
		return "Bodega [BOD_ID=" + BOD_ID + ", BOD_NOMBRES=" + BOD_NOMBRES + ", BOD_DIRECCION=" + BOD_DIRECCION
				+ ", BOD_TELEFONO=" + BOD_TELEFONO + ", BOD_ID_TIPO=" + BOD_ID_TIPO + ", BOD_CIUDAD_ID=" + BOD_CIUDAD_ID
				+ ", BOD_ZONA_ID=" + BOD_ZONA_ID + ", BOD_ESTADO=" + BOD_ESTADO + "]";
	}

	
}
