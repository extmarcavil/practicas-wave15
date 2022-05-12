-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.nombre, empleado.apellido, empleado.puesto, depto.localidad
FROM empresa.departamento AS depto 
	INNER JOIN empresa.empleado AS empleado
		ON depto.depto_nro = empleado.depto_nro
WHERE empleado.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT depto.*, COUNT(empleado.depto_nro) AS cantidad_empleados
FROM empresa.departamento AS depto
	INNER JOIN empresa.empleado AS empleado
		ON depto.depto_nro = empleado.depto_nro
GROUP BY empleado.depto_nro
HAVING empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.apellido, empleado.salario, depto.nombre_depto
FROM empresa.departamento AS depto
	INNER JOIN empresa.empleado AS empleado
		ON depto.depto_nro = empleado.depto_nro
WHERE empleado.puesto IN (SELECT empleado.puesto FROM empresa.empleado AS empleado WHERE nombre = "Mito" AND apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT empleado.*
FROM empresa.empleado AS empleado
WHERE empleado.depto_nro IN (SELECT depto_nro FROM empresa.departamento AS depto WHERE depto.nombre_depto = "Contabilidad")
ORDER BY empleado.nombre, empleado.apellido;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT empleado.nombre, empleado.apellido
FROM empresa.empleado AS empleado
WHERE empleado.salario IN (SELECT MIN(empleado.salario) FROM empresa.empleado AS empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM empresa.empleado AS empleado
WHERE empleado.salario IN (
	SELECT MAX(empleado.salario) FROM empresa.empleado AS empleado WHERE empleado.depto_nro IN (
		SELECT depto.depto_nro FROM empresa.departamento AS depto WHERE depto.nombre_depto = "Ventas"));