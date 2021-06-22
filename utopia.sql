DROP TABLE IF EXISTS `airplane_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airplane_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `max_capacity` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane_type`
--

LOCK TABLES `airplane_type` WRITE;
/*!40000 ALTER TABLE `airplane_type` DISABLE KEYS */;
INSERT INTO `airplane_type` VALUES (1,40),(2,80),(3,120),(4,200),(5,320),(6,520);
/*!40000 ALTER TABLE `airplane_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airport` (
  `iata_id` char(3) NOT NULL,
  `city` varchar(45) NOT NULL,
  PRIMARY KEY (`iata_id`),
  UNIQUE KEY `iata_id_UNIQUE` (`iata_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('ATL','Atlanta'),('BHM','Birmingham'),('BNA','Nashville'),('CHA','Chattanooga'),('CSG','Columbus'),('DHN','Dothan'),('ECP','Panama City'),('HSV','Hunstville'),('JAX','Jacksonville'),('MCO','Orlando'),('MEM','Memphis'),('MGM','Montgomery'),('MIA','Miami'),('MOB','Mobile'),('PNS','Pensacola'),('SAV','Savannah'),('TLH','Tallahassee'),('TYS','Knoxville'),('VLD','Valdosta'),('VPS','Fort Walton');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `is_active` tinyint(4) NOT NULL DEFAULT 1,
  `confirmation_code` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (48,0,'2021/05/23 22:29:34'),(49,0,'2021/05/23 22:29:38'),(50,0,'2021/05/23 22:29:41'),(51,0,'2021/05/23 22:29:45'),(52,0,'2021/05/23 22:29:54'),(53,0,'2021/05/23 22:29:56'),(54,0,'2021/05/23 22:29:59'),(55,0,'2021/05/23 22:30:01'),(56,0,'2021/05/23 22:42:47'),(57,0,'2021/05/23 22:42:49'),(58,0,'2021/05/23 22:42:52'),(59,0,'2021/05/23 22:42:55'),(60,0,'2021/05/23 22:48:10'),(61,0,'2021/05/23 22:48:13'),(62,0,'2021/05/23 22:48:15'),(63,0,'2021/05/23 22:48:17'),(64,0,'2021/05/23 22:54:07'),(65,0,'2021/05/23 22:54:19'),(76,0,'2021/05/24 12:49:41'),(77,0,'2021/05/24 12:49:45'),(78,0,'2021/05/24 12:49:48'),(79,0,'2021/05/24 12:49:51'),(80,0,'2021/05/24 14:36:56'),(81,0,'2021/05/24 14:40:27'),(82,0,'2021/05/24 16:25:28'),(83,1,'2021/05/24 16:26:11'),(84,1,'2021/05/24 16:26:36'),(85,0,'2021/05/24 16:26:55');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_agent`
--

DROP TABLE IF EXISTS `booking_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_agent` (
  `booking_id` int(10) unsigned NOT NULL,
  `agent_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  KEY `fk_booking_booker_user1_idx` (`agent_id`),
  CONSTRAINT `fk_booking_booker_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_booking_booker_user1` FOREIGN KEY (`agent_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_agent`
--

LOCK TABLES `booking_agent` WRITE;
/*!40000 ALTER TABLE `booking_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_guest`
--

DROP TABLE IF EXISTS `booking_guest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_guest` (
  `booking_id` int(10) unsigned NOT NULL,
  `contact_email` varchar(255) NOT NULL,
  `contact_phone` varchar(45) NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  CONSTRAINT `fk_booking_guest_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_guest`
--

LOCK TABLES `booking_guest` WRITE;
/*!40000 ALTER TABLE `booking_guest` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_payment`
--

DROP TABLE IF EXISTS `booking_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_payment` (
  `booking_id` int(10) unsigned NOT NULL,
  `stripe_id` varchar(255) NOT NULL,
  `refunded` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  KEY `fk_booking_payment_booking1_idx` (`booking_id`),
  CONSTRAINT `fk_booking_payment_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_payment`
--

LOCK TABLES `booking_payment` WRITE;
/*!40000 ALTER TABLE `booking_payment` DISABLE KEYS */;
INSERT INTO `booking_payment` VALUES (48,'randomizedStringGoesHere',0),(49,'randomizedStringGoesHere',0),(50,'randomizedStringGoesHere',0),(51,'randomizedStringGoesHere',0),(52,'randomizedStringGoesHere',0),(53,'randomizedStringGoesHere',0),(54,'randomizedStringGoesHere',0),(55,'randomizedStringGoesHere',0),(56,'randomizedStringGoesHere',0),(57,'randomizedStringGoesHere',0),(58,'randomizedStringGoesHere',0),(59,'randomizedStringGoesHere',0),(60,'randomizedStringGoesHere',0),(61,'randomizedStringGoesHere',0),(62,'randomizedStringGoesHere',0),(63,'randomizedStringGoesHere',0),(64,'randomizedStringGoesHere',0),(65,'randomizedStringGoesHere',0),(76,'randomizedStringGoesHere',0),(77,'randomizedStringGoesHere',0),(78,'randomizedStringGoesHere',0),(79,'randomizedStringGoesHere',0),(80,'randomizedStringGoesHere',0),(81,'randomizedStringGoesHere',0),(82,'randomizedStringGoesHere',0),(83,'randomizedStringGoesHere',0),(84,'randomizedStringGoesHere',0),(85,'randomizedStringGoesHere',0);
/*!40000 ALTER TABLE `booking_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_user`
--

DROP TABLE IF EXISTS `booking_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_user` (
  `booking_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_id_UNIQUE` (`booking_id`),
  KEY `fk_user_bookings_booking1_idx` (`booking_id`),
  KEY `fk_user_bookings_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_bookings_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_bookings_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_user`
--

LOCK TABLES `booking_user` WRITE;
/*!40000 ALTER TABLE `booking_user` DISABLE KEYS */;
INSERT INTO `booking_user` VALUES (48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1),(62,1),(63,1),(64,1),(65,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(83,1),(84,1),(85,1);
/*!40000 ALTER TABLE `booking_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `route_id` int(10) unsigned NOT NULL,
  `airplane_id` int(10) unsigned NOT NULL,
  `departure_time` datetime NOT NULL,
  `reserved_seats` int(10) unsigned NOT NULL,
  `seat_price` float NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_flight_airplane1_idx` (`airplane_id`),
  KEY `fk_tbl_flight_tbl_route1_idx` (`route_id`),
  CONSTRAINT `fk_flight_airplane1` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`id`),
  CONSTRAINT `fk_tbl_flight_tbl_route1` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,13,19,'2021-06-02 13:37:00',23,99.99),(2,113,5,'2021-06-03 16:00:00',15,99.99),(3,65,17,'2021-06-06 10:00:00',11,99.99),(4,103,21,'2021-06-06 13:37:00',8,99.99),(35,15,19,'2021-06-12 20:00:00',0,100);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_bookings`
--

DROP TABLE IF EXISTS `flight_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_bookings` (
  `flight_id` int(10) unsigned NOT NULL,
  `booking_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`booking_id`,`flight_id`),
  KEY `fk_flight_bookings_flight` (`flight_id`),
  CONSTRAINT `fk_flight_bookings_booking` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_flight_bookings_flight` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_bookings`
--

LOCK TABLES `flight_bookings` WRITE;
/*!40000 ALTER TABLE `flight_bookings` DISABLE KEYS */;
INSERT INTO `flight_bookings` VALUES (1,48),(2,49),(3,50),(4,51),(1,52),(2,53),(3,54),(4,55),(1,56),(2,57),(3,58),(4,59),(1,60),(2,61),(3,62),(4,63),(1,64),(1,65),(1,76),(2,77),(3,78),(4,79),(1,80),(1,81),(2,82),(1,83),(2,84),(1,85);
/*!40000 ALTER TABLE `flight_bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_passengers`
--

DROP TABLE IF EXISTS `flight_passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_passengers` (
  `flight_id` tinyint(4) NOT NULL,
  `booking_id` tinyint(4) NOT NULL,
  `passenger_id` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_passengers`
--

LOCK TABLES `flight_passengers` WRITE;
/*!40000 ALTER TABLE `flight_passengers` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_status`
--

DROP TABLE IF EXISTS `flight_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_status` (
  `id` tinyint(4) NOT NULL,
  `route_id` tinyint(4) NOT NULL,
  `airplane_id` tinyint(4) NOT NULL,
  `departure_time` tinyint(4) NOT NULL,
  `reserved_seats` tinyint(4) NOT NULL,
  `seat_price` tinyint(4) NOT NULL,
  `max_capacity` tinyint(4) NOT NULL,
  `passenger_count` tinyint(4) NOT NULL,
  `available_seats` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_status`
--

LOCK TABLES `flight_status` WRITE;
/*!40000 ALTER TABLE `flight_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_booking`
--

DROP TABLE IF EXISTS `guest_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_booking` (
  `id` tinyint(4) NOT NULL,
  `is_active` tinyint(4) NOT NULL,
  `confirmation_code` tinyint(4) NOT NULL,
  `contact_email` tinyint(4) NOT NULL,
  `contact_phone` tinyint(4) NOT NULL,
  `agent_id` tinyint(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_booking`
--

LOCK TABLES `guest_booking` WRITE;
/*!40000 ALTER TABLE `guest_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `booking_id` int(10) unsigned NOT NULL,
  `given_name` varchar(255) NOT NULL,
  `family_name` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_traveler_booking1_idx` (`booking_id`),
  CONSTRAINT `fk_traveler_booking1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (32,48,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(33,49,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(34,50,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(35,51,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(36,52,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(37,53,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(38,54,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(39,55,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(40,56,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(41,57,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(42,58,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(43,59,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(44,60,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(45,61,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(46,62,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(47,63,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(48,64,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(49,65,'Anita','Jacobs','2000-05-23','Not Specified','Unknown'),(58,76,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(59,77,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(60,78,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(61,79,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(62,80,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(63,81,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(64,82,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(65,83,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(66,84,'Anita','Jacobs','2000-05-24','Not Specified','Unknown'),(67,85,'Anita','Jacobs','2000-05-24','Not Specified','Unknown');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `origin_id` char(3) NOT NULL,
  `destination_id` char(3) NOT NULL,
  PRIMARY KEY (`id`,`origin_id`,`destination_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `unique_route` (`origin_id`,`destination_id`),
  KEY `fk_route_airport1_idx` (`origin_id`),
  KEY `fk_route_airport2_idx` (`destination_id`),
  CONSTRAINT `fk_route_airport1` FOREIGN KEY (`origin_id`) REFERENCES `airport` (`iata_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_route_airport2` FOREIGN KEY (`destination_id`) REFERENCES `airport` (`iata_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'CHA','BNA'),(2,'CHA','MEM'),(3,'CHA','TYS'),(4,'TYS','BNA'),(5,'TYS','CHA'),(6,'TYS','MEM'),(7,'MEM','BNA'),(8,'MEM','CHA'),(9,'MEM','TYS'),(10,'BNA','CHA'),(11,'BNA','MEM'),(12,'BNA','TYS'),(13,'BNA','ATL'),(14,'CHA','ATL'),(15,'MEM','ATL'),(16,'TYS','ATL'),(17,'ECP','TLH'),(18,'ECP','PNS'),(19,'ECP','MIA'),(20,'ECP','VPS'),(21,'ECP','JAX'),(22,'ECP','MCO'),(23,'TLH','ECP'),(24,'TLH','PNS'),(25,'TLH','MIA'),(26,'TLH','VPS'),(27,'TLH','JAX'),(28,'TLH','MCO'),(29,'PNS','TLH'),(30,'PNS','ECP'),(31,'PNS','MIA'),(32,'PNS','VPS'),(33,'PNS','JAX'),(34,'PNS','MCO'),(35,'MIA','TLH'),(36,'MIA','ECP'),(37,'MIA','PNS'),(38,'MIA','VPS'),(39,'MIA','JAX'),(40,'MIA','MCO'),(41,'VPS','TLH'),(42,'VPS','ECP'),(43,'VPS','PNS'),(44,'VPS','MIA'),(45,'VPS','JAX'),(46,'VPS','MCO'),(47,'JAX','TLH'),(48,'JAX','ECP'),(49,'JAX','PNS'),(50,'JAX','MIA'),(51,'JAX','VPS'),(52,'JAX','MCO'),(53,'MCO','TLH'),(54,'MCO','ECP'),(55,'MCO','PNS'),(56,'MCO','MIA'),(57,'MCO','VPS'),(58,'MCO','JAX'),(59,'TLH','ATL'),(60,'MCO','ATL'),(61,'JAX','ATL'),(62,'VPS','ATL'),(63,'MIA','ATL'),(64,'PNS','ATL'),(65,'ECP','ATL'),(66,'ATL','SAV'),(67,'ATL','CSG'),(68,'ATL','VLD'),(69,'SAV','ATL'),(70,'SAV','CSG'),(71,'SAV','VLD'),(72,'CSG','ATL'),(73,'CSG','SAV'),(74,'CSG','VLD'),(75,'VLD','ATL'),(76,'VLD','SAV'),(77,'VLD','CSG'),(78,'BHM','DHN'),(79,'BHM','HSV'),(80,'BHM','MOB'),(81,'BHM','MGM'),(82,'DHN','BHM'),(83,'DHN','HSV'),(84,'DHN','MOB'),(85,'DHN','MGM'),(86,'HSV','BHM'),(87,'HSV','DHN'),(88,'HSV','MOB'),(89,'HSV','MGM'),(90,'MOB','BHM'),(91,'MOB','DHN'),(92,'MOB','HSV'),(93,'MOB','MGM'),(94,'MGM','BHM'),(95,'MGM','DHN'),(96,'MGM','HSV'),(97,'MGM','MOB'),(98,'BHM','ATL'),(99,'DHN','ATL'),(100,'HSV','ATL'),(101,'MOB','ATL'),(102,'MGM','ATL'),(103,'ATL','BNA'),(104,'ATL','CHA'),(105,'ATL','MEM'),(106,'ATL','TYS'),(107,'ATL','TLH'),(108,'ATL','MCO'),(109,'ATL','JAX'),(110,'ATL','VPS'),(111,'ATL','MIA'),(112,'ATL','PNS'),(113,'ATL','ECP'),(114,'ATL','BHM'),(115,'ATL','DHN'),(116,'ATL','HSV'),(117,'ATL','MOB'),(118,'ATL','MGM'),(198,'BNA','ECP');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned NOT NULL,
  `given_name` varchar(255) NOT NULL,
  `family_name` varchar(255) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_user_user_role1_idx` (`role_id`),
  CONSTRAINT `fk_user_user_role1` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,2,'Anita','Jacobs','ajacobs','anita.jacobs@example.com','woofwoof','158-266-6285'),(2,2,'Diane','Walters','dwalters','diane.walters@example.com','enterprise','336-478-9296'),(3,2,'Rachel','Boyd','rboyd','rachel.boyd@example.com','credit','518-616-3007'),(4,2,'Charlotte','Olson','colson','charlotte.olson@example.com','carolina','984-098-7672'),(5,2,'Joseph','Campbell','jcampbell','joseph.campbell@example.com','fang','463-740-3816'),(6,2,'Melanie','Lambert','mlambert','melanie.lambert@example.com','booger','049-518-8667'),(7,2,'Serenity','Hunter','shunter','serenity.hunter@example.com','5rxypn','439-593-4217'),(8,2,'Holly','Rivera','hrivera','holly.rivera@example.com','redeye','416-871-1776'),(9,2,'Seth','Pearson','spearson','seth.pearson@example.com','poiuy','889-999-9347'),(10,2,'Lillian','Hansen','lhansen','lillian.hansen@example.com','toto','139-295-7060'),(11,2,'Philip','Campbell','pcampbell','philip.campbell@example.com','brooks','510-136-1949'),(12,2,'Rosemary','Roberts','rroberts','rosemary.roberts@example.com','prime','874-028-8634'),(13,1,'Mabel','Barnes','mabel.barnes','mabel.barnes@utopia.com','renee','475-872-4486'),(14,1,'Evan','Williamson','evan.williamson','evan.williamson@utopia.com','crazy1','562-834-1298'),(15,1,'Kent','Jensen','kent.jensen','kent.jensen@utopia.com','tundra','313-369-3310'),(16,1,'Devon','Silva','devon.silva','devon.silva@utopia.com','tundra','137-067-4388'),(17,1,'Evelyn','Evans','evelyn.evans','evelyn.evans@utopia.com','jimmy1','961-213-2463'),(18,3,'Jim','Warren','jim.warren','jim.warren@utopia.com','hershey','869-788-2037'),(19,3,'Ron','Nguyen','ron.nguyen','ron.nguyen@utopia.com','abby','376-855-7444');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (3,'administrator'),(1,'employee'),(2,'traveler');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-18 18:53:29
