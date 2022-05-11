INSERT INTO departamento VALUES (1, 'Software','Los Tigres');
INSERT INTO departamento VALUES ( 2, 'Sistemas','Guadalupe');
INSERT INTO departamento VALUES ( 3, 'Contabilidad','La Roca');
INSERT INTO departamento VALUES ( 4,'Ventas','Plata');

INSERT INTO departamento VALUES ( 5,'Ventas','Plata');
INSERT INTO departamento VALUES ( 6,'Ventas','Plata');
INSERT INTO departamento VALUES ( 7,'Ventas','Plata');
INSERT INTO departamento VALUES ( 8,'Ventas','Plata');




INSERT INTO empleado VALUES ( 1,'César','Piñero','Vendedor','2018-05-12',80000,15000,1);
INSERT INTO empleado VALUES ( 2,'Yosep','Kowaleski','Analista','2018-05-12',140000,0,1);
INSERT INTO empleado VALUES ( 3 ,'Mariela','Barrios','Director','2018-05-12',185000,0,2);
INSERT INTO empleado VALUES ( 4, 'Jonathan','Aguilera','Vendedor','2018-05-12',85000,10000,2);
INSERT INTO empleado VALUES ( 5,'Daniel','Brezezicki','Vendedor','2018-05-12',83000,10000,4);
INSERT INTO empleado VALUES ( 6,'Mito','Barchuk','Presidente','2018-05-12',190000,0,3);
INSERT INTO empleado VALUES ( 7,'Emilio','Galarza','Desarrollador','2018-05-12',60000,0,1);


INSERT INTO empleado VALUES ( 8,'Emilio','Galarza','Desarrollador','2018-05-12',60000,0,1);

INSERT INTO empleado VALUES ( 9,'Carlos','Bilardo','Desarrollador','2018-05-12',60000,0,1);
INSERT INTO empleado VALUES ( 10,'Pablo','Perez','Desarrollador','2018-05-12',60000,0,1);
INSERT INTO empleado VALUES ( 11,'Ali','Galarza','Desarrollador','2018-05-12',60000,0,1);


select	e.nombre, e.puesto, d.localidad from departamento d , empleado e
where d.depto_nro = e.depto_nro
and e.puesto = 'Vendedor';

select * from departamento d, empleado e
where e.depto_nro = d.depto_nro
and count(e.nombre) > 5;

SELECT nombre_depto 
FROM departamento 
INNER JOIN empleado 
ON departamento.depto_nro = empleado.depto_nro
GROUP BY nombre_depto HAVING COUNT(nombre_depto) >= 5;


select e.nombre, e.salario , d.nombre_depto from departamento d, empleado e
where e.depto_nro = d.depto_nro
and e.puesto = (select e.puesto from empleado e where e.nombre = 'Mito' and e.apellido = 'Barchuk');


select * from empleado e, departamento d
where e.depto_nro = d.depto_nro 
and d.nombre_depto = 'Contabilidad'
order by e.nombre asc;

select e.nombre , min(e.salario) from empleado e group by e.nombre;






SELECT nombre, apellido 
FROM empleado 
JOIN departamento ON departamento.depto_nro = empleado.depto_nro 
WHERE nombre_depto = 'Ventas' 
ORDER BY salario DESC LIMIT 1;