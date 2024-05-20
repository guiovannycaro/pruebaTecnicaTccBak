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

import com.tcc.gestion_logistica.dao.UsuariosDao;
import com.tcc.gestion_logistica.model.Usuarios;
import com.tcc.gestion_logistica.util.ExceptionUtil;
@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/getion/CrudUsuarios")
public class ServicioWebUsuarios {

	protected final Log log = LogFactory.getLog(this.getClass());
	

	@GetMapping(value = "/ListarUsuarios")
	public List<Usuarios> ListarUsuarios() {
		try {
			UsuariosDao servicioUsuarios = new UsuariosDao();
			return servicioUsuarios.devolverListaUsuarios();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarUsuariosById", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuarios> buscarUsuarioById(@RequestParam(value = "usuid") String idusu) {
		try {
			UsuariosDao servicioUsuarios = new UsuariosDao();
			return servicioUsuarios.devolverUsuariosById(Integer.parseInt(idusu));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/crearUsuario")
	public String crearUsuario(
			@RequestParam(value = "usunombre") String usunombre,
			@RequestParam(value = "usudireccion") String usudireccion,
			@RequestParam(value = "usutelefono") String usutelefono,
			@RequestParam(value = "usucorreo") String usucorreo,
			@RequestParam(value = "usunumdocumento") String usunumdocumento,
			@RequestParam(value = "usupassword") String usupassword,
			@RequestParam(value = "usutdocid") String usutdocid,
			@RequestParam(value = "usurolid") String usurolid
			) {
		try {
			UsuariosDao servicioUsuarios = new UsuariosDao();
			Usuarios us = new Usuarios();

			us.setUSU_ID(Integer.parseInt(usurolid));
			us.setUSU_NOMBRES(usunombre);
			us.setUSU_DIRECCION(usudireccion);
			us.setUSU_TELEFONO(usutelefono);
			us.setUSU_CORREO(usucorreo);
			us.setUSU_NUMDOCUMENTO(usunumdocumento);
			us.setUSU_PASSWORD(usupassword);
			us.setUSU_TDOC_ID(Integer.parseInt(usutdocid));
			us.setUSU_ROL_ID(Integer.parseInt(usurolid));
			
			return servicioUsuarios.agregarUsuario(us);

		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarUsuario")
	public String editarUsuario(
			@RequestParam(value = "usuid") String usuid,
			@RequestParam(value = "usunombre") String usunombre,
			@RequestParam(value = "usudireccion") String usudireccion,
			@RequestParam(value = "usutelefono") String usutelefono,
			@RequestParam(value = "usucorreo") String usucorreo,
			@RequestParam(value = "usunumdocumento") String usunumdocumento,
			@RequestParam(value = "usupassword") String usupassword,
			@RequestParam(value = "usutdocid") String usutdocid,
			@RequestParam(value = "usurolid") String usurolid
			) {
		try {
			UsuariosDao servicioUsuarios = new UsuariosDao();
			Usuarios us = new Usuarios();
			us.setUSU_ID(Integer.parseInt(usurolid));
			us.setUSU_NOMBRES(usunombre);
			us.setUSU_DIRECCION(usudireccion);
			us.setUSU_TELEFONO(usutelefono);
			us.setUSU_CORREO(usucorreo);
			us.setUSU_NUMDOCUMENTO(usunumdocumento);
			us.setUSU_PASSWORD(usupassword);
			us.setUSU_TDOC_ID(Integer.parseInt(usutdocid));
			us.setUSU_ROL_ID(Integer.parseInt(usurolid));
			
			return servicioUsuarios.actualizarUsuario(us);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarUsuario")
	public String eliminarUsuario(@RequestParam(value = "usuid") String usuid) {
		try {
			UsuariosDao servicioUsuarios = new UsuariosDao();
			return servicioUsuarios.eliminarUsuario(Integer.parseInt(usuid));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}
	
}
