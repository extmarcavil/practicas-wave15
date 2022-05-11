# Mostrar el título y el nombre del género de todas las series.
SELECT ser.title,  gen.name
FROM movies_db.series ser INNER JOIN movies_db.genres gen
ON ser.genre_id = gen.id;

# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, act.first_name, act.last_name
FROM movies_db.actor_episode actep
INNER JOIN movies_db.episodes ep
ON actep.episode_id = ep.id
INNER JOIN movies_db.actors act
ON actep.actor_id = act.id;

# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title, count(*) total
FROM movies_db.series ser INNER JOIN movies_db.seasons sea
ON ser.id = sea.serie_id
GROUP BY ser.title;

# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT gen.name, count(*) total
FROM movies_db.genres gen INNER JOIN movies_db.movies mov
ON mov.genre_id = mov.id
GROUP BY gen.name
HAVING total >= 3;
SELECT * FROM movies_db.movies;

# Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT act.first_name, act.last_name
FROM movies_db.actor_movie actmov
	INNER JOIN movies_db.movies mov
	ON actmov.movie_id = mov.id
	INNER JOIN movies_db.actors act
    ON actmov.actor_id = act.id
WHERE mov.title LIKE "%Guerra de las galaxias%"
GROUP BY act.id
HAVING count(act.id) = 
	(SELECT count(*) 
    FROM movies_db.movies mov 
    WHERE mov.title LIKE "%Guerra de las galaxias%");