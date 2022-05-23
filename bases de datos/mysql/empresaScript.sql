-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT nombre, puesto, localidad 
FROM departamento INNER JOIN empleado ON departamento.depto_nro = empleado.depto_nro
WHERE empleado.puesto="vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT departamento.nombre_depto, COUNT(*) AS counter FROM departamento INNER JOIN empleado ON departamento.depto_nro = empleado.depto_nro
GROUP BY empleado.depto_nro
HAVING counter > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT nombre, salario, nombre_depto FROM empleado INNER JOIN departamento ON departamento.depto_nro = empleado.depto_nro
WHERE empleado.puesto IN (SELECT puesto FROM empleado WHERE empleado.nombre = "Mito" AND empleado.apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.*
FROM empleado INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro 
WHERE departamento.nombre_depto = "contabilidad" ORDER BY empleado.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SElECT nombre FROM empleado WHERE salario IN (SELECT MIN(salario) FROM empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT * FROM empleado WHERE salario IN (SELECT MAX(salario) FROM empleado WHERE puesto = "Vendedor");













