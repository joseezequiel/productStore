Feature: Registar
  Como usuario que aún no se loguea
  Quiero que el usuario pueda registrarse
  Para que luega pueda inciar sesion


  #Valida que no sea posible loguearme sin completar el campo password, mostrando una alerta
  @Registrar
  Scenario: Registro incorrecto: campo Username completado y campo Password sin completar
    Given El usuario abre la pantalla de registro
    When se completa el campo Username con "joseTest7"
    And se deja sin completar el campo Password
    And se hace click en el boton registrarse
    Then se visualiza el mensaje de error "Please fill out Username and Password."
