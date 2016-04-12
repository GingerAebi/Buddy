DROP TABLE USERS;
CREATE TABLE IF NOT EXISTS `crescent`.`client` (
  `_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `userId` INT NULL,
  `age` INT NULL,
  `gender` TINYTEXT NULL,
  PRIMARY KEY (`_id`))
ENGINE = InnoDB;


DROP TABLE favorite;
CREATE TABLE IF NOT EXISTS `crescent`.`buddy` (
  `_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `userId` INT NOT NULL,
  `food` INT NULL,
  `navigate` INT NULL,
  `beauty` INT NULL,
  `play` INT NULL,
  `shopping` INT NULL,
  `medical` INT NULL,
  `culture` INT NULL,
  `k_wave` INT NULL,
  PRIMARY KEY (`_id`))
ENGINE = InnoDB;