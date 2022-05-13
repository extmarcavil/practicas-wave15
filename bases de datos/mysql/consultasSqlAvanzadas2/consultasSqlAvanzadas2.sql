/*
1) Agregar una película a la tabla movies
*/
insert into movies values (22, null, null, "Pinocho", 8.4, 2, "1940-02-07", 88, 10);

/*
2) Agregar un género a la tabla genres.
*/
insert into genres values(13, "2022-05-09", null, "Clasicos Disney", 13, 1);

/*
3) Asociar a la película del punto 1. con el género creado en el punto 2.
*/
update movies set genre_id = 13 where id = 22;

/*
4) Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
*/
update actors set favorite_movie_id = 22 where id = 3;

/*
5) Crear una tabla temporal copia de la tabla movies.
*/
create temporary table movies_temporary select * from movies;

/*
6) Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
*/
delete from movies_temporary where awards < 5;

/*
7) Obtener la lista de todos los géneros que tengan al menos una película.
*/
select distinct g.* from genres g 
left join movies m on m.genre_id = g.id;

/*
8) Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
*/
select a.* from actors a 
join movies m on a.favorite_movie_id = m.id
where m.awards;

/*
9) Crear un índice sobre el nombre en la tabla movies.
*/
create index title_idx on movies(title);

/*
10) Chequee que el índice fue creado correctamente.
*/
explain select * from movies where title = "Pinocho";

/*
11) En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
Sí, ya que nos permitiria hacer consultas mas rapidas y faciles de buscar.
*/

/*
12) ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
Crearía un indice en la tabla de actores ya que es usada en varias otras tablas y nos va a permitir agilizar las consultas.
*/



