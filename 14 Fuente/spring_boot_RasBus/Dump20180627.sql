-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: db_rasbus
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus` (
  `bus_id` varchar(255) NOT NULL,
  `cant_asiento` int(11) DEFAULT NULL,
  `fecha_compra` date DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bus_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES ('TR-03',2,'2017-01-03','foto','3LL4-N0-T3-4M4'),('TR-01',6,'2018-02-02','foto','ALV-666'),('TR-04',22,'2015-06-07','foto','12312-df'),('tr-07',12,'2018-02-02','123fsd','123'),('tr-08',22,'2018-06-20','sdf','1231');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_ruta_paradero`
--

DROP TABLE IF EXISTS `bus_ruta_paradero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus_ruta_paradero` (
  `fecha` datetime NOT NULL,
  `latitud` int(11) DEFAULT NULL,
  `longitud` int(11) DEFAULT NULL,
  `bus_id` varchar(255) NOT NULL,
  `paradero_id` varchar(255) NOT NULL,
  `ruta_id` varchar(255) NOT NULL,
  PRIMARY KEY (`fecha`),
  KEY `FK67i5lphlqmbe5i6swmexqvlkv` (`bus_id`),
  KEY `FKnfisutse10min14hbryha9ff` (`paradero_id`,`ruta_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_ruta_paradero`
--

LOCK TABLES `bus_ruta_paradero` WRITE;
/*!40000 ALTER TABLE `bus_ruta_paradero` DISABLE KEYS */;
/*!40000 ALTER TABLE `bus_ruta_paradero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `cargo_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  PRIMARY KEY (`cargo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'admon',113);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `distrito_id` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`distrito_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES ('ISIDR',NULL);
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacion_policial`
--

DROP TABLE IF EXISTS `estacion_policial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacion_policial` (
  `estacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `telefono` int(11) DEFAULT NULL,
  `distrito_id` varchar(255) NOT NULL,
  PRIMARY KEY (`estacion_id`),
  KEY `FKtkjfa7wc7pqhfklodlg70776s` (`distrito_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacion_policial`
--

LOCK TABLES `estacion_policial` WRITE;
/*!40000 ALTER TABLE `estacion_policial` DISABLE KEYS */;
/*!40000 ALTER TABLE `estacion_policial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_bus`
--

DROP TABLE IF EXISTS `estado_bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_bus` (
  `estado_id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `bateria` int(11) DEFAULT NULL,
  `cant_pasajeros` int(11) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `gasolina_disponible` int(11) DEFAULT NULL,
  `temperatura_motor` float DEFAULT NULL,
  `velocidad` float DEFAULT NULL,
  `bus_id` varchar(255) NOT NULL,
  `trabajador_id` int(11) NOT NULL,
  PRIMARY KEY (`estado_id`,`fecha`),
  KEY `FKl0kkfrhx19re438fo5jviuo6m` (`bus_id`),
  KEY `FK5pqfcgcfbng17p3nb5inyrdff` (`trabajador_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_bus`
--

LOCK TABLES `estado_bus` WRITE;
/*!40000 ALTER TABLE `estado_bus` DISABLE KEYS */;
/*!40000 ALTER TABLE `estado_bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `prioridad` int(11) DEFAULT NULL,
  `bus_id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK75somdjxn67e4oxgplkbob3u2` (`bus_id`,`fecha`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paradero`
--

DROP TABLE IF EXISTS `paradero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paradero` (
  `paradero_id` varchar(255) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `distrito_id` varchar(255) NOT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  PRIMARY KEY (`paradero_id`),
  KEY `FKjwptdjabrr8yp916m1wmp3wb8` (`distrito_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paradero`
--

LOCK TABLES `paradero` WRITE;
/*!40000 ALTER TABLE `paradero` DISABLE KEYS */;
INSERT INTO `paradero` VALUES ('JAPRA','Av. Javier Prado','desc','Javier Prado','ISIDR',-12.043870007154085,-77.096124994751),('CESAR','AV. scesar','asda','das','ISIDR',-12.043844007154085,-77.095124994751),('CANAD','Av Canada','asdsa','Canada','ISIDR',-12.043870003154085,-77.096124884751);
/*!40000 ALTER TABLE `paradero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pasajero` (
  `pasajero_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_caducidad_tarjeta` date DEFAULT NULL,
  `seguro_descripcion` varchar(255) DEFAULT NULL,
  `tiene_seguro` bit(1) DEFAULT NULL,
  PRIMARY KEY (`pasajero_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajero`
--

LOCK TABLES `pasajero` WRITE;
/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `persona_id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `celular` int(11) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono_fijo` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`persona_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recarga`
--

DROP TABLE IF EXISTS `recarga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recarga` (
  `recarga_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `tarjeta_id` int(11) NOT NULL,
  `tipo_recarga_id` int(11) NOT NULL,
  PRIMARY KEY (`recarga_id`),
  KEY `FK2gxg3p1yrrpst8k8wf0i7bdx9` (`tarjeta_id`),
  KEY `FKqc0pg4ts2oy9y8jxt3l0hxrf` (`tipo_recarga_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recarga`
--

LOCK TABLES `recarga` WRITE;
/*!40000 ALTER TABLE `recarga` DISABLE KEYS */;
/*!40000 ALTER TABLE `recarga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `ruta_id` varchar(255) NOT NULL,
  `horario_fin` time DEFAULT NULL,
  `horario_inicio` time DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ruta_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
INSERT INTO `ruta` VALUES ('EXP1 ','17:00:00','10:00:00','Expreso 1'),('EXP2','10:00:01','10:00:00','Expreso 2'),('EXP3','04:00:00','09:00:00','Expreso 3'),('EXP4','09:00:00','04:00:00','Expreso 4'),('EXP 5','14:00:00','07:00:00','Hugo Yupanqui'),('EXP9','10:00:00','09:00:00','dmn');
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta_paradero`
--

DROP TABLE IF EXISTS `ruta_paradero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta_paradero` (
  `paradero_id` varchar(255) NOT NULL,
  `ruta_id` varchar(255) NOT NULL,
  PRIMARY KEY (`paradero_id`,`ruta_id`),
  KEY `FKsru0bt7myc1jinyvjyiofax3n` (`ruta_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta_paradero`
--

LOCK TABLES `ruta_paradero` WRITE;
/*!40000 ALTER TABLE `ruta_paradero` DISABLE KEYS */;
INSERT INTO `ruta_paradero` VALUES ('CANAD','EXP9');
/*!40000 ALTER TABLE `ruta_paradero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `tarjeta_id` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` double DEFAULT NULL,
  `pasajero_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tarjeta_id`),
  KEY `FK9to1djjiusfirf18ddpekfk9a` (`pasajero_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiporecarga`
--

DROP TABLE IF EXISTS `tiporecarga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiporecarga` (
  `tipo_recarga_id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tipo_recarga_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiporecarga`
--

LOCK TABLES `tiporecarga` WRITE;
/*!40000 ALTER TABLE `tiporecarga` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiporecarga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajador` (
  `trabajador_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_contratacion` date DEFAULT NULL,
  `fecha_fin_contrato` date DEFAULT NULL,
  `cargo_id` int(11) NOT NULL,
  `reports_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`trabajador_id`),
  KEY `FK4o42w2ssa4dyqih3pedkgrm4t` (`cargo_id`),
  KEY `FKe7nxtwx1auwu66lqe42dojcr4` (`reports_to`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje`
--

DROP TABLE IF EXISTS `viaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje` (
  `fecha` datetime NOT NULL,
  `viaje_id` bigint(20) NOT NULL,
  `precio` double DEFAULT NULL,
  `bus_id` varchar(255) NOT NULL,
  `tarjeta_id` int(11) NOT NULL,
  PRIMARY KEY (`fecha`,`viaje_id`),
  KEY `FK5qfu3ihhka6oy5ilw9vx0yny8` (`bus_id`),
  KEY `FK5kn45hv7de34nviiih31vngjh` (`tarjeta_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje`
--

LOCK TABLES `viaje` WRITE;
/*!40000 ALTER TABLE `viaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `viaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-27 17:25:48
