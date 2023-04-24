CREATE TABLE jugadoresInno ( 
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	fecha_inscrp DATE NOT NULL,
	altura FLOAT NOT NULL,
	mas18 BOOLEAN NOT NULL,
PRIMARY KEY (id)
)  ENGINE=InnoDB;

CREATE TABLE jugadoresIsam ( 
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	fecha_inscrp DATE NOT NULL,
	altura FLOAT NOT NULL,
	mas18 BOOLEAN NOT NULL,
PRIMARY KEY (id)
)  ENGINE=MyISAM;

CREATE TABLE jugadoresMemory ( 
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	fecha_inscrp DATE NOT NULL,
	altura FLOAT NOT NULL,
	mas18 BOOLEAN NOT NULL,
PRIMARY KEY (id)
)  ENGINE=MEMORY;

CREATE TABLE jugadoresCSV ( 
	id INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	fecha_inscrp DATE NOT NULL,
	altura FLOAT NOT NULL,
	mas18 BOOLEAN NOT NULL
)  ENGINE=CSV;

CREATE TABLE jugadoresArchive ( 
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	fecha_inscrp DATE NOT NULL,
	altura FLOAT NOT NULL,
	mas18 BOOLEAN NOT NULL,
PRIMARY KEY (id)
)  ENGINE=ARCHIVE;

CREATE TABLE jugadoresBH ( 
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	fecha_inscrp DATE NOT NULL,
	altura FLOAT NOT NULL,
	mas18 BOOLEAN NOT NULL,
PRIMARY KEY (id)
)  ENGINE=BLACKHOLE;










