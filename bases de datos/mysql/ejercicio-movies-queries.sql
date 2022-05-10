# Mostrar todos los registros de la tabla de movies. 
SELECT *
FROM movies;

# Mostrar el nombre, apellido y rating de todos los actores.
SELECT actors.first_name, actors.last_name, actors.rating 
FROM actors;
 
# Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT serie.title as titulo 
FROM series as serie;

# Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT actors.first_name, actors.last_name
FROM actors
WHERE actors.rating > 7.5;

# Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT movies.title, movies.rating, movies.awards
FROM movies
WHERE movies.rating > 7.5 
	AND movies.awards > 2;
    
# Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT movies.title, movies.rating
FROM movies
ORDER BY movies.rating ASC;

# Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT movies.title
FROM movies
LIMIT 3;

# Mostrar el top 5 de las películas con mayor rating.
SELECT *
FROM movies
ORDER BY movies.rating DESC
LIMIT 5;

# Listar los primeros 10 actores.
SELECT *
FROM actors
LIMIT 10;

# Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT movies.title, movies.rating
FROM movies
WHERE movies.title LIKE "%toy story%";

# Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT *
FROM actors
WHERE actors.first_name LIKE "Sam%";

# Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT movies.title
FROM movies
WHERE movies.release_date BETWEEN "2004-01-01" AND "2008-12-31";

# Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT movies.title
FROM movies
WHERE movies.rating > 3 
	AND movies.awards > 1 
    AND movies.release_date BETWEEN "1988-01-01" AND "2009-12-31"
ORDER BY movies.rating ASC;