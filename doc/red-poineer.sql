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
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `date_of_birth` date DEFAULT NULL COMMENT '出生日期',
  `native_place` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `admission_time` date DEFAULT NULL COMMENT '入学时间',
  `address` varchar(300) DEFAULT NULL COMMENT '地址',
  `id_card` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `tel` varchar(15) DEFAULT NULL COMMENT '电话',
  `application_time` date DEFAULT NULL COMMENT '申请时间',
  `photo` varchar(300) DEFAULT NULL COMMENT '照片',
  `leader_stu` int(11) DEFAULT NULL COMMENT '党小组组长',
  `leader_techer` int(11) DEFAULT NULL COMMENT '培养人_老师',
  `diploma` varchar(300) DEFAULT NULL COMMENT '积极分子结业证',
  `upactivist_time` date DEFAULT NULL COMMENT '成为积极分子时间',
  `roles` varchar(50) DEFAULT 'user' COMMENT '角色',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限',
  `classes` varchar(50) DEFAULT NULL COMMENT '班级',
  `state` varchar(10) DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1154 DEFAULT CHARSET=utf8;

/*Data for the table `activist` */

insert  into `activist`(`id`,`account`,`password`,`name`,`sex`,`nation`,`date_of_birth`,`native_place`,`admission_time`,`address`,`id_card`,`tel`,`application_time`,`photo`,`leader_stu`,`leader_techer`,`diploma`,`upactivist_time`,`roles`,`permission`,`classes`,`state`) values (1,'admin','888888','王力宏','男','汉','1989-01-01','内蒙古','2019-12-11','内蒙古自治区巴彦淖尔市临河区白脑包镇福利村五组八栋2号','152801200010066216','15148849209','2019-12-12','',235,178,'4/E/1025224svgcvg.jpg','2019-12-11','admin','100',NULL,'1'),(2,'shuji','888888','周杰伦','男','汉','1990-01-12','内蒙古','2019-12-12','内蒙古自治区巴彦淖尔市临河区白脑包镇福利村五组八栋2号','152801200010066216','15148849209','2019-12-12','',0,0,'','2019-12-12','shuji','200',NULL,'1'),(3,'zuzhang','888888','刘德华','男','汉','1983-01-11','内蒙古','2019-12-11','内蒙古自治区巴彦淖尔市临河区白脑包镇福利村五组八栋1号','152801200010066216','15148849209','2019-12-12','',235,178,'2/E/1025224svgcvg.jpg','2019-12-11','zuzhang','300',NULL,'1'),(4,'user','888888','周润发','男','汉','1970-12-17','内蒙古','2019-12-11','内蒙古自治区巴彦淖尔市临河区白脑包镇福利村五组八栋2号','152801200010066216','15148849209','2019-12-12',NULL,NULL,NULL,NULL,'2019-12-11','user','400',NULL,'1'),(1151,'test','888888','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'user',NULL,NULL,'1'),(1152,'qwe',NULL,'zyl',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'shuji',NULL,NULL,NULL),(1153,'1156211195','888888',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'user',NULL,NULL,'1');

/*Table structure for table `conversation` */

DROP TABLE IF EXISTS `conversation`;

CREATE TABLE `conversation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '志愿服务表主键',
  `activist_id` int(11) DEFAULT NULL COMMENT '用户表主键',
  `prove` varchar(300) DEFAULT NULL COMMENT '佐证材料',
  `volunteer time` date DEFAULT NULL COMMENT '志愿时间',
  `volunteer_size` varchar(50) DEFAULT NULL COMMENT '志愿时长',
  `volunteer_address` varchar(100) DEFAULT NULL COMMENT '服务地点',
  `volunteer_info` varchar(300) DEFAULT NULL COMMENT '服务内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `conversation` */

insert  into `conversation`(`id`,`activist_id`,`prove`,`volunteer time`,`volunteer_size`,`volunteer_address`,`volunteer_info`) values (1,4,'qwe','2021-12-08','23',NULL,NULL);

/*Table structure for table `cultivate_people` */

DROP TABLE IF EXISTS `cultivate_people`;

CREATE TABLE `cultivate_people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '培养人姓名',
  `time_of_joining_the_party` date DEFAULT NULL COMMENT '入党时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cultivate_people` */

/*Table structure for table `history_activist` */

DROP TABLE IF EXISTS `history_activist`;

CREATE TABLE `history_activist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '历史表主键',
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `native_place` varchar(50) DEFAULT NULL,
  `admission_time` date DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `application_time` date DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL,
  `leader_stu` int(11) DEFAULT NULL,
  `leader_techer` int(11) DEFAULT NULL,
  `diploma` varchar(300) DEFAULT NULL,
  `upactivist_time` date DEFAULT NULL,
  `roles` varchar(50) DEFAULT NULL,
  `permission` varchar(50) DEFAULT NULL,
  `classes` varchar(50) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `history_activist` */

/*Table structure for table `leader_stu` */

DROP TABLE IF EXISTS `leader_stu`;

CREATE TABLE `leader_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activist_id` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leader_stu` */

/*Table structure for table `leader_techer` */

DROP TABLE IF EXISTS `leader_techer`;

CREATE TABLE `leader_techer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activist_id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leader_techer` */

/*Table structure for table `party_branch` */

DROP TABLE IF EXISTS `party_branch`;

CREATE TABLE `party_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '支部名称',
  `secretary` int(11) DEFAULT NULL COMMENT '负责人id',
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93503472 DEFAULT CHARSET=utf8;

/*Data for the table `party_branch` */

insert  into `party_branch`(`id`,`name`,`secretary`,`tel`) values (93503470,'命电了比们林',-32447166,'19872732447'),(93503471,'一多局过维节',2,'19812148162');

/*Table structure for table `prize` */

DROP TABLE IF EXISTS `prize`;

CREATE TABLE `prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖惩表主键',
  `activist_id` int(11) DEFAULT NULL COMMENT '用户id',
  `prize_date` date DEFAULT NULL COMMENT '奖惩时间',
  `prize_info` varchar(300) DEFAULT NULL COMMENT '奖惩信息',
  `prize_level` varchar(100) DEFAULT NULL COMMENT '奖惩等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `prize` */

insert  into `prize`(`id`,`activist_id`,`prize_date`,`prize_info`,`prize_level`) values (1,184,'1990-09-28','irure in veniam occaecat','aliquip Ut irure ex'),(2,2,'1984-12-05','voluptate tempor elit reprehenderit','adipisicing fugiat ex'),(3,1,'1984-12-05','voluptate tempor elit reprehenderit','adipisicing fugiat ex'),(4,1,'1984-12-05','voluptate tempor elit reprehenderit','adipisicing fugiat ex'),(5,1,'1984-12-05',NULL,'adipisicing fugiat ex'),(6,1,'2019-12-12','/C/1/F1F05799D7A44478BFA4D5716E74866D.webp','内蒙古自治区');

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩表主键',
  `activist_id` int(11) DEFAULT NULL COMMENT '用户表主键',
  `moral` varchar(10) DEFAULT NULL COMMENT '智育成绩',
  `comprehensive` varchar(10) DEFAULT NULL COMMENT '综测成绩',
  `moral_ranking` varchar(15) DEFAULT NULL COMMENT '智育排名',
  `comprehensive_ranking` varchar(15) DEFAULT NULL COMMENT '综测排名',
  `class_size` varchar(15) DEFAULT NULL COMMENT '班级人数',
  `is_firsthalf` varchar(2) DEFAULT NULL COMMENT '是否前1/2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `score` */

insert  into `score`(`id`,`activist_id`,`moral`,`comprehensive`,`moral_ranking`,`comprehensive_ranking`,`class_size`,`is_firsthalf`) values (0,4,'76','82','6','7','20','0'),(1,4,'76','82','6','7','20','0'),(2,4,'76','82','6','7','20','0'),(3,4,'76','82','6','7','20','1'),(4,1153,'79','82','11','9','30','1');

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
