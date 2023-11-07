package sprint2.tests;

import org.apache.commons.math3.analysis.function.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import sprint2.pages.CartPage;
import sprint2.pages.HomePage;
import sprint2.pages.LoginPage;
import sprint2.pages.RegisterPage;
import sprint2.utils.DataDriven;
import sprint2.utils.PropertiesManager;

import java.util.ArrayList;

public class CPs {
    // Definir atributos
    WebDriver driver;
    HomePage home;
    RegisterPage register;
    LoginPage login;
    CartPage carrito;

    ArrayList<String> data;

    String url = PropertiesManager.obtenerProperty("url");
    String browser = PropertiesManager.obtenerProperty("browser");
    String propertyDriver = PropertiesManager.obtenerProperty("propertyDriver");
    String ruta = PropertiesManager.obtenerProperty("rutaDriver");

    @BeforeEach
    public void preCondiciones() {
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        carrito = new CartPage(driver);

        home.conexionDriver(browser, ruta, propertyDriver);

        register = new RegisterPage(home.getDriver());
        login = new LoginPage(home.getDriver());
        carrito = new CartPage(home.getDriver());

        home.cargarSitio(url);
        home.maximizarBrowser();
        data = new ArrayList<>();
    }

    @AfterEach
    public void posCondiciones() {
        //if(home.getDriver().getCurrentUrl().equals("https://www.demoblaze.com/cart.html")){
            //home.esperarXSegundos(3000);
            //    carrito.eliminarProductos();
        //}
        home.cerrarBrowser();
    }

    @Test
    public void cp001_error_creacion_cta_campos_vacios(){
        data = DataDriven.prepararData("cp001_error_creacion_cta_campos_vacios");
        home.irARegistrarse();
        home.esperarXSegundos(3000);
        register.ingresarUsername(data.get(1));
        register.ingresarPassword("");
        register.signUpBtn();

        String resultadoEsperado = data.get(2);
        String resultadoActual = register.obtenerErrorFaltaUsernamePassword(register.getDriver());

        Assertions.assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    public void cp002_loguearse_correctamente(){
        data = DataDriven.prepararData("cp002_loguearse_correctamente");
        home.irALoguearse();
        home.esperarXSegundos(3000);
        login.ingresarUsername(data.get(1));
        login.ingresarPassword(data.get(2));
        login.loginBtn();

        login.esperarXSegundos(3000);
        String resultadoEsperado = data.get(3) + " " + data.get(1);
        String txtBienvenidaLogueadoResultadoActual = home.mensajeBienvenidaLogueado();
        Assertions.assertEquals(resultadoEsperado, txtBienvenidaLogueadoResultadoActual);
    }

    @Test
    public void cp003_agregar_un_producto_al_carrito(){
        data = DataDriven.prepararData("cp003_agregar_un_producto_al_carrito");
        home.irALoguearse();
        home.esperarXSegundos(3000);
        login.ingresarUsername(data.get(1));
        login.ingresarPassword(data.get(2));
        login.loginBtn();

        home.esperarXSegundos(3000);
        home.irACategoria("Laptops");
        home.agregarProducto(data.get(3));
        home.esperarXSegundos(3000);

        String resultadoEsperado = data.get(4);
        String resultadoActual = home.obtenerMensajeProductoAgregado(home.getDriver());

        Assertions.assertEquals(resultadoEsperado, resultadoActual);

        home.aceptarMensajeProductoAgregado(home.getDriver());
    }

    @Test
    public void cp004_video_de_aboutUs_se_pueda_reproducir(){
        data = DataDriven.prepararData("cp004_video_de_aboutUs_se_pueda_reproducir");
        home.irAboutUs();
        boolean resultadoSiCargaVideo = home.cargaElVideo();
        Assertions.assertTrue(resultadoSiCargaVideo);
    }

    @Test
    public void cp005_agregar_productos_y_ver_en_el_carrito(){
        data = DataDriven.prepararData("cp005_agregar_productos_y_ver_en_el_carrito");
        home.irALoguearse();
        home.esperarXSegundos(3000);
        login.ingresarUsername(data.get(1));
        login.ingresarPassword(data.get(2));
        login.loginBtn();

        home.esperarXSegundos(3000);
        home.irACategoria("Laptops");
        home.agregarProducto(data.get(3));
        home.esperarXSegundos(3000);
        home.aceptarMensajeProductoAgregado(home.getDriver());
        home.irAHome();

        home.esperarXSegundos(3000);
        home.irACategoria("Phones");
        home.agregarProducto(data.get(4));
        home.esperarXSegundos(3000);
        home.aceptarMensajeProductoAgregado(home.getDriver());
        home.irACarrito();

        boolean resultadoSiSeCargaronAlCarrito = carrito.verificarProductosAgregados(data.get(3), data.get(4));
        Assertions.assertTrue(resultadoSiSeCargaronAlCarrito);
    }

}
