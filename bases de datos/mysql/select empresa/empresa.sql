drop table if exists empleado,departamento;

CREATE TABLE departamento
(
depto_nro VARCHAR(10) NOT NULL PRIMARY KEY,
nombre_depto VARCHAR(50) NOT NULL,
localidad VARCHAR(50) NOT NULL
);


CREATE TABLE empleado(
	cod_emp VARCHAR (10) NOT NULL,
nombre VARCHAR (10),
apellido VARCHAR (15),
puesto VARCHAR (15),
fecha_alta DATE,
salario INT UNSIGNED ,
comision INT UNSIGNED,
depto_nro VARCHAR (10),
PRIMARY KEY (cod_emp),
FOREIGN KEY (depto_nro) References departamento(depto_nro)
);


#Carga de datos de departamento
insert into departamento values ('D-000-1', 'Software', 'Los Tigres');
insert into departamento values ('D-000-2', 'Sistemas', 'Guadalupe');
insert into departamento values ('D-000-3', 'Contabilidad', 'La Roca');
insert into departamento values ('D-000-4', 'Ventas', 'Plata');

select * from departamento;

#carga de datos empleado

INSERT INTO empleado VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000,15000,'D-000-4');
INSERT INTO empleado VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000,0,'D-000-2');
INSERT INTO empleado VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');
insert into empleado  values ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');
insert into empleado  values ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');
insert into empleado  values ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');
insert into empleado  values ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

select * from empleado;

#consultas sql
# 1 - Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
select e.nombre, e.puesto, d.localidad from empleado e join departamento d ON d.depto_nro = e.depto_nro;

# 2 - Visualizar los departamentos con más de cinco empleados.
select d.nombre_depto,count(1) 'cantidad de empleados' 
from empleado
inner join departamento d on empleado.depto_nro = d.depto_nro
group by d.nombre_depto
having count(1)>=5;

# 3 - Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select empleado.nombre, empleado.salario, departamento.nombre_depto  from empleado INNER JOIN departamento on empleado.depto_nro = departamento.depto_nro where puesto =(
select puesto from empleado where nombre='Mito' and apellido='Barchuk');

# 4 - Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* FROM empleado e INNER JOIN departamento d ON e.depto_nro = d.depto_nro WHERE d.nombre_depto LIKE '%Contabilidad%' ORDER BY e.nombre ASC;

# 5 - Mostrar el nombre del empleado que tiene el salario más bajo.
select concat(nombre,' ',apellido) empleado from empleado where salario = (select min(salario) from empleado);
select concat(nombre,' ',apellido) empleado from empleado order by salario limit 1;

# 6 - Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from empleado e
where salario = (
    select max(salario)
    from empleado e
    inner join departamento d on d.depto_nro = e.depto_nro
    where d.nombre_depto='Ventas');

SELECT e.*
FROM empleado e
INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1;


