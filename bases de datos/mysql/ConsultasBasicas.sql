#Mostrar todos los registros de la tabla de movies
select * 
from movies;

#Mostrar el nombre, apellido y rating de todos los actores
select first_name, last_name, rating 
from actors;

#Mostrar el titulo de todas la series y usar alias para que tanto el nombre de la tabla como el campo esten en español
select title titulo 
from series serie;

#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5
select * 
from actors 
where rating > 7.5;

#Mostrar el titulo de las peliculas, el rating y los premios de las peliculas con un rating mayor a 7.5 y con mas de dos premios
select title, rating, awards 
from movies 
where rating > 7.5 and awards > 2;

#Mostrar el titulo de las peliculas y el rating ordenadas por rating en forma ascendente
select title, rating 
from movies
order by rating asc;

#Mostrar los titulos de las primer tres peliculas en la base de datos
select title 
from movies 
limit 3;

#Mostrar el top 5 de las peliculas con mayor rating
select * 
from movies 
order by rating desc
limit 5;

#Listar los primeros 10 actores
select * 
from actors 
limit 10;

#Mostrar el titulo y rating de todas las peliculas cuyo titulo sea de Toy Story
select title, rating from movies where title like '%toy story%';

#Mostrar a todos los actores cuyos nombres empiezan con Sam
select * 
from actors
where first_name like 'sam%';

# Mostrar el titulo de las peliculas que salieron entre el 2004 y 2008
select title 
from movies
where release_date between 20040101 and 20081231;

#Traer el titulo de las peliculas con el rating mayor a 3, con mas de 1 premio y con fecha de lanzamiento entre
#el año 1998 al 2009. Ordenar los resultados por rating
select title
from movies 
where rating > 3 and awards > 1 and release_date between 19980101 and 20091231
order by rating