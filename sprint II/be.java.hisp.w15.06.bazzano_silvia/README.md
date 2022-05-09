El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.​​​​

Requerimientos:

Requerimientos incrementales (Desarrollo INDIVIDUAL): 

Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con la implementación de al menos un test de integración para lograr una cobertura de código mayor que la lograda con los tests unitarios.
Tener en cuenta que, se debe respetar el desarrollo base logrado en equipo para poder realizar este nuevo incremento de manera individual.

Bonus (Desarrollo Individual EXTRA) :

El mismo especialista en calidad que sugirió implementar al menos un test de integración anteriormente, sugiere que sería ideal lograr contar con la implementación de otros tests de integración extra para intentar lograr un coverage mayor o igual al 75%. El especialista conoce que los tiempos de desarrollo en bootcamp son acotados, por lo que sugiere llevar a cabo esta implementación solo en caso de que alcancen los tiempos y se pueda cumplir con la fecha de entrega estimada.

Requerimientos implementados: 

US-0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
US-0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
US-0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
US-0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

Miembros grupo 6:

Alvarez, Matias;
Bazzano, Silvia;
Leonetti, Julieta;
Pichetti, Gonzalo;
Vilte, Ali;
Vitale, Nicolás;

Consideraciones

- El código se ha definido que se escriba en inglés para mantener su coherencia.
- Se decidió que los usuarios tendrán dos listas (Followed and Followers).
- Se decidió que los POST serán valores de User.
- Utilizamos @DefaultValue por delante de @QueryParam.
- Distincion de paquetes dentro de DTO para response y request.
- Utilizamos SuccessDTO para enviar los mensajes de éxito.
- Por convención, se decidió utilizar DTO en mayúscula en todos los casos.
- Hicimos el mapper a mano.

Github Links:

https://github.com/extmarcavil/practicas-wave15/tree/leonetti_julieta/
https://github.com/extmarcavil/practicas-wave15/tree/vilte_ali/
https://github.com/extmarcavil/practicas-wave15/tree/bazzano_silvia/
https://github.com/extmarcavil/practicas-wave15/tree/pichetti_gonzalo/
https://github.com/extmarcavil/practicas-wave15/tree/alvarez_matias/
https://github.com/extmarcavil/practicas-wave15/tree/vitale_nicolas