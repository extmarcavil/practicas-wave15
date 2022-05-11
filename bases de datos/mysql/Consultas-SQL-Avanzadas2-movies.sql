USE movies_db;

# Agregar una película a la tabla movies.
INSERT INTO movies VALUES
	(null, null, null, "Spider Man", 8.4, 5, "2002-11-25", 121,4);

#Agregar un género a la tabla genres.
INSERT INTO genres VALUES
	(null, now(), null, "El que te guste", 13, 1);

#Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies
SET genre_id = 13 
WHERE movies.id = 22; 

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET favorite_movie_id = 22
WHERE actors.id = 3; 

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies2 
SELECT *
FROM movies ;

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies2 
WHERE awards < 5; 

SELECT *
FROM movies2;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT genres.* 
FROM genres INNER JOIN movies on genres.id = movies.genre_id
GROUP BY genres.id;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.* 
FROM actors INNER JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3; 

#Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title` (`title` ASC) VISIBLE;

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies; 

EXPLAIN SELECT * FROM movies_db.movies mov  WHERE mov.title = "Titanic";
#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si, en la BD de datos habria una mejora notable al crear indices porque estos ayudan a agilizar las consultas de datos.
-- Por ejemplo, hemos creado un indice para el titulo de las peliculas así, para buscar una pelicula por un nombre,
-- si ejecutamos un EXPLAIN SELECT * FROM movies_db.movies mov  WHERE mov.title = "Titanic"; antes de crear el indice, vemos que se busca por todos los registros de la tabla,
-- sin embargo, luego de crear el inidice, podemos observar que solo se busca por un unico registro de la tabla.

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la tabla series podria crearse un indice para release_date y agilizar la busqueda de series por año de lanzamiento (lo mismo para la tabla movies).

