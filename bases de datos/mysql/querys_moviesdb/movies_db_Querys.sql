-- QUERYS
-- Mostrar todos los registros de la tabla movies
SELECT * FROM movies;

-- Mostrar el nombre, apellido y rating de todos los actores
SELECT first_name, last_name, rating FROM actors;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT * FROM series;
SELECT title AS titulo FROM series AS series;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name FROM actors 
WHERE  rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM movies
WHERE rating > 7.5 AND awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies
ORDER BY rating;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies LIMIT 3;

-- Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM movies 
ORDER BY rating DESC
LIMIT 5;

-- Listar los primeros 10 actores.
SELECT * FROM actors
LIMIT 10; 

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating  FROM movies 
WHERE title LIKE "%Toy Story%";

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM actors
WHERE first_name LIKE "Sam%";

-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title FROM movies 
WHERE release_date BETWEEN "2004-01-02" AND "2008-01-01";

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
 SELECT * FROM movies 
 WHERE rating > 3 AND  awards > 1 AND release_date BETWEEN "1988" AND "2009";
 

 -- BONUS --
 -- Mostrar el título y el nombre del género de todas las series.
 SELECT m.title, g.name
 FROM movies m 
 JOIN genres g 
 ON m.genre_id = g.id;
 
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, CONCAT(a.first_name, " ", a.last_name) AS Actor 
FROM actors a 
JOIN actor_episode ae ON a.id = ae.actor_id
JOIN episodes e ON ae.episode_id = e.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(t.serie_id) AS total_temporadas
FROM series s 
JOIN seasons t ON t.serie_id = s.id
GROUP BY t.serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.title) AS total_movies_by_genre
FROM movies m 
JOIN genres g ON m.genre_id = g.id
GROUP BY m.genre_id
HAVING COUNT(m.title) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT CONCAT(a.first_name," ",a.last_name) AS full_name
FROM actors a 
JOIN actor_movie am ON am.actor_id = a.id
JOIN movies m ON am.movie_id = m.id
GROUP BY m.title, a.first_name, a.last_name 
HAVING m.title LIKE "%La Guerra de las galaxias%"


 
 

