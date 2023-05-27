/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : labreserve

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 24/05/2023 14:48:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_stu_num` int UNSIGNED NOT NULL,
  `dept_tea_num` int UNSIGNED NOT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '计算机科学与工程学院', 398, 81);
INSERT INTO `department` VALUES (2, '电光学院', 400, 90);
INSERT INTO `department` VALUES (3, '机械工程学院', 550, 100);
INSERT INTO `department` VALUES (4, '公务学院', 213, 32);
INSERT INTO `department` VALUES (5, '自动化学院', 350, 98);
INSERT INTO `department` VALUES (6, ' 外国语学院', 222, 32);
INSERT INTO `department` VALUES (7, '能源动力学院', 234, 54);
INSERT INTO `department` VALUES (8, '人工智能学院', 120, 34);

-- ----------------------------
-- Table structure for labmanager_info
-- ----------------------------
DROP TABLE IF EXISTS `labmanager_info`;
CREATE TABLE `labmanager_info`  (
  `manager_id` int NOT NULL,
  `manager_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `e-mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of labmanager_info
-- ----------------------------
INSERT INTO `labmanager_info` VALUES (10001, '123', '308@qq');
INSERT INTO `labmanager_info` VALUES (10002, '123', '2345@163.com');

-- ----------------------------
-- Table structure for labresource_info
-- ----------------------------
DROP TABLE IF EXISTS `labresource_info`;
CREATE TABLE `labresource_info`  (
  `lab_id` int NOT NULL AUTO_INCREMENT,
  `seat_num` int NOT NULL,
  `lab_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `belong_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lab_manager_id` int NOT NULL,
  `can_use` tinyint NOT NULL,
  PRIMARY KEY (`lab_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of labresource_info
-- ----------------------------
INSERT INTO `labresource_info` VALUES (1, 34, '计科院实验室', '计算机科学与工程学院', 10001, 0);
INSERT INTO `labresource_info` VALUES (2, 45, '机械院实验室', '机械工程学院', 10001, 1);
INSERT INTO `labresource_info` VALUES (3, 65, '仿真实验室', '计算机科学与工程学院', 10001, 1);
INSERT INTO `labresource_info` VALUES (4, 45, '设计实验室', '公务学院', 10001, 1);
INSERT INTO `labresource_info` VALUES (5, 34, '传感实验室', '自动化学院', 10001, 1);
INSERT INTO `labresource_info` VALUES (6, 36, '硬件设计实验室', '计算机科学与工程学院', 10001, 1);
INSERT INTO `labresource_info` VALUES (7, 56, '金工实习车间', '机械工程学院', 10001, 1);
INSERT INTO `labresource_info` VALUES (8, 80, '美工实验室', '公务学院', 10002, 1);
INSERT INTO `labresource_info` VALUES (9, 67, '超导实验室', '自动化学院', 10001, 1);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `to_teacher_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `manager_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isRead` tinyint NOT NULL DEFAULT 0,
  `send_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (10, '实验室正在维修', '下水道漏水了', '1002', '10001', '金工实习', 1, '2023-05-11 11:19:11');
INSERT INTO `message` VALUES (11, '实验室开放时间更改', '下水道施工，暂时不能使用\n', '1001', '10001', 'c++程序设计', 1, '2023-05-11 12:12:28');
INSERT INTO `message` VALUES (12, '实验室开放时间更改', '', '1001', '10001', '硬件设计II', 1, '2023-05-12 17:09:10');
INSERT INTO `message` VALUES (14, '实验室已经被占', '请重新选择时间段', '1001', '10001', '硬件设计II', 1, '2023-05-14 13:29:41');
INSERT INTO `message` VALUES (15, '实验室正在维修', '无', '1001', '10001', '硬件设计II', 1, '2023-05-14 13:31:05');

-- ----------------------------
-- Table structure for reserve_bystu
-- ----------------------------
DROP TABLE IF EXISTS `reserve_bystu`;
CREATE TABLE `reserve_bystu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `week` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `day` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `laboratory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 134 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reserve_bystu
-- ----------------------------
INSERT INTO `reserve_bystu` VALUES (77, '101', '1001', '第9周', '周二', '2', '计算机科学与工程学院', 'c++程序设计', '计科院实验室');
INSERT INTO `reserve_bystu` VALUES (78, '101', '1001', '第9周', '周二', '3', '计算机科学与工程学院', 'c++程序设计', '计科院实验室');
INSERT INTO `reserve_bystu` VALUES (79, '101', '1001', '第1周', '周三', '1', '计算机科学与工程学院', '硬件设计II', '硬件设计实验室');
INSERT INTO `reserve_bystu` VALUES (80, '101', '1001', '第1周', '周一', '2', '计算机科学与工程学院', '硬件设计II', '硬件设计实验室');
INSERT INTO `reserve_bystu` VALUES (81, '101', '1001', '第3周', '周三', '1', '计算机科学与工程学院', '硬件设计II', '硬件设计实验室');
INSERT INTO `reserve_bystu` VALUES (82, '101', '1001', '第3周', '周一', '2', '计算机科学与工程学院', '硬件设计II', '硬件设计实验室');
INSERT INTO `reserve_bystu` VALUES (84, '102', '1001', '第11周', '周一', '2', '计算机科学与工程学院', 'c++程序设计', '计科院实验室');
INSERT INTO `reserve_bystu` VALUES (85, '103', '1001', '第1周', '周三', '1', '计算机科学与工程学院', 'c++程序设计', '计科院实验室');
INSERT INTO `reserve_bystu` VALUES (86, '103', '1001', '第1周', '周一', '2', '计算机科学与工程学院', 'c++程序设计', '计科院实验室');
INSERT INTO `reserve_bystu` VALUES (87, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (88, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (89, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (90, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (91, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (92, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (93, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (94, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (95, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (96, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (97, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (98, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (99, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (100, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (101, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (102, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (103, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (104, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (105, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (106, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (107, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (108, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (109, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (110, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (111, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (112, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (113, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (114, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (115, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (116, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (117, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (118, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (119, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (120, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (121, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (122, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (123, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (124, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (125, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (126, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (127, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (128, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (129, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (130, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (131, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (132, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');
INSERT INTO `reserve_bystu` VALUES (133, '101', '1001', '第八周', '周三', '第二大节', '材料学院', '高分子化合物', '二栋301');

-- ----------------------------
-- Table structure for reserve_bytea
-- ----------------------------
DROP TABLE IF EXISTS `reserve_bytea`;
CREATE TABLE `reserve_bytea`  (
  `tea_reserve_record_id` int NOT NULL AUTO_INCREMENT,
  `is_passed` tinyint NOT NULL DEFAULT 0,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laboratory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_num` int NULL DEFAULT NULL,
  `trial_times` int NOT NULL,
  `week` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `day` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `course` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tea_reserve_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 217 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reserve_bytea
-- ----------------------------
INSERT INTO `reserve_bytea` VALUES (195, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第1周', '周三', '1');
INSERT INTO `reserve_bytea` VALUES (196, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第1周', '周一', '2');
INSERT INTO `reserve_bytea` VALUES (197, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第9周', '周三', '3');
INSERT INTO `reserve_bytea` VALUES (198, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第9周', '周四', '3');
INSERT INTO `reserve_bytea` VALUES (199, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第7周', '周二', '2');
INSERT INTO `reserve_bytea` VALUES (200, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第7周', '周三', '2');
INSERT INTO `reserve_bytea` VALUES (202, 1, '计算机科学与工程学院', '计科院实验室', '1001', '32课时', 'c++程序设计', 35, 4, '第11周', '周二', '2');
INSERT INTO `reserve_bytea` VALUES (204, 1, '计算机科学与工程学院', '硬件设计实验室', '1001', '32课时', '硬件设计II', 12, 4, '第1周', '周三', '1');
INSERT INTO `reserve_bytea` VALUES (205, 1, '计算机科学与工程学院', '硬件设计实验室', '1001', '32课时', '硬件设计II', 12, 4, '第1周', '周一', '2');
INSERT INTO `reserve_bytea` VALUES (206, 1, '计算机科学与工程学院', '硬件设计实验室', '1001', '32课时', '硬件设计II', 12, 4, '第3周', '周三', '1');
INSERT INTO `reserve_bytea` VALUES (207, 1, '计算机科学与工程学院', '硬件设计实验室', '1001', '32课时', '硬件设计II', 12, 4, '第3周', '周一', '2');
INSERT INTO `reserve_bytea` VALUES (211, 1, '计算机科学与工程学院', '仿真实验室', '1001', '32课时', '汇编基础', 43, 2, '第1周', '周三', '1');
INSERT INTO `reserve_bytea` VALUES (216, 0, '计算机科学与工程学院', '硬件设计实验室', '1001', '16课时', '硬件设计II', 12, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for reservelab_ensure
-- ----------------------------
DROP TABLE IF EXISTS `reservelab_ensure`;
CREATE TABLE `reservelab_ensure`  (
  `ensure_id` int NOT NULL AUTO_INCREMENT,
  `week` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `day` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laboratory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_num` int NULL DEFAULT NULL,
  `trial_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reserve_tea_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operate_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ensure_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservelab_ensure
-- ----------------------------
INSERT INTO `reservelab_ensure` VALUES (6, '第3周', '周一', '2', '硬件设计实验室', 32, NULL, '硬件设计II', '1001', '计算机科学与工程学院', '2023-05-12 17:09:05');
INSERT INTO `reservelab_ensure` VALUES (7, '第4周', '周一', '3', '硬件设计实验室', 23, NULL, '硬件设计II', '1001', '计算机科学与工程学院', '2023-05-13 16:40:33');
INSERT INTO `reservelab_ensure` VALUES (8, '第3周', '周一', '3', '硬件设计实验室', 23, NULL, '硬件设计II', '1001', '计算机科学与工程学院', '2023-05-14 13:28:39');

-- ----------------------------
-- Table structure for reservelab_plan
-- ----------------------------
DROP TABLE IF EXISTS `reservelab_plan`;
CREATE TABLE `reservelab_plan`  (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `reserve_week` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reserve_day` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reserve_course` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_num` int NULL DEFAULT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_refused` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `class_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reserve_tea_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `laboratory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`plan_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservelab_plan
-- ----------------------------
INSERT INTO `reservelab_plan` VALUES (16, '第4周', '周一', '3', 12, '硬件设计II', NULL, 1, NULL, '1001', '硬件设计实验室', '计算机科学与工程学院');
INSERT INTO `reservelab_plan` VALUES (17, '第1周', '周二', '2', 23, '硬件设计II', NULL, 1, NULL, '1001', '硬件设计实验室', '计算机科学与工程学院');
INSERT INTO `reservelab_plan` VALUES (18, '第1周', '周三', '2', 35, '硬件设计II', NULL, 0, NULL, '1001', '硬件设计实验室', '计算机科学与工程学院');
INSERT INTO `reservelab_plan` VALUES (19, '第1周', '周三', '1', 35, '硬件设计II', NULL, 0, NULL, '1001', '硬件设计实验室', '计算机科学与工程学院');
INSERT INTO `reservelab_plan` VALUES (20, '第1周', '周三', '2', 35, '硬件设计II', NULL, 0, NULL, '1001', '硬件设计实验室', '计算机科学与工程学院');
INSERT INTO `reservelab_plan` VALUES (21, '第1周', '周四', '3', 2, '硬件设计II', NULL, 0, NULL, '1001', '硬件设计实验室', '计算机科学与工程学院');
INSERT INTO `reservelab_plan` VALUES (22, '第11周', '周三', '1', 34, 'c++程序设计', NULL, 0, NULL, '1001', '计科院实验室', '计算机科学与工程学院');

-- ----------------------------
-- Table structure for semester
-- ----------------------------
DROP TABLE IF EXISTS `semester`;
CREATE TABLE `semester`  (
  `semester_id` int NOT NULL AUTO_INCREMENT,
  `semester_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start_date` date NOT NULL,
  `start_weekday` int NOT NULL,
  `week_num` int NOT NULL,
  PRIMARY KEY (`semester_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of semester
-- ----------------------------
INSERT INTO `semester` VALUES (1, '2023春季学期', '2023-02-20', 1, 20);
INSERT INTO `semester` VALUES (2, '2022秋季学期', '2022-09-01', 1, 20);

-- ----------------------------
-- Table structure for stu_tea_semester
-- ----------------------------
DROP TABLE IF EXISTS `stu_tea_semester`;
CREATE TABLE `stu_tea_semester`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `semester` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_tea_semester
-- ----------------------------
INSERT INTO `stu_tea_semester` VALUES (3, '101', '1001', '2023春季学期', '硬件设计II');
INSERT INTO `stu_tea_semester` VALUES (5, '101', '1002', '2023春季学期', '机械制图');
INSERT INTO `stu_tea_semester` VALUES (6, '102', '1002', '2023春季学期', '金工实习');
INSERT INTO `stu_tea_semester` VALUES (7, '102', '1001', '2023春季学期', 'c++程序设计');
INSERT INTO `stu_tea_semester` VALUES (8, '102', '1001', '2023春季学期', '汇编基础');
INSERT INTO `stu_tea_semester` VALUES (9, '103', '1001', '2023春季学期', 'c++程序设计');
INSERT INTO `stu_tea_semester` VALUES (10, '101', '1002', '2023春季学期', 'c++程序设计');
INSERT INTO `stu_tea_semester` VALUES (11, '102', '1001', '2023春季学期', '汇编基础');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `stu_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_gender` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`, `stu_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (15, '101', '123', '1', '李海鑫', '9191065502', '计算机科学与工程学院', '3083583682@qq.com');
INSERT INTO `student_info` VALUES (18, '102', '123', '1', '李福滨', '9191065502', '计算机科学与工程学院', '234889@163.com');
INSERT INTO `student_info` VALUES (20, '103', '123', '1', '张明', '三年二班', '机械工程学院', '2428943@sina.com');
INSERT INTO `student_info` VALUES (22, '919106840623', '123', '1', '王朗', '9191065502', '计算机科学与工程学院', '2428943@sina.com');
INSERT INTO `student_info` VALUES (24, '919106840624', '123', '0', '王敏', '9191065502', '计算机科学与工程学院', '2428943@sina.com');
INSERT INTO `student_info` VALUES (26, '919106840625', '123', '1', '李俊熙', '9191065502', '机械工程学院', '2428943@sina.com');
INSERT INTO `student_info` VALUES (27, '919106840626', '123', '1', '高开慧', '9191065502', '计算机科学与工程学院', '2428943@sina.com');
INSERT INTO `student_info` VALUES (39, '919106840624', '123456', '1', '李海鑫', '9191065502', '计算机科学与工程学院', '308@qq.com');
INSERT INTO `student_info` VALUES (45, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (46, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (47, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (48, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (49, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (50, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (51, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (52, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (53, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (54, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (55, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (56, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (57, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (58, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (59, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (60, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (61, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (62, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (63, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (64, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (65, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (66, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (67, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (68, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (69, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (70, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (71, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (72, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (73, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (74, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (75, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (76, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (77, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (78, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (79, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (80, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (81, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (82, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (83, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (84, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (85, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (86, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (87, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (88, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (89, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (90, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');
INSERT INTO `student_info` VALUES (91, '102', '123', '1', '海鑫', '32班', '机械院', '123@qq');

-- ----------------------------
-- Table structure for sysmanager_info
-- ----------------------------
DROP TABLE IF EXISTS `sysmanager_info`;
CREATE TABLE `sysmanager_info`  (
  `manager_id` int NOT NULL,
  `manager_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysmanager_info
-- ----------------------------
INSERT INTO `sysmanager_info` VALUES (100001, '123');

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `tea_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tea_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tea_gender` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tea_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (1, '1001', '张均', '123', '1', '计算机科学与工程学院', '3083583682@qq.com');
INSERT INTO `teacher_info` VALUES (9, '1002', '王瀚', '123', '1', '机械工程学院', '234@111');
INSERT INTO `teacher_info` VALUES (17, '1003', '杨敏', '123', '0', '机械工程学院', 'qq@sina');
INSERT INTO `teacher_info` VALUES (20, '1004', '阳德群院士', '123', '1', '计算机科学与工程学院', '202@sina');
INSERT INTO `teacher_info` VALUES (30, '1005', '王二民', '123', '0', '人工智能学院', '3083583682@qq.com');
INSERT INTO `teacher_info` VALUES (36, '1007', '王阳', '123', '0', '机械工程学院', '3083583682@qq.com');
INSERT INTO `teacher_info` VALUES (37, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (38, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (39, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (40, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (41, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (42, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (43, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (44, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (45, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (46, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (47, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (48, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (49, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (50, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (51, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (52, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (53, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (54, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (55, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (56, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (57, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (58, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (59, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (60, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (61, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (62, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (63, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (64, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (65, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (66, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (67, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (68, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (69, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (70, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (71, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (72, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (73, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (74, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (75, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (76, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (77, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (78, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (79, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (80, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (81, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (82, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');
INSERT INTO `teacher_info` VALUES (83, '111', '孙廷凯', '123', '1', '计算机院', '308@qq');

-- ----------------------------
-- Table structure for trial_info
-- ----------------------------
DROP TABLE IF EXISTS `trial_info`;
CREATE TABLE `trial_info`  (
  `class_time` int NOT NULL,
  `lab_times` int NOT NULL,
  `trial_id` int NOT NULL,
  `stu_num` int NOT NULL,
  `tea_id` int NOT NULL,
  `trial_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`trial_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trial_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
