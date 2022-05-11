#Relaciones entre tablas
select c.*, p.velocidad, p.precio, p.descuento from cliente c
join plan p on p.id_plan = c.id_plan;

#Ejercicio 4 plantear 10 consultas que se podrian realizar en la db
#muestro los clientes que viven en la ciudad de lanus
select nombre, apellido, ciudad
from cliente 
where ciudad = 'lanus';

#muestro los planes que cuentan con un descuento mayor o igual a 20
select *
from plan 
where descuento >= 20;

#Muestro los planes que cuentan con una velocidad mayor o igual a 200
select * 
from plan 
where velocidad >= 200;

#Muestro los nombre y apellido de los clientes que nacieron a partir de 2001
select nombre, apellido, fecha_nacimiento
from cliente 
where fecha_nacimiento > 20010101;

#Muestro los nombre y apellido de los clientes que cuentan con un plan con un precio mayor a 2000
select nombre, apellido, p.precio
from cliente c
join plan p on p.id_plan = c.id_plan
where p.precio > 2000;

#Muestro los descuentos disponibles que hay para los planes
select distinct descuento
from plan;

#Muestro los planes que tengan un precio mayor a 2000 y descuento mayor o igual a 21
select *
from plan
where precio > 2000 and descuento >= 21;

#muestro los clientes que nacieron luego del 2001 y viven en lanus
select nombre, apellido
from cliente 
where fecha_nacimiento > 20010101 and ciudad = 'lanus';

#muestro los clientes que tengan el plan de id 2
select nombre, apellido 
from cliente 
where id_plan = 2;

#muestro los clientes que hayan nacido luego del 2000 y cuyo plan tenga un descuento del 20
select c.nombre, c.apellido
from cliente c
join plan p on p.id_plan = c.id_plan
where c.fecha_nacimiento > 20000101 and p.descuento > 20