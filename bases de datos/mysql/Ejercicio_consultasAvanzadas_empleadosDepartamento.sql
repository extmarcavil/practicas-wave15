CREATE DATABASE empresa_db;
USE empresa_db;
CREATE TABLE `departamento` (
  `depto_nro` varchar(45) NOT NULL,
  `nombre_depto` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `empleado` (
  `cod_emp` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `puesto` varchar(45) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `salario` decimal(13,2) DEFAULT NULL,
  `comision` decimal(13,2) DEFAULT NULL,
  `depto_nro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `depto_nro_idx` (`depto_nro`),
  CONSTRAINT `depto_nro` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO departamento VALUES ( 'D-000-1','Software','Los Tigres');
INSERT INTO departamento VALUES ( 'D-000-2','Sistemas','Guadalupe');
INSERT INTO departamento VALUES ( 'D-000-3','Contabilidad','La Roca');
INSERT INTO departamento VALUES ( 'D-000-4','Ventas','Plata');
INSERT INTO empleado VALUES ( "E-0001","César","Piñero","Vendedor","2018-05-12",80000,15000,"D-000-4");
INSERT INTO empleado VALUES ( "E-0002","Yosep","Kowaleski","Analista","2015-07-14",140000,0,"D-000-2");
INSERT INTO empleado VALUES ( "E-0003","Mariela","Barrios","Director","2014-06-05",185000,0,"D-000-3");
INSERT INTO empleado VALUES ( "E-0004","Jonathan","Aguilera","Vendedor","2015-06-03",85000,10000,"D-000-4");
INSERT INTO empleado VALUES ( "E-0005","Daniel","Brezezicki","Vendedor","2018-03-03",83000,10000,"D-000-4");
INSERT INTO empleado VALUES ( "E-0006","Mito","Barchuk","Presidente","2014-06-05",190000,0,"D-000-3");
INSERT INTO empleado VALUES ( "E-0007","Emilio","Galarza","Desarrollador","2014-08-02",60000,0,"D-000-1");

-- Ejercicio 1
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro;

-- Ejercicio 2
SELECT nombre_depto
FROM departamento JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY nombre_depto
HAVING COUNT(*) >= 5;

-- Ejercicio 3
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (
	SELECT puesto FROM empleado
    WHERE nombre = "MITO" AND apellido = "BARCHUK");
    
-- Ejercicio 4
SELECT e.* FROM empleado e
	JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.depto_nro = (
	SELECT depto_nro FROM departamento
    WHERE nombre_depto = "contabilidad")
ORDER BY e.nombre;

-- Ejercicio 5
SELECT nombre FROM empleado
ORDER BY salario ASC
LIMIT 1;

SELECT nombre FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

-- Ejercicio 6
SELECT * FROM empleado
WHERE salario = (
	SELECT MAX(salario) FROM empleado
    WHERE depto_nro = (
		SELECT depto_nro FROM departamento
        WHERE nombre_depto = "Ventas"));