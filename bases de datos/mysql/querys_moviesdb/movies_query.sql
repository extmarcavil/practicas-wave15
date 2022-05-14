#Ejercicio 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD(
episodio VARCHAR(60),
 numero_temporada int
 );

INSERT INTO TWD 
SELECT e.title AS episodio, se.number AS numero_temporada
FROM series s 
JOIN seasons se ON se.serie_id = s.id
JOIN episodes e ON e.season_id = se.id
WHERE s.title = "The walking dead";

SELECT * FROM TWD;

DROP TABLE TWD;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD 
WHERE numero_temporada = 1;


#Ejercicio 2
-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
SHOW INDEX FROM movies;

CREATE INDEX titleIndex ON movies(title);

EXPLAIN SELECT title FROM movies WHERE title LIKE "The walking dead";








