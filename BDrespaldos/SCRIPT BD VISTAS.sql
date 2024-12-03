CREATE VIEW "DETALLES LICENCIAS" AS
	SELECT ID AS "ID",
		(SELECT DOCUMENTO AS "CEDULA" FROM PERSONAS AS TRANS WHERE TRANS.DOCUMENTO = TRANS_LIC.TRANSPORTISTA),
		(SELECT NOMBRE AS "TRANSPORTISTA" FROM PERSONAS AS TRANS WHERE TRANS.DOCUMENTO = TRANS_LIC.TRANSPORTISTA),
		(SELECT CODIGO AS "ID LICENCIA" FROM LICENCIAS AS LIC WHERE LIC.CODIGO = TRANS_LIC.LICENCIA),
		CODIGO AS "CODIGO",
		(SELECT GRADO AS "TIPO" FROM LICENCIAS AS LIC WHERE LIC.CODIGO = TRANS_LIC.LICENCIA),
		(SELECT DETALLES AS "DESCRIPCION" FROM LICENCIAS AS LIC WHERE LIC.CODIGO = TRANS_LIC.LICENCIA),
		VENCIMIENTO AS "FECHA DE VENCIMIENTO",
		ESTATUS AS "ESTADO"
	FROM TRANSPORTISTAS_LICENCIAS AS TRANS_LIC WHERE ESTATUS != 99;