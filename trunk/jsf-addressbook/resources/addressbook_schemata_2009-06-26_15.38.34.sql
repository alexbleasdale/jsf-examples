-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.4.1-beta


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema addressbook
--

CREATE DATABASE IF NOT EXISTS addressbook;
USE addressbook;

--
-- Definition of table `addressbook`.`address`
--

DROP TABLE IF EXISTS `addressbook`.`address`;
CREATE TABLE  `addressbook`.`address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_address1` varchar(128) DEFAULT NULL,
  `street_address2` varchar(128) DEFAULT NULL,
  `locality` varchar(128) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `postal_code` varchar(12) DEFAULT NULL,
  `country` varchar(2) DEFAULT NULL,
  `state` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `addressbook`.`address`
--

/*!40000 ALTER TABLE `address` DISABLE KEYS */;
LOCK TABLES `address` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


--
-- Definition of table `addressbook`.`contact_details`
--

DROP TABLE IF EXISTS `addressbook`.`contact_details`;
CREATE TABLE  `addressbook`.`contact_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `home_telephone` varchar(12) DEFAULT NULL,
  `mobile_telephone` varchar(12) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `gmaps_url` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `addressbook`.`contact_details`
--

/*!40000 ALTER TABLE `contact_details` DISABLE KEYS */;
LOCK TABLES `contact_details` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `contact_details` ENABLE KEYS */;


--
-- Definition of table `addressbook`.`location`
--

DROP TABLE IF EXISTS `addressbook`.`location`;
CREATE TABLE  `addressbook`.`location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `addressbook`.`location`
--

/*!40000 ALTER TABLE `location` DISABLE KEYS */;
LOCK TABLES `location` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;


--
-- Definition of table `addressbook`.`person`
--

DROP TABLE IF EXISTS `addressbook`.`person`;
CREATE TABLE  `addressbook`.`person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(64) DEFAULT NULL,
  `middle_name` varchar(64) DEFAULT NULL,
  `last_name` varchar(64) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `addressbook`.`person`
--

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
LOCK TABLES `person` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
