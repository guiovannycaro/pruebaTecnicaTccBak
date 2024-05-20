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
import com.tcc.gestion_logistica.dao.DetalleEnvioControllerTempDao;
import com.tcc.gestion_logistica.model.DatosEnvioD;
import com.tcc.gestion_logistica.model.DetalleEnvioTemp;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudDetalleEnvioTemp")
@Api(value = "Servicio DetalleEnvioTemp")
public class DetalleEnvioTempController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarDetalleEnvioTemp")
	@ApiOperation(value = "lista DetalleEnvioTemp", response = DetalleEnvioTemp.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =DetalleEnvioTemp.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvioTemp.class), })
	public List<DetalleEnvioTemp> ListarDetalleEnvioTemp() {
		try {
			DetalleEnvioControllerTempDao servicioCliente = new DetalleEnvioControllerTempDao();
			return servicioCliente.listadoDetalleEnvioTemp();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarDetalleEnvioTempById")
	@ApiOperation(value = "Consulta DetalleEnvioTemp por id", response = DetalleEnvioTemp.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvioTemp.class), })
	public List<DetalleEnvioTemp> buscarDetalleEnvioTempById(@RequestParam(value = "id")  String id) {
		
		try {
			DetalleEnvioControllerTempDao servicioCliente = new DetalleEnvioControllerTempDao();
			return servicioCliente.buscarDetalleEnvioTempXId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
		
	}

	@PostMapping(value = "/crearDetalleTempEnvio" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear DetalleEnvioTemp", response = DetalleEnvioTemp.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvioTemp.class), })
	public String crearDetalleEnvioTemp(
			@RequestBody DatosEnvioD cliente
			
			) {
		try {
			DetalleEnvioControllerTempDao servicioCliente = new DetalleEnvioControllerTempDao();
			return servicioCliente.crearDetalleEnvioTemp(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarDetalleTempEnvio", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar DetalleEnvioTemp", response = DetalleEnvioTemp.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvioTemp.class), })
	public String editarDetalleEnvioTemp(

			@RequestBody DetalleEnvioTemp cliente) {
		try {
			DetalleEnvioControllerTempDao servicioCliente = new DetalleEnvioControllerTempDao();

			return servicioCliente.editarDetalleEnvioTemp(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarDetalleEnvioTemp")
	@ApiOperation(value = "Consulta eliminar DetalleEnvioTemp", response =DetalleEnvioTemp.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvioTemp.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvioTemp.class), })
	public String eliminarDetalleEnvioTemp(
		
			@RequestParam(value = "id")  String id) {
		try {
			DetalleEnvioControllerTempDao servicioCliente = new DetalleEnvioControllerTempDao();
		
			return servicioCliente.eliminarDetalleEnvioTemp(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
