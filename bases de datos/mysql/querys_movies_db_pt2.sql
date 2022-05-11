USE movies_db;
SELECT title, name FROM series s INNER JOIN genres g ON s.genre_id = g.id;
SELECT e.title, first_name, last_name FROM episodes e INNER JOIN actor_episode ae ON ae.episode_id = e.id INNER JOIN actors a ON a.id = ae.actor_id;
SELECT sr.title, COUNT(sr.id) as NumTemporadas FROM series sr INNER JOIN seasons ss ON sr.id = ss.serie_id GROUP BY ss.serie_id;
SELECT name, COUNT(m.id) as NumPeliculas FROM genres g INNER JOIN movies m ON g.id = m.genre_id GROUP BY m.genre_id HAVING NumPeliculas > 3;
SELECT DISTINCT(CONCAT(first_name, ' ',last_name)) as Nombre FROM actors a INNER JOIN actor_movie am ON a.id = am.actor_id INNER JOIN movies m ON am.movie_id = m.id WHERE m.title LIKE 'La Guerra de las galaxias%';