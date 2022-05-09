# SocialMeli
## Quality
### Tests unitarios (Parte A)
- **T-0001:** Verificar que el usuario a seguir exista. (US-0001)
- **T-0002:** Verificar que el usuario a dejar de seguir exista. (US-0007)
- **T-0003:** Verificar que el tipo de ordenamiento alfabético exista (US-0008)
- **T-0004:** Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)
- **T-0005:** Verificar que el tipo de ordenamiento por fecha exista (US-0009)
- **T-0006:** Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)
- **T-0007:** Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)
- **T-0008:** Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)

### Test de integración (Parte B)
- INDIVIDUAL - Verificar que la cantidad de seguidores de un determinado usuario sea correcta
  - Endpoint: /users/{userId}/followers/count

### Test bonus (Parte C)
#### User repository
- BONUS - Verificar que se crea un nuevo post correctamente

#### User service
- BONUS - Verificar que se retorna correctamente la lista de seguidores sin especificar ordenamiento
- BONUS - Verificar que se retorna correctamente la lista de seguidos sin especificar ordenamiento

#### Post service
- BONUS - Verificar que se crea un nuevo post correctamente

#### User controller
- BONUS - Verificar que se lanza una excepción cuando el usuario no existe
  - Endpoint: /users/{userId}/followers/count
- BONUS - Verificar que se retorna correctamente la lista de seguidores
  - Endpoint: /users/{userId}/followers/list 
- BONUS - Verificar que se retorna correctamente la lista de seguidos
  - Endpoint: /users/{userId}/followed/list
- BONUS - Verificar que se retorna correctamente la lista de seguidores con ordenamiento descendente
    - Endpoint: /users/{userId}/followers/list
- BONUS - Verificar que se retorna correctamente la lista de seguidos con ordenamiento descendente
  - Endpoint: /users/{userId}/followed/list

#### Post controller
- BONUS - Verificar que se obtiene correctamente la lista de posts
  - Endpoint: /products/followed/{userId}/list
- BONUS - Verificar que se laza una excepción cuando el tipo de ordenamiento no es válido
  - Endpoint: /products/followed/{userId}/list