INSERT INTO roles (id, rol) VALUES (1, 'ADMIN')
    ON DUPLICATE KEY UPDATE rol = 'ADMIN';

INSERT INTO roles (id, rol) VALUES (2, 'BUYER')
    ON DUPLICATE KEY UPDATE rol = 'BUYER';

INSERT INTO users (id, username, password, rol_id) VALUES (1, 'user 1', 1234, 1)
    ON DUPLICATE KEY UPDATE username = 'user 1';

INSERT INTO users (id, username, password, rol_id) VALUES (2, 'user 2', 1234, 2)
    ON DUPLICATE KEY UPDATE username = 'user 2';

INSERT INTO agents (id, user_id) VALUES (1, 1);

INSERT INTO buyers (id, user_id) VALUES (1, 2);

INSERT INTO warehouses (id, name, agent_id) VALUES (1, 'Almacén 1', 1)
    ON DUPLICATE KEY UPDATE name = 'Almacén 1', agent_id = 1;

INSERT INTO products (id, category, name, price) VALUES (1,'RF', 'Leche', 10)
    ON DUPLICATE KEY UPDATE name = 'Leche';

INSERT INTO products (id, category, name, price) VALUES (2, 'RF', 'Mantenca', 5)
    ON DUPLICATE KEY UPDATE name = 'Manteca';

INSERT INTO products (id, category, name, price) VALUES (3, 'RF', 'Carne', 20)
    ON DUPLICATE KEY UPDATE name = 'Carne';

INSERT INTO products (id, category, name, price) VALUES (4, 'RF', 'Queso', 14)
    ON DUPLICATE KEY UPDATE name = 'Queso';

INSERT INTO products (id, category, name, price) VALUES (5, 'RF', 'Yogurt', 4.40)
    ON DUPLICATE KEY UPDATE name = 'Yogurt';

INSERT INTO products (id, category, name, price) VALUES (6, 'FS', 'Lechuga', 2)
    ON DUPLICATE KEY UPDATE name = 'Lechuga';

INSERT INTO products (id, category, name, price) VALUES (7, 'FS', 'Papa', 1.5)
    ON DUPLICATE KEY UPDATE name = 'Papa';

INSERT INTO products (id, category, name, price) VALUES (8, 'FS', 'Tomate', 1.5)
    ON DUPLICATE KEY UPDATE name = 'Tomate';



INSERT INTO sections (id, category, max_quantity_batch, minimum_temperature, maximum_temperature) VALUES (1, 'FS', 5, 11, 15)
    ON DUPLICATE KEY UPDATE category = 'FS', max_quantity_batch = 5, minimum_temperature = 11, maximum_temperature = 15;

INSERT INTO sections (id,  category, max_quantity_batch, minimum_temperature, maximum_temperature) VALUES (2, 'RF', 5, 6, 10)
    ON DUPLICATE KEY UPDATE category = 'RF', max_quantity_batch = 5, minimum_temperature = 6, maximum_temperature = 10;

INSERT INTO sections (id, category, max_quantity_batch, minimum_temperature, maximum_temperature) VALUES (3, 'FF', 5, 0, 5)
    ON DUPLICATE KEY UPDATE category = 'FF', max_quantity_batch = 5, minimum_temperature = 0, maximum_temperature = 5;



INSERT INTO inbound_orders (id, order_date, section_id, warehouse_id, agent_id) VALUES (1, '2022-06-03', 1, 1, 1)
    ON DUPLICATE KEY UPDATE order_date = '2022-06-03', section_id = 1, warehouse_id = 1, agent_id = 1;

INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                      manufacturing_time, due_date, product_id, inbound_order_id, section_id)
VALUES (1, 11, 14, 100, 100, '2022-05-01 00:00:01', '2022-07-10', 1, 1, 2)
    ON DUPLICATE KEY UPDATE minimum_temperature = 11, current_temperature = 14, initial_quantity = 100, current_quantity = 100,
                         manufacturing_time = '2022-05-01 00:00:01', due_date = '2022-12-01', product_id = 1, inbound_order_id = 1;

INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                     manufacturing_time, due_date, product_id, inbound_order_id, section_id)
VALUES (3, 11, 14, 300, 100, '2022-05-01 00:00:01', '2022-08-10', 1, 1, 1)
    ON DUPLICATE KEY UPDATE minimum_temperature = 11, current_temperature = 14, initial_quantity = 100, current_quantity = 100,
                         manufacturing_time = '2022-05-01 00:00:01', due_date = '2022-12-01', product_id = 1, inbound_order_id = 1;

INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                     manufacturing_time, due_date, product_id, inbound_order_id, section_id)
VALUES (4, 11, 14, 300, 50, '2022-05-01 00:00:01', '2022-09-10', 1, 1, 1)
    ON DUPLICATE KEY UPDATE minimum_temperature = 11, current_temperature = 14, initial_quantity = 100, current_quantity = 100,
                         manufacturing_time = '2022-05-01 00:00:01', due_date = '2022-12-01', product_id = 1, inbound_order_id = 1;

INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                     manufacturing_time, due_date, product_id, inbound_order_id, section_id )
VALUES (2, 11, 14, 100, 100, '2022-05-01 00:00:01', '2022-07-10', 2, 1, 1)
    ON DUPLICATE KEY UPDATE minimum_temperature = 11, current_temperature = 14, initial_quantity = 100, current_quantity = 100,
                         manufacturing_time = '2022-05-01 00:00:01', due_date = '2022-12-01', product_id = 2, inbound_order_id = 1;

INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                     manufacturing_time, due_date, product_id, inbound_order_id, section_id)
VALUES (5, 11, 14, 100, 100, '2022-05-01 00:00:01', '2022-05-10', 2, 1, 1)
    ON DUPLICATE KEY UPDATE minimum_temperature = 11, current_temperature = 14, initial_quantity = 100, current_quantity = 100,
                         manufacturing_time = '2022-05-01 00:00:01', due_date = '2022-12-01', product_id = 1, inbound_order_id = 1;
