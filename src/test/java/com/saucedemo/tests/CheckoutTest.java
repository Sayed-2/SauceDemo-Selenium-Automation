package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase {

    @Test
    public void checkout_information_test(){

        //1:  enter to the site
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        //2: enter to the products page
        ProductsPage productsPage = new ProductsPage();
        productsPage.addToCartSauceLabBackPack();
        productsPage.shoppingCartLink();

        //3: enter to the cart page
        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        //4: enter to the checkouts page
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterCheckoutInformation("Steve", "Craig", "780015");

        Assert.assertTrue(checkoutPage.checkoutTitle.isDisplayed());

    }

    @Test
    public void complete_order_test(){

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage();
        productsPage.addToCartSauceLabBackPack();
        productsPage.shoppingCartLink();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterCheckoutInformation("Steve", "Craig", "780015");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinish();

       /*
        System.out.println("CurrentUrl = " + Driver.getDriver().getCurrentUrl());
        System.out.println("CurrentTitle = " + Driver.getDriver().getTitle());

        System.out.println(
                Driver.getDriver()
                        .findElement(org.openqa.selenium.By.tagName("body"))
                        .getText()
        );
        */


        String actualOrderMessage = checkoutPage.getOrderConfirmationMessage();
        String expectedOrderMessage = "Thank you for your order!";
        Assert.assertEquals(actualOrderMessage, expectedOrderMessage);








    }
}
