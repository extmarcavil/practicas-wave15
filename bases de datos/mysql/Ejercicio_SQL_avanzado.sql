create database EJERCICIO;

create table DEPARTAMENTO;
create table EMPLEADO;

CREATE TABLE DEPARTAMENTO (
  depto_nro varchar(20) NOT NULL,
  nombre_depto varchar(45) NOT NULL,
  localidad varchar(45) NOT NULL,
  PRIMARY KEY (depto_nro)
);

insert into DEPARTAMENTO (depto_nro, nombre_depto, localidad) values
('D-000-1', 'Software', 'Los Tigres'), 
('D-000-2', 'Sistemas', 'Guadalupe'), 
('D-000-3', 'Contabilidad', 'La Roca'), 
('D-000-4', 'Ventas', 'Plata');

CREATE TABLE Empleado (
  cod_emp varchar(20) NOT NULL,
  nombre varchar(45) NOT NULL,
  apellido varchar(45) NOT NULL,
  puesto varchar(45) NOT NULL,
  fecha_alta varchar(45) NOT NULL,
  salario varchar(45) NOT NULL,
  comision varchar(45) NOT NULL,
  depto_nro varchar(45) NOT NULL,
  PRIMARY KEY (cod_emp)
);

INSERT INTO EMPLEADO VALUES 
( 'E-0001','César','Piñero','Vendedor','2018-05-12',80000,15000,'D-000-4'),
( 'E-0002','Yosep','Kowaleski','Analista','2015-07-14',140000,0,'D-000-2'),
( 'E-0003','Mariela','Barrios','Director','2014-06-05',185000,0,'D-000-3'),
( 'E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,'D-000-4'),
( 'E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',83000,10000,'D-000-4'),
( 'E-0006','Mito','Barchuk','Presidente','2014-06-06',190000,0,'D-000-3'),
( 'E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000,0,'D-000-1');

/*. punto 1 
Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/
select e.nombre, e.puesto, d.localidad 
from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro
where e.puesto = 'Vendedor';


/*. punto 2
Visualizar los departamentos con más de cinco empleados.*/
select  count(*) as empleados , d.nombre_depto
from DEPARTAMENTO d join EMPLEADO e on e.depto_nro = d.depto_nro
group by e.depto_nro, d.nombre_depto
having empleados > 5;

/*. punto 3 
Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.*/

select e.nombre, e.salario, d.nombre_depto
from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro
where puesto = (select puesto from EMPLEADO where nombre = 'Mito' and apellido = 'Barchuk');

/*. punto 4
Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.*/

select *
from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'contabilidad'
order by e.nombre;

/*. punto 5
Mostrar el nombre del empleado que tiene el salario más bajo.*/

select e.nombre
from EMPLEADO e
order by salario limit 1;

/*. punto 6
Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.*/
select *
from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro
where d.nombre_depto = 'Ventas'
order by salario desc limit 1;


