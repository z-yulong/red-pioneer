/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.27 : Database - red-pioneer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`red-pioneer` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `red-pioneer`;

/*Table structure for table `activist` */

DROP TABLE IF EXISTS `activist`;

CREATE TABLE `activist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT '888888' COMMENT '密码',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `date_of_birth` date DEFAULT NULL COMMENT '出生日期',
  `native_place` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `education` varchar(20) DEFAULT NULL COMMENT '学历',
  `admission_time` date DEFAULT NULL COMMENT '入学时间',
  `address` varchar(300) DEFAULT NULL COMMENT '地址',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `application_time` date DEFAULT NULL COMMENT '申请时间',
  `is_adult` varchar(2) DEFAULT NULL COMMENT '是否成年',
  `photo` varchar(300) DEFAULT NULL COMMENT '照片',
  `pyr_stu` int(11) DEFAULT NULL COMMENT '培养人',
  `pyr_techer` int(11) DEFAULT NULL COMMENT '培养人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


/*Table structure for table `conversation` */

DROP TABLE IF EXISTS `conversation`;

CREATE TABLE `conversation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activist_id` int(11) DEFAULT NULL,
  `prove` varchar(300) DEFAULT NULL COMMENT '佐证材料',
  `upload time` date DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `conversation` */

/*Table structure for table `fimaly` */

DROP TABLE IF EXISTS `fimaly`;

CREATE TABLE `fimaly` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relation` varchar(10) NOT NULL COMMENT '关系',
  `activist_id` int(11) NOT NULL COMMENT '积极分子id',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `date_of_birth` date DEFAULT NULL COMMENT '出生日期',
  `political` varchar(10) DEFAULT NULL COMMENT '政治面貌',
  `job` varchar(50) DEFAULT NULL COMMENT '职业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fimaly` */

/*Table structure for table `pyr_stu` */

DROP TABLE IF EXISTS `pyr_stu`;

CREATE TABLE `pyr_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pyr_stu` */

/*Table structure for table `pyr_techer` */

DROP TABLE IF EXISTS `pyr_techer`;

CREATE TABLE `pyr_techer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pyr_techer` */

/*Table structure for table `supper_admin` */

DROP TABLE IF EXISTS `supper_admin`;

CREATE TABLE `supper_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supper_admin` */

/*Table structure for table `volunteer` */

DROP TABLE IF EXISTS `volunteer`;

CREATE TABLE `volunteer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '谈话表id',
  `activist_id` int(11) NOT NULL,
  `prove` varchar(300) DEFAULT NULL COMMENT '佐证材料',
  `upload time` date DEFAULT NULL COMMENT '上传时间',
  `volunteer` int(11) DEFAULT NULL COMMENT '谈话人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `volunteer` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
