CREATE DATABASE empresa_db;
USE empresa_db;

CREATE TABLE `departamento` (
  `depto_nro` varchar(45) NOT NULL,
  `nombre_depto` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
​
CREATE TABLE `empleado` (
  `cod_emp` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `puesto` varchar(45) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `salario` decimal(13,2) DEFAULT NULL,
  `comision` decimal(13,2) DEFAULT NULL,
  `nro_depto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `depto_nro_idx` (`nro_depto`),
  CONSTRAINT `nro_depto` FOREIGN KEY (`nro_depto`) REFERENCES `departamento` (`depto_nro`)
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


-- 1) Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select em.nombre, em.apellido, em.puesto, de.localidad 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro;
​
-- 2) Visualizar los departamentos con más de cinco empleados.
select de.nombre_depto,
       count(em.nro_depto) as cant_empleados
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
group by de.nombre_depto
having cant_empleados > 5;
​
-- 3) Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.apellido, em.salario, de.nombre_depto 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
where em.puesto = (select em1.puesto from empleado as em1 where em1.nombre = 'Mito' and em1.apellido = 'Barchuk');   
​
-- 4) Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select em.* 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
where em.nro_depto = 'D-000-3'   
order by em.nombre; 
   
-- 5) Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre
from empleado
order by salario asc
limit 1;
​
-- 6) Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select em.* 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
where em.nro_depto = 'D-000-4'   
order by em.salario desc
limit 1; 
      











