#Mostrar todos los registros de la tabla de movies. 
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id FROM movies_db.movies;
#Mostrar el nombre, apellido y rating de todos los actores.
SELECT first_name, last_name, rating FROM movies_db.actors;
#Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT series.title titulo FROM movies_db.series series;
#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name, rating FROM movies_db.actors WHERE rating > 7.5;
#Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM movies_db.movies WHERE rating > 7.5 AND awards > 2;
#Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies_db.movies ORDER BY rating asc;
#Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies_db.movies Limit 3;
#Mostrar el top 5 de las películas con mayor rating.
SELECT title, rating FROM movies_db.movies ORDER BY rating desc Limit 5;
#Listar los primeros 10 actores.
SELECT first_name nombre, last_name apellido FROM movies_db.actors Limit 10;
#Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating FROM movies_db.movies WHERE title LIKE 'Toy Story%';
#Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT first_name nombre, last_name apellido FROM movies_db.actors WHERE first_name LIKE 'Sam%';
#Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT title FROM movies_db.movies 	WHERE release_date between '20040101' AND '20081231';
#Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT title FROM movies_db.movies WHERE rating > 3 AND awards > 1 AND release_date between '19880101' AND '20091231' ORDER BY rating desc;