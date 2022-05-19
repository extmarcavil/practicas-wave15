SELECT  * from customer c 

select * from internet_plan;
INSERT INTO internet_plan VALUES(1, 100, 2600, 0.5 );
INSERT INTO internet_plan VALUES(2, 50, 2600, 0.6);
INSERT INTO internet_plan VALUES(3, 200, 2600, 0.2 );
INSERT INTO internet_plan VALUES(4, 1000, 2600, 0.25);
INSERT INTO internet_plan VALUES(5, 100, 2600, 0.15 );
INSERT INTO internet_plan VALUES(6, 20, 1200, 0.45 );
INSERT INTO internet_plan VALUES(7, 10, 700, 0.00 );


INSERT INTO customer VALUES  (1, '33445678', 'Facundo', 'Cardenas', '1997-06-23', 'Buenos Aires', 'Jose C. Paz', 1);
INSERT INTO customer VALUES  (2,  '56442112', 'Pablo', 'Ortigoza', '1981-01-22', 'Santa Fe', 'Rosario', 1);
INSERT INTO customer VALUES  (3,  '22356120', 'Jose', 'Perez', '2001-08-02', 'Buenos Aires', 'La Matanza', 2);
INSERT INTO customer VALUES  (4,  '40912587' ,'Sebastian', 'Fernandez', '2002-02-22', 'Buenos Aires', 'Pilar', 4);
INSERT INTO customer VALUES  (5,  '12778901' ,'Fernando', 'Azaroso', '2001-10-11', 'Buenos Aires', 'Rafael Castillo', 4);
INSERT INTO customer VALUES  (6,  '34567889' ,'Sebastian', 'Driussi', '1972-05-25', 'Buenos Aires', 'San Miguel', 3);
INSERT INTO customer VALUES  (7,  '37816456' ,'Ariel', 'Ortega', '1999-07-04', 'Buenos Aires', 'San Martin', 3);


select * FROM  internet_plan ip  where price > 2000;

#Mostrar nombre del cliente y su velocidad de internet con el plan contratado cuando  el precio de su plan  sea menor a 2000.

SELECT c.first_name , ip.speed_megabits  from internet_plan ip INNER JOIN customer c ON  c.id  = ip.id 
WHERE ip.price  <2000;


#Mostrar los 3 clientes con mayor velocidad de intermet

SELECT  * from customer c  INNER JOIN internet_plan ip  on ip.id  = c.id ORDER BY  ip.speed_megabits DESC LIMIT 3;

