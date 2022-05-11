create database empresa;

create table departamento(
depto_nro varchar(7) primary key,
nombre_depto varchar(50),
localidad varchar(40)
);

create table empleado(
cood_emp varchar(6) primary key,
nombre varchar(30),
apellido varchar(30),
puesto varchar(50),
fecha_alta date,
salario numeric,
comision numeric,
depto_nro varchar(7),
foreign key (depto_nro) references departamento(depto_nro)
);


INSERT INTO departamento VALUES
('D-000-1','Software','Los Tigres'),
('D-000-2','Sistemas','Guadalupe'),
('D-000-3','Contabilidad','La Roca'),
('D-000-4','Ventas','Plata');


INSERT INTO empleado values
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


SELECT em.nombre, dp.nombre_depto, em.puesto, dp.localidad FROM empleado as em 
INNER JOIN departamento as dp on em.depto_nro=dp.depto_nro;

SELECT COUNT(*), dp.* FROM departamento as dp
INNER JOIN empleado as em on em.depto_nro=dp.depto_nro
GROUP BY dp.depto_nro
HAVING COUNT(*)>5;

SELECT em.nombre, em.salario, dp.nombre_depto FROM empleado as em
INNER JOIN departamento as dp on em.depto_nro=dp.depto_nro
WHERE em.puesto = (
SELECT emf.puesto from empleado as emf 
WHERE emf.nombre = 'Mito' AND emf.apellido='Barchuk'
);

SELECT em.* FROM empleado as em 
INNER JOIN departamento as dp on em.depto_nro=dp.depto_nro
WHERE dp.nombre_depto='Contabilidad'
ORDER BY nombre, apellido;

SELECT em.* FROM empleado as em 
where em.salario = (SELECT MIN(salario) FROM empleado);

SELECT em.* FROM empleado as em 
INNER JOIN departamento as dp on em.depto_nro=dp.depto_nro
WHERE em.salario = (
SELECT MAX(salario) FROM empleado emf
INNER JOIN departamento as dpf on emf.depto_nro=dpf.depto_nro
WHERE dpf.nombre_depto='Ventas'
) AND dp.nombre_depto='Ventas';

