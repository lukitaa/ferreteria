--
-- Database: `ferreteria`
--

-- Drop obsolete database
DROP DATABASE IF EXISTS `ferreteria`;

-- Create new schema
CREATE DATABASE IF NOT EXISTS `ferreteria` DEFAULT CHARACTER SET=utf8;

-- Load the database
use `ferreteria`;


-- DDL


CREATE TABLE IF NOT EXISTS `users` (
  `IdUser` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL UNIQUE,
  `Password` char(255) NOT NULL,
  `Admin` bool NOT NULL DEFAULT FALSE,
  PRIMARY KEY (`IdUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


CREATE TABLE IF NOT EXISTS `products` (
    `IdProduct` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `Product` varchar(50) NOT NULL UNIQUE,
	`Price` INT UNSIGNED NOT NULL,
	`Stock` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`IdProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


CREATE TABLE IF NOT EXISTS `purchases` (
  `IdPurchase` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  -- `FechaIngreso` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IdUser` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`IdPurchase`),
  FOREIGN KEY (`IdUser`)
    REFERENCES users(`IdUser`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


CREATE TABLE IF NOT EXISTS `details` (
  `Amount` INT UNSIGNED NOT NULL,
  `Price` INT UNSIGNED NOT NULL,
  `IdProduct` INT UNSIGNED NOT NULL,
  `IdPurchase` INT UNSIGNED NOT NULL,
  FOREIGN KEY (`IdProduct`)
    REFERENCES products(`IdProduct`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (`IdPurchase`)
    REFERENCES purchases(`IdPurchase`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;