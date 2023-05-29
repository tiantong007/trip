/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : 8.130.41.55:3306
 Source Schema         : trip

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 29/05/2023 11:26:42
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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (2, 'admin', '123456');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '城市名',
  `province` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '城市所属的省份',
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, '北京', '北京');
INSERT INTO `city` VALUES (2, '上海', '上海');
INSERT INTO `city` VALUES (3, '广州', '广东');
INSERT INTO `city` VALUES (4, '深圳', '广东');
INSERT INTO `city` VALUES (5, '杭州', '浙江');
INSERT INTO `city` VALUES (6, '南京', '江苏');
INSERT INTO `city` VALUES (7, '成都', '四川');
INSERT INTO `city` VALUES (8, '重庆', '重庆');
INSERT INTO `city` VALUES (9, '西安', '陕西');
INSERT INTO `city` VALUES (10, '武汉', '湖北');
INSERT INTO `city` VALUES (11, '安徽', '安徽');
INSERT INTO `city` VALUES (12, '福州', '福建');
INSERT INTO `city` VALUES (13, '南宁', '广西');
INSERT INTO `city` VALUES (14, '贵州', '贵州');
INSERT INTO `city` VALUES (15, '海南', '海南');
INSERT INTO `city` VALUES (16, '黑龙江', '黑龙江');
INSERT INTO `city` VALUES (17, '无锡', '江苏');
INSERT INTO `city` VALUES (18, '武汉', '湖北');
INSERT INTO `city` VALUES (19, '长沙', '湖南');
INSERT INTO `city` VALUES (20, '昆明', '云南');
INSERT INTO `city` VALUES (21, '厦门', '福建');
INSERT INTO `city` VALUES (22, '天津', '天津市');
INSERT INTO `city` VALUES (23, '青岛', '山东省');
INSERT INTO `city` VALUES (24, '大连', '辽宁省');
INSERT INTO `city` VALUES (25, '沈阳', '辽宁省');
INSERT INTO `city` VALUES (26, '哈尔滨', '黑龙江省');
INSERT INTO `city` VALUES (27, '石家庄', '河北省');
INSERT INTO `city` VALUES (28, '太原', '山西省');
INSERT INTO `city` VALUES (29, '呼和浩特', '内蒙古自治区');
INSERT INTO `city` VALUES (30, '南昌', '江西省');
INSERT INTO `city` VALUES (31, '合肥', '安徽省');
INSERT INTO `city` VALUES (32, '济南', '山东省');
INSERT INTO `city` VALUES (33, '郑州', '河南省');
INSERT INTO `city` VALUES (34, '长春', '吉林省');
INSERT INTO `city` VALUES (35, '南通', '江苏省');
INSERT INTO `city` VALUES (36, '常州', '江苏省');
INSERT INTO `city` VALUES (37, '徐州', '江苏省');
INSERT INTO `city` VALUES (38, '盐城', '江苏省');
INSERT INTO `city` VALUES (39, '泰州', '江苏省');
INSERT INTO `city` VALUES (40, '宁波', '浙江省');
INSERT INTO `city` VALUES (41, '温州', '浙江省');
INSERT INTO `city` VALUES (42, '嘉兴', '浙江省');
INSERT INTO `city` VALUES (43, '湖州', '浙江省');
INSERT INTO `city` VALUES (44, '绍兴', '浙江省');
INSERT INTO `city` VALUES (45, '福州', '福建省');
INSERT INTO `city` VALUES (46, '厦门', '福建省');
INSERT INTO `city` VALUES (47, '泉州', '福建省');
INSERT INTO `city` VALUES (48, '漳州', '福建省');
INSERT INTO `city` VALUES (49, '莆田', '福建省');
INSERT INTO `city` VALUES (50, '三明', '福建省');
INSERT INTO `city` VALUES (51, '南平', '福建省');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `h_id` int NOT NULL COMMENT '酒店id',
  `u_id` int NOT NULL COMMENT '用户id',
  `s_id` int NOT NULL COMMENT '景点id',
  `hc_context` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评论信息',
  `hc_date` datetime NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`c_id`) USING BTREE,
  INDEX `h_id`(`h_id` ASC) USING BTREE,
  INDEX `u_id`(`u_id` ASC) USING BTREE,
  INDEX `s_id`(`s_id` ASC) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`s_id`) REFERENCES `scenic` (`scenic_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 170 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 4, 17, '房间很干净，服务态度也很好，下次还会来住', '2023-05-10 10:36:30');
INSERT INTO `comment` VALUES (2, 4, 1, 18, '位置很方便，周围有很多好吃的，但是房间略小', '2023-04-25 10:37:09');
INSERT INTO `comment` VALUES (3, 6, 8, 22, '位置不错周围交通方便', '2023-04-11 10:37:49');
INSERT INTO `comment` VALUES (4, 3, 7, 20, '设施齐全，环境优美，服务态度也非常好', '2023-03-16 10:38:28');
INSERT INTO `comment` VALUES (5, 5, 5, 22, '服务态度非常好，早餐也很棒', '2023-05-08 10:39:00');
INSERT INTO `comment` VALUES (6, 3, 5, 21, '服务态度非常好，房间略小但是干净整洁', '2023-05-01 10:39:30');
INSERT INTO `comment` VALUES (7, 3, 7, 20, '早餐种类丰富味道不错，但是价格稍微有点贵', '2023-05-10 10:40:10');

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
  CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES (1, 'http://image.xxx.com/123.jpg', '北京饭店', '五星级豪华酒店', 5, '北京市东城区王府井大街', 1);
INSERT INTO `hotel` VALUES (2, 'http://image.xxx.com/234.jpg', '北京丽晶酒店', '四星级商务酒店', 4, '北京市朝阳区建国门外大街', 1);
INSERT INTO `hotel` VALUES (3, 'http://image.xxx.com/345.jpg', '北京瑞士酒店', '五星级豪华酒店', 5, '北京市海淀区中关村南大街', 1);
INSERT INTO `hotel` VALUES (4, 'http://image.xxx.com/456.jpg', '上海香格里拉大酒店', '五星级豪华酒店', 5, '上海市浦东新区陆家嘴环路', 2);
INSERT INTO `hotel` VALUES (5, 'http://image.xxx.com/567.jpg', '上海新锦江大酒店', '五星级豪华酒店', 5, '上海市黄浦区南京东路505号', 2);
INSERT INTO `hotel` VALUES (6, 'http://image.xxx.com/678.jpg', '上海和平饭店', '四星级商务酒店', 4, '上海市卢湾区南京西路20号', 2);
INSERT INTO `hotel` VALUES (7, 'http://image.xxx.com/789.jpg', '广州白云宾馆', '三星级标准酒店', 3, '广州市白云区机场路151号', 3);
INSERT INTO `hotel` VALUES (8, 'http://image.xxx.com/890.jpg', '广州花城大酒店', '五星级豪华酒店', 5, '广州市天河区黄埔大道西339号', 3);
INSERT INTO `hotel` VALUES (9, 'http://image.xxx.com/901.jpg', '广州丽江明珠酒店', '五星级豪华酒店', 5, '广州市天河区珠江新城兴民路21号', 3);
INSERT INTO `hotel` VALUES (10, 'http://image.xxx.com/012.jpg', '深圳壹海棠度假酒店', '五星级度假酒店', 5, '深圳市大鹏新区南澳大道1号', 4);
INSERT INTO `hotel` VALUES (11, 'http://image.xxx.com/123.jpg', '深圳欢乐颂商务酒店', '四星级商务酒店', 4, '深圳市福田区金田路2028号', 4);
INSERT INTO `hotel` VALUES (12, 'http://image.xxx.com/234.jpg', '深圳瑞吉酒店', '五星级豪华酒店', 5, '深圳市福田区深南大道5018号', 4);
INSERT INTO `hotel` VALUES (13, 'http://image.xxx.com/345.jpg', '杭州西子湖畔大酒店', '五星级豪华酒店', 5, '杭州市西湖区莫干山路555号', 5);
INSERT INTO `hotel` VALUES (14, 'http://image.xxx.com/456.jpg', '杭州万怡酒店', '四星级商务酒店', 4, '杭州市江干区富春路466号', 5);
INSERT INTO `hotel` VALUES (15, 'http://image.xxx.com/567.jpg', '杭州杭州希尔顿酒店', '五星级豪华酒店', 5, '杭州市滨江区江南大道1号', 5);
INSERT INTO `hotel` VALUES (16, 'http://image.xxx.com/678.jpg', '南京中心皇冠假日酒店', '五星级豪华酒店', 5, '南京市玄武区中山东路89号', 6);
INSERT INTO `hotel` VALUES (17, 'http://image.xxx.com/789.jpg', '南京国贸大酒店', '五星级豪华酒店', 5, '南京市鼓楼区南京国贸38号', 6);
INSERT INTO `hotel` VALUES (18, 'http://image.xxx.com/890.jpg', '西安唯佳萨卡酒店', '五星级豪华酒店', 5, '西安市莲湖区西安四路8号', 7);
INSERT INTO `hotel` VALUES (19, 'http://image.xxx.com/901.jpg', '西安西二旗国际大酒店', '五星级豪华酒店', 5, '西安市碑林区北院门西大街152号', 7);
INSERT INTO `hotel` VALUES (20, 'http://image.xxx.com/012.jpg', '西安东方华美达大酒店', '四星级商务酒店', 4, '西安市莲湖区北院门东大街68号', 7);
INSERT INTO `hotel` VALUES (21, 'http://image.xxx.com/123.jpg', '昆明阳光100度假酒店', '四星级度假酒店', 4, '昆明市五华区西晋街102号', 8);
INSERT INTO `hotel` VALUES (22, 'http://image.xxx.com/234.jpg', '昆明花店国际酒店', '五星级豪华酒店', 5, '昆明市五华区滇池北路7号', 8);
INSERT INTO `hotel` VALUES (23, 'http://image.xxx.com/345.jpg', '贵阳万达文华酒店', '五星级豪华酒店', 5, '贵阳市云岩区自由路11号', 9);
INSERT INTO `hotel` VALUES (24, 'http://image.xxx.com/456.jpg', '贵阳宏信度假酒店', '四星级度假酒店', 4, '贵阳市关岭区凯旋南路68号', 9);
INSERT INTO `hotel` VALUES (25, 'http://image.xxx.com/678.jpg', '南京中心皇冠假日酒店', '五星级豪华酒店', 5, '南京市玄武区中山东路89号', 6);
INSERT INTO `hotel` VALUES (26, 'http://image.xxx.com/789.jpg', '厦门胜利国际酒店', '五星级豪华酒店', 5, '厦门市思明区鹭江路93号', 21);
INSERT INTO `hotel` VALUES (27, 'http://image.xxx.com/890.jpg', '厦门浦东大酒店', '四星级商务酒店', 4, '厦门市鼓浪屿路118号', 21);
INSERT INTO `hotel` VALUES (28, 'http://image.xxx.com/890.jpg', '重庆华美达酒店', '四星级商务酒店', 4, '重庆市解放碑步行街解放碑38号', 11);
INSERT INTO `hotel` VALUES (29, 'http://image.xxx.com/901.jpg', '天津嗨森国际大酒店', '五星级豪华酒店', 5, '天津市河西区解放北路2号', 12);
INSERT INTO `hotel` VALUES (30, 'http://image.xxx.com/012.jpg', '天津滨海假日酒店', '五星级豪华酒店', 5, '天津市河西区解放北路90号', 12);
INSERT INTO `hotel` VALUES (31, 'http://image.xxx.com/123.jpg', '济南山大成颐酒店', '五星级豪华酒店', 5, '济南市历下区泉城路2号', 13);
INSERT INTO `hotel` VALUES (32, 'http://image.xxx.com/234.jpg', '济南诺富特酒店', '四星级商务酒店', 4, '济南市历下区泉城路11号', 13);
INSERT INTO `hotel` VALUES (33, 'http://image.xxx.com/345.jpg', '郑州航海度假酒店', '五星级度假酒店', 5, '郑州市金水区郑汴路288号', 14);
INSERT INTO `hotel` VALUES (34, 'http://image.xxx.com/456.jpg', '郑州东方豪生大酒店', '五星级豪华酒店', 5, '郑州市金水区郑东新区政七街16号', 14);
INSERT INTO `hotel` VALUES (35, 'http://image.xxx.com/567.jpg', '青岛伟达海景别墅酒店', '五星级海景酒店', 5, '青岛市城阳区海之韵路1号', 15);
INSERT INTO `hotel` VALUES (36, 'http://image.xxx.com/678.jpg', '青岛海菲奢华度假酒店', '五星级豪华度假酒店', 5, '青岛市黄岛区奥帆路1号', 15);
INSERT INTO `hotel` VALUES (37, 'http://image.xxx.com/789.jpg', '烟台蓝色海岸酒店', '五星级海景酒店', 5, '烟台蓝色海岸生态休闲旅游区', 16);
INSERT INTO `hotel` VALUES (38, 'http://image.xxx.com/890.jpg', '烟台蛤蟆岛酒店', '四星级海岛度假酒店', 4, '烟台蓝色海岸生态休闲旅游区蛤蟆岛', 16);
INSERT INTO `hotel` VALUES (39, 'http://image.xxx.com/901.jpg', '厦门胜利国际酒店', '五星级豪华酒店', 5, '厦门市思明区鹭江路93号', 21);
INSERT INTO `hotel` VALUES (40, 'http://image.xxx.com/012.jpg', '厦门浦东大酒店', '四星级商务酒店', 4, '厦门市鼓浪屿路118号', 21);

-- ----------------------------
-- Table structure for hotel_orders
-- ----------------------------
DROP TABLE IF EXISTS `hotel_orders`;
CREATE TABLE `hotel_orders`  (
  `ho_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `u_id` int NOT NULL COMMENT '用户id',
  `r_id` int NOT NULL COMMENT '房间id',
  `begin_date` datetime NULL DEFAULT NULL COMMENT '入住时间',
  `end_date` datetime NULL DEFAULT NULL COMMENT '离开时间',
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`ho_id`) USING BTREE,
  INDEX `u_id`(`u_id` ASC) USING BTREE,
  INDEX `r_id`(`r_id` ASC) USING BTREE,
  CONSTRAINT `hotel_orders_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hotel_orders_ibfk_3` FOREIGN KEY (`r_id`) REFERENCES `room` (`room_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hotel_orders
-- ----------------------------
INSERT INTO `hotel_orders` VALUES (1, 1, 1, '2022-01-01 14:00:00', '2022-01-02 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (3, 3, 3, '2022-01-05 14:00:00', '2022-01-07 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (4, 4, 4, '2022-01-08 14:00:00', '2022-01-10 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (5, 5, 5, '2022-01-11 14:00:00', '2022-01-13 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (6, 6, 6, '2022-01-14 14:00:00', '2022-01-16 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (7, 7, 7, '2022-01-17 14:00:00', '2022-01-19 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (8, 8, 8, '2022-01-20 14:00:00', '2022-01-22 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (9, 9, 9, '2022-01-23 14:00:00', '2022-01-25 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (10, 10, 10, '2022-01-26 14:00:00', '2022-01-28 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (11, 11, 11, '2022-01-29 14:00:00', '2022-01-31 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (12, 12, 12, '2022-02-01 14:00:00', '2022-02-03 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (13, 13, 13, '2022-02-04 14:00:00', '2022-02-06 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (14, 14, 14, '2022-02-07 14:00:00', '2022-02-09 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (15, 15, 15, '2022-02-10 14:00:00', '2022-02-12 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (16, 6, 1, '2022-02-13 14:00:00', '2022-02-15 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (17, 7, 1, '2022-02-16 14:00:00', '2022-02-18 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (18, 8, 8, '2022-02-19 14:00:00', '2022-02-21 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (19, 9, 1, '2022-02-22 14:00:00', '2022-02-24 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (20, 4, 2, '2022-02-25 14:00:00', '2022-02-27 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (21, 1, 1, '2022-02-28 14:00:00', '2022-03-02 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (22, 3, 2, '2022-03-03 14:00:00', '2022-03-05 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (23, 5, 3, '2022-03-06 14:00:00', '2022-03-08 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (24, 4, 4, '2022-03-09 14:00:00', '2022-03-11 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (25, 5, 5, '2022-03-12 14:00:00', '2022-03-14 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (26, 6, 6, '2022-03-15 14:00:00', '2022-03-17 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (27, 7, 7, '2022-03-18 14:00:00', '2022-03-20 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (28, 8, 8, '2022-03-21 14:00:00', '2022-03-23 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (29, 9, 9, '2022-03-24 14:00:00', '2022-03-26 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (30, 5, 3, '2022-03-06 14:00:00', '2022-03-08 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (31, 4, 1, '2022-01-01 14:00:00', '2022-01-02 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (32, 5, 2, '2022-01-03 14:00:00', '2022-01-05 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (33, 6, 3, '2022-01-07 14:00:00', '2022-01-10 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (34, 4, 4, '2022-01-12 14:00:00', '2022-01-13 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (35, 5, 5, '2022-01-16 14:00:00', '2022-01-18 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (36, 6, 6, '2022-01-03 14:00:00', '2022-01-04 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (37, 7, 7, '2022-01-06 14:00:00', '2022-01-08 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (38, 8, 8, '2022-01-11 14:00:00', '2022-01-14 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (39, 9, 9, '2022-01-16 14:00:00', '2022-01-17 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (40, 10, 10, '2022-01-02 14:00:00', '2022-01-04 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (41, 11, 11, '2022-01-05 14:00:00', '2022-01-07 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (42, 12, 12, '2022-01-09 14:00:00', '2022-01-11 12:00:00', '已完成');
INSERT INTO `hotel_orders` VALUES (43, 13, 13, '2022-01-12 14:00:00', '2022-01-15 12:00:00', '已预订');
INSERT INTO `hotel_orders` VALUES (44, 14, 14, '2022-01-18 14:00:00', '2022-01-20 12:00:00', '已取消');
INSERT INTO `hotel_orders` VALUES (45, 15, 15, '2022-01-22 14:00:00', '2022-01-23 12:00:00', '已预订');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `h_id` int NULL DEFAULT NULL,
  `s_id` int NULL DEFAULT NULL,
  `img_src` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`img_id`) USING BTREE,
  INDEX `h_id`(`h_id` ASC) USING BTREE,
  INDEX `s_id`(`s_id` ASC) USING BTREE,
  CONSTRAINT `image_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `image_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `scenic` (`scenic_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `h_id` int NOT NULL COMMENT '关联酒店id',
  `room_status` int NULL DEFAULT NULL COMMENT '房间状态（空闲，被预定等）',
  `room_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '房间价格',
  `room_num` int NULL DEFAULT NULL COMMENT '房间数量',
  `room_type` int NULL DEFAULT NULL COMMENT '房间类型（大床房，双人房等）',
  `room_img` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '房间图片',
  PRIMARY KEY (`room_id`) USING BTREE,
  INDEX `h_id`(`h_id` ASC) USING BTREE,
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`h_id`) REFERENCES `hotel` (`h_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, 1, 0, 300.00, 5, 1, 'https://example.com/room1.jpg');
INSERT INTO `room` VALUES (2, 1, 0, 350.00, 10, 2, 'https://example.com/room2.jpg');
INSERT INTO `room` VALUES (3, 12, 1, 400.00, 8, 3, 'https://example.com/room3.jpg');
INSERT INTO `room` VALUES (4, 1, 0, 280.00, 6, 4, 'https://example.com/room4.jpg');
INSERT INTO `room` VALUES (5, 5, 0, 320.00, 4, 5, 'https://example.com/room5.jpg');
INSERT INTO `room` VALUES (6, 2, 0, 200.00, 8, 1, 'https://example.com/room1.jpg');
INSERT INTO `room` VALUES (7, 2, 1, 250.00, 12, 2, 'https://example.com/room2.jpg');
INSERT INTO `room` VALUES (8, 7, 0, 180.00, 6, 3, 'https://example.com/room3.jpg');
INSERT INTO `room` VALUES (9, 8, 0, 220.00, 5, 4, 'https://example.com/room4.jpg');
INSERT INTO `room` VALUES (10, 9, 0, 240.00, 3, 5, 'https://example.com/room5.jpg');
INSERT INTO `room` VALUES (11, 9, 0, 150.00, 7, 1, 'https://example.com/room1.jpg');
INSERT INTO `room` VALUES (12, 3, 0, 180.00, 9, 2, 'https://example.com/room2.jpg');
INSERT INTO `room` VALUES (13, 16, 1, 200.00, 5, 3, 'https://example.com/room3.jpg');
INSERT INTO `room` VALUES (14, 3, 0, 120.00, 10, 4, 'https://example.com/room4.jpg');
INSERT INTO `room` VALUES (15, 3, 0, 160.00, 6, 5, 'https://example.com/room5.jpg');

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
  CONSTRAINT `scenic_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES (1, '鼓浪屿', 'https://example.com/scenic16.jpg', 20.00, '海上明珠', 4, 21, '福建省厦门市思明区');
INSERT INTO `scenic` VALUES (2, '泰山', 'https://example.com/scenic2.jpg', 60.00, '道家五岳之首', 5, 7, '山东省泰安市岱岳区');
INSERT INTO `scenic` VALUES (3, '黄果树瀑布群', 'https://example.com/scenic3.jpg', 55.00, '中国最大的瀑布群', 5, 12, '贵州省黔西南布依族苗族自治州');
INSERT INTO `scenic` VALUES (4, '九寨沟', 'https://example.com/scenic4.jpg', 70.00, '世界自然与文化双遗产', 5, 23, '四川省阿坝藏族羌族自治州九寨沟县');
INSERT INTO `scenic` VALUES (5, '桂林山水', 'https://example.com/scenic5.jpg', 65.00, '世界自然遗产', 5, 15, '广西桂林市');
INSERT INTO `scenic` VALUES (6, '武夷山', 'https://example.com/scenic6.jpg', 50.00, '道家名山之首', 5, 8, '福建省南平市武夷山市');
INSERT INTO `scenic` VALUES (7, '丽江古城', 'https://example.com/scenic7.jpg', 45.00, '世界文化遗产', 4, 6, '云南省丽江市古城区');
INSERT INTO `scenic` VALUES (8, '乾隆皇陵', 'https://example.com/scenic8.jpg', 40.00, '清朝乾隆帝陵墓', 5, 10, '河北省保定市定州市');
INSERT INTO `scenic` VALUES (9, '高山峡谷', 'https://example.com/scenic9.jpg', 20.00, '高山峡谷景观', 4, 5, '四川省宜宾市江安县高山乡');
INSERT INTO `scenic` VALUES (10, '雁荡山', 'https://example.com/scenic10.jpg', 35.00, '山水甲天下', 5, 17, '安徽省黄山市黄山区');
INSERT INTO `scenic` VALUES (11, '峨眉山', 'https://example.com/scenic11.jpg', 50.00, '道教圣地', 5, 14, '四川省乐山市峨眉山市');
INSERT INTO `scenic` VALUES (12, '华山', 'https://example.com/scenic12.jpg', 60.00, '道家五岳之一 ', 5, 7, '陕西省华阴市');
INSERT INTO `scenic` VALUES (13, '南五岳之首 嵩山', 'https://example.com/scenic13.jpg', 65.00, '道家五岳之一', 5, 10, '安徽省合肥市');
INSERT INTO `scenic` VALUES (14, '临沂洗马涧', 'https://example.com/scenic14.jpg', 25.00, '世界名胜小桃源', 4, 16, '山东省临沂市河东区');
INSERT INTO `scenic` VALUES (15, '天池', 'https://example.com/scenic15.jpg', 55.00, '清净静谧的高山草甸湖', 5, 17, '甘肃省天水市武山县天池景区');
INSERT INTO `scenic` VALUES (16, '故宫', 'https://example.com/scenic1.jpg', 60.00, '中国明清两代的皇家宫殿', 4, 1, '北京市东城区景山前街4号');
INSERT INTO `scenic` VALUES (17, '颐和园', 'https://example.com/scenic2.jpg', 40.00, '中国历史文化名园', 4, 1, '北京市海淀区新建宫门路19号');
INSERT INTO `scenic` VALUES (18, '长城', 'https://example.com/scenic3.jpg', 35.00, '中华民族的骄傲', 5, 1, '北京市怀柔区长城镇');
INSERT INTO `scenic` VALUES (19, '西湖', 'https://example.com/scenic4.jpg', 30.00, '浙江省杭州市的一座淡水湖泊', 5, 5, '浙江省杭州市西湖区');
INSERT INTO `scenic` VALUES (20, '黄山', 'https://example.com/scenic5.jpg', 80.00, '世界文化与自然双遗产', 5, 11, '安徽省黄山市黄山区南大街24号');
INSERT INTO `scenic` VALUES (21, '千岛湖', 'https://example.com/scenic6.jpg', 50.00, '浙江省杭州市余杭区的一个人工水库', 4, 5, '浙江省杭州市余杭区');
INSERT INTO `scenic` VALUES (22, '张家界', 'https://example.com/scenic7.jpg', 75.00, '世界自然遗产', 5, 19, '湖南省张家界市永定区武陵源风景区');
INSERT INTO `scenic` VALUES (23, '鼓浪屿', 'https://example.com/scenic10.jpg', 20.00, '厦门市思明区一个海岛', 4, 21, '福建省厦门市思明区');
INSERT INTO `scenic` VALUES (24, '三亚湾', 'https://example.com/scenic11.jpg', 70.00, '中国海南省三亚市的一处海湾', 5, 15, '海南省三亚市三亚湾路');
INSERT INTO `scenic` VALUES (25, '深圳欢乐谷', 'https://example.com/scenic12.jpg', 55.00, '广东省深圳市的一个主题公园', 4, 4, '广东省深圳市南山区华侨城海上世界');
INSERT INTO `scenic` VALUES (26, '东方明珠塔', 'https://example.com/scenic13.jpg', 70.00, '中国上海市浦东新区陆家嘴的一座高塔', 5, 2, '上海市浦东新区东方路1号');
INSERT INTO `scenic` VALUES (27, '兵马俑', 'https://example.com/scenic14.jpg', 50.00, '世界文化遗产', 5, 9, '陕西省西安市临潼区秦始皇陵以东1.5公里处');
INSERT INTO `scenic` VALUES (28, '三亚湾', 'https://example.com/scenic17.jpg', 70.00, '中国海南省三亚市的一处海湾', 5, 15, '海南省三亚市三亚湾路');
INSERT INTO `scenic` VALUES (29, '张家界', 'https://example.com/scenic18.jpg', 75.00, '世界自然遗产', 5, 19, '湖南省张家界市永定区武陵源风景区');
INSERT INTO `scenic` VALUES (30, '五台山', 'https://example.com/scenic19.jpg', 60.00, '佛教圣地', 5, 13, '陕西省西安市周至县五台山景区');
INSERT INTO `scenic` VALUES (31, '七彩丹霞地貌', 'https://example.com/scenic20.jpg', 50.00, '世界遗产', 5, 15, '广西桂林市阳朔县界首镇丹霞村');
INSERT INTO `scenic` VALUES (32, '十八里画廊', 'https://example.com/scenic21.jpg', 55.00, '丹霞地貌的奇特景观', 5, 15, '广西桂林市凌云县和平乡十八里');
INSERT INTO `scenic` VALUES (33, '葛纠纤维拉', 'https://example.com/scenic22.jpg', 30.00, '高山错落的山顶湖泊', 5, 6, '云南省大理白族自治州漾濞彝族自治县');

-- ----------------------------
-- Table structure for scenic_orders
-- ----------------------------
DROP TABLE IF EXISTS `scenic_orders`;
CREATE TABLE `scenic_orders`  (
  `so_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `scenic_id` int NULL DEFAULT NULL COMMENT '景点id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `so_status` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '订单状态',
  `so_time` datetime NULL DEFAULT NULL COMMENT '预定时间',
  PRIMARY KEY (`so_id`) USING BTREE,
  INDEX `scenic_id`(`scenic_id` ASC) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  CONSTRAINT `scenic_orders_ibfk_1` FOREIGN KEY (`scenic_id`) REFERENCES `scenic` (`scenic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `scenic_orders_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of scenic_orders
-- ----------------------------
INSERT INTO `scenic_orders` VALUES (61, 16, 5, '已预订', '2022-01-01 12:30:00');
INSERT INTO `scenic_orders` VALUES (62, 17, 6, '已取消', '2022-01-02 08:45:00');
INSERT INTO `scenic_orders` VALUES (63, 20, 7, '已完成', '2022-01-03 10:15:00');
INSERT INTO `scenic_orders` VALUES (64, 21, 4, '已预订', '2022-01-04 14:20:00');
INSERT INTO `scenic_orders` VALUES (65, 20, 5, '已预订', '2022-01-05 16:30:00');
INSERT INTO `scenic_orders` VALUES (66, 22, 6, '已完成', '2022-01-06 11:50:00');
INSERT INTO `scenic_orders` VALUES (67, 22, 7, '已预订', '2022-01-07 09:40:00');
INSERT INTO `scenic_orders` VALUES (68, 22, 8, '已取消', '2022-01-08 10:55:00');
INSERT INTO `scenic_orders` VALUES (69, 17, 9, '已预订', '2022-01-09 13:25:00');
INSERT INTO `scenic_orders` VALUES (70, 26, 10, '已完成', '2022-01-10 15:35:00');
INSERT INTO `scenic_orders` VALUES (72, 22, 12, '已完成', '2022-01-12 17:25:00');
INSERT INTO `scenic_orders` VALUES (73, 24, 13, '已预订', '2022-01-13 14:30:00');
INSERT INTO `scenic_orders` VALUES (74, 18, 14, '已取消', '2022-01-14 09:20:00');

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
  `balance` decimal(10, 2) UNSIGNED NULL DEFAULT 0.00 COMMENT '用户余额',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', '1', NULL, NULL, '1', NULL, NULL, 0.00);
INSERT INTO `user` VALUES (3, '我爱吃鱼', '654321', '13999999999', 'fish@qq.com', '0', 30, '440111198901010002', 0.00);
INSERT INTO `user` VALUES (4, '张三', '123456', '13888888888', 'zhangsan@qq.com', '1', 28, '11010119900101001X', 1000.00);
INSERT INTO `user` VALUES (5, '李四', '123456', '13999999999', 'lisi@qq.com', '0', 32, '12010119890101001X', 2000.00);
INSERT INTO `user` VALUES (6, '王五', '123456', '13000000000', 'wangwu@qq.com', '1', 26, '13010119950101001X', 3000.00);
INSERT INTO `user` VALUES (7, '赵六', '123456', '13111111111', 'zhaoliu@qq.com', '1', 30, '14010119910101001X', 4000.00);
INSERT INTO `user` VALUES (8, '钱七', '123456', '13222222222', 'qianqi@qq.com', '0', 29, '15010119920101001X', 5000.00);
INSERT INTO `user` VALUES (9, '孙八', '123456', '13333333333', 'sunba@qq.com', '1', 27, '16010119930101001X', 6000.00);
INSERT INTO `user` VALUES (10, '周九', '123456', '13444444444', 'zhoujiu@qq.com', '0', 25, '17010119940101001X', 7000.00);
INSERT INTO `user` VALUES (11, '吴十', '123456', '13555555555', 'wushi@qq.com', '1', 24, '18010119950101001X', 8000.00);
INSERT INTO `user` VALUES (12, '郑十一', '123456', '13666666666', 'zhengshiyi@qq.com', '1', 23, '19010119960101001X', 9000.00);
INSERT INTO `user` VALUES (13, '王十二', '123456', '13777777777', 'wangshier@qq.com', '0', 22, '20010119970101001X', 10000.00);
INSERT INTO `user` VALUES (14, '赵十三', '123456', '13999998888', 'zhaoshisan@qq.com', '1', 29, '21010119920101001X', 11000.00);
INSERT INTO `user` VALUES (15, '钱十四', '123456', '13888887777', 'qiansishi@qq.com', '1', 31, '22010119900101001X', 12000.00);
INSERT INTO `user` VALUES (16, '孙十五', '123456', '13123456789', 'sunshiwu@qq.com', '0', 28, '23010119890101001X', 13000.00);
INSERT INTO `user` VALUES (17, '周十六', '123456', '13234567890', 'zhouershiliu@qq.com', '0', 26, '31010119930101001X', 14000.00);
INSERT INTO `user` VALUES (18, '吴十七', '123456', '13345678901', 'wushiqi@qq.com', '1', 27, '32010119920101001X', 15000.00);
INSERT INTO `user` VALUES (19, '我爱吃鱼', '654321', '13999999999', 'fish@qq.com', '0', 30, '440111198901010002', 0.00);
INSERT INTO `user` VALUES (20, '猫箱', 'abcdefg', '13666666666', 'cat@126.com', '1', 20, '440111198901010003', 0.00);
INSERT INTO `user` VALUES (21, 'AliceWonderland', 'qwertyuiop', '13555555555', 'alice@gmail.com', '0', 28, '440111198901010004', 0.00);
INSERT INTO `user` VALUES (22, '小葵花开', 'asdfghjkl', '13777777777', 'sunflower@hotmail.com', '0', 22, '440111198901010005', 0.00);
INSERT INTO `user` VALUES (23, '天空之城', 'zxcvbnmnbvcxz', '13848888848', 'sky@163.com', '1', 26, '440111198901010006', 0.00);
INSERT INTO `user` VALUES (24, '梦里花落知多少', 'qazwsxedcrfv', '13888885888', 'dreamflower@qq.com', '0', 24, '440111198901010007', 0.00);
INSERT INTO `user` VALUES (25, '青春不散场', 'qazw', '12488888888', 'afsgdreamflower@qq.com', '1', 29, '440111198901010008', 0.00);
INSERT INTO `user` VALUES (26, '一路向北', 'sadvssfv', '11888888888', 'asddreamflower@qq.com', '1', 27, '440111198901010009', 0.00);
INSERT INTO `user` VALUES (27, '梦想天空之城', 'sda', '13888828388', 'asgdfbdreamflower@qq.com', '0', 23, '440111198901010010', 0.00);
INSERT INTO `user` VALUES (28, '星辰大海', 'fy8bhks', '13123458888', 'ksky@163.com', '1', 21, '440111198901010011', 0.00);
INSERT INTO `user` VALUES (29, '夏日清风', 'rfvb', '12123458888', 'kmsky@163.com', '0', 25, '440111198901010112', 0.00);
INSERT INTO `user` VALUES (30, '秋叶原之旅', 'ft7gubhnkj', '14123458888', 'uiisky@163.com', '1', 28, '440111198901010102', 0.00);
INSERT INTO `user` VALUES (31, '冬日暖阳', 'fg', '15123458888', 'vgsky@163.com', '1', 26, '440111198901012202', 0.00);
INSERT INTO `user` VALUES (32, '小麦田', 'wheatfield123', '13877777777', 'wheatfield@gmail.com', '0', 27, '440111199401010001', 0.00);
INSERT INTO `user` VALUES (33, '海边漫步', 'seaside456', '13988888884', 'seaside@163.com', '1', 31, '440111198901010242', 0.00);
INSERT INTO `user` VALUES (34, '山水画卷', 'landscape789', '13629999999', 'landscape@qq.com', '0', 24, '440111198901210002', 0.00);
INSERT INTO `user` VALUES (35, '青春无悔', 'afdsgdfh', '13888888832', 'iosky@163.com', '0', 22, '440111198901210002', 0.00);
INSERT INTO `user` VALUES (36, '向往的生活', 'bkyui', '13444488888', 'hiohsky@163.com', '1', 28, '440111198901010222', 0.00);
INSERT INTO `user` VALUES (37, '旅行的意义', '7bhk', '16888888888', 'nnosky@163.com', '1', 26, '440111198901014003', 0.00);
INSERT INTO `user` VALUES (38, '追逐梦想的脚步', '213454', '13877777777', 'gbisky@163.com', '0', 23, '440111198906010002', 0.00);
INSERT INTO `user` VALUES (39, '热爱生活', 'lifeisgood123', '13766666666', 'lifeisgood@gmail.com', '0', 29, '440111199201010001', 0.00);
INSERT INTO `user` VALUES (40, '海天一色', 'seasky456', '13877777777', 'seasky@163.com', '1', 33, '440111198901310002', 0.00);
INSERT INTO `user` VALUES (41, '山水画境', 'landscape789', '18588888888', 'landscape@qq.com', '0', 26, '440111198901450002', 0.00);
INSERT INTO `user` VALUES (42, '梦想成真', 'tgyhik3', '11888888888', 'gsky@163.com', '1', 25, '44011119890101652', 0.00);
INSERT INTO `user` VALUES (43, '自由行', 't2368r', '19888888888', 'ibsky@163.com', '1', 30, '440111198901013502', 0.00);
INSERT INTO `user` VALUES (44, '旅行的乐趣', '13rt672gr', '13888800088', 'hosky@163.com', '0', 27, '440111198901013502', 0.00);
INSERT INTO `user` VALUES (45, '追逐未来的脚步', '13rt68gyi', '10834888888', 'hosky@163.com', '0', 24, '440111198901030002', 0.00);
INSERT INTO `user` VALUES (46, '自由之翼', 'freedomwing123', '13666667777', 'freedomwing@qq.com', '1', 25, '440111198901030011', 0.00);
INSERT INTO `user` VALUES (47, '旅行的足迹', 'travelfootprint456', '13777778888', 'travelfootprint@163.com', '0', 29, '440111198901030015', 0.00);
INSERT INTO `user` VALUES (48, '梦想家园', 'dreamhome789', '13888889999', 'dreamhome@qq.com', '1', 33, '440111198901030017', 0.00);
INSERT INTO `user` VALUES (49, '海阔天空', 'seasky1234', '13900001111', 'seasky@126.com', '1', 26, '440111198901030017', 0.00);
INSERT INTO `user` VALUES (50, 'Traveler1', 'travel123', '13811112222', 'traveler1@gmail.com', '0', 27, '440111199401010001', 0.00);
INSERT INTO `user` VALUES (51, 'Explorer2', 'explore456', '13922223333', 'explorer2@163.com', '1', 30, '420111199401010001', 0.00);
INSERT INTO `user` VALUES (52, 'Wanderlust3', 'wanderlust789', '13633334444', 'wanderlust3@qq.com', '0', 25, '440111199401010201', 0.00);
INSERT INTO `user` VALUES (53, 'Adventurer4', 'dfsg', '13922223332', 'adventurer4@hotmail.com', '1', 43, '440111199401010022', 0.00);

SET FOREIGN_KEY_CHECKS = 1;
