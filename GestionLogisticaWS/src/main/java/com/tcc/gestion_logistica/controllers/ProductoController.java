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
import com.tcc.gestion_logistica.dao.ProductoControllerDao;
import com.tcc.gestion_logistica.model.Productos;
import com.tcc.gestion_logistica.util.ExceptionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:4200/"} )
@RestController
@RequestMapping("/tcc/getion/CrudProductos")
@Api(value = "Servicio Productos")
public class ProductoController {

	protected final Log log = LogFactory.getLog(this.getClass());

	@GetMapping(value = "/ListarProductos")
	@ApiOperation(value = "lista Productos", response = Productos.class, notes = "Obtiene todos Los Datos ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Productos.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen registros Asociados (String)", response = Productos.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response =Productos.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Productos.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Productos.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Productos.class), })
	public List<Productos> ListarDetalleProducto() {
		try {
			ProductoControllerDao servicioCliente = new ProductoControllerDao();
			return servicioCliente.listadoProducto();
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return Collections.emptyList();
		}
	}

	@GetMapping(value = "/buscarProductosById")
	@ApiOperation(value = "Consulta Producto por id", response = Productos.class, notes = "Obtiene todos Los datos por id ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Productos.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Productos.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Productos.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Productos.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Productos.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Productos.class), })
	public Productos buscarDetalleProductoById(	@RequestParam(value = "id")  String id) {
		Productos c = null;
		try {
			ProductoControllerDao servicioCliente = new ProductoControllerDao();
			c = servicioCliente.buscarProductoXId(Integer.parseInt(id));
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
		}
		return c;
	}

	@PostMapping(value = "/crearProducto" , consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta crear Productos", response = Productos.class, notes = "crea un nuevo registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Productos.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados (String)", response = Productos.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Productos.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Productos.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados ", response = Productos.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Productos.class), })
	public String crearProductos(
			@RequestBody Productos cliente) {
		try {
			ProductoControllerDao servicioCliente = new ProductoControllerDao();
			
			System.err.println(cliente.getPRO_NOMBRES() + " " + cliente.getPRO_DESCRIPCION() + " " + cliente.getPRO_OBSERVACION()
			+ " " + " "+ cliente.getPROD_VALOR() + " " + cliente.getPROD_CANTIDAD() + " " +cliente.getPRO_ESTADO());
			
			
			return servicioCliente.crearProducto(cliente);
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue ingresado De Manera Correcta\"}";
		}
	}

	@PostMapping(value = "/editarProductos", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta editar Productos", response = Productos.class, notes = "edita un  registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Productos.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Productos.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Productos.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Productos.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Productos.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Productos.class), })
	public String editarProductos(

			@RequestBody Productos cliente) {
		try {
			ProductoControllerDao servicioCliente = new ProductoControllerDao();
			System.err.println(cliente.getPRO_ID() + " " +cliente.getPRO_NOMBRES() + " " + cliente.getPRO_DESCRIPCION() + " " + cliente.getPRO_OBSERVACION()
			+ " " + " "+ cliente.getPROD_VALOR() + " " + cliente.getPROD_CANTIDAD() + " " +cliente.getPRO_ESTADO());
			
			return servicioCliente.editarProducto(cliente);

			
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "{\"codigo\":\"500\",\"mensaje\":\"Mensaje Informativo\",\"descripcion\":\"El registro no fue editado De Manera Correcta\"}";
		}
	}

	@GetMapping(value = "/eliminarProductos")
	@ApiOperation(value = "Consulta eliminar Productos", response =Productos.class, notes = "elimina un registro ")
	@ApiResponses({
		@ApiResponse(code = 200, message = "La consulta se Ejecuto de manera correcta", response = Productos.class),
		@ApiResponse(code = 400, message = "Bad Request.No existen datos Asociados(String)", response = Productos.class),
		@ApiResponse(code = 500, message = "Error del sistema inesperado", response = Productos.class),
		@ApiResponse(code = 403, message = "Acceso denegado", response = Productos.class),
		@ApiResponse(code = 401, message = "No existen datos Asociados", response = Productos.class),
		@ApiResponse(code = 404, message = "No existen datos Asociados", response = Productos.class), })
	public String eliminarProductos(
		
			@RequestParam(value = "id")  String id) {
		try {
			ProductoControllerDao servicioCliente = new ProductoControllerDao();
			return servicioCliente.eliminarProducto(Integer.parseInt(id));
		
		} catch (Exception e) {
			log.error(ExceptionUtil.format(e));
			return "error";
		}
	}

}
