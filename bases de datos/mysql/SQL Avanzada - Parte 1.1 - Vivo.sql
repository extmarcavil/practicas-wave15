use empresa_db;

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad
from empleado e
join departamento d on d.depto_nro = e.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select d.depto_nro
from Empleado e
join Departamento d on e.depto_nro = d.depto_nro
group by d.depto_nro
having count(*) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto
from Empleado e
join Departamento d on d.depto_nro = e.depto_nro
where e.puesto = (select puesto from empleado where nombre = 'Mito' and apellido = 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.*
from Empleado e
join Departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Contabilidad'
order by e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select e.nombre
from Empleado e
order by e.salario
limit 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select e.*
from Empleado e
join Departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Ventas'
order by salario desc
limit 1;
