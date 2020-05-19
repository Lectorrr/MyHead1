/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : one

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 16/05/2020 10:22:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_book_info_category
-- ----------------------------
DROP TABLE IF EXISTS `book_book_info_category`;
CREATE TABLE `book_book_info_category`  (
  `category_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `FKtgld1vm4dyoxt8u043p6p7npa`(`category_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_book_info_category
-- ----------------------------
INSERT INTO `book_book_info_category` VALUES ('4028658170c9eca60170c9ee1f780000', '4028658170c9eca60170c9ee1fa10001');
INSERT INTO `book_book_info_category` VALUES ('40286581718ae4a101718ae556e60000', '40286581718ae4a101718ae557040001');
INSERT INTO `book_book_info_category` VALUES ('40286581718ae4a101718ae567ab0002', '40286581718ae4a101718ae567ae0003');
INSERT INTO `book_book_info_category` VALUES ('40286581718ae4a101718ae567ab0002', '40286581718ae4a101718ae56fb80004');
INSERT INTO `book_book_info_category` VALUES ('40286581718ae4a101718ae567ab0002', '40286581718ae4a101718ae579fe0005');
INSERT INTO `book_book_info_category` VALUES ('40286581718ae4a101718ae556e60000', '402865817203dffa017203e26e8c0000');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cover_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('4028658170c9eca60170c9ee1fa10001', '2020-03-11 14:09:51', '2020-03-11 14:09:51', '作者test', '书名test', NULL, '简介test', '出版社test');
INSERT INTO `book_info` VALUES ('40286581718ae4a101718ae557040001', '2020-04-18 01:26:58', '2020-04-18 01:26:58', '', '', NULL, '', '');
INSERT INTO `book_info` VALUES ('40286581718ae4a101718ae567ae0003', '2020-04-18 01:27:02', '2020-04-18 01:27:02', '123', '123', NULL, '123', '123');
INSERT INTO `book_info` VALUES ('40286581718ae4a101718ae56fb80004', '2020-04-18 01:27:04', '2020-04-18 01:27:04', '123', '123', NULL, '123', '123');
INSERT INTO `book_info` VALUES ('40286581718ae4a101718ae579fe0005', '2020-04-18 01:27:07', '2020-04-18 01:27:07', '123', '123', NULL, '123', '123');
INSERT INTO `book_info` VALUES ('402865817203dffa017203e26e8c0000', '2020-05-11 13:17:51', '2020-05-11 13:17:51', '', '', NULL, '', '');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_code` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('4028658170c9eca60170c9ee1f780000', '2020-03-11 14:09:51', '2020-03-11 14:09:51', '类别test', 0);
INSERT INTO `category` VALUES ('40286581718ae4a101718ae556e60000', '2020-04-18 01:26:58', '2020-04-18 01:26:58', '', 0);
INSERT INTO `category` VALUES ('40286581718ae4a101718ae567ab0002', '2020-04-18 01:27:02', '2020-04-18 01:27:02', '123', 0);

-- ----------------------------
-- Table structure for resource_files
-- ----------------------------
DROP TABLE IF EXISTS `resource_files`;
CREATE TABLE `resource_files`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `error_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_type_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE,
  INDEX `FKds59otm8fnvsj7tpn0nmr2tg1`(`file_type_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_files
-- ----------------------------
INSERT INTO `resource_files` VALUES ('40286581712fbaa601712fbad93c0001', '2020-03-31 08:35:06', '2020-03-31 08:35:06', NULL, '7.12.txt', '/E:/MyWorkSpace/Lectorrr/MyHead1/target/classes/static/', '1', '40286581712fbaa601712fbad87c0000');
INSERT INTO `resource_files` VALUES ('40286581712fbaa601712fbbad1f0003', '2020-03-31 08:35:36', '2020-03-31 08:35:36', NULL, '12.13补录工作量.txt', '/E:/MyWorkSpace/Lectorrr/MyHead1/target/classes/static/', '1', '40286581712fbaa601712fbba7710002');

-- ----------------------------
-- Table structure for resource_files_type
-- ----------------------------
DROP TABLE IF EXISTS `resource_files_type`;
CREATE TABLE `resource_files_type`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_files_type
-- ----------------------------
INSERT INTO `resource_files_type` VALUES ('40286581712fbaa601712fbad87c0000', '2020-03-31 08:35:06', '2020-03-31 08:35:06', 'text/plain');
INSERT INTO `resource_files_type` VALUES ('40286581712fbaa601712fbba7710002', '2020-03-31 08:35:58', '2020-03-31 08:35:58', 'text/plain');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_type` enum('menu','button') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('40286581719b647201719b655d6d0051', '2020-04-21 06:20:44', '2020-04-21 06:20:44', 'query', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('40286581719b647201719b655d64004e', '2020-04-21 06:20:44', '2020-04-21 06:20:44', 'add', NULL, NULL);
INSERT INTO `sys_permission` VALUES ('40286581719b647201719b655d61004d', '2020-04-21 06:20:44', '2020-04-21 06:20:44', 'query', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('40286581719b647201719b655d700052', '2020-04-21 06:20:44', '2020-04-21 06:20:44', 0, 'user');
INSERT INTO `sys_role` VALUES ('40286581719b647201719b655d66004f', '2020-04-21 06:20:44', '2020-04-21 06:20:44', 0, 'admin');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE,
  INDEX `FK9q28ewrhntqeipl1t04kh1be7`(`role_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('40286581719b647201719b655d66004f', '40286581719b647201719b655d6d0051');
INSERT INTO `sys_role_permission` VALUES ('40286581719b647201719b655d66004f', '40286581719b647201719b655d64004e');
INSERT INTO `sys_role_permission` VALUES ('40286581719b647201719b655d700052', '40286581719b647201719b655d61004d');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `uuid` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('123', NULL, NULL, 0, 'admin', NULL, 1, 'admin', '管理员', '1', '1', '男');
INSERT INTO `sys_user` VALUES ('4028658171de9d060171de9ef5e80000', '2020-05-04 07:37:59', '2020-05-04 07:37:59', 0, 'user', NULL, 1, 'user', 'user', '609951279@qq.com', '15687104242', '女');
INSERT INTO `sys_user` VALUES ('4028658171de817f0171de85e9da0000', '2020-05-04 07:10:46', '2020-05-04 07:10:46', 0, 'test', NULL, 1, 'test', NULL, '609951279@qq.com', '15687104242', '女');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `role_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `UKkklpfemq6n716st60qwg15y0t`(`user_id`, `role_id`) USING BTREE,
  INDEX `FKhh52n8vd4ny9ff4x9fb8v65qx`(`role_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('40286581719b647201719b655d66004f', '123');
INSERT INTO `sys_user_role` VALUES ('40286581719b647201719b655d700052', '40286581719b647201719b64ed4a0006');
INSERT INTO `sys_user_role` VALUES ('40286581719b647201719b655d700052', '4028658171de9d060171de9ef5e80000');

SET FOREIGN_KEY_CHECKS = 1;
