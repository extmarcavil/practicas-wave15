#Ejercicio 1
SELECT e.nombre,e.puesto, d.localidad from EMPLEADO as e inner join Departamento as d on e.depto_nro = d.depto_nro where e.puesto = "Vendedor";

#Ejercicio 2
#Referencia de tablas y su numero de empleados.
SELECT d.nombre_depto, count(cod_emp) as conteo FROM DEPARTAMENTO as d join EMPLEADO as e on d.depto_nro = e.depto_nro group by d.depto_nro;
#Visualizar departamentos con mas de 5 empleados.
SELECT d.nombre_depto, count(cod_emp) as conteo FROM DEPARTAMENTO as d join EMPLEADO as e on d.depto_nro = e.depto_nro group by d.depto_nro having conteo>5;

#Ejercicio 3
#Mostrar datos de los empleados que tengan el mismo cargo que Mito Brachuk
SELECT e.nombre, e.salario, d.nombre_depto as Departamento FROM EMPLEADO as e join DEPARTAMENTO as d on e.depto_nro = d.depto_nro
WHERE e.puesto = "Presidente";

#Ejercicio 4
#Mostrar datos de los empleados de contabilidad
SELECT e.cod_emp,e.nombre,e.apellido,e.puesto,e.fecha_alta,e.salario,e.comision FROM EMPLEADO as e join DEPARTAMENTO as d on e.depto_nro = d.depto_nro
where d.nombre_depto = "Contabilidad" order by e.nombre;

#Ejercicio 5
#Mostrar el empleado con el salario mas bajo
SELECT * FROM EMPLEADO where salario = (select MIN(salario) from EMPLEADO);

#Ejercicio 6
#Mostar datos del empleado con el salario mas alto del depto ventas
SELECT * FROM EMPLEADO WHERE salario = (SELECT MAX(salario) from EMPLEADO as e join DEPARTAMENTO as d on e.depto_nro = d.depto_nro where nombre_depto ="Ventas");
