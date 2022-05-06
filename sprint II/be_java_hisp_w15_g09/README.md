# README

## Sprint II - SocialMeli

### Resumen:

#### A) ESCENARIO (DESARROLLO GRUPAL)
SocialMeli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.
Para llevar a cabo estas implementaciones, se deberá tomar como base el proyecto desarrollado de forma grupal en el Sprint Nº 1. A partir de él, se llevarán a cabo cada una de las validaciones y tests unitarios correspondientes.
Como documentación de respaldo, un analista funcional adjunta el siguiente documento de requerimientos técnicos y funcionales: [Documentación](https://docs.google.com/document/d/1f-M02GbaXRYO_g3zfcFqzoxZaM7Lg5WY/edit)

#### - VALIDACIONES
| DATO / PARAMETRO| ¿OBLIGATORIO? | VALIDACIÓN | MENSAJE DE ERROR |
| ------ | ------ | ------ | ------ |
| user_id | SI | Que el campo no este vacío + Mayor a 0. | El id no puede estar vacío + El id debe ser mayor a 0. |
| id_post | SI | Que el campo no este vacío + Mayor a 0. | El id_post no puede estar vacío + El id_post debe ser mayor a 0. |
| date | SI | Que el campo no este vacío | La fecha no puede estar vacía.
| product_id | SI | Que el campo no este vacío + Mayor a 0. | El id no puede estar vacío + El id debe ser mayor a 0. |
| product_name | SI | Que el campo no este vacío + Longitud máxima de 40 caracteres + Que no posea caracteres especiales (%, &, $, etc). | El campo no puede estar vacío + La longitud no puede superar los 40 caracteres + El campo no puede poseer caracteres especiales. |
| type | SI | Que el campo no este vacío + Longitud máxima de 15 caracteres + Que no posea caracteres especiales (%, &, $, etc). | El campo no puede estar vacío + La longitud no puede superar los 15 caracteres + El campo no puede poseer caracteres especiales. |
| brand | SI | Que el campo no este vacío + Longitud máxima de 25 caracteres + Que no posea caracteres especiales (%, &, $, etc). | El campo no puede estar vacío + La longitud no puede superar los 25 caracteres + El campo no puede poseer caracteres especiales. |
| color | SI | Que el campo no este vacío + Longitud máxima de 15 caracteres + Que no posea caracteres especiales (%, &, $, etc). | El campo no puede estar vacío + La longitud no puede superar los 15 caracteres + El campo no puede poseer caracteres especiales. |
| notes | NO | Longitud máxima de 80 caracteres + Que no posea caracteres especiales (%, &, $, etc). | La longitud no puede superar los 80 caracteres + El campo no puede poseer caracteres especiales. |
| category | SI | Que el campo no este vacío | El campo no puede estar vacío |
| category | SI | Que el campo no este vacío | El campo no puede estar vacío |

#### - TESTS UNITARIOS
| TESTS| SITUACIONES DE ENTRADA | COMPORTAMIENTO ESPERADO |
| ------ | ------ | ------ |
| T-0001 | Verificar que el usuario a seguir exista. (US-0001) | Se cumple: Permite continuar con normalidad. + No se cumple: Notifica la no existencia mediante una excepción. |
| T-0002 | Verificar que el usuario a dejar de seguir exista. (US-0007) | Se cumple: Permite continuar con normalidad. + No se cumple: Notifica la no existencia mediante una excepción. | 
| T-0003 | Verificar que el tipo de ordenamiento alfabético exista (US-0008) | Se cumple: Permite continuar con normalidad. + No se cumple: Notifica la no existencia mediante una excepción. | 
| T-0004 | Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008) | Devuelve la lista ordenada según el criterio solicitado| 
| T-0005 | Verificar que el tipo de ordenamiento por fecha exista (US-0009) | Se cumple: Permite continuar con normalidad. + No se cumple: Notifica la no existencia mediante una excepción. |
| T-0006 | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009) | Devuelve la lista ordenada según el criterio solicitado | 
| T-0007 | Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002) | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario. | 
| T-0008 | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006) | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | 



#### - COLABORADORES POR REQUERIMIENTOS GRUPALES:
* T-0001, T-0002: Lorena Maciel Bitencur y Alejandro Ivan Henestroza.
* T-0003, T-0004, T-0006: Gonzalo Murias y Ramiro Augusto Vera Guzman.
* T-0005, T-0007, T-0008: Alan Leonel Gimenez y Nicolás Leonardo Kazandjian.


