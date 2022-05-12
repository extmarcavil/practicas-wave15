SET SQL_SAFE_UPDATES = 0;
INSERT INTO `movies_db`.`movies` (`title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) 
	VALUES ('Endgame', '9.4', '10', '2019-04-26', '182', '3');

INSERT INTO `movies_db`.`genres` (`created_at`,`name`, `ranking`) 
	VALUES ('2022-05-12','War', '13');

UPDATE `movies_db`.`movies` 
SET `genre_id` = '13' 
WHERE (`id` = '22');

UPDATE `movies_db`.`actors` 
SET `favorite_movie_id` = '22' 
WHERE (`id` = '3');

CREATE TEMPORARY TABLE movies_copy
SELECT m.id, m.created_at, m.updated_at, m.title, m.rating, m.awards, m.release_date, m.length, m.genre_id 
FROM movies m;

SELECT * FROM movies_copy;

DELETE FROM movies_copy mc
WHERE mc.awards < 5;

SELECT * FROM movies_copy;

SELECT g.id, g.name, COUNT(g.id) cantidad FROM genres g
INNER JOIN movies m ON m.genre_id = g.id
GROUP BY g.id
HAVING cantidad>=1;

SELECT a.first_name, a.last_name FROM actors a
INNER JOIN movies m ON m.id= a.favorite_movie_id
WHERE m.awards >3;

SHOW INDEX FROM movies;
CREATE INDEX movies_title_idx
ON movies (title);
SHOW INDEX FROM movies;