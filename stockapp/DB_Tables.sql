CREATE DATABASE  IF NOT EXISTS `hb_student_stock_exchange`;
USE `hb_student_stock_exchange`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `owner_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `portfolios`
--

DROP TABLE IF EXISTS `portfolios`;

CREATE TABLE `portfolios` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticker` varchar(45) DEFAULT NULL,
  `amount` int(11)  DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Table structure for table `account_balances`
--

DROP TABLE IF EXISTS `account_balances`;

CREATE TABLE `account_balances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11)  DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `balanceAvailable` boolean NOT NULL DEFAULT 1,
  `fk_account_id_account_balances` int(11)  DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (fk_account_id_account_balances) REFERENCES portfolios (account_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticker` varchar(45) DEFAULT NULL,
  `amount` int(11)  DEFAULT NULL,
  `typeOfOrder` varchar(45) DEFAULT NULL,
  `limit` int(11)  DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `timestamp` DATE,
  `expiration` DATE,
  `fk_account_id_orders` int(11)  DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (fk_account_id_orders) REFERENCES portfolios (account_id) ON DELETE NO ACTION ON UPDATE NO ACTION  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `tickers`
--

DROP TABLE IF EXISTS `tickers`;

CREATE TABLE `tickers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticker_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `actualPrice` DECIMAL(10,2) DEFAULT NULL,
  `totalAmountStock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table structure for table `priceHistory`
--

DROP TABLE IF EXISTS `priceHistory`;

CREATE TABLE `priceHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeStamp` TIMESTAMP DEFAULT NULL,
  `tickerName` varchar(45) DEFAULT NULL,
  `Price` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

