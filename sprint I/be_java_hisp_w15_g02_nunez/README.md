## Project information 🚀

In this project we developed a challenge set by meli that consisted of an API with certain endpoints where we were going to have users, sellers where users could follow a seller and be able to perform other types of actions.


## Compilation 💻

-Your code will be compiled this way:

If you want to run the project just download the folder and run the project with your favorite ide or from the terminal if you prefer.

##  Dependencies
- lombok
- spring-boot-devtools
- spring-boot-starter-web


### Requeriments 📌

- 1: Being able to "Follow" a specific seller 

- 2: Obtain the result of the number of users that follow a specific seller

- 3: Get a list of all the users that follow a certain seller (Who follows me?)

- 4: Obtain a list of all sellers followed by a given user (Who am I following?)

- 5: Register a new publication.

- 6: Obtain a list of the publications made in the last two weeks, by the sellers that a user follows (for this take into account sorting by date, most recent publications first).

- 7: To be able to "Unfollow" a specific seller.

- 8: Alphabetical Ascending and Descending

- 9: Date Ascending and Descending


## Endpoints

- 1: <p align="center"> <img src="images/us01.png" width="1000"/></p>
- 2: <p align="center"> <img src="images/us02.png" width="1000"/></p>
- 3: <p align="center"> <img src="images/us03.png" width="1000"/></p>
- 4: <p align="center"> <img src="images/us04.png" width="1000"/></p>
- 5: <p align="center"> <img src="images/us05.png" width="1000"/></p>
        <p align="center"> <img src="images/us05-0.png" width="1000"/></p>
        <p align="center"> <img src="images/us05-1.png" width="1000"/></p>
- 6: <p align="center"> <img src="images/us06.png" width="1000"/></p>
        <p align="center"> <img src="images/us06-0.png" width="1000"/></p>
- 7: <p align="center"> <img src="images/us07.png" width="1000"/></p>
- 8: <p align="center"> <img src="images/us08.png" width="1000"/></p>
- 9: <p align="center"> <img src="images/us09.png" width="1000"/></p>
- 10: <p align="center"> <img src="images/us10-0.png" width="1000"/></p>
        <p align="center"> <img src="images/us10-1.png" width="1000"/></p>
        <p align="center"> <img src="images/us10-2.png" width="1000"/></p>
- 11: <p align="center"> <img src="images/us11.png" width="1000"/></p>
- 12: <p align="center"> <img src="images/us12.png" width="1000"/></p>
  <p align="center"> <img src="images/us12-0.png" width="1000"/></p>

## Class Modeling

   <p align="center"><img src="images/classModel.jpg" width="1000"/></p>

## Post Service

<p>Create a new post</p>
<p>Get a post list by a followed</p>
<p>Create a new discounted product post</p>
<p>Get discounted product post lis</p>

## Postman documentation
# Project: Sprint I
# 📁 Collection: Main


## End-point: US 01 - Follow
### Method: POST
>```
>{{url}}/users/{{client_id}}/follow/{{seller_id}}
>```
### Headers

|Content-Type|Value|
|---|---|
|linkid|1|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 02 - Count Followers
### Method: GET
>```
>{{url}}/users/{{seller_id}}/followers/count
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 03 - Followers / US 08
### Method: GET
>```
>{{url}}/users/{{seller_id}}/followers/list?order=name_desc
>```
### Query Params

|Param|value|
|---|---|
|oder|name_desc|
|order|name_desc|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 04 - Followed / US 08
### Method: GET
>```
>{{url}}/users/{{client_id}}/followed/list?order=name_asc
>```
### Query Params

|Param|value|
|---|---|
|order|name_asc|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 05 - New Post
### Method: POST
>```
>{{url}}/products/post
>```
### Body (**raw**)

```json
{
    "user_id": "{{seller_id}}",
    "date": "29-11-2021",
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

### Query Params

|Param|value|
|---|---|
|clientId|5001|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 06 - Seller's posts / US 09
### Method: GET
>```
>{{url}}/products/followed/{{client_id}}/list?order=date_desc
>```
### Query Params

|Param|value|
|---|---|
|order|date_desc|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 07 - Unfollow
### Method: POST
>```
>{{url}}/users/{{client_id}}/unfollow/{{seller_id}}
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Bonus


## End-point: US 10 - New Promo Post
### Method: POST
>```
>{{url}}/products/promo-post
>```
### Body (**raw**)

```json
{
    "user_id": "{{seller_id}}",
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


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 11 - Count Promo Post
### Method: GET
>```
>{{url}}/products/promo-post/count?user_id={{seller_id}}
>```
### Query Params

|Param|value|
|---|---|
|user_id|{{seller_id}}|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: US 12 - Seller's Promo Post
### Method: GET
>```
>{{url}}/products/promo-post/list?user_id={{seller_id}}
>```
### Query Params

|Param|value|
|---|---|
|user_id|{{seller_id}}|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)


## Authors ✒️

<p align="left">
    <h3 align="left"> Santiago Pinzón D </h3>
    <h3 align="left"> Edwin Gonzalez </h3>
    <h3 align="left"> Gerson Jair Sanchez </h3>
    <h3 align="left"> Josue Alexander Nunez </h3>
    <h3 align="left"> Jose Alejandro Villamizar </h3>
    <h3 align="left"> Juan Pablo Chaparro </h3>
<p align="left">

	   