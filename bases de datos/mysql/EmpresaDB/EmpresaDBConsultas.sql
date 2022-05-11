-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT Empleado.nombre, Empleado.apellido, Empleado.puesto, Departamento.localidad FROM Empleado join Departamento on Empleado.depto_nro = Departamento.depto_nro;
-- Visualizar los departamentos con más de cinco empleados.
SELECT depto_nro,nombre_depto, localidad FROM Departamento WHERE depto_nro in (SELECT  depto_nro FROM Empleado GROUP BY depto_nro having count(*)>=5);
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto FROM Empleado as e join Departamento as d on e.depto_nro = d.depto_nro WHERE e.puesto in (SELECt puesto from Empleado WHERE nombre = "Mito" AND apellido = "Barchuk"); 
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido FROM Empleado WHERE salario = (SELECT salario FROM Empleado order by salario LIMIT 1);
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT Empleado.nombre,Empleado.apellido from Empleado join Departamento on Empleado.depto_nro = Departamento.depto_nro WHERE nombre_depto like "Ventas" ORDER BY salario DESC LIMIT 1;

