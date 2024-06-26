CREATE TRIGGER GL_GCLIENTES BEFORE
INSERT
  ON GL_TCLIENTES FOR EACH ROW BEGIN
    SELECT
   GL_SCLIENTES.NEXTVAL INTO :NEW.CLI_ID
    FROM
      DUAL;
END;

CREATE TRIGGER GL_GBODEGA BEFORE
INSERT
  ON GL_TBODEGA FOR EACH ROW BEGIN
    SELECT
   GL_SBODEGA.NEXTVAL INTO :NEW.BOD_ID
    FROM
      DUAL;
END;

CREATE OR REPLACE TRIGGER GL_GENVIO 
BEFORE INSERT ON GL_TENVIO 
  FOR EACH ROW 
   BEGIN
    SELECT
      GL_SENVIO.NEXTVAL 
	   INTO :NEW.ENV_ID
       FROM
       DUAL;
END;



ALTER TABLE GL_TENVIO
  ADD CONSTRAINT pk_GENVIO_dt PRIMARY KEY( ENV_ID );
  

CREATE TRIGGER GL_GDETALLEENVIO BEFORE
INSERT
  ON GL_TDETALLEENVIO FOR EACH ROW BEGIN
    SELECT
   GL_SDETALLEENVIO.NEXTVAL INTO :NEW.ENVD_ID
    FROM
      DUAL;
END;


CREATE TRIGGER GL_GDETALLEENVIOTEMP BEFORE
INSERT
  ON GL_TDETALLEENVIOTEMP FOR EACH ROW BEGIN
    SELECT
   GL_SDETALLEENVIOTEMP.NEXTVAL INTO :NEW.ENVDT_IDP
    FROM
      DUAL;
END;



CREATE TRIGGER GL_GZONAS BEFORE
INSERT
  ON GL_TZONAS FOR EACH ROW BEGIN
    SELECT
   GL_SZONAS.NEXTVAL INTO :NEW.ZON_ID
    FROM
      DUAL;
END;

CREATE OR REPLACE TRIGGER GL_GUSUARIOS 
BEFORE INSERT ON GL_TUSUARIOS
 FOR EACH ROW 
   BEGIN
    SELECT GL_SUSUARIOS.NEXTVAL
 	INTO :NEW.USU_ID 
	FROM DUAL;
END;

ALTER TABLE GL_TUSUARIOS
  ADD CONSTRAINT pk_GUSUARIOS_dt PRIMARY KEY( USU_ID );

CREATE TRIGGER GL_GTIPOPRODUCTO BEFORE
INSERT
  ON GL_TTIPOPRODUCTO FOR EACH ROW BEGIN
    SELECT
   GL_STIPOPRODUCTO.NEXTVAL INTO :NEW.TIPOPR_ID
    FROM
      DUAL;
END;

CREATE TRIGGER GL_GTIPODOCUMENTO BEFORE
INSERT
  ON GL_TTIPODOCUMENTO FOR EACH ROW BEGIN
    SELECT
   GL_STIPODOCUMENTO.NEXTVAL INTO :NEW.TDOC_ID
    FROM
      DUAL;
END;

CREATE TRIGGER GL_GTIPOBODEGA BEFORE
INSERT
  ON GL_TTIPOBODEGA FOR EACH ROW BEGIN
    SELECT
   GL_STIPOBODEGA.NEXTVAL INTO :NEW.TIPOB_ID
    FROM
      DUAL;
END;

CREATE TRIGGER GL_GROLES BEFORE
INSERT
  ON GL_TROLES FOR EACH ROW BEGIN
    SELECT
   GL_SROLES.NEXTVAL INTO :NEW.ROL_ID
    FROM
      DUAL;
END;

CREATE TRIGGER GL_GPRODUCTOS BEFORE
INSERT
  ON GL_TPRODUCTOS FOR EACH ROW BEGIN
    SELECT
   GL_SPRODUCTOS.NEXTVAL INTO :NEW.PRO_ID
    FROM
      DUAL;
END;