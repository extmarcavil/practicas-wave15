
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

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | **Required**.  id de la persona|
| `date` | `LocalDate` | **Required**.  fecha|
| `product_id` | `int` | **Required**.  id del post|
| `product_name` | `String` | **Required**.  nombre del producto|
| `type` | `String` | **Required**.  tipo de producto|
| `brand` | `String` | **Required**.  marca del producto|
| `color` | `String` | **Required**.  color del producto|
| `notes` | `String` | **Optional**.  nota del producto|
| `category` | `int` | **Optional**.  categoria del producto|
| `price` | `double` | **Required**.  precio del producto|

#### queryPost

```http
  GET /products/followed/{userId}/list?order=date_asc
      /products/followed/{userId}/list?order=date_desc
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**.  id de la persona|
| `order` | `String` | **Optional**.  tipo de orden|

#### createPromoPost

```http
  POST /products/promo-post
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**.  id de la vendedor|
| `date` | `LocalDate` | **Required**.  fecha|
| `productId` | `int` | **Required**.  id del post|
| `productName` | `String` | **Required**.  nombre del producto|
| `type` | `String` | **Required**.  tipo de producto|
| `brand` | `String` | **Required**.  marca del producto|
| `color` | `String` | **Required**.  color del producto|
| `notes` | `String` | **Optional**.  nota del producto|
| `category` | `int` | **Optional**.  categoria del producto|
| `price` | `double` | **Required**.  precio del producto|
| `hasPromo` | `boolean` | **Required**.  producto en promoción|
| `discount` | `double` | **Required**.  descuento|

#### countPromoPosts

```http
  GET /products/promo-post/count?user_id={userId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id del vendedor|

#### getListPromoPosts

```http
  GET /products/promo-post/list?user_id={userId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | **Required**. id del vendedor|


## Author
-[@marbermudez](https://github.com/marbermudez)

## Screenshots

![App Screenshot](https://i.pinimg.com/originals/f3/38/60/f338609f1bc08eea6b0db4d406f42256.jpg)

