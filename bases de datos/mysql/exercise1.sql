-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
SELECT e.nombre , e.puesto , d.nombre_depto FROM empleado e JOIN departamento d ON d.depto_nro = e.depto_nro ;