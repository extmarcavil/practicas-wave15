# EJERCICIO 3
# a - create database
CREATE DATABASE IF NOT EXISTS empresa_internet;

SET SQL_SAFE_UPDATES = 0;

#create table: client
CREATE TABLE IF NOT EXISTS empresa_internet.client (
	client_id int,
    dni varchar(50),
    first_name varchar(50),
    last_name varchar(50),
    birthdate date,
    province varchar(50),
    city varchar(50),
    primary key(client_id)
);

#create table: plant_internet
CREATE TABLE IF NOT EXISTS empresa_internet.plan_internet (
	plan_id int,
    speed float,
    price float,
    discount float,
    primary key (plan_id)
);

#create table: client_planinternet with FK (many to many relationship)
CREATE TABLE IF NOT EXISTS empresa_internet.client_planinternet (
	client_planinternet_id int,
    client_id int,
    plan_id int,
    primary key (client_planinternet_id),
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (plan_id) REFERENCES plan_internet(plan_id)
);

# b - clean tables
DELETE FROM empresa_internet.client_planinternet;
DELETE FROM empresa_internet.client;
DELETE FROM empresa_internet.plan_internet;

# b - load client data
INSERT INTO empresa_internet.client VALUES
	(1, "11111111", "Cliente 1", "Apellido 1", "1998-04-13", "Santa Fe", "Marcelino Escalada"),
	(2, "2222222", "Cliente 2", "Apellido 2", "1996-04-13", "Santa Fe", "San Justo"),
	(3, "3333333", "Cliente 1", "Apellido 1", "1994-04-13", "Santa Fe", "Santa Fe"),
	(4, "4444444", "Cliente 1", "Apellido 1", "1992-04-13", "Santa Fe", "Rosario"),
	(5, "5555555", "Cliente 1", "Apellido 1", "1990-04-13", "Santa Fe", "Santo Tome"),
	(6, "6666666", "Cliente 1", "Apellido 1", "1988-04-13", "Buenos Aires", "Junin"),
	(7, "7777777", "Cliente 1", "Apellido 1", "1986-04-13", "Buenos Aires", "CABA"),
	(8, "88888888", "Cliente 1", "Apellido 1", "1984-04-13", "Buenos Aires", "La Plata"),
	(9, "9999999", "Cliente 1", "Apellido 1", "1982-04-13", "Buenos Aires", "Ezeiza"),
	(10, "10101010", "Cliente 1", "Apellido 1", "2000-04-13", "Buenos Aires", "Baradero");

# b - load plan data
INSERT INTO empresa_internet.plan_internet VALUES
	(1, 10, 1000, 0),
	(2, 25, 2000, 0),
	(3, 50, 2500, 0),
	(4, 100, 3000, 0),
	(5, 120, 4020, 0.05);

# c - load relationship data
INSERT INTO empresa_internet.client_planinternet VALUES
	(1, 1, 1),
	(2, 1, 5),
	(3, 2,3),
	(4, 3,2),
	(5, 4, 5);

# EJERCICIO 4
#--- QUERIES ---

# listar todos los clientes de la empresa
SELECT * 
FROM empresa_internet.client;

# listar todos los planes de la empresa
SELECT *
FROM empresa_internet.plan_internet;

# obtener la cantidad de planes que vendio la empresa
SELECT count(*) as total 
FROM empresa_internet.client_planinternet;

# listar nombre, apellido y ciudad de los clientes que viven en la provincia de Santa Fe
SELECT client.first_name, client.last_name, client.city 
FROM empresa_internet.client as client
WHERE client.province = "Santa Fe";


# listar nombre, apellido y ciudad de los clientes que viven en la provincia de Buenos Aires
SELECT client.first_name, client.last_name, client.city 
FROM empresa_internet.client as client
WHERE client.province = "Buenos Aires";


# listar dni, nombre y apellido de los clientes que viven en la ciudad de Marcelino Escalada
SELECT client.dni, client.first_name, client.last_name
FROM empresa_internet.client as client
WHERE client.city = "Marcelino Escalada";


# listar los clientes que nacieron antes de 1990
SELECT * FROM empresa_internet.client as client
WHERE client.birthdate < 1990-01-01;

# listar los clientes que nacieron despues de 1990
SELECT *
FROM empresa_internet.client as client
WHERE client.birthdate > 1989-31-12;

# listar los planes de la empresa ordenados por precio ascendentemente
SELECT *
FROM empresa_internet.plan_internet as plan
ORDER BY plan.price ASC;

#listar los planes que ofrece la empresa cuyo precio sea menor a 2000
SELECT *
FROM empresa_internet.plan_internet as plan
WHERE plan.price < 2000;

#listar los planes que ofrece la empresa y que poseen descuento
SELECT * FROM empresa_internet.plan_internet as plan
WHERE plan.discount > 0;

#obtener el plan con mayor velocidad
SELECT * 
FROM empresa_internet.plan_internet as plan
WHERE plan.speed = (SELECT max(plan2.speed) 
					FROM empresa_internet.plan_internet as plan2);

