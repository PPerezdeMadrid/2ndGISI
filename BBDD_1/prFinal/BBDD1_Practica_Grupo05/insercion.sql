INSERT INTO enfermedad VALUES('évolaTomas');
INSERT INTO enfermedad VALUES('Esclerosis');
INSERT INTO enfermedad VALUES('Gripe');
INSERT INTO enfermedad VALUES('Pulmotrastitis');
INSERT INTO enfermedad VALUES('tuplitis');
INSERT INTO enfermedad VALUES('Gastronteritis');
INSERT INTO enfermedad VALUES('Dolor de cabeza');
INSERT INTO enfermedad VALUES('Estipulatis');
INSERT INTO enfermedad VALUES('Rosacasambre');
INSERT INTO enfermedad VALUES('MareosFestinos');
INSERT INTO enfermedad VALUES('Perdida de memoria');
INSERT INTO enfermedad VALUES('CabezaZombie');
INSERT INTO enfermedad VALUES('Resfriado');
INSERT INTO enfermedad VALUES('Fibromialgia');

INSERT INTO persona VALUES('54479760M','Paloma','Femenino','Esclerosis','zombieEspañol',19);
INSERT INTO persona VALUES('54477777M','Juan','Masculino','Esclerosis','zombieEspañol',19);
INSERT INTO persona VALUES('12345678A','José','Masculino',NULL,NULL,23);
INSERT INTO persona VALUES('22244466B','Orianna','Femenino',NULL,NULL,20);
INSERT INTO persona VALUES('11133355C','Tomás','Masculino','Gripe','zombieGripe',20);
INSERT INTO persona VALUES('11111111M','Paloma','Femenino','Esclerosis','zombieFrancés',23);
INSERT INTO persona VALUES('11111111D','Clara','Femenino','MareosFestinos','zombieMF',23);
INSERT INTO persona VALUES('22222222X','José','Masculino','Fibromialgia','zombieFibromiálgico',43);
INSERT INTO persona VALUES ("54421345M", "Elena", "Femenino", "MareosFestinos", "zombieMF", 17);

INSERT INTO zombie VALUES('zombieEspañol','forzoso',5,'rapida',4,'Esclerosis');
INSERT INTO zombie VALUES('zombieFrancés','forzoso',4,'rapida',2,'Pulmotrastitis');
INSERT INTO zombie VALUES('zombieTomás','parado',3,'baja',1,'évolaTomás');
INSERT INTO zombie VALUES('zombieGripe','retractivo',2,'media',5,'Gripe');
INSERT INTO zombie VALUES('zombieMF','perezoso',1,'media',3,'MareosFestinos');
INSERT INTO zombie VALUES('zombieFibromiálgico','retractivo',2,'baja',3,'Fibromialgia');

INSERT INTO arma VALUES('pistola','alta','Boadilla','54421345M');
INSERT INTO arma VALUES('cuchillo','media','Montepríncipe','12345678A');
INSERT INTO arma VALUES('espátula','baja','córdoba','22244466B');
INSERT INTO arma VALUES('metralleta','alta','Salamanca','11133355C');
INSERT INTO arma VALUES('granada','alta','Salamanca','11111111D');

INSERT INTO matar VALUES('zombieEspañol','pistola');
INSERT INTO matar VALUES('zombieGripe','cuchillo');
INSERT INTO matar VALUES('zombieTomás','metralleta');
INSERT INTO matar VALUES('zombieFrancés','pistola');
INSERT INTO matar VALUES('zombieEspañol','metralleta');
INSERT INTO matar VALUES('zombieFrancés','metralleta');
INSERT INTO matar VALUES('zombieGripe','metralleta');
INSERT INTO matar VALUES('zombieMF','granada');
INSERT INTO matar VALUES('zombieFibromiálgico','granada');
INSERT INTO matar VALUES('zombieEspañol','granada');
INSERT INTO matar VALUES('zombieGripe','granada');
INSERT INTO matar VALUES('zombieTomás','granada');

INSERT INTO cura VALUES('vacuna43c2','Gripe');
INSERT INTO cura VALUES('vacunaTupla','tuplitis');
INSERT INTO cura VALUES('Ibuprofeno','Dolor de cabeza');
INSERT INTO cura VALUES('Amoxicilina-4mg','Rosacasambre');
INSERT INTO cura VALUES('Vacuna43F3','Perdida de memoria');
INSERT INTO cura VALUES('Antidoto3d21','CabezaZombie');
INSERT INTO cura VALUES('Antidoto23a23A','MareosFestinos');
