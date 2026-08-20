package com.saucedemo.utilities;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static{
        try{
            FileInputStream file = new FileInputStream("src/test/resources/configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //getterMethod
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
