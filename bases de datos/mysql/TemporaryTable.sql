CREATE TEMPORARY TABLE TWD 
	SELECT E.title episode, SEA.title season
	FROM episodes E
	INNER JOIN seasons SEA ON E.season_id = SEA.id
	INNER JOIN series SER ON SEA.serie_id = SER.id
	AND SER.title = "The Walking Dead";
	

	/* SELECT E.title episode, SEA.title season
	FROM episodes E, seasons SEA, series SER
	WHERE E.season_id = SEA.id
	AND SEA.serie_id = SER.id
	AND SER.title = "The Walking Dead"; */
    
SELECT episode, season
FROM TWD
WHERE season = "Primer Temporada";

SELECT *
FROM TWD;