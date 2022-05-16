-- Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies_db.movies;
-- Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name,last_name,rating FROM movies_db.actors;
-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title AS Titulo FROM movies_db.series AS Serie;
-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name,last_name FROM movies_db.actors WHERE rating > 7.5;
-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title,rating,awards FROM movies_db.movies WHERE rating > 7.5 AND awards > 2;
-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title,rating FROM movies_db.movies ORDER BY rating;
-- Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT * FROM movies_db.movies WHERE id <= 3;
-- Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM movies_db.movies ORDER BY rating DESC LIMIT 5;
-- Listar los primeros 10 actores.
SELECT * FROM movies_db.actors WHERE id <= 10;
-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title,rating FROM movies_db.movies WHERE title LIKE '%Toy Story%';
-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM movies_db.actors WHERE first_name LIKE 'Sam%';
-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title,release_date FROM movies_db.movies WHERE release_date BETWEEN '2004-01-01' AND '2008-01-01';
-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title FROM movies_db.movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-01-01' ORDER BY rating;


########## Comandos Avanzados ########

-- Inner Join (o Join a secas) de movies y actors segun el id de actores
SELECT movies.*, actors.first_name, actors.last_name FROM 
movies INNER JOIN actors ON movies.id = actors.favorite_movie_id;

-- Inner Join identica pero con alias
SELECT 
	mo.*, ac.first_name, ac.last_name
FROM 
	movies mo INNER JOIN actors ac
ON 
	mo.id = ac.favorite_movie_id;

-- Left Join como la interseccion esta dada por mo.id = ac.favorite_movie_id , lo que devuelve es 
-- la union propiamente dicha notar que al final esta fovourite movie y como es un select * es todo
SELECT *
FROM movies mo LEFT JOIN actors ac
ON mo.id = ac.favorite_movie_id;

-- Group BY
SELECT COUNT(*) as cantidad , mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac 
ON mo.id = ac.favorite_movie_id 
GROUP BY mo.title,mo.rating, mo.awards
ORDER BY rating desc;

SELECT COUNT(*) AS tot_act, mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac 
ON mo.id = ac.favorite_movie_id 
GROUP BY title,mo.rating, mo.awards HAVING tot_act > 2;

-- Subconsultas
/* SELECT id FROM movies WHERE rating=9.0; ---> Id = [4,6,17 y 20] 
*/
SELECT *
FROM actor_movie
WHERE movie_id IN (SELECT id FROM movies WHERE rating=9.0);


-- Segunda parte
-- Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name FROM series JOIN genres ON series.genre_id = genres.id;
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title,a.first_name,a.last_name FROM  actor_episode AS ae
    INNER JOIN actors   AS a on ae.actor_id = a.id
    INNER JOIN episodes AS e on ae.episode_id = e.id;
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, count(se.id) as cantidad_temporadas
    FROM episodes ep
        JOIN seasons se ON se.id = ep.season_id
        JOIN series s ON se.serie_id = s.id
        GROUP BY s.title;
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name,COUNT(m.title) as cantidad_de_peliculas
    FROM movies m JOIN genres g on m.genre_id = g.id
    GROUP BY g.name HAVING cantidad_de_peliculas >= 3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name,a.last_name
    FROM actors a
        JOIN actor_movie am ON a.id = am.actor_id
        JOIN movies m ON am.movie_id = m.id
        WHERE m.title LIKE '%guerra de las galaxias%';
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name,a.last_name, m.title
FROM actors a
         JOIN actor_movie am ON a.id = am.actor_id
         JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%guerra de las galaxias%';

-- Otra Forma usando subquerys, pero tarda mas que la primera, asi que no es muy convincente
SELECT DISTINCT a.first_name,a.last_name
    FROM actor_movie am
    JOIN ( SELECT m.id, m.title FROM movies m WHERE m.title LIKE '%guerra de las galaxias%') sq1 ON sq1.id = am.movie_id
    JOIN actors a on a.id = am.actor_id



