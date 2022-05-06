# SocialMeli
## Quality
### Tests unitarios (Parte A)
- [x] **T-0001:** Verificar que el usuario a seguir exista. (US-0001)
- [x] **T-0002:** Verificar que el usuario a dejar de seguir exista. (US-0007)
- [x] **T-0003:** Verificar que el tipo de ordenamiento alfabético exista (US-0008)
- [x] **T-0004:** Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
- [x] **T-0005:** Verificar que el tipo de ordenamiento por fecha exista (US-0009)
- [x] **T-0006:** Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
- [x] **T-0007:** Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
- [x] **T-0008:** Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)

### Tests de integración

#### Obligatorios (Parte B)
- [x] **POST /{userId}/follow/{userIdToFollow}:** US-0001 - Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
  
#### Bonus (Parte C)
- [x] **GET /users/{userId}/followers/count:** US-0002 - Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- [x] **GET /users/{userId}/followers/list:** US-0003 y US-0008 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?) y ordenar alfabeticamente (ascendente, descendente)
- [x] **GET /users/{userId}/followed/list:**  US-0004 y US-0008 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?) y ordenar alfabeticamente (ascendente, descendente)
- [x] **POST /products/post** US-0005 - Dar de alta una nueva publicación.
- [x] **GET /products/followed/{userId}/list** US-0006 - Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero) y ordenar por fecha (ascendente, descendente).
- [x] **POST /users/{userId}/unfollow/{userIdToUnfollow}** US-0007 - Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.


