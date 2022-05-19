-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto , count(e.depto_nro) AS cuenta
FROM empleado e JOIN departamento d ON d.depto_nro = e.depto_nro
GROUP BY e.depto_nro
HAVING cuenta > 2;