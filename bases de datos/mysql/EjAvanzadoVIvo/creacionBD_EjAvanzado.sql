DROP DATABASE IF EXISTS empresa_db;
CREATE DATABASE empresa_db;
USE empresa_db;


DROP TABLE IF EXISTS `departamento`;
  CREATE TABLE `departamento` (
  `depto_nro` varchar(60) NOT NULL,
  `nombre_depto` varchar(60) NULL DEFAULT NULL,
  `localidad` varchar(60) NULL DEFAULT NULL,
  PRIMARY KEY (`depto_nro`));

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `cod_emp` varchar(60)  NOT NULL,
  `nombre` varchar(60) NULL DEFAULT NULL,
  `apellido` varchar(60) NULL DEFAULT NULL,
  `puesto` varchar(60) NULL DEFAULT NULL,
  `fecha_alta` timestamp NULL DEFAULT NULL,
  `salario` int NULL DEFAULT NULL,
  `comision` int NULL DEFAULT NULL,
  `depto_nro` varchar(60) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_emp`),
  FOREIGN KEY (`depto_nro`) REFERENCES departamento(`depto_nro`));
  
  
  insert into departamento (  `depto_nro` ,`nombre_depto`,`localidad`) values ("D-000-1","Software", "Los Tigres");
  insert into departamento (  `depto_nro` ,`nombre_depto`,`localidad`) values ("D-000-2","Sistemas", "Guadalupe");
  insert into departamento (  `depto_nro` ,`nombre_depto`,`localidad`) values ("D-000-3","Contabilidad", "La Roca");
  insert into departamento (  `depto_nro` ,`nombre_depto`,`localidad`) values ("D-000-4","Ventas", "Plata");
  
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0001", "Cesar", "Pinero", "Vendedor", '2018-05-12',80000,15000,"D-000-4");
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0002", "Yosep", "Kowaleski", "Analista", '2015-07-14',140000,0,"D-000-2");
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0003", "Mariela", "Barrios", "Director", '2014-06-05',185000,0,"D-000-3");
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0004", "Jonathan", "Aguilera", "Vendedor", '2015-06-03',85000,10000,"D-000-4");
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0005", "Daniel", "Brezezicki", "Vendedor", '2018-03-03',83000,10000,"D-000-4");
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0006", "Mito", "Barchuk", "Presidente", '2014-06-05',190000,0,"D-000-3");
  
  insert into empleado (`cod_emp` ,`nombre` ,`apellido`,`puesto`,`fecha_alta`,`salario`,`comision`,`depto_nro`)
  values ( "E-0007", "Emilio", "Galarza", "Desarrollador", '2014-08-02',60000,0,"D-000-1");