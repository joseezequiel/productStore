package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Registrar extends TestBase{
    @Given("El usuario abre la pantalla de registro")
    public void elUsuarioAbreLaPantallaDeRegistro() throws Exception {
        homePage.irARegistrarse();
        homePage.esperarXSegundos(3000);
    }
    @When("se completa el campo Username con {string}")
    public void seCompletaElCampoUsernameCon(String username) {
        registerPage.ingresarUsername(username);
    }
    @And("se deja sin completar el campo Password")
    public void seDejaSinCompletarElCampoPassword() {
        registerPage.ingresarPassword("");
    }
    @And("se hace click en el boton registrarse")
    public void seHaceClickEnElBotonRegistrarse() throws Exception {
        registerPage.signUpBtn();
    }
    @Then("se visualiza el mensaje de error {string}")
    public void seVisualizaElMensajeDeError(String mensajeCompletarUserYPass) {
        String resultadoEsperado = mensajeCompletarUserYPass;
        String resultadoActual= registerPage.obtenerErrorFaltaUsernamePassword(Hooks.getDriver());
        Assert.assertEquals(resultadoEsperado, resultadoActual);

        // La captura de pantalla, captura el contenido visible en la ventana del navegador.
        // Sin embargo, las alertas del sistema en el navegador generalmente no son parte del contenido visible en la ventana
        // del navegador, por lo que no se capturan directamente con la captura de pantalla.

        // cerramos la ventana del alert, ya que si no la cerramos da error y tira el test abajo.
        homePage.aceptarMensajeProductoAgregado(homePage.getDriver());
    }
}
