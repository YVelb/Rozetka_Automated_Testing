package ua.com.rozetka.order.runners;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BasicWebDriver {

    private WebDriver driver;

    @BeforeScenario
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void get(String url) {
        driver.get(url);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    @AfterScenario
    public void tearDown() {
        driver.close();
    }

}
