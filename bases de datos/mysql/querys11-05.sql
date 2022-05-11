/*


Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
Visualizar los departamentos con más de cinco empleados.
Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
Mostrar el nombre del empleado que tiene el salario más bajo.
Mostrar los datos del empleado que tiene el salario más alto del departamento de ventas


*/

-- 01)

use bootcamp_empresa;

select e.nombre, e.puesto, d.localidad from empleado e 
inner join departamento d on e.dpto_id = d.id;

-- 02) 

select d.nombre_dpto, count(e.dpto_id) cuenta from empleado e inner join departamento d on d.id = e.dpto_id
group by e.dpto_id
having cuenta > 2; -- se uso 2 para ver el resultado

-- 03)

select e.*, d.nombre_dpto from empleado e
left join departamento d on e.dpto_id = d.id
where e.puesto = (select puesto from empleado where nombre = "Mito" and apellido = "Barchuk");

-- 04)

select * from empleado as e 
where e.dpto_id = (select id from departamento as d where d.nombre_dpto = "Contabilidad")
order by e.nombre;

-- 05) 

select nombre from empleado
order by salario asc
limit 1;

-- 06) 

select nombre from empleado
where dpto_id = (select id from departamento where nombre_dpto = "Ventas")
order by salario desc
limit 1;