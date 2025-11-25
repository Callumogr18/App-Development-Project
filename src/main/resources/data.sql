INSERT INTO myusers (username, password, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('admin', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'ADMIN', TRUE, TRUE, TRUE, TRUE);

INSERT INTO myusers (username, password, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('staff', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'STAFF', TRUE, TRUE, TRUE, TRUE);

INSERT INTO myusers (username, password, role, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('student', '$2a$10$jPOV8aXOKupAi7UCJVvMaeEzBXjjLEblskQkB3ZAtNww2ATQjp8QK', 'STUDENT', TRUE, TRUE, TRUE, TRUE);

-- Insert Planets
INSERT INTO PLANETS (PLANET_ID, PLANET_NAME, PLANET_TYPE, RADIUS_KM, MASS_KG, ORBITAL_PERIOD_DAYS) VALUES
   (1, 'Mercury', 'Terrestrial', 2439.7, 3.285e23, 87.97),
   (2, 'Venus', 'Terrestrial', 6051.8, 4.867e24, 224.7),
   (3, 'Earth', 'Terrestrial', 6371.0, 5.972e24, 365.26),
   (4, 'Mars', 'Terrestrial', 3389.5, 6.39e23, 686.98),
   (5, 'Jupiter', 'Gas Giant', 69911.0, 1.898e27, 4332.59),
   (6, 'Saturn', 'Gas Giant', 58232.0, 5.683e26, 10759.22),
   (7, 'Uranus', 'Ice Giant', 25362.0, 8.681e25, 30688.5),
   (8, 'Neptune', 'Ice Giant', 24622.0, 1.024e26, 60182.0);

-- Insert Moons for Earth
INSERT INTO MOONS (MOON_ID, NAME, DIAMETER_KM, ORBITAL_PERIOD_DAYS, PLANET_ID) VALUES
    (1, 'Moon', 3474.8, 27.32, 3);

-- Insert Moons for Mars
INSERT INTO MOONS (MOON_ID, NAME, DIAMETER_KM, ORBITAL_PERIOD_DAYS, PLANET_ID) VALUES
   (2, 'Phobos', 22.4, 0.32, 4),
   (3, 'Deimos', 12.4, 1.26, 4);

-- Insert Moons for Jupiter
INSERT INTO MOONS (MOON_ID, NAME, DIAMETER_KM, ORBITAL_PERIOD_DAYS, PLANET_ID) VALUES
   (4, 'Io', 3643.2, 1.77, 5),
   (5, 'Europa', 3121.6, 3.55, 5),
   (6, 'Ganymede', 5268.2, 7.15, 5),
   (7, 'Callisto', 4820.6, 16.69, 5);

-- Insert Moons for Saturn
INSERT INTO MOONS (MOON_ID, NAME, DIAMETER_KM, ORBITAL_PERIOD_DAYS, PLANET_ID) VALUES
    (8, 'Titan', 5149.5, 15.95, 6),
    (9, 'Rhea', 1527.6, 4.52, 6),
    (10, 'Iapetus', 1469.0, 79.33, 6),
    (11, 'Dione', 1122.8, 2.74, 6),
    (12, 'Tethys', 1062.2, 1.89, 6),
    (13, 'Enceladus', 504.2, 1.37, 6);

-- Insert Moons for Uranus
INSERT INTO MOONS (MOON_ID, NAME, DIAMETER_KM, ORBITAL_PERIOD_DAYS, PLANET_ID) VALUES
   (14, 'Titania', 1577.8, 8.71, 7),
   (15, 'Oberon', 1522.8, 13.46, 7),
   (16, 'Umbriel', 1169.4, 4.14, 7),
   (17, 'Ariel', 1157.8, 2.52, 7),
   (18, 'Miranda', 471.6, 1.41, 7);

-- Insert Moons for Neptune
INSERT INTO MOONS (MOON_ID, NAME, DIAMETER_KM, ORBITAL_PERIOD_DAYS, PLANET_ID) VALUES
   (19, 'Triton', 2706.8, 5.88, 8),
   (20, 'Proteus', 420.0, 1.12, 8);
