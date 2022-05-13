-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
-- SET SQL_SAFE_UPDATES = 0;
SELECT emp.nombre, emp.puesto, depa.localidad FROM
 Empleado emp JOIN  Departamento depa 
ON emp.depto_nro = depa.depto_nro
WHERE emp.puesto LIKE "%Vendedor%";

-- Visualizar los departamentos con más de cinco empleados. No hay mas de 3 empleados por departamento.
SELECT depa.nombre_depto 
FROM Empleado emp
JOIN Departamento depa 
ON emp.depto_nro = depa.depto_nro
GROUP BY emp.depto_nro
HAVING COUNT(*)>=3;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp.nombre, emp.salario, depa.nombre_depto 
FROM Empleado emp 
JOIN Departamento depa
ON emp.depto_nro = depa.depto_nro
WHERE emp.puesto =(SELECT puesto FROM Empleado WHERE nombre LIKE "%Mito%" AND apellido LIKE "%Barchuk%");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT Empleado.*
FROM Empleado 
JOIN Departamento 
ON Empleado.depto_nro = Departamento.depto_nro
WHERE Departamento.nombre_depto LIKE "%Contabilidad%"
ORDER BY Empleado.nombre;

SELECT *
FROM Empleado
WHERE depto_nro LIKE "D-000-3"
ORDER BY nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre 
FROM Empleado
ORDER BY salario LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT d.*, e.*
FROM Empleado e
JOIN Departamento d
ON e.depto_nro = d.depto_nro
HAVING d.nombre_depto LIKE "Ventas"
ORDER BY e.salario DESC LIMIT 1;

SELECT nombre
FROM Empleado
WHERE depto_nro LIKE "D-000-4"
ORDER BY salario DESC LIMIT 1;

SELECT nombre, salario
FROM Empleado
WHERE depto_nro LIKE "D-000-4"
ORDER BY salario DESC;
