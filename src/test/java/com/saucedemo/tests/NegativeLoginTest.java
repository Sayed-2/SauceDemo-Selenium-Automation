package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {


    @Test
    public void invalid_password() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "wrong_password");

        // for assertions
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


    }

    @Test
    public void invalid_username(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong_user", "wrong_password");

        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);



    }

    @Test
    public void empty_username(){
        LoginPage loginPage = new LoginPage();

        loginPage.login("", "secret_sauce");

        String actualEUMS = loginPage.emptyUsernameErrorMessage.getText();
        String expectedEUMS = "Epic sadface: Username is required";
        Assert.assertEquals(actualEUMS, expectedEUMS);
    }

    @Test
    public void empty_password(){

        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "");

        String actualEPMS = loginPage.emptyPasswordErrorMessage.getText();
        String expectedEPMS = "Epic sadface: Password is required";
        Assert.assertEquals(actualEPMS, expectedEPMS);
        System.out.println("actualEPMS = " + actualEPMS);
    }
}



