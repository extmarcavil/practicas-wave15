-- Creación de Tablas Temporales e Índices

-- Crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
SELECT e.id, e.created_at, e.updated_at, e.title, e.number, e.release_date, e.rating, se.number season_number,se.title season FROM episodes e
INNER JOIN seasons se ON e.season_id = se.id
INNER JOIN series s ON se.serie_id = s.id
WHERE s.title = 'The Walking Dead';
 

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE season_number = 1;

-- Seleccionar una tabla y crearle un indice
SHOW INDEX FROM seasons;

CREATE INDEX seasons_release_idx
ON seasons (release_date);

SHOW INDEX FROM seasons;

-- Crearia un indice por el campo release de la tabla season 
-- porque puede ayudar a mejorar los tiempos en consultas que usen por ejemplo seasons con relese entre 2000 y 2005
-- además ya estaban creados indices para la PK y FK de la tabla.