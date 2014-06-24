package ua.com.rozetka.order.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends Page {

    @FindBy(name = "topurchasesfromcatalog")
    private WebElement AddToCart;

    @FindBy(id = "price[max]")
    private WebElement MaxPrice;

    @FindBy(id = "price[min]")
    private WebElement MinPrice;

    @FindBy(id = "submitprice")
    private WebElement SubmitPrice;

    @FindBy(xpath = "//button[@id='popup-checkout']")
    private WebElement CheckOut;


    public AddToCart(WebDriver driver) {
        super(driver);
    }

    public void selectPriceLessThen(String price) {
        WaitForElementVisibility(MaxPrice);
        MaxPrice.click();
        MaxPrice.clear();
        MaxPrice.sendKeys(price);
        WaitForElementVisibility(SubmitPrice);
        SubmitPrice.click();
    }

    public void selectPriceMoreThen(String price) {
        WaitForElementVisibility(MinPrice);
        MinPrice.click();
        MinPrice.clear();
        MinPrice.sendKeys(price);
        WaitForElementVisibility(SubmitPrice);
        SubmitPrice.click();
    }

    public void addingToCart() {
        WaitForElementVisibility(AddToCart);
        AddToCart.click();
    }

    public void goToCheckout() {
        WaitForElementVisibility(CheckOut);
        CheckOut.click();
    }

}
