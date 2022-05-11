USE movies_db;
-- Ejercicio 1
CREATE TEMPORARY TABLE TWD
SELECT e.* FROM episodes e
JOIN seasons s
ON e.season_id = s.id
WHERE s.serie_id = 3;
SELECT * FROM TWD
WHERE s.`number` = 1;
-- Ejercicio 2
-- Justificación: se crea un índice en la columna release_date porque se recibirán consultas frecuentes en base a dicho campo
-- y no suele ser actualizado
CREATE INDEX releaseDateIdx ON movies(release_date);
EXPLAIN SELECT * FROM movies WHERE release_date > “2005-01-01”