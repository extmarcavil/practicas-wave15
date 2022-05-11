-- Ejercicio 1

CREATE TEMPORARY TABLE TWD
SELECT e.* FROM episodes e
JOIN seasons s 
ON e.season_id = s.id
WHERE s.serie_id = 3

SELECT * FROM TWD
WHERE s.`number` = 1

-- Ejercicio 2
-- Justificación: se crea un índice en la columna release_date porque se recibirán consultas frecuentes en base a dicho campo
-- y no suele ser actualizado
CREATE INDEX releaseDateIdx ON movies(release_date);
EXPLAIN SELECT * FROM movies WHERE release_date > "2005-01-01"


-- Ejercicios 2do documento
-- Ejercicio 1
INSERT INTO movies
(created_at, updated_at, title, rating, awards, release_date, `length`, genre_id)
VALUES (null, null, "El lobo de Wall Street", 4, 0, "2017-01-01", 120, 5)

INSERT INTO genres
(created_at, updated_at, name, ranking, active)
VALUES (now(), null, "Anime", 13, 1)

UPDATE movies SET genre_id = 14 WHERE id = 22

UPDATE actors SET favorite_movie_id = 22 WHERE id = 1

CREATE TEMPORARY TABLE moviesTemp
SELECT * FROM movies

DELETE FROM moviesTemp WHERE awards < 5

SELECT DISTINCT g.* FROM genres g
LEFT JOIN movies m
ON m.genre_id = g.id 
WHERE m.id IS NOT NULL

SELECT a.* FROM actors a
JOIN movies m
ON a.favorite_movie_id = m.id 
WHERE m.awards > 3

CREATE INDEX titleIdx ON movies(title);
EXPLAIN SELECT * FROM movies WHERE title = "Toy Story";

-- 11: ¿Existiría mejora en esta base al usar índices?
-- Respuesta: Conceptualmente sí porque al crecer el número de registros, los tiempos de consulta sin índices van a aumentar,
-- pero en su volumen actual no habría mejora notable.

-- 12: ¿En qué otras tablas crearía índices?
-- En seasons se podrían crear índices para las columnas release_date y end_date por la misma razón que en la tabla movies

