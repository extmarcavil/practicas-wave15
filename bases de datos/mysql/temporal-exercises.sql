SELECT * FROM series as se
INNER JOIN seasons as s 
ON se.id = s.serie_id 
INNER JOIN episodes as e 
ON s.id = e.season_id
WHERE se.title = 'The Walking Dead'


CREATE TEMPORARY TABLE TWD(
SELECT e.title, s.number FROM series as se
INNER JOIN seasons as s 
ON se.id = s.serie_id 
INNER JOIN episodes as e 
ON s.id = e.season_id
WHERE se.title = 'The Walking Dead');


SELECT * FROM TWD 
WHERE number = 1; 

INSERT INTO movies VALUES( 22, '2022-05-11', '2022-05-11', '#Aiuda', 9.0, 3, '2022-04-04', 2, null)



INSERT INTO genres VALUES(13, '2022-05-11','2022-05-11', 'aiuda', 13, 1 ); 



UPDATE movies
SET genre_id = 13
WHERE movies.id = 22;

UPDATE actors
SET favorite_movie_id = 22
WHERE actors.id = 1; 

CREATE TEMPORARY TABLE tempMovies(
SELECT * FROM MOVIES); 

DELETE  FROM tempMovies
WHERE awards < 5; 

SET SQL_SAFE_UPDATES = 0;

SELECT * FROM genres 
INNER JOIN Movies
ON genres.id = movies.id
GROUP BY genres.id
HAVING COUNT(genres.active); 

SELECT * FROM actors 
INNER JOIN movies as m 
ON actors.favorite_movie_id = m.id
WHERE m.awards > 3; 


SHOW INDEX FROM MOVIES