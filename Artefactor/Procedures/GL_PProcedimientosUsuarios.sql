CREATE
OR REPLACE PROCEDURE  GL_PListarUsuarios(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
	  GL_TUSUARIOS.USU_ID ,
	  GL_TUSUARIOS.USU_NOMBRES,
	  GL_TUSUARIOS.USU_DIRECCION, 
	  GL_TUSUARIOS.USU_TELEFONO,
	  GL_TUSUARIOS.USU_CORREO,
	  GL_TUSUARIOS.USU_NUMDOCUMENTO,
	  GL_TUSUARIOS.USU_PASSWORD,
	  GL_TUSUARIOS.USU_TDOC_ID,
	  GL_TUSUARIOS.USU_ROL_ID,
	  GL_TUSUARIOS.USU_ESTADO
     FROM
       SCH_CN.GL_TUSUARIOS
     ORDER BY
       SCH_CN.GL_TUSUARIOS.USU_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarUsuarios;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarUsuarios (
	  p_USU_NOMBRES_init,
	  p_USU_DIRECCION_init, 
	  p_USU_TELEFONO_init,
	  p_USU_CORREO_init,
	  p_USU_NUMDOCUMENTO_init,
	  p_USU_PASSWORD_init,
	  p_USU_TDOC_ID_init,
	  p_USU_ROL_ID_init,
	  p_USU_ESTADO_init
	
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
  
	
	insert into SCH_CN.GL_TUSUARIOS(
	USU_NOMBRES,
	USU_DIRECCION,
	USU_TELEFONO,
	USU_CORREO,
	USU_NUMDOCUMENTO,
	USU_PASSWORD,
	USU_TDOC_ID,
	USU_ROL_ID,
	USU_ESTADO
	
	) 
values(
      p_USU_NOMBRES_init,
	  p_USU_DIRECCION_init, 
	  p_USU_TELEFONO_init,
	  p_USU_CORREO_init,
	  p_USU_NUMDOCUMENTO_init,
	  p_USU_PASSWORD_init,
	  p_USU_TDOC_ID_init,
	  p_USU_ROL_ID_init,
	  p_USU_ESTADO_init
);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarUsuarios;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarUsuarios (
      p_USU_ID_init IN VARCHAR2,
      p_USU_NOMBRES_init IN VARCHAR2,
	  p_USU_DIRECCION_init IN VARCHAR2, 
	  p_USU_TELEFONO_init IN VARCHAR2,
	  p_USU_CORREO_init IN VARCHAR2,
	  p_USU_NUMDOCUMENTO_init IN VARCHAR2,
	  p_USU_PASSWORD_init IN VARCHAR2,
	  p_USU_TDOC_ID_init IN VARCHAR2,
	  p_USU_ROL_ID_init IN VARCHAR2,
	  p_USU_ESTADO_init IN VARCHAR2
	  
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
          SCH_CN.GL_TUSUARIOS
         SET
	  USU_NOMBRES=p_USU_NOMBRES_init,
	USU_DIRECCION=p_USU_DIRECCION_init,
	USU_TELEFONO=p_USU_TELEFONO_init,
	USU_CORREO=p_USU_CORREO_init,
	USU_NUMDOCUMENTO=p_USU_NUMDOCUMENTO_init,
	USU_PASSWORD=p_USU_PASSWORD_init,
	USU_TDOC_ID=p_USU_TDOC_ID_init,
	USU_ROL_ID=p_USU_ROL_ID_init,
	USU_ESTADO=p_USU_ESTADO_init
      
    WHERE
          USU_ID = p_USU_ID_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarUsuarios;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarUsuarios (
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
        SCH_CN.GL_TUSUARIOS
	   WHERE
            USU_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarUsuarios;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarUsuariosNombre (
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
     GL_TUSUARIOS.USU_ID ,
	  GL_TUSUARIOS.USU_NOMBRES,
	  GL_TUSUARIOS.USU_DIRECCION, 
	  GL_TUSUARIOS.USU_TELEFONO,
	  GL_TUSUARIOS.USU_CORREO,
	  GL_TUSUARIOS.USU_NUMDOCUMENTO,
	  GL_TUSUARIOS.USU_PASSWORD,
	  GL_TUSUARIOS.USU_TDOC_ID,
	  GL_TUSUARIOS.USU_ROL_ID,
	  GL_TUSUARIOS.USU_ESTADO
     FROM
       SCH_CN.GL_TUSUARIOS
	   WHERE
          GL_TUSUARIOS.USU_NOMBRES= p_nombre_init
     ORDER BY
       SCH_CN.GL_TUSUARIOS.USU_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarUsuariosNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarUsuariosId (
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
         GL_TUSUARIOS.USU_ID ,
	  GL_TUSUARIOS.USU_NOMBRES,
	  GL_TUSUARIOS.USU_DIRECCION, 
	  GL_TUSUARIOS.USU_TELEFONO,
	  GL_TUSUARIOS.USU_CORREO,
	  GL_TUSUARIOS.USU_NUMDOCUMENTO,
	  GL_TUSUARIOS.USU_PASSWORD,
	  GL_TUSUARIOS.USU_TDOC_ID,
	  GL_TUSUARIOS.USU_ROL_ID,
	  GL_TUSUARIOS.USU_ESTADO
     FROM
       SCH_CN.GL_TUSUARIOS
	   WHERE
         USU_ID = p_codigo_init
     ORDER BY
       SCH_CN.GL_TUSUARIOS.USU_ID;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarUsuariosId;
/



CREATE
OR REPLACE PROCEDURE GL_PValidarUsuario (
  p_usuario_init IN VARCHAR2,
  p_password_init IN VARCHAR2,
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
	  GL_TUSUARIOS.USU_CORREO,
	  GL_TUSUARIOS.USU_PASSWORD
     FROM
       SCH_CN.GL_TUSUARIOS
	   WHERE
         USU_CORREO = p_usuario_init;
	   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PValidarUsuario;
/


CREATE
OR REPLACE PROCEDURE GL_PCambiarContrasena (
	  p_USU_CORREO_init IN VARCHAR2,
	  p_USU_PASSWORD_init IN VARCHAR2	  
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
          SCH_CN.GL_TUSUARIOS
         SET
	USU_PASSWORD=p_USU_PASSWORD_init
    WHERE
          USU_CORREO = p_USU_CORREO_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PCambiarContrasena;
/

CREATE
OR REPLACE PROCEDURE GL_PMostrarPerfil (
	  p_USU_CORREO_init IN VARCHAR2,
	  p_USU_PASSWORD_init IN VARCHAR2,
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
  --   12000       tcc         16/05/2024      guiovanny  . Se crea este procedimiento para  EditarCliente
  -- ---------- --------------- ------------ -------------- -----------------------------------------------------------------------------------------------------------------
  --
  -- ========== =============== ============ ============== ==================================================================================================================
  --
    --
    -- Responsable  de EditarCliente
    --
OPEN OUT_CURSOR FOR
         SELECT 
	 GL_TUSUARIOS.USU_ROL_ID
     FROM
       SCH_CN.GL_TUSUARIOS
	   WHERE
         USU_CORREO = p_USU_CORREO_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PMostrarPerfil;
/

