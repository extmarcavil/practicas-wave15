#### ¿Qué ocurriría si nos llegan 1000 requests por minuto? ¿Y si llegaran 100.000? ¿Esta API tiene una implementación correcta? ¿Qué preguntas harías para pensar en optimizaciones a hacerle a la API?
Preguntaría sobre el SLA de la API que convierte precios. 

#### Una vez deployada en producción, ¿cómo te vas a asegurar de enterarte si hay algún problema con tu aplicación? Por ejemplo: si hay un alto grado de errores.
Podría observar métricas en New Relic y Data Dog.

#### Asumiendo que las cotizaciones cambian una vez al día, ¿qué opción podemos tomar para mejorar esta API?
Podría preguntar una vez al día la cotización y guardarla en caché u otro lugar para no consultar a la API cada vez que se necesita la cotización.