package com.tcc.gestion_logistica.service;


import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.gestion_logistica.dao.TipoDocumentoDao;
import com.tcc.gestion_logistica.model.TipoDocumento;
import com.tcc.gestion_logistica.util.ExceptionUtil;
@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/getion/CrudTipoDocumento")
public class ServicioWebTipoDocumento {

	protected final Log log = LogFactory.getLog(this.getClass());
	
	@GetMapping(value = "/ListarTipoDocumento")
	public List<TipoDocumento> ListarTipoDocumento() {
		try {
			TipoDocumentoDao servicioTipoDocumento = new TipoDocumentoDao();
			return servicioTipoDocumento.devolverListaTipoDocumento();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarTipoDocumentoById", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<TipoDocumento> buscarTipoDocumentoById(@RequestParam(value = "tdocid") String tdocrol) {
		try {
			TipoDocumentoDao servicioTipoDocumento = new TipoDocumentoDao();
			return servicioTipoDocumento.devolverTipoDocumentoById(Integer.parseInt(tdocrol));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/crearTipoDocumento")
	public String crearTipoDocumento(
			@RequestParam(value = "tdocid") String tdocid,
			@RequestParam(value = "tdocnombre") String tdocnombre,
			@RequestParam(value = "tdocdescripcion") String tdocdescripcion) {
		try {
			TipoDocumentoDao servicioTipoDocumento = new TipoDocumentoDao();
			TipoDocumento  rol = new TipoDocumento();
			rol.setTDOC_ID(Integer.parseInt(tdocid));
			rol.setTDOC_NOMBRE(tdocnombre);
			rol.setTDOC_DESCRIPCION(tdocdescripcion);
			return servicioTipoDocumento.agregarTipoDocumento(rol);

		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarTipoDocumento")
	public String editarTipoDocumento(
			@RequestParam(value = "tdocid") String tdocid,
			@RequestParam(value = "tdocnombre") String tdocnombre,
			@RequestParam(value = "tdocdescripcion") String tdocdescripcion) {
		try {
			TipoDocumentoDao servicioTipoDocumento = new TipoDocumentoDao();
			TipoDocumento  rol = new TipoDocumento();
			rol.setTDOC_ID(Integer.parseInt(tdocid));
			rol.setTDOC_NOMBRE(tdocnombre);
			rol.setTDOC_DESCRIPCION(tdocdescripcion);
			return servicioTipoDocumento.actualizarTipoDocumento(rol);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarTipoDocumento")
	public String eliminarTipoDocumento(@RequestParam(value = "tdocid") String tdocid) {
		try {
			TipoDocumentoDao servicioTipoDocumento = new TipoDocumentoDao();
			return servicioTipoDocumento.eliminarTipoDocumento(Integer.parseInt(tdocid));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}
}
