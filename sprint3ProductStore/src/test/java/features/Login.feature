Feature: Login
  Como usuario que ya está registrado
  Quiero que el usuario pueda loguearse usando su user y password
  Para que luega pueda inciar sesion

  @Login
  Scenario: Se inicia sesión con Username y Password correctos
    Given El usuario se dirige la pantalla de inicio de sesion
    When se completa el campo Username con el dato "joseTest1"
    And se completa el campo Password con el dato "joseTest1"
    And se hace click en el boton Iniciar sesion
    Then visualizo en el encabezado de la pagina "Welcome joseTest1"