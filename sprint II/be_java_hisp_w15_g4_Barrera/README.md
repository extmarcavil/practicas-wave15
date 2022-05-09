
# Bootcamp Backend Java  - Sprint Nº 2 - Testing

## Objetivo

El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

### A. Escenario (Desarrollo GRUPAL)
SocialMeli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.
Para llevar a cabo estas implementaciones, se deberá tomar como base el proyecto desarrollado de forma grupal en el Sprint Nº 1. A partir de él, se llevarán a cabo cada una de las validaciones y tests unitarios correspondientes.
Como documentación de respaldo, un analista funcional adjunta el siguiente documento de requerimientos técnicos y funcionales: [Documentacion](https://docs.google.com/document/d/1f-M02GbaXRYO_g3zfcFqzoxZaM7Lg5WY/edit)

### Tests Realizados
- T-0001: Verificar que el usuario a seguir exista. (US-0001)
   + Se cumple: Permite continuar con normalidad.
   + No se cumple: Notifica la no existencia mediante una excepción.
- T-0002 Verificar que el usuario a dejar de seguir exista. (US-0007)
   + Se cumple: Permite continuar con normalidad.
   + No se cumple: Notifica la no existencia mediante una excepción.
- T-0003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)
   + Se cumple: Permite continuar con normalidad.
   + No se cumple: Notifica la no existencia mediante una excepción.
- T-0004 Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
   + Devuelve la lista ordenada según el criterio solicitado
- T-0005 Verificar que el tipo de ordenamiento por fecha exista (US-0009)
   + Se cumple: Permite continuar con normalidad.
   + No se cumple: Notifica la no existencia mediante una excepción.
- T-0006 Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
   + Devuelve la lista ordenada según el criterio solicitado
- T-0007 Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
   + Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.
- T-0008 Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)
   + Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.


### B. Requerimientos incrementales (Desarrollo INDIVIDUAL)
Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con la implementación de al menos un test de integración para lograr una cobertura de código mayor que la lograda con los tests unitarios.
Tener en cuenta que, se debe respetar el desarrollo base logrado en equipo para poder realizar este nuevo incremento de manera individual.


### C. Bonus  (Desarrollo Individual EXTRA)
El mismo especialista en calidad que sugirió implementar al menos un test de integración anteriormente, sugiere que sería ideal lograr contar con la implementación de otros tests de integración extra para intentar lograr un coverage mayor o igual al 75%.
El especialista conoce que los tiempos de desarrollo en bootcamp son acotados, por lo que sugiere llevar a cabo esta implementación solo en caso de que alcancen los tiempos y se pueda cumplir con la fecha de entrega estimada.

### Tests de integracion Realizados
#### Archivos:
- _UserControllerIntegrationTest_
   + folowersListOk(): Verifica que se estan cotando los seguidores del usuario correcto.
   + followUserOK(): Verifica que un usuario siga a otro de forma correcta.
   + alreadyFollowing(): Verifica que un usuario ya seguia a otro y devuelve un error.

- _ProductControllerIntegrationTest_
   + postProductOk(): Verifica que se crea un nuevo post de forma correcta.

Se alcanzo un inline coverage del 78%
