package com.tcc.gestion_logistica.controllers;

import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tcc.gestion_logistica.dao.UsuariosControllerDao;
import com.tcc.gestion_logistica.model.Usuarios;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudUsuarios")
@Api(value = "Servicio Usuarios")
public class UsuariosController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarUsuarios")
	@ApiOperation(value = "lista Usuarios", response = Usuarios.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response =Usuarios.class), })
	public List<Usuarios> ListarDetalleUsuarios() {
		try {
			UsuariosControllerDao servicioCliente = new UsuariosControllerDao();
			return servicioCliente.listadoUsuarios();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarUsuariosById")
	@ApiOperation(value = "Consulta Usuarios por id", response = Usuarios.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public Usuarios buscarDetalleUsuariosById(
			
			@RequestParam(value = "id")  String id
			) {
		Usuarios c = null;
		try {
			UsuariosControllerDao servicioCliente = new UsuariosControllerDao();
			c = servicioCliente.buscarUsuariosXId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearUsuarios" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Usuarios", response = Usuarios.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public String crearUsuarios(
			@RequestBody Usuarios cliente) {
		try {
			UsuariosControllerDao servicioCliente = new UsuariosControllerDao();
			return servicioCliente.crearUsuarios(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarUsuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Usuarios", response = Usuarios.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public String editarUsuarios(

			@RequestBody Usuarios cliente) {
		try {
			UsuariosControllerDao servicioCliente = new UsuariosControllerDao();

			return servicioCliente.editarUsuarios(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarUsuarios")
	@ApiOperation(value = "Consulta eliminar Usuarios", response =Usuarios.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Usuarios.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Usuarios.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Usuarios.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Usuarios.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Usuarios.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Usuarios.class), })
	public String eliminarUsuarios(
		
			@RequestParam(value = "id")  String id) {
		try {
			UsuariosControllerDao servicioCliente = new UsuariosControllerDao();
			return servicioCliente.eliminarUsuarios(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
