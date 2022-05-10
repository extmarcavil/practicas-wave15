-- 1) Mostrar todos los registros de la tabla de movies. 
use movies_db;
SELECT * FROM MOVIES;

-- 2) Mostrar el nombre, apellido y rating de todos los actores.
SELECT FIRST_NAME, LAST_NAME, RATING FROM ACTORS;

-- 3) Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT TITLE AS TITULO FROM SERIES AS SERIES_ESP;

-- 4) Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT FIRST_NAME, LAST_NAME FROM ACTORS 
WHERE RATING > 7.5;

-- 5) Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT TITLE, RATING, AWARDS FROM MOVIES 
WHERE RATING > 7.5 AND AWARDS > 2;

-- 6) Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT TITLE, RATING FROM MOVIES 
ORDER BY RATING ASC;

-- 7) Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT TITLE FROM MOVIES 
LIMIT 3;

-- 8) Mostrar el top 5 de las películas con mayor rating.
SELECT * FROM MOVIES 
ORDER BY RATING DESC LIMIT 5;

-- 9) Listar los primeros 10 actores.
SELECT * FROM ACTORS 
LIMIT 10;

-- 10) Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT TITLE, RATING FROM MOVIES 
WHERE TITLE LIKE "TOY STORY%";

-- 11) Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM ACTORS 
WHERE FIRST_NAME LIKE "SAM%";

-- 12) Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT * FROM MOVIES 
WHERE YEAR(RELEASE_DATE) BETWEEN 2004 AND 2008;

-- 13) Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento
--     entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT TITLE FROM MOVIES 
WHERE RATING > 3 AND AWARDS > 1 AND YEAR(RELEASE_DATE) BETWEEN 1988 AND 2009 
ORDER BY RATING DESC;
