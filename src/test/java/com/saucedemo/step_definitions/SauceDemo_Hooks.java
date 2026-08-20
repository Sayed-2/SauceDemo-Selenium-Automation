package com.saucedemo.step_definitions;

import com.saucedemo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SauceDemo_Hooks {

    @Before
    public void setUP(){
        Driver.getDriver().get("https://www.saucedemo.com/");
        System.out.println("Current title: " + Driver.getDriver().getTitle() );
        System.out.println("Current url: " + Driver.getDriver().getCurrentUrl() );
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
