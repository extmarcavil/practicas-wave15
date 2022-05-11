-- Mostrar el título y el nombre del género de todas las series.
SELECT 
	s.title, 
    g.name
FROM movies_db.series as s 
	INNER JOIN movies_db.genres as g ON (s.genre_id = g.id);

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name 
FROM movies_db.actor_episode AS ae
	LEFT JOIN movies_db.episodes AS e ON (e.id = ae.episode_id)
    LEFT JOIN movies_db.actors AS a ON (a.id = ae.actor_id)
ORDER BY e.title, a.last_name;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, COUNT(sea.serie_id) AS Temporadas
FROM movies_db.seasons AS sea
LEFT JOIN movies_db.series AS ser ON (sea.serie_id = ser.id)
GROUP BY sea.serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT 
	g.name, 
    COUNT(m.id) 
FROM movies_db.genres g 
	LEFT JOIN movies_db.movies AS m ON (g.id = m.genre_id)
GROUP BY g.id
HAVING COUNT(g.id) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT 
    a.first_name,
    a.last_name
FROM movies_db.actor_movie as am
	LEFT JOIN movies_db.actors as a ON (am.actor_id = a.id)
	LEFT JOIN movies_db.movies as m ON (am.movie_id = m.id)
WHERE m.title LIKE '%GALAXIA%';
    