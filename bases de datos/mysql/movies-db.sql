SELECT * FROM MOVIES;
SELECT first_name, last_name, rating FROM ACTORS;
SELECT title as titulo FROM series as series;
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
SELECT title, rating, awards FROM movies WHERE awards > 2;
SELECT title, rating FROM movies ORDER by rating;
SELECT title FROM movies LIMIT 3;
SELECT * FROM movies ORDER by rating DESC LIMIT 5;
SELECT * FROM actors LIMIT 10;
SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';
SELECT * FROM actors WHERE first_name LIKE 'Sam%';
SELECT title FROM movies WHERE release_date BETWEEN '20O4-01-01' AND '2008-12-31';
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31' ORDER BY rating;