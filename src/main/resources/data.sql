DROP TABLE IF EXISTS customer;
--------
-------- Table structure for table `customer`
--------
CREATE TABLE `customer` (
   id INT(10) NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   PRIMARY KEY (id)
);

DROP TABLE IF EXISTS availableCategories;
--------
-------- Table structure for table `availableCategories`
--------
CREATE TABLE `availableCategories` (
   name VARCHAR(255) NOT NULL,
   userName VARCHAR(255) NOT NULL,
   availableContent INT(10) NOT NULL,
   price FLOAT NOT NULL
);

DROP TABLE IF EXISTS subscribedCategories;
--------
-------- Table structure for table `subscribedCategories`
--------
CREATE TABLE `subscribedCategories` (
    id INT(10) NOT NULL,
   name VARCHAR(255) NOT NULL,
   userName VARCHAR(255) NOT NULL,
   subscribedContent INT(10) NOT NULL,
   price FLOAT NOT NULL,
   subscribedDate TIMESTAMP NOT NULL,
   startDate TIMESTAMP NOT NULL
);