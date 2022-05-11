-- Consultas Avanzadas 

-- 1)
INSERT INTO movies (title, rating, awards, release_date, length, genre_id) 
VALUES ("Rocky", 10, 1, NOW(), 180, null);

-- 2) 
INSERT INTO genres (name, ranking, active) VALUES ("nuevo genero", 13, 1);

-- 3) 
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE ranking = 13)
WHERE title = "Rocky";

-- 4)
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = "Rocky")
WHERE id = 1;

-- 5)
CREATE TEMPORARY TABLE Temp_Movies
SELECT * FROM movies;

SELECT count(1) FROM Temp_Movies;

-- 6)
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Temp_Movies
WHERE awards < 5;

SELECT count(1) FROM Temp_Movies;

-- 7)
SELECT distinct g.* FROM genres g
inner join movies m ON m.genre_id = g.id;

-- 8)
SELECT a.* FROM actors a
INNER JOIN movies m ON m.id	= a.favorite_movie_id
WHERE m.awards > 3;

-- 9)
CREATE INDEX index_title_movies
ON movies (title);

-- 10)
SHOW INDEX FROM movies;

-- 11)
-- Depende, si contamos con una gran cantidad de consultas aporta una mejora notable. Pero si
-- llega a crecer mucho la tabla no es recomendable que cuente con muchos indices.

-- 12)
-- Se podría realizar con la tabla genres ya que es muy dificil que se actualice.