/*
 Navicat MySQL Data Transfer

 Source Server         : qianyufei
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : 学生宿舍管理系统

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 17/05/2023 12:15:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for 学生
-- ----------------------------
DROP TABLE IF EXISTS `学生`;
CREATE TABLE `学生`  (
  `学号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `性别` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `楼号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `宿舍号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `学院` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `班级` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `政治面貌` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系方式` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `备注` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `密码` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456',
  PRIMARY KEY (`学号`) USING BTREE,
  INDEX `楼号`(`楼号`) USING BTREE,
  INDEX `宿舍号`(`宿舍号`) USING BTREE,
  CONSTRAINT `学生_ibfk_1` FOREIGN KEY (`楼号`) REFERENCES `楼栋` (`楼号`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `学生_ibfk_2` FOREIGN KEY (`宿舍号`) REFERENCES `宿舍编号` (`宿舍号`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 学生
-- ----------------------------
INSERT INTO `学生` VALUES ('21906031000', '张三', '男', '1', '101', '信息工程学院', '19计算机一班', '团员', '15205677517', '无', '123456');
INSERT INTO `学生` VALUES ('21906031001', '张昊', '男', '1', '101', '信息工程学院', '19计算机一班', '团员', '18377041870', '无', 'qyf01218');
INSERT INTO `学生` VALUES ('21906031002', '李明', '男', '1', '101', '信息工程学院', '19计算机一班', '团员', '13591212327', '无', '123456');
INSERT INTO `学生` VALUES ('21906031003', '张开', '男', '1', '101', '信息工程学院', '19计算机一班', '团员', '18456417920', '无', '123456');
INSERT INTO `学生` VALUES ('21906031004', '赵明', '男', '1', '101', '信息工程学院', '19计算机一班', '党员', '13813098703', '无', '123456');
INSERT INTO `学生` VALUES ('21906031005', '赵凯', '男', '1', '102', '信息工程学院', '19计算机一班', '团员', '13442508550', '无', '123456');
INSERT INTO `学生` VALUES ('21906031006', '郑华', '男', '1', '102', '信息工程学院', '19计算机一班', '团员', '18811467262', '无', '123456');
INSERT INTO `学生` VALUES ('21906031007', '李四', '男', '1', '102', '信息工程学院', '19计算机一班', '团员', '15831256504', '无', '123456');
INSERT INTO `学生` VALUES ('21906031008', '张三', '男', '1', '102', '信息工程学院', '19计算机一班', '团员', '13944353415', '无', '123456');
INSERT INTO `学生` VALUES ('21906031009', '赵六', '男', '1', '103', '信息工程学院', '19计算机一班', '党员', '13415406641', '无', '123456');
INSERT INTO `学生` VALUES ('21906031010', '李明明', '男', '1', '103', '信息工程学院', '19计算机一班', '团员', '15214604130', '无', '123456');
INSERT INTO `学生` VALUES ('21906031011', '石小健', '男', '1', '103', '信息工程学院', '19计算机一班', '团员', '15010887548', '无', '123456');
INSERT INTO `学生` VALUES ('21906031012', '时小龙', '男', '1', '103', '信息工程学院', '19计算机一班', '团员', '15243625996', '无', '123456');
INSERT INTO `学生` VALUES ('21906031013', '林平之', '男', '1', '201', '信息工程学院', '19计算机一班', '团员', '18213211464', '无', '123456');
INSERT INTO `学生` VALUES ('21906031014', '杨过', '男', '1', '201', '信息工程学院', '19计算机一班', '团员', '15013942030', '无', '123456');
INSERT INTO `学生` VALUES ('21906031015', '杨康', '男', '1', '201', '信息工程学院', '19计算机一班', '团员', '19873702394', '无', '123456');
INSERT INTO `学生` VALUES ('21906031016', '李思源', '男', '1', '201', '信息工程学院', '19计算机一班', '团员', '18313403248', '无', '123456');
INSERT INTO `学生` VALUES ('21906031017', '李星云', '男', '1', '202', '信息工程学院', '19计算机一班', '团员', '15271675634', '无', '123456');
INSERT INTO `学生` VALUES ('21906031018', '上官红', '男', '1', '202', '信息工程学院', '19计算机一班', '团员', '17854301242', '无', '123456');
INSERT INTO `学生` VALUES ('21906031019', '东方朔', '男', '1', '202', '信息工程学院', '19计算机一班', '团员', '18270938919', '无', '123456');
INSERT INTO `学生` VALUES ('21906031020', '奎因', '男', '1', '202', '信息工程学院', '19计算机一班', '团员', '14744741467', '无', '123456');
INSERT INTO `学生` VALUES ('21906031021', '朱文', '男', '1', '203', '信息工程学院', '19计算机一班', '团员', '15865085660', '无', '123456');
INSERT INTO `学生` VALUES ('21906031022', '石敬瑭', '男', '1', '203', '信息工程学院', '19计算机一班', '团员', '15114259216', '无', '123456');
INSERT INTO `学生` VALUES ('21906031023', '李存礼', '男', '1', '203', '信息工程学院', '19计算机一班', '团员', '18490042050', '无', '123456');
INSERT INTO `学生` VALUES ('21906031024', '李存辉', '男', '1', '203', '信息工程学院', '19计算机一班', '团员', '17259463635', '无', '123456');
INSERT INTO `学生` VALUES ('21906031025', '丁瑞琪', '男', '1', '301', '信息工程学院', '19计算机一班', '团员', '18404371303', '无', '123456');
INSERT INTO `学生` VALUES ('21906031026', '李达康', '男', '1', '301', '信息工程学院', '19计算机一班', '团员', '17818427639', '无', '123456');
INSERT INTO `学生` VALUES ('21906031027', '李志清', '男', '1', '301', '信息工程学院', '19计算机一班', '团员', '18428899665', '无', '123456');
INSERT INTO `学生` VALUES ('21906031028', '李志军', '男', '1', '301', '信息工程学院', '19计算机一班', '团员', '15236665971', '无', '123456');
INSERT INTO `学生` VALUES ('21906031029', '李坤', '男', '1', '302', '信息工程学院', '19计算机一班', '团员', '14792217898', '无', '123456');
INSERT INTO `学生` VALUES ('21906031030', '章凯', '男', '1', '302', '信息工程学院', '19计算机一班', '团员', '18829102709', '无', '123456');
INSERT INTO `学生` VALUES ('21906031031', '李俊', '男', '1', '302', '信息工程学院', '19计算机一班', '团员', '15803141554', '无', '123456');
INSERT INTO `学生` VALUES ('21906031032', '李璐瑜', '男', '1', '302', '信息工程学院', '19计算机一班', '团员', '17809722228', '无', '123456');
INSERT INTO `学生` VALUES ('21906031033', '赵思', '男', '1', '303', '信息工程学院', '19计算机一班', '团员', '13605585187', '无', '123456');
INSERT INTO `学生` VALUES ('21906031034', '张建国', '男', '1', '303', '信息工程学院', '19计算机一班', '团员', '14701584986', '无', '123456');
INSERT INTO `学生` VALUES ('21906031035', '李建设', '男', '1', '303', '信息工程学院', '19计算机一班', '团员', '15198685356', '无', '123456');
INSERT INTO `学生` VALUES ('21906031036', '隋建国', '男', '1', '303', '信息工程学院', '19计算机一班', '团员', '17888986084', '无', '123456');
INSERT INTO `学生` VALUES ('21906031037', '柏浩南', '男', '1', '401', '信息工程学院', '19计算机一班', '党员', '15283492544', '无', '123456');
INSERT INTO `学生` VALUES ('21906031038', '陈浩南', '男', '1', '401', '信息工程学院', '19计算机一班', '团员', '15937471315', '无', '123456');
INSERT INTO `学生` VALUES ('21906031039', '昂俊伟', '男', '1', '401', '信息工程学院', '19计算机一班', '团员', '15820749891', '无', '123456');
INSERT INTO `学生` VALUES ('21906031040', '李想', '男', '1', '401', '信息工程学院', '19计算机一班', '团员', '17273494562', '无', '123456');
INSERT INTO `学生` VALUES ('21906031041', '陈志军', '男', '1', '402', '信息工程学院', '19计算机一班', '团员', '13704567116', '无', '123456');
INSERT INTO `学生` VALUES ('21906031042', '董家康', '男', '1', '402', '信息工程学院', '19计算机一班', '团员', '15825096180', '无', '123456');
INSERT INTO `学生` VALUES ('21906031043', '方伟', '男', '1', '402', '信息工程学院', '19计算机一班', '团员', '18462903029', '无', '123456');
INSERT INTO `学生` VALUES ('21906031044', '葛孟强', '男', '1', '402', '信息工程学院', '19计算机一班', '团员', '14759256849', '无', '123456');
INSERT INTO `学生` VALUES ('21906031045', '陈浩', '男', '1', '403', '信息工程学院', '19计算机一班', '团员', '18449207795', '无', '123456');
INSERT INTO `学生` VALUES ('21906031046', '胡发憷', '男', '1', '403', '信息工程学院', '19计算机一班', '团员', '18744307492', '无', '123456');
INSERT INTO `学生` VALUES ('21906031047', '黄磊', '男', '1', '403', '信息工程学院', '19计算机一班', '团员', '15244379038', '无', '123456');
INSERT INTO `学生` VALUES ('21906031048', '蒋凯旋', '男', '1', '403', '信息工程学院', '19计算机一班', '团员', '18708353251', '无', '123456');
INSERT INTO `学生` VALUES ('21906031049', '雷锋', '男', '1', '501', '信息工程学院', '19计算机一班', '团员', '13616212629', '无', '123456');
INSERT INTO `学生` VALUES ('21906031050', '李斌', '男', '1', '501', '信息工程学院', '19计算机一班', '团员', '18459699556', '无', '123456');
INSERT INTO `学生` VALUES ('21906031051', '李成', '男', '1', '501', '信息工程学院', '19计算机一班', '团员', '16536171790', '无', '123456');
INSERT INTO `学生` VALUES ('21906031052', '林晨', '男', '1', '501', '信息工程学院', '19计算机一班', '团员', '15099062510', '无', '123456');
INSERT INTO `学生` VALUES ('21906031053', '张军', '男', '1', '502', '信息工程学院', '19计算机一班', '团员', '18853442143', '无', '123456');
INSERT INTO `学生` VALUES ('21906031054', '刘家强', '男', '1', '502', '信息工程学院', '19计算机一班', '团员', '17218655155', '无', '123456');
INSERT INTO `学生` VALUES ('21906031055', '刘佳伟', '男', '1', '502', '信息工程学院', '19计算机一班', '团员', '13958038908', '无', '123456');
INSERT INTO `学生` VALUES ('21906031056', '刘纾困', '男', '1', '502', '信息工程学院', '19计算机一班', '团员', '18272254328', '无', '123456');
INSERT INTO `学生` VALUES ('21906031057', '刘志和', '男', '1', '503', '信息工程学院', '19计算机一班', '团员', '19870541878', '无', '123456');
INSERT INTO `学生` VALUES ('21906031058', '马乐乐', '男', '1', '503', '信息工程学院', '19计算机一班', '团员', '13525219298', '无', '123456');
INSERT INTO `学生` VALUES ('21906031059', '孟涛', '男', '1', '503', '信息工程学院', '19计算机一班', '团员', '14721614974', '无', '123456');
INSERT INTO `学生` VALUES ('21906031060', '孟伟', '男', '1', '503', '信息工程学院', '19计算机一班', '团员', '18844912392', '无', '123456');
INSERT INTO `学生` VALUES ('21906031061', '李楠', '女', '8', '101', '外国语学院', '19外国语言文学一班', '团员', '15825749867', '无', '123456');
INSERT INTO `学生` VALUES ('21906031062', '章子怡', '女', '8', '101', '外国语学院', '19外国语言文学一班', '团员', '17852483281', '无', '123456');
INSERT INTO `学生` VALUES ('21906031063', '李娜', '女', '8', '101', '外国语学院', '19外国语言文学一班', '团员', '15838905269', '无', '123456');
INSERT INTO `学生` VALUES ('21906031064', '马小小', '女', '8', '101', '外国语学院', '19外国语言文学一班', '团员', '19838384072', '无', '123456');
INSERT INTO `学生` VALUES ('21906031065', '李璐瑶', '女', '8', '102', '外国语学院', '19外国语言文学一班', '团员', '18853843669', '无', '123456');
INSERT INTO `学生` VALUES ('21906031066', '黄巧', '女', '8', '102', '外国语学院', '19外国语言文学一班', '团员', '18490216927', '无', '123456');
INSERT INTO `学生` VALUES ('21906031067', '宋子青', '女', '8', '102', '外国语学院', '19外国语言文学一班', '团员', '14780567830', '无', '123456');
INSERT INTO `学生` VALUES ('21906031068', '李婉姚', '女', '8', '102', '外国语学院', '19外国语言文学一班', '团员', '18457331830', '无', '123456');
INSERT INTO `学生` VALUES ('21906031069', '李文静', '女', '8', '103', '外国语学院', '19外国语言文学一班', '团员', '18324771486', '无', '123456');
INSERT INTO `学生` VALUES ('21906031070', '杨航', '女', '8', '103', '外国语学院', '19外国语言文学一班', '团员', '18856385425', '无', '123456');
INSERT INTO `学生` VALUES ('21906031071', '李苗苗', '女', '8', '103', '外国语学院', '19外国语言文学一班', '团员', '15230861388', '无', '123456');
INSERT INTO `学生` VALUES ('21906031072', '钱丽华', '女', '8', '103', '外国语学院', '19外国语言文学一班', '团员', '18310496965', '无', '123456');
INSERT INTO `学生` VALUES ('21906031073', '赵丽华', '女', '8', '201', '外国语学院', '19外国语言文学一班', '团员', '18321991825', '无', '123456');
INSERT INTO `学生` VALUES ('21906031074', '胡春燕', '女', '8', '201', '外国语学院', '19外国语言文学一班', '团员', '18782725608', '无', '123456');
INSERT INTO `学生` VALUES ('21906031075', '谢丹', '女', '8', '201', '外国语学院', '19外国语言文学一班', '团员', '18739506375', '无', '123456');
INSERT INTO `学生` VALUES ('21906031076', '李红', '女', '8', '201', '外国语学院', '19外国语言文学一班', '团员', '13656773841', '无', '123456');
INSERT INTO `学生` VALUES ('21906031077', '钱露露', '女', '8', '202', '外国语学院', '19外国语言文学一班', '团员', '13806546394', '无', '123456');
INSERT INTO `学生` VALUES ('21906031078', '赵美丽', '女', '8', '202', '外国语学院', '19外国语言文学一班', '团员', '18866646399', '无', '123456');
INSERT INTO `学生` VALUES ('21906031079', '孙莉', '女', '8', '202', '外国语学院', '19外国语言文学一班', '党员', '15217697059', '无', '123456');
INSERT INTO `学生` VALUES ('21906031080', '孙丽', '女', '8', '202', '外国语学院', '19外国语言文学一班', '团员', '15764445064', '无', '123456');
INSERT INTO `学生` VALUES ('21906031081', '李梦美', '女', '8', '203', '外国语学院', '19外国语言文学一班', '团员', '15291528237', '无', '123456');
INSERT INTO `学生` VALUES ('21906031082', '李花', '女', '8', '203', '外国语学院', '19外国语言文学一班', '团员', '13428768906', '无', '123456');
INSERT INTO `学生` VALUES ('21906031083', '胡娜', '女', '8', '203', '外国语学院', '19外国语言文学一班', '团员', '15024888086', '无', '123456');
INSERT INTO `学生` VALUES ('21906031084', '李梦想', '女', '8', '203', '外国语学院', '19外国语言文学一班', '团员', '18849415798', '无', '123456');
INSERT INTO `学生` VALUES ('21906031085', '李曼文', '女', '8', '301', '外国语学院', '19外国语言文学一班', '团员', '18865408039', '无', '123456');
INSERT INTO `学生` VALUES ('21906031086', '李苑香', '女', '8', '301', '外国语学院', '19外国语言文学一班', '团员', '13930598615', '无', '123456');
INSERT INTO `学生` VALUES ('21906031087', '赵平安', '女', '8', '301', '外国语学院', '19外国语言文学一班', '团员', '15137839216', '无', '123456');
INSERT INTO `学生` VALUES ('21906031088', '李香桥', '女', '8', '301', '外国语学院', '19外国语言文学一班', '团员', '13431903981', '无', '123456');
INSERT INTO `学生` VALUES ('21906031089', '雷浩宇', '女', '8', '302', '外国语学院', '19外国语言文学一班', '团员', '15245705338', '无', '123456');
INSERT INTO `学生` VALUES ('21906031090', '李潘楠', '女', '8', '302', '外国语学院', '19外国语言文学一班', '团员', '13835763544', '无', '123456');
INSERT INTO `学生` VALUES ('21906031091', '李小冉', '女', '8', '302', '外国语学院', '19外国语言文学一班', '团员', '15909387895', '无', '123456');
INSERT INTO `学生` VALUES ('21906031092', '黎招娣', '女', '8', '302', '外国语学院', '19外国语言文学一班', '团员', '18793274078', '无', '123456');
INSERT INTO `学生` VALUES ('21906031093', '刘玉云', '女', '8', '303', '外国语学院', '19外国语言文学一班', '团员', '16523397039', '无', '123456');
INSERT INTO `学生` VALUES ('21906031094', '罗嘉欣', '女', '8', '303', '外国语学院', '19外国语言文学一班', '团员', '13738879066', '无', '123456');
INSERT INTO `学生` VALUES ('21906031095', '舒淇', '女', '8', '303', '外国语学院', '19外国语言文学一班', '团员', '19815003624', '无', '123456');
INSERT INTO `学生` VALUES ('21906031096', '杨颖', '女', '8', '303', '外国语学院', '19外国语言文学一班', '团员', '18801401276', '无', '123456');
INSERT INTO `学生` VALUES ('21906031097', '李紫晴', '女', '8', '401', '外国语学院', '19外国语言文学一班', '团员', '15759172108', '无', '123456');
INSERT INTO `学生` VALUES ('21906031098', '谭文静', '女', '8', '401', '外国语学院', '19外国语言文学一班', '团员', '15159572863', '无', '123456');
INSERT INTO `学生` VALUES ('21906031099', '王思佳', '女', '8', '401', '外国语学院', '19外国语言文学一班', '党员', '14712243612', '无', '123456');
INSERT INTO `学生` VALUES ('21906031100', '王艺璇', '女', '8', '401', '外国语学院', '19外国语言文学一班', '团员', '17813007150', '无', '123456');
INSERT INTO `学生` VALUES ('21906031101', '王宇晴', '女', '8', '402', '外国语学院', '19外国语言文学一班', '团员', '15768271159', '无', '123456');
INSERT INTO `学生` VALUES ('21906031102', '李梦晴', '女', '8', '402', '外国语学院', '19外国语言文学一班', '团员', '15602508804', '无', '123456');
INSERT INTO `学生` VALUES ('21906031103', '李茹情', '女', '8', '402', '外国语学院', '19外国语言文学一班', '团员', '13788011562', '无', '123456');
INSERT INTO `学生` VALUES ('21906031104', '李倩玉', '女', '8', '402', '外国语学院', '19外国语言文学一班', '团员', '18877091690', '无', '123456');
INSERT INTO `学生` VALUES ('21906031105', '王一轩', '女', '8', '403', '外国语学院', '19外国语言文学一班', '团员', '15860375825', '无', '123456');
INSERT INTO `学生` VALUES ('21906031106', '李璇', '女', '8', '403', '外国语学院', '19外国语言文学一班', '团员', '17885464627', '无', '123456');
INSERT INTO `学生` VALUES ('21906031107', '李清', '女', '8', '403', '外国语学院', '19外国语言文学一班', '团员', '13985153598', '无', '123456');
INSERT INTO `学生` VALUES ('21906031108', '莉亚', '女', '8', '403', '外国语学院', '19外国语言文学一班', '团员', '18114199304', '无', '123456');
INSERT INTO `学生` VALUES ('21906031109', '李梦雅', '女', '8', '501', '外国语学院', '19外国语言文学一班', '团员', '18148133135', '无', '123456');
INSERT INTO `学生` VALUES ('21906031110', '胡源', '女', '8', '501', '外国语学院', '19外国语言文学一班', '团员', '13333444054', '无', '123456');
INSERT INTO `学生` VALUES ('21906031111', '范冰冰', '女', '8', '501', '外国语学院', '19外国语言文学一班', '团员', '15836451766', '无', '123456');
INSERT INTO `学生` VALUES ('21906031112', '沈佳宜', '女', '8', '501', '外国语学院', '19外国语言文学一班', '团员', '18520991725', '无', '123456');
INSERT INTO `学生` VALUES ('21906031113', '李冰冰', '女', '8', '502', '外国语学院', '19外国语言文学一班', '团员', '15144198942', '无', '123456');
INSERT INTO `学生` VALUES ('21906031114', '赵丽娜', '女', '8', '502', '外国语学院', '19外国语言文学一班', '团员', '18965409709', '无', '123456');
INSERT INTO `学生` VALUES ('21906031115', '李盼盼', '女', '8', '502', '外国语学院', '19外国语言文学一班', '团员', '17241162304', '无', '123456');
INSERT INTO `学生` VALUES ('21906031116', '马瑶瑶', '女', '8', '502', '外国语学院', '19外国语言文学一班', '团员', '17778281967', '无', '123456');
INSERT INTO `学生` VALUES ('21906031117', '赵莉莉', '女', '8', '503', '外国语学院', '19外国语言文学一班', '团员', '17845091619', '无', '123456');
INSERT INTO `学生` VALUES ('21906031118', '张丽', '女', '8', '503', '外国语学院', '19外国语言文学一班', '党员', '17289184009', '无', '123456');
INSERT INTO `学生` VALUES ('21906031119', '李凤', '女', '8', '503', '外国语学院', '19外国语言文学一班', '团员', '15216149729', '无', '123456');
INSERT INTO `学生` VALUES ('21906031120', '罗安妮', '女', '8', '503', '外国语学院', '19外国语言文学一班', '团员', '16631329814', '无', '123456');

-- ----------------------------
-- Table structure for 学生违纪
-- ----------------------------
DROP TABLE IF EXISTS `学生违纪`;
CREATE TABLE `学生违纪`  (
  `编号` bigint(255) NOT NULL AUTO_INCREMENT,
  `学号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `学院` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `班级` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `违纪描述` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `登记日期` date NULL DEFAULT NULL,
  PRIMARY KEY (`编号`) USING BTREE,
  INDEX `学号`(`学号`) USING BTREE,
  CONSTRAINT `学生违纪_ibfk_1` FOREIGN KEY (`学号`) REFERENCES `学生` (`学号`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 201 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 学生违纪
-- ----------------------------
INSERT INTO `学生违纪` VALUES (1, '21906031001', '张昊', '信息工程学院', '19计算机一班', '在宿舍抽烟', '2023-04-02');
INSERT INTO `学生违纪` VALUES (2, '21906031001', '张昊', '信息工程学院', '19计算机一班', '打架斗殴', '2023-03-21');
INSERT INTO `学生违纪` VALUES (3, '21906031002', '李明', '信息工程学院', '19计算机一班', '使用大功率电器', '2023-05-02');
INSERT INTO `学生违纪` VALUES (4, '21906031003', '张开', '信息工程学院', '19计算机一班', '使用违规电器', '2023-01-16');
INSERT INTO `学生违纪` VALUES (5, '21906031004', '赵明', '信息工程学院', '19计算机一班', '在宿舍抽烟', '2023-01-16');
INSERT INTO `学生违纪` VALUES (6, '21906031005', '赵凯', '信息工程学院', '19计算机一班', '夜不归宿', '2023-01-11');

-- ----------------------------
-- Table structure for 宿舍
-- ----------------------------
DROP TABLE IF EXISTS `宿舍`;
CREATE TABLE `宿舍`  (
  `楼号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `宿舍号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `类型` enum('四人间','五人间','六人间') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`楼号`, `宿舍号`) USING BTREE,
  INDEX `楼号`(`楼号`) USING BTREE,
  INDEX `宿舍号`(`宿舍号`) USING BTREE,
  CONSTRAINT `宿舍_ibfk_1` FOREIGN KEY (`楼号`) REFERENCES `楼栋` (`楼号`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `宿舍_ibfk_2` FOREIGN KEY (`宿舍号`) REFERENCES `宿舍编号` (`宿舍号`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 宿舍
-- ----------------------------
INSERT INTO `宿舍` VALUES ('1', '101', '四人间');
INSERT INTO `宿舍` VALUES ('1', '102', '四人间');
INSERT INTO `宿舍` VALUES ('1', '103', '四人间');
INSERT INTO `宿舍` VALUES ('1', '201', '四人间');
INSERT INTO `宿舍` VALUES ('1', '202', '四人间');
INSERT INTO `宿舍` VALUES ('1', '203', '四人间');
INSERT INTO `宿舍` VALUES ('1', '301', '四人间');
INSERT INTO `宿舍` VALUES ('1', '302', '四人间');
INSERT INTO `宿舍` VALUES ('1', '303', '四人间');
INSERT INTO `宿舍` VALUES ('1', '401', '四人间');
INSERT INTO `宿舍` VALUES ('1', '402', '四人间');
INSERT INTO `宿舍` VALUES ('1', '403', '四人间');
INSERT INTO `宿舍` VALUES ('1', '501', '四人间');
INSERT INTO `宿舍` VALUES ('1', '502', '四人间');
INSERT INTO `宿舍` VALUES ('1', '503', '四人间');
INSERT INTO `宿舍` VALUES ('2', '101', '五人间');
INSERT INTO `宿舍` VALUES ('2', '102', '五人间');
INSERT INTO `宿舍` VALUES ('2', '103', '五人间');
INSERT INTO `宿舍` VALUES ('2', '201', '五人间');
INSERT INTO `宿舍` VALUES ('2', '202', '五人间');
INSERT INTO `宿舍` VALUES ('2', '203', '五人间');
INSERT INTO `宿舍` VALUES ('2', '301', '五人间');
INSERT INTO `宿舍` VALUES ('2', '302', '五人间');
INSERT INTO `宿舍` VALUES ('2', '303', '五人间');
INSERT INTO `宿舍` VALUES ('2', '401', '五人间');
INSERT INTO `宿舍` VALUES ('2', '402', '五人间');
INSERT INTO `宿舍` VALUES ('2', '403', '五人间');
INSERT INTO `宿舍` VALUES ('2', '501', '五人间');
INSERT INTO `宿舍` VALUES ('2', '502', '五人间');
INSERT INTO `宿舍` VALUES ('2', '503', '五人间');
INSERT INTO `宿舍` VALUES ('3', '101', '六人间');
INSERT INTO `宿舍` VALUES ('3', '102', '六人间');
INSERT INTO `宿舍` VALUES ('3', '103', '六人间');
INSERT INTO `宿舍` VALUES ('3', '201', '六人间');
INSERT INTO `宿舍` VALUES ('3', '202', '六人间');
INSERT INTO `宿舍` VALUES ('3', '203', '六人间');
INSERT INTO `宿舍` VALUES ('3', '301', '六人间');
INSERT INTO `宿舍` VALUES ('3', '302', '六人间');
INSERT INTO `宿舍` VALUES ('3', '303', '六人间');
INSERT INTO `宿舍` VALUES ('3', '401', '六人间');
INSERT INTO `宿舍` VALUES ('3', '402', '六人间');
INSERT INTO `宿舍` VALUES ('3', '403', '六人间');
INSERT INTO `宿舍` VALUES ('3', '501', '六人间');
INSERT INTO `宿舍` VALUES ('3', '502', '六人间');
INSERT INTO `宿舍` VALUES ('3', '503', '六人间');
INSERT INTO `宿舍` VALUES ('4', '101', '四人间');
INSERT INTO `宿舍` VALUES ('4', '102', '四人间');
INSERT INTO `宿舍` VALUES ('4', '103', '四人间');
INSERT INTO `宿舍` VALUES ('4', '201', '四人间');
INSERT INTO `宿舍` VALUES ('4', '202', '四人间');
INSERT INTO `宿舍` VALUES ('4', '203', '四人间');
INSERT INTO `宿舍` VALUES ('4', '301', '四人间');
INSERT INTO `宿舍` VALUES ('4', '302', '四人间');
INSERT INTO `宿舍` VALUES ('4', '303', '四人间');
INSERT INTO `宿舍` VALUES ('4', '401', '四人间');
INSERT INTO `宿舍` VALUES ('4', '402', '四人间');
INSERT INTO `宿舍` VALUES ('4', '403', '四人间');
INSERT INTO `宿舍` VALUES ('4', '501', '四人间');
INSERT INTO `宿舍` VALUES ('4', '502', '四人间');
INSERT INTO `宿舍` VALUES ('4', '503', '四人间');
INSERT INTO `宿舍` VALUES ('5', '101', '四人间');
INSERT INTO `宿舍` VALUES ('5', '102', '四人间');
INSERT INTO `宿舍` VALUES ('5', '103', '四人间');
INSERT INTO `宿舍` VALUES ('5', '201', '四人间');
INSERT INTO `宿舍` VALUES ('5', '202', '四人间');
INSERT INTO `宿舍` VALUES ('5', '203', '四人间');
INSERT INTO `宿舍` VALUES ('5', '301', '四人间');
INSERT INTO `宿舍` VALUES ('5', '302', '四人间');
INSERT INTO `宿舍` VALUES ('5', '303', '四人间');
INSERT INTO `宿舍` VALUES ('5', '401', '四人间');
INSERT INTO `宿舍` VALUES ('5', '402', '四人间');
INSERT INTO `宿舍` VALUES ('5', '403', '四人间');
INSERT INTO `宿舍` VALUES ('5', '501', '四人间');
INSERT INTO `宿舍` VALUES ('5', '502', '四人间');
INSERT INTO `宿舍` VALUES ('5', '503', '四人间');
INSERT INTO `宿舍` VALUES ('6', '101', '五人间');
INSERT INTO `宿舍` VALUES ('6', '102', '五人间');
INSERT INTO `宿舍` VALUES ('6', '103', '五人间');
INSERT INTO `宿舍` VALUES ('6', '201', '五人间');
INSERT INTO `宿舍` VALUES ('6', '202', '五人间');
INSERT INTO `宿舍` VALUES ('6', '203', '五人间');
INSERT INTO `宿舍` VALUES ('6', '301', '五人间');
INSERT INTO `宿舍` VALUES ('6', '302', '五人间');
INSERT INTO `宿舍` VALUES ('6', '303', '五人间');
INSERT INTO `宿舍` VALUES ('6', '401', '五人间');
INSERT INTO `宿舍` VALUES ('6', '402', '五人间');
INSERT INTO `宿舍` VALUES ('6', '403', '五人间');
INSERT INTO `宿舍` VALUES ('6', '501', '五人间');
INSERT INTO `宿舍` VALUES ('6', '502', '五人间');
INSERT INTO `宿舍` VALUES ('6', '503', '五人间');
INSERT INTO `宿舍` VALUES ('7', '101', '六人间');
INSERT INTO `宿舍` VALUES ('7', '102', '六人间');
INSERT INTO `宿舍` VALUES ('7', '103', '六人间');
INSERT INTO `宿舍` VALUES ('7', '201', '六人间');
INSERT INTO `宿舍` VALUES ('7', '202', '六人间');
INSERT INTO `宿舍` VALUES ('7', '203', '六人间');
INSERT INTO `宿舍` VALUES ('7', '301', '六人间');
INSERT INTO `宿舍` VALUES ('7', '302', '六人间');
INSERT INTO `宿舍` VALUES ('7', '303', '六人间');
INSERT INTO `宿舍` VALUES ('7', '401', '六人间');
INSERT INTO `宿舍` VALUES ('7', '402', '六人间');
INSERT INTO `宿舍` VALUES ('7', '403', '六人间');
INSERT INTO `宿舍` VALUES ('7', '501', '六人间');
INSERT INTO `宿舍` VALUES ('7', '502', '六人间');
INSERT INTO `宿舍` VALUES ('7', '503', '六人间');
INSERT INTO `宿舍` VALUES ('8', '101', '四人间');
INSERT INTO `宿舍` VALUES ('8', '102', '四人间');
INSERT INTO `宿舍` VALUES ('8', '103', '四人间');
INSERT INTO `宿舍` VALUES ('8', '201', '四人间');
INSERT INTO `宿舍` VALUES ('8', '202', '四人间');
INSERT INTO `宿舍` VALUES ('8', '203', '四人间');
INSERT INTO `宿舍` VALUES ('8', '301', '四人间');
INSERT INTO `宿舍` VALUES ('8', '302', '四人间');
INSERT INTO `宿舍` VALUES ('8', '303', '四人间');
INSERT INTO `宿舍` VALUES ('8', '401', '四人间');
INSERT INTO `宿舍` VALUES ('8', '402', '四人间');
INSERT INTO `宿舍` VALUES ('8', '403', '四人间');
INSERT INTO `宿舍` VALUES ('8', '501', '四人间');
INSERT INTO `宿舍` VALUES ('8', '502', '四人间');
INSERT INTO `宿舍` VALUES ('8', '503', '四人间');

-- ----------------------------
-- Table structure for 宿舍管理员
-- ----------------------------
DROP TABLE IF EXISTS `宿舍管理员`;
CREATE TABLE `宿舍管理员`  (
  `编号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `性别` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `管理楼号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系方式` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `备注` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `密码` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`编号`) USING BTREE,
  INDEX `管理楼号`(`管理楼号`) USING BTREE,
  CONSTRAINT `宿舍管理员_ibfk_1` FOREIGN KEY (`管理楼号`) REFERENCES `楼栋` (`楼号`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 宿舍管理员
-- ----------------------------
INSERT INTO `宿舍管理员` VALUES ('admin-1', '张凯', '男', '1', '17855674273', '无', 'qyf01218');
INSERT INTO `宿舍管理员` VALUES ('admin-2', '钱玉飞', '男', '2', '17289765322', '无', '123456');
INSERT INTO `宿舍管理员` VALUES ('admin-3', '李四', '男', '3', '18956347988', '无', '123456');
INSERT INTO `宿舍管理员` VALUES ('admin-4', '王五', '男', '4', '16732547866', '无', '123456');
INSERT INTO `宿舍管理员` VALUES ('admin-5', '赵六', '男', '5', '17890346532', '无', '123456');
INSERT INTO `宿舍管理员` VALUES ('admin-6', '陈坤', '男', '6', '16754232321', '无', '123456');
INSERT INTO `宿舍管理员` VALUES ('admin-7', '赵构', '男', '7', '16754907655', '无', '123456');
INSERT INTO `宿舍管理员` VALUES ('admin-8', '李丽', '女', '8', '15205677517', '无', 'qyf01218');

-- ----------------------------
-- Table structure for 宿舍编号
-- ----------------------------
DROP TABLE IF EXISTS `宿舍编号`;
CREATE TABLE `宿舍编号`  (
  `宿舍号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`宿舍号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 宿舍编号
-- ----------------------------
INSERT INTO `宿舍编号` VALUES ('101');
INSERT INTO `宿舍编号` VALUES ('102');
INSERT INTO `宿舍编号` VALUES ('103');
INSERT INTO `宿舍编号` VALUES ('104');
INSERT INTO `宿舍编号` VALUES ('105');
INSERT INTO `宿舍编号` VALUES ('106');
INSERT INTO `宿舍编号` VALUES ('107');
INSERT INTO `宿舍编号` VALUES ('108');
INSERT INTO `宿舍编号` VALUES ('201');
INSERT INTO `宿舍编号` VALUES ('202');
INSERT INTO `宿舍编号` VALUES ('203');
INSERT INTO `宿舍编号` VALUES ('204');
INSERT INTO `宿舍编号` VALUES ('205');
INSERT INTO `宿舍编号` VALUES ('206');
INSERT INTO `宿舍编号` VALUES ('207');
INSERT INTO `宿舍编号` VALUES ('208');
INSERT INTO `宿舍编号` VALUES ('301');
INSERT INTO `宿舍编号` VALUES ('302');
INSERT INTO `宿舍编号` VALUES ('303');
INSERT INTO `宿舍编号` VALUES ('304');
INSERT INTO `宿舍编号` VALUES ('305');
INSERT INTO `宿舍编号` VALUES ('306');
INSERT INTO `宿舍编号` VALUES ('307');
INSERT INTO `宿舍编号` VALUES ('308');
INSERT INTO `宿舍编号` VALUES ('401');
INSERT INTO `宿舍编号` VALUES ('402');
INSERT INTO `宿舍编号` VALUES ('403');
INSERT INTO `宿舍编号` VALUES ('404');
INSERT INTO `宿舍编号` VALUES ('405');
INSERT INTO `宿舍编号` VALUES ('406');
INSERT INTO `宿舍编号` VALUES ('407');
INSERT INTO `宿舍编号` VALUES ('408');
INSERT INTO `宿舍编号` VALUES ('501');
INSERT INTO `宿舍编号` VALUES ('502');
INSERT INTO `宿舍编号` VALUES ('503');
INSERT INTO `宿舍编号` VALUES ('504');
INSERT INTO `宿舍编号` VALUES ('505');
INSERT INTO `宿舍编号` VALUES ('506');
INSERT INTO `宿舍编号` VALUES ('507');
INSERT INTO `宿舍编号` VALUES ('508');

-- ----------------------------
-- Table structure for 来访信息
-- ----------------------------
DROP TABLE IF EXISTS `来访信息`;
CREATE TABLE `来访信息`  (
  `编号` bigint(255) NOT NULL AUTO_INCREMENT,
  `楼号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `宿舍号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `来访日期` date NULL DEFAULT NULL,
  `来访人姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `来访目的` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `与学生关系` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `身份证号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系电话` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`编号`) USING BTREE,
  INDEX `楼号`(`楼号`) USING BTREE,
  INDEX `宿舍号`(`宿舍号`) USING BTREE,
  CONSTRAINT `来访信息_ibfk_1` FOREIGN KEY (`楼号`) REFERENCES `楼栋` (`楼号`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `来访信息_ibfk_2` FOREIGN KEY (`宿舍号`) REFERENCES `宿舍编号` (`宿舍号`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 来访信息
-- ----------------------------
INSERT INTO `来访信息` VALUES (1, '8', '101', '2023-05-09', '张胜男', '探亲', '母女', '341621197012234152', '18856788967');
INSERT INTO `来访信息` VALUES (2, '8', '301', '2023-05-08', '李丽', '探亲', '母女', '341621198009081265', '15605654221');
INSERT INTO `来访信息` VALUES (3, '1', '101', '2023-05-09', '李军', '维修', '无', '341621197002205674', '17856789087');
INSERT INTO `来访信息` VALUES (4, '1', '301', '2023-05-30', '王二', '探亲', '父子', '341621197502205671', '15205677751');
INSERT INTO `来访信息` VALUES (5, '1', '402', '2023-04-09', '李思源', '探亲', '父子', '341621198709086675', '13856780908');
INSERT INTO `来访信息` VALUES (6, '8', '503', '2023-06-07', '王二小', '探亲', '母女', '341621200102204136', '16754230907');

-- ----------------------------
-- Table structure for 楼栋
-- ----------------------------
DROP TABLE IF EXISTS `楼栋`;
CREATE TABLE `楼栋`  (
  `楼号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`楼号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 楼栋
-- ----------------------------
INSERT INTO `楼栋` VALUES ('1');
INSERT INTO `楼栋` VALUES ('10');
INSERT INTO `楼栋` VALUES ('2');
INSERT INTO `楼栋` VALUES ('3');
INSERT INTO `楼栋` VALUES ('4');
INSERT INTO `楼栋` VALUES ('5');
INSERT INTO `楼栋` VALUES ('6');
INSERT INTO `楼栋` VALUES ('7');
INSERT INTO `楼栋` VALUES ('8');
INSERT INTO `楼栋` VALUES ('9');

-- ----------------------------
-- Table structure for 系统管理员
-- ----------------------------
DROP TABLE IF EXISTS `系统管理员`;
CREATE TABLE `系统管理员`  (
  `编号` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `性别` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `备注` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `密码` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`编号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 系统管理员
-- ----------------------------
INSERT INTO `系统管理员` VALUES ('admin', '钱玉飞', '男', '无', 'qyf01218');

SET FOREIGN_KEY_CHECKS = 1;
