DROP TABLE IF EXISTS cliente, plan, clientexplan;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `provincia` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ciudad` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_cliente`)
);
CREATE TABLE `plan` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `velocidad` varchar(10) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  `precio` float NOT NULL,
  `descuento` float NOT NULL,
  PRIMARY KEY (`id_plan`)
);
CREATE TABLE `clientexplan` (
  `id_clientexplan` int NOT NULL,
  `id_cliente` int NOT NULL,
  `id_plan` int NOT NULL,
  PRIMARY KEY (`id_clientexplan`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_plan_idx` (`id_plan`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_plan` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id_plan`) ON DELETE CASCADE ON UPDATE CASCADE
);