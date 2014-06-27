package ua.com.rozetka.order.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class AssertTheDeliveryCost extends Page {

    WebDriver driver;


//    @FindBy(id = "suggest_locality")
//    private WebElement EneterCity;

//    @FindBy(xpath = "//section[@id='step_contacts']/div/div/div/div[2]/div[2]/div/div/div/ul/li")
//    private WebElement CityName;

    @FindBy(id = "reciever_phone")
    private WebElement EnterPhone;

    @FindBy(xpath = "//section[@id='step_contacts']/div/div/div[3]/div/span/button")
    private WebElement NextStep;

    @FindBy(xpath = "//div[@id='orders']/div/div/div[2]/div/div[2]/ul/li[2]/a")
    private WebElement Courier;

    @FindBy(xpath = "//div[@id='orders']/div/div/div[2]/div/div[2]/div/ul/li[2]/div/label/input")
    private WebElement NovaPoshta;

    @FindBy(xpath = "//div[@id='delivery_address']/div")
    private WebElement AssertDeliveryCostIsLoaded;

    @FindBy(xpath = "//div[@id='orders']/div/div/div[2]/div/div[2]/div[2]/ul/li/div/div/div/div")
    private WebElement DeliveryCost;

    @FindBy(xpath = "//div[@id='orders']/div/div/div[2]/div/div[2]/div/ul/li[2]/div/div/div/div")
    private WebElement DeliveryCostToNovaPoshta;

    @FindBy(xpath = "//aside[@id='total_block']/div[5]/a")
    private WebElement ChangeOrder;

    @FindBy(xpath = "//div[@id='cart-popup']/div/div/div/div[2]/div/div/a/img")
    private WebElement DeleteFromCart;

    @FindBy(xpath = "//aside[@id='total_block']/div/div/div")
    private WebElement GiftPresent;


    public AssertTheDeliveryCost(WebDriver driver) {
        super(driver);
    }


    public void enterPersonalData(String phone) {
//        EneterCity.click();
//        CityName.click();
        WaitForElementVisibility(EnterPhone);
        EnterPhone.click();
        EnterPhone.clear();
        EnterPhone.sendKeys(phone);
    }

    public void nextRegistrationStep() {
        WaitForElementVisibility(NextStep);
        NextStep.click();
        WaitForElementVisibility(Courier);

    }

    public String assertDeliveryCost() {
        Courier.click();
        WaitForElementVisibility(AssertDeliveryCostIsLoaded);
        return DeliveryCost.getText();
    }

    public String assertGiftIsGiven() {
        WaitForElementVisibility(GiftPresent);
        return GiftPresent.getText();
    }

    public String assertDeliveryCostToNovaPoshta() {
        NovaPoshta.click();
        WaitForElementVisibility(DeliveryCostToNovaPoshta);
        return DeliveryCostToNovaPoshta.getText();
    }

    public void deleteFromBasket() {
        WaitForElementVisibility(ChangeOrder);
        ChangeOrder.click();
        WaitForElementVisibility(DeleteFromCart);
        DeleteFromCart.click();
    }
}
