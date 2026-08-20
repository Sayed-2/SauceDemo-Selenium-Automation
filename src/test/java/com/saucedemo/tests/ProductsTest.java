package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ProductsTest extends TestBase {

    @Test
    public void verifyProductsPage(){

        LoginPage loginPage = new LoginPage();

        loginPage.inputUserName.sendKeys("standard_user");
        loginPage.inputPassword.sendKeys("secret_sauce");
        loginPage.loginButton.click();

        ProductsPage productsPage = new ProductsPage();

        Assert.assertTrue(productsPage.productsTitle.isDisplayed());
        Assert.assertTrue(productsPage.inventoryList.isDisplayed());
    }

    @Test
    public void add_to_cart_sauce_backpack_test() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");



        ProductsPage productsPage = new ProductsPage();
        productsPage.addToCartSauceLabBackPack();
        productsPage.shoppingCartLink();



        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.cartTitle.isDisplayed());
        String actualProductName = cartPage.inventoryItemName.getText();
        String expectedProductName = "Sauce Labs Backpack";
        Assert.assertEquals(actualProductName, expectedProductName);

        String actualPrice = cartPage.inventoryItemPrice.getText();
        String expectedPrice = "$29.99";
        Assert.assertEquals(actualPrice, expectedPrice);
    }
}
