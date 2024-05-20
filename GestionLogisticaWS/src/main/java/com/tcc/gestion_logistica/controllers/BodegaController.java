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
import com.tcc.gestion_logistica.dao.BodegaControllerDao;
import com.tcc.gestion_logistica.model.Bodega;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudBodega")
@Api(value = "Servicio Bodega")
public class BodegaController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarBodegas")
	@ApiOperation(value = "Bodega Bodega", response = Bodega.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Bodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = Bodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =Bodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Bodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Bodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Bodega.class), })
	public List<Bodega> ListarClientes() {
		try {
			BodegaControllerDao servicioCliente = new BodegaControllerDao();
			return servicioCliente.listadoDeBodega();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarBodegaById")
	@ApiOperation(value = "Consulta Bodega por id", response = Bodega.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Bodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Bodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Bodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Bodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Bodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Bodega.class), })
	public Bodega buscarClientesById(@RequestParam(value = "id")  String id) {
		Bodega c = null;
		try {
			BodegaControllerDao servicioCliente = new BodegaControllerDao();
			c = servicioCliente.buscarBodegaXId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearBodega" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Bodega", response = Bodega.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Bodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Bodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Bodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Bodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Bodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Bodega.class), })
	public String crearBodega(
			@RequestBody Bodega cliente) {
		try {
			BodegaControllerDao servicioCliente = new BodegaControllerDao();
			return servicioCliente.crearBodega(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarBodega", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Bodega", response = Bodega.class, notes = "edita un  cliente ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Bodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Bodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Bodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Bodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Bodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Bodega.class), })
	public String editarClientes(

			@RequestBody Bodega cliente) {
		try {
			BodegaControllerDao servicioCliente = new BodegaControllerDao();

			return servicioCliente.editarBodega(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarBodega")
	@ApiOperation(value = "Consulta eliminar Bodega", response =Bodega.class, notes = "elimina un Bodega ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Bodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Bodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Bodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Bodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Bodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Bodega.class), })
	public String eliminarCliente(
		
			@RequestParam(value = "id")  String id) {
		try {
			BodegaControllerDao servicioCliente = new BodegaControllerDao();
			return servicioCliente.eliminarBodega(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
