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
### Tests de Integración (Parte B - Bonus C)
- [x] /users/{userId}/followers/count -> trae la cantidad de followers del usuario pasado por param
- [x] /users/{userId}/followers/count -> lanza excepción cuando no encuentra el usuario
- [x] /users/{userId}/follow/{userIdToFollow} -> devuelve un OK al intentar seguir un usuario
- [x] /users/{userId}/follow/{userIdToFollow} -> lanza una excepción si el usuario no existe
- [x] /users/{userId}/followers/list -> un usuario obtiene su lista de seguidores
- [x] /products/post -> agrega correctamente un nuevo POST a un usuario
- [x] /products/post -> lanza excepción al intentar agregar usuario con payload incompleto
