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
import org.springframework.web.bind.annotation.RestController;
import com.tcc.gestion_logistica.dao.RolesControllerDao;
import com.tcc.gestion_logistica.model.Roles;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudRoles")
@Api(value = "Servicio Roles")
public class RolesController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarRoles")
	@ApiOperation(value = "lista Roles", response = Roles.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Roles.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = Roles.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =Roles.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Roles.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Roles.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Roles.class), })
	public List<Roles> ListarDetalleProducto() {
		try {
			RolesControllerDao servicioCliente = new RolesControllerDao();
			return servicioCliente.listadoRoles();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarRolesById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta Producto por id", response = Roles.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Roles.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Roles.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Roles.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Roles.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Roles.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Roles.class), })
	public Roles buscarDetalleRolesById(@RequestBody Roles cliente) {
		Roles c = null;
		try {
			RolesControllerDao servicioCliente = new RolesControllerDao();
			c = servicioCliente.buscarRolesXId(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearRoles" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Productos", response = Roles.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Roles.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Roles.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Roles.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Roles.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Roles.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Roles.class), })
	public String crearRoles(
			@RequestBody Roles cliente) {
		try {
			RolesControllerDao servicioCliente = new RolesControllerDao();
			return servicioCliente.crearRoles(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarRoles", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Roles", response = Roles.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Roles.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Roles.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Roles.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Roles.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Roles.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Roles.class), })
	public String editarRoles(

			@RequestBody Roles cliente) {
		try {
			RolesControllerDao servicioCliente = new RolesControllerDao();

			return servicioCliente.editarRoles(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarRoles", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta eliminar Roles", response =Roles.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Roles.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Roles.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Roles.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Roles.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Roles.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Roles.class), })
	public String eliminarRoles(
		
			@RequestBody Roles cliente) {
		try {
			RolesControllerDao servicioCliente = new RolesControllerDao();
			return servicioCliente.eliminarRoles(cliente);
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
