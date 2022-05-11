
-- 1
select e.nombre, e.puesto,d.localidad from empleado e inner join departamento d on e.depto_nro=d.depto_nro 
where puesto="Vendedor";
-- 2 
select d.depto_nro,count(*) from Empleado e inner join Departamento d on e.depto_nro=d.depto_nro
group by d.depto_nro having count(*)>5;
-- 3
select e.nombre, e.salario,d.nombre_depto from empleado e inner join departamento d on e.depto_nro=d.depto_nro
where e.puesto = (select puesto from empleado where nombre="Mito" and apellido="Barchuk");
-- 4
select e.nombre from empleado e inner join departamento d on e.depto_nro=d.depto_nro
 where d.nombre_depto="Contabilidad" order by e.nombre;
 -- 5
 select nombre from empleado where salario=(select min(salario) from empleado);
 -- 6
 select e.nombre from empleado e inner join departamento d on e.depto_nro=d.depto_nro
 where e.salario=(select max(salario) from empleado) and d.nombre_depto="Ventas";
 