
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



## Authors

-[@GomezRodrigoML](https://github.com/GomezRodrigoML)

-[@marbermudez](https://github.com/marbermudez)

-[@sofiacotmeli](https://github.com/sofiacotmeli)

-[@mfranciscog](https://github.com/mfranciscog)

-[@NicoLopez1203](https://github.com/NicoLopez1203)

-[@vaneza17ruiz](https://github.com/ruizandino)



## Screenshots

![App Screenshot](https://i.pinimg.com/originals/f3/38/60/f338609f1bc08eea6b0db4d406f42256.jpg)

