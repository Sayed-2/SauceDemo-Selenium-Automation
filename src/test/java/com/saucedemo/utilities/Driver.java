package com.saucedemo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class Driver {

    private Driver(){};

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if ( driver == null){
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");

            options.setExperimentalOption("prefs", Map.of(
                    "credentials_enable_service", false,
                    "profile.password_manager_leak_detection", false
            ));

            driver = new ChromeDriver(options);

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
