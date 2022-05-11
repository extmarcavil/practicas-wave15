CREATE DATABASE facturacion_db;
USE facturacion_db;


#Se normaliza separando datos de clientes,esto con el fin de tener integridad y atomicidad en los datos
CREATE TABLE cliente(
id_cliente INT NOT NULL AUTO_INCREMENT,
nombre_cliente VARCHAR(40) NOT NULL,
apellido_cliente VARCHAR(40) NOT NULL,
direccion_cliente VARCHAR(40) NOT NULL,
PRIMARY KEY (id_cliente));

#Se trae el id_cliente que funge como un FK ,para cumplir un 3FN
CREATE TABLE factura(
id_factura INT NOT NULL AUTO_INCREMENT,
id_cliente INT NOT NULL,
fecha_factura DATE NOT NULL,
forma_pago DECIMAL(10,0) NOT NULL,
IVA DECIMAL(10,0) NOT NULL,
cantidad INT NOT NULL,
importe DECIMAL(10,0) NOT NULL,
descripcion_articulo VARCHAR(40) NOT NULL,
PRIMARY KEY (id_factura),
CONSTRAINT fk_cliente_factua FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente));
