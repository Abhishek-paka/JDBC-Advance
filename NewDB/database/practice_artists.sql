-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: practice
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `artists`
--

LOCK TABLES `artists` WRITE;
/*!40000 ALTER TABLE `artists` DISABLE KEYS */;
INSERT INTO `artists` VALUES (1,'Mahogany Rush'),(2,'Elf'),(3,'One Kitten'),(4,'Big Brother & The Holding Company'),(5,'Roy Harper'),(6,'Pat Benatar'),(7,'Rory Gallagher'),(8,'Iron Maiden'),(9,'Blaster Bates'),(10,'Procol Harum'),(11,'1000 Maniacs'),(12,'Wishbone Ash'),(13,'Nazareth'),(14,'Crosby Stills Nash & Young'),(15,'George Thorogood & The Destroyers'),(16,'Axel Rudi Pell'),(17,'Leaf Hound'),(18,'Budgie'),(19,'Commitments'),(20,'Enigma'),(21,'Kevin Bloody Wilson'),(22,'Pixies'),(23,'ZZ Top'),(24,'Pressgang'),(25,'Hayseed Dixie'),(26,'Paco De Lucia'),(27,'Ted Nugent'),(28,'Hawkwind'),(29,'Status Quo'),(30,'Dusty Springfield'),(31,'Soundtracks'),(32,'Dream Theater'),(33,'Peter Gabriel'),(34,'Imelda May'),(35,'Dio'),(36,'Black Sabbath'),(37,'Dr Feelgood'),(38,'Carole King'),(39,'Heart'),(40,'Chopyn'),(41,'Darkness'),(42,'Jimmy Page & Robert Plant'),(43,'Vangelis'),(44,'Black Oak Arkansas'),(45,'Lou Reed'),(46,'Oasis'),(47,'Manfred Mann'),(48,'Tomita'),(49,'Mood Elevator'),(50,'Warner E Hodges'),(51,'Be Bop Deluxe'),(52,'Ozric Tentacles'),(53,'Florence And The Machine'),(54,'Bon Jovi'),(55,'Jefferson Airplane'),(56,'Rolling Stones'),(57,'Mountain'),(58,'Guess Who'),(59,'Vladimir Vysotsky'),(60,'Frank Zappa Captain Beefheart & The Mothers'),(61,'Steve Vai'),(62,'Black River Project'),(63,'Treatment'),(64,'Led Zeppelin'),(65,'Bruce Springsteen'),(66,'AC DC'),(67,'Velvet Underground'),(68,'Man'),(69,'Animals'),(70,'Prokofiev'),(71,'Thin Lizzy'),(72,'Blackbeard\'s Tea Party'),(73,'Arlo Guthrie'),(74,'Ry Cooder'),(75,'Leatherat'),(76,'Ozzy Osbourne'),(77,'Jefferson Starship'),(78,'Smetana'),(79,'Extreme'),(80,'Ian Gillan'),(81,'Lone Star'),(82,'Uriah Heep'),(83,'John Lee Hooker'),(84,'Van Halen'),(85,'John Martyn'),(86,'10cc'),(87,'Rachel Portman'),(88,'Jakatta'),(89,'Pearl Jam'),(90,'Jimi Hendrix'),(91,'Kate Bush'),(92,'Fleetwood Mac'),(93,'Foo Fighters'),(94,'Robert Calvert'),(95,'New Model Army'),(96,'Steppenwolf'),(97,'Camel'),(98,'Beth Orton'),(99,'Tom Lehrer'),(100,'Michael Moorcock and the Deep Fix'),(101,'Free'),(102,'The Clan'),(103,'Madonna'),(104,'Allan Holdsworth'),(105,'David Bowie'),(106,'Judas Priest'),(107,'Steely Dan'),(108,'Ennio Morricone'),(109,'Terry Reid'),(110,'Dread Zeppelin'),(111,'Mumford & Sons'),(112,'Emerson Lake & Palmer'),(113,'Horslips'),(114,'Blue Öyster Cult'),(115,'UFO'),(116,'Genesis'),(117,'Lenny Kravitz'),(118,'Primordial Soup'),(119,'Bob Marley'),(120,'Carl Orff'),(121,'The Killers'),(122,'O.S.T.'),(123,'White Zombie'),(124,'Bonzo Dog Band'),(125,'Evanescence'),(126,'Cream'),(127,'Tom Jones'),(128,'Edvard Grieg'),(129,'Meredith Brooks'),(130,'Pink Floyd'),(131,'King Crimson'),(132,'Joe Bonamassa'),(133,'Black Keys'),(134,'Dire Straits'),(135,'Bernie Torme'),(136,'Velvet Revolver'),(137,'Doors'),(138,'Richard Ashcroft'),(139,'Bo Didley'),(140,'Frank Zappa'),(141,'Mussorgsky'),(142,'Faith No More'),(143,'Meat Loaf'),(144,'Neutrons'),(145,'B.B. King'),(146,'Joe Satriani'),(147,'Thunder'),(148,'Yardbirds'),(149,'Gorillaz'),(150,'Foreigner'),(151,'J.J. Cale'),(152,'Aerosmith'),(153,'Troggs'),(154,'Biffy Clyro'),(155,'Howlin\' Wolf'),(156,'Marillion'),(157,'Stone Roses'),(158,'Clannad'),(159,'Jeff Buckley'),(160,'Rainbow'),(161,'Corey Taylor'),(162,'Kula Shaker'),(163,'Bachman Turner Overdrive'),(164,'Captain Beefheart'),(165,'Eric Serra'),(166,'Eric Clapton'),(167,'Chumbawamba'),(168,'Grover Washinton Jr'),(169,'Guns N\' Roses'),(170,'Steve Harley & Cockney Rebel'),(171,'Queen'),(172,'Sweet'),(173,'Steve Hillage'),(174,'Iggy Pop'),(175,'Seasick Steve'),(176,'Billy Idol'),(177,'Split Whiskers'),(178,'Alice Cooper'),(179,'Yngwie Malmsteen'),(180,'Steve Hackett'),(181,'Beatles'),(182,'DragonForce'),(183,'Jools Holland'),(184,'Gary Moore'),(185,'Heaven & Hell'),(186,'Paul Giovanni'),(187,'John Paul Jones'),(188,'Billy Joel'),(189,'Bad Company'),(190,'Patti Smith'),(191,'Black Crowes'),(192,'Metallica'),(193,'U2'),(194,'Garbage'),(195,'Pink Fairies'),(196,'Deep Purple'),(197,'T.Rex'),(198,'Tom Petty & The Heartbreakers'),(199,'Thomas Tallis'),(200,'Stevie Ray Vaughan'),(201,'Chemical Brothers'),(202,''),(203,'Yo Yo Honey Singh');
/*!40000 ALTER TABLE `artists` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-02  0:01:37
