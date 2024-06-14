## ENUNCIADO DE LA ACTIVIDAD:

Imagine que está desarrollando una aplicación de gestión de pedidos para una tienda en línea. Su tarea es implementar una función llamada procesarPedido que reciba como parámetro un pedido y realice las siguientes acciones:

1. Verificar si el producto solicitado está disponible en el inventario.

2. Si el producto está disponible, restar la cantidad solicitada del inventario y registrar el pedido.

3. Si el producto no está disponible, lanzar una excepción personalizada llamada ProductoNoDisponibleException.

 A continuación, se plantean algunas preguntas para guiar su implementación:

¿Qué excepciones estándar de Java utilizaría en este escenario?

¿Cómo implementaría la excepción personalizada ProductoNoDisponibleException?

¿Cómo manejaría las excepciones lanzadas durante el procesamiento del pedido en la función principal?

Tenga en cuenta que su implementación debe ser capaz de procesar múltiples pedidos en una sola ejecución.