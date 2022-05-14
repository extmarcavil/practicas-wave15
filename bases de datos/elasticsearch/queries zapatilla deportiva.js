# create index and 20 data
POST /zapatillasdeportivas/_doc/1
{
  "marca": "Adidas",
  "modelo": "A56",
  "color": "Dorado",
  "genero": "unisex"
}

POST /zapatillasdeportivas/_doc/2
{
  "marca": "Adidas",
  "modelo": "A50",
  "color": "Azul",
  "genero": "unisex"
}

POST /zapatillasdeportivas/_doc/3
{
  "marca": "Adidas",
  "modelo": "A60",
  "color": "Azul",
  "genero": "Dama"
}

POST /zapatillasdeportivas/_doc/4
{
  "marca": "Nike",
  "modelo": "B50",
  "color": "Azul",
  "genero": "Dama"
}

POST /zapatillasdeportivas/_doc/5
{
  "marca": "Nike",
  "modelo": "B52",
  "color": "Azul/Blanco",
  "genero": "Dama"
}

POST /zapatillasdeportivas/_doc/6
{
  "marca": "Nike",
  "modelo": "B45",
  "color": "Blanco",
  "genero": "Dama"
}

POST /zapatillasdeportivas/_doc/7
{
  "marca": "Nike",
  "modelo": "C50",
  "color": "Verde",
  "genero": "Dama"
}

POST /zapatillasdeportivas/_doc/8
{
  "marca": "Nike",
  "modelo": "D50",
  "color": "Blanco",
  "genero": "Dama"
}

POST /zapatillasdeportivas/_doc/9
{
  "marca": "Puma",
  "modelo": "P50",
  "color": "Negro",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/10
{
  "marca": "Puma",
  "modelo": "P55",
  "color": "Negro",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/11
{
  "marca": "Puma",
  "modelo": "P60",
  "color": "Negro",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/12
{
  "marca": "Puma",
  "modelo": "MXD3",
  "color": "Gris",
  "genero": "Hombre"
}

POST /zapatillasdeportivas/_doc/13
{
  "marca": "Puma",
  "modelo": "PY50",
  "color": "Negro",
  "genero": "Hombre"
}

POST /zapatillasdeportivas/_doc/14
{
  "marca": "Converse",
  "modelo": "WE34",
  "color": "Rojo",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/15
{
  "marca": "Converse",
  "modelo": "CON67",
  "color": "Azul",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/16
{
  "marca": "Converse",
  "modelo": "OP90",
  "color": "Amarillo",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/17
{
  "marca": "Converse",
  "modelo": "T7",
  "color": "Lila",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/18
{
  "marca": "Converse",
  "modelo": "T10",
  "color": "Blanco",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/19
{
  "marca": "Converse",
  "modelo": "T27",
  "color": "Marron",
  "genero": "Unisex"
}

POST /zapatillasdeportivas/_doc/20
{
  "marca": "Rebook",
  "modelo": "R45",
  "color": "Blanco",
  "genero": "Dama"
}

# get all
GET zapatillasdeportivas/_search

# get all with marca converse
GET /zapatillasdeportivas/_search
{
  "query": {
    "match": {
    "marca": "Converse"
    }
  }
}

# query en la ruta
GET  /zapatillasdeportivas/_search?q=marca: "Rebook"
