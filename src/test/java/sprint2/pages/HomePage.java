package sprint2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sprint2.utils.ClaseBase;

public class HomePage extends ClaseBase {

    // Centralizar los localizador
    By locatorBtnRegistrarte = By.id("signin2");
    By locatorBtnLoguearse = By.id("login2");
    By locatorTxtWelcomeUser = By.id("nameofuser");
    By locatorBtnAgregarAlCarrito = By.xpath("//a[contains(text(),'Add to cart')]");
    By locatorBtnAboutUs = By.xpath("//a[contains(text(),'About us')]");
    By locatorTxtModalErrorCargaVideo = By.xpath("//body/div[@id='videoModal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[5]/div[1]");
    By locatorHeaderBtnHome = By.xpath("//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
    By locatorHeaderBtnCart = By.xpath("//a[@id='cartur']");


    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Crear las funciones de la pagina
    public void irARegistrarse(){
        click(esperarPorPresenciaDeElementoClickeable(locatorBtnRegistrarte));
    }
    public void irALoguearse(){
        click(esperarPorPresenciaDeElementoClickeable(locatorBtnLoguearse));
    }
    public String mensajeBienvenidaLogueado(){
        return obtenerTexto(locatorTxtWelcomeUser);
    }

    public void irACategoria(String categoria){
        By locatorLinkCategoriaLaptops = By.xpath("//a[contains(text(),'" + categoria + "')]");
        click(esperarPorPresenciaDeElementoClickeable(locatorLinkCategoriaLaptops));
    }
    public void agregarProducto(String nombreProducto){
        By locatorLinkProducto = By.xpath("//a[contains(text(),'"+nombreProducto+"')]");
        click(esperarPorPresenciaDeElementoClickeable(locatorLinkProducto));
        click(esperarPorPresenciaDeElementoClickeable(locatorBtnAgregarAlCarrito));
    }
    public String obtenerMensajeProductoAgregado(WebDriver driver){
        return driver.switchTo().alert().getText();
    }

    public void irAboutUs(){
        click(esperarPorPresenciaDeElementoClickeable(locatorBtnAboutUs));
    }
    public boolean cargaElVideo(){
        String textoError = obtenerTexto(locatorTxtModalErrorCargaVideo);
        if(textoError.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void aceptarMensajeProductoAgregado(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public void irAHome(){
        click(esperarPorPresenciaDeElementoClickeable(locatorHeaderBtnHome));
    }

    public void irACarrito(){
        click(esperarPorPresenciaDeElementoClickeable(locatorHeaderBtnCart));
    }
}


