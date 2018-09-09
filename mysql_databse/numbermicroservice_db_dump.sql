-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: numberservice
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CustomerInfo`
--

DROP TABLE IF EXISTS `CustomerInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CustomerInfo` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key, id of each customer.',
  `cus_name` varchar(50) NOT NULL COMMENT 'name of each customer.',
  `passport_number` varchar(50) NOT NULL COMMENT 'Customer must register with their passport',
  `passport_expiredTime` datetime DEFAULT NULL COMMENT 'Over the this customer cannot bind to any number.’NULL’ means Citizen or PR.',
  PRIMARY KEY (`cus_id`),
  UNIQUE KEY `cus_id_UNIQUE` (`cus_id`),
  UNIQUE KEY `passport_number_UNIQUE` (`passport_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CustomerInfo`
--

LOCK TABLES `CustomerInfo` WRITE;
/*!40000 ALTER TABLE `CustomerInfo` DISABLE KEYS */;
INSERT INTO `CustomerInfo` VALUES (1,'Wanghy','E22480559','2029-10-01 00:00:00'),(2,'ZQ','E33560811','2019-01-20 00:00:00');
/*!40000 ALTER TABLE `CustomerInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `History`
--

DROP TABLE IF EXISTS `History`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `History` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'primary key, id of each change',
  `service_id` int(11) NOT NULL COMMENT 'foreign key to service table.',
  `num_id` int(11) NOT NULL COMMENT 'foreign key to number table.',
  `cus_id` int(11) NOT NULL COMMENT 'foreign key to customer table',
  `status_id` tinyint(3) NOT NULL COMMENT '0: available 1: in use; 2: pause; 3: disabled',
  `create_time` varchar(45) DEFAULT NULL COMMENT 'time of change happens.',
  PRIMARY KEY (`history_id`),
  UNIQUE KEY `history_id_UNIQUE` (`history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `History`
--

LOCK TABLES `History` WRITE;
/*!40000 ALTER TABLE `History` DISABLE KEYS */;
INSERT INTO `History` VALUES (1,1,3,1,1,'2018-09-09'),(2,1,3,1,2,'2018-09-09'),(3,1,0,0,0,'2018-09-09 14:03:52'),(4,1,3,1,2,'2018-09-09 14:18:31');
/*!40000 ALTER TABLE `History` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NumberInfo`
--

DROP TABLE IF EXISTS `NumberInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `NumberInfo` (
  `num_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(20) NOT NULL,
  `cus_id` int(11) DEFAULT NULL,
  `status_id` tinyint(3) NOT NULL,
  `service_id` tinyint(3) NOT NULL DEFAULT '0',
  `expired_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`num_id`),
  UNIQUE KEY `num_id_UNIQUE` (`num_id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NumberInfo`
--

LOCK TABLES `NumberInfo` WRITE;
/*!40000 ALTER TABLE `NumberInfo` DISABLE KEYS */;
INSERT INTO `NumberInfo` VALUES (3,'82964866',1,2,1,'2020-10-01 00:00:00','2018-09-08 00:00:00'),(4,'82964867',0,3,0,'2018-10-31 00:00:00','2018-09-08 00:00:00'),(6,'82964869',0,2,0,'2018-10-31 00:00:00','2018-09-08 00:00:00'),(7,'82964870',0,3,0,'2018-10-01 00:00:00','2018-09-08 00:00:00'),(9,'82964871',0,0,0,NULL,'2018-09-08 00:00:00'),(10,'82964872',0,0,0,NULL,'2018-09-08 00:00:00'),(11,'82964874',0,0,0,NULL,'2018-09-08 00:00:00');
/*!40000 ALTER TABLE `NumberInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NumberStatus`
--

DROP TABLE IF EXISTS `NumberStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `NumberStatus` (
  `status_id` int(3) NOT NULL COMMENT 'primary key, id of each status.',
  `status_name` varchar(30) NOT NULL COMMENT 'the name of the status (0: available 1: in use; 2: pause; 3: disabled).',
  `description` varchar(100) DEFAULT NULL COMMENT 'describe the details of the status.',
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `status_id_UNIQUE` (`status_id`),
  UNIQUE KEY `status_name_UNIQUE` (`status_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NumberStatus`
--

LOCK TABLES `NumberStatus` WRITE;
/*!40000 ALTER TABLE `NumberStatus` DISABLE KEYS */;
INSERT INTO `NumberStatus` VALUES (0,'available','Number can be assigned'),(1,'using','Already assigned'),(2,'pause','Balance is not enough or other reasons.'),(3,'disabled','cannot be used for now');
/*!40000 ALTER TABLE `NumberStatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Service`
--

DROP TABLE IF EXISTS `Service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Service` (
  `service_id` int(11) NOT NULL COMMENT 'primary key, id of each service.',
  `service_name` varchar(30) NOT NULL,
  `service_type` tinyint(2) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `service_id_UNIQUE` (`service_id`),
  UNIQUE KEY `service_type_UNIQUE` (`service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Service`
--

LOCK TABLES `Service` WRITE;
/*!40000 ALTER TABLE `Service` DISABLE KEYS */;
INSERT INTO `Service` VALUES (1,'prepaid',0,'prepaied type.If the balance is not enough, the service will be paused.'),(2,'contract',1,'customer pay the bill monthly.');
/*!40000 ALTER TABLE `Service` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-09 18:03:29
