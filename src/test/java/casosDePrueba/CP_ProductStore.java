package casosDePrueba;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CP_ProductStore {
    private WebDriver driver;

    @BeforeEach
    public void preCondiciones(){
        // Parametrizar la ruta del driver
        String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";

        // Enlazar el Webdriver de chrome al browser (Chrome)
        System.setProperty("webdriver.chrome.driver", rutaDriver);

        // Instanciar un objeto de tipo webdriver de chrome y carga la web de prueba
        driver =new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void posCondiones(){
        driver.quit();
    }

    @Test
    public void CP001_registrarse() throws InterruptedException{
        WebElement btnSignUp = driver.findElement(By.id("signin2"));
        btnSignUp.click();

        Thread.sleep(1000);

        driver.findElement(By.id("sign-username")).sendKeys("joseTest6");
        driver.findElement(By.id("sign-password")).sendKeys("joseTest6");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        Thread.sleep(1000);

        String alertMessageSignUpSuccess = driver.switchTo().alert().getText();
        assertTrue(alertMessageSignUpSuccess.contains("Sign up successful."));
    }

    @Test
    public void CP002_loguearse() throws InterruptedException{
        String userName = "joseTest1";
        String password = "joseTest1";

        WebElement btnSignUp = driver.findElement(By.id("login2"));
        btnSignUp.click();

        Thread.sleep(1000);

        driver.findElement(By.id("loginusername")).sendKeys(userName);
        driver.findElement(By.id("loginpassword")).sendKeys(password);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        Thread.sleep(3000);

        // Para comprobar que se logueó correctamente se toma el texto "Welcome nombreUsuario" que aparece arriba a la derecha
        String nombreUsuarioLogueado = driver.findElement(By.id("nameofuser")).getText();
        Thread.sleep(3000);
        assertTrue(nombreUsuarioLogueado.contains("Welcome " + userName));
    }

    @Test
    public void CP003_enviarMensajeDeContacto() throws InterruptedException{
        String userName = "joseTest1";
        String password = "joseTest1";

        String contactEmail = "test@gmail.com";
        String contactName = "Jose Valdez";
        String message = "Este es una prueba de envio de mensaje de contacto";

        WebElement btnSignUp = driver.findElement(By.id("login2"));
        btnSignUp.click();

        Thread.sleep(3000);

        driver.findElement(By.id("loginusername")).sendKeys(userName);
        driver.findElement(By.id("loginpassword")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        Thread.sleep(3000);

        // Abrir el modal de contacto
        WebElement btnContact = driver.findElement(By.xpath("//a[contains(text(),'Contact')]"));
        btnContact.click();

        Thread.sleep(2000);

        // Completar los campos de contacto
        driver.findElement(By.id("recipient-email")).sendKeys(contactEmail);
        driver.findElement(By.id("recipient-name")).sendKeys(contactName);
        driver.findElement(By.id("message-text")).sendKeys(message);

        Thread.sleep(2000);

        // Enviar el mensaje
        WebElement btnSendMessage = driver.findElement(By.xpath("//button[contains(text(),'Send message')]"));
        btnSendMessage.click();
        Thread.sleep(2000);

        // Comprobar el alert con el mensaje de que se envió correctamente la info de contacto
        String alertMessageContact = driver.switchTo().alert().getText();
        assertTrue(alertMessageContact.contains("Thanks for the message!!"));
    }
}
