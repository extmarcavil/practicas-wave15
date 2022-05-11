SELECT nombre, puesto, localidad FROM departamento INNER JOIN empleado ON departamento.depto_nro = empleado.depto_nro WHERE puesto = 'Vendedor';
SELECT nombre_depto FROM empresa.departamento INNER JOIN empleado ON departamento.depto_nro = empleado.depto_nro GROUP BY nombre_depto HAVING COUNT(nombre_depto) >= 5;
SELECT nombre, salario FROM empresa.empleado WHERE empleado.puesto = (SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk');
SELECT nombre, puesto, localidad FROM empleado INNER JOIN departamento ON departamento.depto_nro = empleado.depto_nro WHERE nombre_depto = 'Contabilidad' ORDER BY nombre;
SELECT nombre, apellido FROM empleado ORDER BY salario LIMIT 1;
SELECT nombre, apellido FROM empleado INNER JOIN departamento ON departamento.depto_nro = empleado.depto_nro WHERE nombre_depto = 'Ventas' ORDER BY salario DESC LIMIT 1;