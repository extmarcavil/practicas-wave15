-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: factura_db
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura`
--

DROP TABLE IF EXISTS `Factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idFormaPago` int NOT NULL,
  `iva` decimal(10,0) NOT NULL,
  `cantidad` int NOT NULL,
  `idCliente` int NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_factura_formaPago_idx` (`idFormaPago`),
  KEY `fk_factura_cliente_idx` (`idCliente`),
  KEY `fecha` (`fecha` DESC),
  CONSTRAINT `fk_factura_cliente` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`),
  CONSTRAINT `fk_factura_formaPago` FOREIGN KEY (`idFormaPago`) REFERENCES `FormaPago` (`idFormaPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FacturaProducto`
--

DROP TABLE IF EXISTS `FacturaProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FacturaProducto` (
  `idFactura` int DEFAULT NULL,
  `idProducto` int DEFAULT NULL,
  KEY `fk_facturaProducto_factura_idx` (`idFactura`),
  KEY `fk_productoProducto_producto_idx` (`idProducto`),
  CONSTRAINT `fk_facturaProducto_factura` FOREIGN KEY (`idFactura`) REFERENCES `Factura` (`idFactura`),
  CONSTRAINT `fk_productoProducto_producto` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FacturaProducto`
--

LOCK TABLES `FacturaProducto` WRITE;
/*!40000 ALTER TABLE `FacturaProducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `FacturaProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FormaPago`
--

DROP TABLE IF EXISTS `FormaPago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FormaPago` (
  `idFormaPago` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idFormaPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FormaPago`
--

LOCK TABLES `FormaPago` WRITE;
/*!40000 ALTER TABLE `FormaPago` DISABLE KEYS */;
/*!40000 ALTER TABLE `FormaPago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Producto` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-11 16:19:17
