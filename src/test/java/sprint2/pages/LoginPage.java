package sprint2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sprint2.utils.ClaseBase;

public class LoginPage extends ClaseBase{

    // Centralizar los localizador
    By locatorFieldUsername = By.id("loginusername");
    By locatorFieldPassword = By.id("loginpassword");
    By locatorBtnLogin = By.xpath("//button[contains(text(),'Log in')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Acciones del sitio
    public void ingresarUsername(String username){
        agregarTexto(esperarPorPresenciaDeElementoWeb(locatorFieldUsername), username);
    }
    public void ingresarPassword(String password){
        agregarTexto(esperarPorPresenciaDeElementoWeb(locatorFieldPassword), password);
    }
    public void loginBtn(){
        click(esperarPorPresenciaDeElementoWeb(locatorBtnLogin));
    }
}
