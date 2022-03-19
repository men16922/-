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
-- Table structure for table `scenarios`
--

DROP TABLE IF EXISTS `scenarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `scenarios` (
  `scnearion` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `contents` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`scnearion`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scenarios`
--

LOCK TABLES `scenarios` WRITE;
/*!40000 ALTER TABLE `scenarios` DISABLE KEYS */;
INSERT INTO `scenarios` VALUES (1,'최고인구(남북)','SELECT MAX(year) AS 년도, MAX(population) AS 인구 , MAX(population_density) AS 인구밀집도 , MAX(male) As 남 , MAX(female) As 여 FROM population_ns'),(2,'가장 많이 본 뉴스','SELECT title, count FROM test.news WHERE count = (SELECT MAX(count) FROM test.news);'),(3,'북한의 coal생산량이 25000 보다 큰 경우','SELECT year, coal FROM test.resources WHERE ns = 1 AND coal>25000;'),(4,'남한의 누적 coal 생산량','SELECT SUM(coal) FROM test.resources WHERE ns=2;'),(5,'남북한 합계 인구 중 남자 인구수가 30000보다 크고 35000보다 작을 때','SELECT year,population,population_density,male,female FROM population_ns WHERE male BETWEEN 33000 AND 35000;'),(6,' 2002년에 최대 풍속인 지역','SELECT distribution, wind_speed FROM test.environment WHERE year = \'2002\' AND wind_speed = (SELECT MAX(wind_speed) FROM test.environment);'),(7,' 유저별 포스트 개수','SELECT author, count(title) AS count FROM test.bulletin GROUP BY author;'),(8,' 1 과 2를 north와 south로 바꾸기','SELECT distribution, year, temperature, precipitation, CASE WHEN ns = 1 THEN \'north\' WHEN ns=2 THEN \'south\' END AS NorthOrSouth FROM test.environment;'),(9,'북한의 남녀 인구의 합','SELECT year, male + female FROM population_north;'),(10,'남북의 남자 인구수 합','SELECT population_north.year, population_north.male + population_south.male AS population_male FROM population_north, population_south;'),(11,'특정 사용자가 존재하는지','SELECT * FROM test.user WHERE name IN(\'가브리엘\');'),(12,'d가 1,2,3이 아닌 것','SELECT * FROM test.dictionary WHERE id NOT IN(1, 2, 3);'),(13,'gabi의 코멘트','SELECT comment,author,date,title FROM test.comment where author=\'gabi\''),(14,'삭제된 포스트의 개수','SELECT count(title) AS count FROM test.bulletin_trash GROUP BY author;'),(15,'삭제된 포스트들','SELECT title,author,date FROM test.bulletin_trash;'),(16,'뉴스 조회수별 오름차순정렬','select * from test.news order by count asc'),(17,'뉴스 조회수별 내림차순정렬','select * from news order by count desc;');
/*!40000 ALTER TABLE `scenarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-19 19:44:56
