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

 Date: 22/05/2023 16:25:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `a_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_hotel
-- ----------------------------
DROP TABLE IF EXISTS `t_hotel`;
CREATE TABLE `t_hotel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '酒店名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `miaoshu` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述',
  `bed` int(11) NULL DEFAULT NULL COMMENT '床数',
  `day` int(11) NULL DEFAULT 1 COMMENT '天数',
  `star` int(11) NULL DEFAULT 0 COMMENT '评论星',
  `startdate` datetime(0) NULL DEFAULT NULL COMMENT '入住时间',
  `addr` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '酒店城市',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_hotel_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_hotel_orders`;
CREATE TABLE `t_hotel_orders`  (
  `id` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `scenicid` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品id',
  `userid` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id',
  `qty` int(11) NULL DEFAULT NULL COMMENT '数量',
  `payment` decimal(10, 2) NULL DEFAULT NULL COMMENT '总支付金额',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '状态',
  `paytime` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `scenicname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `begin` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '入住时间',
  `end` varchar(2255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '离开时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `scenicid` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '商品id',
  `userid` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id',
  `qty` int(11) NULL DEFAULT NULL COMMENT '数量',
  `payment` decimal(10, 2) NULL DEFAULT NULL COMMENT '总支付金额',
  `status` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '状态',
  `paytime` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '电话',
  `u_id` int(11) NULL DEFAULT NULL COMMENT '连接用户id',
  `s_id` int(11) NULL DEFAULT NULL COMMENT '连接景区id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_scenic
-- ----------------------------
DROP TABLE IF EXISTS `t_scenic`;
CREATE TABLE `t_scenic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '景点名称',
  `img` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '景点图片',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '描述',
  `comment` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '评论',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `start` int(11) NULL DEFAULT NULL COMMENT '评分',
  `contry` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '国家地区',
  `startdate` datetime(0) NULL DEFAULT NULL COMMENT '出发时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(120) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '密码',
  `mobile` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  `sex` char(6) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '1' COMMENT '性别，男1，女0',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
