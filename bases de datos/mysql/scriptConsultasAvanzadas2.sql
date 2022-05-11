#Agregar pelicula a tabla movies
insert into movies values (22, null,null, 'Toy story 3', 10.0, 5, 20100603, 103, 7);

#agregar un genero a tabla genres
insert into genres values(13, 20100510, null, 'Ficcion', 13, 1);

#Asociar pelicula de punto 1 al punto 2
SET SQL_SAFE_UPDATES = 0;
update movies set genre_id = 13 where id = 22;

#modificar tabla actores para que un actor tenga pelicula favorita toy story 3
update actors set favorite_movie_id = 22 where id = 45;

#crear tabla temporal copia de tabla movies
create temporary table moviesTemporal(
id int,
created_at timestamp,
updated_at timestamp,
title varchar(500),
rating decimal(3,1),
awards int,
release_date datetime,
lenght int,
genre_id int
);

insert into moviesTemporal
select * from movies;

#Eliminar de la temporal todas las peli de menos de 5 premios
SET SQL_SAFE_UPDATES = 0;
delete from moviestemporal where awards < 5;

#Obtener lista de generos que tengan minimo una pelicula
select genre_id, m.title
from genres g
join movies m on m.genre_id = g.id
group by m.genre_id, m.title
having count(m.genre_id) >= 1;

#Obtener lista de actores cuya pelicula haya ganado mas de 3 awards
select * 
from actors a
join actor_movie am on am.actor_id = a.id
join movies m on m.id = am.movie_id
where m.awards > 3;

#crear indice sobre el nombre en la tabla movies
create index indiceNombre on movies(title);

#Chequear que el indice fue creado
show index from movies;

#Analisis de index
explain select title from movies where title = 'mi pobre angelito'