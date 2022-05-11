
--1 Listar los datos de los autores.
select * from autor;
--2 Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;
--3 ¿Qué estudiantes pertenecen a la carrera informática?
select nombre from estudiante where carrera = "Informatica";
--4 ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad ="Francia" or nacionalidad = "Italia";
--5 ¿Qué libros no son del área de internet?
select * from libro where area<>"Internet";
--6 Listar los libros de la editorial Salamandra.
select * from libro where editorial="Salamandra";
--7 Listar los datos de los estudiantes cuya edad es mayor al promedio.
select nombre from estudiante where edad > (select avg(edad) from estudiante);
--8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select * from estudiante where apellido like "G%";
--9 Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select nombre from autor a inner join libroautor la on a.idAutor=la.idAutor inner join libro l on la.idLibro=l.idLibro
where l.titulo="El Universo: Guía de viaje";
--10 ¿Qué libros se prestaron al lector “Filippo Galli”?
select nombre from autor a inner join libroautor la on a.idAutor=la.idAutor inner join libro l on la.idLibro=l.idLibro
inner join prestamo p on l.idLibro = p.idLibro inner join estudiante e on p.idLector=e.idLector
where e.nombre="Filipo Galli";
--11 Listar el nombre del estudiante de menor edad.
select nombre from estudiante where edad=(select min(edad) from estudiante)
--12 Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre from estudiante e inner join prestamo p on e.idLector=p.idLector
inner join libro l on l.idLibro=p.idLibro where l.area="Base de Datos"
--13 Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* from autor a inner join libroautor la on a.idAutor=la.idAutor inner join libro l on la.idLibro=l.idLibro
where a.nombre="J.K Rowling";
--14 Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from prestamo p inner join libro l on p.idLibro=l.idLibro where p.fechaDevolucion="2021-07-16";