@Home
Feature: Cabecera
  Como usuario logueado y sin loguear
  Quiero poder ver siempre la barra de arriba
  Para poder acceder cómodamente a mis accesos a la "Home", "Contact", "About us", "Cart", "Log in", "Sign up"

  Scenario: Ver el video de about us, sin estar logueado
    Given estoy en cualquier parte de la pagina, en este caso en la home
    When hago click en el boton About Us
    Then se abre un modal que contiene el video.