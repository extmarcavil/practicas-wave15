#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
select e.nombre, e.puesto, d.localidad
from empleado e
join departamento d on d.depto_nro = e.depto_nro;

#Visualizar los departamentos con mas de 3 empleados
select d.nombre_depto
from empleado e
join departamento d on d.depto_nro = e.depto_nro
group by e.depto_nro, d.nombre_depto
having count(e.depto_nro) >=3;

#Mostrar el nombre, salario y nombre del depto de los empleados que tengan el mismo puesto que "mito Barchuk"
select e.nombre, e.salario, d. nombre_depto
from empleado e
join departamento d on d.depto_nro = e.depto_nro
where (select puesto from empleado where nombre = "Mito" and apellido = "Barchuk") = e.puesto;

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre
select e.* 
from empleado e
join departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'contabilidad'
order by e.nombre;

#Mostrar el nombre del empleado que tiene el salario mas bajo
select nombre, salario
from empleado
order by salario asc
limit 1;

#Mostrar los datos del empleado que tiene el salario mas alto en el departamento de ventas
select e.*
from empleado e
join departamento d on d.depto_nro = e.depto_nro
where nombre_depto = 'ventas'
order by e.salario desc
limit 1