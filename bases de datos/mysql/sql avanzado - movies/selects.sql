-- Mostrar el título y el nombre del género de todas las series.
select m.title titulo, g.name
from movies m
inner join genres g on m.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title episodio,group_concat(concat(a.first_name,' ',a.last_name)) actores
from actor_episode ae
inner join actors a on ae.actor_id = a.id
inner join episodes e on ae.episode_id = e.id
group by e.title;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title,count(1)
from series s
inner join seasons s2 on s.id = s2.serie_id
group by s.title

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name,count(1) cont
from genres g
inner join movies m on g.id = m.genre_id
group by name
having cont>=3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select concat(a.first_name,' ',a.last_name) actor
from actor_movie
inner join movies m on actor_movie.movie_id = m.id
inner join actors a on actor_movie.actor_id = a.id
where upper(m.title) like '%GUERRA DE LAS GALAXIAS%'
group by actor
having count(1)=(select count(1)
                 from movies
                 where upper(title) like '%GUERRA DE LAS GALAXIAS%');