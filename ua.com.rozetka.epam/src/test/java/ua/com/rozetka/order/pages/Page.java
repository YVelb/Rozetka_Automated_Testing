package ua.com.rozetka.order.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void WaitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30, 1);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean CartIsNotEmpty() {
        try {
            driver.findElement(By.xpath("//a[@onclick=\"document.fireEvent('goToCheckoutFromHead');\"]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}