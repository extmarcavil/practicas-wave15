# fp-be-java-hisp-w15-g05

# Spring Boot App model for Java 11

We provide a basic model for JDK 11 / Spring based web applications.

Please address any questions and comments to [Fury Issue Tracker](https://github.com/mercadolibre/fury/issues).

## Usage

### SCOPE

The suffix of each Fury **SCOPE** is used to know which properties file to use, it is identified from the last '-' of the name of the scope.

If you want to run the application from your development IDE, you need to configure the environment variable **SCOPE=local** in the app luncher.

The properties of **application.yml** are always loaded and at the same time they are complemented with **application-<SCOPE_SUFFIX>.yml** properties. If a property is in both files, the one that is configured in **application-<SCOPE_SUFFIX>.yml** has preference over the property of **application.yml**.

For example, for the **SCOPE** 'items-loader-test' the **SCOPE_SUFFIX** would be 'test' and the loaded property files will be **application.yml** and **application-test.yml**

### Web Server

Each Spring Boot web application includes an embedded web server. For servlet stack applications, Its supports three web Servers:
* Tomcat (maven dependency: `spring-boot-starter-tomcat`)
* Jetty (maven dependency: `spring-boot-starter-jetty`)
* Undertow (maven dependency: `spring-boot-starter-undertow`)

This project is configured with Jetty, but to exchange WebServer, it is enough to configure the dependencies mentioned above in the pom.xml file.

### Main

The main class for this app is Application, where Spring context is initialized and SCOPE_SUFFIX is generated.

### Error Handling

We also provide basic handling for exceptions in ControllerExceptionHandler class.

## Api Documentation

This project uses Springfox to automate the generation of machine and human readable specifications for JSON APIs written using Spring. Springfox works by examining an application, once, at runtime to infer API semantics based on spring configurations, class structure and various compile time java Annotations.

You can change this configuration in SpringfoxConfig class.

## [Release Process](https://release-process.furycloud.io/#/)

### Usage

1. Specify the correct tag for your app in your `Dockerfile` and `Dockerfile.runtime`, according to the desired Java runtime version.

```
# Dockerfile
FROM hub.furycloud.io/mercadolibre/java:1.11-mini
```

You can find all available tags for your `Dockerfile` [here](https://github.com/mercadolibre/fury_java-mini#supported-tags)

```
# Dockerfile.runtime
FROM hub.furycloud.io/mercadolibre/java:1.11-runtime-mini
```

You can find all available tags for your `Dockerfile.runtime` [here](https://github.com/mercadolibre/fury_java-mini-runtime#supported-tags)
# Sprint3: Proyecto Grupal

### TODOS LOS ENDPOINTS REQUIEREN UN JWT
### Header
|Content-Type|Value|
|---|---|
|X-Auth-Token|{{token-fury}}|
## Endpoints
# Login
### Method: POST
>```
>localhost:8080/api/v1/sign-in
>```
### Body
```json
{
    "user_name":"rep",
    "password":"123"
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# Requerimiento 1 - Admin
## End-point: Req1 - 1
### Method: POST
>```
>localhost:8080/api/v1/fresh-products/inboundorder
>```
### Body
```json
{
    "inbound_order": {
        "order_number": 1,
        "order_date": "02-06-2022",
        "section": {
            "section_code": "1",
            "warehouse_code": "1"
        },
        "batch_stock": [
            {
                "batch_number": 1,
                "product_id": "3",
                "current_temperature": 40,
                "minimum_temperature": 10,
                "initial_quantity": 16,
                "current_quantity": 16,
                "manufacturing_date": "01-06-2022 10:20:38",
                "due_date": "10-02-2022"
            }
        ]
    }
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Req1 - 2
### Method: PUT
>```
>localhost:8080/api/v1/fresh-products/inboundorder
>```
### Body
```json
{
    "inbound_order": {
        "order_number": 1,
        "order_date": "02-06-2022",
        "section": {
            "section_code": "1",
            "warehouse_code": "1"
        },
        "batch_stock": [
            {
                "batch_number": 1,
                "product_id": "3",
                "current_temperature": 40,
                "minimum_temperature": 10,
                "initial_quantity": 16,
                "current_quantity": 16,
                "manufacturing_date": "01-06-2022 10:20:38",
                "due_date": "10-02-2022"
            }
        ]
    }
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# Requerimiento 2 - Buyer
## End-point: Req2 - 1
### Method: GET
>```
>localhost:8080/api/v1/fresh-products/list
>```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Req2 - 2
### Method: GET
>```
>localhost:8080/api/v1/fresh-products/list?category=FS
>```
### Query Params
|Param| value | equivalent   |
|---|-------|--------------|
|category| 1     | FRESH        |
|category| 2     | FROZEN       |
|category| 3     | REFRIGERATED |
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Req2 - 3
### Method: POST
>```
>localhost:8080/api/v1/fresh-products/orders
>```
### Body
```json
{
    "date": "02-02-2022",
    "buyer_id": "1",
    "order_status": {
        "status_code": "CARRITO"
    },
    "products": [
        {
            "product_id": 2,
            "quantity": 10
        }
    ]
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Req2 - 4
### Method: GET
>```
>localhost:8080/api/v1/fresh-products/orders/1
>```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Req2 - 5
### Method: PUT
>```
>localhost:8080/api/v1/fresh-products/orders/{{idOrder}}
>```
### Body
```json
{
    "date": "20-09-2021",
    "buyer_id": "1",
    "order_status": {
        "status_code": "CARRITO"
    },
    "products": [
        {
            "product_id": "1",
            "quantity": 15
        }
    ]
}
```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
#  Requerimiento 3 - Admin
## End-point: Req3 - 1
### Method: GET
>```
>localhost:8080/api/v1/fresh-products/1/batch/list
>```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Req3 - 2
### Method: GET
>```
>localhost:8080/api/v1/fresh-products/1/batch/list?order=L
>```
### Headers
### Query Params
|Param|value|
|---|---|
|order|L|
|order|C|
|order|F|
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
## End-point: Ping
### Method: GET
>```
>localhost8080:/ping
>```
⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## Class Modeling

   <p align="center"><img src="extras/Diagrama%20Sprint3%20Grupo5.drawio.png" width="1000"/></p>

## Authors

-[@sofiacotmeli](https://github.com/sofiacotmeli)

-[@GomezRodrigoML](https://github.com/GomezRodrigoML)

-[@marbermudez](https://github.com/marbermudez)

-[@mfranciscog](https://github.com/mfranciscog)

-[@NicoLopez1203](https://github.com/NicoLopez1203)

-[@vaneza17ruiz](https://github.com/ruizandino)

### Questions

[Release Process Issue Tracker](https://github.com/mercadolibre/fury_release-process/issues)