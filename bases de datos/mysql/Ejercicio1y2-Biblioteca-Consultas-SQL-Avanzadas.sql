-- EJERCICIO 1
-- Listar los datos de los autores.
SELECT *
FROM biblioteca.autor;

-- Listar nombre y edad de los estudiantes
SELECT est.nombre, est.edad
FROM biblioteca.estudiante est;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT est.*
FROM biblioteca.estudiante est
WHERE est.carrera = "Informatica";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT aut.*
FROM biblioteca.autor aut
WHERE aut.nacionalidad = "Francesa" OR aut.nacionalidad = "Italiana" ;

-- ¿Qué libros no son del área de internet?
SELECT lib.*
FROM biblioteca.libro lib
WHERE lib.area != "Internet";

-- Listar los libros de la editorial Salamandra.
SELECT lib.*
FROM biblioteca.libro lib
WHERE lib.editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT est2.*
FROM biblioteca.estudiante est2 
WHERE est2.edad > (
	SELECT avg(est.edad)
    FROM biblioteca.estudiante est);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT est.*
FROM biblioteca.estudiante est
WHERE est.apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT aut.nombre
FROM biblioteca.autor aut INNER JOIN biblioteca.libro_autor libaut
ON aut.id_autor = libaut.id_autor 
WHERE libaut.id_libro = 
	(SELECT lib.id_libro 
	FROM biblioteca.libro lib 
	WHERE lib.titulo = "El Universo: Guía de viaje");

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT lib.* 
FROM biblioteca.libro lib INNER JOIN biblioteca.prestamo prest
ON lib.id_libro = prest.id_libro
WHERE prest.id_lector =
	(SELECT est.id_lector 
    FROM biblioteca.estudiante est 
    WHERE est.nombre = "Filippo" AND est.apellido = "Galli");

-- Listar el nombre del estudiante de menor edad.
SELECT est.nombre FROM biblioteca.estudiante est 
WHERE est.edad = 
	(SELECT MIN(est2.edad) 
    FROM biblioteca.estudiante est2);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT est.nombre 
FROM biblioteca.estudiante est INNER JOIN biblioteca.prestamo prest
ON est.id_lector = prest.id_lector
WHERE prest.id_libro IN
	(SELECT lib.id_libro
    FROM biblioteca.libro lib 
    WHERE lib.area LIKE "%Base de Datos%");

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT lib.*
FROM biblioteca.libro lib INNER JOIN biblioteca.libro_autor libaut
ON lib.id_libro = libaut.id_libro
WHERE libaut.id_autor = 
	(SELECT aut2.id_autor 
    FROM biblioteca.autor aut2 
    WHERE aut2.nombre = "J. K. Rowling");

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT lib.titulo
FROM biblioteca.libro lib INNER JOIN biblioteca.prestamo prest
ON lib.id_libro = prest.id_libro
WHERE prest.fecha_devolucion = "2021-07-16";


-- EJERCICIO 2
CREATE DATABASE IF NOT EXISTS biblioteca;

SET SQL_SAFE_UPDATES = 0;

-- create table: libro
CREATE TABLE IF NOT EXISTS biblioteca.libro (
	id_libro int,
    titulo varchar(50),
    editorial varchar(50),
    area varchar(50),
    PRIMARY KEY (id_libro)
);

-- create table: estudiante
CREATE TABLE IF NOT EXISTS biblioteca.estudiante (
	id_lector int,
    nombre varchar(50),
    apellido varchar(50),
    direccion varchar(50),
    carrera varchar(50),
    edad int,
    PRIMARY KEY (id_lector)
);

-- create table: autor
CREATE TABLE IF NOT EXISTS biblioteca.autor (
	id_autor int,
    nombre varchar(50),
    nacionalidad varchar(50),
    PRIMARY KEY (id_autor)
);

-- create table: libro_autor
CREATE TABLE IF NOT EXISTS biblioteca.libro_autor (
	id_libro_autor int,
    id_libro int,
    id_autor int,
    PRIMARY KEY (id_libro_autor),
    FOREIGN KEY (id_libro) REFERENCES biblioteca.libro(id_libro),
    FOREIGN KEY (id_autor) REFERENCES biblioteca.autor(id_autor)
);

-- create table: prestamo
CREATE TABLE IF NOT EXISTS biblioteca.prestamo (
	id_prestamo int,
    fecha_prestamo date,
    fecha_devolucion date,
    id_lector int,
    id_libro int,
    devuelto date,
    PRIMARY KEY (id_prestamo),
    FOREIGN KEY (id_libro) REFERENCES biblioteca.libro(id_libro),
    FOREIGN KEY (id_lector) REFERENCES biblioteca.estudiante(id_lector)
);

INSERT INTO biblioteca.autor VALUES 
	(1, "J. K. Rowling", "Inglesa"),
	(2, "Abraham Silberschatz", "Israeli"),
	(3, "Umberto Eco", "Italiana"),
	(4, "Michel Houellebecq", "Francesa"),
	(5, "Julio Verne", "Frances");

INSERT INTO biblioteca.estudiante VALUES
	(1, "Tomas", "Ravelli", "15 de agosto - 495", "Informatica", 24),
	(2, "Juan", "Ravelli", "25 de mayo - 201", "Filosofia", 20),
	(3, "Mario", "Ravelli", "9 de julio - 300", "Letras", 16),
	(4, "Filippo", "Galli", "San martin - 900", "Informatica", 12),
	(5, "Jose","Ravelli", "15 de agosto - 102", "Matematica", 10)
;

INSERT INTO biblioteca.libro VALUES
	(1, "Harry Potter - La piedra filosofal", "Editorial 1", "Novela"),
	(2, "Fundamentos de bases de datos", "Editorial 2",  "Base de datos"),
	(3,  "El péndulo de Foucault", "Editorial 3", "Novela"),
	(4,  "El mapa y el territorio", "Editorial 4", "Novela"),
	(5,  "Veinte mil leguas de viaje submarino", "Editorial 5", "Novela")
;

INSERT INTO biblioteca.libro_autor VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 4, 4),
	(5, 5, 5);

INSERT INTO biblioteca.prestamo VALUES
	(1, "2021-01-01", "2021-07-16", 1, 2, "2021-07-10"),
	(2, "2021-01-01", "2021-07-16",2, 1, "2021-07-10"),
	(3, "2021-01-01", "2021-07-16",3, 3, "2021-07-10"),
	(4, "2021-01-01", "2021-07-16",4, 4, "2021-07-10"),
	(5, "2021-01-01", "2021-07-17",5, 5, "2021-07-10");


