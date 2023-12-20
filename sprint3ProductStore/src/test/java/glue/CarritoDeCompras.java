package glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static java.lang.Thread.sleep;

public class CarritoDeCompras extends TestBase{
    // Background:
    @Given("El usuario se dirige la pantalla de inicio de sesion y se loguea con {string} y {string}")
    public void elUsuarioSeDirigeLaPantallaDeInicioDeSesionYSeLogueaConY(String username, String password) throws Exception {
        homePage.irALoguearse();
        loginPage.ingresarUsername(username);
        loginPage.ingresarPassword(password);
        loginPage.loginBtn();
        sleep(1000);
    }
    @Given("no tiene ningun producto agregado en el carrito")
    public void no_tiene_ningun_producto_agregado_en_el_carrito() throws Exception {
        homePage.irACarrito();
        cartPage.limpiarCarrito();
        cartPage.irAHomeDesdeCarrito();
    }


    // Scenario: Agregar un producto al carrito de compras
    @Given("se dirige a la seccion categoria {string}")
    public void seDirigeALaSeccionCategoriaLaptops(String categoria) throws Exception {
        homePage.irACategoria(categoria);
    }
    @And("se agrega un producto {string}")
    public void seAgregaUnProducto(String producto) throws Exception {
        homePage.agregarProducto(producto);
        sleep(1000);
    }
    @Then("se muestra un mensaje {string}")
    public void seMuestraUnMensaje(String mensajeProductoAgregado) {
        String resultadoEsperado = mensajeProductoAgregado;
        String resultadoActual = homePage.obtenerMensajeProductoAgregado(homePage.getDriver());

        Assert.assertEquals(resultadoEsperado, resultadoActual);

        // cerramos la ventana del alert.
        homePage.aceptarMensajeProductoAgregado(homePage.getDriver());
    }



    // Scenario: Agregar mas de 1 producto al carrito y ver que aparezcan correctamente agregados en el mismo.
    @When("se agrega correctamente el producto {string} al carrito y se acepta la alerta de confirmacion")
    public void seAgregaCorrectamenteElProductoAlCarritoYSeAceptaLaAlertaDeConfirmacion(String producto) throws Exception {
        homePage.agregarProducto(producto);
        sleep(2000);
        homePage.aceptarMensajeProductoAgregado(homePage.getDriver());
    }

    @When("se dirige a la pagina de home y se selecciona la categoria {string}")
    public void seDirigeALaPaginaDeHomeYSeSeleccionaLaCategoria(String categoria) throws Exception {
        homePage.irAHomeDesdeVistaProducto();
        homePage.irACategoria(categoria);
        sleep(2000);
    }
    @When("se dirige a la seccion del carrito")
    public void seDirigeALaSeccionDelCarrito() throws Exception {
        homePage.irACarrito();
    }
    @Then("se muestran en una tabla los productos agregados {string} y {string}")
    public void seMuestranEnUnaTablaLosProductosAgregadosY(String producto1, String producto2) throws Exception {
        boolean resultadoSiSeCargaronAlCarrito = cartPage.verificarProductosAgregados(producto1, producto2);
        Assert.assertTrue(resultadoSiSeCargaronAlCarrito);
    }


}
