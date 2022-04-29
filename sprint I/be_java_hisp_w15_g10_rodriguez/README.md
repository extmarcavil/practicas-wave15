# Documentacion

## Descripción del proyecto
Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Requerimientos tecnicos


### US 0001:
Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

#### Sign:

| Method   | SIGN                                                         |
|----------|--------------------------------------------------------------|
| POST     | /users/{userId}/follow/{userIdToFollow}                      |
| Ejemplo: | /users/1235/follow/1569                                      |
| Response | Status Code 200 (todo OK) <br> Status Code 400 (Bad Request) |

#### Filtros/Parámetros:

| Parámetros     | Tipo | Descripción/Ejemplo                       |
|----------------|------|-------------------------------------------|
| userId         | int  | Número que identifica al usuario actual   |
| userIdToFollow | int  | Número que identifica al usuario a seguir |

***

### US 0002:
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

#### Sign:

| Method   | SIGN                            |
|----------|---------------------------------|
| GET      | /users/{userId}/followers/count |
| Ejemplo: | /users/1569/followers/count/    |

RESPONSE:

```json
{
  "user_id": 1569,
  "user_name": "vendedor1",
  "followers_count": 35
}
```


### Filtros/Parámetros:

| Parámetros | Tipo | Descripción/Ejemplo                  |
|------------|------|--------------------------------------|
| userId     | int  | Número que identifica a cada usuario |

***

### US 0003: 
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
#### Sign:

| Method   | SIGN                           |
|----------|--------------------------------|
| GET      | /users/{userId}/followers/list |
| Ejemplo: | /users/1569/followers/list     |

RESPONSE:

```json
{
  "user_id": 1569,
  "user_name": "vendedor1",
  "followers": [
    {
      "user_id": 4698,
      "user_name": "usuario1"
    },
    {
      "user_id": 1536,
      "user_name": "usuario2"
    },
    {
      "user_id": 2236,
      "user_name": "usuario3"
    }
  ]
}
```

#### Filtros/Parámetros:

| Parámetros | Tipo | Descripción/Ejemplo                  |
|------------|------|--------------------------------------|
| userId     | int  | Número que identifica a cada usuario |

***

### US 0004:
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
#### Sign:

| Method   | SIGN                          |
|----------|-------------------------------|
| GET      | /users/{userId}/followed/list |
| Ejemplo: | /users/4698/followed/list     |

RESPONSE:

```json
{
  "user_id": 4698,
  "user_name": "usuario1",
  "followed": [
    {
      "user_id": 1569,
      "user_name": "vendedor1"
    },
    {
      "user_id": 6932,
      "user_name": "vendedor2"
    },
    {
      "user_id": 6631,
      "user_name": "vendedor3"
    }
  ]
}
```

#### Filtros/Parámetros:

| Parámetros | Tipo | Descripción/Ejemplo                  |
|------------|------|--------------------------------------|
| userId     | int  | Número que identifica a cada usuario |

***

### US 0005:
Dar de alta una nueva publicación

#### Sign:

| Method   | SIGN                                                       |
|----------|------------------------------------------------------------|
| POST     | /products/post                                             |
| RESPONSE | Status Code 200 (todo OK)<br>Status Code 400 (Bad Request) |

PAYLOAD:

```json
{
  "user_id": 1235,
  "date": "29-04-2021",
  "detail": {
    "product_id": 1,
    "product_name": "Silla Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50
}
```

#### Filtros/Parámetros:

| Parámetros   | Tipo      | Descripción/Ejemplo                                                                                                      |
|--------------|-----------|--------------------------------------------------------------------------------------------------------------------------|
| user_id      | int       | Número que identifica a cada usuario                                                                                     |
| date         | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| product_id   | int       | Número identificatorio de cada uno de los productos asociados a una publicación                                          |
| product_name | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| type         | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| brand        | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| color        | String    | Cadena de caracteres que representa el color de un producto                                                              |
| notes        | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| category     | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price        | double    | Precio del producto                                                                                                      |

***

### US 0006:
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
#### Sign:

| Method    | SIGN                             |
|-----------|----------------------------------|
| GET       | /products/followed/{userId}/list |
| Ejemplo:  | /products/followed/4698/list     |

RESPONSE:

```json
{
    "user_id": 4698,
    "posts": [ {
            "post_id": 32,
            "date": "01-05-2021",
            "detail": {
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
        },
        {
            "post_id": 18,
            "date": "29-04-2021",
            "detail": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.50
        }
    ]
}

```

#### Filtros/Parámetros:

| Parámetros | Tipo | Descripción/Ejemplo                  |
|------------|------|--------------------------------------|
| userId     | int  | Número que identifica a cada usuario |

***

### US 0007:
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
#### Sign:

| Method   | SIGN                                        |
|----------|---------------------------------------------|
| POST     | /users/{userId}/unfollow/{userIdToUnfollow} |
| Ejemplo: | /users/1569/unfollow/1235                   |

#### Filtros/Parámetros:

| Parámetros       | Tipo | Descripción/Ejemplo                                |
|------------------|------|----------------------------------------------------|
| userId           | int  | Número que identifica al usuario actual            |
| userIdToUnfollow | int  | Número que identifica al usuario a dejar de seguir |

***

### US 0008: Ordenamiento alfabético ascendente y descendente
#### Sign:

| Method | SIGN                                                                                                                                                                                                          |
|--------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | Ejemplos:<br>/users/{UserID}/followers/list?order=name_asc<br>/users/{UserID}/followers/list?order=name_desc<br>/users/{UserID}/followed/list?order=name_asc<br>/users/{UserID}/followed/list?order=name_desc |

| order     | Description             |
|-----------|-------------------------|
| name_asc  | Alfabético ascendente.  |
| name_desc | Alfabético descendente. |

***

### US 0009:
Ordenamiento por fecha ascendente y descendente

#### Sign:

| Method | SIGN                                                                                                             |
|--------|------------------------------------------------------------------------------------------------------------------|
| GET    | Ejemplos:<br>/products/followed/{userId}/list?order=date_asc<br>/products/followed/{userId}/list?order=date_desc |

| order     | Description                                    |
|-----------|------------------------------------------------|
| date_asc  | Fecha ascendente (de más antigua a más nueva)  |
| date_desc | Fecha descendente (de más nueva a más antigua) |

**Nota**: Este ordenamiento aplica solo para la US-006

***

## B. Requerimientos incrementales (Desarrollo INDIVIDUAL)
### US 0010:
Llevar a cabo la publicación de un nuevo producto en promoción
#### Sign:

| Method   | SIGN                                                  |
|----------|-------------------------------------------------------|
| POST     | /products/promo-post                                  |
| Response | Status Code 200 (OK)<br>Status Code 400 (Bad request) |

PAYLOAD:

```json
{
    "user_id": 1569,
    "date": "29-04-2021",
    "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "has_promo": true,
    "discount": 0.25
}
```

#### Filtros/Parámetros:

| Parámetros   | Tipo      | Descripción/Ejemplo                                                                                                      |
|--------------|-----------|--------------------------------------------------------------------------------------------------------------------------|
| user_id      | int       | Número que identifica a cada usuario                                                                                     |
| date         | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| product_id   | int       | Número identificatorio de cada uno de los productos asociados a una publicación                                          |
| product_name | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| type         | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| brand        | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| color        | String    | Cadena de caracteres que representa el color de un producto                                                              |
| notes        | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| category     | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price        | double    | Precio del producto                                                                                                      |
| has_promo    | boolean   | Campo true o false para determinar si un producto está en promoción o no                                                 |
| discount     | double    | En caso de que un producto estuviese en promoción ,establece el monto de descuento.                                      |

***

### US 0011:
Obtener la cantidad de productos en promoción de un determinado vendedor
#### Sign:

| Method   | SIGN                                        |
|----------|---------------------------------------------|
| GET      | /products/promo-post/count?user_id={userId} |

RESPONSE:

```json
{
  "user_id" : 1569,
  "user_name": "vendedor1",
  "promo_products_count": 23
}
```

#### Filtros/Parámetros:

| Parámetros           | Tipo   | Descripción/Ejemplo                                                    |
|----------------------|--------|------------------------------------------------------------------------|
| user_id              | int    | Número que identifica a cada usuario                                   |
| user_name            | String | Cadena de caracteres que representa el nombre del usuario              |
| promo_products_count | int    | Cantidad numérica de productos en promoción de un determinado usuario. |

## C. Ejemplo Requerimiento Bonus (Desarrollo INDIVIDUAL)
### US 0012:
Obtener un listado de todos los productos en promoción de un determinado vendedor
#### Sign:

| Method    | SIGN                                       |
|-----------|--------------------------------------------|
| GET       | /products/promo-post/list?user_id={userId} |
 
RESPONSE:                                             

```json
{
  "user_id": 1569,
  "user_name": "vendedor1",
  "posts": [
    {
      "post_id": 18,
      "date": "29-04-2021",
      "detail": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": "100",
      "price": 15000.50,
      "has_promo": true,
      "discount": 0.25,
      "real_price": 1350.45
    }
  ]
}

```

#### Filtros/Parámetros:

| Parámetros   | Tipo      | Descripción/Ejemplo                                                                                                      |
|--------------|-----------|--------------------------------------------------------------------------------------------------------------------------|
| user_id      | int       | Número que identifica a cada usuario                                                                                     |
| user_name    | String    | Cadena de caracteres que representa el nombre del usuario                                                                |
| post_id      | int       | Número identificatorio de cada una de las publicaciones                                                                  |
| date         | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| product_id   | int       | Número identificatorio de cada uno de los productos asociados a una publicación                                          |
| product_name | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| type         | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| brand        | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| color        | String    | Cadena de caracteres que representa el color de un producto                                                              |
| notes        | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| category     | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price        | double    | Precio del producto                                                                                                      |
| has_promo    | boolean   | Campo true o false para determinar si un producto está en promoción o no                                                 |
| discount     | double    | En caso de que un producto estuviese en promoción, establece el monto de descuento.                                      |

