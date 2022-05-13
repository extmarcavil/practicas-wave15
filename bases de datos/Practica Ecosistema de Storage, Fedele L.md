Practica Ecosistema de Storage, Fedele Lucas, Bootcamp Backend Java w15

Ejercicio 1)

Elijo Object Storage porque lo dice el arbol de desicion :(

Ejercicio 2)

Yo usaria RDBMS, porque no son binarios, se van a acceder con frecencia, me gustaria tener 
escalabilidad horizontanl y a su vez me gustaria que se le puedan realizar querys complejas,
para no limitar a mi ecosistema a buscarlos solos por id, si no tambien por ranking de ventas,
acciones sospechosas, marcas que contenga el usuario y un sin fin de casos de uso mas

Caso de uso 1)

Yo implementaria un CDC en la tabla de carritos y haria que la API de Growth se subscriba a 
el evento de capturar carritos insertados, detectar quien es el usuario y pushear la notificacion

Caso de uso 2)

Yo creo que habria que analizar la posibilidad de si buscarlos por categoria puede evolucionar
en el futuro a querys mas complejas, si la respuesta es si, evaluaria migrar a RDBMS

Si no va a evolucionar o si se decide que por el momento no es una prioridad. Se podria 
implementar, ademas del par kv items, otro par kv categorias, siendo k nombre o codigo de 
categoria (habria que analizar bien el dominio para saberlo) y v una coleccion de claves de 
items. 
Claro que si bien esta solucion no implica migrar toda una base de datos, si 
representa una complejidad extra a la hora de agregar y borrar items.

Caso de uso 3)

Utilizaria el servicio de Object Storage de fury, que te genera un dump del KVS y asi poder
operarlo

Caso de uso 4)

Respuesta similar al Caso de uso 1 pero utilizando el BigQueue de Fury para KVS