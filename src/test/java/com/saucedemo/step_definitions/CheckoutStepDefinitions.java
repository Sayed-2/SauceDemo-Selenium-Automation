package com.saucedemo.step_definitions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutStepDefinitions {

    //scenario (1, 2, 3) -step 1:
    @Given("the user is logged in with valid credentials.")
    public void the_user_is_logged_in() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
    }

    ////scenario (1, 2, 3) -step 2:
    @When("the user adds Sauce Labs Backpack to the cart")
    public void the_user_adds_sauce_labs_backpack_to_the_cart() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.addToCartSauceLabBackPack();

    }

    //scenario (1, 2, 3) -step 3:
    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        ProductsPage productsPage = new ProductsPage();
        productsPage.shoppingCartLink();

        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();
    }

    //scenario (1, 2) -step 4:
    @When("the user enters the following checkout information:")
    public void the_user_enters_valid_checkout_information(DataTable dataTable) {

        List<Map<String, String>> checkoutDate = dataTable.asMaps(String.class, String.class);
        String firstName = checkoutDate.get(0).get("firstName");
        String lastName = checkoutDate.get(0).get("lastName");
        String postalCode = checkoutDate.get(0).get("postalCode");

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterCheckoutInformation(firstName, lastName, postalCode);
    }

    ////scenario (1) -step 5:
    @When("the user completes the order")
    public void the_user_completes_the_order() {
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.completeOrder();
    }

    //scenario1-step 6:
    @Then("the order confirmation message should be displayed")
    public void the_order_confirmation_message_should_be_displayed() {

        CheckoutPage checkoutPage = new CheckoutPage();
        String actualMessage = checkoutPage.orderConfirmationMessage.getText();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals(actualMessage, expectedMessage);

    }








    //scenario ( 2 ) - step 5:
    //for  negative scenario testing:
    @When("the user clicks the continue button")
    public void the_user_clicks_the_continue_button() {

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.clickContinueButton();
    }
    // scenario 2 - step 6
    @Then("the checkout error message for missing first name should be displayed")
    public void the_checkout_missing_firstName_error_message_should_be_displayed() {

        CheckoutPage checkoutPage = new CheckoutPage();

        String actualMessage = checkoutPage.getCheckoutErrorMessage();
        String expectedMessage = "Error: First Name is required";

        Assert.assertEquals(actualMessage, expectedMessage);
    }





    // scenario 3 - step 6
    @Then("the checkout error message for missing last name should be displayed")
    public void the_checkout_missing_LastName_error_message_should_be_displayed() {

        CheckoutPage checkoutPage = new CheckoutPage();

        String actualMessage = checkoutPage.getCheckoutErrorMessage();
        String expectedMessage = "Error: Last Name is required";

        Assert.assertEquals(actualMessage, expectedMessage);
    }





    // scenario 4 - step 6
    @Then("the checkout error message for missing postal code should be displayed")
    public void the_checkout_missing_postalCode_error_message_should_be_displayed() {

        CheckoutPage checkoutPage = new CheckoutPage();

        String actualMessage = checkoutPage.getCheckoutErrorMessage();
        String expectedMessage = "Error: Postal Code is required";

        Assert.assertEquals(actualMessage, expectedMessage);
    }














}
