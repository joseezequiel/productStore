package sprint2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import sprint2.utils.ClaseBase;

public class RegisterPage extends ClaseBase {
    // Centralizamos localizador
    By locatorTxtUsername = By.id("sign-username");
    By locatorTxtPassword = By.id("sign-password");
    By locatorBtnSignUp = By.xpath("//button[contains(text(),'Sign up')]");

    // Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Acciones del sitio
    public void ingresarUsername(String username){
        agregarTexto(esperarPorPresenciaDeElementoWeb(locatorTxtUsername), username);
    }

    public void ingresarPassword(String password){
        agregarTexto(esperarPorPresenciaDeElementoWeb(locatorTxtPassword), password);
    }

    public void signUpBtn(){
        click(esperarPorPresenciaDeElementoWeb(locatorBtnSignUp));
    }

    public String obtenerErrorFaltaUsernamePassword(WebDriver driver){
        return driver.switchTo().alert().getText();
    }
}
