CREATE TABLE USERS (
  user_name VARCHAR(20) NOT NULL,
  user_id VARCHAR(100) PRIMARY KEY,
  user_password VARCHAR(20) NOT NULL UNIQUE,
  email VARCHAR(50),
  ip VARCHAR(20),
  reg_date DATE,
  contrib_level VARCHAR(10),
  first_name VARCHAR (50),
  last_name VARCHAR (50),
  modified DATE,
  modified_by VARCHAR(100)
);


CREATE TABLE roles (
  role_name VARCHAR(10) NOT NULL,
  limitsForGroups INT NOT NULL,
  limitsForDrafts INT NOT NULL,
  limitsPendPois INT NOT NULL,
  limitsPendRoutes INT NOT NULL,
  routesToGetNextRole INT NOT NULL,
  poisToGetNextRole INT NOT NULL
  );
  
  user_id VARCHAR(100) PRIMARY KEY,
  user_password VARCHAR(20) NOT NULL UNIQUE,
  email VARCHAR(50),
  ip VARCHAR(20),
  reg_date DATE,
  contrib_level VARCHAR(10),
  first_name VARCHAR (50),
  last_name VARCHAR (50),
  modified DATE,
  modified_by VARCHAR(100)
);

CREATE TABLE Addcat (
addcat_name VARCHAR (50) not null UNIQUE,
addcat_index INTEGER,
show_for_filters INTEGER 
);

INSERT INTO Districts (distr_name, distr_index, show_for_filters)
VALUES 

('Uralskiy', 59, 1);


DROP TABLE POIS_FOR_DRAFTS_ROUTES22;
ALTER TABLE users ADD COLUMN Confirmed VARCHAR(1);

ALTER TABLE users DROP CONSTRAINT SQL151226140534061 
ALTER TABLE groups ADD CONSTRAINT Group_id_Constr PRIMARY KEY (group_id);

ALTER TABLE groups ADD COLUMN modified DATE;

DROP INDEX SQL151226140534060;

ALTER TABLE users ALTER COLUMN first_name NULL;

ALTER TABLE drafts_routes DROP COLUMN creator_id;
ALTER TABLE POIS_For_Groups ADD COLUMN temp_poi_id VARCHAR(100);

ALTER TABLE POIS_For_Groups ALTER COLUMN poi_id NOT NULL; 

ALTER TABLE POIS_For_Groups ADD CONSTRAINT Group_id_FK FOREIGN KEY (group_id) REFERENCES APP.groups(group_id);

RENAME COLUMN POIS_For_Groups.temp_poi_id TO poi_id;

DELETE FROM temp_pois;

ALTER TABLE pending_pois ADD COLUMN create_date DATE;
ALTER TABLE pois ADD COLUMN CREATOR_ID VARCHAR(100);
ALTER TABLE temp_pois ADD COLUMN poi_id VARCHAR(100);

ALTER TABLE pois ADD CONSTRAINT poi_id_Key PRIMARY KEY (poi_id);
ALTER TABLE groups ALTER COLUMN group_id NOT NULL;
ALTER TABLE pois DROP CONSTRAINT SQL160427133644750;
RENAME COLUMN pois.poi_UUid TO poi_id;

ALTER TABLE POIS_FOR_ROUTES DROP CONSTRAINT SQL151226184954181;

ALTER TABLE POIS_FOR_DRAFTS_ROUTES DROP CONSTRAINT SQL160106184431571;

ALTER TABLE routes DROP CONSTRAINT SQL151226182758902;

declare global temporary table temp_pois (
	poi_id INT,
    creator_id INTEGER,
    poi_name VARCHAR(50), 
    main_poi_id INT,
    lat DECIMAL (10,7) NOT NULL, 
    longit DECIMAL (10,7) NOT NULL, 
    town VARCHAR(30),
    street VARCHAR(30), 
    building VARCHAR(20), 
    post_code VARCHAR(10), 
    district_index INTEGER NOT NULL, 
    avail_index INT NOT NULL, 
    status_index INT NOT NULL, 
    poi_main_cat_index INT NOT NULL, 
    poi_add_cat_index INT NOT NULL, 
    poi_sub1_index INT NOT NULL,
    poi_sub2_index INT NOT NULL,
    poi_period_index INT NOT NULL, 
    rating INT NOT NULL, 
    descript VARCHAR(200) NOT NULL,
    weblink VARCHAR (50)
) not logged;

drop table temp_pois1;

create table temp_pois (
	poi_id INT,
    creator_id INTEGER,
    poi_name VARCHAR(50), 
    main_poi_id INT,
    lat DECIMAL (10,7) NOT NULL, 
    longit DECIMAL (10,7) NOT NULL, 
    town VARCHAR(30),
    street VARCHAR(30), 
    building VARCHAR(20), 
    post_code VARCHAR(10), 
    district_index INTEGER NOT NULL, 
    avail_index INT NOT NULL, 
    status_index INT NOT NULL, 
    poi_main_cat_index INT NOT NULL, 
    poi_add_cat_index INT NOT NULL, 
    poi_sub1_index INT NOT NULL,
    poi_sub2_index INT NOT NULL,
    poi_period_index INT NOT NULL, 
    rating INT NOT NULL, 
    descript VARCHAR(200) NOT NULL,
    weblink VARCHAR (50)
);

INSERT INTO users (user_name, user_password, email, ip, reg_date, contrib_level)
VALUES ('admin1', 'blablabla', 'androgeny80@gmail.com', null, CURRENT DATE, 3);

DELETE FROM USERS;

DROP TABLE pois;

CREATE TABLE pending_pois (
	poi_id VARCHAR(100) NOT NULL PRIMARY KEY,
    creator_id VARCHAR(100) NOT NULL,
    poi_name VARCHAR(50), 
    main_poi_id INT,
    lat DECIMAL (10,7) NOT NULL, 
    longit DECIMAL (10,7) NOT NULL, 
    town VARCHAR(30),
    street VARCHAR(30), 
    building VARCHAR(20), 
    post_code VARCHAR(10), 
    district_index INTEGER NOT NULL CONSTRAINT D_Ch CHECK (district_index < 60), 
    avail_index INT NOT NULL CONSTRAINT A_Ch CHECK (avail_index < 6), 
    status_index INT NOT NULL CONSTRAINT S_Ch CHECK (status_index < 5), 
    poi_main_cat_index INT NOT NULL CONSTRAINT m_cat_Ch CHECK (poi_main_cat_index < 12), 
    poi_add_cat_index INT NOT NULL CONSTRAINT addcat_Ch CHECK (poi_add_cat_index < 10), 
    poi_sub1_index INT NOT NULL CONSTRAINT sub1_Ch CHECK (poi_sub1_index < 17),
    poi_sub2_index INT NOT NULL CONSTRAINT sub2_Ch CHECK (poi_sub2_index < 19),
    poi_period_index INT NOT NULL CONSTRAINT p_Ch CHECK (poi_period_index < 8), 
    rating INT NOT NULL CONSTRAINT r_Ch CHECK (rating < 6), 
    descript VARCHAR(200) NOT NULL,
    weblink VARCHAR (50),
    modified DATE,
    modified_by VARCHAR(100),
    operation VARCHAR (3)
);

CREATE TABLE ROUTES (
route_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 2) PRIMARY KEY,
creator_id INTEGER NOT NULL,
route_name VARCHAR (100) NOT NULL UNIQUE,
route_descr VARCHAR (300) NOT NULL,
route_type_index INT NOT NULL CONSTRAINT type_Ch CHECK (route_type_index < 4),
route_duration_index INT NOT NULL CONSTRAINT duration_Ch CHECK (route_duration_index < 4),
diff_level_index INT NOT NULL CONSTRAINT diff_Ch CHECK (diff_level_index < 4),
FOREIGN KEY (creator_id) REFERENCES APP.users(user_id)
);

CREATE TABLE DRAFTS_ROUTES2 (
route_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 2) PRIMARY KEY,
creator_id INTEGER NOT NULL,
route_name VARCHAR (100) NOT NULL UNIQUE,
route_descr VARCHAR (300) NOT NULL,
route_type_index INT NOT NULL CONSTRAINT type_Ch CHECK (route_type_index < 4),
route_duration_index INT NOT NULL CONSTRAINT duration_Ch CHECK (route_duration_index < 4),
diff_level_index INT NOT NULL CONSTRAINT diff_Ch CHECK (diff_level_index < 4),
FOREIGN KEY (creator_id) REFERENCES APP.users(user_id)
);

CREATE TABLE POIS_For_ROUTES (
route_id INTEGER NOT NULL,
poi_id INT NOT NULL,
order_number INT NOT NULL,
FOREIGN KEY (route_id) REFERENCES APP.routes(route_id),
FOREIGN KEY (poi_id) REFERENCES APP.pois(poi_id)
);


CREATE TABLE POIS_FOR_DRAFTS_ROUTES22 (
route_id INTEGER NOT NULL,
poi_id INT NOT NULL,
order_number INT NOT NULL);

,
FOREIGN KEY (route_id) REFERENCES APP.DRAFTS_ROUTES(route_id),
FOREIGN KEY (poi_id) REFERENCES APP.pois(poi_id)
);

CREATE TABLE GROUPS (
group_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 30, INCREMENT BY 2) PRIMARY KEY,
creator_id INTEGER NOT NULL,
group_name VARCHAR (100) NOT NULL,
group_descr VARCHAR (300) NOT NULL,
FOREIGN KEY (creator_id) REFERENCES APP.users(user_id)
);

DROP TABLE POIS_For_Groups;

CREATE TABLE POIS_For_Groups (
group_id VARCHAR(100) NOT NULL,
poi_id VARCHAR(100) NOT NULL),
FOREIGN KEY (group_id) REFERENCES APP.groups(group_id),
FOREIGN KEY (poi_id) REFERENCES APP.pois(poi_id)
);
