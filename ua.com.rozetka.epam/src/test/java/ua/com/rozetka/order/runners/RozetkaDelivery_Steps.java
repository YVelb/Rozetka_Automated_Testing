package ua.com.rozetka.order.runners;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ua.com.rozetka.order.pages.AddToCart;
import ua.com.rozetka.order.pages.AssertTheDeliveryCost;
import ua.com.rozetka.order.pages.FindGoods;
import ua.com.rozetka.order.pages.LoginPage;

public class RozetkaDelivery_Steps extends BasicWebDriver {

    private LoginPage loginPage;
    private FindGoods findGoods;
    private AddToCart addToCart;
    private AssertTheDeliveryCost assertTheDeliveryCost;

    private String assertOneThing = ".*1.*";
    private String deliveryCostPresent = "35 грн.";
    private String noDeliveryCost = "бесплатно";
    private String priceLessThen = "1500";
    private String priceMoreThen = "1700";
    private String priceMax = "20000";
    private String LoginName = "autobot13579@gmail.com";
    private String PasswordIs = "password";
    private String Phone = "0933637198";


    @Given("home page of $url")
    public void givenHomePageOfRozetka(String url) {
        get(url);
        loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
        loginPage.waitForPageToLoad();
    }

    @Given("successful login")
    public void givenSuccessLogin() {
        loginPage.signInButton();
        loginPage.loginEnter(LoginName);
        loginPage.passwordEnter(PasswordIs);
        loginPage.pressSubmit();
    }

    @When("the user has found goods")
    public void whenGoodsAreFound() {
        findGoods = PageFactory.initElements(getWebDriver(), FindGoods.class);
        findGoods.waitForPageToLoad();
        findGoods.lookForCategory();
        findGoods.waitForPageToLoad();
        findGoods.lookForGoods();
    }

    @When("added goods for less then 1500 hrn to his shopping cart")
    public void whenGoodsLessThen1500AreAddedToTheBasket() {
        addToCart = PageFactory.initElements(getWebDriver(), AddToCart.class);
        addToCart.waitForPageToLoad();
        addToCart.selectPriceLessThen(priceLessThen);
        addToCart.waitForPageToLoad();
        addToCart.addingToCart();
        addToCart.waitForPageToLoad();
        addToCart.goToCheckout();
    }

    @When("added goods for 1500 hrn or more to his shopping cart")
    public void whenGoodsMoreThen1500AreAddedToTheBasket() {
        addToCart = PageFactory.initElements(getWebDriver(), AddToCart.class);
        addToCart.waitForPageToLoad();
        addToCart.selectPriceMoreThen(priceMoreThen);
        addToCart.waitForPageToLoad();
        addToCart.addingToCart();
        addToCart.waitForPageToLoad();
        addToCart.goToCheckout();
    }

    @When("added goods for more then 20000 hrn to his shopping cart")
    public void whenGoodsMoreThen20000AreAddedToTheBasket() {
        addToCart = PageFactory.initElements(getWebDriver(), AddToCart.class);
        addToCart.waitForPageToLoad();
        addToCart.selectPriceMoreThen(priceMax);
        addToCart.waitForPageToLoad();
        addToCart.addingToCart();
        addToCart.waitForPageToLoad();
        addToCart.goToCheckout();
    }

    @When("proceeded to checkout")
    public void whenTheUserHasProceededToCheckout() {
        assertTheDeliveryCost = PageFactory.initElements(getWebDriver(), AssertTheDeliveryCost.class);
        assertTheDeliveryCost.waitForPageToLoad();
        assertTheDeliveryCost.enterPersonalData(Phone);
        assertTheDeliveryCost.nextRegistrationStep();
    }

    @Then("verify delivery cost is 35 hryvnas")
    public void thenCheckDeliveryCostIs35() {
        assertTheDeliveryCost.waitForPageToLoad();
        assertEquals(deliveryCostPresent, assertTheDeliveryCost.assertDeliveryCost());
        assertTheDeliveryCost.deleteFromBasket();
    }

    @Then("verify delivery is free")
    public void thenCheckDeliveryCostIsFree() {
        assertTheDeliveryCost.waitForPageToLoad();
        assertEquals(noDeliveryCost, assertTheDeliveryCost.assertDeliveryCost());
        assertTheDeliveryCost.deleteFromBasket();
    }

    @Then("verify that free present is granted")
    public void thenCheckFreeGiftGrantSample() {
        assertTheDeliveryCost.waitForPageToLoad();
        assertTrue(assertTheDeliveryCost.assertGiftIsGiven().matches(assertOneThing));
        assertTheDeliveryCost.deleteFromBasket();
    }
    @Then("verify delivery cost to the nearest Nova Poshta filia is 35 hryvnas")
    public void thenCheckDeliveryToNovaPoshtais35() {
        assertTheDeliveryCost.waitForPageToLoad();
        assertEquals(deliveryCostPresent, assertTheDeliveryCost.assertDeliveryCostToNovaPoshta());
        assertTheDeliveryCost.deleteFromBasket();
    }
}

