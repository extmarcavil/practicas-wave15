INSERT INTO  departamento VALUES ( "D-000-1","Software","Los Tigres");
INSERT INTO  departamento VALUES ( "D-000-2","Sistemas","Guadalupe");
INSERT INTO  departamento VALUES ( "D-000-3","Contabilidad","La Roca");
INSERT INTO  departamento VALUES ( "D-000-4","Ventas","Plata");

INSERT INTO empleado VALUES ( "E-0001",'César','Piñero','Vendedor','2018-05-12',80000,15000,'D-000-4');
INSERT INTO empleado VALUES ( "E-0002",'Yosep','Kowaleski','Analista','2018-05-12',140000,0,'D-000-2');
INSERT INTO empleado VALUES ( "E-0003",'Mariela','Barrios','Director','2018-05-12',185000,0,'D-000-3');
INSERT INTO empleado VALUES ( 'E-0004','Jonathan','Aguilera','Vendedor','2018-05-12',85000,10000,'D-000-4');
INSERT INTO empleado VALUES ( 'E-0005','Daniel','Brezezicki','Vendedor','2018-05-12',83000,10000,'D-000-4');
INSERT INTO empleado VALUES ( 'E-0006','Mito','Barchuk','Presidente','2018-05-12',190000,0,'D-000-3');
INSERT INTO empleado VALUES ( 'E-0007','Emilio','Galarza','Desarrollador','2018-05-12',60000,0,'D-000-1');

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT E.nombre, E.puesto, D.localidad
FROM empleado E, departamento D 
WHERE E.depto_nro = D.depto_nro;

SELECT E.nombre, E.puesto, D.localidad
FROM empleado E 
INNER JOIN departamento D ON E.depto_nro = D.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT nombre_depto, COUNT(E.depto_nro)
FROM empleado E 
INNER JOIN departamento D ON E.depto_nro = D.depto_nro
GROUP BY nombre_depto
HAVING COUNT(E.depto_nro) > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp.nombre, emp.salario, dpto.nombre_depto FROM empleado emp
JOIN departamento dpto ON emp.depto_nro = dpto.depto_nro
WHERE emp.puesto = (SELECT emp.puesto FROM empleado emp WHERE emp.nombre = "César" AND emp.apellido = "Piñero");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT E.nombre, E.apellido, E.puesto, E.fecha_alta, E.salario, D.nombre_depto
FROM departamento D
INNER JOIN empleado E ON D.depto_nro = E.depto_nro
AND D.nombre_depto = "Contabilidad"
ORDER BY nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado ORDER BY salario LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT E.nombre, E.apellido, E.puesto, E.fecha_alta, E.salario, D.nombre_depto
FROM departamento D
INNER JOIN empleado E ON D.depto_nro = E.depto_nro
AND D.nombre_depto = "Ventas"
ORDER BY E.salario DESC
LIMIT 1;
