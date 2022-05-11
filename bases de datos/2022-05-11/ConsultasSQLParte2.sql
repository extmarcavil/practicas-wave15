USE movies_db;
SELECT * FROM movies;
SELECT first_name, last_name,rating FROM actors;
SELECT title AS Titulo FROM series AS Series;
SELECT first_name, last_name, rating FROM actors WHERE rating > 7.5;
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;
SELECT title, rating FROM movies ORDER BY title;
SELECT title FROM movies LIMIT 3;
SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;
SELECT CONCAT (first_name, ' ', last_name) AS Name FROM actors LIMIT 10;
SELECT title, rating FROM movies WHERE title LIKE 'Toy Story%';
SELECT first_name, last_name FROM actors WHERE first_name = 'Sam';
SELECT title, release_date FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';
SELECT title FROM movies 
	WHERE rating > 3
		AND awards > 1
        AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
	ORDER BY rating DESC