-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `population_south`
--

DROP TABLE IF EXISTS `population_south`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `population_south` (
  `year` int(11) NOT NULL,
  `population` int(11) DEFAULT NULL,
  `population_density` float DEFAULT NULL,
  `male` int(11) DEFAULT NULL,
  `female` int(11) DEFAULT NULL,
  `sexratio` float DEFAULT NULL,
  `birth_since_nationaldivision` int(11) DEFAULT NULL,
  PRIMARY KEY (`year`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population_south`
--

LOCK TABLES `population_south` WRITE;
/*!40000 ALTER TABLE `population_south` DISABLE KEYS */;
INSERT INTO `population_south` VALUES (1999,46617,468.8,23458,23159,101.3,39210),(2000,47008,472.6,23667,23341,101.4,39790),(2001,47370,475.9,23855,23515,101.4,40340),(2002,47645,478.4,23991,23653,101.4,40801),(2003,47892,480.8,24121,23771,101.5,41242),(2004,48083,482.7,24211,23872,101.4,41628),(2005,48185,483.6,24243,23941,101.3,41918),(2006,48438,485.9,24370,24069,101.2,42351),(2007,48684,488.2,24491,24192,101.2,42781),(2008,49055,491.4,24672,24383,101.2,43332),(2009,49308,493.6,24774,24533,101,43763),(2010,49554,495.4,24881,24673,100.8,44188),(2011,49937,498.6,25070,24867,100.8,44755),(2012,50200,501.1,25187,25012,100.7,45204),(2013,50429,503,25285,25144,100.6,45621),(2014,50747,506,25445,25302,100.6,46123),(2015,51015,508.6,25586,25429,100.6,46579),(2016,51246,510.7,25694,25552,100.6,46992),(2017,51446,512.6,25790,25656,100.5,47379);
/*!40000 ALTER TABLE `population_south` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `population_south_AFTER_UPDATE` AFTER UPDATE ON `population_south` FOR EACH ROW BEGIN
update population_ns set population = (select population from population_north 
where new.year = population_north.year) + new.population where year = new.year;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-19 19:44:53
