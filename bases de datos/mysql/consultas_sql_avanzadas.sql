use movies_db;

-- 01)
-- Mostrar el título y el nombre del género de todas las series.

select s.title, g.name 
from series s inner join genres g;

-- 02)
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

select e.title, a.first_name, a.last_name
from episodes e 
inner join actor_episode ae on e.id = ae.episode_id
inner join actors a on ae.actor_id = a.id;

-- 03)
-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

select s.title, count(s.title) as total_temporadas
from series s inner join seasons ss on s.id = ss.serie_id
group by s.title;

-- 04)
-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.

select g.name, count(g.name) as total_peliculas
from genres g inner join movies m on g.id = m.genre_id
group by g.name
having total_peliculas >= 3;

-- 05)
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
-- la guerra de las galaxias y que estos no se repitan.

select distinct a.first_name, a.last_name
from actors a
inner join actor_movie am on a.id = am.actor_id
inner join movies m on am.movie_id = m.id
where m.title like "La Guerra de las galaxias%";