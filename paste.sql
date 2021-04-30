/*
 Navicat Premium Data Transfer

 Source Server         : MysqlLocal
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : sypastebin

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 23/04/2021 16:02:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paste
-- ----------------------------
DROP TABLE IF EXISTS `paste`;
CREATE TABLE `paste`  (
  `short_link` char(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `expiration_time` datetime(0) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `paste_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`short_link`) USING BTREE,
  INDEX `cleanoverduedata`(`expiration_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
