/*Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.*/

SELECT nombre, puesto, localidad FROM Empleado JOIN Departamento WHERE Departamento.depto_nro = Empleado.depto_nro; 

/* Visualizar los departamentos con más de cinco empleados. */ 
SELECT Count(d.depto_nro), d.nombre_depto FROM Departamento as d 
INNER JOIN Empleado as e 
ON d.depto_nro = e.depto_nro
GROUP BY nombre_depto
HAVING Count(nombre_depto) > 5 ; 

/* Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */ 
SELECT nombre, salario, nombre_depto
FROM Empleado as e
INNER JOIN Departamento as d
ON e.depto_nro = d.depto_nro
WHERE puesto
IN (SELECT puesto
FROM Empleado
WHERE nombre LIKE 'Mi%' AND apellido LIKE '%chuk');

/* Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */
SELECT * 
FROM Empleado as e
INNER JOIN Departamento as d
ON e.depto_nro = d.depto_nro
WHERE nombre_depto = 'Contabilidad'
ORDER BY e.nombre ASC;

/* Mostrar el nombre del empleado que tiene el salario más bajo.*/
SELECT salario, nombre
FROM Empleado 
WHERE salario IN(SELECT MIN(salario) FROM Empleado); 

/* Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */ 
SELECT salario, nombre
FROM Empleado
INNER JOIN Departamento 
ON departamento.depto_nro = empleado.depto_nro
WHERE Departamento.nombre_depto = 'Ventas'
ORDER BY salario DESC
LIMIT 1; 








 





 


