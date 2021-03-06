/*	DELETE USER si existe	*/
DROP USER 'crowdfunding'@'localhost';

/* DROP DATABASE si existe */
DROP DATABASE IF EXISTS fr_m1info_rv2j;
CREATE DATABASE fr_m1info_rv2j DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE fr_m1info_rv2j;

/* DROP TABLE si existe */
DROP TABLE IF EXISTS contributions;
DROP TABLE IF EXISTS commentaries;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;

/* Table des utilisateur */
CREATE TABLE users(
	id INT(10) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	pw VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	inscription_date DATE NOT NULL,
	right_level INT(1) NOT NULL DEFAULT '1',
	PRIMARY KEY (id)
);
ALTER TABLE users CONVERT TO CHARACTER SET 'UTF8';

/* Table des projets */
CREATE TABLE projects(
	id INT(10) NOT NULL AUTO_INCREMENT,
	author_id INT(10) NOT NULL,
	name TEXT NOT NULL,
	presentation LONGTEXT,
	goal INT(10) NOT NULL,
	picture_path LONGTEXT,
	creation_date DATE NOT NULL,
	last_update DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE 
);

/* Table des commentaires */
CREATE TABLE commentaries(
	id INT(10) NOT NULL AUTO_INCREMENT,
	author_id INT(10) NOT NULL,
	project_id INT(10) NOT NULL,
	text VARCHAR(140) NOT NULL, 	/* Comme un tweet :D */ 
	creation_date DATE NOT NULL,
	last_update DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE,
	FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
);

/* Table des contributions */
CREATE TABLE contributions(
	contributor_id INT(10) NOT NULL,
	project_id INT(10) NOT NULL,
	donation INT(10) NOT NULL,
	creation_date DATE NOT NULL,
	FOREIGN KEY (contributor_id) REFERENCES users(id) ON DELETE CASCADE,
	FOREIGN KEY (project_id) REFERENCES projects(id)  ON DELETE CASCADE
);

/*	CREATE USER FOR DATABASE	*/
CREATE USER 'crowdfunding'@'localhost' IDENTIFIED BY 'rv2j';
GRANT ALL PRIVILEGES ON fr_m1info_rv2j.* TO 'crowdfunding'@'localhost';
FLUSH PRIVILEGES;

/*	INSERT USER - ADMINS FOR DATABSE */
INSERT INTO users(name, pw, email, inscription_date, right_level) VALUES ('Jerome','jeje','jerome@example.fr',NOW(),2);
INSERT INTO users(name, pw, email, inscription_date, right_level) VALUES ('Johan','johan','johan@example.fr',NOW(),2);
INSERT INTO users(name, pw, email, inscription_date, right_level) VALUES ('Valerian','valou','valerian@example.fr',NOW(),2);
INSERT INTO users(name, pw, email, inscription_date, right_level) VALUES ('Robin','roro','robin@example.fr',NOW(),2);