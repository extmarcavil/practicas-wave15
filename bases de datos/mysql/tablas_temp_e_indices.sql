# *************************************************** EJERCICIO 1

#crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (nombre varchar(40), temporada varchar(40));
insert into TWD SELECT e.title nombre, se.title temporada FROM series s inner join seasons se on s.id = se.serie_id inner join episodes e on se.id = e.season_id 
where s.title LIKE '%The Walking Dead%';

#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE temporada LIKE '%Primer temporada%';

# *************************************************** EJERCICIO 2

#En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
EXPLAIN SELECT * FROM movies WHERE awards > 3; #antes de crear el indice
-- ALTER TABLE `movies_db`.`movies`;
-- ALTER TABLE `movies_db`.`movies` ALTER INDEX `movies_awards_index` VISIBLE;
EXPLAIN SELECT * FROM movies WHERE awards > 3; #despues de crear el indice

# *********************************** EJERCICIO CONSULTAS SQL AVANZADAS 2 (Tomando la base de datos movies_db.sql)

#Agregar una película a la tabla movies.
INSERT INTO movies values (null, null, null, 'La momia', 9.9, 7, '1999-05-07', 120, 4);

#Agregar un género a la tabla genres.
INSERT INTO genres values (null, '2022-05-11', null, 'sql', 15, 1);

#Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies set genre_id = 15 where id = 26;

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors set favorite_movie_id = 26 where id = 3;

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp (id int Primary key not null AUTO_INCREMENT, created_at timestamp, updated_at timestamp, title varchar(500),
rating decimal(3,1), awards int, release_date datetime, length int, genre_id int);
insert into movies_temp SELECT * FROM movies; 

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;
select * from movies_temp;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT GEN.NAME FROM GENRES GEN LEFT JOIN MOVIES MOV ON MOV.GENRE_ID = GEN.ID WHERE MOV.ID IS NOT NULL;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ACT.FIRST_NAME, ACT.LAST_NAME FROM ACTORS ACT INNER JOIN MOVIES MOV ON ACT.FAVORITE_MOVIE_ID = MOV.ID WHERE MOV.AWARDS > 3;

#Crear un índice sobre el nombre en la tabla movies.
EXPLAIN SELECT * FROM MOVIES WHERE TITLE = 'AVATAR'; -- CONSULTA ANTES DE CREAR EL ÍNDICE, ANALIZA 21 FILAS.
CREATE INDEX movies_title_index ON MOVIES (title);

#Chequee que el índice fue creado correctamente.
EXPLAIN SELECT * FROM MOVIES WHERE TITLE = 'AVATAR'; -- CONSULTA LUEGO DE CREAR EL ÍNDICE, ANALIZA SÓLO 1 FILA, OPTIMIZÓ EL TIEMPO DE CONSULTA.

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- La creación de índices haría una mejora notable en la base de datos movies en caso de que esta crezca en cuanto a registros. 
-- En caso de que tengamos muchas más películas cargadas en la tabla movies, por ejemplo, al crear éstos se acortaría y optimizarían los tiempos de las consultas.

# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Se podría crear también en la tabla de actores, por el mismo motivo que en la respuesta anterior.
