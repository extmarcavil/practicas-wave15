
-- EJercicio 1 Tablas e Indices - Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD(
SELECT e.title, s.number FROM series as se
INNER JOIN seasons as s 
ON se.id = s.serie_id 
INNER JOIN episodes as e 
ON s.id = e.season_id
WHERE se.title = 'The Walking Dead');


SELECT * FROM TWD 
WHERE number = 1; 

-- Consultas SQL Avanzadas 2

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies VALUES( 22, '2022-05-11', '2022-05-11', '#Aiuda', 9.0, 3, '2022-04-04', 2, null)

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUES(13, '2022-05-11','2022-05-11', 'aiuda', 13, 1 ); 

-- 3. Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1. 
UPDATE actors
SET favorite_movie_id = 22
WHERE actors.id = 1; 

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE tempMovies(
SELECT * FROM MOVIES); 

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE  FROM tempMovies
WHERE awards < 5; 

-- 7.Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres 
INNER JOIN Movies
ON genres.id = movies.id
GROUP BY genres.id
HAVING COUNT(genres.active); 

-- 8.Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors 
INNER JOIN movies as m 
ON actors.favorite_movie_id = m.id
WHERE m.awards > 3; 

-- 9.Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX moviesTitlex (title)

-- 10.Chequee que el índice fue creado correctamente.
SHOW INDEX FROM MOVIES