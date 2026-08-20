package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utilities.ConfigurationReader;
import com.saucedemo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTest(){

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce" );


        // Create ProductsPage object
        ProductsPage productsPage = new ProductsPage();
        // Verify successful login
        Assert.assertTrue(productsPage.productsTitle.isDisplayed() );

        System.out.println(ConfigurationReader.getProperty("url"));
    }
}
