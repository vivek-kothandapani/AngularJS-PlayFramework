CREATE DATABASE  IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `products`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: products
-- ------------------------------------------------------
-- Server version	5.6.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `play_evolutions`
--

DROP TABLE IF EXISTS `play_evolutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text COLLATE utf8_unicode_ci,
  `revert_script` text COLLATE utf8_unicode_ci,
  `state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_problem` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_evolutions`
--

LOCK TABLES `play_evolutions` WRITE;
/*!40000 ALTER TABLE `play_evolutions` DISABLE KEYS */;
INSERT INTO `play_evolutions` VALUES (1,'8c767f41f3cae80c8359d1118d29c0aede8093a9','2015-02-21 08:35:23','create table skus (\nid                        varchar(255) not null,\nname                      varchar(255),\nstatus                    varchar(255),\nprice                     varchar(255),\ntype                      varchar(255),\nfeatures                  varchar(255),\ncreated_date              varchar(255),\nexpiry_date               varchar(255),\nconstraint pk_skus primary key (id))\n;','SET FOREIGN_KEY_CHECKS=0;\n\ndrop table skus;\n\nSET FOREIGN_KEY_CHECKS=1;','applied','Table \'skus\' already exists [ERROR:1050, SQLSTATE:42S01]');
/*!40000 ALTER TABLE `play_evolutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skus`
--

DROP TABLE IF EXISTS `skus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skus` (
  `id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `features` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `expiry_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skus`
--

LOCK TABLES `skus` WRITE;
/*!40000 ALTER TABLE `skus` DISABLE KEYS */;
INSERT INTO `skus` VALUES ('A00001','Basic','ACTIVE','175','checkout','For Business with 30 or less monthly transaction','2015-02-21','2016-02-28'),('A00002','Small','ACTIVE','250','checkout','For Business with 60 or less monthly transaction','2015-02-21','2016-02-28'),('A00003','Mid-Size','ACTIVE','375','checkout','For Business with 100 or less monthly transaction','2015-03-09','2016-02-28'),('A00004','Enterprise','ACTIVE','0','call','For Business with 100 or more monthly transaction. Please call 1-800-123-4567','2015-03-09','2016-02-28');
/*!40000 ALTER TABLE `skus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'products'
--

--
-- Dumping routines for database 'products'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-03  1:54:35
CREATE DATABASE  IF NOT EXISTS `cxprofile` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cxprofile`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cxprofile
-- ------------------------------------------------------
-- Server version	5.6.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_info`
--

DROP TABLE IF EXISTS `account_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_info` (
  `account_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address_id` int(10) unsigned DEFAULT NULL,
  `legal_info_id` int(10) unsigned DEFAULT NULL,
  `entitlement_id` int(10) unsigned DEFAULT NULL,
  `report_info_id` int(10) unsigned DEFAULT NULL,
  `profile_info_id` int(10) unsigned DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_info`
--

LOCK TABLES `account_info` WRITE;
/*!40000 ALTER TABLE `account_info` DISABLE KEYS */;
INSERT INTO `account_info` VALUES (1,'yoursite Technology Inc,','yoursite','password123',NULL,NULL,NULL,NULL,NULL,'CLIENT',NULL,'NEW'),(1001,'Test Inc,','test','test',NULL,NULL,NULL,NULL,NULL,'CLIENT',NULL,'NEW'),(1002,'ABC Corporatio,','David','david',NULL,NULL,NULL,NULL,NULL,'CLIENT',NULL,'NEW');
/*!40000 ALTER TABLE `account_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) NOT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `state_provice` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `postal_code` varchar(255) NOT NULL,
  `phone1` varchar(255) NOT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `phone3` varchar(255) DEFAULT NULL,
  `email1` varchar(255) NOT NULL,
  `email2` varchar(255) DEFAULT NULL,
  `email3` varchar(255) DEFAULT NULL,
  `contact_person_name1` varchar(255) NOT NULL,
  `contact_person_name2` varchar(255) DEFAULT NULL,
  `contact_person_name3` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entitlement_info`
--

DROP TABLE IF EXISTS `entitlement_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entitlement_info` (
  `entitlement_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `entitlement_list` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`entitlement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entitlement_info`
--

LOCK TABLES `entitlement_info` WRITE;
/*!40000 ALTER TABLE `entitlement_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `entitlement_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legal_info`
--

DROP TABLE IF EXISTS `legal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legal_info` (
  `legal_info_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `legal_address_id` int(10) unsigned DEFAULT NULL,
  `terms_agreed` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`legal_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legal_info`
--

LOCK TABLES `legal_info` WRITE;
/*!40000 ALTER TABLE `legal_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `legal_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `play_evolutions`
--

DROP TABLE IF EXISTS `play_evolutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play_evolutions`
--

LOCK TABLES `play_evolutions` WRITE;
/*!40000 ALTER TABLE `play_evolutions` DISABLE KEYS */;
INSERT INTO `play_evolutions` VALUES (1,'c5dce315708785324950d1c214fb81c2fd29c5c4','2015-03-28 19:04:48','create table account_info (\naccount_id                varchar(255) not null,\ncompany_name              varchar(255),\nusername                  varchar(255),\npassword                  varchar(255),\naddress_id                varchar(255),\nlegal_info_id             varchar(255),\nentitlement_id            varchar(255),\nreport_info_id            varchar(255),\nstatus                    varchar(255),\nrole                      varchar(255),\nlast_login                varchar(255),\nconstraint pk_account_info primary key (account_id))\n;','SET FOREIGN_KEY_CHECKS=0;\n\ndrop table account_info;\n\nSET FOREIGN_KEY_CHECKS=1;','applied','Table \'account_info\' already exists [ERROR:1050, SQLSTATE:42S01]');
/*!40000 ALTER TABLE `play_evolutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_info`
--

DROP TABLE IF EXISTS `profile_info`;

-- -----------------------------------------------------
-- Table `cxprofile`.`profile_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cxprofile`.`profile_info` (
  `profile_info_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cra_bus_number` VARCHAR(255) NULL DEFAULT NULL,
  `cra_bus_rt` VARCHAR(255) NULL DEFAULT NULL,
  `qst_reg_number` VARCHAR(255) NULL DEFAULT NULL,
  `cra_payroll_acnt` VARCHAR(255) NULL DEFAULT NULL,
  `cra_payroll_rp` VARCHAR(255) NULL DEFAULT NULL,
  `mrq_payroll_acnt` VARCHAR(255) NULL DEFAULT NULL,
  `your_industry` VARCHAR(255) NULL DEFAULT NULL,
  `company_type` VARCHAR(255) NULL DEFAULT NULL,
  `what_we_sell` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`profile_info_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;
--
-- Dumping data for table `profile_info`
--

LOCK TABLES `profile_info` WRITE;
/*!40000 ALTER TABLE `profile_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_info`
--

DROP TABLE IF EXISTS `report_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report_info` (
  `report_info_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fiscal_mnth_fiscal_yr` varchar(255) DEFAULT NULL,
  `fiscal_mnth_tx_yr` varchar(255) DEFAULT NULL,
  `income_tax_form` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`report_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_info`
--

LOCK TABLES `report_info` WRITE;
/*!40000 ALTER TABLE `report_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `report_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cxprofile'
--

--
-- Dumping routines for database 'cxprofile'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-03  1:54:35


/* Vivek - Testuser Password update */
/* Date : Apr 6 2015 */
/* username : David , Password : david */
update  cxprofile.account_info set password="24b8a029bb75c60e036f982d5018e7828c905081c1c795dfe1acc818aae9a0b7" where account_id='1002'

/* Apr 7 */
/* accounting schema */

create schema accounting;

CREATE TABLE accounting.customer
(
 customer_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 account_id int UNSIGNED NOT NULL,
 account_username varchar(255) NOT NULL,
 firstname varchar(255),
 lastname varchar(255),
 title varchar(10),
 display_name varchar(255) NOT NULL,
 company_name varchar(255),
 email varchar(255),
 phone varchar(20),
 PRIMARY KEY (customer_id)
);

/*Test data */
insert into accounting.customer (`display_name`,`account_id`) values ('vivek',1002);
UPDATE `accounting`.`customer` SET `account_username`='David' WHERE `customer_id`='1';

/* Apr 10 */

INSERT INTO cxprofile.account_info (`account_id`,`company_name`,`username`,`password`,`address_id`,`legal_info_id`,`entitlement_id`,`report_info_id`,`profile_info_id`,`role`,`last_login`,`status`) VALUES (1003,'yoursite.com Employee','sam','c2198da97bb9156637873752a03d156561689ec19a171b15a3be5af4437c5898',NULL,NULL,NULL,NULL,NULL,'Bsuper',NULL,'EMPLOYEE');
INSERT INTO cxprofile.account_info (`account_id`,`company_name`,`username`,`password`,`address_id`,`legal_info_id`,`entitlement_id`,`report_info_id`,`profile_info_id`,`role`,`last_login`,`status`) VALUES (1004,'yoursite.com Employee','chris','c91e70b2fbbc9a26bd62ab03440c2c42deae170e6f3836e5d0d0656dcdc57c03',NULL,NULL,NULL,NULL,NULL,'BSUPER',NULL,'SUPER');
INSERT INTO cxprofile.account_info (`account_id`,`company_name`,`username`,`password`,`address_id`,`legal_info_id`,`entitlement_id`,`report_info_id`,`profile_info_id`,`role`,`last_login`,`status`) VALUES (1005,'yoursite.com Employee','vivek','2030d51340f9b20512cc42815eacb1540f88caf8eae7c8f2a84d6d802bf94d22',NULL,NULL,NULL,NULL,NULL,'ROOT',NULL,'ROOT');
INSERT INTO cxprofile.account_info (`account_id`,`company_name`,`username`,`password`,`address_id`,`legal_info_id`,`entitlement_id`,`report_info_id`,`profile_info_id`,`role`,`last_login`,`status`) VALUES (1006,'yoursite.com Employee','joel','f83f1a1ce79790fc0264fb9558e611651dd09c31cd3d3755e8eeaa4d107018a0',NULL,NULL,NULL,NULL,NULL,'BADMIN',NULL,'ADMIN');


UPDATE `accounting`.`customer` SET `firstname`='Vivekanandhan', `lastname`='Kothandapani', `title`='Mr', `company_name`='yoursite', `email`='keviveck@gmail.com', `phone`='2896549944' WHERE `customer_id`='1';

INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('2', '1002', 'David', 'John', 'Green', 'Mr', 'johng', 'NERDS Cmp');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('3', '1002', 'David', 'Ram', 'Guessname', 'Mr', 'ramg', 'NERDS Cmp');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('4', '1002', 'David', 'samosam', 'ss', 'Mr', 'samos', 'NERDS Cmp');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('5', '1002', 'David', 'Raj', 'Green', 'Mr', 'rajg', 'Yes We Can Cmp');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('6', '1002', 'David', 'Martin', 'D', 'Mr', 'martind', 'We Are Crazy Dreamers');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('7', '1002', 'David', 'Kevin', 'Xu', 'Mr', 'kevinxu', 'RBC Robbers');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('8', '1002', 'David', 'Kent', 'Ho', 'Mr', 'kentho', 'Bell Rogers Cmp');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('9', '1002', 'David', 'Smith', 'Will', 'Mr', 'wills', '122 Cmp');
INSERT INTO `accounting`.`customer` (`customer_id`, `account_id`, `account_username`, `firstname`, `lastname`, `title`, `display_name`, `company_name`) VALUES ('10', '1002', 'David', 'NewGuy', 'OldGuy', 'Mr', 'newguy', 'ABC Cmp');


/*April 14 */

CREATE TABLE accounting.file
(
 file_id bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 account_id int UNSIGNED NOT NULL,
 account_username varchar(255),
 accountant_id int UNSIGNED,
 filename varchar(255) not null,
 filetype varchar(20), 
 fileclass varchar(20),
 upload_year int UNSIGNED NOT NULL,
 upload_month int UNSIGNED NOT NULL,
 upload_day int UNSIGNED NOT NULL,
 upload_hour int UNSIGNED NOT NULL,
 upload_minute int UNSIGNED NOT NULL,
 upload_second  int UNSIGNED NOT NULL,
 PRIMARY KEY (file_id)
);

CREATE TABLE accounting.transaction
(
 transaction_id bigint UNSIGNED NOT NULL AUTO_INCREMENT,
 file_id bigint UNSIGNED,
 account_id int UNSIGNED NOT NULL,
 account_username varchar(255),
 accountant_id int UNSIGNED,
 tx_category_id int UNSIGNED,
 tx_class_id int UNSIGNED,
 name varchar(255),
 description varchar(255),
 tx_type varchar(20),
 tx_mode varchar(20),
 tx_category varchar(20),
 tx_class varchar(20),
 tx_set varchar(20),
 quantity int UNSIGNED,
 rate numeric(15,2),
 tax numeric(15,2), 
 amount numeric(15,2),
 balance_due numeric(15,2),
 tax_type varchar(20),
 discount_percent tinyint UNSIGNED,
 status varchar(20),
 remarks varchar(255),
 PRIMARY KEY (transaction_id)
);


-- -----------------------------------------------------
-- Table `cxprofile`.`company_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cxprofile`.`company_info` (
  `company_name` VARCHAR(500) NOT NULL,
  `company_address1` VARCHAR(500) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `postal_code` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `province` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `account_id` INT(10) UNSIGNED NOT NULL,
  `company_address2` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE INDEX `account_id_UNIQUE` (`account_id` ASC),
  INDEX `fk_company_info_1_idx` (`account_id` ASC),
  CONSTRAINT `fk_company_info_1`
    FOREIGN KEY (`account_id`)
    REFERENCES `cxprofile`.`account_info` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


/* April 21 */

ALTER TABLE accounting.transaction
add column  filename varchar(255);

ALTER TABLE cxprofile.entitlement_info
ADD COLUMN  sku varchar(20);

/* April 26 */
alter table accounting.transaction
ADD COLUMN tx_date datetime,
ADD column payment_date datetime,
add column last_modified_date datetime,
add column reference_id VARCHAR(255),
add column entity_id int UNSIGNED,
add column account_type_id int UNSIGNED,
add column account_cat_id int UNSIGNED,
add column account_sub_cat_id int UNSIGNED,
add column item_description VARCHAR(255);

/* April 29 */

alter table cxprofile.account_info
ADD COLUMN `first_name` VARCHAR(255) NULL DEFAULT NULL,
ADD COLUMN  `last_name` VARCHAR(45) NULL DEFAULT NULL,
ADD COLUMN  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
ADD COLUMN  `email` VARCHAR(45) NULL DEFAULT NULL,
ADD COLUMN  `reason` VARCHAR(45) NULL DEFAULT NULL;


/* May 1 */

CREATE TABLE accounting.code_group
(
 group_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 code varchar(255),
 name varchar(255),
 remarks varchar(255),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (group_id)
);

CREATE TABLE accounting.code_sub_group
(
 sub_group_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 group_id int UNSIGNED,
 code varchar(255),
 name varchar(255),
 remarks varchar(255),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (sub_group_id)
);

CREATE TABLE accounting.code_account_type
(
 account_type_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 sub_group_id int UNSIGNED,
 code varchar(255),
 name varchar(255),
 remarks varchar(255),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (account_type_id)
);

CREATE TABLE accounting.code
(
 code_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 account_type_id int UNSIGNED,
 code varchar(255),
 name varchar(255),
 report_ref_id int UNSIGNED,
 remarks varchar(255),
 country varchar(10),
 region varchar(10),
 status varchar(10),
 visibility varchar(10),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (code_id)
);

CREATE TABLE accounting.client_code
(
 account_id int UNSIGNED,
 code_id int UNSIGNED,
 remarks varchar(255),
 status varchar(10),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 mofified_by int UNSIGNED
);


CREATE TABLE accounting.vendor
(
 vendor_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 account_id int UNSIGNED NOT NULL,
 account_username varchar(255),
 code_id int UNSIGNED,
 firstname varchar(255),
 lastname varchar(255),
 title varchar(10),
 display_name varchar(255) NOT NULL,
 company_name varchar(255),
 email varchar(255),
 phone varchar(20),
 remarks varchar(255),
 status varchar(10),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (vendor_id)
);

drop table accounting.customer;

CREATE TABLE accounting.customer
(
 customer_id int UNSIGNED NOT NULL AUTO_INCREMENT,
 account_id int UNSIGNED NOT NULL,
 account_username varchar(255),
 code_id int UNSIGNED,
 firstname varchar(255),
 lastname varchar(255),
 title varchar(10),
 display_name varchar(255) NOT NULL,
 company_name varchar(255),
 email varchar(255),
 phone varchar(20),
 remarks varchar(255),
 status varchar(10),
 created_date datetime,
 created_by int UNSIGNED,
 modified_date datetime,
 modified_by int UNSIGNED,
 PRIMARY KEY (customer_id)
);


/* May 2 */
alter table `accounting`.`client_code`
ADD CONSTRAINT `code_id_fk` FOREIGN KEY (`code_id`)
REFERENCES `accounting`.`code` (`code_id`);

alter table `accounting`.`code`
ADD CONSTRAINT `account_type_id_fk` FOREIGN KEY (`account_type_id`)
REFERENCES `accounting`.`code_account_type` (`account_type_id`);

alter table `accounting`.`code_account_type`
ADD CONSTRAINT `sub_group_id_fk` FOREIGN KEY (`sub_group_id`)
REFERENCES `accounting`.`code_sub_group` (`sub_group_id`);

alter table `accounting`.`code_sub_group`
ADD CONSTRAINT `group_id_fk` FOREIGN KEY (`group_id`)
REFERENCES `accounting`.`code_group` (`group_id`);

alter table `accounting`.`client_code`
add column `client_code_id` int UNSIGNED NOT NULL AUTO_INCREMENT,
ADD CONSTRAINT PRIMARY KEY (`client_code_id`);

alter table `accounting`.`client_code`
drop column `mofified_by`,
ADD column `modified_by` int UNSIGNED;


/* May 3 */
alter table `accounting`.`code`
ADD column `sort_order` int UNSIGNED,
ADD column `drop_down` int UNSIGNED,
ADD column `type` varchar(10),
ADD column `category` varchar(10),
ADD column `set` varchar(10);


alter table `accounting`.`client_code`
ADD column `sort_order` int UNSIGNED;

/* Important!!! This script deletes all rows and reset auto increment initial value to 1*/
/* Code group entries  */
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE `accounting`.`code_group`; 
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE `accounting`.`code_group` AUTO_INCREMENT = 1;
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('1', 'Assets');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('2', 'Cost of Sales');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('3', 'Equity');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('4', 'Farming Expenses');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('5', 'Farming Revenue');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('6', 'Liabilities');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('7', 'Net non-farming income');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('8', 'Operating Expenses');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('9', 'Other Comprehensive Income');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('10', 'Retained Earnings');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('11', 'Revenue');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('12', 'Total expenses');
INSERT INTO `accounting`.`code_group` (`code`, `name`) VALUES ('13', 'Others');


/* Code sub group entries */
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE `accounting`.`code_sub_group`; 
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE `accounting`.`code_sub_group` AUTO_INCREMENT = 1;
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('1', '1', 'Capital Assets');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('1', '2', 'Current Assets');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('1', '3', 'Intangible Capital Asset');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('1', '4', 'Long-Term Assets');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('2', '1', 'Cost of Sales');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('3', '1', 'Equity');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('4', '1', 'Farming Expenses');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('5', '1', 'Farming Revenue');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('6', '1', 'Current Liabilities');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('6', '2', 'Long-Term Liabilities');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('7', '1', 'Net non-farming income');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('8', '1', 'Operating Expenses');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('9', '1', 'Other Comprehensive Income');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('10', '1', 'Retained Earnings');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('11', '1', 'Revenue');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('12', '1', 'Total expenses');
INSERT INTO `accounting`.`code_sub_group` (`group_id`,`code`, `name`) VALUES ('13', '1', 'Others');

/* Code Account Type entries */
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE `accounting`.`code_account_type`; 
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE `accounting`.`code_account_type` AUTO_INCREMENT = 1;
/** 1.Assets **/
/* 1.Capital Assets */	
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '1', 'Land');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '2', 'Depletable assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '3', 'Accumulated amortization of depletable assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '4', 'Buildings');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '5', 'Accumulated amortization of buildings');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '6', 'Machinery, equipment, furniture, and fixtures');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '7', 'Accumulated amortization of machinery, equipment Furniture & Fixtures');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '8', 'Other tangible capital assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '9', 'Accumulated amortization of other tangible');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '10', 'Total tangible capital assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('1', '11', 'Total accumulated amortization of tangible');

/*2.Current Assets */
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '1', 'Cash and Deposits');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '2', 'Accounts Receivable');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '3', 'Allowance for Doubtful Accounts');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '4', 'Inventories');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '5', 'Due from shareholder(s)/director(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '6', 'Due from member(s)/general partner(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '7', 'Investment in Joint Ventures');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '8', 'Investment From Joint Ventures');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '9', 'Due from/investment in related parties');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '10', 'Customer''s Liability under Acceptance');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '11', 'Other Current Assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('2', '12', 'Total Current Assets');

/*3.Intangible Capital Asset*/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('3', '1', 'Intangible assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('3', '2', 'Accumulated amortization of intangible assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('3', '3', 'Resource Rights');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('3', '4', 'Accumulated amortization of resource rights');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('3', '5', 'Total intangible capital assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('3', '6', 'Total accumulated amortization of intangible assets');

/*4.Long-Term Assets*/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '1', 'Due from shareholder(s)/director(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '2', 'Due from members');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '3', 'Investment in joint venture(s)/partnership(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '4', 'Due from member(s)/general partner(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '5', 'Due from joint venture(s)/partnership(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '6', 'Due from/investment in related parties');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '7', 'Investment in co-tenancy');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '8', 'Long-term investments');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '9', 'Long-term loans');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '10', 'Other long-term assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '11', 'Total long-term assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '12', 'Assets held in trust');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('4', '13', 'Total assets');


/** 2.Cost of Sales **/
/* 5.Cost of Sales */
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '1', 'Opening inventory');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '2', 'Purchases/cost of materials');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '3', 'Direct wages');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '4', 'Benefits on direct wages');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '5', 'Trades and sub-contracts');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '6', 'Production costs other than resource');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '7', 'Resource production costs');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '8', 'Crown charges');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '9', 'Other direct costs');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '10', 'Closing inventory');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '11', 'Cost of sales');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('5', '12', 'Gross profit/loss');


/**3.Equity**/
/**	6.Equity**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '1', 'Common shares');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '2', 'Preferred shares');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '3', 'Contributed and other surplus');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '4', 'Head office account');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '5', 'Accumulated other comprehensive income');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '6', 'General partners’ capital (cost of partnership');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '7', 'Retained earnings/deficit');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '8', 'Total shareholder equity');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '9', 'Total partners’ capital');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '10', 'Total liabilities and shareholder equity');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('6', '11', 'Total liabilities and partners’ capital'); 

/**4.Farming Expenses**/
/**	7.Farming Expenses**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '1', 'Crop expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '2', 'Livestock expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '3', 'General farm expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '4', 'Non-farming expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '5', 'Net inventory adjustment');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '6', 'Total farm expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '7', 'Net farm income');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('7', '8', 'Net income/loss before taxes and extraordinary');

/**5.Farming Revenue**/
/**	8.Farming Revenue**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '1', 'Grains and oilseeds');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '2', 'Other crop revenues');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '3', 'Livestock and animal products revenue');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '4', 'Other commodities');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '5', 'Program payment revenues');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '6', 'Other farm revenues/losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '7', 'Non-farming income');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('8', '8', 'Total farm revenue');
/**6.Liabilities**/
/**	9.Current Liabilities**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '1', 'Bank overdraft');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '2', 'Amounts payable and accrued liabilities');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '3', 'Taxes payable');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '4', 'Short-term debt');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '5', 'Deferred income');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '6', 'Due to shareholder(s)/director(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '7', 'Due to member(s)/general partner(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '8', 'Due to joint venture(s)/partnership(s)'); 
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '9', 'Due to related parties');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '10', 'Current portion of long-term liability');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '11', 'Bankers’ acceptances');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '12', 'Other current liabilities');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('9', '13', 'Total current liabilities');
/**	10.Long-Term Liabilities**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '1', 'Long-term debt');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '2', 'Deposit liabilities of financial institutions');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '3', 'Bonds and debentures');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '4', 'Deferred income');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '5', 'Future (deferred) income taxes');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '6', 'Due to shareholder(s)/director(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '7', 'Due to members');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '8', 'Due to joint venture(s)/partnership(s)');  
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '9', 'Due to member(s)/general partner(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '10', 'Due to related parties');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '11', 'Other long-term liabilities');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '12', 'Total long-term liabilities');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '13', 'Subordinated debt');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '14', 'Amounts held in trust');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('10', '15', 'Total liabilities');
/**7.Net non-farming income**/
/**	11.Net non-farming income**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('11', '1', 'Net non-farming income');
/**8.Operating Expenses**/
/**	12.Operating Expenses**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '1', 'Advertising and promotion');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '2', 'Amortization of intangible assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '3', 'Goodwill impairment loss');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '4', 'Bad debt expense');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '5', 'Loan losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '6', 'Employee benefits');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '7', 'Amortization of natural resource assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '8', 'Amortization of tangible assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '9', 'Insurance');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '10', 'Interest and bank charges');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '11', 'Interest paid (financial institutions)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '12', 'Business taxes, licences, and memberships');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '13', 'Nova Scotia tax on large corporations');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '14', 'Office expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '15', 'Professional fees');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '16', 'Rental');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '17', 'Other repairs and maintenance');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '18', 'Salaries and wages');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '19', 'Sub-contracts');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '20', 'Supplies');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '21', 'Computer-related expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '22', 'Property taxes');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '23', 'Travel expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '24', 'Utilities');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '25', 'Other expenses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('12', '26', 'Total operating expenses');
/**9.Other Comprehensive Income**/
/**	13.Other Comprehensive Income**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '1', 'Revaluation surplus');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '2', 'Defined benefit gains/losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '3', 'Foreign operation translation gains/losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '4', 'Equity instruments gains/losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '5', 'Cash flow hedge effective portion gains/losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '6', 'Income tax relating to components of other');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('13', '7', 'Miscellaneous other comprehensive income');
/**10.Retained Earnings**/
/**	14.Retained Earnings**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '1', 'Retained earnings/deficit – Start');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '2', 'Net income/loss');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '3', 'Capital contributed');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '4', 'Dividends declared');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '5', 'Prior period adjustments');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '6', 'Other items affecting retained earnings');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '7', 'Drawings'); 
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('14', '8', 'Retained earnings/deficit – End');
/**11.Revenue**/
/**	15.Revenue**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '1', 'Trade sales of goods and services');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '2', 'Sales of goods and services to related parties');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '3', 'Interdivisional sales');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '4', 'Sales from resource properties');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '5', 'Total sales of goods and services');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '6', 'Investment revenue');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '7', 'Interest income (financial institutions)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '8', 'Commission revenue');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '9', 'Rental revenue');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '10', 'Vehicle leasing');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '11', 'Fishing revenue');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '12', 'Realized gains/losses on disposal of assets');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '13', 'NPO amounts received');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '14', 'Other revenue');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('15', '15', 'Total revenue');
/**12.Total expenses**/
/**	16.Total expenses**/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('16', '1', 'Total expenses');
/**13.Others **/
/**	17.Others **/
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '1', 'Extraordinary item(s)');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '2', 'Legal settlements');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '3', 'Unrealized gains/losses');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '4', 'Unusual items');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '5', 'Current income taxes');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '6', 'Future (deferred) income tax provision');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '7', 'Total-other comprehensive income');
INSERT INTO `accounting`.`code_account_type` (`sub_group_id`,`code`, `name`) VALUES ('17', '8', 'Net Income / loss after taxes and ');


/* Code  entries */
SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE `accounting`.`code`; 
SET FOREIGN_KEY_CHECKS = 1;
ALTER TABLE `accounting`.`code` AUTO_INCREMENT = 1;
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1000','Cash and deposits','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1001','Cash','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1002','Deposits in Canadian banks and institutions –','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1003','Deposits in Canadian banks and institutions –','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1004','Deposits in foreign banks – Canadian currency','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1005','Deposits in foreign banks – Foreign currency','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1006','Credit union central deposits','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('12','1007','Other cash-like instruments','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('13','1060','Accounts receivable','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1061','Allowance for doubtful accounts','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1062','Trade accounts receivable','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1063','Allowance for doubtful trade accounts receivable','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1064','Trade accounts receivable from related parties','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1065','Allowance for doubtful trade accounts receivable','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1066','Taxes receivable','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1067','Interest receivable','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1068','Holdbacks receivable','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1069','Leases receivable','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1070','Allowance for doubtful amounts contained in','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1071','Accounts receivable from employees','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1072','Allowance for doubtful accounts receivable from','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('14','1073','Amounts receivable from members of NPOs','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1120','Inventories','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1121','Inventory of goods for sale','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1122','Inventory parts and supplies','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1123','Inventory properties','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1124','Inventory of aggregates','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1125','Work in progress','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1126','Raw materials','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1127','Inventory of securities','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1180','Short-term investments','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1181','Canadian term deposits','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1182','Canadian shares','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1183','Canadian bonds','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1184','Canadian treasury bills','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1185','Securities purchased under resale agreements','2','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1186','Other short-term Canadian investments','2','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1187','Short-term foreign investments','2','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1240','Loans and notes receivable','2','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1241','Demand loans receivable','2','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1242','Other loans receivable','2','19');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1243','Notes receivable','2','20');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('15','1244','Mortgages receivable','2','21');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('16','1300','Due from shareholder(s)/director(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('16','1301','Due from individual shareholder(s)','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('16','1302','Due from corporate shareholder(s)','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('16','1303','Due from director(s)','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('17','1310','Due from member(s)/general partner(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('17','1311','Due from limited partners','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('17','1312','Due from members that are partnerships','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('17','1313','Due from general partners','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('17','1314','Due from specified members who are not limited','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('18','1360','Investment in joint venture(s)/partnership(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('19','1380','Due from joint venture(s)/partnership(s) (item for','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('20','1400','Due from/investment in related parties','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('20','1401','Demand notes from related parties','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('20','1402','Interest receivable from related parties','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('20','1403','Loans/advances due from related parties','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('21','1460','Customers’ liability under acceptances','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1480','Other current assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1481','Future (deferred) income taxes','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1482','Accrued investment income','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1483','Taxes recoverable/refundable','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1484','Prepaid expenses','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1485','Drilling advances','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('22','1486','Security/tender deposits','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('23','1599','Total current assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('1','1600','Land','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('1','1601','Land improvements','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('1','1602','Accumulated amortization of land improvements','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('2','1620','Depletable assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1621','Accumulated amortization of depletable assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1622','Petroleum and natural gas properties','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1623','Accumulated amortization of petroleum and','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1624','Mining properties','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1625','Accumulated amortization of mining properties','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1626','Deferred exploration and development charges','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1627','Accumulated amortization of deferred exploration','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1628','Quarries','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1629','Accumulated amortization of quarries','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1630','Gravel pits','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1631','Accumulated amortization of gravel pits','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1632','Timber limits','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('3','1633','Accumulated amortization of timber limits','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('4','1680','Buildings','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('5','1681','Accumulated amortization of buildings','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('5','1682','Manufacturing and processing plant','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('5','1683','Accumulated amortization of manufacturing and','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('5','1684','Buildings under construction','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('6','1740','Machinery, equipment, furniture, and fixtures','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1741','Accumulated amortization of machinery, equipment Furniture & Fixtures','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1742','Motor vehicles','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1743','Accumulated amortization of motor vehicles','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1744','Tools and dies','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1745','Accumulated amortization of tools and dies','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1746','Construction and excavating equipment','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1747','Accumulated amortization of construction and','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1748','Forestry and logging equipment','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1749','Accumulated amortization of forestry and logging','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1750','Fishing gear and nets','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1751','Accumulated amortization of fishing gear and nets','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1752','Mining equipment','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1753','Accumulated amortization of mining equipment','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1754','Oil and gas systems','2','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1755','Accumulated amortization of oil and gas systems','2','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1756','Production equipment for resource industries','2','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1757','Accumulated amortization of production','2','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1758','Production equipment for other than resource','2','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1759','Accumulated amortization of production','2','19');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1760','Exploration equipment','2','20');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1761','Accumulated amortization of exploration','2','21');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1762','Shipping equipment','2','22');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1763','Accumulated amortization of shipping equipment','2','23');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1764','Ships and boats','2','24');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1765','Accumulated amortization of ships and boats','2','25');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1766','Aircraft','2','26');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1767','Accumulated amortization of aircraft','2','27');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1768','Signs','2','28');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1769','Accumulated amortization of signs','2','29');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1770','Small tools','2','30');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1771','Accumulated amortization of small tools','2','31');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1772','Radio and communication equipment','2','32');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1773','Accumulated amortization of radio and','2','33');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1774','Computer equipment/software','2','34');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1775','Accumulated amortization of computer','2','35');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1776','Musical instruments','2','36');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1777','Accumulated amortization of musical instruments','2','37');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1778','Satellites','2','38');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1779','Accumulated amortization of satellites','2','39');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1780','Earth stations','2','40');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1781','Accumulated amortization of earth stations','2','41');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1782','Machinery and equipment under construction','2','42');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1783','Transportation equipment','2','43');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1784','Accumulated amortization of transportation','2','44');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1785','Other machinery and equipment','2','45');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1786','Accumulated amortization of other machinery and','2','46');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1787','Furniture and fixtures','2','47');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('7','1788','Accumulated amortization of furniture and','2','48');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('8','1900','Other tangible capital assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1901','Accumulated amortization of other tangible','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1902','Logging roads','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1903','Accumulated amortization of logging roads','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1904','Asphalt and parking areas','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1905','Accumulated amortization of asphalt and parking','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1906','Wharves','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1907','Accumulated amortization of wharves','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1908','Fences','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1909','Accumulated amortization of fences','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1910','Capital leases – Buildings','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1911','Accumulated amortization of capital leases –','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1912','Capital leases – Equipment','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1913','Accumulated amortization of capital leases –','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1914','Capital leases – Vehicles','2','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1915','Accumulated amortization of capital leases –','2','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1916','Capital leases – Others','2','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1917','Accumulated amortization of capital leases –','2','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1918','Leasehold improvements','2','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1919','Accumulated amortization of leasehold','2','19');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1920','Other capital assets under construction','2','20');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1921','Campsites','2','21');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('9','1922','Accumulated amortization of campsites','2','22');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('10','2008','Total tangible capital assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('11','2009','Total accumulated amortization of tangible','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('24','2010','Intangible assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2011','Accumulated amortization of intangible assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2012','Goodwill','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2013','Accumulated amortization of goodwill','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2014','Quota','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2015','Accumulated amortization of quota','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2016','Licences','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2017','Accumulated amortization of licences','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2018','Incorporation costs','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2019','Accumulated amortization of incorporation costs','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2020','Trademarks/patents','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2021','Accumulated amortization of trademarks/patents','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2022','Customer lists','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2023','Accumulated amortization of customer lists','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2024','Rights','2','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2025','Accumulated amortization of rights','2','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2026','Research and development','2','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('25','2027','Accumulated amortization of research and development','2','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('26','2070','Resource Rights','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2071','Accumulated amortization of resource rights','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2072','Timber rights','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2073','Accumulated amortization of timber rights','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2074','Mining rights','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2075','Accumulated amortization of mining rights','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2076','Oil and gas rights','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('27','2077','Accumulated amortization of oil and gas rights','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('28','2178','Total intangible capital assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('29','2179','Total accumulated amortization of intangible assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('30','2180','Due from shareholder(s)/director(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('30','2181','Due from individual shareholder(s)','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('30','2182','Due from corporate shareholder(s)','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('30','2183','Due from director(s)','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('31','2190','Due from members','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('32','2200','Investment in joint venture(s)/partnership(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('33','2210','Due from member(s)/general partner(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('33','2211','Due from limited partners','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('33','2212','Due from members that are partnerships','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('33','2213','Due from general partners','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('33','2214','Due from specified members who are not limited','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('34','2220','Due from joint venture(s)/partnership(s) ','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2240','Due from/investment in related parties','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2241','Due from/investment in Canadian related parties','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2242','Shares in Canadian related corporations','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2243','Loans/advances to Canadian related corporations','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2244','Investment in Canadian related corporations at','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2245','Investment in Canadian related corporations at','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2246','Due from/investment in foreign related parties','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2247','Shares in foreign related corporations','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2248','Loans/advances to foreign related corporations','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2249','Investment in foreign related corporations at cost','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('35','2250','Investment in foreign related corporations at','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('36','2280','Investment in co-tenancy','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2300','Long-term investments','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2301','Foreign shares','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2302','Other types of foreign investments','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2303','Canadian shares','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2304','Government of Canada debt','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2305','Canadian, provincial, and municipal government','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2306','Canadian corporate bonds and debentures','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2307','Debt securities','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2308','Equity securities','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2309','Securities purchased under resale agreements','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2310','Central credit union shares','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('37','2311','Other Canadian long-term investments','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('38','2360','Long-term loans','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('38','2361','Mortgages','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('38','2362','Personal and credit card loans','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('38','2363','Business and government loans','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('38','2364','Line of credit','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2420','Other long-term assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2421','Future (deferred) income taxes','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2422','Deferred pension charges','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2423','Deferred unrealized exchange losses','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2424','Other deferred items/charges','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2425','Accumulated amortization of deferred charges','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2426','Reserve fund','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('39','2427','Cash surrender value of life insurance','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('40','2589','Total long-term assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('41','2590','Assets held in trust','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('42','2599','Total assets','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('82','2600','Bank overdraft','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2620','Amounts payable and accrued liabilities','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2621','Trade payables','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2622','Trade payables to related parties','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2623','Holdbacks payable','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2624','Wages payable','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2625','Management fees payable','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2626','Bonuses payable','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2627','Employee deductions payable','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2628','Withholding taxes payable','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2629','Interest payable','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('83','2630','Amounts payable to members of NPOs','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('84','2680','Taxes payable','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2700','Short-term debt','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2701','Loans from Canadian banks','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2702','Liability for securities sold short','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2703','Liability for securities sold under repurchase','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2704','Gold and silver certificates','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2705','Cheques and other items in transit','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2706','Lien notes','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('85','2707','Credit card loans','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('86','2770','Deferred income','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('87','2780','Due to shareholder(s)/director(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('87','2781','Due to individual shareholder(s)','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('87','2782','Due to corporate shareholder(s)','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('87','2783','Due to director(s)','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('88','2790','Due to member(s)/general partner(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('88','2791','Due to limited partners','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('88','2792','Due to members that are partnerships','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('88','2793','Due to general partners','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('88','2794','Due to specified members who are not limited','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('89','2840','Due to joint venture(s)/partnership(s) ','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('90','2860','Due to related parties','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('90','2861','Demand notes due to related parties','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('90','2862','Interest payable to related parties','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('90','2863','Advances due to related parties','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('91','2920','Current portion of long-term liability','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('92','2940','Bankers’ acceptances','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2960','Other current liabilities','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2961','Deposits received','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2962','Dividends payable','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2963','Future (deferred) income taxes','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2964','Reserves for guarantees, warranties, or indemnities','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2965','General provisions/reserves','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('93','2966','Crew shares','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('94','3139','Total current liabilities','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3140','Long-term debt','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3141','Mortgages','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3142','Farm Credit Corporation loan','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3143','Chartered bank loan','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3144','Credit Union/Caisse Populaire loan','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3145','Provincial or territorial government loan','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3146','Supply company loan','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3147','Private loan','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3148','Central, league, and federation loans','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3149','Line of credit','2','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3150','Liability for securities sold short','2','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3151','Liability for securities sold under repurchase','2','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('95','3152','Lien notes','2','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('96','3200','Deposit liabilities of financial institutions','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('97','3210','Bonds and debentures','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('98','3220','Deferred income','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('99','3240','Future (deferred) income taxes','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('100','3260','Due to shareholder(s)/director(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('100','3261','Due to individual shareholder(s)','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('100','3262','Due to corporate shareholder(s)','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('100','3263','Due to director(s)','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('101','3270','Due to members','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('102','3280','Due to joint venture(s)/partnership(s)  ','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('103','3291','Due to member(s)/general partner(s)','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('103','3292','Due to limited partners','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('103','3293','Due to members that are partnerships','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('103','3294','Due to general partners','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('103','3295','Due to specified members who are not limited','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('104','3300','Due to related parties','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('104','3301','Amounts owing to related Canadian parties','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('104','3302','Amounts owing to related foreign parties','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3320','Other long-term liabilities','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3321','Long-term obligations/commitments/capital','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3322','Reserves for guarantees, warranties, or indemnities','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3323','Provision for site restoration','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3324','Contributions to qualifying environmental trust','2','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3325','General provisions/reserves','2','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3326','Preference shares restated','2','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3327','Member allocations (item for use by corporations)','2','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('105','3328','Deferred revenue from incomplete contracts','2','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('106','3450','Total long-term liabilities','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('107','3460','Subordinated debt','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('108','3470','Amounts held in trust','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('109','3499','Total liabilities','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('55','3500','Common shares','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('56','3520','Preferred shares','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('57','3540','Contributed and other surplus','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('57','3541','Contributed surplus','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('57','3542','Appraisal surplus','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('57','3543','General reserve','2','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('58','3570','Head office account','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('59','3580','Accumulated other comprehensive income','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('60','3590','General partners’ capital (cost of partnership','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('60','3591','Limited partners’ capital (cost of partnership interest)','2','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('60','3592','Contributions during the year  ','2','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('61','3600','Retained earnings/deficit','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('62','3620','Total shareholder equity','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('63','3630','Total partners’ capital  ','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('64','3640','Total liabilities and shareholder equity','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('65','3650','Total liabilities and partners’ capital  ','2','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('144','3660','Retained earnings/deficit – Start','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('145','3680','Net income/loss','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('146','3690','Capital contributed  ','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('147','3700','Dividends declared','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('147','3701','Cash dividends','4','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('147','3702','Patronage dividends','4','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('148','3720','Prior period adjustments','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('149','3740','Other items affecting retained earnings','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('149','3741','Share redemptions','4','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('149','3742','Special reserves','4','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('149','3743','Currency adjustments','4','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('149','3744','Unusual revenue items','4','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('149','3745','Interfund transfer','4','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('150','3750','Drawings ','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('151','3849','Retained earnings/deficit – End','4','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('137','7000','Revaluation surplus','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('138','7002','Defined benefit gains/losses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('139','7004','Foreign operation translation gains/losses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('140','7006','Equity instruments gains/losses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('141','7008','Cash flow hedge effective portion gains/losses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('142','7010','Income tax relating to components of other','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('143','7020','Miscellaneous other comprehensive income','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('152','8000','Trade sales of goods and services','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('153','8020','Sales of goods and services to related parties','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('154','8030','Interdivisional sales','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8040','Sales from resource properties','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8041','Petroleum and natural gas sales','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8042','Petroleum and natural gas sales to related parties','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8043','Gas marketing','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8044','Processing revenue','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8045','Pipeline revenue','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8046','Seismic sales','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8047','Mining revenue','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8048','Coal revenue','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8049','Oil sands revenue','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8050','Royalty income','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8051','Oil and gas partnership/joint venture income/loss','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8052','Mining partnership/joint venture income/loss','1','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('155','8053','Other production revenue','1','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('156','8089','Total sales of goods and services','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8090','Investment revenue','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8091','Interest from foreign sources','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8092','Interest from Canadian bonds and debentures','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8093','Interest from Canadian mortgage loans','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8094','Interest from other Canadian sources','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8095','Dividend income','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8096','Dividends from Canadian sources','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('157','8097','Dividends from foreign sources','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('158','8100','Interest income (financial institutions)','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('158','8101','Loan interest','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('158','8102','Securities interest','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('158','8103','Deposits with banks interest','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('159','8120','Commission revenue','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('159','8121','Commission income on real estate transactions','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('160','8140','Rental revenue','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('160','8141','Real estate rental revenue','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('160','8142','Film rental revenue','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('161','8150','Vehicle leasing','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8160','Fishing revenue','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8161','Fish products','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8162','Other marine products','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8163','Fishing grants, credits, and rebates','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8164','Fishing subsidies','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8165','Compensation for loss of fishing income or property','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('162','8166','Sharesman income','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('163','8210','Realized gains/losses on disposal of assets','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('163','8211','Realized gains/losses on sale of investments','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('163','8212','Realized gains/losses on sale of resource','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('164','8220','NPO amounts received','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('164','8221','Membership fees','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('164','8222','Assessments','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('164','8223','Gifts','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('164','8224','Gross sales and revenues from organizational','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8230','Other revenue','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8231','Foreign exchange gains/losses','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8232','Income/loss of subsidiaries/affiliates','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8233','Income/loss of other divisions','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8234','Income/loss of joint ventures','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8235','Income/loss of partnerships','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8236','Realization of deferred revenues','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8237','Royalty income other than resource','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8238','Alberta royalty tax credits','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8239','Management and administration fees','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8240','Telecommunications revenue','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8241','Consulting fees','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8242','Subsidies and grants','1','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8243','Sale of by-products','1','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8244','Deposit services','1','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8245','Credit services','1','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8246','Card services','1','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8247','Patronage dividends','1','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8248','Insurance recoveries','1','19');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8249','Expense recoveries','1','20');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('165','8250','Bad debt recoveries','1','21');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('166','8299','Total revenue','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('43','8300','Opening inventory','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('43','8301','Opening inventory – Finished goods','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('43','8302','Opening inventory – Raw materials','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('43','8303','Opening inventory – Goods in process','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('44','8320','Purchases/cost of materials','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('45','8340','Direct wages','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('46','8350','Benefits on direct wages','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('47','8360','Trades and sub-contracts','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('48','8370','Production costs other than resource','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8400','Resource production costs','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8401','Pipeline operations','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8402','Drilling','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8403','Site restoration costs','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8404','Gross overriding royalty','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8405','Freehold royalties','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8406','Other producing properties rental','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8407','Prospect/geological','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8408','Well operating, fuel and equipment','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8409','Well abandonment and dry holes','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8410','Other lease rentals','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8411','Exploration expenses','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('49','8412','Development expenses','1','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8435','Crown charges','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8436','Crown royalties','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8437','Crown lease rentals','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8438','Freehold mineral tax','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8439','Mining taxes','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8440','Oil sand leases','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('50','8441','Saskatchewan resource surcharge','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8450','Other direct costs','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8451','Equipment hire and operation','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8452','Log yard','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8453','Forestry costs','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8454','Logging road costs','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8455','Stumpage costs','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8456','Royalty costs','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8457','Freight-in and duty','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8458','Inventory write-down','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8459','Direct cost amortization of tangible assets','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8460','Direct cost amortization of natural resource assets','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('51','8461','Overhead expenses allocated to cost of sales','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('52','8500','Closing inventory','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('52','8501','Closing inventory – Finished goods','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('52','8502','Closing inventory – Raw materials','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('52','8503','Closing inventory – Goods in process','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('53','8518','Cost of sales','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('54','8519','Gross profit/loss','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('111','8520','Advertising and promotion','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('111','8521','Advertising','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('111','8522','Donations','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('111','8523','Meals and entertainment','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('111','8524','Promotion','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('112','8570','Amortization of intangible assets','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('113','8571','Goodwill impairment loss','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('114','8590','Bad debt expense','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('115','8610','Loan losses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('115','8611','Provision for loan losses','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('116','8620','Employee benefits','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('116','8621','Group insurance benefits','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('116','8622','Employer’s portion of employee benefits','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('116','8623','Contributions to deferred income plans','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('117','8650','Amortization of natural resource assets','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('118','8670','Amortization of tangible assets','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('119','8690','Insurance','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('119','8691','Life insurance on executives','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8710','Interest and bank charges','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8711','Interest on short-term debt','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8712','Interest on bonds and debentures','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8713','Interest on mortgages','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8714','Interest on long-term debt','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8715','Bank charges','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8716','Credit card charges','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('120','8717','Collection and credit costs','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('121','8740','Interest paid (financial institutions)','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('121','8741','Interest paid on deposits','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('121','8742','Interest paid on bonds and debentures','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('122','8760','Business taxes, licences, and memberships','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('122','8761','Memberships','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('122','8762','Business taxes','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('122','8763','Franchise fees','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('122','8764','Government fees','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('123','8790','Nova Scotia tax on large corporations','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('124','8810','Office expenses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('124','8811','Office stationery and supplies','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('124','8812','Office utilities','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('124','8813','Data processing','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8860','Professional fees','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8861','Legal fees','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8862','Accounting fees','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8863','Consulting fees','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8864','Architect fees','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8865','Appraisal fees','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8866','Laboratory fees','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8867','Medical fees','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8868','Veterinary fees','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8869','Brokerage fees','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8870','Transfer fees','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8871','Management and administration fees','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8872','Refining and assay','1','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8873','Registrar and transfer agent fees','1','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8874','Restructuring costs','1','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8875','Security commission fees','1','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8876','Training expense','1','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('125','8877','Studio and recording','1','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8910','Rental','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8911','Real estate rental','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8912','Occupancy costs','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8913','Condominium fees','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8914','Equipment rental','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8915','Motor vehicle rentals','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8916','Moorage (boat)','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8917','Storage','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8918','Quota rental','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8960','Repairs and maintenance','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8961','Repairs and maintenance – Buildings','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8962','Repairs and maintenance – Vehicles','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8963','Repairs and maintenance – Boats','1','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('126','8964','Repairs and maintenance – Machinery and Equpment','1','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('127','9010','Other repairs and maintenance','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('127','9011','Machine shop expense','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('127','9012','Road costs','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('127','9012','Road costs','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('127','9013','Security','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('127','9014','Garbage removal','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9060','Salaries and wages','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9061','Commissions','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9062','Crew share','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9063','Bonuses','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9064','Directors fees','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9065','Management salaries','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('128','9066','Employee salaries','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('129','9110','Sub-contracts','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9130','Supplies','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9131','Small tools','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9132','Shop expense','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9133','Uniforms','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9134','Laundry','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9135','Food and catering','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9136','Fishing gear','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9137','Nets and traps','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9138','Salt, bait, and ice','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('130','9139','Camp supplies','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('131','9150','Computer-related expenses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('131','9151','Upgrade','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('131','9152','Internet','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('132','9180','Property taxes','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('133','9200','Travel expenses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('133','9201','Meetings and conventions','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('134','9220','Utilities','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('134','9221','Electricity','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('134','9222','Water','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('134','9223','Heat','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('134','9224','Fuel costs','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('134','9225','Telephone and telecommunications','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9270','Other expenses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9271','Cash over/short','1','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9272','Reimbursement of parent company expense','1','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9273','Selling expenses','1','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9274','Shipping and warehouse expense','1','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9275','Delivery, freight and express','1','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9276','Warranty expenses','1','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9277','Royalty expenses – Resident','1','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9278','Royalty expenses – Non-resident','1','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9279','Dumping charges','1','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9280','Land fill fees','1','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9281','Vehicle expenses','1','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9282','Research and development','1','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9283','Withholding taxes','1','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9284','General and administrative expenses','1','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9285','Interdivisional expenses','1','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('135','9286','Interfund transfer','1','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('136','9367','Total operating expenses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('167','9368','Total expenses','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('110','9369','Net non-farming income','1','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9370','Grains and oilseeds','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9371','Wheat','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9372','Oats','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9373','Barley','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9374','Mixed grains','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9375','Corn','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9376','Canola','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9377','Flaxseed','3','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9378','Soya beans','3','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('74','9379','Wheat Board payments','3','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9420','Other crop revenues','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9421','Fruit','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9422','Potatoes','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9423','Vegetables','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9424','Tobacco','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9425','Greenhouse and nursery products','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('75','9426','Forage crops','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9470','Livestock and animal products revenue','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9471','Cattle','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9472','Swine','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9473','Poultry','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9474','Sheep and lambs','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9475','Pregnant mare urine (PMU)','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9476','Milk and cream (excluding dairy subsidies)','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9477','Eggs for consumption','3','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9478','Hatching eggs','3','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9479','Aquaculture (hatching and raising)','3','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('76','9480','Horses (breeding and meat)','3','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('77','9520','Other commodities','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('77','9521','Maple products','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('77','9522','Artificial insemination','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('77','9523','Semen production','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('77','9524','Embryo production','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9540','Program payment revenues','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9541','Dairy subsidies','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9542','Crop insurance','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9544','Disaster Assistance Program payments','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9545','AgriStability and AgriInvest benefit','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9546','Production insurance premium benefit','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9570','Rebates','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9571','Rebates – Fuel','3','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9572','Rebates – Interest','3','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('78','9573','Rebates – Property taxes','3','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9600','Other farm revenues/losses','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9601','Custom or contract work','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9602','Wood sales','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9603','Horse racing','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9604','Insurance proceeds','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9605','Patronage dividends','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9606','Rental income','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9607','Interest income','3','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9608','Dividend income','3','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9609','Gains/losses on disposal of assets','3','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9610','Gravel','3','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9611','Trucking','3','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9612','Resale of commodities purchased','3','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9613','Leases (gas, oil, well, surface, etc.)','3','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9614','Machine rentals','3','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9615','Farming partnership income/loss','3','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9616','Farming joint venture income/loss','3','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('79','9617','Custom feeding','3','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('80','9650','Non-farming income','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('81','9659','Total farm revenue','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('66','9660','Crop expenses','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('66','9661','Containers, twine, and baling wire','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('66','9662','Fertilizers and lime','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('66','9663','Pesticides','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('66','9664','Seeds and plants','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9710','Livestock expenses','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9711','Feed, supplements, straw, and bedding','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9712','Livestock purchases','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9713','Veterinary fees, medicine, and breeding fees','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9714','Minerals and salts','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9760','Machinery expenses','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9761','Machinery insurance','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9762','Machinery licences','3','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9763','Machinery repairs','3','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9764','Machinery fuel','3','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('67','9765','Machinery lease','3','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9790','General farm expenses','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9791','Amortization of tangible assets','3','2');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9792','Advertising, marketing costs, and promotion','3','3');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9793','Bad debt','3','4');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9794','Benefits related to employee salaries','3','5');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9795','Building repairs and maintenance','3','6');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9796','Clearing, levelling, and draining land','3','7');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9797','Crop insurance, Revenue Protection Program, and','3','8');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9798','Custom or contract work','3','9');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9799','Electricity','3','10');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9800','Fence repairs and maintenance','3','11');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9801','Freight and trucking','3','12');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9802','Heating fuel and curing fuel','3','13');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9803','Insurance program overpayment recapture','3','14');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9804','Other insurance premiums','3','15');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9805','Interest and bank charges','3','16');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9806','Marketing board fees','3','17');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9807','Memberships/subscription fees','3','18');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9808','Office expenses','3','19');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9809','Professional fees','3','20');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9810','Property taxes','3','21');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9811','Rent – Land and buildings','3','22');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9812','Rent – Machinery','3','23');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9813','Other rental expenses','3','24');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9814','Salaries and wages','3','25');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9815','Salaries and wages other than for spouse or','3','26');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9816','Salaries and wages paid to dependants','3','27');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9817','Selling costs','3','28');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9818','Supplies','3','29');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9819','Motor vehicle expenses','3','30');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9820','Small tools','3','31');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9821','Soil testing','3','32');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9822','Storage/drying','3','33');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9823','Licences/permits','3','34');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9824','Telephone','3','35');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9825','Quota rental (tobacco, dairy)','3','36');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9826','Gravel','3','37');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9827','Purchases of commodities resold','3','38');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9828','Salaries and wages paid to spouse','3','39');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9829','Motor vehicle interest and leasing costs','3','40');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9830','Prepared feed','3','41');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9831','Custom feed','3','42');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9832','Amortization of intangible assets','3','43');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9833','Amortization of milk quota','3','44');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9834','Travel expenses','3','45');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9835','Capital/business taxes','3','46');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('68','9836','Commissions and levies','3','47');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('69','9850','Non-farming expenses','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('70','9870','Net inventory adjustment','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('71','9898','Total farm expenses','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('72','9899','Net farm income','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('73','9970','Net income/loss before taxes and extraordinary','3','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9975','Extraordinary item(s)','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9976','Legal settlements','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9980','Unrealized gains/losses','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9985','Unusual items','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9990','Current income taxes','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9995','Future (deferred) income tax provision','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9998','Total-other comprehensive income','5','1');
INSERT INTO `accounting`.`code` (`account_type_id`,`code`, `name`,`report_ref_id`,`sort_order`) VALUES ('168','9999','Net Income / loss after taxes and ','5','1');


/* May 6 */
CREATE TABLE accounting.chart_of_accounts
(
 account_id int UNSIGNED NOT NULL,
 code_id int UNSIGNED,
 amount numeric(15,2),
 modified_date datetime,
 PRIMARY KEY (account_id,code_id)
);

/* May 12 */
INSERT INTO `accounting`.`chart_of_accounts` (`account_id`, `code_id`, `amount`) VALUES ('1005', '1', '100');
INSERT INTO `accounting`.`chart_of_accounts` (`account_id`, `code_id`, `amount`) VALUES ('1005', '23', '200');
INSERT INTO `accounting`.`chart_of_accounts` (`account_id`, `code_id`, `amount`) VALUES ('1005', '216', '100');
INSERT INTO `accounting`.`chart_of_accounts` (`account_id`, `code_id`, `amount`) VALUES ('1005', '258', '200');
INSERT INTO `accounting`.`chart_of_accounts` (`account_id`, `code_id`, `amount`) VALUES ('1005', '334', '100');

/* May 14 */
ALTER TABLE `accounting`.`chart_of_accounts` 
ADD COLUMN `chart_id` INT(10) NOT NULL AUTO_INCREMENT AFTER `modified_date`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`chart_id`);

/* May 21 */ 
ALTER TABLE `accounting`.`transaction` 
ADD COLUMN `payment_method` int UNSIGNED,
ADD COLUMN `payment_amount` numeric(15,2),
ADD COLUMN `payment_entity_id` int UNSIGNED;

ALTER TABLE `accounting`.`vendor` 
ADD COLUMN `amount` numeric(15,2);

ALTER TABLE `accounting`.`customer` 
ADD COLUMN `amount` numeric(15,2);

/* May 23 */ 
CREATE TABLE `accounting`.`bank` (
  `bank_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(10) unsigned NOT NULL,
  `account_username` varchar(255) DEFAULT NULL,
  `code_id` int(10) unsigned DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `title` varchar(10) DEFAULT NULL,
  `display_name` varchar(255) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(10) unsigned DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `accounting`.`employee` (
  `employee_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(10) unsigned NOT NULL,
  `account_username` varchar(255) DEFAULT NULL,
  `code_id` int(10) unsigned DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `title` varchar(10) DEFAULT NULL,
  `display_name` varchar(255) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(10) unsigned DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/* May 25 */
ALTER TABLE `cxprofile`.`account_info` 
ADD COLUMN `temp_pass` VARCHAR(45) NULL AFTER `reason`;

/* June 1 */
CREATE TABLE `accounting`.`tax_rule` (
  `tax_rule_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `country_code` varchar(10) DEFAULT NULL,
  `state_code` varchar(10) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `class` varchar(10) DEFAULT NULL,
  `display_name` varchar(255) NOT NULL,
  `percentage_one` decimal(8,5) DEFAULT NULL,
  `percentage_two` decimal(8,5) DEFAULT NULL,
  `percentage_three` decimal(8,5) DEFAULT NULL,
  `percentage_four` decimal(8,5) DEFAULT NULL,
  `percentage` decimal(8,5) DEFAULT NULL,
  `fixed_amount_one` decimal(20,5) DEFAULT NULL,
  `fixed_amount_two` decimal(20,5) DEFAULT NULL,
  `fixed_amount_three` decimal(20,5) DEFAULT NULL,
  `fixed_amount_four` decimal(20,5) DEFAULT NULL,
  `fixed_amount` decimal(20,5) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` int(10) unsigned DEFAULT NULL,  
  PRIMARY KEY (`tax_rule_id`)
);

INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`, `country_code`,`state_code`,`percentage` ) VALUES ('1','CA-AB-Alberta', 'GST','CA','AB','5');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('2','CA-BC-British Columbia', 'GST+PST','CA','BC','12');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('3','CA-MB-Manitoba', 'GST+PST','CA','MB','13');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`, `country_code`,`state_code`,`percentage` ) VALUES ('4','CA-NB-New Brunswick', 'HST','CA','NB','13');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`, `country_code`,`state_code`,`percentage` ) VALUES ('5','CA-NL-Newfoundland and Labrador', 'HST','CA','NL','13');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('6','CA-NS-Nova Scotia', 'HST','CA','NS','15');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('7','CA-NT-Northwest Territories', 'GST','CA','NT','5');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('8','CA-NU-Nunavut', 'GST','CA','NU','5');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('9','CA-ON-Ontario', 'HST','CA','ON','13');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('10','CA-PE-Prince Edward Island', 'HST','CA','PE','14');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('11','CA-QC-Quebec', 'GST+QST','CA','QC','14.975');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('12','CA-SK-Saskatchewan', 'GST+PST','CA','SK','10');
INSERT INTO `accounting`.`tax_rule` (`code`,`display_name`, `remarks`,`country_code`,`state_code`,`percentage` ) VALUES ('13','CA-YA-Yukon', 'GST','CA','YA','5');

/* decimal points update */
ALTER TABLE `accounting`.`bank` change `amount` `amount` decimal(20,5);
ALTER TABLE `accounting`.`employee` change `amount` `amount` decimal(20,5);
ALTER TABLE `accounting`.`chart_of_accounts` change `amount` `amount` decimal(20,5);
ALTER TABLE `accounting`.`vendor` change `amount` `amount` decimal(20,5);
ALTER TABLE `accounting`.`customer` change `amount` `amount` decimal(20,5);
ALTER TABLE `accounting`.`transaction` change `rate` `rate` decimal(20,5);
ALTER TABLE `accounting`.`transaction` change `tax` `tax` decimal(20,5);
ALTER TABLE `accounting`.`transaction` change `amount` `amount` decimal(20,5);
ALTER TABLE `accounting`.`transaction` change `balance_due` `balance_due` decimal(20,5);
ALTER TABLE `accounting`.`transaction` change `payment_amount` `payment_amount` decimal(20,5);
ALTER TABLE `accounting`.`transaction` change `discount_percent` `discount_percent` decimal(8,5);

/* June 3 */
ALTER TABLE `accounting`.`customer` ADD column `country_code` varchar(10) DEFAULT NULL, ADD column `state_code` varchar(10) DEFAULT NULL;
ALTER TABLE `accounting`.`bank` ADD column `country_code` varchar(10) DEFAULT NULL, ADD column `state_code` varchar(10) DEFAULT NULL;
ALTER TABLE `accounting`.`vendor` ADD column `country_code` varchar(10) DEFAULT NULL, ADD column `state_code` varchar(10) DEFAULT NULL;
ALTER TABLE `accounting`.`employee` ADD column `country_code` varchar(10) DEFAULT NULL, ADD column `state_code` varchar(10) DEFAULT NULL;

/* June 12 */
ALTER TABLE `accounting`.`transaction` ADD column `net_amount` decimal(20,5);

/* June 13 */
ALTER TABLE `cxprofile`.`account_info` 
ADD COLUMN `is_account_verified` VARCHAR(45) NULL AFTER `temp_pass`;

ALTER TABLE `cxprofile`.`account_info` 
ADD COLUMN `activation_id` VARCHAR(45) NULL AFTER `is_account_verified`;

/*July 29*/
ALTER TABLE `accounting`.`code_group`
ADD column `sort_order` int UNSIGNED;

ALTER TABLE `accounting`.`code_sub_group`
ADD column `sort_order` int UNSIGNED;

UPDATE `accounting`.`code_group` SET `sort_order`='1' WHERE `group_id`='1';
UPDATE `accounting`.`code_group` SET `sort_order`='2' WHERE `group_id`='6';
UPDATE `accounting`.`code_group` SET `sort_order`='3' WHERE `group_id`='3';
UPDATE `accounting`.`code_group` SET `sort_order`='1' WHERE `group_id`='11';
UPDATE `accounting`.`code_group` SET `sort_order`='3' WHERE `group_id`='8';
UPDATE `accounting`.`code_group` SET `sort_order`='2' WHERE `group_id`='2';
UPDATE `accounting`.`code_group` SET `sort_order`='4' WHERE `group_id`='9';
UPDATE `accounting`.`code_group` SET `sort_order`='' WHERE `group_id`='12';

/* Aug 1 */
ALTER TABLE `accounting`.`code_account_type`
ADD column `sort_order` int UNSIGNED;

