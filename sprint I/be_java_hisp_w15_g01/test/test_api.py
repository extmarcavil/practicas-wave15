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
