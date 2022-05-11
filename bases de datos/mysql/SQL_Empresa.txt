-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
select Empleado.nombre, Empleado.puesto, Departamento.localidad
from Empleado inner join Departamento
on Empleado.depto_nro = Departamento.depto_nro
where Empleado.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados
select Dep.*
from Departamento as Dep join Empleado E
on Dep.depto_nro = E.depto_nro
group by E.depto_nro
having count(*) > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’
select e.nombre, e.salario, e.puesto, d.nombre_depto
from Empleado e join Departamento d
on e.depto_nro = d.depto_nro
where e.puesto = (select puesto from Empleado where nombre = "Mito");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre
select e.*
from Empleado e join Departamento d
on e.depto_nro = d.depto_nro
where d.nombre_depto = "Contabilidad"
order by e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo
select e.nombre
from Empleado e 
where e.salario = (select min(Empleado.salario) from Empleado);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
select e.*
from Empleado e join Departamento d
on e.depto_nro = d.depto_nro
where d.nombre_depto = "Ventas"
and e.salario = (select max(Empleado.salario) from Empleado where Empleado.depto_nro = d.depto_nro);