package com.tcc.gestion_logistica.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private DateUtil() {
	}

	public static String formatearFecha(String fecha) {
		String date = "";
		if (!isNumeric(fecha)) {
			date = fecha.replaceAll("\\W", "");
		} else {
			date = fecha;
		}
		return date;
	}

	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	
	public static String obtenerFechaYHoraActual() {
		String formato = "MMDDYYYY";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		LocalDateTime ahora = LocalDateTime.now();
		return formateador.format(ahora);
	}
}
