DROP DATABASE demo;
#DROP USER 'user'@'%';
DROP USER 'user'@'127.0.0.1';

CREATE DATABASE demo;

#CREATE USER 'user'@'%' IDENTIFIED BY 'password';
CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY 'password';

#GRANT ALL PRIVILEGES ON demo.* TO 'user'@'%';
#GRANT ALL PRIVILEGES ON demo.* TO 'user'@'127.0.0.1';

GRANT SELECT, INSERT, UPDATE, DELETE, DROP ON demo.* TO 'user'@'127.0.0.1';
FLUSH PRIVILEGES;

CREATE TABLE demo.programming_language(
	pl_id INT PRIMARY KEY AUTO_INCREMENT,
	pl_name VARCHAR(50) NOT NULL UNIQUE,
	pl_rating INT
);

