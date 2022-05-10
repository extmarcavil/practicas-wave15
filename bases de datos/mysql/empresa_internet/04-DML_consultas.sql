use empresa_internet;
#Consultas
#Obtiene los clientes que son de la provincia GAM
SELECT 	id_cliente
		nombre,
        apellido,
        fecha_nacimiento,
        provincia,
        ciudad
FROM 	cliente
WHERE   provincia = 'GAM';

#Obtiene catalogo de todos los planes que se ofrecen
SELECT 	id_plan,
		descripcion,
        ROUND(velocidad_transferencia / 1024) as velocidadEnGB,
        precio,
        descuento
FROM	plan;

 #Obtener los planes que tengan un descuento mayor a cero
 SELECT 	id_plan,
		descripcion,
        ROUND(velocidad_transferencia / 1024) as velocidadEnGB,
        precio,
        descuento
FROM	plan
WHERE   descuento > 0.0;


#Obtiene los planes en un rango de precios entre 400 y 600 pesos mexicanos,ordenados por precio de forma ascendente
SELECT 		id_plan,
			descripcion,
			ROUND(velocidad_transferencia / 1024) as velocidadEnGB,
			precio,
			descuento
FROM		plan
WHERE   	precio BETWEEN 400 AND 600
ORDER BY	precio ASC;



#Obtiene el plan con mayor velocidad que se tiene OFERTADO
SELECT 		id_plan,
			descripcion,
			ROUND(velocidad_transferencia / 1024) as velocidadEnGB,
			precio,
			descuento
FROM		plan
ORDER BY	precio DESC
LIMIT 1;


#Obtiene el plan con menor velocidad que se tiene OFERTADO
SELECT 		id_plan,
			descripcion,
			ROUND(velocidad_transferencia / 1024) as velocidadEnGB,
			precio,
			descuento
FROM		plan
ORDER BY	precio ASC
LIMIT 1;

#Obtener toda la informacion de la tabla plan_cliente
SELECT  id_plan_cliente,
		id_plan,
        id_cliente,
        fecha_contratacion,
        fecha_baja,
        activo
 FROM 	plan_cliente;
 
 #Obtener el nombre, apellido del cliente asi como el nombre del plan,velocidad y costo quien tenga un plan contratado
 SELECT 		c.nombre,
				c.apellido,
                p.descripcion,
                ROUND(p.velocidad_transferencia / 1024) as velocidadEnGB,
                p.precio
 FROM 			plan_cliente AS pc
 INNER JOIN		cliente c ON pc.id_cliente = c.id_cliente
 INNER JOIN     plan p   ON pc.id_plan = p.id_plan;
 
 
  #Obtener el nombre, apellido del cliente asi como el nombre del plan,velocidad y costo quien tenga un plan contratado
  # y el plan tenga una velocidad mayor a 2 gb
 SELECT 		c.nombre,
				c.apellido,
                p.descripcion,
                ROUND(p.velocidad_transferencia / 1024) as velocidadEnGB,
                p.precio
 FROM 			plan_cliente AS pc
 INNER JOIN		cliente c ON pc.id_cliente = c.id_cliente
 INNER JOIN     plan p   ON pc.id_plan = p.id_plan
 WHERE          ROUND(p.velocidad_transferencia / 1024) > 2;
 
 
 #Obtener en un solo campo nombre y apellido con alias nombreCompleto, velocidad en GB y nombre del plan
 #que tengan un plan contratado bootcamp
 SELECT 		CONCAT(c.nombre,' ',c.apellido) as nombreCompleto,
                p.descripcion,
                ROUND(p.velocidad_transferencia / 1024) as velocidadEnGB
 FROM 			plan_cliente AS pc
 INNER JOIN		cliente c 	ON pc.id_cliente = c.id_cliente
 INNER JOIN     plan p   	ON pc.id_plan = p.id_plan
 WHERE          p.descripcion LIKE '%bootcamp%'
 