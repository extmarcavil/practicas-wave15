# Sprint 2
# Introduccion

SocialMeli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con la implementación de al menos un test de integración para lograr una cobertura de código mayor que la lograda con los tests unitarios.

### COVERAGE ALCANZADO: 86%

[ANALISIS DE COVERAGE](http://htmlpreview.github.io/?https://github.com/extmarcavil/practicas-wave15/blob/sinnott_gonzalo/sprint%20II/be_java_hisp_w15_g01_sinnott_gonzalo/jacoco/index.html)

## TEST UNITARIOS 

## End-point: T-0001
Verificar que el usuario a seguir exista. (US-0001)


### Comportamiento esperado
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.


## End-point: T-0002
Verificar que el usuario a dejar de seguir exista. (US-0007)

### Comportamiento esperado
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.



## End-point: T-0003
Verificar que el tipo de ordenamiento alfabético exista (US-0008)

### Comportamiento esperado
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.


## End-point: T-0004
Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)

### Comportamiento esperado
Devuelve la lista ordenada según el criterio solicitado


## End-point: T-0005
Verificar que el tipo de ordenamiento por fecha exista (US-0009)

### Comportamiento esperado
Se cumple:
Permite continuar con normalidad.

No se cumple:
Notifica la no existencia mediante una excepción.



## End-point: T-0006
Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)

### Comportamiento esperado
Devuelve la lista ordenada según el criterio solicitado


## End-point: T-0007
Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)

### Comportamiento esperado
Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.


## End-point: T-0008
Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)

### Comportamiento esperado
Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.

## TEST DE INTEGRACION

### test_integration_createPost()
Evalua el Endpoint "/products/post"

### test_integration_followUserValidUser() y test_integration_followUserNotValidUser()
Evaluan el Endpoint "/users/{userId}/follow/{userIdToFollow}"
