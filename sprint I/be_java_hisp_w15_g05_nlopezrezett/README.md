# Sprint I: SocialMeli

Este es el repositorio del primer Sprint realizado en el bootcamp wave 15 de Java con Spring Boot.

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

| Parameter | Type     | Description                           |
| :-------- | :------- |:--------------------------------------|
| `user_id` | `int` | **Required**. id de la persona        |
| `date` | `LocalDate` | **Required**. fecha                   |
| `product_id` | `int` | **Required**. id del post             |
| `product_name` | `String` | **Required**. nombre del producto     |
| `type` | `String` | **Required**. tipo de producto        |
| `brand` | `String` | **Required**. marca del producto      |
| `color` | `String` | **Required**. color del producto      |
| `notes` | `String` | **Optional**. notas sobre el producto |
| `category` | `int` | **Optional**. categoria del producto  |
| `price` | `double` | **Required**. precio del producto     |

#### queryPost

```http
  GET /products/followed/{userId}/list?order=date_asc
      /products/followed/{userId}/list?order=date_desc
```

```
ATENCION: order **date_asc** trae del post mas reciente al mas antiguo y 
                **date_desc** trae del post mas antiguo al mas reciente
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id de la persona|
| `order` | `String` | **Optional**. tipo de orden|

## Desarrollo Individual

#### Post con promo

```http
  POST /products/promo-post
```

| Parameter      | Type        | Description                           |
|:---------------|:------------|:--------------------------------------|
| `user_id`      | `int`       | **Required**. id de la persona        |
| `date`         | `LocalDate` | **Required**. fecha                   |
| `product_id`   | `int`       | **Required**. id del post             |
| `product_name` | `String`    | **Required**. nombre del producto     |
| `type`         | `String`    | **Required**. tipo de producto        |
| `brand`        | `String`    | **Required**. marca del producto      |
| `color`        | `String`    | **Required**. color del producto      |
| `notes`        | `String`    | **Optional**. notas sobre el producto |
| `category`     | `int`       | **Optional**. categoria del producto  |
| `price`        | `double`    | **Required**. precio del producto     |
| `has_promo`    | `boolean`   | **Required**. si contiene promoción   |
| `discount`     | `double`    | **Required**. descuento               |

#### Productos en promocion de un vendedor

```http
  GET /products/promo-post/count?user_id={userId}
```

| Parameter | Type     | Description                |
|:----------| :------- | :------------------------- |
| `user_id` | `int` | **Required**. id de la persona |

## Bonus

#### Lista de productos en promocion de un vendedor

````http 
  GET /products/promo-post/list?user_id={userId}&order={name_asc}
      /products/promo-post/list?user_id={userId}&order={name_desc}
````

| Parameter | Type     | Description                        |
|:----------|:---------|:-----------------------------------|
| `user_id` | `int`    | **Required**. id de la persona     |
| `order`   | `String` | **Optional**. el orden de la lista |

#### Lista de todos los productos de un vendedor

````http 
  GET /products/post/{userId}/all?order={name_asc}
      /products/post/{userId}/all?order={name_desc}
````

| Parameter | Type     | Description                |
|:----------| :------- | :------------------------- |
| `userId`  | `int` | **Required**. id de la persona |
| `order`   | `String` | **Optional**. el orden de la lista |****

## Authors

-[@]Nicolas Lopez Rezett(https://github.com/NicoLopez1203)

## Screenshots

![App Screenshot](https://i.pinimg.com/originals/f3/38/60/f338609f1bc08eea6b0db4d406f42256.jpg)

