# get all
GET /employee/_search

# creando cliente
PUT /clientsmisiones/_doc/3
{
  "body":{
    "Nombre": "marco avila"
  }
}

# creando un Index y un nuevo dato
POST /nuevoindex/_doc/1
{
  "name":"new item",
  "salary":1234
}

# get all
GET /nuevoindex/_search

# borrar dato en base al _id
DELETE nuevoindex/_doc/1

# get all paginacion
GET  /clientsmisiones/_search
{
  "from": 756,"size": 1
}

# query en la ruta
GET  /clientsmisiones/_search?q=name: "marco"

# query en la ruta con rango
GET  /employee/_search?q=salary:(>=600 AND <=1000)

# buscar un valor en multiples campos
GET /clientsmisiones/_search
{
  "query": {
    "multi_match": {
      "query": "marco avila",
      "fields": ["Nombre", "name", "Apellido", "lastname"]
    }
  }
}


# Busqueda de texto, se pueden usar expresiones regulares
GET /clientsmisiones/_search
{
  "query": {
    "query_string": {
      "query": "marco*"
    }
  }
}

# Busca datos en base a un rango de fechas
GET employee/_search
{
  "query": {
    "bool": {
      "filter": {
        "range": {
          "date": {
            "gte": "2020-11-03",
            "lt": "2021-11-03"
          }
        }
      }
    }
  }
}

# "must" funciona como AND
GET employee/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "term": {
            "first_name": "marco"
          }
        },
        {
          "term": {
            "last_name": "avila"
          }
        }
      ]
    }
  }
}

# "should" funciona como OR  
GET employees/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "term": {
            "first_name": "marco"
          }
        },
        {
          "term": {
            "first_name": "avila"
          }
        }
      ]
    }
  }
}
