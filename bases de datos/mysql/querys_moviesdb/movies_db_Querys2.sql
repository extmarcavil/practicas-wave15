-- Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, null, null, "Fast and Fourius", 10.0, 8, 20030709, 135, null);

-- Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13, 20150709, null, "ficcion", 13, 1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 34;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE moviesTemporal (
id int,
created_at timestamp,
updated_at timestamp,
title varchar(500),
rating decimal(3,1),
awards int,
release_date datetime,
lenght int,
genre_id int
);

INSERT INTO moviesTemporal
SELECT * FROM movies;

SELECT * FROM moviesTemporal;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM moviesTemporal
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name, COUNT(m.genre_id)AS num_peliculas
FROM movies m 
JOIN genres g
ON m.genre_id = g.id
GROUP BY m.genre_id , g.name
HAVING COUNT(m.genre_id) >= 1;


-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*, m.title, m.awards
FROM actors a 
JOIN actor_movie am ON a.id = am.actor_id
JOIN movies m ON am.movie_id = m.id
WHERE m.awards > 3;


-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX rating 
ON movies(rating);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN SELECT title 
FROM movies 
WHERE title LIKE "Fast and forius";

EXPLAIN SELECT rating 
FROM movies
WHERE rating >= 7.9; 

SELECT rating 
FROM movies
WHERE rating >= 7.9;




