-- Ejercicio 1
INSERT INTO `movies_db`.`movies` (`id`, `title`, `rating`, `awards`, `release_date`, `length`, `genre_id`) 
VALUES ('22', 'Equilibrium', '8.0', '1', '2008-02-10 00:00:00', '120', '4');

-- Ejercicio 2
INSERT INTO `movies_db`.`genres` (`id`, `created_at`, `name`, `ranking`, `active`) 
VALUES ('13', '2022-05-12 00:00:00', 'Anime', '13', '1');

-- Ejercicio 3
UPDATE `movies_db`.`movies` 
SET `genre_id` = '13' 
WHERE (`id` = '22');

-- Ejercicio 4
UPDATE `movies_db`.`actors` 
SET `favorite_movie_id` = '22' 
WHERE (`id` = '34');

-- Ejercicio 5
DROP TEMPORARY TABLE IF EXISTS moviesTemp;
CREATE TEMPORARY TABLE moviesTemp
(id int, created datetime, updated datetime, title varchar(100), rating decimal(10,1), awards int, release_time datetime, lenght int, genre_id int);
INSERT INTO moviesTemp 
	SELECT * FROM movies;
SELECT * FROM moviesTemp;

-- Ejercicio 6
DELETE FROM moviesTemp
WHERE awards < 5;

-- Ejercicio 7
SELECT g.name 
FROM genres g JOIN movies m ON g.id = m.genre_id
GROUP BY g.name;

-- Ejercicio 8
SELECT a.* 
FROM actors a JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Ejercicio 9
CREATE INDEX titles ON movies (title);

-- Ejercicio 10
EXPLAIN SELECT title FROM movies;

