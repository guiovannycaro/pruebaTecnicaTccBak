package com.tcc.gestion_logistica.model;

public class DatosEnvioD {
	
	  Integer DATENV_ID;
	  Integer  DATENV_CANTIDAD;
	  Integer  DATENV_REF;
	  
	  
	public DatosEnvioD() {
	}




	public DatosEnvioD(Integer dATENV_ID, Integer dATENV_CANTIDAD, Integer dATENV_REF) {
		super();
		DATENV_ID = dATENV_ID;
		DATENV_CANTIDAD = dATENV_CANTIDAD;
		DATENV_REF = dATENV_REF;
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




	public Integer getDATENV_REF() {
		return DATENV_REF;
	}




	public void setDATENV_REF(Integer dATENV_REF) {
		DATENV_REF = dATENV_REF;
	}




	@Override
	public String toString() {
		return "DatosEnvioD [DATENV_ID=" + DATENV_ID + ", DATENV_CANTIDAD=" + DATENV_CANTIDAD + ", DATENV_REF="
				+ DATENV_REF + "]";
	}



	
	  
	  
}
