CREATE TABLE enfermedad (
nombre TEXT PRIMARY KEY
);
CREATE TABLE persona (
dni TEXT PRIMARY KEY,
nombre TEXT,
sexo TEXT
, enfermedad TEXT REFERENCES enfermedad(nombre), zombie TEXT REFERENCES zombie(nombre), edad INTERGER);
CREATE TABLE zombie (
nombre TEXT PRIMARY KEY,
tipoAtaque TEXT,
nivelInfeccion INTERGER,
velInfeccion TEXT,
rapidez INTERGER
, enfermedad TEXT REFERENCES enfermedad(nombre));
CREATE TABLE arma (
nombre TEXT PRIMARY KEY,
letalidad TEXT,
lugar TEXT
, personaPropietaria TEXT REFERENCES persona(dni));
CREATE TABLE matar (
nombreZombie TEXT,
nombreArma TEXT,
PRIMARY KEY (nombreZombie, nombreArma),
FOREIGN KEY (nombreZombie) REFERENCES zombie(nombre)
ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (nombreArma) REFERENCES armas(nombre)
ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE cura(
id TEXT PRIMARY KEY,
enfermedad TEXT,
FOREIGN KEY(enfermedad) REFERENCES enfermedad(nombre)
ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE VIEW enferm AS SELECT nombre, ifnull(id, '(no hay cura)') AS id FROM enfermedad LEFT JOIN cura ON
cura.enfermedad = enfermedad.nombre
/* enferm(nombre,id) */;