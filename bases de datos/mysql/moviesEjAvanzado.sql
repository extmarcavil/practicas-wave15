-- Mostrar el título y el nombre del género de todas las series.
select s.title, g.name from series s inner join genres g on s.genre_id= g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name from episodes e inner join actor_episode ae on ae.episode_id= e.id inner join actors a on ae.actor_id=a.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(t.id) as 'Total Seasons' from series s inner join seasons t on t.serie_id=s.id GROUP BY t.serie_id; 

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(m.id) as 'Movies Per Genre' from movies m inner join genres g on g.id = m.genre_id group by m.genre_id having count(m.id)>3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name from actors a where not exists ((select m.id from movies m where m.title like 'La Guerra de las galaxias:%' and m.id not in (select am.movie_id from actor_movie am where am.actor_id=a.id)));