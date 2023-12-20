package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Home extends TestBase{
    @Given("estoy en cualquier parte de la pagina, en este caso en la home")
    public void estoyEnCualquierParteDeLaPaginaEnEsteCasoEnLaHome() throws Exception {
        homePage.irAHome();
    }
    @When("hago click en el boton About Us")
    public void hagoClickEnElBotonAboutUs() throws Exception {
        homePage.irAAboutUs();
    }
    @Then("se abre un modal que contiene el video.")
    public void seAbreUnModalQueContieneElVideo() throws Exception {
        boolean resultadoSiCargaVideo = homePage.cargaElVideo();
        Assert.assertTrue(resultadoSiCargaVideo);
    }
}
