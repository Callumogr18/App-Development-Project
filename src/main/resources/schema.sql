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