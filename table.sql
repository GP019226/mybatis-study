CREATE TABLE `merchant` (
  `mid` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `business_scope` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `mybatis`.`merchant` ( `name`, `business_scope`)
VALUES
  ('华为', '1,2,4') ;