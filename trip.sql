/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : trip

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 26/05/2023 20:53:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `a_id` int NOT NULL AUTO_INCREMENT,
  `a_account` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '账号',
  `a_password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`a_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456');
INSERT INTO `admin` VALUES (2, 'admin2', '654321');
INSERT INTO `admin` VALUES (3, 'admin3', 'password');
INSERT INTO `admin` VALUES (4, 'admin4', 'qwertyuiop');
INSERT INTO `admin` VALUES (5, 'admin5', 'asdfghjkl');
INSERT INTO `admin` VALUES (6, 'admin6', 'zxcvbnm');
INSERT INTO `admin` VALUES (7, 'admin7', 'iloveyou');
INSERT INTO `admin` VALUES (8, 'admin8', 'letmein');
INSERT INTO `admin` VALUES (9, 'admin9', 'welcome');
INSERT INTO `admin` VALUES (10, 'admin10', 'monkey');
INSERT INTO `admin` VALUES (11, 'manager1', '123456');
INSERT INTO `admin` VALUES (12, 'manager2', '654321');
INSERT INTO `admin` VALUES (13, 'manager3', 'password');
INSERT INTO `admin` VALUES (14, 'manager4', 'qwertyuiop');
INSERT INTO `admin` VALUES (15, 'manager5', 'asdfghjkl');
INSERT INTO `admin` VALUES (16, 'manager6', 'zxcvbnm');
INSERT INTO `admin` VALUES (17, 'manager7', 'iloveyou');
INSERT INTO `admin` VALUES (18, 'manager8', 'letmein');
INSERT INTO `admin` VALUES (19, 'manager9', 'welcome');
INSERT INTO `admin` VALUES (20, 'manager10', 'monkey');
INSERT INTO `admin` VALUES (21, 'employee1', '123456');
INSERT INTO `admin` VALUES (22, 'employee2', '654321');
INSERT INTO `admin` VALUES (23, 'employee3', 'password');
INSERT INTO `admin` VALUES (24, 'employee4', 'qwertyuiop');
INSERT INTO `admin` VALUES (25, 'employee5', 'asdfghjkl');
INSERT INTO `admin` VALUES (26, 'employee6', 'zxcvbnm');
INSERT INTO `admin` VALUES (27, 'employee7', 'iloveyou');
INSERT INTO `admin` VALUES (28, 'employee8', 'letmein');
INSERT INTO `admin` VALUES (29, 'employee9', 'welcome');
INSERT INTO `admin` VALUES (30, 'employee10', 'monkey');
INSERT INTO `admin` VALUES (31, 'admin11', '123456');
INSERT INTO `admin` VALUES (32, 'admin12', '654321');
INSERT INTO `admin` VALUES (33, 'admin13', 'password');
INSERT INTO `admin` VALUES (34, 'admin14', 'qwertyuiop');
INSERT INTO `admin` VALUES (35, 'admin15', 'asdfghjkl');
INSERT INTO `admin` VALUES (36, 'admin16', 'zxcvbnm');
INSERT INTO `admin` VALUES (37, 'admin17', 'iloveyou');
INSERT INTO `admin` VALUES (38, 'admin18', 'letmein');
INSERT INTO `admin` VALUES (39, 'admin19', 'welcome');
INSERT INTO `admin` VALUES (40, 'admin20', 'monkey');
INSERT INTO `admin` VALUES (41, 'manager11', '123456');
INSERT INTO `admin` VALUES (42, 'manager12', '654321');
INSERT INTO `admin` VALUES (43, 'manager13', 'password');
INSERT INTO `admin` VALUES (44, 'manager14', 'qwertyuiop');
INSERT INTO `admin` VALUES (45, 'manager15', 'asdfghjkl');
INSERT INTO `admin` VALUES (46, 'manager16', 'zxcvbnm');
INSERT INTO `admin` VALUES (47, 'manager17', 'iloveyou');
INSERT INTO `admin` VALUES (48, 'manager18', 'letmein');
INSERT INTO `admin` VALUES (49, 'manager19', 'welcome');
INSERT INTO `admin` VALUES (50, 'manager20', 'monkey');
INSERT INTO `admin` VALUES (51, 'employee11', '123456');
INSERT INTO `admin` VALUES (52, 'employee12', '654321');
INSERT INTO `admin` VALUES (53, 'employee13', 'password');
INSERT INTO `admin` VALUES (54, 'employee14', 'qwertyuiop');
INSERT INTO `admin` VALUES (55, 'employee15', 'asdfghjkl');
INSERT INTO `admin` VALUES (56, 'employee16', 'zxcvbnm');
INSERT INTO `admin` VALUES (57, 'employee17', 'iloveyou');
INSERT INTO `admin` VALUES (58, 'employee18', 'letmein');
INSERT INTO `admin` VALUES (59, 'employee19', 'welcome');
INSERT INTO `admin` VALUES (60, 'employee20', 'monkey');
INSERT INTO `admin` VALUES (61, 'guide1', '123456');
INSERT INTO `admin` VALUES (62, 'guide2', '654321');
INSERT INTO `admin` VALUES (63, 'guide3', 'password');
INSERT INTO `admin` VALUES (64, 'guide4', 'qwertyuiop');
INSERT INTO `admin` VALUES (65, 'guide5', 'asdfghjkl');
INSERT INTO `admin` VALUES (66, 'guide6', 'zxcvbnm');
INSERT INTO `admin` VALUES (67, 'guide7', 'iloveyou');
INSERT INTO `admin` VALUES (68, 'guide8', 'letmein');
INSERT INTO `admin` VALUES (69, 'guide9', 'welcome');
INSERT INTO `admin` VALUES (70, 'guide10', 'monkey');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` int NOT NULL,
  `city_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '城市名',
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `h_id` int NOT NULL COMMENT '酒店id',
  `u_id` int NOT NULL COMMENT '用户id',
  `c_context` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评论信息',
  `c_date` datetime NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `h_id`(`h_id` ASC) USING BTREE,
  INDEX `u_id`(`u_id` ASC) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `h_id` int NOT NULL AUTO_INCREMENT,
  `hotel_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '图片',
  `hotel_name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '酒店名称',
  `hotel_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '描述',
  `hotel_star` int NULL DEFAULT 0 COMMENT '星级',
  `hotel_position` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '具体位置',
  `city_id` int NULL DEFAULT NULL COMMENT '所在城市',
  PRIMARY KEY (`h_id`) USING BTREE,
  INDEX `city_id`(`city_id` ASC) USING BTREE,
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hotel
-- ----------------------------

-- ----------------------------
-- Table structure for hotel_orders
-- ----------------------------
DROP TABLE IF EXISTS `hotel_orders`;
CREATE TABLE `hotel_orders`  (
  `ho_id` varchar(120) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT 'id',
  `h_id` int NOT NULL COMMENT '\r\n酒店id',
  `u_id` int NOT NULL COMMENT '用户id',
  `r_id` int NOT NULL COMMENT '房间id',
  `begin_date` datetime NULL DEFAULT NULL COMMENT '入住时间',
  `end_date` datetime NULL DEFAULT NULL COMMENT '离开时间',
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`ho_id`) USING BTREE,
  INDEX `h_id`(`h_id` ASC) USING BTREE,
  INDEX `u_id`(`u_id` ASC) USING BTREE,
  INDEX `r_id`(`r_id` ASC) USING BTREE,
  CONSTRAINT `hotel_orders_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hotel_orders_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hotel_orders_ibfk_3` FOREIGN KEY (`r_id`) REFERENCES `room` (`room_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hotel_orders
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int NOT NULL,
  `h_id` int NOT NULL COMMENT '关联酒店id',
  `room_status` int NULL DEFAULT NULL COMMENT '房间状态（空闲，被预定等）',
  `room_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '房间价格',
  `room_num` int NULL DEFAULT NULL COMMENT '房间数量',
  `room_type` int NULL DEFAULT NULL COMMENT '房间类型（大床房，双人房等）',
  `room_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '房间图片',
  PRIMARY KEY (`room_id`) USING BTREE,
  INDEX `h_id`(`h_id` ASC) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic`  (
  `scenic_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `science_name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '景点名称',
  `science_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '景点图片',
  `science_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '景点价格',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '景点描述',
  `science_star` int NULL DEFAULT NULL COMMENT '评分',
  `city_id` int NOT NULL COMMENT '所在城市',
  `science_position` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '具体位置',
  PRIMARY KEY (`scenic_id`) USING BTREE,
  INDEX `city_id`(`city_id` ASC) USING BTREE,
  CONSTRAINT `scenic_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of scenic
-- ----------------------------

-- ----------------------------
-- Table structure for scenic_orders
-- ----------------------------
DROP TABLE IF EXISTS `scenic_orders`;
CREATE TABLE `scenic_orders`  (
  `so_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `scenic_id` int NOT NULL COMMENT '景点id',
  `user_id` int NOT NULL COMMENT '用户id',
  `so_status` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '订单状态',
  `so_time` datetime NULL DEFAULT NULL COMMENT '预定时间',
  PRIMARY KEY (`so_id`) USING BTREE,
  INDEX `scenic_id`(`scenic_id` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `scenic_orders_ibfk_1` FOREIGN KEY (`scenic_id`) REFERENCES `scenic` (`scenic_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scenic_orders_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of scenic_orders
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(120) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '邮箱',
  `sex` char(6) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT '1' COMMENT '性别，男1，女0',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `id_card` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '身份证',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '随风', '123456', '13922233332', 'urer4@hotmail.com', '1', 22, '440111199411010022');
INSERT INTO `user` VALUES (2, '晚间的风', '123456', '13888888888', 'wind@163.com', '1', 25, '440111199501010001');
INSERT INTO `user` VALUES (3, '我爱吃鱼', '654321', '13999999999', 'fish@qq.com', '0', 30, '440111198901010002');
INSERT INTO `user` VALUES (4, '猫箱', 'abcdefg', '13666666666', 'cat@126.com', '1', 20, '440111198901010003');
INSERT INTO `user` VALUES (5, 'AliceWonderland', 'qwertyuiop', '13555555555', 'alice@gmail.com', '0', 28, '440111198901010004');
INSERT INTO `user` VALUES (6, '小葵花开', 'asdfghjkl', '13777777777', 'sunflower@hotmail.com', '0', 22, '440111198901010005');
INSERT INTO `user` VALUES (7, '天空之城', 'zxcvbnmnbvcxz', '13848888848', 'sky@163.com', '1', 26, '440111198901010006');
INSERT INTO `user` VALUES (8, '梦里花落知多少', 'qazwsxedcrfv', '13888885888', 'dreamflower@qq.com', '0', 24, '440111198901010007');
INSERT INTO `user` VALUES (9, '青春不散场', 'qazw', '12488888888', 'afsgdreamflower@qq.com', '1', 29, '440111198901010008');
INSERT INTO `user` VALUES (10, '一路向北', 'sadvssfv', '11888888888', 'asddreamflower@qq.com', '1', 27, '440111198901010009');
INSERT INTO `user` VALUES (11, '梦想天空之城', 'sda', '13888828388', 'asgdfbdreamflower@qq.com', '0', 23, '440111198901010010');
INSERT INTO `user` VALUES (12, '星辰大海', 'fy8bhks', '13123458888', 'ksky@163.com', '1', 21, '440111198901010011');
INSERT INTO `user` VALUES (13, '夏日清风', 'rfvb', '12123458888', 'kmsky@163.com', '0', 25, '440111198901010112');
INSERT INTO `user` VALUES (14, '秋叶原之旅', 'ft7gubhnkj', '14123458888', 'uiisky@163.com', '1', 28, '440111198901010102');
INSERT INTO `user` VALUES (15, '冬日暖阳', 'fg', '15123458888', 'vgsky@163.com', '1', 26, '440111198901012202');
INSERT INTO `user` VALUES (16, '小麦田', 'wheatfield123', '13877777777', 'wheatfield@gmail.com', '0', 27, '440111199401010001');
INSERT INTO `user` VALUES (17, '海边漫步', 'seaside456', '13988888884', 'seaside@163.com', '1', 31, '440111198901010242');
INSERT INTO `user` VALUES (18, '山水画卷', 'landscape789', '13629999999', 'landscape@qq.com', '0', 24, '440111198901210002');
INSERT INTO `user` VALUES (19, '青春无悔', 'afdsgdfh', '13888888832', 'iosky@163.com', '0', 22, '440111198901210002');
INSERT INTO `user` VALUES (20, '向往的生活', 'bkyui', '13444488888', 'hiohsky@163.com', '1', 28, '440111198901010222');
INSERT INTO `user` VALUES (21, '旅行的意义', '7bhk', '16888888888', 'nnosky@163.com', '1', 26, '440111198901014003');
INSERT INTO `user` VALUES (22, '追逐梦想的脚步', '213454', '13877777777', 'gbisky@163.com', '0', 23, '440111198906010002');
INSERT INTO `user` VALUES (23, '热爱生活', 'lifeisgood123', '13766666666', 'lifeisgood@gmail.com', '0', 29, '440111199201010001');
INSERT INTO `user` VALUES (24, '海天一色', 'seasky456', '13877777777', 'seasky@163.com', '1', 33, '440111198901310002');
INSERT INTO `user` VALUES (25, '山水画境', 'landscape789', '18588888888', 'landscape@qq.com', '0', 26, '440111198901450002');
INSERT INTO `user` VALUES (26, '梦想成真', 'tgyhik3', '11888888888', 'gsky@163.com', '1', 25, '44011119890101652');
INSERT INTO `user` VALUES (27, '自由行', 't2368r', '19888888888', 'ibsky@163.com', '1', 30, '440111198901013502');
INSERT INTO `user` VALUES (28, '旅行的乐趣', '13rt672gr', '13888800088', 'hosky@163.com', '0', 27, '440111198901013502');
INSERT INTO `user` VALUES (29, '追逐未来的脚步', '13rt68gyi', '10834888888', 'hosky@163.com', '0', 24, '440111198901030002');
INSERT INTO `user` VALUES (30, '自由之翼', 'freedomwing123', '13666667777', 'freedomwing@qq.com', '1', 25, '440111198901030011');
INSERT INTO `user` VALUES (31, '旅行的足迹', 'travelfootprint456', '13777778888', 'travelfootprint@163.com', '0', 29, '440111198901030015');
INSERT INTO `user` VALUES (32, '梦想家园', 'dreamhome789', '13888889999', 'dreamhome@qq.com', '1', 33, '440111198901030017');
INSERT INTO `user` VALUES (33, '海阔天空', 'seasky1234', '13900001111', 'seasky@126.com', '1', 26, '440111198901030017');
INSERT INTO `user` VALUES (34, 'Traveler1', 'travel123', '13811112222', 'traveler1@gmail.com', '0', 27, '440111199401010001');
INSERT INTO `user` VALUES (35, 'Explorer2', 'explore456', '13922223333', 'explorer2@163.com', '1', 30, '420111199401010001');
INSERT INTO `user` VALUES (36, 'Wanderlust3', 'wanderlust789', '13633334444', 'wanderlust3@qq.com', '0', 25, '440111199401010201');
INSERT INTO `user` VALUES (37, 'Adventurer4', 'dfsg', '13922223332', 'adventurer4@hotmail.com', '1', 43, '440111199401010022');
INSERT INTO `user` VALUES (38, 'user', '123', NULL, 'sadx@gmail.com', '1', NULL, NULL);
INSERT INTO `user` VALUES (39, 'aa', '123', NULL, 'qwe@qq.com', '1', NULL, NULL);
INSERT INTO `user` VALUES (40, '无畏', '123', NULL, 'sad@gmail.com', '1', NULL, NULL);
INSERT INTO `user` VALUES (41, 'user2', '1', NULL, 'sad-sasmx@gmail.com', '1', NULL, NULL);
INSERT INTO `user` VALUES (42, 'uu', '1', NULL, 'adx@gmail.com', '1', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
