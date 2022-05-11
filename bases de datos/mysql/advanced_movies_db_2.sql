-- Consultas SQL Avanzadas 2
SET SQL_SAFE_UPDATES = 0;

-- Agregar una película a la tabla movies.
INSERT INTO `movies_db`.`movies` (`title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) 
	VALUES ('Parasito', '8.5', '4', '2019-05-30', '132', '2');

-- Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres` (`created_ip`,`name`, `ranking`) 
	VALUES ('2022-05-11','Romance', '13');

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE `movies_db`.`movies` 
SET `genre_id` = '13' 
WHERE (`id` = '22');

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE `movies_db`.`actors` 
SET `favorite_movie_id` = '22' 
WHERE (`id` = '3');

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
SELECT m.id, m.created_at, m.updated_at, m.title, m.rating, m.awards, m.release_date, m.length, m.genre_id 
FROM movies m;

SELECT * FROM movies_copy;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy mc
WHERE mc.awards < 5;

-- verifico tabla
SELECT * FROM movies_copy;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT 
	g.id, g.name, COUNT(g.id) cantidad FROM genres g
INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.id
HAVING cantidad>=1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT 
	a.first_name, a.last_name FROM actors a
INNER JOIN movies m ON m.id= a.favorite_movie_id
WHERE m.awards >3;

-- Crear un índice sobre el nombre en la tabla movies.
SHOW INDEX FROM movies;

CREATE INDEX movies_title_idx
ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- Si, al agregar indices a los id y a algunos campos, se podrían mejorar los tiempos de respuestas en consultas y accesos a los registros 
-- quizas ahora no se notaria casi la diferencia, al ser una base chica pero si en un futuro crece, se podría notar.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
--  Todas las tablas ya tienen indices en sus PK y FK, se podría crear otros relacionados a fechas si se nota que es un campo bastabte utilizado en consultas.
