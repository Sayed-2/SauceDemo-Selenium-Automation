package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement cartTitle;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    public WebElement inventoryItemName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public WebElement inventoryItemPrice;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;



    // Actions

    //1)
    public void clickCheckout() {
        BrowserUtils.waitForVisibleElement(checkoutButton);
        checkoutButton.click();
    }


}
