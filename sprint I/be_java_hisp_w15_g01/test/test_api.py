#!/usr/bin/env python
# -*- encoding: utf-8 -*-
import unittest
import requests

class TestApi(unittest.TestCase):
    host = "http://localhost:8080"
    def test_creamosUnPostPromo(self):
        url = self.host+"/products/promo-post"
        datos= {
            "user_id": 1,
            "date": "27-04-2022",
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
            "has_promo": True,
            "discount": 0.25
        }
        r = requests.post(url, json=datos)
        # verificamos que responda 200 okey
        self.assertEquals(r.status_code, 200)

    def test_consultamosCuantosPostPromoTieneUnUsuario(self):
        userId = 1
        url = self.host+"/products/promo-post/count?userId="+str(userId)
        data = {"userId": userId}
        r = requests.get(url)
        #  guardamos la cantidad:
        count=r.json()['promo_products_count']

        # hacemos un posteo:
        urlPosteo = self.host+"/products/promo-post"
        datos= {
            "user_id": userId,
            "date": "27-04-2022",
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
            "has_promo": True,
            "discount": 0.25
        }
        r = requests.post(urlPosteo, json=datos)
        # verificamos que responda 200 okey
        self.assertEquals(r.status_code, 200)

        # consultamos para ver si se sumo un producto más
        r = requests.get(url)
        #  guardamos la cantidad:
        count2=r.json()['promo_products_count']
        self.assertEquals(count+1, count2)


    def test_agregamosUnPostAFavoritos(self):
        url = self.host+"/favorites/add"
        datos= {
            "user_id": 1,
            "product_id": 1
        }
        r = requests.post(url, json=datos)
        # verificamos que responda 200 okey
        self.assertEquals(r.status_code, 200)


    def test_siIntentamosagregarUnPostQueNoExisteAFavoritoRespondeNotFound(self):
        url = self.host+"/favorites/add"
        datos= {
            "user_id": 1,
            "product_id": 500
        }
        r = requests.post(url, json=datos)
        # verificamos que responda 404 not found
        self.assertEquals(r.status_code, 404)

    def test_elUsuarioPuedeConsultarCuantosFavoritosTiene(self):
        userId=1
        url = self.host+"/favorites/{userId}/count".format(userId=userId)
        r = requests.get(url)
        count=r.json()['favorites_count']
        urlPost = self.host+"/favorites/add"
        datos= {
            "user_id": userId,
            "product_id": 1
        }
        r = requests.post(urlPost, json=datos)
        # verificamos que responda 200 okey
        self.assertEquals(r.status_code, 200)

        # consultamos de vuelta para ver si sumó uno:
        r = requests.get(url)
        count2=r.json()['favorites_count']
        self.assertEquals(count+1, count2)

        
