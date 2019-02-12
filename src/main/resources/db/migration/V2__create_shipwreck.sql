CREATE TABLE "shipwreck"(
	ID INT AUTO_INCREMENT,
	NAME VARCHAR(255),
	DESCRIPTION VARCHAR(2000),
	CONDITION VARCHAR(255),
	DEPTH INT,
	LATITUDE DOUBLE,
	LONGITUDE DOUBLE,
	YEAR_DISCOVERED INT
);

-- CREATE TABLE LOCATION(
-- 	ID INT AUTO_INCREMENT,
-- 	STATE VARCHAR(255),
-- 	COUNTRY VARCHAR(255)
-- );
--
-- CREATE TABLE MANUFACTURER(
-- 	ID INT AUTO_INCREMENT,
-- 	NAME VARCHAR(255),
-- 	LOCATION_ID INT,
--   AVERAGEYEARLYSALES INT,
--   FOUNDEDDATE DATE
-- );


-- insert into manufacturer (id, name, location_id, averageYearlySales, foundedDate)
-- values (2, 'Gibson Guitar Corporation', 42, 32000000, '1902-01-01');
-- insert into modeltype (id, name) values (1, 'Dreadnought Acoustic');
-- insert into model (id, name, manufacturer_id, modeltype_id, price, woodtype, yearfirstmade, frets) values (1, 'American Stratocaster', 1, 4, 1000, 'Maple, Alder, Ash, Popular', '1954-01-01', 21);
