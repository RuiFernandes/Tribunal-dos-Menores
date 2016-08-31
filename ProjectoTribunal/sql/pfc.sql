CREATE DATABASE  IF NOT EXISTS `pfc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pfc`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: pfc
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto` (
  `id` int(11) NOT NULL,
  `auto` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (14,'outro'),(19,'Accao de Alimentos');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Administrador'),(2,'Juiz'),(3,'Escrivao'),(4,'Ajudante Escrivao'),(5,'Oficial de Deligencias'),(6,'Assistente Social'),(7,'Secretaria Geral');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (23),(23),(23),(23),(23),(23),(23),(23),(23),(23),(23);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inqueritosocial`
--

DROP TABLE IF EXISTS `inqueritosocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inqueritosocial` (
  `id` int(11) NOT NULL,
  `assistentesocial` varchar(255) NOT NULL,
  `processo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiqdumsixx1ir6r28d134qto67` (`processo`),
  CONSTRAINT `FKiqdumsixx1ir6r28d134qto67` FOREIGN KEY (`processo`) REFERENCES `processo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inqueritosocial`
--

LOCK TABLES `inqueritosocial` WRITE;
/*!40000 ALTER TABLE `inqueritosocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `inqueritosocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livro` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `numero` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nrxo5xfrqh25uhcnq3l48kypx` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (17,'Livro Porta',1);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `log` varchar(255) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaoe28kow2u0nbahkjf4qgbndu` (`user`),
  CONSTRAINT `FKaoe28kow2u0nbahkjf4qgbndu` FOREIGN KEY (`user`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagina`
--

DROP TABLE IF EXISTS `pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagina` (
  `id` int(11) NOT NULL,
  `pag` int(11) NOT NULL,
  `livro` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5smr1n7yksjgrw4bw312a92t2` (`livro`),
  CONSTRAINT `FK5smr1n7yksjgrw4bw312a92t2` FOREIGN KEY (`livro`) REFERENCES `livro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagina`
--

LOCK TABLES `pagina` WRITE;
/*!40000 ALTER TABLE `pagina` DISABLE KEYS */;
INSERT INTO `pagina` VALUES (18,1,17),(21,2,17);
/*!40000 ALTER TABLE `pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peticao`
--

DROP TABLE IF EXISTS `peticao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peticao` (
  `DTYPE` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `apenso` varchar(255) NOT NULL,
  `archived` bit(1) NOT NULL,
  `data` datetime NOT NULL,
  `dist` bit(1) NOT NULL,
  `numeroid` varchar(255) NOT NULL,
  `remetente` varchar(255) NOT NULL,
  `requerente` varchar(255) NOT NULL,
  `requerido` varchar(255) NOT NULL,
  `resumo` varchar(255) NOT NULL,
  `seccao` int(11) DEFAULT NULL,
  `processo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKivtasahsrnn5kwdpkq934dl42` (`seccao`),
  KEY `FKh8vmtjr9tt0x2f49laik78khj` (`processo`),
  CONSTRAINT `FKh8vmtjr9tt0x2f49laik78khj` FOREIGN KEY (`processo`) REFERENCES `processo` (`id`),
  CONSTRAINT `FKivtasahsrnn5kwdpkq934dl42` FOREIGN KEY (`seccao`) REFERENCES `seccao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peticao`
--

LOCK TABLES `peticao` WRITE;
/*!40000 ALTER TABLE `peticao` DISABLE KEYS */;
INSERT INTO `peticao` VALUES ('Peticao',15,'','','2016-08-31 07:36:29','\0','123432342','`Rui Fernandes Guirrugo','Mercia Sopas','Rui Guirrugo','Accao de Alimentos',NULL,NULL),('PeticaoDistribuida',16,'','\0','2016-08-31 07:36:29','\0','123432342','`Rui Fernandes Guirrugo','Mercia Sopas','Rui Guirrugo','Accao de Alimentos',9,NULL);
/*!40000 ALTER TABLE `peticao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processo`
--

DROP TABLE IF EXISTS `processo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `processo` (
  `DTYPE` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `archived` bit(1) NOT NULL,
  `data` datetime NOT NULL,
  `identification` varchar(255) NOT NULL,
  `conclusao` bit(1) DEFAULT NULL,
  `auto` int(11) NOT NULL,
  `pagina` int(11) NOT NULL,
  `peticao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4ojxcssrvopfb7xsb45t3vllo` (`identification`),
  KEY `FK1pmtht2kxswln8u03hl2cikx3` (`auto`),
  KEY `FK9fy5k2qtr5xkabxf3v6sh7521` (`pagina`),
  KEY `FKpoeipcuy279sqd0x4wgxlhvin` (`peticao`),
  CONSTRAINT `FKpoeipcuy279sqd0x4wgxlhvin` FOREIGN KEY (`peticao`) REFERENCES `peticao` (`id`),
  CONSTRAINT `FK1pmtht2kxswln8u03hl2cikx3` FOREIGN KEY (`auto`) REFERENCES `auto` (`id`),
  CONSTRAINT `FK9fy5k2qtr5xkabxf3v6sh7521` FOREIGN KEY (`pagina`) REFERENCES `pagina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processo`
--

LOCK TABLES `processo` WRITE;
/*!40000 ALTER TABLE `processo` DISABLE KEYS */;
INSERT INTO `processo` VALUES ('ProcessoAutuado',20,'\0','2016-08-31 07:38:40','1-1-2016-R','',19,18,16);
/*!40000 ALTER TABLE `processo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `inforegisto` varchar(255) NOT NULL,
  `processoautuado` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi6iptl2clxps8eeucok3ic3hf` (`processoautuado`),
  KEY `FKkutafg82n0i15ioexdaimvqem` (`user`),
  CONSTRAINT `FKkutafg82n0i15ioexdaimvqem` FOREIGN KEY (`user`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKi6iptl2clxps8eeucok3ic3hf` FOREIGN KEY (`processoautuado`) REFERENCES `processo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (22,'2016-08-31 07:38:40','Processo Autuado: Accao de Alimentos',20,13);
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seccao`
--

DROP TABLE IF EXISTS `seccao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seccao` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seccao`
--

LOCK TABLES `seccao` WRITE;
/*!40000 ALTER TABLE `seccao` DISABLE KEYS */;
INSERT INTO `seccao` VALUES (8,'Gestao do sistema'),(9,'Seccao 1'),(10,'Seccao 2'),(11,'Seccao 3');
/*!40000 ALTER TABLE `seccao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `archived` bit(1) NOT NULL,
  `datadenascimento` datetime NOT NULL,
  `nome` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `categoria` int(11) NOT NULL,
  `seccao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_863n1y3x0jalatoir4325ehal` (`username`),
  KEY `FKtlxicg595cpx3mxkte5fhcf91` (`categoria`),
  KEY `FKey0ujr5fcvqp9yxf0c96vc56i` (`seccao`),
  CONSTRAINT `FKey0ujr5fcvqp9yxf0c96vc56i` FOREIGN KEY (`seccao`) REFERENCES `seccao` (`id`),
  CONSTRAINT `FKtlxicg595cpx3mxkte5fhcf91` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (12,'\0','1991-07-07 00:00:00','other user','admin1','admin1',1,8),(13,'\0','1991-07-07 00:00:00','Rui Fernandes','admin','admin',1,8);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-31 18:59:39
