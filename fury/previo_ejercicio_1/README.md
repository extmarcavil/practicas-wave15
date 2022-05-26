## Preguntas propuestas:

1. ¿Cuáles son las entidades que modelan esta solución? Diseñar un diagrama de clases.
2. ¿Cómo sería el flujo de ejecución desde que nos llega un request? Diseñar un diagrama que muestre dicho flujo.
3. ¿Qué ocurriría si nos llegan 1000 requests por minuto? ¿Y si llegaran 100.000? ¿Esta API tiene una implementación correcta? ¿Qué preguntas harías para pensar en optimizaciones a hacerle a la API?
4. Una vez deployada en producción, ¿cómo te vas a asegurar de enterarte si hay algún problema con tu aplicación? Por ejemplo: si hay un alto grado de errores.
5. Asumiendo que las cotizaciones cambian una vez al día, ¿qué opción podemos tomar para mejorar esta API?

## Respuestas

2. Entra la request por el endpoint del controller, de ahí se llama al service el cual se comunica con una API para solicitar el precio del ítem. Luego, se obtiene por medio de otro service que se comunica con otra api el ratio de conversión entre monedas. Se multiplican ambos valores y se devuelve un DTO con la información solicitada.

3. Lo que ocurrirá es que Fury iría escalando horizontalmente la aplicación a medida que el tráfico aumenta, para poder continuar trabajando sin interrupciones.

4. Estaría al tanto de las métricas otorgadas por DataDog, viendo como va evolucionando a lo largo del tiempo

5. Asumiendo que cambian una vez al día, se podría utilizar una caché para mantener guardado el valor, y actualizarlo una vez al día. De esta manera nos evitamos el tener que estar solicitando el valor por cada conversión.
