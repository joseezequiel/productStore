package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClaseBase {
    //localizador
    @FindBy(xpath = "//body/nav[@id='narvbarx']/div[@id='navbarExample']/ul[1]/li[1]/a[1]")
    WebElement btnHome;

    // Atributos
    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    // Métodos
    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    // Encapsular los métodos de selenium
    public void click(By element) throws Exception{
        try {
            driver.findElement(element).click();
        } catch (Exception e){
            throw new Exception("No se pudo clickear sobre el boton "+ element);
        }
    }

    public void click(WebElement element) throws Exception{
        try {
            element.click();
        } catch (Exception e){
            throw new Exception("No se pudo clickear sobre el boton "+ element);
        }
    }

    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public void cargarSitio(String url){
        driver.get(url);
    }

    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        driver.quit();
    }

    public void ScrollingByWebElement(WebElement elemento){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", elemento);
    }

    public void esperarXSegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        }catch (Exception e){
            System.out.println("Se cayó la espera");
            System.out.println("Traza de error: " + e.getStackTrace());
        }
    }

    public WebElement esperarPorPresenciaDeElementoWeb(By localizador){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public WebElement esperarPorPresenciaDeElementoClickeable(By localizador){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    //agregado cuando se implemento Page Factory
    public WebElement esperarPorPresenciaDeElementoClickeable(WebElement elemento){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(elemento));
    }


    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el texto del elemento: " + element);
        }
    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        }catch (Exception e){
            throw new Exception("No se pudo obtener el texto del elemento: " + element);
        }
    }

    public void agregarTexto(By localizador, String texto){
        driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    // Metodos que pueden ser llamados por cualquier page
    public String obtenerTituloSitio(){
        return driver.getTitle();
    }

    //ir a la home
    public void irAHome() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnHome));
    }
}
