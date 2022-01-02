/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.27 : Database - red-pioneer-ddl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`red-pioneer-ddl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `red-pioneer-ddl`;

/*Table structure for table `activist` */

DROP TABLE IF EXISTS `activist`;

CREATE TABLE `activist` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `account` varchar(20) NOT NULL COMMENT '账号',
  `password` varchar(30) NOT NULL DEFAULT '888888' COMMENT '密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL DEFAULT '' COMMENT '性别',
  `birthday` date NOT NULL DEFAULT '2000-01-01' COMMENT '出生年月',
  `nation` varchar(20) NOT NULL DEFAULT '' COMMENT '民族',
  `native_place` varchar(30) NOT NULL DEFAULT '' COMMENT '籍贯',
  `id_card` varchar(20) NOT NULL DEFAULT '' COMMENT '身份证',
  `address` varchar(300) NOT NULL DEFAULT '' COMMENT '地址',
  `tel` varchar(20) NOT NULL DEFAULT '' COMMENT '电话',
  `photo` varchar(255) NOT NULL DEFAULT '' COMMENT '照片',
  `classes` varchar(20) NOT NULL DEFAULT '' COMMENT '班级',
  `roles` varchar(10) NOT NULL DEFAULT 'user' COMMENT '角色',
  `state_code` varchar(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `activist` */

insert  into `activist`(`id`,`account`,`password`,`name`,`sex`,`birthday`,`nation`,`native_place`,`id_card`,`address`,`tel`,`photo`,`classes`,`roles`,`state_code`) values (1,'1005','888888','王思聪','男','2021-12-10','汉','上海','152801202112106281','das','15148849209','/8/6/B55A83B23D714F4AA1EADFB2A70F1B76.jpg','19软件技术','admin','1'),(2,'1006','888888','李连杰','n','1970-01-01','蒙族','海南','851665474147485167','发生大','48956','  ','大','admin','1'),(4,'2019114426496','888888','qwe','','2000-01-01','','','','','','','','shuji','1'),(5,'1007','888888','wangji','女','2022-01-05','回族','北京','34586998636598836','das','0000000000000','   ','dqwq','user','1');

/*Table structure for table `conversation` */

DROP TABLE IF EXISTS `conversation`;

CREATE TABLE `conversation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '志愿服务表主键',
  `volunteer_address` varchar(255) DEFAULT NULL COMMENT '服务地点',
  `volunteer_time` date DEFAULT NULL COMMENT '服务时间',
  `volunteer_info` varchar(255) DEFAULT NULL COMMENT '服务内容',
  `volunteer_size` varchar(10) DEFAULT NULL COMMENT '服务时长',
  `prove` varchar(255) NOT NULL COMMENT '佐证材料',
  `activist_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  CONSTRAINT `conversation_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='志愿服务表';

/*Data for the table `conversation` */

insert  into `conversation`(`id`,`volunteer_address`,`volunteer_time`,`volunteer_info`,`volunteer_size`,`prove`,`activist_id`) values (1,'dsfd','2019-12-12','dfsd','12','/E/0/53879EF4D943404992314AF4DCD8598B.png',1);

/*Table structure for table `development_info` */

DROP TABLE IF EXISTS `development_info`;

CREATE TABLE `development_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '发展信息表主键',
  `application_time` date NOT NULL COMMENT '入党申请时间',
  `application_form` varchar(255) DEFAULT NULL COMMENT '入党申请书',
  `diploma` varchar(255) DEFAULT NULL COMMENT '积极分子结业证',
  `upactivist_time` date DEFAULT NULL COMMENT '确定为积极分子时间',
  `activist_id` int(11) NOT NULL COMMENT '积极分子id',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  CONSTRAINT `development_info_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='发展信息';

/*Data for the table `development_info` */

insert  into `development_info`(`id`,`application_time`,`application_form`,`diploma`,`upactivist_time`,`activist_id`) values (1,'2019-12-12','/F/E/04A63B1754D04B2191AAA1D68601FDC0.jpg','/8/F/5BEE7B2A31C4423C87BAD7DD06400C62.png','2020-01-08',1);

/*Table structure for table `party_branch` */

DROP TABLE IF EXISTS `party_branch`;

CREATE TABLE `party_branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '支部表主键',
  `branch_name` varchar(50) NOT NULL COMMENT '支部名称',
  `activist_id` int(11) DEFAULT NULL COMMENT '负责人id',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  CONSTRAINT `party_branch_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='支部表';

/*Data for the table `party_branch` */

insert  into `party_branch`(`id`,`branch_name`,`activist_id`) values (6,'fs',5),(7,'fwe',5),(8,'dwfas',5),(9,'信管系第一党支部',4);

/*Table structure for table `party_group` */

DROP TABLE IF EXISTS `party_group`;

CREATE TABLE `party_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '党小组表主键',
  `group_name` varchar(50) NOT NULL COMMENT '党小组名称',
  `activist_id` int(11) NOT NULL COMMENT '负责人id',
  `branch` int(11) NOT NULL COMMENT '所在支部',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  KEY `branch` (`branch`),
  CONSTRAINT `party_group_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`),
  CONSTRAINT `party_group_ibfk_2` FOREIGN KEY (`branch`) REFERENCES `party_branch` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='党小组';

/*Data for the table `party_group` */

/*Table structure for table `prize` */

DROP TABLE IF EXISTS `prize`;

CREATE TABLE `prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '奖惩信息表主键',
  `prize_info` varchar(255) DEFAULT NULL COMMENT '奖惩信息',
  `prize_time` date DEFAULT NULL COMMENT '奖惩时间',
  `prove` varchar(255) NOT NULL COMMENT '佐证材料',
  `activist_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  CONSTRAINT `prize_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='奖惩信息表';

/*Data for the table `prize` */

insert  into `prize`(`id`,`prize_info`,`prize_time`,`prove`,`activist_id`) values (1,'蓝桥杯','2021-12-07','dasfqawf',1),(2,'acm','2021-12-16','dada',2),(3,'奥林匹克','2019-12-03','/1/C/20BA8B07E35F4CC18C7597FF1E007155.png',2);

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩表主键',
  `moral` varchar(20) DEFAULT NULL COMMENT '智育成绩',
  `moral_ranking` varchar(20) DEFAULT NULL COMMENT '智育排名',
  `comprehensive` varchar(20) DEFAULT NULL COMMENT '综测成绩',
  `comprehensive_ranking` varchar(20) DEFAULT NULL COMMENT '综测排名',
  `class_size` varchar(20) DEFAULT NULL COMMENT '班级人数',
  `is_firsthalf` varchar(2) DEFAULT NULL COMMENT '是否前1/2',
  `activist_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  CONSTRAINT `score_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='成绩表';

/*Data for the table `score` */

insert  into `score`(`id`,`moral`,`moral_ranking`,`comprehensive`,`comprehensive_ranking`,`class_size`,`is_firsthalf`,`activist_id`) values (1,'68','10','89','7','20','1',5);

/*Table structure for table `talk` */

DROP TABLE IF EXISTS `talk`;

CREATE TABLE `talk` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '谈话表主键',
  `activist_id` int(11) NOT NULL COMMENT '用户表主键',
  `talk_time` date NOT NULL COMMENT '谈话时间',
  `talk_people` int(1) NOT NULL COMMENT '谈话人',
  `prove` varchar(255) NOT NULL COMMENT '佐证材料',
  PRIMARY KEY (`id`),
  KEY `activist_id` (`activist_id`),
  CONSTRAINT `talk_ibfk_1` FOREIGN KEY (`activist_id`) REFERENCES `activist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='谈话表';

/*Data for the table `talk` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
