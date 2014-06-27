package ua.com.rozetka.order.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    WebDriver driver;

    @FindBy(name = "signin")
    private WebElement LoginLink;

    @FindBy(name = "login")
    private WebElement LogIn;

    @FindBy(name = "password")
    private WebElement Pass;

    @FindBy(xpath = "//div/button[@type='submit']")
    private WebElement ConfirmBtn;

    @FindBy(xpath = "//div/a[@name='signout']")
    private WebElement LogoutBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void signInButton() {
        LoginLink.click();
    }

    public void loginEnter(String LoginName) {
        LogIn.click();
        LogIn.clear();
        LogIn.sendKeys(LoginName);
    }

    public void passwordEnter(String PasswordIs) {
        Pass.click();
        Pass.clear();
        Pass.sendKeys(PasswordIs);
    }

    public void pressSubmit() {
        ConfirmBtn.click();
        WaitForElementVisibility(LogoutBtn);
    }
}
