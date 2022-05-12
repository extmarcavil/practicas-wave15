-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select emp.nombre, emp.apellido, dpto.localidad from empleado emp inner join departamento dpto on emp.depto_nro= dpto.depto_nro; 

-- Visualizar los departamentos con más de cinco empleados. - Nota: Puse 3 para que tuviera algun dato
select  dpto.* from departamento dpto inner join empleado emp on emp.depto_nro=dpto.depto_nro group by dpto.depto_nro having count(dpto.depto_nro) >=3;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select emp.nombre, emp.apellido, emp.salario, dpto.nombre_depto from empleado emp inner join departamento dpto on emp.depto_nro=dpto.depto_nro where emp.puesto in (select m.puesto from empleado m where nombre like 'Mito' AND apellido like 'Barchuk');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select emp.* from empleado emp inner join departamento dpto on emp.depto_nro=dpto.depto_nro where dpto.nombre_depto like 'Contabilidad' order by emp.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select e1.nombre from empleado e1 where e1.salario in (select MIN(e2.salario) from empleado e2);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select emp.* from empleado emp inner join departamento dpto on emp.depto_nro=dpto.depto_nro where dpto.nombre_depto='Ventas' and emp.salario in (select MAX(e2.salario) from empleado e2 inner join departamento d2 on d2.depto_nro=e2.depto_nro where d2.nombre_depto='Ventas');