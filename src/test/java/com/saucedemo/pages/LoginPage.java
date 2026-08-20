package com.saucedemo.pages;

import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='user-name']")
            public WebElement inputUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;


    @FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
    public WebElement errorMessage;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
    public WebElement emptyUsernameErrorMessage;

    @FindBy(xpath = "//h3[text()='Epic sadface: Password is required']")
    public WebElement emptyPasswordErrorMessage;

    //To make our code refactor and more clean:
    public void login(String username, String password){
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }




}
