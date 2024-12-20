
-- TABLAS DE LOS TRANSPORTISTAS
CREATE TABLE PERSONAS (
	ID SERIAL NOT NULL UNIQUE,
	DOCUMENTO INT NOT NULL UNIQUE PRIMARY KEY,
	NOMBRE VARCHAR(100) NOT NULL,
	TELEFONO VARCHAR(15),
	CORREO VARCHAR(30),
	TIPO VARCHAR(1) NOT NULL, -- V. VENEZOLANO E. EXTRANJERO J. JURIDICO G. GUBERNAMENTAL
	CATEGORIA INT NOT NULL, -- 2. TRANSPORTISTA
	ESTATUS INT NOT NULL -- 0. NO DISPONIBLE 1. DISPONIBLE 99. ELIMINADO
);

/*
CREATE TABLE TRANSPORTISTAS (
	DOCUMENTO INT NOT NULL UNIQUE PRIMARY KEY,
	NOMBRE VARCHAR(100) NOT NULL,
	TELEFONO VARCHAR(15),
	CORREO VARCHAR(30),
	ESTATUS INT NOT NULL -- 0. NO DISPONIBLE 1. DISPONIBLE 99. ELIMINADO
);
*/

CREATE TABLE LICENCIAS(
    CODIGO SERIAL PRIMARY KEY NOT NULL,
    GRADO VARCHAR(20) NOT NULL,
	DETALLES VARCHAR(100) NOT NULL
);

CREATE TABLE TRANSPORTISTAS_LICENCIAS(
	ID SERIAL NOT NULL UNIQUE,
	TRANSPORTISTA INT NOT NULL,
	FOREIGN KEY (TRANSPORTISTA) REFERENCES PERSONAS(DOCUMENTO),
	LICENCIA INT NOT NULL,
	FOREIGN KEY (LICENCIA) REFERENCES LICENCIAS(CODIGO),
	CODIGO VARCHAR(20) NOT NULL,
	VENCIMIENTO DATE NOT NULL,
	ESTATUS INT NOT NULL, -- 0. VENCIDA 1. VIGENTE 99. ELIMINADO
	PRIMARY KEY (TRANSPORTISTA, LICENCIA)
);


-- TABLAS RELACIONADAS CON LA UNIDAD DE TRANSPORTE

CREATE TABLE PROPIETARIOS (
	DOCUMENTO INT NOT NULL UNIQUE PRIMARY KEY,
	NOMBRE VARCHAR(100) NOT NULL,
	TELEFONO VARCHAR(15),
	CORREO VARCHAR(30),
	TIPO_DOCUMENTO VARCHAR(1) NOT NULL, -- V. VENEZOLANO E. EXTRANJERO J. JURIDICO G. GUBERNAMENTAL
	ESTATUS INT NOT NULL -- 0. NO DISPONIBLE 1. DISPONIBLE 99. ELIMINADO
);

CREATE TABLE TIPO_UNIDAD(
	ID SERIAL PRIMARY KEY NOT NULL UNIQUE,
	NOMBRE VARCHAR(30) NOT NULL,
	DETALLES VARCHAR(100)
);

CREATE TABLE TIPO_CARGA(
	ID SERIAL PRIMARY KEY NOT NULL UNIQUE,
	NOMBRE VARCHAR(30) NOT NULL,
	MEDICION VARCHAR(10) NOT NULL,
	DETALLES VARCHAR(100)
);

CREATE TABLE LOCALIZADOR(
	CODIGO VARCHAR(30) PRIMARY KEY NOT NULL UNIQUE,
	URL VARCHAR(500) NOT NULL,
	DESCRIPCION VARCHAR(100)
);

CREATE TABLE UNIDADES(
	CODIGO SERIAL PRIMARY KEY UNIQUE NOT NULL,
	LOCALIZADOR VARCHAR(30) UNIQUE NOT NULL,
	TIPO_UNIDAD INT NOT NULL,
	PLACA VARCHAR(15) NOT NULL UNIQUE,
	MARCA VARCHAR(100) NOT NULL,
	MODELO VARCHAR(100) NOT NULL,
	ANIO VARCHAR(4) NOT NULL,
	COLOR VARCHAR(10) NOT NULL,
	PROPIETARIO INT NOT NULL,
	TIPO_CARGA INT NOT NULL,
	CAPACIDAD_CARGA INT NOT NULL,
	ESTATUS INT NOT NULL, -- 0. NO DISPONIBLE 1. DISPONIBLE 2. EN MANTENIMIENTO 99. ELIMINADO
	FOREIGN KEY (PROPIETARIO) REFERENCES PROPIETARIOS(DOCUMENTO),
	FOREIGN KEY (TIPO_UNIDAD) REFERENCES TIPO_UNIDAD(ID),
	FOREIGN KEY (TIPO_CARGA) REFERENCES TIPO_CARGA(ID),
	FOREIGN KEY (LOCALIZADOR) REFERENCES LOCALIZADOR(CODIGO)
);


-- TABLAS RELACIONADAS AL MANTENIMIENTO DE LAS UNIDADES

CREATE TABLE ENCARGADO_MANTENIMIENTO(
	ID SERIAL PRIMARY KEY NOT NULL UNIQUE,
	EMPRESA VARCHAR(30) NOT NULL,
	DIRECCION VARCHAR(200) NOT NULL,
	TELEFONO VARCHAR(15),
	ESTATUS INT NOT NULL -- 0. NO DISPONIBLE 1. DISPONIBLE
);

CREATE TABLE TIPO_MANTENIMIENTO(
	ID SERIAL PRIMARY KEY NOT NULL UNIQUE,
	NOMBRE VARCHAR(30) NOT NULL,
	DETALLES VARCHAR(100)
);

CREATE TABLE MANTENIMIENTO(
	CODIGO VARCHAR(30) PRIMARY KEY NOT NULL UNIQUE,
	FECHA DATE NOT NULL,
	TIPO_MANTENIMIENTO INT NOT NULL,
	ENCARGADO INT NOT NULL,
	UNIDAD INT NOT NULL,
	DESCRIPCION VARCHAR(100),
	ESTATUS INT NOT NULL, -- 0.FINALIZADO 1. EN CURSO
	FOREIGN KEY (UNIDAD) REFERENCES UNIDADES(CODIGO),
	FOREIGN KEY (TIPO_MANTENIMIENTO) REFERENCES TIPO_MANTENIMIENTO(ID),
	FOREIGN KEY (ENCARGADO) REFERENCES ENCARGADO_MANTENIMIENTO(ID)
);



-- TABLAS REALACIONADAS A LAS RUTAS DE SERVICIO

CREATE TABLE PUNTOS_CONTROL(
	ID SERIAL PRIMARY KEY UNIQUE NOT NULL,
	COORDENADAS_X VARCHAR(30) NOT NULL,
	COORDENADAS_Y VARCHAR(30) NOT NULL,
	DESCRIPCION VARCHAR(100)
);

CREATE TABLE RUTAS(
	ID SERIAL PRIMARY KEY UNIQUE NOT NULL,
	DESCRIPCION VARCHAR(100) NOT NULL,
	KILOMETROS INT NOT NULL
);

CREATE TABLE RUTA_CONTROL(
	PUNTO_CONTROL INT NOT NULL,
	RUTA INT NOT NULL,
	PRIMARY KEY (PUNTO_CONTROL, RUTA),
	FOREIGN KEY (PUNTO_CONTROL) REFERENCES PUNTOS_CONTROL(ID),
	FOREIGN KEY (RUTA) REFERENCES RUTAS(ID)
);


-- TABLAS COMPLEMENTO PARA EL CONTROL DE LAS GUIAS DE SERVICIO

CREATE TABLE CLIENTES (
	DOCUMENTO INT NOT NULL UNIQUE PRIMARY KEY,
	NOMBRE VARCHAR(100) NOT NULL,
	TELEFONO VARCHAR(15),
	CORREO VARCHAR(30),
	TIPO_DOCUMENTO VARCHAR(1) NOT NULL, -- V. VENEZOLANO E. EXTRANJERO J. JURIDICO G. GUBERNAMENTAL
	ESTATUS INT NOT NULL -- 0. NO DISPONIBLE 1. DISPONIBLE 99. ELIMINADO
);

CREATE TABLE SERVICIOS(
	ID SERIAL PRIMARY KEY UNIQUE NOT NULL,
	NOMBRE VARCHAR(30) NOT NULL,
	DESCRIPCION VARCHAR(100),
	MONTO_BASE INT NOT NULL
);

CREATE TABLE COSTES_OPERATIVOS(
	ID SERIAL PRIMARY KEY UNIQUE NOT NULL,
	NOMBRE VARCHAR(30) NOT NULL,
	DESCRIPCION VARCHAR(100)
);

-- TABLA DE GUIAS DE SERVICIO
CREATE TABLE GUIAS(
	CODIGO SERIAL PRIMARY KEY UNIQUE NOT NULL,
	CLIENTE INT NOT NULL,
	UNIDAD INT NOT NULL,
	TRANSPORTISTA INT NOT NULL,
	SERVICIO INT NOT NULL,
	RUTA INT NOT NULL,
	FECHA_SALIDA DATE NOT NULL,
	FECHHA_LLEGADA DATE NOT NULL,
	CARGA_TOTAL INT NOT NULL,
	DETALLES_CARGA VARCHAR(100) NOT NULL,
	OBSERVACIONES VARCHAR(100),
	ESTATUS INT NOT NULL, -- 0. FINALIZADA 1. EN CURSO 99. ELIMINADO
	FOREIGN KEY (SERVICIO) REFERENCES SERVICIOS(ID),
	FOREIGN KEY (CLIENTE) REFERENCES CLIENTES(DOCUMENTO),
	FOREIGN KEY (TRANSPORTISTA) REFERENCES /*TRANSPORTISTAS*/PERSONAS(DOCUMENTO),
	FOREIGN KEY (UNIDAD) REFERENCES UNIDADES(CODIGO),
	FOREIGN KEY (RUTA) REFERENCES RUTAS(ID)
);

CREATE TABLE GASTOS_GUIA(
	GASTO_OPERATIVO INT NOT NULL,
	GUIA_SERVICIO INT NOT NULL,
	MONTO INT NOT NULL,
	PRIMARY KEY (GASTO_OPERATIVO, GUIA_SERVICIO),
	FOREIGN KEY (GASTO_OPERATIVO) REFERENCES COSTES_OPERATIVOS(ID),
	FOREIGN KEY (GUIA_SERVICIO) REFERENCES GUIAS(CODIGO)
);

-- TABLA DE FACURACION DE LAS GUIAS DE SERVICIO
CREATE TABLE FACTURAS(
	ID_FISCAL SERIAL UNIQUE NOT NULL,
	ID_CONTROL VARCHAR(10) UNIQUE NOT NULL,
	GUIA_SERVICIO INT NOT NULL,
	ESTATUS INT NOT NULL, -- 0. ANULADA 1. VALIDADA
	PRIMARY KEY (ID_FISCAL, ID_CONTROL),
	FOREIGN KEY (GUIA_SERVICIO) REFERENCES GUIAS(CODIGO)
);







------------------------
------------------------
------------------------
------------------------
------------------------

-- CREACION DE LAS VISTAS PARA FACILITAR EL ENVIO DE LOS DATOS

------------------------
------------------------
------------------------
------------------------
------------------------




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



CREATE VIEW "DETALLES GUIAS" AS
	SELECT CODIGO AS "CODIGO",
		(SELECT DOCUMENTO AS "DOCUMENTO CLIENTE" FROM CLIENTES AS C WHERE C.DOCUMENTO = G.CLIENTE),
		(SELECT NOMBRE AS "NOMBRE CLIENTE" FROM CLIENTES AS C WHERE C.DOCUMENTO = G.CLIENTE),
		(SELECT PLACA AS "PLACA UNIDAD" FROM UNIDADES AS U WHERE U.CODIGO = G.UNIDAD),
		(SELECT MODELO AS "MODELO UNIDAD" FROM UNIDADES AS U WHERE U.CODIGO = G.UNIDAD),
		(SELECT LOCALIZADOR AS "LOCALIZADOR UNIDAD" FROM UNIDADES AS U WHERE U.CODIGO = G.UNIDAD),
		(SELECT DOCUMENTO AS "DOCUMENTO TRANSPORTISTA" FROM PERSONAS AS P WHERE P.DOCUMENTO = G.TRANSPORTISTA),
		(SELECT NOMBRE AS "NOMBRE TRANSPORTISTA" FROM PERSONAS AS P WHERE P.DOCUMENTO = G.TRANSPORTISTA),
		(SELECT ID AS "RUTA" FROM RUTAS AS R WHERE R.ID = G.RUTA),
		(SELECT (SELECT DESCRIPCION AS "PUNTO INICIO" FROM PUNTOS_CONTROL AS PC WHERE PC.ID = RC.PUNTO_CONTROL)
			FROM RUTA_CONTROL AS RC WHERE RC.RUTA = G.RUTA ORDER BY PUNTO_CONTROL ASC LIMIT 1),
		(SELECT (SELECT DESCRIPCION AS "PUNTO FINAL" FROM PUNTOS_CONTROL AS PC WHERE PC.ID = RC.PUNTO_CONTROL)
			FROM RUTA_CONTROL AS RC WHERE RC.RUTA = G.RUTA ORDER BY PUNTO_CONTROL DESC LIMIT 1),
		CARGA_TOTAL AS "TOTAL DE CARGA",
		DETALLES_CARGA AS "DETALLES DE CARGA",
		OBSERVACIONES AS "OBSERVACIONES DE GUIA",
		ESTATUS
	FROM GUIAS AS G;








































