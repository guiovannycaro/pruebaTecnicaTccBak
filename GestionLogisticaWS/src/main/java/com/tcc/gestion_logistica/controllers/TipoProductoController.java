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
import com.tcc.gestion_logistica.dao.TipoProductoControllerDao;
import com.tcc.gestion_logistica.model.TipoProducto;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudTipoProducto")
@Api(value = "Servicio TipoProducto")
public class TipoProductoController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarTipoProducto")
	@ApiOperation(value = "lista TipoProducto", response = TipoProducto.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoProducto.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = TipoProducto.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =TipoProducto.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoProducto.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoProducto.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoProducto.class), })
	public List<TipoProducto> ListarDetalleTipoProducto() {
		try {
			TipoProductoControllerDao servicioCliente = new TipoProductoControllerDao();
			return servicioCliente.listadoTipoProducto();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@PostMapping(value = "/buscarTipoProductoById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta TipoProducto por id", response = TipoProducto.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoProducto.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = TipoProducto.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoProducto.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoProducto.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoProducto.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoProducto.class), })
	public TipoProducto buscarDetalleRolesById(@RequestBody TipoProducto cliente) {
		TipoProducto c = null;
		try {
			TipoProductoControllerDao servicioCliente = new TipoProductoControllerDao();
			c = servicioCliente.buscarTipoProductoXId(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearTipoProducto" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear TipoProducto", response = TipoProducto.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoProducto.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = TipoProducto.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoProducto.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoProducto.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = TipoProducto.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoProducto.class), })
	public String crearTipoProducto(
			@RequestBody TipoProducto cliente) {
		try {
			TipoProductoControllerDao servicioCliente = new TipoProductoControllerDao();
			return servicioCliente.crearTipoProducto(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarTipoProducto", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar TipoProducto", response = TipoProducto.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoProducto.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = TipoProducto.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoProducto.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoProducto.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoProducto.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoProducto.class), })
	public String editarTipoProducto(

			@RequestBody TipoProducto cliente) {
		try {
			TipoProductoControllerDao servicioCliente = new TipoProductoControllerDao();

			return servicioCliente.editarTipoProducto(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/eliminarTipoProducto", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta eliminar TipoProducto", response =TipoProducto.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = TipoProducto.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = TipoProducto.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = TipoProducto.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = TipoProducto.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = TipoProducto.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = TipoProducto.class), })
	public String eliminarTipoProducto(
		
			@RequestBody TipoProducto cliente) {
		try {
			TipoProductoControllerDao servicioCliente = new TipoProductoControllerDao();
			return servicioCliente.eliminarTipoProducto(cliente);
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
