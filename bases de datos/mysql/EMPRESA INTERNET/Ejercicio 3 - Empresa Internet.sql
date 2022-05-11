-- EJERCICIO 3 
-- a) Se solicita crear una nueva base de datos llamada “empresa_internet”. 
CREATE DATABASE empresa_internet;
use empresa_internet;

CREATE TABLE if not exists Pais(
		idPais int not null auto_increment,
        nombrePais varchar(50) not null,
        PRIMARY KEY (idPais)
);

CREATE TABLE if not exists Ciudad(
	idCiudad int not null auto_increment,
    nombreCiudad varchar(50) not null,
    idPais int not null,
    FOREIGN KEY (idPais) REFERENCES Pais(idPais),
    PRIMARY KEY (idCiudad)
);

CREATE TABLE IF NOT EXISTS PlanInternet(
	idPlanInternet int not null auto_increment,
    velocidadMegas int not null,
    precio float not null,
    descuento int null,
	PRIMARY KEY (idPlanInternet)
);

CREATE TABLE IF NOT EXISTS Cliente(
	dni int not null,
    nombreCliente varchar(50),
    apellidoCliente varchar(50),
    fechaNac date not null,
	idCiudad int not null,
    idPlanInternet int not null,
	FOREIGN KEY (idCiudad) REFERENCES Ciudad(idCiudad),
    FOREIGN KEY (idPlanInternet) REFERENCES PlanInternet (idPlanInternet)
);

-- b) Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
-- + 
-- c) Realizar las asociaciones/relaciones correspondientes entre estos registros.

INSERT INTO PAIS(nombrePais) VALUES ('Argentina');
INSERT INTO CIUDAD(nombreCiudad, idPais) VALUES ('Buenos Aires', 1);
INSERT INTO CIUDAD(nombreCiudad, idPais) VALUES ('Cordoba', 1);
INSERT INTO CIUDAD(nombreCiudad, idPais) VALUES ('Rosario', 1);

INSERT INTO PLANINTERNET(velocidadMegas, precio, descuento) VALUES (50, 5000, 0);
INSERT INTO PLANINTERNET(velocidadMegas, precio, descuento) VALUES (100, 10000, 0);
INSERT INTO PLANINTERNET(velocidadMegas, precio, descuento) VALUES (150, 15000, 5);
INSERT INTO PLANINTERNET(velocidadMegas, precio, descuento) VALUES (200, 20000, 10);
INSERT INTO PLANINTERNET(velocidadMegas, precio, descuento) VALUES (250, 25000, 15);

INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (37786097, 'Gonzalo', 'Murias', "1993-08-07", 1, 5);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (24589632, 'Maria', 'Gonzalez', "1985-04-27", 2, 4);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (29857896, 'Juan Diego', 'Perez', "1975-01-11", 3, 2);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (35698522, 'Jorge', 'Menusd', "1976-01-31", 1, 5);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (32584328, 'Romina', 'Sandoval', "1987-02-19", 2, 2);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (26859578, 'Sandra', 'Gomez', "1966-02-12", 3, 4);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (29156785, 'Fabian', 'Artigas', "1963-11-23", 1, 1);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (18589745, 'Eugenia', 'Martinez', "1953-11-01", 2, 3);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (34605202, 'Candelaria', 'Murias', "1996-10-29", 1, 3);
INSERT INTO CLIENTE (dni, nombreCliente, apellidoCliente, fechaNac, idCiudad, idPlanInternet) VALUES (32859780, 'Macarena', 'Miller', "1991-02-11", 3, 2);

select * from cliente;