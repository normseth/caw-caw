create database IF NOT EXISTS stocks;

drop table IF EXISTS `stocks`.`stock`;

CREATE TABLE  `stocks`.`stock` (
  `STOCK_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` VARCHAR(10) NOT NULL,
  `STOCK_NAME` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- This isnt about stocks at all, just a place to keep data.
INSERT INTO `stocks`.`stock` (STOCK_CODE, STOCK_NAME) VALUES ('ABBA', 'American Bubble Buster Asscn.');
INSERT INTO `stocks`.`stock` (STOCK_CODE, STOCK_NAME) VALUES ('SLAP', 'Small Light Aircraft Project.');

-- This is our webapp user. Needs to be in hibernate/mysql configuration
GRANT ALL ON `stocks`.* TO 'monty'@'localhost' IDENTIFIED BY 'standalone';
GRANT ALL ON `stocks`.* TO 'monty'@'%' IDENTIFIED BY 'standalone';
