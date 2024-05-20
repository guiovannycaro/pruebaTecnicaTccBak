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
import com.tcc.gestion_logistica.dao.EnvioControllerDao;
import com.tcc.gestion_logistica.model.Envio;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudEnvio")
@Api(value = "Servicio Envio")
public class EnvioController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarEnvio")
	@ApiOperation(value = "lista Envio", response = Envio.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Envio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = Envio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =Envio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Envio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Envio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Envio.class), })
	public List<Envio> ListarDetalleEnvio() {
		try {
			EnvioControllerDao servicioCliente = new EnvioControllerDao();
			return servicioCliente.listadoEnvio();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarEnvioById")
	@ApiOperation(value = "Consulta DetalleEnvio por id", response = Envio.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Envio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Envio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Envio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Envio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Envio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Envio.class), })
	public Envio buscarDetalleEnvioById(
			@RequestParam(value = "id")  String id
			) {
		Envio c = null;
		try {
			EnvioControllerDao servicioCliente = new EnvioControllerDao();
			c = servicioCliente.buscarEnvioXId(Integer.parseInt(id) );
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearEnvio" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Envio", response = Envio.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Envio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Envio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Envio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Envio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Envio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Envio.class), })
	public String crearEnvio(
			@RequestBody Envio cliente) {
		try {
			EnvioControllerDao servicioCliente = new EnvioControllerDao();
			return servicioCliente.crearEnvio(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}
	
	
	@PostMapping(value = "/enviarDatosTemporal" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Envio", response = Envio.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Envio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Envio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Envio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Envio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Envio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Envio.class), })
	public String enviarDatosTemporal(
			@RequestBody Envio cliente) {
		try {
			EnvioControllerDao servicioCliente = new EnvioControllerDao();
			return servicioCliente.envioEnvioTemporal(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}
	
	
	

	@PostMapping(value = "/editarEnvio", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Envio", response = Envio.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Envio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Envio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Envio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Envio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Envio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Envio.class), })
	public String editarEnvio(

			@RequestBody Envio cliente) {
		try {
			System.err.println("entra edita");
			EnvioControllerDao servicioCliente = new EnvioControllerDao();

			return servicioCliente.editarEnvio(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarEnvio")
	@ApiOperation(value = "Consulta eliminar DetalleEnvio", response =Envio.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Envio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Envio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Envio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Envio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Envio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Envio.class), })
	public String eliminarEnvio(
		
			@RequestParam(value = "id")  String id) {
		try {
			EnvioControllerDao servicioCliente = new EnvioControllerDao();
			return servicioCliente.eliminarEnvio(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
