-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: fakenews
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `article_source`
--

DROP TABLE IF EXISTS `article_source`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_source` (
  `pairingID` int(11) NOT NULL,
  `sourceID` int(11) NOT NULL,
  `articleID` int(11) NOT NULL,
  `comments` varchar(45) NOT NULL,
  PRIMARY KEY (`pairingID`,`sourceID`,`articleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_source`
--

LOCK TABLES `article_source` WRITE;
/*!40000 ALTER TABLE `article_source` DISABLE KEYS */;
INSERT INTO `article_source` VALUES (1,1,1,'Simple updating'),(2,2,2,'Simple pairing'),(3,3,3,'articles matched'),(4,4,4,'source and article paired');
/*!40000 ALTER TABLE `article_source` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `articleID` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `validityRating` decimal(3,0) NOT NULL,
  `partyAffected` varchar(45) NOT NULL,
  `response` varchar(45) CHARACTER SET hp8 NOT NULL,
  `responseBy` varchar(45) NOT NULL,
  `responseDesc` varchar(45) NOT NULL,
  PRIMARY KEY (`articleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (1,'New Game Will Rock Your World','article about popular game','0000-00-00',1,'Gamers','Y','Klaus Windhelm','agreeable'),(2,'President is a Joke','article about the state of the union','0000-00-00',1,'The World','Y','Scott Williams','disagreeable'),(3,'Music is the Best Thing in the World','article about a passion for music','0000-00-00',1,'Music Listeners','N','',''),(4,'Live Your Life','article about living well','0000-00-00',1,'Stressed People','Y','Olivia Benson','appreciative');
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sources`
--

DROP TABLE IF EXISTS `sources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sources` (
  `sourceID` int(11) NOT NULL,
  `sourceName` varchar(45) NOT NULL,
  `sourceGroup` varchar(45) NOT NULL,
  `mediaCategory` varchar(45) NOT NULL,
  `sourceLocation` varchar(45) NOT NULL,
  PRIMARY KEY (`sourceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sources`
--

LOCK TABLES `sources` WRITE;
/*!40000 ALTER TABLE `sources` DISABLE KEYS */;
INSERT INTO `sources` VALUES (1,'Lance Robinson','CNN','internet','global'),(2,'Big Sal','Troll News','internet','global'),(3,'Wanda Reynolds','Fox News','internet','global'),(4,'Mike Barclay','Channel 2','internet','global');
/*!40000 ALTER TABLE `sources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('craig1234@uga.edu','1234'),('garrettabc@yahoo.com','abc'),('kb123@yahoo.com','123'),('waldoislost@aol.com','help');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'fakenews'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-11 23:17:41
