USE empresa_internet;

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `megas` int NOT NULL,
  `precio` double NOT NULL,
  `descuento` double NOT NULL,
  PRIMARY KEY (`id_plan`)
);

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `id_plan` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id_plan`)
);

INSERT INTO plan (megas, precio, descuento) VALUES (25, 300, 0);
INSERT INTO plan (megas, precio, descuento) VALUES (50, 500, 0);
INSERT INTO plan (megas, precio, descuento) VALUES (100, 1000, 5);
INSERT INTO plan (megas, precio, descuento) VALUES (200, 1500, 10);
INSERT INTO plan (megas, precio, descuento) VALUES (300, 2000, 5);

INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("123456789", "Juan", "Perez", "1991-05-12", "Buenos Aires", "Caballito", 1);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("234567891", "Carla", "Sanchez", "1986-03-12", "Buenos Aires", "Ramos Mejia", 2);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("345678912", "Carlos", "Zabala", "1968-04-24", "Buenos Aires", "Olivos", 3);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("456789123", "Milagros", "Muñoz", "1993-05-20", "Cordoba", "Cosquín", 4);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("567891234", "Juliana", "Camacho", "1995-05-17", "Salta", "San Lorenzo", 5);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("678912345", "Cristian", "Peña", "1997-12-12", "Cordoba", "Villa Carlos Paz", 3);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("789123456", "Raul", "Vazquez", "2000-11-12", "Buenos Aires", "Palermo", 3);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("891234567", "Marcos", "Quintana", "1972-05-11", "Santa Fe", "Esperanza", 1);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("912345678", "Rocio", "Botta", "1988-09-01", "Santa Fe", "Rosario", 3);
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)  VALUES ("012345678", "Miguel", "Bossio", "1990-08-03", "Buenos Aires", "Banfield", 4);