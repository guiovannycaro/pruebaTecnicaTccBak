CREATE
OR REPLACE PROCEDURE  GL_PListarBodega(OUT_CURSOR OUT SYS_REFCURSOR) AS BEGIN
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
       GL_TBODEGA.BOD_ID,
	   GL_TBODEGA.BOD_NOMBRES,
	   GL_TBODEGA.BOD_DIRECCION,
       GL_TBODEGA.BOD_TELEFONO,
       GL_TBODEGA.BOD_ID_TIPO,
       GL_TBODEGA.BOD_CIUDAD_ID,
	   GL_TBODEGA.BOD_ZONA_ID,
       GL_TBODEGA.BOD_ESTADO
     FROM
       SCH_CN.GL_TBODEGA
     ORDER BY
       SCH_CN.GL_TBODEGA.BOD_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PListarBodega;
/


CREATE
OR REPLACE PROCEDURE GL_PInsertarBodega (
    p_BOD_NOMBRES_init IN VARCHAR2,
    p_BOD_DIRECCION_init IN VARCHAR2,
    p_BOD_TELEFONO_init IN VARCHAR2,
    p_BOD_ID_TIPO_init IN VARCHAR2,
	p_BOD_CIUDAD_ID_init IN VARCHAR2,
    p_BOD_ZONA_ID_init IN VARCHAR2,
    p_BOD_ESTADO_init IN VARCHAR2
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
  
	
	insert into SCH_CN.GL_TBODEGA(BOD_NOMBRES,BOD_DIRECCION,BOD_TELEFONO,
	BOD_ID_TIPO,BOD_CIUDAD_ID,BOD_ZONA_ID,BOD_ESTADO) 
values(p_BOD_NOMBRES_init,p_BOD_DIRECCION_init,p_BOD_TELEFONO_init,
p_BOD_ID_TIPO_init,p_BOD_CIUDAD_ID_init,p_BOD_ZONA_ID_init,p_BOD_ESTADO_init);
	
	
     
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PInsertarBodega;
/


CREATE
OR REPLACE PROCEDURE GL_PEditarBodega (
    p_codigo_init IN VARCHAR2,
     p_BOD_NOMBRES_init IN VARCHAR2,
    p_BOD_DIRECCION_init IN VARCHAR2,
    p_BOD_TELEFONO_init IN VARCHAR2,
    p_BOD_ID_TIPO_init IN VARCHAR2,
	p_BOD_CIUDAD_ID_init IN VARCHAR2,
    p_BOD_ZONA_ID_init IN VARCHAR2,
    p_BOD_ESTADO_init IN VARCHAR
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
          SCH_CN.GL_TBODEGA
         SET
		  BOD_NOMBRES=p_BOD_NOMBRES_init,
          BOD_DIRECCION =p_BOD_DIRECCION_init,
		  BOD_TELEFONO =p_BOD_TELEFONO_init,
          BOD_ID_TIPO=p_BOD_ID_TIPO_init,
          BOD_CIUDAD_ID=p_BOD_CIUDAD_ID_init,
		  BOD_ZONA_ID=p_BOD_ZONA_ID_init,
		  BOD_ESTADO=p_BOD_ESTADO_init
    WHERE
          BOD_ID = p_codigo_init;
		
EXCEPTION
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEditarBodega;
/

CREATE
OR REPLACE PROCEDURE GL_PEliminarBodega (
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
       SCH_CN.GL_TBODEGA
	   WHERE
            BOD_ID = p_codigo_init;
   
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PEliminarBodega;
/




CREATE
OR REPLACE PROCEDURE GL_PBuscarBodegaNombre (
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
       GL_TBODEGA.BOD_ID,
	   GL_TBODEGA.BOD_NOMBRES,
	   GL_TBODEGA.BOD_DIRECCION,
       GL_TBODEGA.BOD_TELEFONO,
       GL_TBODEGA.BOD_ID_TIPO,
       GL_TBODEGA.BOD_CIUDAD_ID,
	   GL_TBODEGA.BOD_ZONA_ID,
       GL_TBODEGA.BOD_ESTADO
     FROM
       SCH_CN.GL_TBODEGA
	   WHERE
          GL_TBODEGA.BOD_NOMBRES= p_nombre_init
     ORDER BY
       SCH_CN.GL_TBODEGA.BOD_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarBodegaNombre;
/

CREATE
OR REPLACE PROCEDURE GL_PBuscarBodegaId (
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
       GL_TBODEGA.BOD_ID,
	   GL_TBODEGA.BOD_NOMBRES,
	   GL_TBODEGA.BOD_DIRECCION,
       GL_TBODEGA.BOD_TELEFONO,
       GL_TBODEGA.BOD_ID_TIPO,
       GL_TBODEGA.BOD_CIUDAD_ID,
	   GL_TBODEGA.BOD_ZONA_ID,
       GL_TBODEGA.BOD_ESTADO
     FROM
       SCH_CN.GL_TBODEGA
	   WHERE
          BOD_ID = p_codigo_init
     ORDER BY
       SCH_CN.GL_TBODEGA.BOD_ID;
EXCEPTION
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('ERROR');
DBMS_OUTPUT.PUT_LINE('CODIGO : -1');
RAISE;
END GL_PBuscarBodegaId;
/