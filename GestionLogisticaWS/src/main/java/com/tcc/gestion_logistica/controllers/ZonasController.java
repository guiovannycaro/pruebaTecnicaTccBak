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
import com.tcc.gestion_logistica.dao.ZonasControllerDao;
import com.tcc.gestion_logistica.model.Zonas;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudZonas")
@Api(value = "Servicio Zonas")
public class ZonasController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarZonas")
	@ApiOperation(value = "lista Zonas", response = Zonas.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Zonas.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = Zonas.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =Zonas.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Zonas.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Zonas.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response =Zonas.class), })
	public List<Zonas> ListarDetalleZonas() {
		try {
			ZonasControllerDao servicioCliente = new ZonasControllerDao();
			return servicioCliente.listadoZonas();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarZonasById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta Zonas por id", response = Zonas.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Zonas.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Zonas.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Zonas.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Zonas.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Zonas.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Zonas.class), })
	public Zonas buscarDetalleUsuariosById(@RequestBody Zonas cliente) {
		Zonas c = null;
		try {
			ZonasControllerDao servicioCliente = new ZonasControllerDao();
			c = servicioCliente.buscarZonasXId(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearZonas" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Zonas", response = Zonas.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Zonas.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Zonas.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Zonas.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Zonas.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Zonas.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Zonas.class), })
	public String crearZonas(
			@RequestBody Zonas cliente) {
		try {
			ZonasControllerDao servicioCliente = new ZonasControllerDao();
			return servicioCliente.crearZonas(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarZonas", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Zonas", response = Zonas.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Zonas.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Zonas.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Zonas.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Zonas.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Zonas.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Zonas.class), })
	public String editarZonas(

			@RequestBody Zonas cliente) {
		try {
			ZonasControllerDao servicioCliente = new ZonasControllerDao();

			return servicioCliente.editarZonas(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarZonas", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta eliminar Zonas", response =Zonas.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Zonas.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Zonas.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Zonas.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Zonas.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Zonas.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Zonas.class), })
	public String eliminarZonas(
		
			@RequestBody Zonas cliente) {
		try {
			ZonasControllerDao servicioCliente = new ZonasControllerDao();
			return servicioCliente.eliminarZonas(cliente);
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
