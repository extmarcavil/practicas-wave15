-- Se elige la columna rating ya que es probable que haga consultas por esta columna para mostrar
-- que peliculas tuvieron mayor exito

CREATE INDEX index_rating
ON movies (rating);