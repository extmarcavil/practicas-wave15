#Agregar una película a la tabla movies.
INSERT INTO movies VALUES(null,null,null,"Spider Man",8.4,5,"2002-11-25",121,4);

#Agregar un género a la tabla genres.
INSERT INTO genres VALUES(null,now(),null,"El que te guste",13,1);

#Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies SET genre_id = 13 
where movies.id = 22; 

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22
WHERE actors.id = 3; 

#Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies2 
SELECT *
FROM movies 
;

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

DELETE FROM movies2 
WHERE awards < 5; 

SELECT *
FROM movies2;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT genres.*,COUNT(*) cant_peli FROM genres
INNER JOIN movies on genres.id = movies.genre_id
GROUP BY genres.id
;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.* FROM actors 
INNER JOIN movies on actors.favorite_movie_id = movies.id
WHERE movies.awards >3; 

#Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE `movies_db`.`movies` 
ADD INDEX `title` (`title` ASC) VISIBLE;

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies; 

#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.


#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta


