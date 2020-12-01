/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.11-MariaDB : Database - softverskipaterni_stefan_lezaic_1061_17
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`softverskipaterni_stefan_lezaic_1061_17` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `softverskipaterni_stefan_lezaic_1061_17`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `Counter` int(11) DEFAULT 0,
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 
('rezervacija',5);

/*Table structure for table `rezervacija` */

DROP TABLE IF EXISTS `rezervacija`;

CREATE TABLE `rezervacija` (
  `sifraRezervacije` int(11) NOT NULL,
  `nazivDogadjaja` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `sifraKlijenta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `brojKarata` int(11) NOT NULL,
  `tipDogadjaja` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`sifraRezervacije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `rezervacija` */

insert  into `rezervacija`(`sifraRezervacije`,`nazivDogadjaja`,`sifraKlijenta`,`brojKarata`,`tipDogadjaja`,`datum`) values 
(2,'Koncert','Zika',2,'KULTURNI','2020-12-01'),
(3,'Fudbalska utakmica','Mika',4,'SPORTSKI','2020-12-01'),
(4,'Beer Fest','Ljuba',4,'OSTALO','2020-12-01'),
(5,'Klizanje','Mika',4,'OSTALO','2020-12-01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
