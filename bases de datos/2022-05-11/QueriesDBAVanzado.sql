USE empresa_db;

-- Ejercicio 1
SELECT e.nombre, e.puesto, d.localidad
FROM empleado as e
JOIN departamento as d ON e.depto_nro = d.depto_nro;

-- Ejercicio 2
SELECT d.nombre_depto, count(e.depto_nro) as num_trabajadores
FROM departamento as d
JOIN empleado as e ON  e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto
HAVING num_trabajadores > 1;

-- Ejercicio 5
SELECT e.nombre, e.salario
FROM empleado as e
WHERE e.salario = (SELECT MIN(salario) FROM empleado);

-- Ejercicio 6
/*
SELECT e.nombre, max(e.salario)
FROM empleado as e
JOIN departamento as d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Ventas';
*/
-- Ejercicio 3
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado as e
JOIN departamento as d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (SELECT puesto FROM empleado WHERE empleado.nombre='Mito' AND empleado.apellido='Barchuk'); 

