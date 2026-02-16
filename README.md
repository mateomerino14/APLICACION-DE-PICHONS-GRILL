==========APLICACION DE PICHONS GRILL==========

====DESCRIPCIÓN====

  Este proyecto implementa una aplicación de pedidos de comida para llevar utilizando Programación Orientada a Objetos (POO) en Java, desarrollada completamente en el entorno BlueJ.
  La aplicación modela el proceso completo de un sistema de pedidos: desde que el cliente selecciona productos hasta que se genera el pago y se asigna un repartidor.

====ESTRUCTURA DE CLASES====

  ----USUARIOS Y PERSONAS----
  -Usuario.java - Clase base para usuarios del sistema
  -Cliente.java - Cliente que realiza los pedidos
  -Cajero.java - Atiende y procesa los pedidos
  -Repartidor.java - Responsable de la entrega

  ----PRODUCTOS Y MENÚ----
  -Producto.java - Clase abstracta base para productos
  -Plato.java - Comidas del menú
  -Bebida.java - Bebidas disponibles
  -Menu.java - Gestiona el catálogo de productos

  ----GESTIÓN DE PEDIDOS----
  -Pedido.java - Representa un pedido completo
  -Carrito.java - Carrito de compras temporal
  -Caja.java - Punto de cobro y gestión de pagos
  
  ----MÉTODOS DE PAGO----
  -Pago.java - Clase abstracta para pagos
  -Efectivo.java - Pago en efectivo
  -TarjetaCredito.java - Pago con tarjeta
  -QR.java - Pago mediante código QR
  
  ----OTROS COMPONENTES----
  -Notificacion.java - Mensajes de confirmación y estado
  -Aplicacion.java - Clase principal con método main


====CARACTERÍSTICAS POO IMPLEMENTADAS====

  ----ABSTRACCIÓN----
  -Clases que modelan entidades del mundo real (Cliente, Pedido, Producto)
  -Métodos que representan comportamientos específicos
  
  ----ENCAPSULAMIENTO----
  -Atributos privados con getters y setters
  -Ocultamiento de la implementación interna
  
  ----HERENCIA----
  -Producto como clase base para Plato y Bebida
  -Pago como clase base para Efectivo, TarjetaCredito y QR
  -Usuario como clase base para Cliente, Cajero y Repartidor
  
  ----POLIMORFISMO----
  -Métodos sobrescritos en clases hijas
  -Referencias de tipo padre apuntando a objetos hijos
  
  ----POLIMORFISMO----
  -Métodos sobrescritos en clases hijas
  -Referencias de tipo padre apuntando a objetos hijos
