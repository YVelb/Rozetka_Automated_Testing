package ua.com.rozetka.order.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FindGoods extends Page {

    @FindBy(css = "div.m-cart-full > a[name=\"open_cart\"]")
    private WebElement CartIsNotEmpty;

    @FindBy(xpath = "//div[@id='cart-popup']/div/div/div/div[2]/div/div/a/img")
    private WebElement DeleteFromCart;

    @FindBy(xpath = "//div[@id='cart-popup']/div/a/img")
    private WebElement CloseCart;

    @FindBy(xpath = "//td[@id='tv-photo-video']/div/a")
    private WebElement SearchCategory;

    @FindBy(xpath = "//div[@id='head_banner_container']/div[3]/div/div/div[2]/div[3]/ul/li[5]/ul/li/a")
    private WebElement SearchWord;


    public FindGoods(WebDriver driver) {
        super(driver);
    }


    public void lookForCategory() {

        if (CartIsNotEmpty() == true) {
            CartIsNotEmpty.click();
            WaitForElementVisibility(DeleteFromCart);
            DeleteFromCart.click();
            WaitForElementVisibility(CloseCart);
            CloseCart.click();
            WaitForElementVisibility(SearchCategory);
            SearchCategory.click();
        } else {
            SearchCategory.click();
        }
    }

    public void lookForGoods() {
        SearchWord.click();

    }


}
