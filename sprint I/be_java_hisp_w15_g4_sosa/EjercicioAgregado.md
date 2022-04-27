
# Ejercicio Extra

Obtener el listado completo de productos en promoción de todos los usuarios
## API Reference US0013:

#### Get all products in promo
Method
```http
  GET /products/promo-post
```
#### Response:
```http
{
    "user_id": 0,
    "user_name": null,
    "promos": [
        {
            "user_id": 3,
            "post_id": 1,
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
            "price": 1500.5,
            "has_promo": true,
            "discount": 0.25
        }
    ]
}

```