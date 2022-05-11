# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select emp.nombre, emp.puesto, dto.localidad from empresa_db.departamento dto inner join empresa_db.empleado emp on dto.depto_nro = emp.depto_nro;
#Visualizar los departamentos con más de cinco empleados.
select d.depto_nro,count(*) from empresa_db.empleado e inner join empresa_db.Departamento d on e.depto_nro=d.depto_nro
group by d.depto_nro having count(*)>5;
#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto from empresa_db.empleado e inner join empresa_db.departamento d on e.depto_nro = d.depto_nro
where e.puesto in (select puesto from empresa_db.empleado where nombre = "Mito" and apellido = "Barchuk");
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro, d.nombre_depto from empresa_db.empleado e inner join empresa_db.departamento d on e.depto_nro = d.depto_nro
where d.nombre_depto = "Contabilidad" ORDER BY e.nombre;
#Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from empresa_db.empleado where salario = (select min(salario) from empresa_db.empleado);
#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select  e.cod_emp, e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, e.depto_nro from empresa_db.empleado e inner join empresa_db.departamento d on e.depto_nro=d.depto_nro
where e.salario=(select max(salario) from empresa_db.empleado) and d.nombre_depto = "Ventas";
 
