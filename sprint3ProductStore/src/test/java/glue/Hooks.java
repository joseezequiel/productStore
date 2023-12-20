package glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Hooks {
    private static WebDriver driver;
    private DriverManager driverManager;

    @Before
    public void setUp(){
        // descarga el chromedriver
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        byte[] screenShoot;
        if(scenario.isFailed()){
            screenShoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShoot, "image/png", scenario.getName());
            scenario.log("Falló el step del escenario.");
        } else {
            screenShoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShoot, "image/png", scenario.getName());
            scenario.log("Escenario OK.");
        }
        //driver.quit();
        driverManager.quitDriver();
    }

    // método de la clase
    public static WebDriver getDriver(){
        return driver;
    }
}
