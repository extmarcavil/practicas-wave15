-- Agregar una película a la tabla movies.
INSERT INTO movies (`title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) 
VALUES ("El camino de Josu", 7.6, 2, '2010-10-04 00:00:00', '120', '5');

-- Agregar un género a la tabla genres.
INSERT INTO `movies_db`.`genres`
(`name`, `ranking`, `active`)
VALUES
("Indi", 20, 1);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE `movies_db`.`movies`
SET
`genre_id` = 13
WHERE `id` = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE `movies_db`.`actors`
SET
`favorite_movie_id` = 22
WHERE `id` = 6;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copy_movie
	SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM copy_movie
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT G.name, COUNT(M.genre_id)
FROM genres G
INNER JOIN movies M ON G.id = M.genre_id
GROUP BY G.name
HAVING COUNT(M.genre_id)>0;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT CONCAT(A.first_name, ' ', A.last_name) AS "Actor", M.awards Premios
FROM actors A
INNER JOIN movies M ON A.favorite_movie_id = M.id
AND M.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX name_movies_ind ON movies (title);

-- Chequee que el índice fue creado correctamente.
EXPLAIN SELECT * FROM movies WHERE title = "Avatar";
EXPLAIN SELECT * FROM copy_movie WHERE title = "Avatar";

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si se existe una mejora notable ya que al crear un indice se llega directo a los datos que se necesitan 
-- y no recorre todos los datos que estan en la misma.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearia otro indice en la tabla actors para la columna rating ya que es posible que se realicen busquedas de 
-- los actores por su rating y esto agilizaria esas consultas.