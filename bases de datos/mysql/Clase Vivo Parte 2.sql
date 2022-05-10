use movies_db;

/* 1 */
SELECT 
	* 
FROM movies;

/* 2 */
select 
	first_name Name,
    last_name Lastname,
    rating Rating 
from actors;

/* 3 */
select 
	title Titulo 
from series;

/* 4 */
select 
	first_name Name, 
    last_name Lastname 
from actors 
where rating >= 7.5;

/* 5 */
select
	title Titulo,
    rating Rating,
    awards Premios
from movies
where rating >= 7.5
and awards > 2;

/* 6 */
select
	title Titulo,
    rating Rating
from movies
order by rating;

/* 7 */
select
	title Titulo
from movies
limit 3;

/* 8 */
select
	*
from movies
order by rating desc
limit 5;

/* 9 */
select
	*
from actors
limit 10;

/* 10 */
select
	title Titulo,
    rating Rating
from movies
where title LIKE '%Toy Story%';

/* 11 */
select
	*
from actors
where first_name LIKE 'Sam%';

/* 12 */
select
	title Titulo
from movies
where YEAR(release_date) between 2004 and 2008;

/* 13 */
select
	title Titulo
from movies
where rating > 3
and awards > 1
and YEAR(release_date) between 1988 and 2009;
