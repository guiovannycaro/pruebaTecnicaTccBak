CREATE
OR REPLACE PROCEDURE  GL_PListarRoles(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	 
	 GL_TROLES.ROL_ID,
	GL_TROLES.ROL_NOMBRE,
	GL_TROLES.ROL_DESCRIPCION
     FROM
       SCH_CN.GL_TROLES
     ORDER BY
       SCH_CN.GL_TROLES.ROL_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarRoles;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarRol (
  
    p_ROL_NOMBRE_ID_init IN VARCHAR2,
    p_ROL_DESCRIPCION_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TROLES(ROL_NOMBRE,ROL_DESCRIPCION) 
values(p_ROL_NOMBRE_ID_init,p_ROL_DESCRIPCION_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarRol;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarRol (
        p_ROL_ID_init IN VARCHAR2,
    p_ROL_NOMBRE_ID_init IN VARCHAR2,
    p_ROL_DESCRIPCION_init IN VARCHAR2
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
          SCH_CN.GL_TROLES
         SET
	   ROL_NOMBRE=p_ROL_NOMBRE_ID_init,
       ROL_DESCRIPCION=p_ROL_DESCRIPCION_init
      
    WHERE
          ROL_ID = p_ROL_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarRol;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarRol (
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
         SCH_CN.GL_TROLES
	   WHERE
            ROL_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarRol;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarRolesNombre (
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
     GL_TROLES.ROL_ID ,
	GL_TROLES.ROL_NOMBRE,
	GL_TROLES.ROL_DESCRIPCION
     FROM
       SCH_CN.GL_TROLES
	   WHERE
          GL_TROLES.ROL_NOMBRE= p_nombre_init
     ORDER BY
       SCH_CN.GL_TROLES.ROL_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarRolesNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarRolesId (
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
        GL_TROLES.ROL_ID ,
	    GL_TROLES.ROL_NOMBRE,
	    GL_TROLES.ROL_DESCRIPCION
     FROM
       SCH_CN.GL_TROLES
	   WHERE
         ROL_ID = p_codigo_init
     ORDER BY
       SCH_CN.GL_TROLES.ROL_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarRolesId;
/