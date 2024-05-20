CREATE
OR REPLACE PROCEDURE  GL_PListarDetalleEnvio(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	 
	 GL_TDETALLEENVIO.ENVD_ID ,
	GL_TDETALLEENVIO.ENVD_PROD_ID,
	GL_TDETALLEENVIO.ENVD_CANTIDAD ,
	GL_TDETALLEENVIO.ENVD_PRECIO,
	GL_TDETALLEENVIO.ENVD_SUBTOTAL,
	GL_TDETALLEENVIO.ENVD_IVA ,
	GL_TDETALLEENVIO.ENVD_TOTAL,
	GL_TDETALLEENVIO.ENVD_DESCUENTO ,
	GL_TDETALLEENVIO.ENVD_ENV_ID 
     FROM
       SCH_CN.GL_TDETALLEENVIO
     ORDER BY
       SCH_CN.GL_TDETALLEENVIO.ENVD_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarDetalleEnvio;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarDetalleEnvio (
    p_ENVD_PROD_ID_init IN VARCHAR2,
    p_ENVD_CANTIDAD_init IN VARCHAR2,
    p_ENVD_PRECIO_init IN VARCHAR2,
	p_ENVD_SUBTOTAL_init IN VARCHAR2,
    p_ENVD_IVA_init IN VARCHAR2,
    p_ENVD_TOTAL_init IN VARCHAR2,
	p_ENVD_DESCUENTO_init IN VARCHAR2,
	p_ENVD_ENV_ID_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TDETALLEENVIO(ENVD_PROD_ID,ENVD_CANTIDAD,ENVD_PRECIO,
	ENVD_SUBTOTAL,ENVD_IVA,ENVD_TOTAL,ENVD_DESCUENTO,ENVD_ENV_ID) 
values(p_ENVD_PROD_ID_init,p_ENVD_CANTIDAD_init,
p_ENVD_PRECIO_init,p_ENVD_SUBTOTAL_init,p_ENVD_IVA_init,p_ENVD_TOTAL_init,p_ENVD_DESCUENTO_init,p_ENVD_ENV_ID_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarDetalleEnvio;
/



CREATE
OR REPLACE PROCEDURE GL_PInsertarDetalleEnvioTempD (
    p_ENVDT_PROD_ID_init IN NUMBER,
    p_ENVDT_CANTIDAD_init IN NUMBER,
    p_ENVDT_PRECIO_init IN NUMBER,
    p_ENVDT_TOTAL_init IN NUMBER,
	p_DATENV_REF_init IN  VARCHAR2
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
  
	
	insert into SCH_CN.GL_TDETALLEENVIOTEMP(
    ENVDT_PROD_ID ,
	ENVDT_CANTIDAD,
	ENVDT_PRECIO ,
	ENVDT_TOTAL,
	ENVDT_ID
	) 
values(
p_ENVDT_PROD_ID_init,
p_ENVDT_CANTIDAD_init,
p_ENVDT_PRECIO_init,
p_ENVDT_TOTAL_init,
p_DATENV_REF_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarDetalleEnvioTempD;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarDetalleEnvio (
     p_ENVD_ID_init IN VARCHAR2,
    p_ENVD_PROD_ID_init IN VARCHAR2,
    p_ENVD_CANTIDAD_init IN VARCHAR2,
    p_ENVD_PRECIO_init IN VARCHAR2,
	p_ENVD_SUBTOTAL_init IN VARCHAR2,
    p_ENVD_IVA_init IN VARCHAR2,
    p_ENVD_TOTAL_init IN VARCHAR2,
	p_ENVD_DESCUENTO_init IN VARCHAR2,
	p_ENVD_ENV_ID_init IN VARCHAR2
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
          SCH_CN.GL_TDETALLEENVIO
         SET
	   ENVD_PROD_ID=p_ENVD_PROD_ID_init,
       ENVD_CANTIDAD=p_ENVD_CANTIDAD_init,
       ENVD_PRECIO=p_ENVD_PRECIO_init,
       ENVD_SUBTOTAL=p_ENVD_SUBTOTAL_init,
	   ENVD_IVA=p_ENVD_IVA_init,
       ENVD_TOTAL=p_ENVD_TOTAL_init,
	   ENVD_DESCUENTO=p_ENVD_DESCUENTO_init,
	   ENVD_ENV_ID=p_ENVD_ENV_ID_init
    WHERE
          ENVD_ID = p_ENVD_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarDetalleEnvio;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarDetalleEnvio (
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
         SCH_CN.GL_TDETALLEENVIO
	   WHERE
            ENVD_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarDetalleEnvio;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarDetalleEnvioProducto (
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
        GL_TDETALLEENVIO.ENVD_ID ,
	GL_TDETALLEENVIO.ENVD_PROD_ID,
	GL_TDETALLEENVIO.ENVD_CANTIDAD ,
	GL_TDETALLEENVIO.ENVD_PRECIO,
	GL_TDETALLEENVIO.ENVD_SUBTOTAL,
	GL_TDETALLEENVIO.ENVD_IVA ,
	GL_TDETALLEENVIO.ENVD_TOTAL,
	GL_TDETALLEENVIO.ENVD_DESCUENTO ,
	GL_TDETALLEENVIO.ENVD_ENV_ID 
     FROM
       SCH_CN.GL_TDETALLEENVIO
	   WHERE
          GL_TDETALLEENVIO.ENVD_PROD_ID= p_nombre_init
     ORDER BY
       SCH_CN.GL_TDETALLEENVIO.ENVD_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarDetalleEnvioProducto;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarDetalleEnvioId (
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
            GL_TDETALLEENVIO.ENVD_ID ,
	GL_TDETALLEENVIO.ENVD_PROD_ID,
	GL_TDETALLEENVIO.ENVD_CANTIDAD ,
	GL_TDETALLEENVIO.ENVD_PRECIO,
	GL_TDETALLEENVIO.ENVD_SUBTOTAL,
	GL_TDETALLEENVIO.ENVD_IVA ,
	GL_TDETALLEENVIO.ENVD_TOTAL,
	GL_TDETALLEENVIO.ENVD_DESCUENTO ,
	GL_TDETALLEENVIO.ENVD_ENV_ID 
     FROM
       SCH_CN.GL_TDETALLEENVIO
	   WHERE
         ENVD_ID = p_codigo_init
     ORDER BY
       SCH_CN.GL_TDETALLEENVIO.ENVD_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarDetalleEnvioId;
/