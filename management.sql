/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80034 (8.0.34)
 Source Host           : localhost:3306
 Source Schema         : management

 Target Server Type    : MySQL
 Target Server Version : 80034 (8.0.34)
 File Encoding         : 65001

 Date: 21/08/2023 10:03:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `clid` int NOT NULL,
  `clname` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `did` int NOT NULL,
  `tid` int NULL DEFAULT NULL,
  PRIMARY KEY (`clid`) USING BTREE,
  INDEX `fk_class_department`(`did` ASC) USING BTREE,
  CONSTRAINT `fk_class_department` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (20150103, '2015-3班', 201501, 1);
INSERT INTO `class` VALUES (20150104, '2015-4班', 201501, 6);
INSERT INTO `class` VALUES (20150201, '2015-1班', 201502, 2);
INSERT INTO `class` VALUES (20150202, '2015-2班', 201502, 7);
INSERT INTO `class` VALUES (20150301, '2015-1班', 201503, 3);
INSERT INTO `class` VALUES (20150302, '2015-2班', 201503, 8);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高等数学');
INSERT INTO `course` VALUES (2, '数据库原理设计');
INSERT INTO `course` VALUES (3, 'Java程序设计');
INSERT INTO `course` VALUES (4, '线性代数');
INSERT INTO `course` VALUES (5, '数据结构与算法');
INSERT INTO `course` VALUES (6, '操作系统');
INSERT INTO `course` VALUES (7, '计算机网络');
INSERT INTO `course` VALUES (8, '软件工程');
INSERT INTO `course` VALUES (9, '人工智能');
INSERT INTO `course` VALUES (10, '编译原理');
INSERT INTO `course` VALUES (11, '离散数学');
INSERT INTO `course` VALUES (12, '数字逻辑');
INSERT INTO `course` VALUES (13, '计算机组成原理');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `did` int NOT NULL,
  `dname` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (201501, '软件学院');
INSERT INTO `department` VALUES (201502, '经管学院');
INSERT INTO `department` VALUES (201503, '人文学院');
INSERT INTO `department` VALUES (201504, '国际学院');
INSERT INTO `department` VALUES (201505, '理学院');

-- ----------------------------
-- Table structure for select_course
-- ----------------------------
DROP TABLE IF EXISTS `select_course`;
CREATE TABLE `select_course`  (
  `sid` bigint NOT NULL,
  `cid` int NOT NULL,
  `usual_grade` float NULL DEFAULT NULL,
  `final_grade` float NULL DEFAULT NULL,
  PRIMARY KEY (`sid`, `cid`) USING BTREE,
  INDEX `fk_sc_course`(`cid` ASC) USING BTREE,
  CONSTRAINT `fk_sc_course` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sc_student` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of select_course
-- ----------------------------
INSERT INTO `select_course` VALUES (2015010312, 1, 50, 84);
INSERT INTO `select_course` VALUES (2015010312, 3, 70, 78);
INSERT INTO `select_course` VALUES (2015010313, 1, 90, 98);
INSERT INTO `select_course` VALUES (2015010313, 2, 89, 89);
INSERT INTO `select_course` VALUES (2015010313, 3, 59, 75);
INSERT INTO `select_course` VALUES (2015010314, 1, 85, 89);
INSERT INTO `select_course` VALUES (2015010418, 10, NULL, NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` bigint NOT NULL,
  `name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `gender` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthdate` datetime NULL DEFAULT NULL,
  `clid` int NULL DEFAULT NULL,
  `telephone` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `fk_student_class`(`clid` ASC) USING BTREE,
  CONSTRAINT `fk_student_class` FOREIGN KEY (`clid`) REFERENCES `class` (`clid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2015010312, '张明', '男', '1999-03-15 00:00:00', 20150103, '13123456589');
INSERT INTO `student` VALUES (2015010313, '李华', '女', '2000-01-15 00:00:00', 20150103, '13123456789');
INSERT INTO `student` VALUES (2015010314, '王刚', '男', '1999-11-30 00:00:00', 20150103, '13134567890');
INSERT INTO `student` VALUES (2015010315, '陈梅', '女', '2000-02-28 00:00:00', 20150103, '13145678901');
INSERT INTO `student` VALUES (2015010416, '赵雷', '男', '1999-10-12 00:00:00', 20150104, '13156789012');
INSERT INTO `student` VALUES (2015010417, '刘芳', '女', '2000-03-21 00:00:00', 20150104, '13167890123');
INSERT INTO `student` VALUES (2015010418, '周杰', '男', '1999-09-18 00:00:00', 20150104, '13178901234');
INSERT INTO `student` VALUES (2015020119, '林娜', '女', '2000-04-10 00:00:00', 20150201, '13189012345');
INSERT INTO `student` VALUES (2015020120, '马强', '男', '1999-08-24 00:00:00', 20150201, '13190123456');
INSERT INTO `student` VALUES (2015030221, '张琳', '女', '2000-05-05 00:00:00', 20150302, '13201234567');
INSERT INTO `student` VALUES (2015030222, '李伟', '男', '1999-07-07 00:00:00', 20150302, '13212345678');
INSERT INTO `student` VALUES (2015030223, '急急急', '男', '2002-08-31 00:00:00', 20150104, '13333333333');
INSERT INTO `student` VALUES (2015030555, '张三三', '男', '2000-09-13 00:00:00', 20150103, '13186794554');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tid` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `tname` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `did` int NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `fk_teacher_department`(`did` ASC) USING BTREE,
  CONSTRAINT `fk_teacher_department` FOREIGN KEY (`did`) REFERENCES `department` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '姚学林', 201501);
INSERT INTO `teacher` VALUES (2, '简小瑜', 201502);
INSERT INTO `teacher` VALUES (3, '通俊雄', 201503);
INSERT INTO `teacher` VALUES (4, '贾白梅', 201504);
INSERT INTO `teacher` VALUES (5, '牛琼芳', 201505);
INSERT INTO `teacher` VALUES (6, '欧飞雨', 201501);
INSERT INTO `teacher` VALUES (7, '符雪艳', 201502);
INSERT INTO `teacher` VALUES (8, '杜佳晨', 201503);
INSERT INTO `teacher` VALUES (9, '刘宏浚', 201504);
INSERT INTO `teacher` VALUES (10, '王向荣', 201505);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', 'admin');
INSERT INTO `users` VALUES (2, 'user', 'user', 'user');

SET FOREIGN_KEY_CHECKS = 1;
