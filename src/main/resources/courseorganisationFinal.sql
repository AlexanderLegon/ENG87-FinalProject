CREATE DATABASE  IF NOT EXISTS `courseorganisation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `courseorganisation`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: courseorganisation
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `discipline_id` int DEFAULT NULL,
  `location_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `trainer_id` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `fk_discipline_idx` (`discipline_id`),
  KEY `fk_trainer_idx` (`trainer_id`),
  KEY `fk_course_type_idx` (`type_id`),
  KEY `fk_location_idx` (`location_id`),
  CONSTRAINT `fk_course_type` FOREIGN KEY (`type_id`) REFERENCES `course_type` (`course_type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_discipline` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`discipline_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trainer` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Engineering 87',1,4,'2021-05-04',1,2),(3,'Engineering 90',4,4,'2021-05-10',16,2),(69,'Padawan Training',3,8,'2021-08-16',12,2),(70,'SDET 34',4,2,'2021-05-31',11,2),(72,'Engineering 51',5,2,'2021-07-05',2,1),(73,'Business 31',3,3,'2021-07-12',14,1),(74,'Maintenance 12',1,1,'2021-08-02',12,1),(76,'SDET 54',2,3,'2021-09-27',11,2),(77,'Business 65',5,1,'2021-10-18',1,1),(78,'Engineering 62',3,1,'2021-11-01',3,2),(79,'Hacking 4',3,4,'2022-01-03',13,2),(80,'Business 12',3,1,'2021-12-06',18,1),(82,'Jedi Training',3,8,'2021-04-26',3,1),(83,'Sith Training',2,10,'2021-07-12',23,1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_trainer_dates`
--

DROP TABLE IF EXISTS `course_trainer_dates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_trainer_dates` (
  `course_trainer_dates_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `trainer_end_date` int DEFAULT NULL,
  `trainer_id` int DEFAULT NULL,
  `trainer_start_date` int DEFAULT NULL,
  KEY `fk_course_id_idx` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_trainer_dates`
--

LOCK TABLES `course_trainer_dates` WRITE;
/*!40000 ALTER TABLE `course_trainer_dates` DISABLE KEYS */;
INSERT INTO `course_trainer_dates` VALUES (1,1,4,1,1),(2,1,8,2,5),(3,1,120,3,9),(4,2,5,3,1),(5,3,1,16,1),(6,4,140,3,1),(33,69,4,12,1),(34,69,10,13,4),(35,70,1,11,1),(36,71,5,13,1),(37,71,12,11,5),(38,72,6,2,1),(39,72,12,1,6),(40,73,1,14,1),(41,73,1,16,6),(42,74,1,12,1),(43,74,1,15,7),(44,75,1,19,1),(45,75,1,17,5),(46,76,4,11,1),(47,76,8,14,5),(48,76,12,16,9),(49,77,5,1,1),(50,77,1,13,6),(51,78,1,3,1),(52,78,1,15,6),(53,79,5,13,1),(54,79,1,15,6),(55,80,1,18,1),(56,80,1,17,6),(57,3,1,12,6),(58,70,1,12,6),(59,2,12,13,6),(60,81,7,20,1),(61,81,12,21,7),(62,82,7,3,1),(63,82,12,14,7),(64,83,10,23,1),(65,84,6,22,1),(66,84,12,24,7);
/*!40000 ALTER TABLE `course_trainer_dates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_type`
--

DROP TABLE IF EXISTS `course_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_type` (
  `course_type_id` int NOT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_type`
--

LOCK TABLES `course_type` WRITE;
/*!40000 ALTER TABLE `course_type` DISABLE KEYS */;
INSERT INTO `course_type` VALUES (1,'Business'),(2,'Technology');
/*!40000 ALTER TABLE `course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discipline` (
  `discipline_id` int NOT NULL,
  `discipline_duration` int DEFAULT NULL,
  `discipline_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`discipline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discipline`
--

LOCK TABLES `discipline` WRITE;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` VALUES (1,12,'Java'),(2,12,'C#'),(3,12,'DevOps'),(4,12,'JavaSDET'),(5,12,'C#SDET');
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (24);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `location_id` int NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `number_of_rooms` int DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Hoth',5),(2,'Naboo',7),(3,'Geonosis',5),(4,'Kashyyyk',4),(8,'Coruscant',5),(10,'Mustafar',4);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quality_gate`
--

DROP TABLE IF EXISTS `quality_gate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quality_gate` (
  `quality_gate_id` int NOT NULL,
  `trainer_feedback_1` varchar(255) DEFAULT NULL,
  `trainer_feedback_2` varchar(255) DEFAULT NULL,
  `quality_gate_status` varchar(255) DEFAULT NULL,
  `trainee_id` int DEFAULT NULL,
  `trainer_id_1` int DEFAULT NULL,
  `trainer_id_2` int DEFAULT NULL,
  `quality_gate_date` date DEFAULT NULL,
  PRIMARY KEY (`quality_gate_id`),
  KEY `fk trainer 1_idx` (`trainer_id_1`),
  KEY `fk trainer 2_idx` (`trainer_id_2`),
  KEY `fk trainee_idx` (`trainee_id`),
  CONSTRAINT `fk trainee` FOREIGN KEY (`trainee_id`) REFERENCES `trainee` (`trainee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk trainer 1` FOREIGN KEY (`trainer_id_1`) REFERENCES `trainer` (`trainer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk trainer 2` FOREIGN KEY (`trainer_id_2`) REFERENCES `trainer` (`trainer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quality_gate`
--

LOCK TABLES `quality_gate` WRITE;
/*!40000 ALTER TABLE `quality_gate` DISABLE KEYS */;
INSERT INTO `quality_gate` VALUES (1,'good technical answers but soft skill questions lacking','good content to answers but they are rambled and communication is unclear','Failed- needs support',1,1,2,NULL),(2,'much clearer answers with strong personality coming through','Made good attempt at technical questions testing to see how they behaved when they aren\'t sure','Passed',1,2,3,NULL),(19,'You are on this council, but we do not grant you the rank of Master.','You have failed','Failed-Needs Help',23,12,13,'2021-05-10'),(20,'This is the way','Train yourself to let go... of everything you fear to lose.','Failed-Needs Help',23,15,18,'2021-05-20'),(21,'You were supposed to bring balance to the force, not leave it in darkness.','Twisted by the Dark Side, young Skywalker has become.','Failed',23,22,19,'2021-08-05'),(22,'Unlimited POWER!!!!','Did you ever hear the tragedy of Darth Plagueis the Wise?','Passed',29,23,23,'2021-08-05');
/*!40000 ALTER TABLE `quality_gate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_course`
--

DROP TABLE IF EXISTS `sequence_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_course` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_course`
--

LOCK TABLES `sequence_course` WRITE;
/*!40000 ALTER TABLE `sequence_course` DISABLE KEYS */;
INSERT INTO `sequence_course` VALUES (85);
/*!40000 ALTER TABLE `sequence_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_course_trainer`
--

DROP TABLE IF EXISTS `sequence_course_trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_course_trainer` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_course_trainer`
--

LOCK TABLES `sequence_course_trainer` WRITE;
/*!40000 ALTER TABLE `sequence_course_trainer` DISABLE KEYS */;
INSERT INTO `sequence_course_trainer` VALUES (67);
/*!40000 ALTER TABLE `sequence_course_trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_course_type`
--

DROP TABLE IF EXISTS `sequence_course_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_course_type` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_course_type`
--

LOCK TABLES `sequence_course_type` WRITE;
/*!40000 ALTER TABLE `sequence_course_type` DISABLE KEYS */;
INSERT INTO `sequence_course_type` VALUES (8);
/*!40000 ALTER TABLE `sequence_course_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_discipline`
--

DROP TABLE IF EXISTS `sequence_discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_discipline` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_discipline`
--

LOCK TABLES `sequence_discipline` WRITE;
/*!40000 ALTER TABLE `sequence_discipline` DISABLE KEYS */;
INSERT INTO `sequence_discipline` VALUES (11);
/*!40000 ALTER TABLE `sequence_discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_location`
--

DROP TABLE IF EXISTS `sequence_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_location` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_location`
--

LOCK TABLES `sequence_location` WRITE;
/*!40000 ALTER TABLE `sequence_location` DISABLE KEYS */;
INSERT INTO `sequence_location` VALUES (12);
/*!40000 ALTER TABLE `sequence_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_trainee`
--

DROP TABLE IF EXISTS `sequence_trainee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_trainee` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_trainee`
--

LOCK TABLES `sequence_trainee` WRITE;
/*!40000 ALTER TABLE `sequence_trainee` DISABLE KEYS */;
INSERT INTO `sequence_trainee` VALUES (31);
/*!40000 ALTER TABLE `sequence_trainee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence_trainer`
--

DROP TABLE IF EXISTS `sequence_trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence_trainer` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence_trainer`
--

LOCK TABLES `sequence_trainer` WRITE;
/*!40000 ALTER TABLE `sequence_trainer` DISABLE KEYS */;
INSERT INTO `sequence_trainer` VALUES (25);
/*!40000 ALTER TABLE `sequence_trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainee`
--

DROP TABLE IF EXISTS `trainee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainee` (
  `trainee_id` int NOT NULL,
  `course_id` int DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`trainee_id`),
  KEY `fk_course_idx` (`course_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainee`
--

LOCK TABLES `trainee` WRITE;
/*!40000 ALTER TABLE `trainee` DISABLE KEYS */;
INSERT INTO `trainee` VALUES (1,1,'Ahsoka','Tano'),(18,82,'Barriss','Offe'),(19,82,'Cal','Kestis'),(20,82,'Caleb','Dume'),(21,82,'Eldra','Kaitis'),(22,82,'Ferren','Barr'),(23,82,'Anakin','Skywalker'),(24,82,'Galdos','Stouff'),(25,82,'Nes','Ukul'),(26,82,'Nim','Pianna'),(27,82,'Trilla','Sunduri'),(28,82,'Zett','Jukassa'),(29,83,'Anakin','Skywalker');
/*!40000 ALTER TABLE `trainee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `trainer_color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (1,'Aayla','Secura','#090179'),(2,'Mike','Wazowski','#008000FF'),(3,'JarJar','Binks','#bb00ff'),(11,'Kit','Fisto','#033602'),(12,'Mace','Windu','#500066'),(13,'Ki-adi','Mundi','#0091ff'),(14,'Luminara','Unduli','#fbff00'),(15,'Plo','Koon','#ff6f00'),(16,'Eeth','Koth','#1d4d81'),(17,'Adi','Gallia','#00e1ff'),(18,'Ima-gun','Di','#846b10'),(19,'Qui-gon','Jinn','#e3bc68'),(22,'Obi-Wan','Kenobi','#2d1010'),(23,'Sheev','Palpatine','#8f0000');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_stream`
--

DROP TABLE IF EXISTS `trainer_stream`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer_stream` (
  `trainer_id` int NOT NULL,
  `discipline_id` int NOT NULL,
  PRIMARY KEY (`trainer_id`,`discipline_id`),
  KEY `fk_discpline_idx` (`discipline_id`),
  CONSTRAINT `fk_discpline` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`discipline_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trainers` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_stream`
--

LOCK TABLES `trainer_stream` WRITE;
/*!40000 ALTER TABLE `trainer_stream` DISABLE KEYS */;
INSERT INTO `trainer_stream` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `trainer_stream` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_entity`
--

DROP TABLE IF EXISTS `user_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_entity` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_enabled` int DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_entity`
--

LOCK TABLES `user_entity` WRITE;
/*!40000 ALTER TABLE `user_entity` DISABLE KEYS */;
INSERT INTO `user_entity` VALUES (10,1,'Alex','$2a$10$igjkg.TY12bTxRyTiUxOluT6do0MgJFMTeqkSGh6Fq1Iw2canv6Gq','USER'),(11,1,'Tom','$2a$10$pJGqnNP9uSaNrQ9JBSAaK.HDRlkjyHxgQcksHwLVTNbu.qbb/JNYC','USER');
/*!40000 ALTER TABLE `user_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-23 13:48:30
