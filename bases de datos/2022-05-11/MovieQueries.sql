USE movies_db;

SELECT s.title, g.name
FROM series AS s INNER JOIN genres AS g
ON g.id = s.genre_id;
    
SELECT e.title, CONCAT(a.first_name, ' ', a.last_name) AS name
FROM episodes as e
JOIN actor_episode ON e.id = actor_episode.episode_id
JOIN actors as a ON a.id = actor_episode.actor_id;

SELECT s.title, COUNT(seasons.serie_id) AS Seasons
FROM series AS s
JOIN seasons ON s.id = seasons.serie_id
GROUP BY s.title;

SELECT g.name, COUNT(m.genre_id) as Total
FROM genres AS g
JOIN movies AS m on g.id = m.genre_id
GROUP BY g.name
HAVING Total >= 3;

SELECT COUNT(*), mo.title
FROM movies mo INNER JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY title;

SELECT DISTINCT
	a.first_name, a.last_name FROM actors a
INNER JOIN actor_movie am ON am.actor_id = a.id
INNER JOIN movies m ON am.movie_id = m.id WHERE m.title LIKE 'La Guerra de las galaxias%';
