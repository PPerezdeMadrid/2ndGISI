UPDATE zombie SET velInfeccion = velInfeccion + 1;
ALTER TABLE enfermedad ADD COLUMN lugarOrigen TEXT;
UPDATE enfermedad SET lugarOrigen = "desconocido" WHERE lugarOrigen IS NULL;

DELETE FROM arma WHERE letalidad LIKE “b%”;
DELETE FROM persona WHERE edad > (SELECT AVG (edad) FROM persona);
DROP VIEW eferm;

SELECT nombre, zombie, nombreArma FROM persona INNER JOIN matar ON nombreZombie = zombie;
SELECT nombreZombie FROM matar INNER JOIN persona ON zombie= nombreZombie AND nombreArma = (SELECT arma.nombre AS "arma" FROM arma INNER JOIN persona ON personaPropietaria = dni);
SELECT enfermedad.nombre, cura.id FROM enfermedad LEFT JOIN cura ON cura.enfermedad = enfermedad.nombre LIMIT 6 OFFSET 2;

SELECT AVG(edad) FROM persona WHERE zombie = “zombieEspañol”;
SELECT COUNT(enfermedad) FROM persona WHERE sexo = "Femenino" AND edad BETWEEN 23 AND 43;
SELECT dni, max(edad), enfermedad FROM persona GROUP BY enfermedad HAVING edad < 40;

SELECT nombre FROM arma WHERE personaPropietaria = (SELECT dni FROM persona WHERE enfermedad IS NULL);
SELECT dni, persona.nombre AS "nombre Sujeto", arma.nombre AS "arma", enfermedad FROM persona INNER JOIN arma ON personaPropietaria = dni  AND enfermedad = (SELECT enfermedad FROM cura WHERE cura.id IS NOT NULL);

CREATE VIEW inmunes AS SELECT dni, nombre, sexo, edad FROM persona WHERE enfermedad is null;
SELECT * FROM inmunes ORDER BY edad;
CREATE TEMP VIEW armasPersonas AS SELECT arma.nombre, letalidad, lugar, persona.nombre FROM arma INNER JOIN persona ON personaPropietaria = dni;
SELECT * FROM armasPersonas WHERE letalidad = alta;