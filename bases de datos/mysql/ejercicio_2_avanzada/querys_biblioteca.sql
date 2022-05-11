USE biblioteca;
SELECT * FROM autor;
SELECT nombre, edad FROM estudiante;
SELECT * FROM estudiante WHERE Carrera = 'Sistemas';
SELECT * FROM autor WHERE nacionalidad = 'Francia' OR nacionalidad  = 'Italia';
SELECT * FROM libro WHERE Area != 'Internet';
SELECT * FROM libro WHERE Editorial = 'Salamandra';
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

SELECT nombre FROM autor INNER JOIN libroAutor ON autor.idAutor = libroAutor.idAutor INNER JOIN libro ON libro.idLibro = libroAutor.idLibro WHERE Titulo = 'El Universo: Guía de viaje';
SELECT Titulo FROM libro INNER JOIN prestamo ON prestamo.idLibro = libro.idLibro INNER JOIN estudiante ON estudiante.idLector = prestamo.idLector WHERE nombre = 'Fillippo' AND apellido = 'Galli';

SELECT nombre FROM estudiante ORDER BY edad LIMIT 1;
SELECT nombre FROM estudiante INNER JOIN prestamo ON estudiante.idLector = prestamo.idLector  INNER JOIN libro ON prestamo.idLibro = libro.idLibro WHERE Area = 'Base de Datos';
SELECT Titulo FROM libro INNER JOIN libroAutor ON libro.idLibro = libroAutor.idLibro INNER JOIN autor ON autor.idAutor = libroAutor.idAutor WHERE nombre = 'J.K. Rowling';
SELECT Titulo FROM libro INNER JOIN prestamo ON prestamo.idLibro = libro.idLibro WHERE FechaDevolucion = '2021-07-16';