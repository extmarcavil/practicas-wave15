DROP TABLE TWD;
-- Ejercicio 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD 
SELECT episodes.*, seasons.number temporada
FROM series 
INNER JOIN seasons on series.id = seasons.serie_id
INNER JOIN  episodes on seasons.id = episodes.season_id
WHERE series.title = "The Walking Dead";

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD
WHERE temporada = 1;

-- Ejercicio 1
-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
ALTER TABLE `movies_db`.`actors` 
DROP INDEX `first_name` ,
ADD INDEX `first_name` (`first_name` ASC) COMMENT '\'Optimizar la busqueda de actores por su nombre\'' VISIBLE;

SHOW INDEX FROM actors; 

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- El indice lo creamos en la columna first_name de la tabla actors para optimizar la busqueda de actores por su nombre



