-- Ejercicio 1

CREATE TEMPORARY TABLE TWD
select e.*, s.title as season_title
from series se
inner join seasons s on se.id = s.serie_id
inner join episodes e on s.id = e.season_id
WHERE se.title = "The Walking Dead";

SELECT * FROM TWD
WHERE season_title = "Primer Temporada";

-- Ejercicio 2
CREATE INDEX index_title_movies
ON movies (title);

SHOW INDEX FROM movies;
-- Se elige el titulo de la pelicula porque es un dato que se puede consultar varias veces.


