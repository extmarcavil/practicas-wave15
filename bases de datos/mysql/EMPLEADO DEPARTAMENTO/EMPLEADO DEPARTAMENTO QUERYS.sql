use empresa_db;

-- 1) Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select em.nombre, em.apellido, em.puesto, de.localidad 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro;
   
-- 2) Visualizar los departamentos con más de cinco empleados.
select de.nombre_depto,
       count(em.nro_depto) as cant_empleados
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
group by de.nombre_depto
having cant_empleados > 5;

-- 3) Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.apellido, em.salario, de.nombre_depto 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
where em.puesto = (select em1.puesto from empleado as em1 where em1.nombre = 'Mito' and em1.apellido = 'Barchuk');   

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

-- 6) Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select em.* 
from empleado as em
inner join departamento as de
   on em.nro_depto = de.depto_nro
where em.nro_depto = 'D-000-4'   
order by em.salario desc
limit 1; 
