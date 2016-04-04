-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: localhost    Database: tourism2
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `t_activity`
--

DROP TABLE IF EXISTS `t_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_activity` (
  `_activity_id` varchar(32) NOT NULL,
  `_activity_name` varchar(20) NOT NULL,
  `_title` varchar(120) NOT NULL DEFAULT 'no title',
  `_short_desc` varchar(120) NOT NULL DEFAULT 'no describe',
  `_publisher_id` varchar(32) NOT NULL,
  `_age_range` varchar(20) NOT NULL,
  `_age_flag` int(11) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_destination` varchar(20) NOT NULL,
  `_dest_type` int(11) NOT NULL,
  `_content` text NOT NULL,
  `_count` int(11) NOT NULL DEFAULT '0',
  `_image` varchar(40) NOT NULL,
  `_type` int(11) NOT NULL,
  PRIMARY KEY (`_activity_id`),
  KEY `_publisher_id` (`_publisher_id`),
  CONSTRAINT `t_activity_ibfk_1` FOREIGN KEY (`_publisher_id`) REFERENCES `t_company` (`_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_activity`
--

LOCK TABLES `t_activity` WRITE;
/*!40000 ALTER TABLE `t_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `_user_id` varchar(32) NOT NULL,
  `_username` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`_user_id`),
  UNIQUE KEY `_username` (`_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comment` (
  `_comment_id` varchar(32) NOT NULL,
  `_publisher_id` varchar(32) NOT NULL,
  `_content` text NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_to_id` varchar(32) NOT NULL,
  `_type` varchar(20) DEFAULT NULL,
  `_type_flag` int(11) NOT NULL,
  `_reply_id` varchar(32) NOT NULL,
  PRIMARY KEY (`_comment_id`),
  KEY `_publisher_id` (`_publisher_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`_publisher_id`) REFERENCES `t_user` (`_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_company`
--

DROP TABLE IF EXISTS `t_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_company` (
  `_company_id` varchar(32) NOT NULL,
  `_company_name` varchar(20) NOT NULL,
  `_content` text NOT NULL,
  `_join_time` datetime NOT NULL,
  PRIMARY KEY (`_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_company`
--

LOCK TABLES `t_company` WRITE;
/*!40000 ALTER TABLE `t_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_knowledge`
--

DROP TABLE IF EXISTS `t_knowledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_knowledge` (
  `_nlg_id` varchar(32) NOT NULL,
  `_nlg_name` varchar(20) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_content` text NOT NULL,
  PRIMARY KEY (`_nlg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_knowledge`
--

LOCK TABLES `t_knowledge` WRITE;
/*!40000 ALTER TABLE `t_knowledge` DISABLE KEYS */;
INSERT INTO `t_knowledge` VALUES ('ADSFADFASDFASDFASDFAS','为什么兔子不能喝水','2016-02-16 22:00:00','无论动物还是植物都离不开水，兔子也一样。但是为什么兔子平时不能喝水呢？因为兔子的主食青菜里面含有大量水分，足够身体的需要。而且它的消化器官很脆弱，肠里面的水一多，就会患肠胃炎，不停地拉肚子，如果治疗不当，还会死掉。但是兔子体内缺水时，也是可以喝的'),('AFASDFBSFDGHSFDG','鸡有耳朵吗 ','2016-02-16 22:00:00','鸡和小兔、猫等等这些小动物一样是有耳朵的。不过，它的耳朵生的挺巧妙，只有耳孔，没有耳朵壳。你仔细瞧一下，在鸡眼睛后边有一撮稍凸起的毛，毛背后就是耳朵孔，这样的耳朵虫子钻不进去，雨水也淋不着。');
/*!40000 ALTER TABLE `t_knowledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_package`
--

DROP TABLE IF EXISTS `t_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_package` (
  `_package_id` varchar(32) NOT NULL,
  `_pkg_name` varchar(20) NOT NULL,
  `_activity_id` varchar(32) NOT NULL,
  `_pub_time` datetime NOT NULL,
  `_active_time` datetime NOT NULL,
  `_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `_content` text NOT NULL,
  `_title` varchar(120) NOT NULL DEFAULT 'no title',
  PRIMARY KEY (`_package_id`),
  KEY `_activity_id` (`_activity_id`),
  CONSTRAINT `t_package_ibfk_1` FOREIGN KEY (`_activity_id`) REFERENCES `t_activity` (`_activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_package`
--

LOCK TABLES `t_package` WRITE;
/*!40000 ALTER TABLE `t_package` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_plan`
--

DROP TABLE IF EXISTS `t_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_plan` (
  `_plan_id` varchar(32) NOT NULL,
  `_publisher_id` varchar(32) DEFAULT NULL,
  `_plan_name` varchar(20) NOT NULL,
  `_destination` varchar(20) NOT NULL,
  `_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `_people_num` int(11) NOT NULL,
  `_content` text NOT NULL,
  `_image` varchar(40) NOT NULL DEFAULT 'default',
  `_type` int(11) NOT NULL,
  `_created_time` datetime NOT NULL,
  `_start_time` datetime NOT NULL,
  `_end_time` datetime NOT NULL,
  `_active_time` datetime NOT NULL,
  PRIMARY KEY (`_plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_plan`
--

LOCK TABLES `t_plan` WRITE;
/*!40000 ALTER TABLE `t_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_purchase`
--

DROP TABLE IF EXISTS `t_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_purchase` (
  `_purchase_id` varchar(32) NOT NULL,
  `_owner_id` varchar(32) NOT NULL,
  `_package_id` varchar(32) NOT NULL,
  `_count` int(11) NOT NULL,
  `_purchase_date` datetime NOT NULL,
  `_status` varchar(4) NOT NULL,
  `_rate_status` varchar(3) NOT NULL,
  PRIMARY KEY (`_purchase_id`),
  KEY `_owner_id` (`_owner_id`),
  KEY `_package_id` (`_package_id`),
  CONSTRAINT `t_purchase_ibfk_1` FOREIGN KEY (`_owner_id`) REFERENCES `t_user` (`_user_id`),
  CONSTRAINT `t_purchase_ibfk_2` FOREIGN KEY (`_package_id`) REFERENCES `t_package` (`_package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_purchase`
--

LOCK TABLES `t_purchase` WRITE;
/*!40000 ALTER TABLE `t_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tel`
--

DROP TABLE IF EXISTS `t_tel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_tel` (
  `_tel_id` varchar(32) NOT NULL,
  `_owner_id` varchar(32) NOT NULL,
  `_friend_id` varchar(32) NOT NULL,
  PRIMARY KEY (`_tel_id`),
  KEY `_owner_id` (`_owner_id`),
  KEY `_friend_id` (`_friend_id`),
  CONSTRAINT `t_tel_ibfk_1` FOREIGN KEY (`_owner_id`) REFERENCES `t_user` (`_user_id`),
  CONSTRAINT `t_tel_ibfk_2` FOREIGN KEY (`_friend_id`) REFERENCES `t_user` (`_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tel`
--

LOCK TABLES `t_tel` WRITE;
/*!40000 ALTER TABLE `t_tel` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_topic`
--

DROP TABLE IF EXISTS `t_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_topic` (
  `_tpc_id` varchar(32) NOT NULL,
  `_tpc_name` varchar(20) NOT NULL,
  `_title` varchar(120) NOT NULL DEFAULT 'no title',
  `_image` varchar(40) NOT NULL DEFAULT 'default',
  `_content` text NOT NULL,
  `_people_num` int(11) NOT NULL DEFAULT '0',
  `_publisher_id` varchar(32) NOT NULL,
  `_pub_time` datetime NOT NULL,
  PRIMARY KEY (`_tpc_id`),
  KEY `_publisher_id` (`_publisher_id`),
  CONSTRAINT `t_topic_ibfk_1` FOREIGN KEY (`_publisher_id`) REFERENCES `t_user` (`_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_topic`
--

LOCK TABLES `t_topic` WRITE;
/*!40000 ALTER TABLE `t_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `_user_id` varchar(32) NOT NULL,
  `_user_name` varchar(20) NOT NULL,
  `_password` varchar(32) NOT NULL,
  `_nick_name` varchar(20) DEFAULT NULL,
  `_name` varchar(20) DEFAULT NULL,
  `_created_time` datetime NOT NULL,
  `_last_login` datetime DEFAULT NULL,
  `_image` varchar(40) NOT NULL DEFAULT 'default',
  `_sex` varchar(5) DEFAULT NULL,
  `_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`_user_id`),
  UNIQUE KEY `_user_name` (`_user_name`),
  UNIQUE KEY `_phone` (`_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES ('54370719F09645BDAA762461922BFE69','18957612452@tourism','E10ADC3949BA59ABBE56E057F20F883E','即把','王巴阿','2016-04-03 21:26:24',NULL,'default','男','18957612452'),('73A432643D21F290281AAF8A30131AAB','ni','asdfasdfas','操你妈','傻逼','2016-12-22 00:00:00','2016-11-22 00:00:00','default','男','18574447444'),('8A122D100B4A293E9533F47F1A969701','18957612454@tourism','E10ADC3949BA59ABBE56E057F20F883E','即把','ha巴阿','2016-04-03 21:26:48',NULL,'default','男','18957612454'),('9B4F665DA234AE4BB35C28BA2266C8D8','18957612453@tourism','E10ADC3949BA59ABBE56E057F20F883E','即把','haha巴阿','2016-04-03 21:26:38',NULL,'default','男','18957612453'),('F059F45B6ACA202B3E8CDBBB5E3AEAA6','18957137624@tourism','E10ADC3949BA59ABBE56E057F20F883E','null','null','2016-04-04 18:49:06',NULL,'default','男','18957137624'),('F6877F362F2656EA7901286F6E529D6B','18957612451@tourism','E10ADC3949BA59ABBE56E057F20F883E','即把','王巴阿','2016-04-03 21:17:46',NULL,'default','男','18957612451');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_zan`
--

DROP TABLE IF EXISTS `t_zan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_zan` (
  `_zan_id` varchar(32) NOT NULL,
  `_owner_id` varchar(32) NOT NULL,
  `_public_time` datetime NOT NULL,
  `_type_flag` int(11) NOT NULL,
  `_object_id` varchar(32) NOT NULL,
  PRIMARY KEY (`_zan_id`),
  KEY `_owner_id` (`_owner_id`),
  CONSTRAINT `t_zan_ibfk_1` FOREIGN KEY (`_owner_id`) REFERENCES `t_user` (`_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_zan`
--

LOCK TABLES `t_zan` WRITE;
/*!40000 ALTER TABLE `t_zan` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_zan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-04 19:19:41
