CREATE
OR REPLACE PROCEDURE  GL_PListarTipoDocumento(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	 
	 
	 GL_TTIPODOCUMENTO.TDOC_ID,
	GL_TTIPODOCUMENTO.TDOC_NOMBRE,
	GL_TTIPODOCUMENTO.TDOC_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPODOCUMENTO
     ORDER BY
       SCH_CN.GL_TTIPODOCUMENTO.TDOC_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarTipoDocumento;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarTipoDocumento (
  
    p_TDOC_NOMBRE_init IN VARCHAR2,
    p_TDOC_DESCRIPCION_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TTIPODOCUMENTO(TDOC_NOMBRE,TDOC_DESCRIPCION) 
values(p_TDOC_NOMBRE_init,p_TDOC_DESCRIPCION_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarTipoDocumento;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarTipoDocumento (
        p_TDOC_ID_init IN VARCHAR2,
    p_TDOC_NOMBRE_init IN VARCHAR2,
    p_TDOC_DESCRIPCION_init IN VARCHAR2
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
          SCH_CN.GL_TTIPODOCUMENTO
         SET
	   TDOC_NOMBRE=p_TDOC_NOMBRE_init,
       TDOC_DESCRIPCION=p_TDOC_DESCRIPCION_init
      
    WHERE
          TDOC_ID = p_TDOC_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarTipoDocumento;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarTipoDocumento (
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
         SCH_CN.GL_TTIPODOCUMENTO
	   WHERE
            TDOC_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarTipoDocumento;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarTipoDocumentoNombre (
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
     GL_TTIPODOCUMENTO.TDOC_ID ,
	GL_TTIPODOCUMENTO.TDOC_NOMBRE,
	GL_TTIPODOCUMENTO.TDOC_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPODOCUMENTO
	   WHERE
          GL_TTIPODOCUMENTO.TDOC_NOMBRE= p_nombre_init
     ORDER BY
       SCH_CN.GL_TTIPODOCUMENTO.TDOC_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarTipoDocumentoNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarTipoDocumentoId (
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
     GL_TTIPODOCUMENTO.TDOC_ID ,
	GL_TTIPODOCUMENTO.TDOC_NOMBRE,
	GL_TTIPODOCUMENTO.TDOC_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPODOCUMENTO
	   WHERE
          GL_TTIPODOCUMENTO.TDOC_ID= p_nombre_init;
	   
	   
     
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarTipoDocumentoId;
/CREATE
OR REPLACE PROCEDURE  GL_PListarTipoDocumento(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	 
	 
	 GL_TTIPODOCUMENTO.TDOC_ID,
	GL_TTIPODOCUMENTO.TDOC_NOMBRE,
	GL_TTIPODOCUMENTO.TDOC_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPODOCUMENTO
     ORDER BY
       SCH_CN.GL_TTIPODOCUMENTO.TDOC_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarTipoDocumento;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarTipoDocumento (
  
    p_TDOC_NOMBRE_init IN VARCHAR2,
    p_TDOC_DESCRIPCION_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TTIPODOCUMENTO(TDOC_NOMBRE,TDOC_DESCRIPCION) 
values(p_TDOC_NOMBRE_init,p_TDOC_DESCRIPCION_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarTipoDocumento;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarTipoDocumento (
        p_TDOC_ID_init IN VARCHAR2,
    p_TDOC_NOMBRE_init IN VARCHAR2,
    p_TDOC_DESCRIPCION_init IN VARCHAR2
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
          SCH_CN.GL_TTIPODOCUMENTO
         SET
	   TDOC_NOMBRE=p_TDOC_NOMBRE_init,
       TDOC_DESCRIPCION=p_TDOC_DESCRIPCION_init
      
    WHERE
          TDOC_ID = p_TDOC_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarTipoDocumento;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarTipoDocumento (
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
         SCH_CN.GL_TTIPODOCUMENTO
	   WHERE
            TDOC_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarTipoDocumento;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarTipoDocumentoNombre (
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
     GL_TTIPODOCUMENTO.TDOC_ID ,
	GL_TTIPODOCUMENTO.TDOC_NOMBRE,
	GL_TTIPODOCUMENTO.TDOC_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPODOCUMENTO
	   WHERE
          GL_TTIPODOCUMENTO.TDOC_NOMBRE= p_nombre_init
     ORDER BY
       SCH_CN.GL_TTIPODOCUMENTO.TDOC_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarTipoDocumentoNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarTipoDocumentoId (
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
     GL_TTIPODOCUMENTO.TDOC_ID ,
	GL_TTIPODOCUMENTO.TDOC_NOMBRE,
	GL_TTIPODOCUMENTO.TDOC_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPODOCUMENTO
	   WHERE
          GL_TTIPODOCUMENTO.TDOC_ID= p_nombre_init;
	   
	   
     
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarTipoDocumentoId;
/