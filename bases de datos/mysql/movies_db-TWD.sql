CREATE TEMPORARY TABLE TWD
SELECT e.id, e.created_at, e.updated_at, e.title, e.number, e.release_date, e.rating, se.number season_number,se.title season FROM episodes e
INNER JOIN seasons se ON e.season_id = se.id
INNER JOIN series s ON se.serie_id = s.id
WHERE s.title = 'The Walking Dead';

SELECT * FROM TWD WHERE season_number = 1;

SHOW INDEX FROM seasons;

CREATE INDEX seasons_release_idx
ON seasons (release_date);

SHOW INDEX FROM seasons;