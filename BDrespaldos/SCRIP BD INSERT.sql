-- INSERTAMOS DATOS DENTRO DE LA TABLA LICENCIAS
INSERT INTO LICENCIAS (GRADO, DETALLES) VALUES
	('PRIMER GRADO', 'VEHICULOS DE TRACCION HUMANA O ANIMAL'),
	('SEGUNDO GRADO', 'MOTOCICLETAS'),
	('TERCER GRADO', 'AUTOMOVIL, HASTA 9 PUESTOS O 2,5 TN DE MERCANCIA'),
	('CUARTO GRADO', 'TRANSPORTE, HASTA 12 PUESTOS O 6 TN DE MERCANCIA'),
	('QUINTO GRADO', 'TRANSPORTE, HASTA 33 PUESTOS O 9 TN DE MERCANCIA'),
	('T.S.P', 'TRANSPORTE, SUPERIOR A 33 PUESTOS O 9 TN DE MERCANCIA');

-- Insertar 15 personas en la tabla PERSONAS
INSERT INTO PERSONAS (DOCUMENTO, NOMBRE, TELEFONO, CORREO, TIPO, CATEGORIA, ESTATUS)
VALUES
-- Transportistas (Venezolanos)
('80000001', 'Transportista 1', '04141234567', 'trans1@example.com', 'V', 2, 1),
('80000002', 'Transportista 2', '04141234568', 'trans2@example.com', 'V', 2, 1),
('80000003', 'Transportista 3', '04141234569', 'trans3@example.com', 'V', 2, 1),
('80000004', 'Transportista 4', '04141234570', 'trans4@example.com', 'V', 2, 1),
('80000005', 'Transportista 5', '04141234571', 'trans5@example.com', 'V', 2, 1),

-- Clientes (Variados)
('90000001', 'Cliente 1', '04141234572', 'cliente1@example.com', 'E', 1, 1),
('90000002', 'Cliente 2', '04141234573', 'cliente2@example.com', 'J', 1, 1),
('90000003', 'Cliente 3', '04141234574', 'cliente3@example.com', 'G', 1, 1),
('90000004', 'Cliente 4', '04141234575', 'cliente4@example.com', 'E', 1, 1),
('90000005', 'Cliente 5', '04141234576', 'cliente5@example.com', 'J', 1, 1),

-- Propietarios (Variados)
('10000001', 'Propietario 1', '04141234577', 'prop1@example.com', 'G', 3, 1),
('10000002', 'Propietario 2', '04141234578', 'prop2@example.com', 'E', 3, 1),
('10000003', 'Propietario 3', '04141234579', 'prop3@example.com', 'J', 3, 1),
('10000004', 'Propietario 4', '04141234580', 'prop4@example.com', 'V', 3, 1),
('10000005', 'Propietario 5', '04141234581', 'prop5@example.com', 'E', 3, 1);

-- Insertar transportistas y sus licencias asociadas en la tabla TRANSPORTISTAS_LICENCIAS basando en el DOCUMENTO
INSERT INTO TRANSPORTISTAS_LICENCIAS (TRANSPORTISTA, LICENCIA, CODIGO, VENCIMIENTO, ESTATUS)
VALUES
('80000001', 2, '2', '2024-12-31', 1),
('80000001', 3, '3', '2024-12-31', 1),
('80000001', 4, '4', '2024-12-31', 1),
('80000002', 2, '2', '2024-12-31', 1),
('80000002', 4, '4', '2024-12-31', 1),
('80000002', 5, '5', '2024-12-31', 1),
('80000003', 2, '2', '2024-12-31', 1),
('80000003', 5, '5', '2024-12-31', 1),
('80000003', 6, '6', '2024-12-31', 1),
('80000004', 2, '2', '2024-12-31', 1),
('80000004', 3, '3', '2024-12-31', 1),
('80000004', 5, '5', '2024-12-31', 1),
('80000005', 2, '2', '2024-12-31', 1),
('80000005', 4, '4', '2024-12-31', 1),
('80000005', 6, '6', '2024-12-31', 1);



