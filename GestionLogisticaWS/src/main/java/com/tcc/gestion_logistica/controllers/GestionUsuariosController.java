package com.tcc.gestion_logistica.controllers;

import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tcc.gestion_logistica.dao.GestionUsuariosControllerDao;
import com.tcc.gestion_logistica.model.User;
import com.tcc.gestion_logistica.model.Usuarios;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/GestionUsuarios")
@Api(value = "Servicio Roles")
public class GestionUsuariosController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@PostMapping(value = "/validarUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "validar Usuarios", response = User.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = User.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = User.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =User.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = User.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = User.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = User.class), })
	public boolean validarUsuarios( @RequestBody User use) {
		
		boolean dato = false;
		try {
			GestionUsuariosControllerDao servicioCliente = new GestionUsuariosControllerDao();
			 
			dato = servicioCliente.validarUsuarios(use);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		
		}
		return dato;
	}

	@PostMapping(value = "/cambiarContrasena", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cambiar Contraseña", response = Usuarios.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public String consCambiarContrasena(@RequestParam("useremail") String useremail,@RequestParam("password") String password) {
	
		try {
			GestionUsuariosControllerDao servicioCliente = new GestionUsuariosControllerDao();
			 servicioCliente.cambiarContrasena(useremail,password);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return "{\"codigo\":\"200\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro fue actualizado De Manera Correcta\"}";
	}

	@PostMapping(value = "/recordarContrasena" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Usuarios", response = Usuarios.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public Usuarios recordarContrasenaUsuarios(
			@RequestParam("user") String user) {
		Usuarios datos = new Usuarios();
		try {
			GestionUsuariosControllerDao servicioCliente = new GestionUsuariosControllerDao();
			datos = servicioCliente.recordarContrasena(user);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			
		}
		return datos;
	}

	@PostMapping(value = "/obtenerPerfil" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Usuarios", response = Usuarios.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public Usuarios obtenerPerfil(
			@RequestParam("user") String user) {
		Usuarios datos = new Usuarios();
		try {
			GestionUsuariosControllerDao servicioCliente = new GestionUsuariosControllerDao();
			datos = servicioCliente.getPerfil(user);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			
		}
		return datos;
	}


	

}
