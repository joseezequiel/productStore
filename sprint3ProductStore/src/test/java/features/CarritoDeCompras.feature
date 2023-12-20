@CarritoDeCompras
Feature: Carrito de compras
  Como usuario logueado
  Quiero poder agregar, quitar
  Para poder comprar lo que se haya puesto en el carrito de compras

  Background:
    Given El usuario se dirige la pantalla de inicio de sesion y se loguea con "joseTest1" y "joseTest1"
    And no tiene ningun producto agregado en el carrito

  Scenario: Agregar un producto al carrito de compras para verificar que salga el mensaje de confirmacion
    Given se dirige a la seccion categoria "Laptops"
    When se agrega un producto "Sony vaio i5"
    Then se muestra un mensaje "Product added."

  Scenario: Agregar mas de 1 producto al carrito y ver que aparezcan correctamente agregados en el mismo.
    Given se dirige a la seccion categoria "Laptops"
    When se agrega correctamente el producto "Sony vaio i5" al carrito y se acepta la alerta de confirmacion
    And se dirige a la pagina de home y se selecciona la categoria "Phones"
    And se agrega correctamente el producto "Iphone 6 32gb" al carrito y se acepta la alerta de confirmacion
    And se dirige a la seccion del carrito
    Then se muestran en una tabla los productos agregados "Sony vaio i5" y "Iphone 6 32gb"