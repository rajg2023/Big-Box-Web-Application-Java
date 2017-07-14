-- create and select the database
DROP DATABASE IF EXISTS bigbox;
CREATE DATABASE bigbox;
USE bigbox;

-- create the Divisions table
CREATE TABLE divisions (
  ID		     INT            PRIMARY KEY  AUTO_INCREMENT,
  DivisionNumber VARCHAR(3)     NOT NULL,
  Name           VARCHAR(255)   NOT NULL,
  Address        VARCHAR(255)   NOT NULL,
  City           VARCHAR(255)   NOT NULL,
  State    		 VARCHAR(2)     NOT NULL,
  ZipCode		 VARCHAR(5)     NOT NULL
);

-- create the Stores table
CREATE TABLE stores (
  ID		     INT            PRIMARY KEY  AUTO_INCREMENT,
  DivisionID	 INT            NOT NULL,
  StoreNumber    VARCHAR(5)     NOT NULL,
  Name           VARCHAR(255)   NOT NULL,
  Address        VARCHAR(255)   NOT NULL,
  City           VARCHAR(255)   NOT NULL,
  State    		 VARCHAR(2)     NOT NULL,
  ZipCode		 VARCHAR(5)     NOT NULL,
  Foreign Key (DivisionID) references divisions(ID) ON DELETE CASCADE
);

-- create the Store_Sales table
CREATE TABLE store_sales (
	ID			int				PRIMARY KEY AUTO_INCREMENT,
    StoreID		int				NOT NULL,
    Year		int				NOT NULL,
    Week		int				NOT NULL,
    Sales		decimal(10,2)	NOT NULL,
    CONSTRAINT store_year_week unique (StoreID,Year,Week),
    Foreign Key (StoreID) references stores(ID) ON DELETE CASCADE
);
-- insert some rows into the Stores table
INSERT INTO divisions VALUES 
(1, '001', 'Cincinnati Division Office', '2200 Fields Ertel Rd.', 'Mason', 'OH', '45249'),
(2, '111', 'Louisville Division Office', '4000 Liberty St.', 'Louisville', 'KY', '40204');

-- insert some rows into the Stores table
INSERT INTO stores VALUES 
(1, 1, '00011', 'Mason Big Box', '5711 Fields Ertel Rd.', 'Mason', 'OH', '45249'),
(2, 1, '00255', 'Downtown Big Box','9330 Main St.', 'Cincinnati', 'OH', '45249'),
(3, 1, '00172', 'Goshen Big Box','6777 Goshen Rd.', 'Goshen', 'OH', '45249'),
(4, 1, '00075', 'Bridgetown Big Box','3888 Race Rd.', 'Cincinnati', 'OH', '45249'),
(5, 2, '00011', 'Louisville Big Box','1111 Washington St.', 'Louisville', 'KY', '40206'),
(6, 2, '00044', 'Riverfront Big Box','8000 Liberty St.', 'Louisville', 'KY', '40204');

-- insert some rows into the Store_Sales table
INSERT INTO store_sales (StoreID, Year, Week, Sales) VALUES
(1, 2017, 2, 3445555.89),
(1, 2017, 3, 3445555.89),
(1, 2017, 4, 3445555.89),
(1, 2017, 5, 3445555.89),
(2, 2017, 10, 3444433.33),
(2, 2017, 11, 3444433.33),
(2, 2017, 12, 3444433.33),
(2, 2017, 13, 3444433.33),
(2, 2017, 14, 3444433.33),
(3, 2017, 21, 4555543.66),
(3, 2017, 22, 4555543.66),
(3, 2017, 23, 4555543.66),
(3, 2017, 24, 4555543.66),
(3, 2017, 25, 4555543.66),
(3, 2017, 26, 4555543.66),
(3, 2017, 27, 4555543.66),
(4, 2017, 2, 3444555.99),
(4, 2017, 3, 3444555.99),
(5, 2017, 11, 7668944.33),
(5, 2017, 12, 7668944.33),
(5, 2017, 13, 7668944.33),
(5, 2017, 14, 7668944.33),
(6, 2017, 16, 8777655.33),
(6, 2017, 17, 8777655.33),
(6, 2017, 18, 8777655.33);

-- create a user and grant privileges to that user
GRANT SELECT, INSERT, DELETE, UPDATE
ON bigbox.*
TO bb_user@localhost
IDENTIFIED BY 'sesame';