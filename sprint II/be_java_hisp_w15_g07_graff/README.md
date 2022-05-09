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

## Test de Integración
### Obligatorio (Parte B)
- [x] **GET /users/{userId}/followers/count** prueba el retorno de la cuenta de seguiores.

### Bonus (Parte C)
**INTEGRACION**
- [x] **GET /users/{userId}/followers/list** prueba que se retorna correctamente la lista de seguidores.
- [x] **GET /users/{userId}/followers/count** prueba la exception cuando un user no es encontrado.
**UNITARIOS**
- [x] **TBONUS - PostServiceTest** Verificar la carga de un Post.
- [x] **TBONUS - UserServiceTest** Este test prueba la excepción si el usuario se quiere seguir a si mismo.




