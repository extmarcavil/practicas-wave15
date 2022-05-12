
-- Agregar una película a la tabla movies.
INSERT INTO movies_db.movies (id, title, rating, awards, release_date, length) 
VALUES ('22', 'Fast And Furious I', '8.0', '1', '2002-03-15', '103');

-- Agregar un género a la tabla genres.
INSERT INTO movies_db.genres (id, created_at, name, ranking, active) VALUES ('13', '2022-05-11', 'Nuevo genero', '13', '1');

-- Asociar a la película del punto 1. con el género creado en el punto 2.
 UPDATE movies_db.movies SET genre_id = '13' WHERE (id = '22');
 
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
 UPDATE movies_db.actors SET favorite_movie_id = '22' WHERE (id = '47');

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp
SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT 
	g.*
FROM movies_db.genres g 
	INNER JOIN movies_db.movies AS m ON (g.id = m.genre_id)
GROUP BY g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT 
	g.*
FROM movies_db.actors g 
	INNER JOIN movies_db.movies AS m ON (g.favorite_movie_id = m.id)
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title
ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
