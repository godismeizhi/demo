/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/12/2019 18:45:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '盐',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_account
-- ----------------------------
INSERT INTO `user_account` VALUES (1, 'w2312', '23123', '31212', '2019-12-05 17:36:33', '2019-12-18 17:36:36');

-- ----------------------------
-- View structure for test2
-- ----------------------------
DROP VIEW IF EXISTS `test2`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `test2` AS select `s`.`id` AS `id`,`s`.`type` AS `type`,`s`.`title` AS `title`,`s`.`service_id` AS `service_id`,`s`.`create_by` AS `create_by`,`s`.`create_time` AS `create_time`,`s`.`update_time` AS `update_time`,`s`.`remote_addr` AS `remote_addr`,`s`.`user_agent` AS `user_agent`,`s`.`request_uri` AS `request_uri`,`s`.`method` AS `method`,`s`.`params` AS `params`,`s`.`time` AS `time`,`s`.`del_flag` AS `del_flag`,`s`.`exception` AS `exception` from `sys_log` `s`;

SET FOREIGN_KEY_CHECKS = 1;
