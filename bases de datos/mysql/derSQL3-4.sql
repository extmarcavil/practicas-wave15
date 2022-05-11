DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int  NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NULL DEFAULT NULL,
  `apellido` varchar(60) NULL DEFAULT NULL,
  `fechaNacimiento` timestamp NULL DEFAULT NULL,
  `provincia` varchar(60) NULL DEFAULT NULL,
  `ciudad` varchar(60) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`));
  
  
DROP TABLE IF EXISTS `plan`;
  CREATE TABLE `plan` (
  `idPlan` int NOT NULL AUTO_INCREMENT,
  `velocidad` varchar(60) NULL DEFAULT NULL,
  `precio` varchar(60) NULL DEFAULT NULL,
  PRIMARY KEY (`idPlan`));

DROP TABLE IF EXISTS `planContrato`;
  CREATE TABLE `planContrato` (
  `idPlanContrato` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idPlan` int NOT NULL,
  PRIMARY KEY (`idPlanContrato`),
  FOREIGN KEY (`idCliente`) REFERENCES cliente(`idCliente`),
  FOREIGN KEY (`idPlan`) REFERENCES plan(`idPlan`)
  );
  
  
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Pepe", "Grillo", '2000-01-03', "Provincia","Ciudad");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Juan", "Grillo", '2000-01-03', "OtraProv","Ciudad");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Jose", "Perez", '1989-01-03', "Depto","OtraCiu");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Jose", "Gutierrez", '2020-01-03', "CarlosPaz","Montevideo");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Luis", "Luca", '1990-11-03', "Otromas","Artigas");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Carlos", "Bueno", '1970-01-03', "Colonia","Colonia");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Moises", "Moises", '1972-01-03', "Juan Lacaze","Colonia");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Carlos", "Tevez", '2010-01-03', "Minas","Lavalleja");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Natalia", "Oreiro", '2000-01-03', "Provincia","Ciudad");
  insert into cliente (`nombre`,`apellido`,`fechaNacimiento` ,`provincia`,`ciudad`) values("Natalia", "Lafourcade", '2020-01-03', "Salto","Salto");

  insert into plan (`velocidad`,`precio`) values ("10 mbps", "$500");
  insert into plan (`velocidad`,`precio`) values ("100 mbps", "$5000");
  insert into plan (`velocidad`,`precio`) values ("1000 mbps", "$8000");
  insert into plan (`velocidad`,`precio`) values ("50 mbps", "$3000");
  insert into plan (`velocidad`,`precio`) values ("500 mbps", "$7000");
  
  insert into planContrato(`idCliente`,`idPlan`) values (1,1);
  insert into planContrato(`idCliente`,`idPlan`) values (1,4);
  insert into planContrato(`idCliente`,`idPlan`) values (2,2);
  insert into planContrato(`idCliente`,`idPlan`) values (3,3);
  insert into planContrato(`idCliente`,`idPlan`) values (4,4);
  insert into planContrato(`idCliente`,`idPlan`) values (5,5);
  insert into planContrato(`idCliente`,`idPlan`) values (6,1);
  insert into planContrato(`idCliente`,`idPlan`) values (7,2);
  insert into planContrato(`idCliente`,`idPlan`) values (8,4);
  insert into planContrato(`idCliente`,`idPlan`) values (9,3);
  

-- Apellidos que tengan er en el mismo
select * from cliente where apellido like '%er%';
-- Planes con precio entre 100 y 1000
select * from plan where precio like '%00';
-- Clientes nacidos entre 1970 y 1999
select nombre,apellido from cliente where fechaNacimiento between '1970-01-01' and '2000-01-01';
-- clientes que hayan contratado el plan 1
select cli.nombre, cli.apellido from cliente cli where exists (select * from planContrato where idCliente = cli.idCliente);
-- cuantos clientes contrataron el plan 2
select count(*) from planContrato where idPlan=2;