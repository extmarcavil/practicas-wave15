-- EJERCICIO CREACIÓN DE TABLAS TEMPORALES E ÍNDICES
-- EJERCICIO 1:
-- A) Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las
--    temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (nombre varchar(40), temporada varchar(40));
insert into TWD SELECT e.title nombre, se.title temporada FROM series s 
inner join seasons se on s.id = se.serie_id 
inner join episodes e on se.id = e.season_id 
where s.title LIKE '%The Walking Dead%';

​-- B) Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE temporada LIKE '%Primer temporada%';
​-- ----------------------------------------------------------------------------------------------------------------------------------
-- EJERCICIO 2:
-- A) En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
EXPLAIN SELECT * FROM movies WHERE awards > 3; -- ANTES DE CREAR EL INDEX
-- ALTER TABLE `movies_db`.`movies`;
-- ALTER TABLE `movies_db`.`movies` ALTER INDEX `movies_awards_index` VISIBLE;
EXPLAIN SELECT * FROM movies WHERE awards > 3; -- DESPUÉS DE CREAR EL INDEX

-- B) Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Se crea un índice en la tabla movies para poder realizar la consulta sobre premios más rápida. 
-- Antes de crear el índice, la consulta analizaba 21 filas para llegar al resultado de 7 registros que cumplen con la condición consultada.
-- Luego de crearlo, al hacer la misma consulta, analiza sólo las 7 filas resultantes, optimizando la misma.