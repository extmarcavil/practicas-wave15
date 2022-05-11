CREATE DATABASE IF NOT EXISTS empresa_db;

SET SQL_SAFE_UPDATES = 0;

#create table: departamento
CREATE TABLE IF NOT EXISTS empresa_db.departamento (
	depto_nro varchar(255),
    nombre_depto varchar(50),
    localidad varchar(50),
    primary key(depto_nro)
);

#create table: empleado
CREATE TABLE IF NOT EXISTS empresa_db.empleado (
	cod_emp varchar(255),
    nombre varchar(50),
    apellido varchar(50),
    puesto varchar(50),
    fecha_alta date,
    salario float,
    comision float,
    depto_nro varchar(255),
    primary key(cod_emp),
    FOREIGN KEY (depto_nro) REFERENCES empresa_db.departamento(depto_nro)
);

# load data
INSERT INTO empresa_db.departamento values("D-000-1", "Software", "Los Tigres");
INSERT INTO empresa_db.departamento values("D-000-2", "Sistemas", "Guadalupe");
INSERT INTO empresa_db.departamento values("D-000-3", "Contabilidad", "La Roca");
INSERT INTO empresa_db.departamento values("D-000-4", "Ventas", "Plata");
INSERT INTO empresa_db.empleado values("E-0001", "César", "Piñero", "Vendedor", "2018-05-12", 80000 ,15000, "D-000-4");
INSERT INTO empresa_db.empleado values("E-0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", 140000, 0, "D-000-2");
INSERT INTO empresa_db.empleado values("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", 185000, 0, "D-000-3");
INSERT INTO empresa_db.empleado values("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, "D-000-4");
INSERT INTO empresa_db.empleado values("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, "D-000-4");
INSERT INTO empresa_db.empleado values("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", 190000, 0, "D-000-3");
INSERT INTO empresa_db.empleado values("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-08-02", 60000, 0, "D-000-1");


# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT emp.nombre, emp.puesto, dto.localidad
FROM empresa_db.departamento dto INNER JOIN empresa_db.empleado emp
ON dto.depto_nro = emp.depto_nro;

# Visualizar los departamentos con más de cinco empleados.
SELECT dpto.*
FROM empresa_db.empleado emp INNER JOIN empresa_db.departamento dpto
ON dpto.depto_nro = emp.depto_nro
GROUP BY emp.depto_nro
HAVING count(*) > 5;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT emp2.nombre, emp2.salario, dpto.nombre_depto
FROM empresa_db.empleado emp2 INNER JOIN empresa_db.departamento dpto
ON emp2.depto_nro = dpto.depto_nro
WHERE emp2.puesto in (
	SELECT emp.puesto
	FROM empresa_db.empleado emp
	WHERE emp.nombre = "Mito" AND emp.apellido = "Barchuk")
AND emp2.nombre != "Mito" AND emp2.apellido != "Barchuk";

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT emp.*
FROM empresa_db.empleado emp INNER JOIN empresa_db.departamento dpto
ON emp.depto_nro = dpto.depto_nro
WHERE dpto.nombre_depto = "Contabilidad"
ORDER BY emp.nombre ASC;

# Mostrar el nombre del empleado que tiene el salario más bajo
SELECT emp2.* 
FROM empresa_db.empleado emp2
WHERE emp2.salario IN (
	SELECT MIN(emp.salario)
	FROM empresa_db.empleado emp);

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT emp2.* 
FROM empresa_db.empleado emp2 JOIN empresa_db.departamento dpto2
ON emp2.depto_nro = dpto2.depto_nro
WHERE emp2.salario IN (
	SELECT MAX(emp.salario)
	FROM empresa_db.empleado emp JOIN empresa_db.departamento dpto
	ON emp.depto_nro = dpto.depto_nro
	WHERE dpto.nombre_depto = "Ventas")
AND dpto2.nombre_depto = "Ventas";

