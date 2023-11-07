package sprint2.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ClaseBase {
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
    public void click(By localizador){
        driver.findElement(localizador).click();
    }

    public void click(WebElement elemento){
        elemento.click();
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
        wait = new WebDriverWait(this.driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public WebElement esperarPorPresenciaDeElementoClickeable(By localizador){
        wait = new WebDriverWait(this.driver, 30);
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public String obtenerTexto(By localizador){
        return driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemnto){
        return elemnto.getText();
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

    public WebDriver conexionDriver(String browser, String ruta, String property){
        switch (browser){
            case "chrome":
                System.setProperty(property, ruta);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(property, ruta);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty(property, ruta);
                driver = new EdgeDriver();
                break;
        }
        return driver;
    }
}
