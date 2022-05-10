use movies_db;

-- 01)

select * from movies;

-- 02)

select first_name, last_name, rating from actors;

-- 03) 

select title as titulo from series;

-- 04) 

select first_name, last_name from actors where rating > 7.5;

-- 05)

select title, rating, awards from movies where rating > 7.5 and awards > 2; 

-- 06)

select title, rating from movies
order by rating asc;

-- 07)

select title from movies limit 3;

-- 08)

select title, rating from movies
order by rating desc
limit 5;

-- 09)

select * from actors limit 10;

-- 10)

select title, rating from movies
where title like '%Toy Story%';

-- 11)

select * from actors
where first_name like 'Sam%';

-- 12)

select title from movies
where release_date >= '2004-01-01' and release_date <= '2008-12-12';

-- 13)

select title from movies
where rating > 3 and awards > 1 and release_date >= '1988-01-01' and release_date <= '2009-12-12'
order by rating;