package com.saucedemo.tests;

import com.saucedemo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    @BeforeMethod
    public void setup(){
        Driver.getDriver();
        Driver.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
