#Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
#y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.


#Crear tabla temporal TWD
CREATE TEMPORARY table TWD
SELECT 
    ep.*
FROM
    series AS se
        INNER JOIN
    seasons AS t ON se.id = t.serie_id
        INNER JOIN
    episodes AS ep ON ep.season_id = t.id
		WHERE
	se.title like '%The Walking Dead%';
    
#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT 
    *
FROM
    twd
        INNER JOIN
    seasons AS se ON se.id = twd.season_id
WHERE
    se.title LIKE '%Primer Temporada%';