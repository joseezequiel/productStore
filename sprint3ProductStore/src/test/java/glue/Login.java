package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class Login extends TestBase{
    @Given("El usuario se dirige la pantalla de inicio de sesion")
    public void elUsuarioSeDirigeLaPantallaDeInicioDeSesion() throws Exception {
        homePage.irALoguearse();
    }
    @When("se completa el campo Username con el dato {string}")
    public void seCompletaElCampoUsernameConElDato(String username) {
        loginPage.ingresarUsername(username);
    }
    @And("se completa el campo Password con el dato {string}")
    public void seCompletaElCampoPasswordConElDato(String password) {
        loginPage.ingresarPassword(password);
    }
    @And("se hace click en el boton Iniciar sesion")
    public void seHaceClickEnElBotonIniciarSesion() throws Exception {
        loginPage.loginBtn();
        sleep(3000);
    }
    @Then("visualizo en el encabezado de la pagina {string}")
    public void visualizoEnElEncabezadoDeLaPagina(String mensajeWelcome) throws Exception {
        String resultadoEsperado = mensajeWelcome;
        String resultadoActual= homePage.mensajeBienvenidaLogueado();
        Assert.assertEquals(resultadoEsperado, resultadoActual);
    }
}
