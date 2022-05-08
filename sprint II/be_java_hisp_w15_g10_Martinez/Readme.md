# CHALLENGE ACCEPTED SPRINT I

## - Requerimiento 
User: Dar de alta un Usuario

## END POINTS

- [POST]()
>***URL:*** http://localhost:8080/users

>***Request :*** 
```
curl --location --request POST 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName":"Pedro"
}'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 1,
    "userName": "Pedro"
}
```

## - Requerimiento 
User: Obtener todos los usuarios creados

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/users

>***Request :*** 
```
curl --location --request GET 'localhost:8080/users'
```
>***Response OK:*** Status Code 200 (OK)
```
[
    {
        "userId": 1,
        "userName": "Pedro"
    },
    {
        "userId": 2,
        "userName": "Juan"
    }
]
```


## - Requerimiento 
User: Obtener un usuario por userName

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/users/Pedro

>***Request :*** 
```
curl --location --request GET 'localhost:8080/users/Pedro'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 1,
    "userName": "Pedro"
}
```

 ## - Requerimiento 
US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

## END POINTS

- [POST]()
>***URL:*** http://localhost:8080/users/{userId}/follow/{userIdToFollow}

>***Request :*** 
```
curl --location --request POST 'localhost:8080/users/1/follow/2'
```
>***Response OK:*** Status Code 200 (OK)
```
El Usuario: Pedro ahora sigue al Vendedor: Juan
```


## - Requerimiento 
US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/users/{userId}/followers/count

>***Request :*** 
```
curl --location --request GET 'localhost:8080/users/2/followers/count'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 2,
    "userName": "Juan",
    "followersCount": 2
}
```

## - Requerimiento 
US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/users/{userId}/followers/list

>***Request :*** 
```
curl --location --request GET 'localhost:8080/users/4/followers/list?order=name_desc'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 2,
    "userName": "Juan",
    "followers": [
        {
            "userId": 1,
            "userName": "Pedro"
        },
        {
            "userId": 3,
            "userName": "Andres"
        }
    ]
}
```



## - Requerimiento 
US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/users/{userId}/followed/list

>***Request :*** 
```
curl --location --request GET 'localhost:8080/users/1/followed/list?order=name_desc'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 1,
    "userName": "Pedro",
    "followed": [
        {
            "userId": 2,
            "userName": "Juan"
        },
        {
            "userId": 3,
            "userName": "Andres"
        }
    ]
}
```

## - Requerimiento 
Product: Dar de alta un producto

## END POINTS

- [POST]()
>***URL:*** http://localhost:8080/products

>***Request :*** 
```
curl --location --request POST 'localhost:8080/products' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productName": "Car",
    "type": "Sport",
    "brand": "Audi",
    "color": "Blue",
    "notes": "lujoso"
}'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "productId": 1,
    "productName": "Car",
    "type": "sport",
    "brand": "Audi",
    "color": "blue",
    "notes": "costoso"
}
```

## - Requerimiento 
Product: Obtener todos los productos 

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products'
```
>***Response OK:*** Status Code 200 (OK)
```
[
    {
        "productId": 1,
        "productName": "Car",
        "type": "sport",
        "brand": "Audi",
        "color": "blue",
        "notes": "costoso"
    },
    {
        "productId": 2,
        "productName": "Laptop",
        "type": "Apple",
        "brand": "Apple",
        "color": "Black",
        "notes": "i15"
    }
]
```

## - Requerimiento 
Product: Obtener un producto por Id

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/{productId}

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/2'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "productId": 2,
    "productName": "Laptop",
    "type": "Apple",
    "brand": "Apple",
    "color": "Black",
    "notes": "i15"
}
```


## - Requerimiento 
Category: Dar de alta una categoria

## END POINTS

- [POST]()
>***URL:*** http://localhost:8080/products/category

>***Request :*** 
```
curl --location --request POST 'localhost:8080/products/category' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nameCategory":"Performance"
}'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "categoryId": 6,
    "nameCategory": "Performance"
}
```

## - Requerimiento 
Category: Obtener todas las categorias

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/category

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/category'
```
>***Response OK:*** Status Code 200 (OK)
```
[
    {
        "categoryId": 1,
        "nameCategory": "Tecnologia"
    },
    {
        "categoryId": 2,
        "nameCategory": "Electrodomesticos"
    },
    {
        "categoryId": 3,
        "nameCategory": "Accesorios"
    },
    {
        "categoryId": 4,
        "nameCategory": "Aseo"
    },
    {
        "categoryId": 5,
        "nameCategory": "Deporte"
    },
    {
        "categoryId": 6,
        "nameCategory": "Performance"
    }
]
```



## - Requerimiento 
Category: Obtener una categoria por Id

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/category/{categoryId}

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/category/1'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "categoryId": 1,
    "nameCategory": "Tecnologia"
}
```


## - Requerimiento 
US 0005: Dar de alta una nueva publicación

## END POINTS

- [POST]()
>***URL:*** http://localhost:8080/products/post
>***Request :*** 
```
curl --location --request POST 'localhost:8080/products/post' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 1,
    "detail": {
        "productName": "Portatil",
        "type": "Apple",
        "brand": "Apple",
        "color": "Blanca",
        "notes": "A1466"
    },
    "category": 1,
    "price": 10000.0
}'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 1,
    "date": "2022-04-28",
    "category": 1,
    "price": 10000.0,
    "hasPromo": false,
    "detail": {
        "productId": 3,
        "productName": "Portatil",
        "type": "Apple",
        "brand": "Apple",
        "color": "Blanca",
        "notes": "A1466"
    }
}
```





## - Requerimiento 
US 0006: Obtener un listado de las publicaciones realizadas 
por los vendedores que un usuario sigue en las últimas dos semanas
(para esto tener en cuenta ordenamiento por fecha, publicaciones 
más recientes primero).

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/followed/{userId}/list

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/followed/3/list'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 3,
    "posts": [
        {
            "userId": 1,
            "date": "2022-04-28",
            "category": 1,
            "price": 10000.0,
            "hasPromo": false,
            "detail": {
                "productId": 3,
                "productName": "Portatil",
                "type": "Apple",
                "brand": "Apple",
                "color": "Blanca",
                "notes": "A1466"
            }
        }
    ]
}
```



## - Requerimiento 
US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

## END POINTS

- [POST]()
>***URL:*** http://localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}

>***Request :***
```
curl --location --request POST 'localhost:8080/users/1/unfollow/2'
```
>***Response OK:*** Status Code 200 (OK)
```
El Usuario: 1 ahora dejo de seguir al Vendedor: 2
```



## - Requerimiento 
US 0008: Ordenamiento alfabético ascendente y descendente

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/users/{UserID}/followers/list?order=name_desc

>***Request :*** 
```
curl --location --request GET 'localhost:8080/users/2/followers/list?order=name_desc'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 2,
    "userName": "Juan",
    "followers": [
        {
            "userId": 1,
            "userName": "Pedro"
        },
        {
            "userId": 3,
            "userName": "Andres"
        }
    ]
}
```



## - Requerimiento 
US 0009: Ordenamiento por fecha ascendente y descendente

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/followed/{userId}/list?order=date_desc

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/followed/3/list?order=date_desc'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 3,
    "posts": [
        {
            "userId": 1,
            "date": "2022-04-28",
            "category": 1,
            "price": 10000.0,
            "hasPromo": false,
            "detail": {
                "productId": 3,
                "productName": "Portatil",
                "type": "Apple",
                "brand": "Apple",
                "color": "Blanca",
                "notes": "A1466"
            }
        },
        {
            "userId": 1,
            "date": "2022-04-26",
            "category": 1,
            "price": 10000.0,
            "hasPromo": false,
            "detail": {
                "productId": 4,
                "productName": "Pan",
                "type": "Apple",
                "brand": "Apple",
                "color": "Blanca",
                "notes": "A1466"
            }
        },
        {
            "userId": 1,
            "date": "2022-04-21",
            "category": 1,
            "price": 10000.0,
            "hasPromo": false,
            "detail": {
                "productId": 5,
                "productName": "cicla",
                "type": "Apple",
                "brand": "Apple",
                "color": "Blanca",
                "notes": "A1466"
            }
        }
    ]
}
```






## - Requerimiento 
US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/promo-post

>***Request :*** 
```
curl --location --request POST 'localhost:8080/products/promo-post' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": 3,
    "detail": {
        "productName": "Casa",
        "type": "Sport",
        "brand": "Audi",
        "color": "Iphone",
        "notes": "A52S"
    },
    "category": 1,
    "price": 250,
    "hasPromo": true,
    "discount": 70.0
}'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 3,
    "date": "2022-04-28",
    "category": 1,
    "price": 250.0,
    "hasPromo": true,
    "discount": 70.0,
    "detail": {
        "productId": 6,
        "productName": "Casa",
        "type": "Sport",
        "brand": "Audi",
        "color": "Iphone",
        "notes": "A52S"
    }
}
```




## - Requerimiento 
US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/promo-post/count?user_id={userId}

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/promo-post/count?user_id=1'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 1,
    "userName": "Pedro",
    "promoProductsCount": 1
}
```


## - Requerimiento 
US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor

## END POINTS

- [GET]()
>***URL:*** http://localhost:8080/products/promo-post/list?user_id={userId}

>***Request :*** 
```
curl --location --request GET 'localhost:8080/products/promo-post/list?user_id=3'
```
>***Response OK:*** Status Code 200 (OK)
```
{
    "userId": 1,
    "userName": "Pedro",
    "postList": [
        {
            "userId": 1,
            "date": "2022-04-28",
            "category": 1,
            "price": 250.0,
            "hasPromo": true,
            "discount": 70.0,
            "detail": {
                "productId": 7,
                "productName": "Carro",
                "type": "Sport",
                "brand": "Audi",
                "color": "Iphone",
                "notes": "A52S"
            }
        }
    ]
}
```



