#Listar los datos de los autores
select * 
from autor;

#Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

#Que estudiantes pertenecen a la carrera Informatica?
select * 
from estudiante 
where carrera = 'informatica';

#Que autores son de nacionalidad francesa o italiana?
select * 
from autor
where nacionalidad = 'francia' or nacionalidad = 'italia';

#Que libros no son del area de Internet?
select * 
from libro
where area <> 'Internet';

#Listar los libros de la editorial salamandra
select * 
from libro
where editorial = 'salamandra';

#Listar los datos de los estudiantes cuya edad es mayor al promedio
select * 
from estudiante
where edad > (select avg(edad) from estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G
select nombre 
from estudiante 
where apellido like 'G%';

#Listar los autores del libro "El universo: guia de viaje"
select a.nombre
from libro l
join libroautor la on la.idLibro = l.idLibro
join autor a on a.idAutor = la.idAutor
where l.titulo = 'El universo: Guia de viaje';

#Que libros se prestaron al lector "Fillippo Galli"?
select l.titulo
from prestamo p
join libro l on l.idLibro = p.idLibro
join estudiante e on e.idLector = p.idLector
where e.nombre = 'Fillippo' and e.apellido = 'Galli';

#Listar el nombre del estudiante de menor edad
select nombre
from estudiante
order by edad
limit 1;

#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
select e.nombre
from prestamo p
join libro l on l.idLibro = p.idLibro
join estudiante e on e.idLector = p.idLector
where l.area = 'Base de Datos';

#listar los libros que pertenecen a la autora J.K. Rowling
select l.titulo
from libro l
join libroautor la on la.idLibro = l.idLibro
join autor a on a.idAutor = la.idAutor
where a.nombre = 'J.K. Rowling';

#Listar titulos de los libros que debian devolverse el 16/07/2021
select l.titulo
from libro l
join prestamo p on p.idLibro = l.idLibro
where fechaDevolucion = '20210716'