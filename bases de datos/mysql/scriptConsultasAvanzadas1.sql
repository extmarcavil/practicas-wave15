#Ejercicio 1
create temporary table TWD(
title varchar(50),
season_number int
);

insert into TWD
select e.title, se.number
from series s
join seasons se on se.serie_id = s.id
join episodes e on e.season_id = se.id
where s.title = 'The walking dead';

select * 
from twd 
where season_number = 1;


#Ejercicio 2
show index from movies
create index ratingIndex on movies(rating)
explain select rating from movies where rating = 5.7