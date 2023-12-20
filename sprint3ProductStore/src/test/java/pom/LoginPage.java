package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ClaseBase;

public class
LoginPage extends ClaseBase{

    // Centralizar los localizador
    //By locatorFieldUsername = By.id("loginusername");
    @FindBy(id = "loginusername")
    WebElement fieldUsername;
    //By locatorFieldPassword = By.id("loginpassword");
    @FindBy(id = "loginpassword")
    WebElement fieldPassword;
    //By locatorBtnLogin = By.xpath("//button[contains(text(),'Log in')]");
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement btnLogin;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Acciones del sitio
    public void ingresarUsername(String username){
        agregarTexto(esperarPorPresenciaDeElementoClickeable(fieldUsername), username);
    }
    public void ingresarPassword(String password){
        agregarTexto(esperarPorPresenciaDeElementoClickeable(fieldPassword), password);
    }
    public void loginBtn() throws Exception {
        click(esperarPorPresenciaDeElementoClickeable(btnLogin));
    }
}