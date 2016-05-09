-- MySQL Script generated by MySQL Workbench
-- Tue May  3 20:26:41 2016
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema crescent
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema crescent
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crescent` ;
USE `crescent` ;

DROP TABLE IF EXISTS `crescent`.`client`;
DROP TABLE IF EXISTS `crescent`.`buddy`;
DROP TABLE IF EXISTS `crescent`.`user`;
-- -----------------------------------------------------
-- Table `crescent`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crescent`.`client` (
  `_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `userId` INT NOT NULL,
  `age` INT NULL,
  `gender` TINYTEXT NULL,
  PRIMARY KEY (`_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crescent`.`buddy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crescent`.`buddy` (
  `_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `userId` INT NOT NULL,
  `food` INT NULL DEFAULT 1,
  `navigate` INT NULL DEFAULT 1,
  `beauty` INT NULL DEFAULT 1,
  `play` INT NULL DEFAULT 1,
  `shopping` INT NULL DEFAULT 1,
  `medical` INT NULL DEFAULT 1,
  PRIMARY KEY (`_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `crescent`.`user`
-- ----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crescent`.`user`(
	`_id` INT NOT NULL AUTO_INCREMENT,
	`email` TEXT NOT NULL, 
	`password` TEXT NOT NULL,
	`userType` INT NOT NULL,
	PRIMARY KEY (`_id`))
ENGINE = InnoDB;
 






SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

