CREATE
OR REPLACE PROCEDURE  GL_PListarEnvio(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
       GL_TENVIO.ENV_ID,
	   GL_TENVIO.ENV_CLIE_ID,
	   GL_TENVIO.ENV_TELEFONO,
       GL_TENVIO.ENV_BOD_ID,
       GL_TENVIO.ENV_FECHA_ENTREGA,
       GL_TENVIO.ENV_FECHA_ENVIO,
	   GL_TENVIO.ENV_ORIG_CIU_ID,
       GL_TENVIO.ENV_DEST_CIU_ID,
	   GL_TENVIO.ENV_ESTADO,
	   GL_TENVIO.ENV_REFERENCIA
     FROM
       SCH_CN.GL_TENVIO
     ORDER BY
       SCH_CN.GL_TENVIO.ENV_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarEnvio;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarEnvio (
    p_ENV_CLIE_ID_init IN VARCHAR2,
    p_ENV_TELEFONO_init IN VARCHAR2,
    p_ENV_BOD_ID_init IN VARCHAR2,
    p_ENV_FECHA_ENTREGA_init IN VARCHAR2,
	p_ENV_FECHA_ENVIO_init IN VARCHAR2,
    p_ENV_ORIG_CIU_ID_init IN VARCHAR2,
    p_ENV_DEST_CIU_ID_init IN VARCHAR2,
	p_ENV_ESTADO_init IN VARCHAR2,
	p_ENV_REFERENCIA_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TENVIO(ENV_CLIE_ID,ENV_TELEFONO,ENV_BOD_ID,
	ENV_FECHA_ENTREGA,ENV_FECHA_ENVIO,ENV_ORIG_CIU_ID,ENV_DEST_CIU_ID,ENV_ESTADO,ENV_REFERENCIA) 
values(p_ENV_CLIE_ID_init,p_ENV_TELEFONO_init,p_ENV_BOD_ID_init,
p_ENV_FECHA_ENTREGA_init,p_ENV_FECHA_ENVIO_init,p_ENV_ORIG_CIU_ID_init,p_ENV_DEST_CIU_ID_init,p_ENV_ESTADO_init,p_ENV_REFERENCIA_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarEnvio;



CREATE OR REPLACE PROCEDURE GL_PInsertarEnvioDetalleTemporal (
    p_ENV_REFERENCIA_init IN VARCHAR2
) AS 
BEGIN
    -- Creado por : guiovanny
    -- Fecha      : 16/05/2024
    -- Solicitud  : tcc
    -- Historial
    -- =========================================================================================================================================================================
    --  Version     Solicitud        Fecha      Realizo        Comentario
    -- ========== =============== ============ ============== ==================================================================================================================
    --   12000       tcc         16/05/2024      guiovanny  . Se crea este procedimiento para  InsertarCliente 
    -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
    --
    -- ========== =============== ============ ============== ==================================================================================================================
    --
    -- Responsable  de InsertarCliente 
    
  
        -- Insertar datos en la tabla temporal
        INSERT INTO SCH_CN.GL_TDETALLEENVIOTEMP (ENVDT_PROD_ID, ENVDT_CANTIDAD, ENVDT_PRECIO, ENVDT_TOTAL, ENVDT_ID)
        SELECT ENVD_PROD_ID, ENVD_CANTIDAD, ENVD_PRECIO, ENVD_TOTAL, p_ENV_REFERENCIA_init
        FROM GL_TDETALLEENVIO;
        
  
    EXCEPTION
        WHEN OTHERS THEN 
            DBMS_OUTPUT.PUT_LINE('ERROR');
            DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
            RAISE;
    
END GL_PInsertarEnvioDetalleTemporal;
/



CREATE OR REPLACE PROCEDURE GL_PlimpiarEnvioDetalle (
    p_ENV_REFERENCIA_init IN VARCHAR2
) AS 
BEGIN
    -- Creado por : guiovanny
    -- Fecha      : 16/05/2024
    -- Solicitud  : tcc
    -- Historial
    -- =========================================================================================================================================================================
    --  Version     Solicitud        Fecha      Realizo        Comentario
    -- ========== =============== ============ ============== ==================================================================================================================
    --   12000       tcc         16/05/2024      guiovanny  . Se crea este procedimiento para  InsertarCliente 
    -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
    --
    -- ========== =============== ============ ============== ==================================================================================================================
    --
    -- Responsable  de InsertarCliente 
    
  
        -- Insertar datos en la tabla temporal
      TRUNCATE TABLE SCH_CN.GL_TDETALLEENVIO;
        
  
    EXCEPTION
        WHEN OTHERS THEN 
            DBMS_OUTPUT.PUT_LINE('ERROR');
            DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
            RAISE;
    
END GL_PlimpiarEnvioDetalle;
/



CREATE
OR REPLACE PROCEDURE GL_PEditarEnvio (
   p_ENV_ID_init IN VARCHAR2,
   p_ENV_CLIE_ID_init IN VARCHAR2,
    p_ENV_TELEFONO_init IN VARCHAR2,
    p_ENV_BOD_ID_init IN VARCHAR2,
    p_ENV_FECHA_ENTREGA_init IN VARCHAR2,
	p_ENV_FECHA_ENVIO_init IN VARCHAR2,
    p_ENV_ORIG_CIU_ID_init IN VARCHAR2,
    p_ENV_DEST_CIU_ID_init IN VARCHAR2,
	p_ENV_ESTADO_init IN VARCHAR2

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
          SCH_CN.GL_TENVIO
         SET
	   ENV_CLIE_ID=p_ENV_CLIE_ID_init,
	   ENV_TELEFONO=p_ENV_TELEFONO_init,
       ENV_BOD_ID=p_ENV_BOD_ID_init,
       ENV_FECHA_ENTREGA=p_ENV_FECHA_ENTREGA_init,
       ENV_FECHA_ENVIO=p_ENV_FECHA_ENVIO_init,
	   ENV_ORIG_CIU_ID=p_ENV_ORIG_CIU_ID_init,
       ENV_DEST_CIU_ID=p_ENV_DEST_CIU_ID_init,
	   ENV_ESTADO=p_ENV_ESTADO_init
	  
    WHERE
          ENV_ID = p_ENV_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarEnvio;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarEnvio (
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
         SCH_CN.GL_TENVIO
	   WHERE
           ENV_REFERENCIA = p_codigo_init;
		   
		  
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;

END GL_PEliminarEnvio;
/



CREATE
OR REPLACE PROCEDURE GL_PEliminarEnvioDetallTem (
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
 
      DELETE FROM SCH_CN.GL_TDETALLEENVIOTEMP WHERE  ENVDT_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;

END GL_PEliminarEnvioDetallTem;
/





CREATE
OR REPLACE PROCEDURE GL_PBuscarEnvioCliente (
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
        GL_TENVIO.ENV_ID,
	   GL_TENVIO.ENV_CLIE_ID,
	   GL_TENVIO.ENV_TELEFONO,
       GL_TENVIO.ENV_BOD_ID,
       GL_TENVIO.ENV_FECHA_ENTREGA,
       GL_TENVIO.ENV_FECHA_ENVIO,
	   GL_TENVIO.ENV_ORIG_CIU_ID,
       GL_TENVIO.ENV_DEST_CIU_ID,
	   GL_TENVIO.ENV_ESTADO,
	   GL_TENVIO.ENV_REFERENCIA 
     FROM
       SCH_CN.GL_TENVIO
	   WHERE
          GL_TENVIO.ENV_CLIE_ID= p_nombre_init
     ORDER BY
       SCH_CN.GL_TENVIO.ENV_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarEnvioCliente;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarEnvioId (
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
         GL_TENVIO.ENV_ID,
	   GL_TENVIO.ENV_CLIE_ID,
	   GL_TENVIO.ENV_TELEFONO,
       GL_TENVIO.ENV_BOD_ID,
       GL_TENVIO.ENV_FECHA_ENTREGA,
       GL_TENVIO.ENV_FECHA_ENVIO,
	   GL_TENVIO.ENV_ORIG_CIU_ID,
       GL_TENVIO.ENV_DEST_CIU_ID,
	   GL_TENVIO.ENV_ESTADO,
	   GL_TENVIO.ENV_REFERENCIA 
     FROM
       SCH_CN.GL_TENVIO
	   WHERE
          ENV_REFERENCIA = p_codigo_init
     ORDER BY
       SCH_CN.GL_TENVIO.ENV_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarEnvioId;
/