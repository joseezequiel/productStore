package runner.browser_manager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{
    @Override
    protected void createDriver() {
        driver = new ChromeDriver();
    }
}
