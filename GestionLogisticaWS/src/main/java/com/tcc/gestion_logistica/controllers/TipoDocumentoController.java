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
import com.tcc.gestion_logistica.dao.TipoDocumentoControllerDao;
import com.tcc.gestion_logistica.model.TipoDocumento;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudTipoDocumento")
@Api(value = "Servicio TipoDocumento")
public class TipoDocumentoController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarTipoDocumento")
	@ApiOperation(value = "lista TipoDocumento", response = TipoDocumento.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoDocumento.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = TipoDocumento.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =TipoDocumento.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoDocumento.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoDocumento.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoDocumento.class), })
	public List<TipoDocumento> ListarDetalleTipoBodega() {
		try {
			TipoDocumentoControllerDao servicioCliente = new TipoDocumentoControllerDao();
			return servicioCliente.listadoTipoDocumento();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarTipoDocumentoById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta TipoDocumento por id", response = TipoDocumento.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoDocumento.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = TipoDocumento.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoDocumento.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoDocumento.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoDocumento.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoDocumento.class), })
	public TipoDocumento buscarDetalleRolesById(@RequestBody TipoDocumento cliente) {
		TipoDocumento c = null;
		try {
			TipoDocumentoControllerDao servicioCliente = new TipoDocumentoControllerDao();
			c = servicioCliente.buscarTipoDocumentoXId(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearTipoDocumento" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear TipoDocumento", response = TipoDocumento.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoDocumento.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = TipoDocumento.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoDocumento.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoDocumento.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = TipoDocumento.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoDocumento.class), })
	public String crearTipoDocumento(
			@RequestBody TipoDocumento cliente) {
		try {
			TipoDocumentoControllerDao servicioCliente = new TipoDocumentoControllerDao();
			return servicioCliente.crearTipoDocumento(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarTipoDocumento", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar TipoDocumento", response = TipoDocumento.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoDocumento.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = TipoDocumento.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoDocumento.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoDocumento.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoDocumento.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoDocumento.class), })
	public String editarTipoDocumento(

			@RequestBody TipoDocumento cliente) {
		try {
			TipoDocumentoControllerDao servicioCliente = new TipoDocumentoControllerDao();

			return servicioCliente.editarTipoDocumento(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarTipoDocumento", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta eliminar TipoDocumento", response =TipoDocumento.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoDocumento.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = TipoDocumento.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoDocumento.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoDocumento.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoDocumento.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoDocumento.class), })
	public String eliminarTipoDocumento(
		
			@RequestBody TipoDocumento cliente) {
		try {
			TipoDocumentoControllerDao servicioCliente = new TipoDocumentoControllerDao();
			return servicioCliente.eliminarTipoDocumento(cliente);
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
