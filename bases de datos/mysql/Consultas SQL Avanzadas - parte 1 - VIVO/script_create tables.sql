CREATE TABLE `departamento` (
  `depto_nro` varchar(45) NOT NULL,
  `nombre_depto` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `empleado` (
  `cod_emp` varchar(45) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `puesto` varchar(45) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `salario` decimal(13,2) DEFAULT NULL,
  `comision` decimal(13,2) DEFAULT NULL,
  `nro_depto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `depto_nro_idx` (`nro_depto`),
  CONSTRAINT `nro_depto` FOREIGN KEY (`nro_depto`) REFERENCES `departamento` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
