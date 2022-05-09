
# Sprint II: SocialMeli

Este es el repositorio del segundo Sprint realizado en el bootcamp wave 15 de Java con Spring Boot. 



## API Reference

#### Follow

```http
  POST /users/{userId}/follow/{userIdToFollow}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id de la persona |
| `userIdToFollow` | `int` | **Required**. id de la persona a seguir|

#### UnFollow

```http
  POST /users/{userId}/unfollow/{userIdToUnfollow}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id de la persona |
| `userIdToFollow` | `int` | **Required**. id de la persona a dejar de seguir|

#### countFollowers

```http
  GET /users/{userId}/followers/count
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id de la persona |

#### getListFollowers

```http
  GET /users/{userId}/followers/list
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id de la persona |
| `order` | `String` | **Optional**. tipo de orden |

#### getListFollowed

```http
  GET /users/{userId}/followed/list
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id de la persona |
| `order` | `String` | **Optional**. tipo de orden |

#### createPost

```http
  POST /products/post
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | **Required**.  id de la persona|
| `date` | `LocalDate` | **Required**.  fecha|
| `product_id` | `int` | **Required**.  id del post|
| `product_name` | `String` | **Required**.  nombre del producto|
| `type` | `String` | **Required**.  tipo de producto|
| `brand` | `String` | **Required**.  marca del producto|
| `color` | `String` | **Required**.  color del producto|
| `notes` | `String` | **Optional**.  color del producto|
| `category` | `int` | **Optional**.  color del producto|
| `price` | `double` | **Required**.  color del producto|

#### queryPost

```http
  GET /products/followed/{userId}/list?order=date_asc
      /products/followed/{userId}/list?order=date_desc
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**.  id de la persona|
| `order` | `String` | **Optional**.  tipo de orden|


## Unit Tests

### Repository Tests

```http
  VerifyUserExistence()
    Validación de existencia de usuario a seguir
```

```http
  VerifyUserToUnFollowExistence()
    Validación de existencia de usuario a dejar de seguir
```

### Service Tests
#### FollowService

```http
  verificarCorrectoOrdenAlfabetico()
    Verificación de orden alfabetico ascendente
```

```http
  verificarCorrectoOrdenDescAlfabetico()
    Verificación de orden alfabetico descendente
```

```http
  verificarCorrectoOrdenDefectoAlfabetico()
    Verificación de orden alfabetico por defecto
```

```http
  verificarExcepcionOrdenAlf()
    Verificación lanzado de excepción
```

```http
  correctoOrdenAlfabeticoSellers()
    Verificación de orden alfabetico ascendente de vendedores
```

```http
  correctoOrdenAlfabeticoSellersDesc()
    Verificación de orden alfabetico descendente de vendedores
```

```http
  correctoOrdenAlfabeticoSellersDefault()
    Verificación de orden alfabetico por defecto de vendedores
```

```http
  verificarExcepcionOrdenAlfSellers()
    Verificación lanzado de excepción sellers
```

```http
  verifyFollow()
    Validación de follow camino feliz
```

```http
  VerifyUserExistenceException()
    Validación de existencia de excepcion cuando no encuentra el usuario a seguir
```

```http
  verifyUnfollow()
    Validación de unfollow camino feliz
```

```http
  VerifySellerExistenceException()
    Validación de existencia de excepcion cuando no encuentra el usuario a dejar de seguir
```

```http
  VerifyQuantityFollowers()
    Validar cantidad de usuarios seguidores
```
#### ProductService

```http
  verificarCorrectoOrdenAscFecha()
    Verificación de fecha ascendente
```

```http
  verificarCorrectoOrdenDescFecha()
    Verificación de fecha descendente
```

```http
  verificarCorrectoOrdenDefaultFecha()
    Verificación de fecha default
```

```http
  verificarExcepcionOrdenFecha()
    Verificacion lanzado de excepcion OrderNotValidException
```

```http
  verificarCorrectoFiltroPorFecha()
    Verificación correcto filtro de fecha
```

## Authors

-[@GomezRodrigoML](https://github.com/GomezRodrigoML)

-[@marbermudez](https://github.com/marbermudez)

-[@sofiacotmeli](https://github.com/sofiacotmeli)

-[@mfranciscog](https://github.com/mfranciscog)

-[@NicoLopez1203](https://github.com/NicoLopez1203)

-[@vaneza17ruiz](https://github.com/ruizandino)



## Screenshots

![App Screenshot](https://i.pinimg.com/originals/f3/38/60/f338609f1bc08eea6b0db4d406f42256.jpg)

