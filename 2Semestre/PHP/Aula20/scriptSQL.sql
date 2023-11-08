CREATE DATABASE teste;
USE teste;

CREATE TABLE `teste`.`login` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(200) NOT NULL,
  `pass` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`userid`));

INSERT INTO `login` (`userid`,`user`,`pass`) VALUES (NULL,'joao', md5('123'));
INSERT INTO `login` (`userid`,`user`,`pass`) VALUES (NULL,'maria', md5('123456'));