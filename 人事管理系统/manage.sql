/*
Navicat MySQL Data Transfer

Source Server         : javawebtest
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2020-09-11 15:45:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for deparbao
-- ----------------------------
DROP TABLE IF EXISTS `deparbao`;
CREATE TABLE `deparbao` (
  `ldeptno` int(11) NOT NULL,
  `ldept` varchar(255) NOT NULL,
  `ljobno` int(11) NOT NULL,
  `ljob` varchar(255) NOT NULL,
  `lpno` int(11) NOT NULL,
  `lpname` varchar(255) NOT NULL,
  `lpsex` varchar(255) NOT NULL,
  `lpyongg` varchar(255) NOT NULL,
  `lpshiyong` varchar(255) NOT NULL,
  `lizhi` varchar(255) NOT NULL,
  `ldate` varchar(255) NOT NULL,
  `ltype` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deparbao
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(100) NOT NULL,
  `dtype` varchar(100) NOT NULL,
  `dtel` varchar(100) NOT NULL,
  `demail` varchar(100) DEFAULT NULL,
  `dmiaoshu` varchar(100) DEFAULT NULL,
  `ddescribe` varchar(100) DEFAULT NULL,
  `ddate` varchar(100) NOT NULL,
  PRIMARY KEY (`deptno`),
  UNIQUE KEY `AK_Key_2` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('3', '研发', '部门', '34567854', '', '', '', '2020-09-09');
INSERT INTO `dept` VALUES ('4', '测试', '部门', '12398746', '', '无', '无', '2020-09-10');
INSERT INTO `dept` VALUES ('5', '产品策划', '部门', '125234145', '', '', '', '2020-09-28');
INSERT INTO `dept` VALUES ('101', '销售', '部门', '25254646', '3744', '', '', '2020-09-23');
INSERT INTO `dept` VALUES ('111', '产品维护', '部门', '11111111111', '无', '修', '无', '2020-09-23');
INSERT INTO `dept` VALUES ('212', '设计1', '部门', '2141455', null, null, null, '2020-09-24');
INSERT INTO `dept` VALUES ('310', '研发2', '部门', '3-1236443', 'y-123456', '产品研发', '无', '2020-09-23');
INSERT INTO `dept` VALUES ('311', '开发2', '部门', '313131443', '', '', '', '2020-09-30');
INSERT INTO `dept` VALUES ('501', '产品策划1', '部门', '501345321', null, null, null, '2020-09-29');
INSERT INTO `dept` VALUES ('1212', 'UI设计1', '部门', '112345', '', '', '', '2020-09-07');

-- ----------------------------
-- Table structure for deptbao
-- ----------------------------
DROP TABLE IF EXISTS `deptbao`;
CREATE TABLE `deptbao` (
  `bdeptno` int(11) NOT NULL,
  `bdept` varchar(255) NOT NULL,
  `bpno` int(11) NOT NULL,
  `bpname` varchar(255) NOT NULL,
  `bpsex` varchar(255) NOT NULL,
  `nowDeptno` int(11) NOT NULL,
  `nowDept` varchar(255) NOT NULL,
  `bpyongg` varchar(255) NOT NULL,
  `bpshiyong` varchar(255) NOT NULL,
  `bdtype` varchar(255) NOT NULL,
  PRIMARY KEY (`bdeptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deptbao
-- ----------------------------
INSERT INTO `deptbao` VALUES ('4', '测试', '6', '刘', '女', '3', '研发', '正式员工', '是', '被动调动');

-- ----------------------------
-- Table structure for emp_rnover
-- ----------------------------
DROP TABLE IF EXISTS `emp_rnover`;
CREATE TABLE `emp_rnover` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pno` int(11) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `psex` char(6) NOT NULL,
  `deptno` int(11) NOT NULL,
  `jno` int(11) NOT NULL,
  `modate` date NOT NULL,
  `motype` varchar(100) NOT NULL,
  `mogo` varchar(100) DEFAULT NULL,
  `gopool` char(11) NOT NULL,
  `monote` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`id`),
  KEY `FK_Reference_8` (`deptno`),
  KEY `FK_Reference_9` (`jno`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`jno`) REFERENCES `job` (`jno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_rnover
-- ----------------------------

-- ----------------------------
-- Table structure for hr
-- ----------------------------
DROP TABLE IF EXISTS `hr`;
CREATE TABLE `hr` (
  `id` int(11) NOT NULL,
  `user` varchar(32) NOT NULL,
  `pwd` varchar(8) NOT NULL,
  `realName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr
-- ----------------------------
INSERT INTO `hr` VALUES ('1', 'zyh', '123', '张运浩');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `jno` int(11) NOT NULL,
  `jname` varchar(100) NOT NULL,
  `jtype` varchar(100) NOT NULL,
  `jnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`jno`),
  UNIQUE KEY `AK_Key_2` (`jno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', 'java', '技术', '0');
INSERT INTO `job` VALUES ('2', '设计', '技术', '30');
INSERT INTO `job` VALUES ('3', '人事', '管理', '0');
INSERT INTO `job` VALUES ('21', '覆盖', '管理', '0');
INSERT INTO `job` VALUES ('1213', '4444', '营销', null);
INSERT INTO `job` VALUES ('1222', '后端', '技术', '0');
INSERT INTO `job` VALUES ('1231', '人事', '管理', '20');
INSERT INTO `job` VALUES ('2134', '递归', '技术', '30');
INSERT INTO `job` VALUES ('546789', '初步', '营销', '0');

-- ----------------------------
-- Table structure for jobbao
-- ----------------------------
DROP TABLE IF EXISTS `jobbao`;
CREATE TABLE `jobbao` (
  `bJobno` int(11) NOT NULL,
  `bJob` varchar(255) NOT NULL,
  `nowJobno` int(11) NOT NULL,
  `nowJob` varchar(255) NOT NULL,
  `bpno` int(11) NOT NULL,
  `bpname` varchar(255) NOT NULL,
  `bpsex` varchar(255) NOT NULL,
  `bpyongg` varchar(255) NOT NULL,
  `bpshiyong` varchar(255) NOT NULL,
  `btype` varchar(255) NOT NULL,
  PRIMARY KEY (`bJobno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobbao
-- ----------------------------
INSERT INTO `jobbao` VALUES ('2', '设计', '1', 'java', '6', '刘', '女', '正式员工', '是', '数据录入错误');

-- ----------------------------
-- Table structure for mobdept
-- ----------------------------
DROP TABLE IF EXISTS `mobdept`;
CREATE TABLE `mobdept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pno` int(11) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `psex` char(6) NOT NULL,
  `deptno1` int(11) NOT NULL,
  `deptno` int(11) NOT NULL,
  `mdtype` varchar(100) NOT NULL,
  `mdreason` varchar(100) NOT NULL,
  `mnode` varchar(100) DEFAULT NULL,
  `mdate` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`id`),
  KEY `FK_Reference_3` (`deptno`),
  KEY `FK_Reference_7` (`deptno1`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`deptno1`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobdept
-- ----------------------------

-- ----------------------------
-- Table structure for mobjob
-- ----------------------------
DROP TABLE IF EXISTS `mobjob`;
CREATE TABLE `mobjob` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pno` int(11) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `psex` char(6) DEFAULT NULL,
  `depno` int(11) DEFAULT NULL,
  `jno1` int(11) DEFAULT NULL,
  `jno` int(11) NOT NULL,
  `mjdate` date NOT NULL,
  `mjtype` varchar(100) NOT NULL,
  `mjreason` varchar(100) NOT NULL,
  `mjnode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`id`),
  KEY `FK_Reference_4` (`jno`),
  KEY `FK_Reference_5` (`jno1`),
  KEY `FK_Reference_6` (`depno`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`jno`) REFERENCES `job` (`jno`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`jno1`) REFERENCES `job` (`jno`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`depno`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobjob
-- ----------------------------

-- ----------------------------
-- Table structure for per_center
-- ----------------------------
DROP TABLE IF EXISTS `per_center`;
CREATE TABLE `per_center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pno` int(11) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `psex` char(6) NOT NULL,
  `startdate` date NOT NULL,
  `stopdate` date NOT NULL,
  `entity_name` varchar(100) DEFAULT NULL,
  `job_content` varchar(100) DEFAULT NULL,
  `positions` varchar(100) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `zmpeo` varchar(100) DEFAULT NULL,
  `zm_posi` varchar(100) DEFAULT NULL,
  `zm_tel` varchar(100) DEFAULT NULL,
  `pnote` varchar(100) DEFAULT NULL,
  `For_lang` varchar(100) NOT NULL,
  `shulian` varchar(100) DEFAULT NULL,
  `gx_me` varchar(100) NOT NULL,
  `gx_name` varchar(100) NOT NULL,
  `gx_place` varchar(100) DEFAULT NULL,
  `gx_posi` varchar(100) DEFAULT NULL,
  `gx_tel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of per_center
-- ----------------------------

-- ----------------------------
-- Table structure for talent_pool
-- ----------------------------
DROP TABLE IF EXISTS `talent_pool`;
CREATE TABLE `talent_pool` (
  `pno` int(11) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `psex` varchar(100) NOT NULL,
  `pbirthday` varchar(100) NOT NULL,
  `pidnum` varchar(100) NOT NULL,
  `pdeptno` int(11) NOT NULL,
  `pdep` varchar(100) NOT NULL,
  `pjobno` int(11) NOT NULL,
  `pjob` varchar(100) NOT NULL,
  `pjoindate` varchar(100) NOT NULL,
  `pjobdate` varchar(100) NOT NULL,
  `pyongg` varchar(100) NOT NULL,
  `prlaiyuan` varchar(100) NOT NULL,
  `pzhenzhi` varchar(100) DEFAULT NULL,
  `pnspace` varchar(100) DEFAULT NULL,
  `ptel` varchar(100) DEFAULT NULL,
  `pemail` varchar(100) DEFAULT NULL,
  `pmar` varchar(20) DEFAULT NULL,
  `phighl` varchar(100) DEFAULT NULL,
  `phighd` varchar(100) DEFAULT NULL,
  `plearnp` varchar(100) DEFAULT NULL,
  `pgdate` varchar(100) DEFAULT NULL,
  `pshiyong` varchar(100) DEFAULT NULL,
  `pbshidate` varchar(100) DEFAULT NULL,
  `poshidate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pno`),
  UNIQUE KEY `AK_Key_2` (`pno`),
  KEY `FK_Reference_1` (`pdep`),
  KEY `FK_Reference_2` (`pjob`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of talent_pool
-- ----------------------------
INSERT INTO `talent_pool` VALUES ('3', '何', '女', '1999-07-11', '2456787654345', '3', '研发', '1', 'java', '1999-07-11', '1999-07-11', '正式员工', '校园招聘', '党员', '', '', '', '', '', '', '', '', '否', '1999-07-11', '1999-07-11');
INSERT INTO `talent_pool` VALUES ('4', '鹿', '男', '1990-05-32', '345678765467', '3', '研发', '1', 'java', '1990-05-32', '1990-05-32', '正式员工', '社会招聘', '其他', '', '', '', '', '', '', '', '', '否', '1990-05-32', '1990-05-32');
INSERT INTO `talent_pool` VALUES ('5', '王', '男', '1997-09-05', '234567897654', '3', '研发', '1', 'java', '2020-10-10', '2020-10-10', '正式员工', '校园招聘', '', '', '', '', '', '', '', '', '', '是', '2020-10-10', '2020-10-10');
INSERT INTO `talent_pool` VALUES ('6', '刘', '女', '2020-09-10', '356785433', '3', '研发', '1', 'java', '2020-09-18', '2020-09-18', '正式员工', '校园招聘', '党员', '', '', '', '', '', '', '', '', '是', '2020-09-18', '2020-09-18');
INSERT INTO `talent_pool` VALUES ('7', '徐艺洋', '女', '1997-07-08', '4928756000223346', '3', '研发', '1', 'java', '2020-09-06', '2018-09-04', '正式员工', '社会招聘', '', '', '', '', '', '', '', '', '2020-09-28', '是', '2020-09-15', '2020-09-21');
INSERT INTO `talent_pool` VALUES ('8', '刘些宁', '女', '1996-08-28', '345678932224', '3', '研发', '1', 'java', '2020-09-09', '2020-09-23', '临时员工', '其他', '', '', '', '', '', '', '', '', '2020-09-15', '是', '2020-10-03', '2020-10-10');
