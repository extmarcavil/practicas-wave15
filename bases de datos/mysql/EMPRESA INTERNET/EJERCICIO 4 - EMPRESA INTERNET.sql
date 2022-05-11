-- EJERCICIO 4
-- Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

use empresa_internet;
-- 1) Mostrar todos los clientes.
SELECT * FROM CLIENTE;

-- 2) Mostrar todos los clientes que no vivan en Buenos Aires.
SELECT * FROM CLIENTE WHERE IDCIUDAD NOT LIKE 1;

-- 3) Mostrar todos los planes de internet que tengan descuento.
SELECT * FROM PLANINTERNET WHERE DESCUENTO > 0;

-- 4) Mostrar nombre, apellido y edad de todos los clientes.
SELECT NOMBRECLIENTE, APELLIDOCLIENTE, TIMESTAMPDIFF(YEAR, FECHANAC, NOW()) AS EDAD FROM CLIENTE;

-- 5) Mostrar nombre, apellido y edad de los clientes mayores a 30 años.
SELECT NOMBRECLIENTE, APELLIDOCLIENTE, TIMESTAMPDIFF(YEAR, FECHANAC, NOW()) AS EDAD FROM CLIENTE WHERE TIMESTAMPDIFF(YEAR, FECHANAC, NOW()) > 30;

-- 6) Mostrar nombre, apellido y plan contratado ordenado por plan de manera ascendente.
SELECT NOMBRECLIENTE, APELLIDOCLIENTE, IDPLANINTERNET FROM CLIENTE ORDER BY IDPLANINTERNET ASC;

-- 7) Mostrar nombre y apellido de todos los clientes que contengan una A en su apellido.
SELECT NOMBRECLIENTE, APELLIDOCLIENTE FROM CLIENTE WHERE APELLIDOCLIENTE LIKE '%A%';

-- 8) Mostrar nombre y apellido de todos los clientes que no contengan una A en su apellido.
SELECT NOMBRECLIENTE, APELLIDOCLIENTE FROM CLIENTE WHERE APELLIDOCLIENTE NOT LIKE '%A%';

-- 9) Mostrar nombre y apellido de todos los clientes que vivan en Córdoba y tengan contratado el plan 2.
SELECT NOMBRECLIENTE, APELLIDOCLIENTE FROM CLIENTE WHERE IDCIUDAD = 2 AND IDPLANINTERNET = 2;

-- 10) Mostrar todos los planes que ofrezcan 100 o 150 megas.
SELECT * FROM PLANINTERNET WHERE VELOCIDADMEGAS = 100 OR VELOCIDADMEGAS = 150;
