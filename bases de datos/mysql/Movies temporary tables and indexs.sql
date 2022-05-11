-- Creación de Tablas Temporales e Índices

-- Crear una tabla temporal llamada “TWD” y guardar los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
SELECT e.* FROM episodes e
JOIN seasons s
ON e.season_id = s.id
WHERE s.serie_id = 3;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD
WHERE s.`number` = 1;

-- Seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
# Justificación: Se crea un índice en la columna release_date porque se pueden recibir consultas frecuentes 
# sobre dicho campo y el mimso no será actualizado.
CREATE INDEX releaseDateIdx ON movies(release_date);
EXPLAIN SELECT * FROM movies WHERE release_date > “2005-01-01”


-- Consultas SQL Avanzadas 2

-- Agregar una película a la tabla movies.
INSERT INTO movies_db.movies (created_at, updated_at, title, rating, awards, release_date, `length`, genre_id)
VALUES (null, null, "El lobo de Wall Street", 4, 0, "2017-01-01", 120, 5);

-- Agregar un género a la tabla genres.
INSERT INTO movies_db.genres (created_at, updated_at, name, ranking, active)
VALUES (now(), null, "Anime", 13, 1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies_db.movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE movies_db.actors SET favorite_movie_id = 22 WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_db.moviesTemp SELECT * FROM movies_db.movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_db.moviesTemp WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* FROM movies_db.genres g
LEFT JOIN movies_db.movies m
ON m.genre_id = g.id 
WHERE m.id IS NOT NULL;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* FROM movies_db.actors a
JOIN movies_db.movies m
ON a.favorite_movie_id = m.id 
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX titleIdx ON movies_db.movies (title);
-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT * FROM movies_db.movies WHERE title = "Toy Story";

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# Sí. Por ejemplo, crear índices en la tabla movies, la cual es una de las principales tablas de la base de datos
# y su número de registros crece constantemente, acortará muchísimo los tiempos de consulta sobre la misma.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# Se podrían crear índices en la tabla de actores en los campos de nombre y apellido, 
# ya que los datos de los mismos no cambiarán.