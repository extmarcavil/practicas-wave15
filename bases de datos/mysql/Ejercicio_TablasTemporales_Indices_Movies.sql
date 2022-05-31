-- Ejercicio 1
DROP TEMPORARY TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD (episode_title varchar(50), episode_number int, season_number int);
INSERT INTO TWD 
SELECT e.title, e.number, s.number
FROM episodes e JOIN seasons s ON e.season_id = s.id
WHERE season_id IN (
	SELECT id FROM seasons
    WHERE serie_id = (
		SELECT id FROM series
        WHERE title = "The Walking Dead"));
        
SELECT * FROM TWD
WHERE season_number = 1;

-- Ejercicio 2
CREATE INDEX movies_date
ON movies (release_date);

EXPLAIN SELECT release_date FROM movies;