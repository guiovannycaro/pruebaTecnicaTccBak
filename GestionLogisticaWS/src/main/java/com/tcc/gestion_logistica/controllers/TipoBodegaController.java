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
import com.tcc.gestion_logistica.dao.TipoBodegaControllerDao;
import com.tcc.gestion_logistica.model.TipoBodega;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudTipoBodega")
@Api(value = "Servicio TipoBodega")
public class TipoBodegaController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarTipoBodega")
	@ApiOperation(value = "lista TipoBodega", response = TipoBodega.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoBodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = TipoBodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =TipoBodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoBodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoBodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoBodega.class), })
	public List<TipoBodega> ListarDetalleTipoBodega() {
		try {
			TipoBodegaControllerDao servicioCliente = new TipoBodegaControllerDao();
			return servicioCliente.listadoTipoBodega();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarTipoBodegaById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta TipoBodega por id", response = TipoBodega.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoBodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = TipoBodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoBodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoBodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoBodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoBodega.class), })
	public TipoBodega buscarDetalleRolesById(@RequestBody TipoBodega cliente) {
		TipoBodega c = null;
		try {
			TipoBodegaControllerDao servicioCliente = new TipoBodegaControllerDao();
			c = servicioCliente.buscarTipoBodegaXId(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearTipoBodega" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear TipoBodega", response = TipoBodega.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoBodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = TipoBodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoBodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoBodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = TipoBodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoBodega.class), })
	public String crearTipoBodega(
			@RequestBody TipoBodega cliente) {
		try {
			TipoBodegaControllerDao servicioCliente = new TipoBodegaControllerDao();
			return servicioCliente.crearTipoBodega(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarTipoBodega", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Roles", response = TipoBodega.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoBodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = TipoBodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoBodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoBodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoBodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoBodega.class), })
	public String editarTipoBodega(

			@RequestBody TipoBodega cliente) {
		try {
			TipoBodegaControllerDao servicioCliente = new TipoBodegaControllerDao();

			return servicioCliente.editarTipoBodega(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarTipoBodega", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta eliminar TipoBodega", response =TipoBodega.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoBodega.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = TipoBodega.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoBodega.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoBodega.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoBodega.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoBodega.class), })
	public String eliminarTipoBodega(
		
			@RequestBody TipoBodega cliente) {
		try {
			TipoBodegaControllerDao servicioCliente = new TipoBodegaControllerDao();
			return servicioCliente.eliminarTipoBodega(cliente);
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
