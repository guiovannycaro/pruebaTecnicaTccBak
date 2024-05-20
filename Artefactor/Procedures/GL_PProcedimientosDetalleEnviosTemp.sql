CREATE
OR REPLACE PROCEDURE  GL_PListarDetalleEnvioTemp(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	 
	 GL_TDETALLEENVIOTEMP.ENVDT_PROD_ID ,
	GL_TDETALLEENVIOTEMP.ENVDT_CANTIDAD,
	GL_TDETALLEENVIOTEMP.ENVDT_PRECIO ,
	GL_TDETALLEENVIOTEMP.ENVDT_TOTAL,
	GL_TDETALLEENVIOTEMP.ENVDT_ID,
	GL_TDETALLEENVIOTEMP.ENVDT_IDP

     FROM
       SCH_CN.GL_TDETALLEENVIOTEMP
     ORDER BY
       SCH_CN.GL_TDETALLEENVIOTEMP.ENVDT_PROD_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarDetalleEnvioTemp;
/



CREATE
OR REPLACE PROCEDURE GL_PInsertarDetalleEnvioTemp (
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
  
	
	insert into SCH_CN.GL_TDETALLEENVIO(
    ENVDT_PROD_ID ,
	ENVDT_CANTIDAD,
	ENVDT_PRECIO ,
	ENVDT_TOTAL,
	ENVD_ENV_ID
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
END GL_PInsertarDetalleEnvioTemp;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarDetalleEnvioTemp (
    p_ENVDT_PROD_ID_init IN VARCHAR2,
    p_ENVDT_CANTIDAD_init IN VARCHAR2,
    p_ENVDT_PRECIO_init IN VARCHAR2,
    p_ENVDT_TOTAL_init IN VARCHAR2,
	p_ENVDT_ID_init IN VARCHAR2
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
          SCH_CN.GL_TDETALLEENVIOTEMP
         SET
	   ENVDT_PROD_ID=p_ENVDT_PROD_ID_init,
       ENVDT_CANTIDAD=p_ENVDT_CANTIDAD_init,
       ENVDT_PRECIO=p_ENVDT_PRECIO_init,
       ENVDT_TOTAL=p_ENVDT_TOTAL_init,
	   ENVDT_ID=p_ENVDT_ID_init
      
    WHERE
          ENVDT_ID = p_ENVDT_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarDetalleEnvioTemp;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarDetalleEnvioTemp (
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
         SCH_CN.GL_TDETALLEENVIOTEMP
	   WHERE
            ENVDT_IDP = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarDetalleEnvioTemp;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarDetalleEnvioTempProducto (
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
    GL_TDETALLEENVIOTEMP.ENVDT_PROD_ID ,
	GL_TDETALLEENVIOTEMP.ENVDT_CANTIDAD,
	GL_TDETALLEENVIOTEMP.ENVDT_PRECIO ,
	GL_TDETALLEENVIOTEMP.ENVDT_TOTAL,
	GL_TDETALLEENVIOTEMP.ENVDT_ID,
	GL_TDETALLEENVIOTEMP.ENVDT_IDP
     FROM
       SCH_CN.GL_TDETALLEENVIOTEMP
	   WHERE
          GL_TDETALLEENVIOTEMP.ENVDT_PROD_ID= p_nombre_init
     ORDER BY
       SCH_CN.GL_TDETALLEENVIOTEMP.ENVDT_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarDetalleEnvioTempProducto;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarDetalleEnvioTempId (
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
        GL_TDETALLEENVIOTEMP.ENVDT_PROD_ID ,
	GL_TDETALLEENVIOTEMP.ENVDT_CANTIDAD,
	GL_TDETALLEENVIOTEMP.ENVDT_PRECIO ,
	GL_TDETALLEENVIOTEMP.ENVDT_TOTAL,
	GL_TDETALLEENVIOTEMP.ENVDT_ID,
	GL_TDETALLEENVIOTEMP.ENVDT_IDP
     FROM
       SCH_CN.GL_TDETALLEENVIOTEMP
	   WHERE
         ENVDT_ID = p_codigo_init;
   
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarDetalleEnvioTempId;
/