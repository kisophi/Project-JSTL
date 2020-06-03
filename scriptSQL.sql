CREATE DATABASE	dbjava;

USE dbjava;

CREATE TABLE user(
	userid int AUTO_INCREMENT,
    name VARCHAR(255),
    login VARCHAR(255) UNIQUE NOT NULL,
    pass VARCHAR(255),
    PRIMARY KEY(userid)
);

INSERT INTO user VALUES(null,'Akira','aki','111');
INSERT INTO user VALUES(null,'Leandro','leo','222');
INSERT INTO user VALUES(null,'João','joa','333');
INSERT INTO user VALUES(null,'Pedro','ped','444');
INSERT INTO user VALUES(null,'Maria','mar','555');
INSERT INTO user VALUES(null,'Carlos','car','666');
INSERT INTO user VALUES(null,'Fabio','fab','777');

SELECT*FROM user;

SELECT login FROM user WHERE login='a';

SELECT * FROM user WHERE name LIKE '%lu%';
