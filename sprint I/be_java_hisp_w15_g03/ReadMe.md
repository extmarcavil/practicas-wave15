#Bootcamp Backend Java Sprint Nº 1 - Spring

## Introduccion 

El objetivo de este sprint es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada.

## Requerimientos 

###**US 0001**
Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.

| US | METHOD | SIGN | RESPONSE |
|:-----|----|------|--------|
| 0001 | POST | /users/{userId}/follow/{userIdToFollow}| Status Code 200 <br /> Status Code 400 

###**US 0002**
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.

| US | METHOD | SIGN |
|:-----|----|------|
| 0002 | GET | /users/{userId}/followers/count|

#### Response

```
{
    "user_id": 1569,
    "user_name": "vendedor1",
    "followers_count": 35
}
```

###**US 0003**
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).


| US | METHOD | SIGN |
|:-----|----|------|
| 0003 | GET | /users/{userId}/followers/list| 

#### Response
```
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

###**US 0004**
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).


| US | METHOD | SIGN |
|:-----|----|------|
| 0004 | GET | /users/{userId}/followed/list| 

#### Response
```
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

###**US 0005**
Dar de alta una nueva publicación.

| US | METHOD | SIGN | RESPONSE |
|:-----|----|------|--------|
| 0005 | POST | /products/post| Status Code 200 <br /> Status Code 400


#### Payload
```
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

###**US 0006**
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

| US | METHOD | SIGN |
|:-----|----|------|
| 0006 | GET | /products/followed/{userId}/list| 

#### Response
```
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

###**US 0007**
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.


| US | METHOD | SIGN 
|:-----|----|------|
| 0007 | POST | /users/{userId}/unfollow/{userIdToUnfollow}

###**US 0008**
Ordenamiento alfabético ascendente y descendente para la US 3 y US 4.

| US | METHOD | SIGN |
|:-----|----|------|
| 0008 | GET | /users/{UserID}/followers/list?order=name_desc <br />/users/{UserID}/followed/list?order=name_asc

###**US 0009**
Ordenamiento alfabético ascendente y descendente para la US 6.

| US | METHOD | SIGN |
|:-----|----|------|
| 0009 | GET | /products/followed/{userId}/list?order=date_asc <br />/products/followed/{userId}/list?order=date_desc


















