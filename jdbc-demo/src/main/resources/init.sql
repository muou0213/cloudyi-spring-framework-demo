CREATE DATABASE spring_demo;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `accountName` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletestatus` int(1) DEFAULT '0' COMMENT '逻辑删除状态0:存在1:删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


INSERT INTO `user` VALUES ('1', '张三', 'simple', '三', '2015-05-17 22:23:15', '0');
INSERT INTO `user` VALUES ('2', '李四', 'mark',  '四', '2015-05-23 17:39:37', '0');
INSERT INTO `user` VALUES ('3', '王五', 'admin',  '五', '2015-05-23 17:39:39', '0');
