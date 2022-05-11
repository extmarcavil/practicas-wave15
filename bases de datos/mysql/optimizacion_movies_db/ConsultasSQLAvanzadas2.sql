#Agregar un género a la tabla genres.
INSERT INTO genres (created_at,updated_at,name,ranking,active)
	VALUES (NOW(),NULL,'Deportes',13,1);

#Agregar una película a la tabla movies.
#Asociar a la película del punto 1. con el género creado en el punto 2.
INSERT INTO movies (created_at,updated_at,title,rating,awards,release_date,length,genre_id)
	VALUES(NOW(),null,'Gol! El sueño imposible',8.1,1,'2022-05-15 00:00:00',NULL,13);
  
 SET @IdNewMovie = 22;
 SELECT * FROM movies where id = @IdNewMovie;

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET 
    favorite_movie_id = 22
WHERE
    id = 3;
    
SELECT * FROM actors where favorite_movie_id = 22;

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies
	SELECT * FROM movies;
    
SELECT * FROM temp_movies ;  

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM temp_movies 
WHERE
    awards < 5;
         
#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT 
    g.name AS genero, COUNT(m.id) totalPeliculas
FROM
    genres g
        INNER JOIN
    movies m ON g.id = m.genre_id
GROUP BY genero
HAVING totalPeliculas >= 1
ORDER BY totalPeliculas DESC;
    
    
#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT 
    m.title AS Pelicula,
    CONCAT(a.first_name, ' ' ,a.last_name) AS nombreActor,
    m.awards
FROM
    actors a
        INNER JOIN
    movies m ON a.favorite_movie_id = m.id
        AND m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies. revisar que el índice fue creado correctamente
CREATE INDEX Idx_title ON movies (title);
SHOW INDEXES FROM movies;

#En la base de datos movies ¿Existiría una mejora notable al crear índices? 
#Respuesta depende de las consultas que se requieran, asi como el nivel de transaccionalidad que exista
#ya que al crear indices se vuelve lento en operaciones insert,update,delete
#¿En qué otra tabla crearía un índice y por qué? 
#Respuesta seria en la tabla episodes en el campo title ya que podria surgir la necesidad de buscar por nombre de episodio



