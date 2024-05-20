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
import com.tcc.gestion_logistica.dao.DetalleEnvioControllerDao;
import com.tcc.gestion_logistica.model.DatosEnvio;
import com.tcc.gestion_logistica.model.DetalleEnvio;
import com.tcc.gestion_logistica.model.Productos;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudDetalleEnvio")
@Api(value = "Servicio DetalleEnvio")
public class DetalleEnvioController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarDetalleEnvio")
	@ApiOperation(value = "lista DetalleEnvio", response = DetalleEnvio.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = DetalleEnvio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =DetalleEnvio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvio.class), })
	public List<DetalleEnvio> ListarDetalleEnvio() {
		try {
			DetalleEnvioControllerDao servicioCliente = new DetalleEnvioControllerDao();
			return servicioCliente.listadoDetalleEnvio();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarDetalleEnvioById", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta DetalleEnvio por id", response = DetalleEnvio.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = DetalleEnvio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvio.class), })
	public DetalleEnvio buscarDetalleEnvioById(@RequestParam(value = "id")  String id) {
		DetalleEnvio c = null;
		try {
			DetalleEnvioControllerDao servicioCliente = new DetalleEnvioControllerDao();
			c = servicioCliente.buscarDetalleEnvioXId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearDetalleEnvio" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear DetalleEnvio", response = DetalleEnvio.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = DetalleEnvio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = DetalleEnvio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvio.class), })
	public String crearDetalleEnvio(
			@RequestBody DatosEnvio cliente) {
		try {
			System.out.println("cliente " + cliente.getDATENV_ID() + " "+ cliente.getDATENV_CANTIDAD() + " " + cliente.getDATENV_REF());
			DetalleEnvioControllerDao servicioCliente = new DetalleEnvioControllerDao();
			return servicioCliente.crearDetalleEnvio(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarDetalleEnvio", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar DetalleEnvio", response = DetalleEnvio.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = DetalleEnvio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvio.class), })
	public String editarDetalleEnvio(

			@RequestBody DetalleEnvio cliente) {
		try {
			DetalleEnvioControllerDao servicioCliente = new DetalleEnvioControllerDao();

			return servicioCliente.editarDetalleEnvio(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarDetalleEnvio")
	@ApiOperation(value = "Consulta eliminar DetalleEnvio", response =DetalleEnvio.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = DetalleEnvio.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = DetalleEnvio.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = DetalleEnvio.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = DetalleEnvio.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = DetalleEnvio.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = DetalleEnvio.class), })
	public String eliminarDetalleEnvio(
		
			@RequestParam(value = "id")  String id) {
		try {
			DetalleEnvioControllerDao servicioCliente = new DetalleEnvioControllerDao();
			return servicioCliente.eliminarDetalleEnvio(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
