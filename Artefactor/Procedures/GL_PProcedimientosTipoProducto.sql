CREATE
OR REPLACE PROCEDURE  GL_PListarTipoProducto(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	 
	 
	 GL_TTIPOPRODUCTO.TIPOPR_ID,
	GL_TTIPOPRODUCTO.TIPOPR_NOMBRE,
	GL_TTIPOPRODUCTO.TIPOPR_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPOPRODUCTO
     ORDER BY
       SCH_CN.GL_TTIPOPRODUCTO.TIPOPR_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarTipoProducto;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarTipoProducto (
  
    p_TIPOPR_NOMBRE_init IN VARCHAR2,
    p_TIPOPR_DESCRIPCION_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TTIPOPRODUCTO(TIPOPR_NOMBRE,TIPOPR_DESCRIPCION) 
values(p_TIPOPR_NOMBRE_init,p_TIPOPR_DESCRIPCION_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarTipoProducto;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarTipoProducto (
        p_TIPOPR_ID_init IN VARCHAR2,
    p_TIPOPR_NOMBRE_init IN VARCHAR2,
    p_TIPOPR_DESCRIPCION_init IN VARCHAR2
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
          SCH_CN.GL_TTIPOPRODUCTO
         SET
	   TIPOPR_NOMBRE=p_TIPOPR_NOMBRE_init,
       TIPOPR_DESCRIPCION=p_TIPOPR_DESCRIPCION_init
      
    WHERE
          TIPOPR_ID = p_TIPOPR_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarTipoProducto;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarTipoProducto (
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
         SCH_CN.GL_TTIPOPRODUCTO
	   WHERE
            TIPOPR_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarTipoProducto;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarTipoProductoNombre (
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
     GL_TTIPOPRODUCTO.TIPOPR_ID ,
	GL_TTIPOPRODUCTO.TIPOPR_NOMBRE,
	GL_TTIPOPRODUCTO.TIPOPR_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPOPRODUCTO
	   WHERE
          GL_TTIPOPRODUCTO.TIPOPR_NOMBRE= p_nombre_init
     ORDER BY
       SCH_CN.GL_TTIPOPRODUCTO.TIPOPR_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarTipoProductoNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarTipoProductoId (
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
     GL_TTIPOPRODUCTO.TIPOPR_ID ,
	GL_TTIPOPRODUCTO.TIPOPR_NOMBRE,
	GL_TTIPOPRODUCTO.TIPOPR_DESCRIPCION
     FROM
       SCH_CN.GL_TTIPOPRODUCTO
	   WHERE
          GL_TTIPOPRODUCTO.TIPOPR_ID= p_codigo_init
     
	   
	   
     
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarTipoProductoId;

