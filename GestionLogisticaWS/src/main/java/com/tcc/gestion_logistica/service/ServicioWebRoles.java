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

import com.tcc.gestion_logistica.dao.RolesDao;
import com.tcc.gestion_logistica.model.Roles;
import com.tcc.gestion_logistica.util.ExceptionUtil;
@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/getion/CrudRoles")
public class ServicioWebRoles {

	protected final Log log = LogFactory.getLog(this.getClass());
	
	@GetMapping(value = "/ListarRoles")
	public List<Roles> ListarClientes() {
		try {
			RolesDao servicioRoles = new RolesDao();
			return servicioRoles.devolverListaRoles();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarRolById", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Roles> buscarClientesById(@RequestParam(value = "rolid") String idrol) {
		try {
			RolesDao servicioRoles = new RolesDao();
			return servicioRoles.devolverRolesById(Integer.parseInt(idrol));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/crearRol")
	public String crearRol(
			@RequestParam(value = "rolid") String rolid,
			@RequestParam(value = "rolnombre") String rolnombre,
			@RequestParam(value = "roldescripcion") String roldescripcion) {
		try {
			RolesDao servicioRoles = new RolesDao();
			Roles  rol = new Roles();
			rol.setROL_ID(Integer.parseInt("rol_id"));
			rol.setROL_NOMBRE("rol_nombre");
			rol.setROL_DESCRIPCION("rol_descripcion");
			return servicioRoles.agregarRoles(rol);

		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarRol")
	public String editarRol(
			@RequestParam(value = "rolid") String rolid,
			@RequestParam(value = "rolnombre") String rolnombre,
			@RequestParam(value = "roldescripcion") String roldescripcion) {
		try {
			RolesDao servicioRoles = new RolesDao();
			Roles  rol = new Roles();
			rol.setROL_ID(Integer.parseInt("rol_id"));
			rol.setROL_NOMBRE("rol_nombre");
			rol.setROL_DESCRIPCION("rol_descripcion");
			return servicioRoles.actualizarRoles(rol);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarRol")
	public String eliminarCliente(@RequestParam(value = "rolid") String rolid) {
		try {
			RolesDao servicioRoles = new RolesDao();
			return servicioRoles.eliminarRoles(Integer.parseInt(rolid));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}
	
}
