package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ClaseBase;

public class  HomePage extends ClaseBase {

    // Centralizar los localizador
    @FindBy(id = "signin2")
    WebElement btnRegistrarte;

    @FindBy(id = "login2")
    WebElement btnLoguearse;

    @FindBy(id = "nameofuser")
    WebElement txtWelcomeUser;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement btnAgregarAlCarrito;

    @FindBy(xpath = "//a[contains(text(),'About us')]")
    WebElement btnAboutUs;

    @FindBy(xpath = "//div[contains(text(),'The media could not be loaded, either because the ')]")
    WebElement txtModalErrorCargaVideo;

    @FindBy(xpath = "//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    WebElement headerBtnHome;

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement btnCart;


    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Crear las funciones de la pagina
    public void irARegistrarse() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnRegistrarte));
    }
    public void irALoguearse() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnLoguearse));
    }
    public String mensajeBienvenidaLogueado() throws Exception {
        return getText(txtWelcomeUser);
    }

    public void irACategoria(String categoria) throws Exception {
        By locatorLinkCategoriaLaptops = By.xpath("//a[contains(text(),'" + categoria + "')]");
        click(esperarPorPresenciaDeElementoClickeable(locatorLinkCategoriaLaptops));
    }
    public void agregarProducto(String nombreProducto) throws Exception {
        By locatorLinkProducto = By.xpath("//a[contains(text(),'"+nombreProducto+"')]");
        click(esperarPorPresenciaDeElementoClickeable(locatorLinkProducto));
        click(esperarPorPresenciaDeElementoClickeable(btnAgregarAlCarrito));
    }
    public String obtenerMensajeProductoAgregado(WebDriver driver){
        return driver.switchTo().alert().getText();
    }

    public boolean cargaElVideo() throws Exception {
        // Encontrar el elemento de video dentro del modal
        WebElement videoElement = getDriver().findElement(By.id("example-video_html5_api"));

        /*******************************************/
        // Descomentar las 2 lineas de abajo para forzar el failed del test es decir, para simular que no cargue el video
        //JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        //jsExecutor.executeScript("arguments[0].src = '';", videoElement);
        /*******************************************/

        // Esperar a que el elemento del modal esté presente
        WebElement esperarAQueCargueElModal = esperarPorPresenciaDeElementoClickeable(By.id("videoModal"));

        WebElement modalElement = esperarPorPresenciaDeElementoWeb(By.xpath("//div[@class='vjs-modal-dialog-content']"));

        // Obtener el texto del modal solo si el elemento está presente
        String textoError = getText(modalElement);

        // devuelve true si no hay error--> Passed el caso
        return textoError.isEmpty();
    }

    public void aceptarMensajeProductoAgregado(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public void irAHomeDesdeVistaProducto() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(headerBtnHome));
    }

    public void irACarrito() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnCart));
    }

    public void irAAboutUs() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnAboutUs));
    }
}


