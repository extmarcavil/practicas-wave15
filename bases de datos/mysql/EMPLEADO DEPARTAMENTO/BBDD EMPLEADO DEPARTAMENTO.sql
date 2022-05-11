-- creando la base de datos

CREATE DATABASE empresa_db;
use empresa_db;
CREATE TABLE Departamento (
  depto_nro varchar(45) NOT NULL,
  nombre_depto varchar(45) DEFAULT NULL,
  localidad varchar(45) DEFAULT NULL,
  PRIMARY KEY (depto_nro)
);

CREATE TABLE Empleado (
  cod_emp varchar(45) NOT NULL,
  nombre varchar(45) DEFAULT NULL,
  apellido varchar(45) DEFAULT NULL,
  puesto varchar(45) DEFAULT NULL,
  fecha_alta datetime DEFAULT NULL,
  salario decimal(13,2) DEFAULT NULL,
  comision decimal(13,2) DEFAULT NULL,
  nro_depto varchar(45) DEFAULT NULL,
  PRIMARY KEY (cod_emp),
  KEY depto_nro_idx (nro_depto),
  CONSTRAINT nro_depto FOREIGN KEY (nro_depto) REFERENCES departamento (depto_nro)
);

insert into departamento value('D-000-1','Software','Los Tigres');
insert into departamento value('D-000-2','Sistemas','Guadalupe');
insert into departamento value('D-000-3','Contabilidad','La Roca');
insert into departamento value('D-000-4','Ventas','Plata');

insert into empleado value('E-0001','César','Piñero','Vendedor','2018-05-12 00:00:00','80000.00','15000.00','D-000-4');
insert into empleado value('E-0002','Yosep','Kowaleski','Analista','2015-07-14 00:00:00','140000.00','0.00','D-000-2');
insert into empleado value('E-0003','Mariela','Barrios','Director','2014-06-05 00:00:00','185000.00','0.00','D-000-3');
insert into empleado value('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03 00:00:00','85000.00','10000.00','D-000-4');
insert into empleado value('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03 00:00:00','83000.00','10000.00','D-000-4');
insert into empleado value('E-0006','Mito','Barchuk','Presidente','2014-06-05 00:00:00','190000.00','0.00','D-000-3');
insert into empleado value('E-0007','Emilio','Galarza','Desarrollador','2014-08-02 00:00:00','60000.00','0.00','D-000-1');



