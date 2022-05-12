-- Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name 
FROM movies_db.series as series INNER JOIN movies_db.genres as genres
ON series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name
FROM movies_db.actors AS actors 
	INNER JOIN movies_db.actor_episode AS actor_episode 
		ON actors.id = actor_episode.actor_id
	INNER JOIN movies_db.episodes AS episodes
		ON actor_episode.episode_id = episodes.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, count(seasons.title) AS seasons_count 
FROM movies_db.series AS series INNER JOIN movies_db.seasons AS seasons
ON series.id = seasons.serie_id
GROUP BY series.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(movies.title) AS movies_count
FROM movies_db.genres AS genres INNER JOIN movies_db.movies AS movies
ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING movies_count >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
-- y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name
FROM movies_db.actors AS actors 
	INNER JOIN movies_db.actor_movie AS actor_movie
		ON actors.id = actor_movie.actor_id
	INNER JOIN movies_db.movies AS movies
		ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE "La Guerra de las galaxias%";