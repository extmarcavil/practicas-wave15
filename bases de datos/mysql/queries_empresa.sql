-- Crear tabla departamento
CREATE TABLE `empresa_db`.`departamento` (
  `depto_nro` VARCHAR(8) NOT NULL,
  `nombre_depto` VARCHAR(45) NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`depto_nro`));


-- Crear tabla empleado
CREATE TABLE `empresa_db`.`empleado` (
  `cod_emp` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  `fecha_alta` DATETIME NOT NULL,
  `salario` INT NOT NULL,
  `comision` INT NOT NULL,
  `depto_nro` VARCHAR(10) NULL,
  PRIMARY KEY (`cod_emp`),
  FOREIGN KEY (`depto_nro`) REFERENCES `empresa_db`.`departamento` (`depto_nro`));
  
-- Crear datos en departamento
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-1', 'Software', 'Los Tigres');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-3', 'Contabilidad', 'La Roca');
INSERT INTO `empresa_db`.`departamento` (`depto_nro`, `nombre_depto`, `localidad`) VALUES ('D-000-4', 'Ventas', 'Plata');

-- Crear datos en empleado
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', '80000', '15000', 'D-000-4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', '140000', '0', 'D-000-2');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', '185000', '0', 'D-000-3');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', '85000', '10000', 'D-000-4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', '83000', '10000', 'D-000-4');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', '190000', '0', 'D-000-3');
INSERT INTO `empresa_db`.`empleado` (`cod_emp`, `nombre`, `apellido`, `puesto`, `fecha_alta`, `salario`, `comision`, `depto_nro`) VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', '60000', '0', 'D-000-1');

-- CONSULTAS
-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad 
FROM empleado 
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(e.depto_nro) cantidad 
FROM departamento d 
INNER JOIN empleado e ON d.depto_nro = e.depto_nro 
GROUP BY e.depto_nro 
HAVING cantidad>5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT nombre, salario, nombre_depto 
FROM empleado 
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro 
WHERE empleado.puesto = 'Presidente';

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.cod_emp, e.nombre, e.apellido,e.puesto, e.fecha_alta,e.salario,e.comision, d.nombre_depto 
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto= 'Contabilidad' 
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, min(e.salario) 
FROM empleado e;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.cod_emp, e.nombre, e.apellido,e.puesto, e.fecha_alta,e.salario,e.comision, max(e.salario) 
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto= 'Ventas';



