# Creo nuevo index
PUT /zapatillas

#Ingreso datos
PUT /zapatillas/_doc/1
{
    "Marca": "Nike",
    "Modelo": "Modelo uno",
    "Tipo" : "Chancleta",
    "Talle" : 38 
}
PUT /zapatillas/_doc/2
{
    "Marca": "Adidas",
    "Modelo": "Modelo dos",
    "Tipo" : "Zapato"
  
}
PUT /zapatillas/_doc/3
{
    "Marca": "Nike",
    "Modelo": "Modelo tres",
    "Talle" : 40
  
}
PUT /zapatillas/_doc/4
{

    "Marca": "Converse",
    "Modelo": "Botita",
    "Tipo" : "Bota",
    "Talle" : 39
  
}
PUT /zapatillas/_doc/5
{

    "Marca": "Nike",
    "Modelo": "Modelo uno",
    "Talle" : 35 
  
}
PUT /zapatillas/_doc/6
{

    "Marca": "Adidas",
    "Modelo": "Modelo uno"
    
}

#Consultas para ver si trae correctamente
#Todas
GET /zapatillas/_search
#Las marca Nike
GET /zapatillas/_search?q=Marca: "Nike"
#La de id=1
GET /zapatillas/_doc/1
#con query
GET  /zapatillas/_doc/_search
{
  "query": {
    "match": {
      "Marca": "Nike"
    }
  }
}
