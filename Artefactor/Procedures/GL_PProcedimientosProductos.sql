CREATE
OR REPLACE PROCEDURE  GL_PListarProductos(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
--
  --
  --
  -- Creado por : guiovanny
  -- Fecha      : 16/05/2024 
  -- Solicitud  : tcc
  --
  -- Historial


  -- =========================================================================================================================================================================
  --  Version     Solicitud        Fecha      Realizo        Comentario
  -- ========== =============== ============ ============== ==================================================================================================================
  --   1        TCC              16/05/2024       GUIOVANNY  . Se crea este procedimiento para ListarClientes
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de ListarClientes
    --
	OPEN OUT_CURSOR FOR
     SELECT
	 
	 GL_TPRODUCTOS.PRO_ID ,
	GL_TPRODUCTOS.PRO_NOMBRES ,
	GL_TPRODUCTOS.PRO_DESCRIPCION,
	GL_TPRODUCTOS.PRO_OBSERVACION,
	GL_TPRODUCTOS.PROD_VALOR,
	GL_TPRODUCTOS.PROD_CANTIDAD ,
	GL_TPRODUCTOS.PRO_ESTADO 
	
     
     FROM
       SCH_CN.GL_TPRODUCTOS
     ORDER BY
       SCH_CN.GL_TPRODUCTOS.PRO_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarProductos;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarProductos (
	p_PRO_NOMBRES_init  IN VARCHAR2,
	p_PRO_DESCRIPCION_init  IN VARCHAR2,
	p_PRO_OBSERVACION_init IN VARCHAR2,
	p_PROD_VALOR_init IN VARCHAR2,
	p_PROD_CANTIDAD_init IN VARCHAR2 ,
	p_PRO_ESTADO_init  IN VARCHAR2

) AS BEGIN
 --
  --
  --
  -- Creado por : guiovanny
  -- Fecha      : 16/05/2024
  -- Solicitud  : tcc
  --
  -- Historial


  -- =========================================================================================================================================================================
  --  Version     Solicitud        Fecha      Realizo        Comentario
  -- ========== =============== ============ ============== ==================================================================================================================
  --   12000       tcc         16/05/2024      guiovanny  . Se crea este procedimiento para  InsertarCliente 
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de InsertarCliente 
    --
  
	
	insert into SCH_CN.GL_TPRODUCTOS(
	PRO_NOMBRES ,
	PRO_DESCRIPCION ,
	PRO_OBSERVACION ,
	PROD_VALOR ,
	PROD_CANTIDAD,
	PRO_ESTADO 
	) 
values(
    p_PRO_NOMBRES_init,
	p_PRO_DESCRIPCION_init,
	p_PRO_OBSERVACION_init,
	p_PROD_VALOR_init,
	p_PROD_CANTIDAD_init ,
	p_PRO_ESTADO_init
);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarProductos;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarProductos (
    p_codigo_init IN VARCHAR2,
   p_PRO_NOMBRES_init  IN VARCHAR2,
	p_PRO_DESCRIPCION_init  IN VARCHAR2,
	p_PRO_OBSERVACION_init IN VARCHAR2,
	p_PROD_VALOR_init IN VARCHAR2,
	p_PROD_CANTIDAD_init IN VARCHAR2 ,
	p_PRO_ESTADO_init  IN VARCHAR2
) AS BEGIN
 --
  --
  --
  -- Creado por : guiovanny
  -- Fecha      : 16/05/2024
  -- Solicitud  : tcc
  --
  -- Historial


  -- =========================================================================================================================================================================
  --  Version     Solicitud        Fecha      Realizo        Comentario
  -- ========== =============== ============ ============== ==================================================================================================================
  --   12000       tcc         16/05/2024      guiovanny  . Se crea este procedimiento para  EditarCliente
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de EditarCliente
    --

         UPDATE
          SCH_CN.GL_TPRODUCTOS
         SET
	PRO_NOMBRES =p_PRO_NOMBRES_init,
	PRO_DESCRIPCION =p_PRO_DESCRIPCION_init,
	PRO_OBSERVACION =p_PRO_OBSERVACION_init,
	PROD_VALOR =p_PROD_VALOR_init,
	PROD_CANTIDAD =p_PROD_CANTIDAD_init,
	PRO_ESTADO =p_PRO_ESTADO_init
    WHERE
          PRO_ID = p_codigo_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarProductos;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarProductos (
 p_codigo_init IN VARCHAR2
) AS BEGIN
--
  --
  --
  -- Creado por : guiovanny
  -- Fecha      : 16/05/2024 
  -- Solicitud  : tcc
  --
  -- Historial


  -- =========================================================================================================================================================================
  --  Version     Solicitud        Fecha      Realizo        Comentario
  -- ========== =============== ============ ============== ==================================================================================================================
  --   1        TCC              16/05/2024       GUIOVANNY  . Se crea este procedimiento para EliminarCliente
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de EliminarCliente
    --

     DELETE
    
     FROM
       SCH_CN.GL_TPRODUCTOS
	   WHERE
            PRO_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarProductos;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarProductosNombre (
 p_nombre_init IN VARCHAR2,
OUT_CURSOR OUT SYS_REFCURSOR

) AS BEGIN
--
  --
  --
  -- Creado por : guiovanny
  -- Fecha      : 16/05/2024 
  -- Solicitud  : tcc
  --
  -- Historial


  -- =========================================================================================================================================================================
  --  Version     Solicitud        Fecha      Realizo        Comentario
  -- ========== =============== ============ ============== ==================================================================================================================
  --   1        TCC              16/05/2024       GUIOVANNY  . Se crea este procedimiento para BuscarClienteNombre
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de BuscarClienteNombre
    --
	OPEN OUT_CURSOR FOR
     SELECT
       GL_TPRODUCTOS.PRO_ID ,
	GL_TPRODUCTOS.PRO_NOMBRES ,
	GL_TPRODUCTOS.PRO_DESCRIPCION,
	GL_TPRODUCTOS.PRO_OBSERVACION,
	GL_TPRODUCTOS.PROD_VALOR,
	GL_TPRODUCTOS.PROD_CANTIDAD ,
	GL_TPRODUCTOS.PRO_ESTADO
     FROM
       SCH_CN.GL_TPRODUCTOS
	   WHERE
          GL_TPRODUCTOS.PRO_NOMBRES= p_nombre_init
     ORDER BY
       SCH_CN.GL_TPRODUCTOS.PRO_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarProductosNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarProductosId (
 p_codigo_init IN VARCHAR2,
OUT_CURSOR OUT SYS_REFCURSOR

) AS BEGIN
--
  --
  --
  -- Creado por : guiovanny
  -- Fecha      : 16/05/2024 
  -- Solicitud  : tcc
  --
  -- Historial


  -- =========================================================================================================================================================================
  --  Version     Solicitud        Fecha      Realizo        Comentario
  -- ========== =============== ============ ============== ==================================================================================================================
  --   1        TCC              16/05/2024       GUIOVANNY  . Se crea este procedimiento para BuscarClienteId
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de BuscarClienteId
    --
	OPEN OUT_CURSOR FOR
     SELECT
       GL_TPRODUCTOS.PRO_ID ,
	GL_TPRODUCTOS.PRO_NOMBRES ,
	GL_TPRODUCTOS.PRO_DESCRIPCION,
	GL_TPRODUCTOS.PRO_OBSERVACION,
	GL_TPRODUCTOS.PROD_VALOR,
	GL_TPRODUCTOS.PROD_CANTIDAD ,
	GL_TPRODUCTOS.PRO_ESTADO
     FROM
       SCH_CN.GL_TPRODUCTOS
	   WHERE
          GL_TPRODUCTOS.PRO_ID= p_codigo_init
     ORDER BY
       SCH_CN.GL_TPRODUCTOS.PRO_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarProductosId;
/