#EJERCICIO 3
#Punto A
#Create database "empresa_internet"
CREATE DATABASE IF NOT EXISTS empresa_internet;

SET SQL_SAFE_UPDATES = 0;

#Create table "client" 
CREATE TABLE IF NOT EXISTS empresa_internet.client(
	client_id int,
    dni varchar(45),
    first_name varchar(45),
    last_name varchar(45),
    birthday date,
    province varchar(45),
    city varchar(45),
    primary key (client_id)
);

#Create table "plan_internet"
CREATE TABLE IF NOT EXISTS empresa_internet.internet_plan(
	plan_id int,
    speed float,
    price float,
    discount float,
    primary key (plan_id)
);

#Create table "client_planInternet with FK (foreign key), many to many
CREATE TABLE IF NOT EXISTS empresa_internet.cliente_internetPlan(
	client_internetPlan int,
    client_id int,
    plan_id int,
    PRIMARY KEY (client_internetPlan),
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (plan_id) REFERENCES internet_plan(plan_id)
);

# Punto B
#Load clients data
INSERT INTO empresa_internet.client VALUES
	(1,"11111","ClientName1","ClientSurname1","1996-06-11","Buenos Aires", "Bahia Blanca"),
	(2,"22222","ClientName2","ClientSurname2","1995-10-19","San Luis", "San Luis"),	
	(3,"33333","ClientName3","ClientSurname3","1999-11-21","Santa fe", "Rosario"),    
	(4,"44444","ClientName4","ClientSurname4","2001-02-07","San Luis", "Merlo"),
    (5,"55555","ClientName5","ClientSurname5","1999-05-15","Buenos Aires", "La plata"),
    (6,"66666","ClientName6","ClientSurname6","1978-08-21","Cordoba", "Cordoba"),
    (7,"77777","ClientName7","ClientSurname7","1964-01-2","Cordoba", "Rio cuarto"),
    (8,"88888","ClientName8","ClientSurname8","1986-05-25","La pampa", "Santa rosa"),
    (9,"99999","ClientName9","ClientSurname9","2003-12-2","Buenos Aires", "CABA"),
    (10,"1010101010","ClientName10","ClientSurname10","1999-02-11","Buenos Aires", "Pergamino")
    
#Load Internet plan data
INSERT INTO empresa_internet.internet_plan VALUES
	(1,10,1000,0),
    (2,20,2000,0),
    (3,50,5000,0),
    (4,70,7500,0),
    (5,1000,8000,10)
    
#Load relationship data
INSERT INTO empresa_internet.client_internetPlan VALUES
	(1,2,1),
    (2,3,5),
    (3,4,1),
    (4,1,,3),
    (5,2,2)
    
    
    
#EJERCICIO 4
#Generate queries

#1. List all the clients
SELECT * FROM empresa_internet.client;

#2. List all the plans
SELECT * FROM empresa_internet.internet_plan;

#3. List name and surname of Buenos Aires clients
SELECT client.first_name, client.last_name, client.province FROM empresa_internet.client AS client 
WHERE client.province = "Buenos Aires";

#4. List plans under 3000
SELECT * FROM empresa_internet.internet_plan 
WHERE price < 3000;

#5. List plan with higher speed
SELECT * FROM empresa_internet.internet_plan
WHERE speed = (SELECT MAX(speed));

#6. Update table: Modify price of ID 5
UPDATE empresa_internet.internet_plan SET price = "12000" WHERE plan_id = 5;

#7. Create Index over table "internet_plan"
ALTER TABLE `empresa_internet`.`internet_plan`
ADD INDEX `plan_id`(`Plan_id` ASC) VISIBLE;

#8. List price by order desc
SELECT * FROM empresa_internet.internet_plan AS plan
ORDER BY price DESC;

#9. List clients with birthday between 1995 and 2000
SELECT * FROM empresa_internet.client
WHERE birthday BETWEEN "1995-1-1" AND "2000-12-31";

#10. List clients born after 1990
SELECT * FROM empresa_internet.client
WHERE birthday > "1990-12-31";
    
    