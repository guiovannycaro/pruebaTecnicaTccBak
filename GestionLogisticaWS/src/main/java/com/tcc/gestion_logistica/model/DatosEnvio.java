package com.tcc.gestion_logistica.model;

public class DatosEnvio {
	
	  Integer DATENV_ID;
	  Integer  DATENV_CANTIDAD;
	  
	  
	public DatosEnvio() {
	}

	public DatosEnvio(Integer dATENV_ID, Integer dATENV_CANTIDAD) {
		DATENV_ID = dATENV_ID;
		DATENV_CANTIDAD = dATENV_CANTIDAD;
	}

	public Integer getDATENV_ID() {
		return DATENV_ID;
	}

	public void setDATENV_ID(Integer dATENV_ID) {
		DATENV_ID = dATENV_ID;
	}

	public Integer getDATENV_CANTIDAD() {
		return DATENV_CANTIDAD;
	}

	public void setDATENV_CANTIDAD(Integer dATENV_CANTIDAD) {
		DATENV_CANTIDAD = dATENV_CANTIDAD;
	}
	
	
	  
	  
}
