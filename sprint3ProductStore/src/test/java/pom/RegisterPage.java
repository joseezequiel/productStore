package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ClaseBase;

import java.time.Duration;

public class RegisterPage extends ClaseBase {
    // Centralizamos localizador
    //By locatorTxtUsername = By.id("sign-username");
    @FindBy(id = "sign-username")
    WebElement txtUsername;
    //By locatorTxtPassword = By.id("sign-password");
    @FindBy(id = "sign-password")
    WebElement txtPassword;
    //By locatorBtnSignUp = By.xpath("//button[contains(text(),'Sign up')]");
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement btnSignUp;

    // Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Acciones del sitio
    public void ingresarUsername(String username){
        agregarTexto(esperarPorPresenciaDeElementoClickeable(txtUsername), username);
    }

    public void ingresarPassword(String password){
        agregarTexto(esperarPorPresenciaDeElementoClickeable(txtPassword), password);
    }

    public void signUpBtn() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnSignUp));
    }

    public String obtenerErrorFaltaUsernamePassword(WebDriver driver) {
        try {
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            // No hay alerta presente
            return "Error, no hay alerta presente"; //
        }
    }
}