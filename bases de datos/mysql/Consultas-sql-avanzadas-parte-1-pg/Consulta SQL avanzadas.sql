-- Ejemplo
-- SELECT movies.*, actors.first_name, actors.last_name, actors.favorite_movie_id FROM movies INNER JOIN actors ON movies.id = actors.favorite_movie_id

-- Mostrar el título y el nombre del género de todas las series.
-- SELECT series.id, series.title, genres.name FROM series INNER JOIN genres ON series.genre_id = genres.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
-- SELECT episodes.title, actors.first_name, actors.last_name FROM actor_episode INNER JOIN episodes ON actor_episode.episode_id = episodes.id INNER JOIN actors ON actors.id = actor_episode.actor_id ORDER BY episodes.title ASC;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
-- SELECT series.title, COUNT(seasons.serie_id) FROM seasons INNER JOIN series ON seasons.serie_id = series.id GROUP BY title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
-- SELECT genres.name, COUNT(movies.id) as cantidad FROM genres INNER JOIN movies ON genres.id = movies.genre_id GROUP BY name HAVING cantidad >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
-- SELECT actors.first_name, actors.last_name, movies.title FROM actor_movie INNER JOIN actors ON actor_movie.actor_id = actors.id INNER JOIN movies ON actor_movie.movie_id = movies.id GROUP BY title, first_name, last_name HAVING title LIKE "%VII%";