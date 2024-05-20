package com.tcc.gestion_logistica.model;

public class Operaciones {
	double descuento;
	double subtotal;
	double viva;
	double total;
	
	public Operaciones() {
	}

	public Operaciones(double descuento, double subtotal, double viva, double total) {
		this.descuento = descuento;
		this.subtotal = subtotal;
		this.viva = viva;
		this.total = total;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getViva() {
		return viva;
	}

	public void setViva(double viva) {
		this.viva = viva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Operaciones [descuento=" + descuento + ", subtotal=" + subtotal + ", viva=" + viva + ", total=" + total
				+ "]";
	}
	
	
	
	
	
	

	
}
