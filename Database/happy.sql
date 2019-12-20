/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : happy

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-12-20 22:54:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_image
-- ----------------------------
DROP TABLE IF EXISTS `t_image`;
CREATE TABLE `t_image` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `country` varchar(20) default NULL,
  `position` varchar(20) default NULL,
  `resolution` varchar(20) default NULL,
  `longitude` varchar(20) default NULL,
  `latitude` varchar(20) default NULL,
  `acquisition_time` varchar(50) default NULL,
  `scale` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_image
-- ----------------------------
INSERT INTO `t_image` VALUES ('33', 'admin', '中国', 'east', '7200', '40E', '26N', '1576381466.jpg', '100');
INSERT INTO `t_image` VALUES ('34', 'admin', '中国', 'east', '6000', '45E', '40N', '1576381516.jpg', '200');
INSERT INTO `t_image` VALUES ('35', '小明', '美国', 'west', '1300', '23W', '24S', '1576386456.jpg', '200');
INSERT INTO `t_image` VALUES ('36', 'David', '中国', 'north', '4000', '56N', '23E', '1576386978.jpg', '400');
INSERT INTO `t_image` VALUES ('37', 'Amy', '美国', 'east', '3000', '23W', '32N', '1576388589.jpg', '200');
INSERT INTO `t_image` VALUES ('38', 'Amy', '英国', 'east', '4500', '50W', '40N', '1576388750.jpg', '300');
INSERT INTO `t_image` VALUES ('39', '小红', '中国', 'west', '2000', '30E', '40W', '1576388834.jpg', '200');
INSERT INTO `t_image` VALUES ('40', '小红', '中国', 'east', '2000', '30E', '40W', '1576388851.jpg', '300');
INSERT INTO `t_image` VALUES ('41', '小红', '中国', 'west', '2000', '30E', '40N', '1576388856.jpg', '250');
INSERT INTO `t_image` VALUES ('42', '小红', '中国', 'east', '2000', '40E', '40W', '1576388867.jpg', '300');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int(10) NOT NULL auto_increment,
  `uname` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `sex` char(2) default NULL,
  `age` int(3) default NULL,
  `birth` varchar(20) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0', 'admin', 'adminadmin', '1', '19', '2000/03/19');
INSERT INTO `t_user` VALUES ('19', '小明', 'xiaoming', '1', '6', '2010/01/01');
INSERT INTO `t_user` VALUES ('20', '小红', 'xiaohong', '2', '3', '2016/12/12');
INSERT INTO `t_user` VALUES ('21', '张三', '123456', '1', '40', '1980/02/21');
INSERT INTO `t_user` VALUES ('22', 'David', '123456', '1', '23', '1996/11/11');
INSERT INTO `t_user` VALUES ('23', 'Amy', 'amyamy', '2', '13', '2008/08/08');
