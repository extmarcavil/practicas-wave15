DROP TABLE TWD;
CREATE TEMPORARY TABLE TWD 
SELECT episodes.*, seasons.number temporada
FROM series 
INNER JOIN seasons on series.id = seasons.serie_id
INNER JOIN  episodes on seasons.id = episodes.season_id
WHERE series.title = "The Walking Dead" ;

SELECT * FROM TWD
WHERE temporada = 1
;

ALTER TABLE `movies_db`.`actors` 
DROP INDEX `first_name` ,
ADD INDEX `first_name` (`first_name` ASC) COMMENT '\'Buscar los actores con una mayor facilidad por nombre\'' VISIBLE;
;

SHOW INDEX FROM actors; 



