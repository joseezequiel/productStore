package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.CartPage;
import pom.HomePage;
import pom.LoginPage;
import pom.RegisterPage;

public class TestBase {
    protected WebDriver driver = Hooks.getDriver();

    // Page Object
    //protected HomePage homePage = new HomePage(driver);
    //protected CartPage cartPage = new CartPage(driver);
    //protected LoginPage loginPage = new LoginPage(driver);
    //protected RegisterPage registerPage = new RegisterPage(driver);

    // PAGE FACTORY
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    protected LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    protected RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);


}
