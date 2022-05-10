SET SQL_SAFE_UPDATES = 0;
drop table cliente;
create table cliente(
	dni int not null,
	nombre varchar(20),
	apellido varchar(20),
	ciudad varchar(20),
	provincia varchar(20),
	fchnac date,
	primary key (dni)
);
drop table plan;
create table plan (
	id int not null auto_increment,
	megas varchar(10),
	precio decimal(10,2),
	descuento decimal(10,2),
	primary key (id)
);
drop table cliente_plan;
create table cliente_plan (
	dni int not null,
	id int not null,
	primary key (dni,id)
);

insert into cliente (dni,nombre,apellido,ciudad,provincia,fchnac)
values (11111111,"cliente1","apellido1","ciudad1","provincia1","2022-05-1"),
		(11111112,"cliente2","apellido2","ciudad2","provincia2","2022-05-2"),
		(11111113,"cliente3","apellido3","ciudad3","provincia3","2022-05-3"),
		(11111114,"cliente4","apellido4","ciudad4","provincia4","2022-05-4"),
		(11111115,"cliente5","apellido5","ciudad5","provincia5","2022-05-5"),
		(11111116,"cliente6","apellido6","ciudad6","provincia6","2022-05-6"),
		(11111117,"cliente7","apellido7","ciudad7","provincia7","2022-05-7"),
		(11111118,"cliente8","apellido8","ciudad8","provincia8","2022-05-8"),
		(11111119,"cliente9","apellido9","ciudad9","provincia9","2022-05-9"),
		(11111110,"cliente10","apellido10","ciudad10","provincia10","2022-05-10");
        
insert into plan (megas,precio,descuento)
values ("1",2000,500),
		("2",3000,500),
		("3",4000,300),
		("4",5000,500),
		("5",6000,100);
        
delete from cliente_plan;
insert into cliente_plan (dni,id) 
values (11111112,2),
		(11111113,3),
		(11111114,1),
		(11111115,1),
		(11111116,5),
		(11111117,5),
		(11111118,1),
		(11111119,2),
		(11111119,3),
		(11111119,4),
		(11111110,4);
/* Todos los clientes */
select * from cliente;
/* Todos los planes */
select * from plan;
/* Todos los clientes con fecha de nacimiento mayor a 2022-05-05 */
select * from cliente where fchnac>"2022-05-05";
/* Todos los datos del los clientes con planes asociados */
select c.* from cliente_plan cp inner join cliente c on c.dni=cp.dni;
/* Todos los datos de los planes con clientes asociados */
select p.* from cliente_plan cp inner join plan p on p.id=cp.id;
/* Todos los datos de los clientes y planes asociados */
select c.*,p.* from cliente_plan cp inner join plan p on p.id=cp.id inner join cliente c on cp.dni=c.dni;
/* Todos los datos de los clientes con mas de 4 megas contratados*/
select c.*,p.* from cliente_plan cp inner join plan p on p.id=cp.id inner join cliente c on cp.dni=c.dni
 where p.megas>4;
 /* Todos los datos de los clientes con mas de $200 de descuento*/
select c.dni,c.nombre,p.descuento from cliente_plan cp inner join plan p on p.id=cp.id inner join cliente c on cp.dni=c.dni
 where p.descuento>200;
/* Cuantos clientes tiene asociado cada plan*/
select p.id plan,count(*) cantidad_clientes from cliente_plan cp inner join plan p on p.id=cp.id inner join cliente c on cp.dni=c.dni
 group by (p.id);
 /* Que planes tienen 3 o mas clientes asociados*/
select p.id plan,count(*) cantidad_clientes from cliente_plan cp inner join plan p on p.id=cp.id inner join cliente c on cp.dni=c.dni
 group by (p.id) having cantidad_clientes>=3;