drop table if exists `COMMON_MESSAGE`;
CREATE TABLE `COMMON_MESSAGE` (
  `MESSAGE_ID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `MESSAGE_NAME` VARCHAR(100) NOT NULL,
  `MESSAGE_CONTENT` VARCHAR(100) NOT NULL,
  `MESSAGE_STATUS` VARCHAR(1) NOT NULL,
  `MESSAGE_CREATE_DATE_TIME` TIMESTAMP NOT NULL,
  PRIMARY KEY (`MESSAGE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
