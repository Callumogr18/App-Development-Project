CREATE TABLE myusers (
                       user_id BIGINT NOT NULL AUTO_INCREMENT,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('ADMIN', 'STAFF', 'STUDENT') NOT NULL,
                       PRIMARY KEY (user_id),
                       enabled BOOLEAN DEFAULT TRUE,
                       account_non_expired BOOLEAN DEFAULT TRUE,
                       credentials_non_expired BOOLEAN DEFAULT TRUE,
                       account_non_locked BOOLEAN DEFAULT TRUE
);

-- DROP TABLE IF EXISTS MOONS;
-- DROP TABLE IF EXISTS PLANETS;

-- Create PLANETS table
CREATE TABLE PLANETS (
                         PLANET_ID BIGINT PRIMARY KEY,
                         PLANET_NAME VARCHAR(100) NOT NULL,
                         PLANET_TYPE VARCHAR(50) NOT NULL,
                         RADIUS_KM DOUBLE NOT NULL,
                         MASS_KG DOUBLE NOT NULL,
                         ORBITAL_PERIOD_DAYS DOUBLE NOT NULL
);

-- Create MOONS table
CREATE TABLE MOONS (
                       MOON_ID BIGINT PRIMARY KEY,
                       NAME VARCHAR(100) NOT NULL,
                       DIAMETER_KM DOUBLE NOT NULL,
                       ORBITAL_PERIOD_DAYS DOUBLE NOT NULL,
                       PLANET_ID BIGINT NOT NULL,
                       CONSTRAINT FK_MOON_PLANET FOREIGN KEY (PLANET_ID) REFERENCES PLANETS(PLANET_ID)
);