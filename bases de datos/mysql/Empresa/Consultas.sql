-- Ejercicio 1
SELECT nombre, puesto, localidad FROM Empleado 
INNER JOIN Departamento 
ON Empleado.depto_nro = Departamento.depto_nro 
WHERE puesto = 'Vendedor';

-- Ejercicio 2
SELECT d.depto_nro, d.nombre_depto, d.localidad, COUNT(cod_emp) AS cant_empleados FROM Empleado
INNER JOIN Departamento as d
ON Empleado.depto_nro = d.depto_nro
GROUP BY Empleado.depto_nro
HAVING cant_empleados >= 5;

-- Ejercicio 3
SELECT nombre, salario, nombre_depto FROM Empleado
INNER JOIN Departamento
ON Empleado.depto_nro = Departamento.depto_nro
WHERE puesto = (
	SELECT puesto
    FROM Empleado
    WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);

-- Ejercicio 4
SELECT * FROM Empleado
INNER JOIN Departamento
ON Empleado.depto_nro = Departamento.depto_nro
WHERE Departamento.nombre_depto = 'Contabilidad';

-- Ejercicio 5
SELECT * FROM Empleado
WHERE salario = (SELECT MIN(salario) FROM Empleado);

-- Ejercicio 6
SELECT * FROM Empleado
WHERE depto_nro = (SELECT depto_nro from Departamento where nombre_depto = "Ventas")
ORDER BY salario DESC
LIMIT 1;