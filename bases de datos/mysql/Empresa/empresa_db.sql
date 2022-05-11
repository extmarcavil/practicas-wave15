-- Crear tabla Departamento
CREATE TABLE `Departamento` (
	depto_nro VARCHAR(40) NOT NULL PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

-- Crear tabla Empleado
CREATE TABLE `Empleado` (
	cod_emp VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    puesto VARCHAR(40) NOT NULL,
    fecha_alta DATE NOT NULL DEFAULT (DATE_FORMAT(NOW(), '%d/%m/%Y')),
    salario FLOAT NOT NULL,
    comision FLOAT DEFAULT 0,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES Departamento(depto_nro)
);

-- Insertar datos tabla Departamento
INSERT INTO 
	empresa_db.Departamento (depto_nro, nombre_depto, localidad) 
VALUES	('D-000-1', 'Software', 'Los Tigres'),
		('D-000-2', 'Sistemas', 'Guadalupe'),
		('D-000-3', 'Contabilidad', 'La Roca'),
		('D-000-4', 'Ventas', 'Plata');
        
-- Insertar datos tabla Empleado
INSERT INTO 
	empresa_db.Empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) 
VALUES	('E-0001', 'César', 'Piñero', 'Vendedor', STR_TO_DATE('12/05/2018', '%d/%m/%Y'), 80000, 15000, 'D-000-4'),
		('E-0002', 'Yosep', 'Kowaleski', 'Analista', STR_TO_DATE('14/07/2015', '%d/%m/%Y'), 140000, 0, 'D-000-2'),
        ('E-0003', 'Mariela', 'Barrios', 'Director', STR_TO_DATE('05/06/2014', '%d/%m/%Y'), 185000, 0, 'D-000-3'),
        ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', STR_TO_DATE('03/06/2015', '%d/%m/%Y'),85000, 10000, 'D-000-4'),
        ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', STR_TO_DATE('03/03/2018', '%d/%m/%Y'), 83000, 10000, 'D-000-4'),
        ('E-0006', 'Mito', 'Barchuk', 'Presidente', STR_TO_DATE('05/06/2014', '%d/%m/%Y'), 190000, 0, 'D-000-3'),
        ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', STR_TO_DATE('02/08/2014', '%d/%m/%Y'), 60000, 0, 'D-000-1');