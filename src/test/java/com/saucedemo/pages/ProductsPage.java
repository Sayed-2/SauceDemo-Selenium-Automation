package com.saucedemo.pages;

import com.saucedemo.utilities.BrowserUtils;
import com.saucedemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement productsTitle;

    @FindBy(xpath = "//div[@class='inventory_list']")
    public WebElement inventoryList;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartSauceLabBackPack;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartLink;


    //Actions that can be done in ProductsPage
                       //1)
    public void addToCartSauceLabBackPack(){
        BrowserUtils.waitForVisibleElement(addToCartSauceLabBackPack);
        addToCartSauceLabBackPack.click();
    }
                       //2)
    public void shoppingCartLink(){
        BrowserUtils.waitForVisibleElement(shoppingCartLink);
        shoppingCartLink.click();
    }

















}
