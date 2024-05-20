package com.tcc.gestion_logistica.service;

import java.util.Collections;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.gestion_logistica.dao.ClientesDao;
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
@RequestMapping("/getion/CrudClientes")
@Api(value = "Servicio Clientes")
public class ServicioWebClientes {

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
			ClientesDao servicioCliente = new ClientesDao();
			return servicioCliente.devolverListaClientes();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarClientesById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta Cliente por id", response = Clientes.class, notes = "Obtiene todos Los Clientes por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public List<Clientes> buscarClientesById(
			@ApiParam(name = "cliid", value = "id cliente", required = true, example = "00000000")
			@RequestParam(value = "clienteid") String idcliente) {
		try {
			ClientesDao servicioCliente = new ClientesDao();
			return servicioCliente.devolverClienteById(Integer.parseInt(idcliente));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/crearClientes")
	@ApiOperation(value = "Consulta crear clientes", response = Clientes.class, notes = "crea un nuevo cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public String crearClientes(
			@ApiParam(name = "clicorreo", value = "correo", required = true, example = "00000000")
			@RequestParam(value = "clicorreo") String clicorreo,
			@ApiParam(name = "clicelular", value = "celular", required = true, example = "00000000")
			@RequestParam(value = "clicelular") String clicelular,
			@ApiParam(name = "clidireccion", value = "direccion", required = true, example = "00000000")
			@RequestParam(value = "clidireccion") String clidireccion,
			@ApiParam(name = "cliciudad", value = "ciudad", required = true, example = "00000000")
			@RequestParam(value = "cliciudad") String cliciudad,
			@ApiParam(name = "cliestado", value = "estado", required = true, example = "00000000")
			@RequestParam(value = "cliestado") String cliestado,
			@ApiParam(name = "clinombre", value = "nombre", required = true, example = "00000000")
			@RequestParam(value = "clinombre") String clinombre) {
		try {
			ClientesDao servicioCliente = new ClientesDao();
			Clientes cliente = new Clientes();

			cliente.setCLI_NOMBRES(clinombre);
			cliente.setCLI_CORREO(clicorreo);
			cliente.setCLI_CELULAR(clicelular);
			cliente.setCLI_DIRECCION(clidireccion);
			cliente.setCLI_CIUDAD_ID(Integer.parseInt(cliciudad));
			cliente.setCLI_ESTADO(cliestado);
			return servicioCliente.agregarCliente(cliente);

		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarClientes")
	@ApiOperation(value = "Consulta editar clientes", response = Clientes.class, notes = "edita un  cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public String editarClientes(
			@ApiParam(name = "cliid", value = "id cliente", required = true, example = "00000000")
			@RequestParam(value = "cliid") String cliid,
			@ApiParam(name = "clicorreo", value = "correo", required = true, example = "00000000")
			@RequestParam(value = "clicorreo") String clicorreo,
			@ApiParam(name = "clicelular", value = "celular", required = true, example = "00000000")
			@RequestParam(value = "clicelular") String clicelular,
			@ApiParam(name = "clidireccion", value = "direccion", required = true, example = "00000000")
			@RequestParam(value = "clidireccion") String clidireccion,
			@ApiParam(name = "cliciudad", value = "ciudad", required = true, example = "00000000")
			@RequestParam(value = "cliciudad") String cliciudad,
			@ApiParam(name = "cliestado", value = "estado", required = true, example = "00000000")
			@RequestParam(value = "cliestado") String cliestado,
			@ApiParam(name = "clinombre", value = "nombre", required = true, example = "00000000")
			@RequestParam(value = "clinombre") String clinombre) {
		try {
			ClientesDao servicioCliente = new ClientesDao();
			Clientes cliente = new Clientes();
			cliente.setCLI_ID(Integer.parseInt(cliid));
			cliente.setCLI_NOMBRES(clinombre);
			cliente.setCLI_CORREO(clicorreo);
			cliente.setCLI_CELULAR(clicelular);
			cliente.setCLI_DIRECCION(clidireccion);
			cliente.setCLI_CIUDAD_ID(Integer.parseInt(cliciudad));
			cliente.setCLI_ESTADO(cliestado);
			return servicioCliente.actualizarCliente(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarCliente")
	@ApiOperation(value = "Consulta eliminar clientes", response = Clientes.class, notes = "elimina un cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Clientes.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen Clientes Asociados a esa cedula(String)", response = Clientes.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Clientes.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Clientes.class),
		@ApiResponse(code = 401, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class),
		@ApiResponse(code = 404, message = "No existen Clientes Asociados a esa cedula", response = Clientes.class), })
	public String eliminarCliente(
			@ApiParam(name = "cliid", value = "id cliente", required = true, example = "00000000") 
			@RequestParam(value = "cliid") String cliid) {
		try {
			ClientesDao servicioCliente = new ClientesDao();
			return servicioCliente.eliminarCliente(Integer.parseInt(cliid));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
