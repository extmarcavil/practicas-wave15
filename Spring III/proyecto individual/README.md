# fp-be-java-hisp-w15-g06sbazzan
​
El objetivo de este proyecto correspondiente al Sprint 3 es implementar una API REST aplicando los contenidos trabajados durante el BOOTCAMP MELI WAVE 15 JAVA. (Git, Java, Spring, Bases de datos y calidad de software).
​
​
​
​
## Enunciado:
​
​
Este requerimiento se realiza de forma individual y reviste carácter de obligatorio.

La consigna consiste en crear/agregar una nueva Historia de Usuario al Proyecto Final, pero esta vez sin mediar especificación del problema a resolver por parte de Product Owner (PO), es decir, de carácter LIBRE. El participante tendrá la posibilidad de explorar creativamente diferentes alternativas de problemáticas posibles mientras estas se encuentren incluidas dentro del universo y la lógica de negocio propuesto por la cátedra en el Proyecto Final, para luego desarrollar e implementar la solución que considere más adecuada.

A su vez, el requerimiento contará con dos niveles de dificultad para su resolución:
El Nivel 1: Base, que incluye el desarrollo de entregables que serán base para el siguiente nivel..
El Nivel 2: Bonus, que incluye el desarrollo de entregables con especificaciones avanzadas.

A continuación se especifican los objetivos generales y entregables correspondientes para cada nivel.

Especificaciones generales

La Historia de Usuario propuesta para el requerimiento 6 debe:

Ser consistente con la lógica de negocios que propone el problema a resolver por la consigna del Proyecto Final.
Agregar valor a la implementación propuesta en los requerimientos anteriores.
Plantear y resolver un problema que se corresponda con una situación posible del negocio propuesto.
Considerar la posibilidad de que la propuesta deba ser presentada (o “vendida”) al Product Owner, a quien tendría que despertarle un interés por adquirirla y aprobar el proyecto.

Entregables
El Requerimiento 6 deberá ser entregado en la forma especificada en el enunciado inicial del Proyecto Final, es decir, mediante la creación y despliegue (deploy) en forma individual de una nueva API en la plataforma Fury, que deberá incluir todos los requerimientos del Proyecto Final, del Req. 1 al Req. 6.

Se le adicionarán los siguientes entregables de acuerdo a cada nivel.
Nivel 1: Base
Readme.txt descriptivo.
Documentación en PDF con formato de Historia de Usuario (plantilla disponible para descarga)
Historia de usuario con hasta 4 endpoints.
Colección de Postman con casos de prueba de cada endpoint.

Nivel 2: Bonus
Todos los entregables del Nivel 1 completos.
Diagrama de Clases (UML) del Proyecto Final (completo con todos los requerimientos).
Diagrama Entidad-Relación (DER) completo del Proyecto Final.
Historia de usuario con más de 4 endpoints (requerimiento 6).
​
​
## Especificación de requerimiento:
​
​
**User Story Code:** ml-checkBarchsInSecction-01

**User Story Name:** Consultar los lotes que se encuentran en cada sección

**Requerimiento:** Como Representante quiero poder consultar los lotes de productos que se encuentran en cada sección de warehouse.

**ESCENARIO 1:**
- Existe una sección perteneciente a un Representante registrado.
- Dado que existe una sección perteneciente a un Representante registrado, que el warehouse es válido, que el representante pertenece al warehouse, que el sector existe, el sector tiene lotes asignados.
- Cuando el representante ingresa el id de una sección se listan los lotes pertenecientes a dicha sección asociados a un determinado producto.

**VALIDACIÓN:**
Autenticarse como representante y acceder a los endpoints.
La sección asociado a esos lotes debe existir.
El lote debe estar asociado a una sección.

Representación JSON:

Response

```json
{
  "section": {
    "section_code": "long",
  }
    "batch": [
      {
        "batch_id": “long",
        “current_temperature": “Double”,
        “minimum_temperature": “Double”,
        “initial_quantity": “int",
        "current_quantity": “int”,
        “manufacturing_time: “dd-MM-yyyy hh:mm:ss”,
        “due_date”: “dd-MM-yyyy”
      }
    ]
}
```
No se llegó a una cobertura total del testing de código.

**Contratos referentes a la User Story:**

**HTTP:** GET

**Plantilla URI:** /api/v1/fresh-products/{idSection}

**Descripción:** Obtener la lista de los lotes contenidos en cada secciòn.

**US-code:** ml-checkBarchsInSecction-01

​
​
## Diagrama Entidad Relación
​
![DER Fresco DB](https://user-images.githubusercontent.com/103071441/173084970-d9609f3c-75d9-4bdb-b420-000cb0451c88.png)
​
​
## Consideraciones
​
- Un usuario se relaciona con un buyer o con un admin, no con ambos.
- Los lotes (Batches) de producto corresponden a una única orden de entrega (InboundOrder) mediante la cual conocen el almacén (Warehouse) y sector (Section) al que estan asignados.
- El lote posee un único producto, pero el producto puede estar en varios lotes.
- Al momento de ingresar una orden de entrega se tienen en cuenta las siguientes validaciones:
    - El producto de cada lote debe estar registrado en la base.
    - El almacén y sector deben existir.
    - El representante (Agent) debe pertenecer al almacén.
    - El producto debe pertenecer a la categoría del sector. Para esto se valida que las temeperaturas del producto ingresen dentro del rango del sector.
    - El sector debe tener espacio disponible para ingresar los lotes.
- Al momento de modificar una orden de entrega solo se actualizan los valores de cada lote perteneciente a la orden.
- Los productos de un carrito almacenan la cantidad solicitada y el precio total que luego se utiliza para calcular el valor total del pedido.
- Al momento de ingresar un pedido de compra se tienen en cuenta las siguientes validaciones:
    - El producto debe contar con stock en alguno de los lotes del sector con la categoría correspondiente.
    - El producto no debe haber expirado.
- La temperatura máxima del sector tiene que ser igual o mayor a la temperatura máxima del lote (current temperature). Lo mismo aplica para el mínimo.
- Los identificadores de cada entidad serán puestos como Long.
  A la hora de hacer las dos clases, el buyer tendra la purchase order e implementara el ENUM.
- El estado de la orden sera un ENUM con un único valor = SHOPPING_CART.
- El tipo de usuario sera un ENUM con dos valores posibles = BUYER y ADMIN.
- La categoría de producto sera un ENUM con tres posibles valores = FS, RF y FF.
  ​
  ​
