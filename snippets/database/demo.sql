DROP DATABASE demo;
#DROP USER 'user'@'%';
DROP USER 'user'@'127.0.0.1';

CREATE DATABASE demo;

#CREATE USER 'user'@'%' IDENTIFIED BY 'password';
CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY '123';

#GRANT ALL PRIVILEGES ON demo.* TO 'user'@'%';
GRANT ALL PRIVILEGES ON demo.* TO 'user'@'127.0.0.1';

#GRANT SELECT, INSERT, UPDATE, DELETE, DROP ON demo.* TO 'user'@'127.0.0.1';
FLUSH PRIVILEGES;

CREATE TABLE demo.programming_language(
	pl_id INT PRIMARY KEY AUTO_INCREMENT,
	pl_name VARCHAR(50) NOT NULL UNIQUE,
	pl_rating INT
);

CREATE SEQUENCE demo.person_sq
	MINVALUE = 10
	START = 10
	INCREMENT = 1
	CACHE = 1000
	NOCYCLE;

CREATE TABLE demo.person (
	id INT NOT NULL DEFAULT (NEXT VALUE FOR demo.person_sq),
	name VARCHAR(24) NOT NULL,
	last_name VARCHAR(32) NOT NULL,
	occupation VARCHAR(24) NOT NULL,
	age SMALLINT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE demo.matrix2d (
	name CHAR(8) NOT NULL,
	row SMALLINT NOT NULL,
	col SMALLINT NOT NULL,
	value DOUBLE DEFAULT 0.0,
	PRIMARY KEY (name, row, col)
);

delimiter //
CREATE procedure demo.matrix_set(in aname char(8), IN arow SMALLINT, IN acol SMALLINT, IN avalue DOUBLE)
BEGIN
	IF (SELECT COUNT(*) FROM demo.matrix2d WHERE name = aname AND row = arow AND col = acol) = 1
	THEN
		DELETE FROM demo.matrix2d WHERE name = aname AND row = arow AND col = acol;
	END IF;

	INSERT INTO demo.matrix2d VALUES (aname, arow, acol, avalue);
end//
delimiter ;

