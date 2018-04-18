SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `java2` DEFAULT CHARACTER SET utf8 ;
USE `java2` ;

DROP TABLE IF EXISTS `shopping_lists` ;
DROP TABLE IF EXISTS `products` ;
DROP TABLE IF EXISTS `users` ;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS `products` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(32) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

CREATE TABLE IF NOT EXISTS `shopping_lists` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `user_id` BIGINT NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

ALTER TABLE `shopping_lists`
ADD CONSTRAINT `fk_shopping_lists_user_id`
FOREIGN KEY (`user_id`) REFERENCES `users`(`id`);

ALTER TABLE `shopping_lists`
ADD INDEX `ix_shopping_lists_user_id`(`user_id`);

ALTER TABLE `shopping_lists`
ADD UNIQUE INDEX `ix_shopping_lists_user_id_title`(`user_id`, `title`);


CREATE TABLE IF NOT EXISTS `shopping_list_items` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `shopping_list_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `quantity` INT NOT NULL,
  `created_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

ALTER TABLE `shopping_list_items`
ADD CONSTRAINT `fk_shopping_list_items_shopping_list_id`
FOREIGN KEY (`shopping_list_id`) REFERENCES `shopping_lists`(`id`);

ALTER TABLE `shopping_list_items`
ADD INDEX `ix_shopping_list_items_shopping_list_id`(`shopping_list_id`);

ALTER TABLE `shopping_list_items`
ADD CONSTRAINT `fk_shopping_list_items_product_id`
FOREIGN KEY (`product_id`) REFERENCES `products`(`id`);

ALTER TABLE `shopping_list_items`
ADD INDEX `ix_shopping_list_items_product_id`(`product_id`);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;