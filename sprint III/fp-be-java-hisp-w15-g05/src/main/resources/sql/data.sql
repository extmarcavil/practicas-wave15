INSERT INTO user_rol(`id`, `rol`)
values (1, "BUYER"),
       (2, "REP");

INSERT INTO user(`id`, `username`, `password`,`rol_id`)
values (1, "buyer", "123",1),
       (2, "rep", "123",2),
       (3, "max power", "123",1);

INSERT INTO warehouse
values
    (1,"Centro de distribucion 1");

INSERT INTO section_type
(`id`, `type`)
values
    (1,"FRESH"),
    (2,"FROZEN"),
    (3,"REFRIGERATED");

INSERT INTO section
(`section_id`,`warehouse_id`,`section_type_id`,`total_size`,`current_size`)

values
    (1,1,1,20,15),
    (2,1,2,20,5),
    (3,1,3,20,18);

INSERT INTO purchase_order
(`order_id`,`date`,`order_status`,`buyer_id`)
values
    (1,"2022-05-01","carrito",1),
    (2,"2022-05-01","carrito",2),
    (3,"2022-06-01","carrito",3),
    (4,"2022-06-03","carrito",1),
    (5,"2022-06-03","carrito",3);

INSERT INTO product
(`product_id`,`name`,`price`,`section_type_id`)
values
    (1,"leche",150,2),
    (2,"manteca",100,2),
    (3,"manzana",20,1),
    (4,"hamburguesa",300,3),
    (5,"cafe",250,1);

INSERT INTO purchase_order_product
(`purchase_order_prod_number`,`order_id`,`product_id`,`product_quantity`)
values
    (1,1,2,1),
    (2,2,3,3),
    (3,3,5,2),
    (4,4,1,3),
    (5,4,2,1),
    (6,5,4,5);

INSERT INTO inbound_order
values
    (1,"2022-04-01",1),
    (2,"2022-05-16",2),
    (3,"2022-05-16",3),
    (4,"2022-04-01",4),
    (5,"2022-04-01",5);

INSERT INTO batch
(`batch_number`,`section_id`,`product_id`,`due_date`,`initial_quantity`,`current_quantity`,`manufacturing_date`,`manufacturing_time`,`minimum_temperature`,`current_temperature`)
values

    (1,1,3,"2022-08-01",20,15,"2022-04-01","2022-04-01",10,12),
    (2,2,1,"2022-08-01",20,18,"2022-05-16","2022-05-16",0,2),
    (3,2,2,"2022-08-01",20,13,"2022-05-16","2022-05-16",0,2),
    (4,3,4,"2022-08-01",30,25,"2022-04-01","2022-04-01",-24,-10),
    (5,1,1,"2022-08-05",15,10,"2022-04-01","2022-04-01",10,12);

