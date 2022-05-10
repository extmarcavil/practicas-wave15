CREATE DATABASE empresa_internet;
USE empresa_internet;


CREATE TABLE cliente(
id_cliente 			INT NOT NULL AUTO_INCREMENT,
nombre     			VARCHAR(100) NOT NULL,
apellido			VARCHAR(100) NOT NULL,
fecha_nacimiento	DATE NOT NULL,
provincia			VARCHAR(150),
ciudad				VARCHAR(100),
PRIMARY KEY (id_cliente));


CREATE TABLE plan(
id_plan 					INT NOT NULL AUTO_INCREMENT,
descripcion     			VARCHAR(100) NOT NULL,
velocidad_transferencia		INT,
precio						DOUBLE,
descuento					DOUBLE,
PRIMARY KEY (id_plan));


CREATE TABLE plan_cliente(
id_plan_cliente 		INT NOT NULL AUTO_INCREMENT,
id_plan 				INT NOT NULL,
id_cliente 				INT NOT NULL,
fecha_contratacion		DATETIME NOT NULL,
fecha_baja				DATETIME NULL,
activo					BIT NOT NULL,
PRIMARY KEY (id_plan_cliente),
FOREIGN KEY (id_plan) REFERENCES plan(id_plan),
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);


#Se insertan registros en la tabla cliente
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Gerson Jair','Sanchez Arroyo','1992-08-05','GAM','Ciudad de mexico');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Juan','Perez Ruiz','1990-12-16','Coyoacan','Ciudad de mexico');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Martin','Suarez','1982-02-14','Iztapalapa','Ciudad de mexico');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Itzel','Contreras','1994-12-16','GAM','Ciudad de mexico');
        
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Edwin','Duran','1972-08-15','Ecatepec de Morelos','Estado de mexico');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Brenda','Padilla','1989-12-11','Polanco','Ciudad de mexico');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Kevin','Ortiz','2000-04-10','Iztacalco','Ciudad de mexico');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Fernando','Tapia','1998-01-01','Acapulco','Guerrero');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Luis','Garcia','1988-12-01','Poza rica','Veracruz');
        
INSERT INTO cliente (nombre,apellido,fecha_nacimiento,provincia,ciudad) 
		VALUES('Hugo','Sanchez','1980-11-30','nuevo leon','Monterrey');
        
#se insertan registros en tabla plan
INSERT INTO plan (descripcion,velocidad_transferencia,precio,descuento)
		VALUES('Plan total internet + telefono',2048,549.00,0.0);
        
INSERT INTO plan (descripcion,velocidad_transferencia,precio,descuento)
		VALUES('Plan solo internet',4096,649.00,0.0);
        
INSERT INTO plan (descripcion,velocidad_transferencia,precio,descuento)
		VALUES('Plan internet bootcamp',8192,849.00,0.0);
        
INSERT INTO plan (descripcion,velocidad_transferencia,precio,descuento)
		VALUES('Plan basico',1024,449.00,0.0);
        
INSERT INTO plan (descripcion,velocidad_transferencia,precio,descuento)
		VALUES('Plan home office',5120,749.00,0.0);
        
#Se insertan registros en la tabla plan_cliente. es decir aqui se registraran todos los planes que tiene un cliente una
#relacion de 1 a n 
INSERT INTO plan_cliente (id_plan,id_cliente,fecha_contratacion,fecha_baja,activo)
	VALUES (3,1,NOW(),NULL,1);
    
INSERT INTO plan_cliente (id_plan,id_cliente,fecha_contratacion,fecha_baja,activo)
	VALUES (1,2,NOW(),NULL,1);
    
INSERT INTO plan_cliente (id_plan,id_cliente,fecha_contratacion,fecha_baja,activo)
	VALUES (2,3,NOW(),NULL,1);
    
INSERT INTO plan_cliente (id_plan,id_cliente,fecha_contratacion,fecha_baja,activo)
	VALUES (4,4,NOW(),NULL,1);
    