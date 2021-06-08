-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema website_sach_cu
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema website_sach_cu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `website_sach_cu` DEFAULT CHARACTER SET utf8 ;
USE `website_sach_cu` ;

-- -----------------------------------------------------
-- Table `website_sach_cu`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website_sach_cu`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `website_sach_cu`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website_sach_cu`.`book` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NULL DEFAULT NULL,
  `book_picture` VARCHAR(45) NULL DEFAULT NULL,
  `book_year` VARCHAR(45) NULL DEFAULT NULL,
  `book_description` VARCHAR(45) NULL DEFAULT NULL,
  `book_author` VARCHAR(45) NULL DEFAULT NULL,
  `book_price` VARCHAR(45) NULL DEFAULT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`book_id`, `category_id`),
  UNIQUE INDEX `book_id_UNIQUE` (`book_id` ASC) VISIBLE,
  INDEX `fk_book_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_book_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `website_sach_cu`.`category` (`category_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `website_sach_cu`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website_sach_cu`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_phone` VARCHAR(45) NULL DEFAULT NULL,
  `user_email` VARCHAR(45) NULL DEFAULT NULL,
  `user_password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `website_sach_cu`.`user_collection`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website_sach_cu`.`user_collection` (
  `user_collection_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  `user_collection_time` DATETIME NOT NULL,
  PRIMARY KEY (`user_collection_id`),
  UNIQUE INDEX `user_collection_id_UNIQUE` (`user_collection_id` ASC) VISIBLE,
  INDEX `fk_user_collection_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_user_collection_book1_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_collection_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `website_sach_cu`.`book` (`book_id`),
  CONSTRAINT `fk_user_collection_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `website_sach_cu`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `website_sach_cu`.`user_posted`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website_sach_cu`.`user_posted` (
  `user_posted_id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `posted_time` DATETIME NOT NULL,
  PRIMARY KEY (`user_posted_id`),
  UNIQUE INDEX `user_book_id_UNIQUE` (`user_posted_id` ASC) VISIBLE,
  INDEX `fk_user_book_book_idx` (`book_id` ASC) VISIBLE,
  INDEX `fk_user_book_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_book_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `website_sach_cu`.`book` (`book_id`),
  CONSTRAINT `fk_user_book_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `website_sach_cu`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
