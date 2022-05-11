#Mostrar el título y el nombre del género de todas las series.
SELECT s.title titulo, g.name genero FROM movies_db.series s LEFT JOIN movies_db.genres g on g.id = s.genre_id;
#Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT  a.first_name nombre, a.last_name apellido, e.title titulo FROM movies_db.episodes e LEFT JOIN movies_db.actor_episode ae on e.id = ae.episode_id LEFT JOIN movies_db.actors a on ae.actor_id = a.id;
#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title titulo, count(t.number) temporadas FROM movies_db.series s LEFT JOIN movies_db.seasons t on s.id = t.serie_id group by s.title;
#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name genero, count(m.title) total_peliculas FROM movies_db.movies m LEFT JOIN movies_db.genres g on g.id = m.genre_id GROUP BY g.name HAVING count(m.title) >= 3;
#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name nombre, a.last_name apellido FROM movies_db.movies m LEFT JOIN movies_db.actors a on a.id = m.id WHERE m.title LIKE '%la guerra de las galaxias%';
