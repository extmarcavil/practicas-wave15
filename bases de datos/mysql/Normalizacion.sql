# Nombre Tipo
1 id_factura int(11)
2 fecha_factura date
3 forma_pago decimal(10,0)
4 IVA decimal(10,0)
5 cantidad int(11)
6 importe decimal(10,0)
7 nombre_cliente varchar(40)
8 apellido_cliente varchar(40)
9 direccion_cliente varchar(40)
10 descripcion_articulo varchar(40)


Normalizacion:

Tabla forma_pago
    forma_pago_id int
    forma_pago varchar(45)

Tabla factura
    id_factura int(11)
    fecha_factura date
    FK forma_pago_id int
    FK id_producto int

Tabla Cliente
    id_cliente int
    nombre_cliente varchar(40)
    apellido_cliente varchar(40)
    direccion_cliente varchar(40)
    FK id_factura INT(11)

Tabla Producto
    id_producto int(1)
    descripcion_articulo varchar(40)
    cantidad int(11)
    importe decimal(10,0)
    IVA decimal(10,0)


revise que entidades podia determinar a partir de esta primera Tabla
cree las tablas de las entidades que haya determinado
revise las relaciones que se pueden presentar entre las entidades planteadas y hacer las relaciones
revisar que se aplicaron la 1FN,2FN Y 3FN en las tablas correctamente y que no haya inconsistencias de datos u redundancias
