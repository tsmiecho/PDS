CREATE DATABASE PDS
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_polish_ci;

 CREATE TABLE Person
(
id int UNSIGNED NOT NULL AUTO_INCREMENT,
name varchar(255) NOT NULL,
msisdn varchar(32) NULL,
email varchar(128) NULL,
person_comment longtext NULL,
photo_url varchar(255) NULL,
city varchar(255) NULL,
street varchar(255) NULL,
street_number varchar(32) NULL,
flat_number varchar(32) NULL,
PRIMARY KEY(id)
);