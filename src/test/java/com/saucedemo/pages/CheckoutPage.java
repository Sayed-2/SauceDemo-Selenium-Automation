package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement checkoutTitle;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement orderConfirmationMessage;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement checkoutErrorMessage;


    // Actions
    //1:
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {

        BrowserUtils.waitForVisibleElement(this.firstName);
        BrowserUtils.waitForVisibleElement(this.lastName);
        BrowserUtils.waitForVisibleElement(this.postalCode);

        if (firstName != null && !firstName.isEmpty()) {
            this.firstName.sendKeys(firstName);
        }

        if (lastName != null && !lastName.isEmpty()) {
            this.lastName.sendKeys(lastName);
        }

        if (postalCode != null && !postalCode.isEmpty()) {
            this.postalCode.sendKeys(postalCode);
        }
    }



    //2:
    public void clickContinueButton(){
        BrowserUtils.waitForVisibleElement(continueButton);
        continueButton.click();
    }

    //3:
    public void clickFinish(){
        BrowserUtils.waitForVisibleElement(finishButton);
        finishButton.click();
    }


    //4:
    public String getOrderConfirmationMessage(){
        BrowserUtils.waitForVisibleElement(orderConfirmationMessage);
        return orderConfirmationMessage.getText();
    }

    //5
    public void completeOrder() {
        clickContinueButton();
        clickFinish();
    }

    //6
    public String getCheckoutErrorMessage(){
        BrowserUtils.waitForVisibleElement(checkoutErrorMessage);
        return checkoutErrorMessage.getText();
    }










}
