#Ejercicio 2
#En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
#Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
EXPLAIN SELECT * FROM series where title='Breaking Bad';

CREATE INDEX Idx_title ON series (title);


EXPLAIN SELECT * FROM series where title='Breaking Bad'

#se opto crear un indice en la tabla series en el campo title ,ya que para eficientar consultas por el title de una pelicula