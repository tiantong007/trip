/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3307
 Source Schema         : trip

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 23/05/2023 20:27:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账号',
  `a_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` int(11) NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名',
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_id` int(11) NOT NULL COMMENT '酒店id',
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `c_context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论信息',
  `c_date` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `h_id`(`h_id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片',
  `hotel_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '酒店名称',
  `hotel_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述',
  `hotel_star` int(11) NULL DEFAULT 0 COMMENT '星级',
  `hotel_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '具体位置',
  `city_id` int(11) NULL DEFAULT NULL COMMENT '所在城市',
  PRIMARY KEY (`h_id`) USING BTREE,
  INDEX `city_id`(`city_id`) USING BTREE,
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hotel_orders
-- ----------------------------
DROP TABLE IF EXISTS `hotel_orders`;
CREATE TABLE `hotel_orders`  (
  `ho_id` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `h_id` int(11) NOT NULL COMMENT '\r\n酒店id',
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `r_id` int(11) NOT NULL COMMENT '房间id',
  `begin_date` datetime(0) NULL DEFAULT NULL COMMENT '入住时间',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '离开时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`ho_id`) USING BTREE,
  INDEX `h_id`(`h_id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `r_id`(`r_id`) USING BTREE,
  CONSTRAINT `hotel_orders_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hotel_orders_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hotel_orders_ibfk_3` FOREIGN KEY (`r_id`) REFERENCES `room` (`room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int(11) NOT NULL,
  `h_id` int(11) NOT NULL COMMENT '关联酒店id',
  `room_status` int(11) NULL DEFAULT NULL COMMENT '房间状态（空闲，被预定等）',
  `room_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '房间价格',
  `room_num` int(11) NULL DEFAULT NULL COMMENT '房间数量',
  `room_type` int(11) NULL DEFAULT NULL COMMENT '房间类型（大床房，双人房等）',
  `room_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间图片',
  PRIMARY KEY (`room_id`) USING BTREE,
  INDEX `h_id`(`h_id`) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic`  (
  `scenic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `science_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '景点名称',
  `science_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '景点图片',
  `science_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '景点价格',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '景点描述',
  `science_star` int(11) NULL DEFAULT NULL COMMENT '评分',
  `city_id` int(11) NOT NULL COMMENT '所在城市',
  `science_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '具体位置',
  PRIMARY KEY (`scenic_id`) USING BTREE,
  INDEX `city_id`(`city_id`) USING BTREE,
  CONSTRAINT `scenic_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for scenic_orders
-- ----------------------------
DROP TABLE IF EXISTS `scenic_orders`;
CREATE TABLE `scenic_orders`  (
  `so_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `so_status` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '订单状态',
  `so_time` datetime(0) NULL DEFAULT NULL COMMENT '预定时间',
  PRIMARY KEY (`so_id`) USING BTREE,
  INDEX `scenic_id`(`scenic_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `scenic_orders_ibfk_1` FOREIGN KEY (`scenic_id`) REFERENCES `scenic` (`scenic_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scenic_orders_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `sex` char(6) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '1' COMMENT '性别，男1，女0',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
