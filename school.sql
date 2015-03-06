CREATE DATABASE  IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `Level_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_Classe_Level1_idx` (`Level_id`),
  CONSTRAINT `fk_Classe_Level1` FOREIGN KEY (`Level_id`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (1,'CE1A',1),(2,'CE1B',1),(3,'CE1C',1),(4,'CE2A',2),(5,'CE2B',2),(6,'CE2C',2),(7,'CE3A',3),(8,'CE3B',3),(9,'CE3C',3),(10,'CE4A',4),(11,'CE4B',4),(12,'CE4C',4),(13,'CE5A',5),(14,'CE5B',5),(15,'CE5C',5),(16,'CE6A',6),(17,'CE6B',6),(18,'CE6C',6),(19,'1AC1',7),(20,'1AC2',7),(21,'2AC1',8),(22,'2AC2',8),(23,'3AC1',9),(24,'3AC2',9),(25,'TC1',10),(26,'TC2',10),(27,'1BAC SX',11),(28,'1BAC SM',11),(29,'2BAC SX',12),(30,'2BAC SM',12),(31,'Desinscrit',13);
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cycle`
--

DROP TABLE IF EXISTS `cycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cycle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cycle`
--

LOCK TABLES `cycle` WRITE;
/*!40000 ALTER TABLE `cycle` DISABLE KEYS */;
INSERT INTO `cycle` VALUES (1,'Primaire'),(2,'College'),(3,'Lycee'),(4,'Desinscrit');
/*!40000 ALTER TABLE `cycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedetails`
--

DROP TABLE IF EXISTS `feedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedetails` (
  `Student_id` int(11) NOT NULL,
  `start_FeeType_id` int(11) NOT NULL,
  `ScholarYear_id` int(11) NOT NULL,
  `serviceTG` int(11) NOT NULL,
  `comment` varchar(150) DEFAULT NULL,
  `monthlyReduction` int(11) NOT NULL DEFAULT '0',
  `annualReduction` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Student_id`,`start_FeeType_id`,`ScholarYear_id`),
  KEY `fk_FeeDetails_Student1_idx` (`Student_id`),
  KEY `fk_FeeDetails_FeeType1_idx` (`start_FeeType_id`),
  KEY `fk_FeeDetails_ScholarYear1_idx` (`ScholarYear_id`),
  CONSTRAINT `fk_FeeDetails_FeeType1` FOREIGN KEY (`start_FeeType_id`) REFERENCES `feetype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FeeDetails_ScholarYear1` FOREIGN KEY (`ScholarYear_id`) REFERENCES `scholaryear` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FeeDetails_Student1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedetails`
--

LOCK TABLES `feedetails` WRITE;
/*!40000 ALTER TABLE `feedetails` DISABLE KEYS */;
INSERT INTO `feedetails` VALUES (4656,1,1,0,NULL,0,0);
/*!40000 ALTER TABLE `feedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feetype`
--

DROP TABLE IF EXISTS `feetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `monthly` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feetype`
--

LOCK TABLES `feetype` WRITE;
/*!40000 ALTER TABLE `feetype` DISABLE KEYS */;
INSERT INTO `feetype` VALUES (1,'Inscription',0),(2,'Septembre',1),(3,'Octobre',1),(4,'Novembre',1),(5,'Decembre',1),(6,'Janvier',1),(7,'Fevrier',1),(8,'Mars',1),(9,'Avril',1),(10,'Mai',1),(11,'Juin',1);
/*!40000 ALTER TABLE `feetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `Cycle_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Level_Cycle1_idx` (`Cycle_id`),
  CONSTRAINT `fk_Level_Cycle1` FOREIGN KEY (`Cycle_id`) REFERENCES `cycle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (1,'CE1',1),(2,'CE2',1),(3,'CE3',1),(4,'CE4',1),(5,'CE5',1),(6,'CE6',1),(7,'1AC',2),(8,'2AC',2),(9,'3AC',2),(10,'TC',3),(11,'1BAC',3),(12,'2BAC',3),(13,'Desinscrit',4);
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levelfees`
--

DROP TABLE IF EXISTS `levelfees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `levelfees` (
  `ScholarYear_id` int(11) NOT NULL,
  `Level_id` int(11) NOT NULL,
  `registration` int(11) NOT NULL,
  `insurance` int(11) NOT NULL,
  `monthly` int(11) NOT NULL,
  `transport` int(11) NOT NULL,
  PRIMARY KEY (`ScholarYear_id`,`Level_id`),
  KEY `fk_LevelFees_ScholarYear1_idx` (`ScholarYear_id`),
  KEY `fk_LevelFees_Level1_idx` (`Level_id`),
  CONSTRAINT `fk_LevelFees_Level1` FOREIGN KEY (`Level_id`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_LevelFees_ScholarYear1` FOREIGN KEY (`ScholarYear_id`) REFERENCES `scholaryear` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levelfees`
--

LOCK TABLES `levelfees` WRITE;
/*!40000 ALTER TABLE `levelfees` DISABLE KEYS */;
INSERT INTO `levelfees` VALUES (1,1,1200,300,800,300),(1,2,1200,300,800,300),(1,3,1200,300,800,300),(1,4,1200,300,800,300),(1,5,1200,300,800,300),(1,6,1200,300,800,300),(1,7,1200,300,800,300),(1,8,1200,300,800,300),(1,9,1200,300,800,300),(1,10,1200,300,800,300),(1,11,1200,300,800,300),(1,12,1200,300,800,300),(1,13,0,0,0,0);
/*!40000 ALTER TABLE `levelfees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payedfee`
--

DROP TABLE IF EXISTS `payedfee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payedfee` (
  `Student_id` int(11) NOT NULL,
  `FeeType_id` int(11) NOT NULL,
  `ScholarYear_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `payementDate` date NOT NULL,
  PRIMARY KEY (`Student_id`,`FeeType_id`,`ScholarYear_id`),
  KEY `fk_PayedFee_FeeType1_idx` (`FeeType_id`),
  KEY `fk_PayedFee_ScholarYear1_idx` (`ScholarYear_id`),
  CONSTRAINT `fk_PayedFee_FeeType1` FOREIGN KEY (`FeeType_id`) REFERENCES `feetype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PayedFee_ScholarYear1` FOREIGN KEY (`ScholarYear_id`) REFERENCES `scholaryear` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PayedFee_Student1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payedfee`
--

LOCK TABLES `payedfee` WRITE;
/*!40000 ALTER TABLE `payedfee` DISABLE KEYS */;
/*!40000 ALTER TABLE `payedfee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone` (
  `Student_id` int(11) NOT NULL,
  `number` varchar(20) NOT NULL,
  `owner` varchar(45) NOT NULL,
  KEY `fk_Phone_Student1_idx` (`Student_id`),
  CONSTRAINT `fk_Phone_Student1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scholaryear`
--

DROP TABLE IF EXISTS `scholaryear`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scholaryear` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startYear` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scholaryear`
--

LOCK TABLES `scholaryear` WRITE;
/*!40000 ALTER TABLE `scholaryear` DISABLE KEYS */;
INSERT INTO `scholaryear` VALUES (1,2014);
/*!40000 ALTER TABLE `scholaryear` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (4656,'youssef','elhouti');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_classe`
--

DROP TABLE IF EXISTS `student_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_classe` (
  `Student_id` int(11) NOT NULL,
  `ScholarYear_id` int(11) NOT NULL,
  `Classe_id` int(11) NOT NULL,
  PRIMARY KEY (`Student_id`,`ScholarYear_id`,`Classe_id`),
  KEY `fk_Student_Classe_Student1_idx` (`Student_id`),
  KEY `fk_Student_Classe_ScholarYear1_idx` (`ScholarYear_id`),
  KEY `fk_Student_Classe_Classe1_idx` (`Classe_id`),
  CONSTRAINT `fk_Student_Classe_Classe1` FOREIGN KEY (`Classe_id`) REFERENCES `classe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Classe_ScholarYear1` FOREIGN KEY (`ScholarYear_id`) REFERENCES `scholaryear` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Classe_Student1` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_classe`
--

LOCK TABLES `student_classe` WRITE;
/*!40000 ALTER TABLE `student_classe` DISABLE KEYS */;
INSERT INTO `student_classe` VALUES (4656,1,1);
/*!40000 ALTER TABLE `student_classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test','BxtAJyj1t8Lhbk8NgkOte3e11S9i+1zmhoxsJOJbAA8=','q6q5iSY=');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-06 19:47:47
