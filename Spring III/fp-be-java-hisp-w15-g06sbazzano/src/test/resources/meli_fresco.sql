INSERT INTO roles (id, rol) VALUES (1, 'ADMIN')
;
INSERT INTO roles (id, rol) VALUES (2, 'BUYER')
;
INSERT INTO users (id, username, password, rol_id) VALUES (1, 'user 1', 1234, 1);
INSERT INTO users (id, username, password, rol_id) VALUES (2, 'user 2', 1234, 2);
INSERT INTO agents (id, user_id) VALUES (1, 1);
INSERT INTO buyers (id, user_id) VALUES (1, 2);
INSERT INTO warehouses (id, name, agent_id) VALUES (1, 'Almacén 1', 1);
INSERT INTO products (id, category, name, price) VALUES (1,'RF', 'Leche', 10);
INSERT INTO products (id, category, name, price) VALUES (2, 'RF', 'Mantenca', 5);
INSERT INTO products (id, category, name, price) VALUES (3, 'RF', 'Carne', 20);
INSERT INTO products (id, category, name, price) VALUES (4, 'RF', 'Queso', 14);
INSERT INTO products (id, category, name, price) VALUES (5, 'RF', 'Yogurt', 4.40);
INSERT INTO products (id, category, name, price) VALUES (6, 'FS', 'Lechuga', 2);
INSERT INTO products (id, category, name, price) VALUES (7, 'FS', 'Papa', 1.5);
INSERT INTO products (id, category, name, price) VALUES (8, 'FS', 'Tomate', 1.5);
INSERT INTO products (id, category, name, price) VALUES (9, 'FF', 'Helado', 19.5);
INSERT INTO sections (id, category, max_quantity_batch, minimum_temperature, maximum_temperature) VALUES (1, 'FS', 5, 11, 15);
INSERT INTO sections (id, category, max_quantity_batch, minimum_temperature, maximum_temperature) VALUES (2, 'RF', 5, 6, 10);
INSERT INTO sections (id, category, max_quantity_batch, minimum_temperature, maximum_temperature) VALUES (3, 'FF', 5, 0, 5);
INSERT INTO inbound_orders (id, order_date, section_id, warehouse_id, agent_id) VALUES (1, '2022-06-03', 1, 1, 1);
INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                     manufacturing_time, due_date, product_id, inbound_order_id)
VALUES (1, 11, 14, 100, 100, '2022-05-01 00:00:01', '2022-07-10', 1, 1);
INSERT INTO batches (id, minimum_temperature, current_temperature, initial_quantity, current_quantity,
                     manufacturing_time, due_date, product_id, inbound_order_id)
VALUES (2, 11, 14, 100, 100, '2022-05-01 00:00:01', '2022-07-10', 2, 1);