CREATE
OR REPLACE PROCEDURE GL_PListarClientes (OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
       GL_TCLIENTES.CLI_ID,
	   GL_TCLIENTES.CLI_NOMBRES,
	   GL_TCLIENTES.CLI_TIPODOCUMENTO,
       GL_TCLIENTES.CLI_CEDULA,
       GL_TCLIENTES.CLI_CORREO,
       GL_TCLIENTES.CLI_CELULAR,
	   GL_TCLIENTES.CLI_DIRECCION,
       GL_TCLIENTES.CLI_CIUDAD_ID,
       GL_TCLIENTES.CLI_ESTADO
     FROM
       SCH_CN.GL_TCLIENTES
     ORDER BY
       SCH_CN.GL_TCLIENTES.CLI_CEDULA;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarClientes;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarCliente (
    p_CLI_NOMBRES_init IN VARCHAR2,
    p_CLI_TIPODOCUMENTO_init IN VARCHAR2,
    p_CLI_CEDULA_init IN VARCHAR2,
    p_CLI_CORREO_init IN VARCHAR2,
	p_CLI_CELULAR_init IN VARCHAR2,
    p_CLI_DIRECCION_init IN VARCHAR2,
    p_CLI_CIUDAD_ID_init IN VARCHAR2,
    p_CLI_ESTADO_init IN VARCHAR2,
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
  --   12000       tcc         16/05/2024      guiovanny  . Se crea este procedimiento para  InsertarCliente 
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de InsertarCliente 
    --
    OPEN OUT_CURSOR FOR
	
	insert into SCH_CN.GL_TCLIENTES(CLI_CEDULA,CLI_TIPODOCUMENTO,CLI_NOMBRES,CLI_CIUDAD_ID,CLI_CORREO,CLI_CELULAR,CLI_ESTADO,CLI_DIRECCION) 
values(p_CLI_CEDULA_init,p_CLI_TIPODOCUMENTO_init,p_CLI_NOMBRES_init,p_CLI_CIUDAD_ID_init,p_CLI_CORREO_init,p_CLI_CELULAR_init,p_CLI_ESTADO_init,p_CLI_DIRECCION_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarCliente;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarCliente (
    p_codigo_init IN VARCHAR2,
    p_CLI_NOMBRES_init IN VARCHAR2,
    p_CLI_TIPODOCUMENTO_init IN VARCHAR2,
    p_CLI_CEDULA_init IN VARCHAR2,
    p_CLI_CORREO_init IN VARCHAR2,
	p_CLI_CELULAR_init IN VARCHAR2,
    p_CLI_DIRECCION_init IN VARCHAR2,
    p_CLI_CIUDAD_ID_init IN VARCHAR2,
    p_CLI_ESTADO_init IN VARCHAR2
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
          SCH_CN.GL_TCLIENTES
         SET
		  CLI_NOMBRES=p_CLI_NOMBRES_init,
          CLI_TIPODOCUMENTO =p_CLI_TIPODOCUMENTO_init,
		  CLI_CEDULA =p_CLI_CEDULA_init,
          CLI_CORREO=p_CLI_CORREO_init,
          CLI_CELULAR=p_CLI_CELULAR_init,
		  CLI_DIRECCION=p_CLI_DIRECCION_init,
		  CLI_CIUDAD_ID=p_CLI_CIUDAD_ID_init,
		  CLI_ESTADO=p_CLI_ESTADO_init
    WHERE
          CLI_ID = p_codigo_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarCliente;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarCliente (
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
       SCH_CN.GL_TCLIENTES
	   WHERE
            CLI_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarCliente;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarClienteNombre (
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
       GL_TCLIENTES.CLI_ID,
	   GL_TCLIENTES.CLI_NOMBRES,
	   GL_TCLIENTES.CLI_TIPODOCUMENTO,
       GL_TCLIENTES.CLI_CEDULA,
       GL_TCLIENTES.CLI_CORREO,
       GL_TCLIENTES.CLI_CELULAR,
	   GL_TCLIENTES.CLI_DIRECCION,
       GL_TCLIENTES.CLI_CIUDAD_ID,
       GL_TCLIENTES.CLI_ESTADO
     FROM
       SCH_CN.GL_TCLIENTES
	   WHERE
          GL_TCLIENTES.CLI_NOMBRES= p_nombre_init
     ORDER BY
       SCH_CN.GL_TCLIENTES.CLI_CEDULA;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarClienteNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarClienteId (
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
       GL_TCLIENTES.CLI_ID,
	   GL_TCLIENTES.CLI_NOMBRES,
	   GL_TCLIENTES.CLI_TIPODOCUMENTO,
       GL_TCLIENTES.CLI_CEDULA,
       GL_TCLIENTES.CLI_CORREO,
       GL_TCLIENTES.CLI_CELULAR,
	   GL_TCLIENTES.CLI_DIRECCION,
       GL_TCLIENTES.CLI_CIUDAD_ID,
       GL_TCLIENTES.CLI_ESTADO
     FROM
       SCH_CN.GL_TCLIENTES
	   WHERE
          CLI_ID = p_codigo_init;
     ORDER BY
       SCH_CN.GL_TCLIENTES.CLI_CEDULA;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarClienteId;
/