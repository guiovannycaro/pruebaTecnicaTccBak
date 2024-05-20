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

import com.tcc.gestion_logistica.dao.ClientesControllerDao;
import com.tcc.gestion_logistica.model.Clientes;
import com.tcc.gestion_logistica.util.ExceptionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;
@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudClientes")
@Api(value = "Servicio Clientes")
public class ClientesController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarClientes")
	@ApiOperation(value = "Consulta Cliente", response = Clientes.class, notes = "Obtiene todos Los Clientes ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public List<Clientes> ListarClientes() {
		try {
			ClientesControllerDao servicioCliente = new ClientesControllerDao();
			return servicioCliente.listadoDeClientes();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarClientesById")
	@ApiOperation(value = "Consulta Cliente por id", response = Clientes.class, notes = "Obtiene todos Los Clientes por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public Clientes buscarClientesById(@RequestParam(value = "id")  String id) {
		Clientes c = null;
		try {
			ClientesControllerDao servicioCliente = new ClientesControllerDao();
			c = servicioCliente.buscarClienteXId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearClientes" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear clientes", response = Clientes.class, notes = "crea un nuevo cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public String crearClientes(
			@RequestBody Clientes cliente) {
		try {
			ClientesControllerDao servicioCliente = new ClientesControllerDao();
			return servicioCliente.crearCliente(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarClientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar clientes", response = Clientes.class, notes = "edita un  cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public String editarClientes(

			@RequestBody Clientes cliente) {
		try {
			ClientesControllerDao servicioCliente = new ClientesControllerDao();

			return servicioCliente.editarCliente(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarClientes")
	@ApiOperation(value = "Consulta eliminar clientes", response = Clientes.class, notes = "elimina un cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public String eliminarCliente(
		
			@RequestParam(value = "id")  String id) {
		try {
			ClientesControllerDao servicioCliente = new ClientesControllerDao();
			return servicioCliente.eliminarCliente(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
