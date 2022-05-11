USE empresa_db;

DROP TABLE IF EXISTS empresa_db.empleado;
DROP TABLE IF EXISTS empresa_db.departamento;

CREATE TABLE IF NOT EXISTS departamento(
	depto_nro VARCHAR(40),
    nombre_depto VARCHAR(40),
    localidad VARCHAR(40),
    PRIMARY KEY (depto_nro)
);

CREATE TABLE IF NOT EXISTS empleado(
	cod_emp VARCHAR(40),
    nombre VARCHAR(40),
    apellido VARCHAR(40),
    puesto VARCHAR(40),
    fecha_alta DATE,
    salario INT,
    comision INT,
    depto_nro VARCHAR(40),
    PRIMARY KEY (cod_emp),
    FOREIGN KEY (depto_nro) REFERENCES empresa_db.departamento(depto_nro)
);

INSERT INTO departamento VALUES ( 'D-000-1','Software','Los Tigres');
INSERT INTO departamento VALUES ( 'D-000-2','Sistemas','Guadalupe');
INSERT INTO departamento VALUES ( 'D-000-3','Contabilidad','La Roca');
INSERT INTO departamento VALUES ( 'D-000-4','Ventas','Plata');

INSERT INTO empleado VALUES ( "E-0001","César","Piñero","Vendedor","2018-05-12",80000,15000,"D-000-4");
INSERT INTO empleado VALUES ( "E-0002","Yosep","Kowaleski","Analista","2015-07-14",140000,0,"D-000-2");
INSERT INTO empleado VALUES ( "E-0003","Mariela","Barrios","Director","2014-06-05",185000,0,"D-000-3");
INSERT INTO empleado VALUES ( "E-0004","Jonathan","Aguilera","Vendedor","2015-06-03",85000,10000,"D-000-4");
INSERT INTO empleado VALUES ( "E-0005","Daniel","Brezezicki","Vendedor","2018-03-03",83000,10000,"D-000-4");
INSERT INTO empleado VALUES ( "E-0006","Mito","Barchuk","Presidente","2014-06-05",190000,0,"D-000-3");
INSERT INTO empleado VALUES ( "E-0007","Emilio","Galarza","Desarrollador","2014-08-02",60000,0,"D-000-1");

