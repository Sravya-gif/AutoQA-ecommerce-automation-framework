package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By commentBox = By.name("message");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");

    By payConfirmBtn = By.id("submit");
    public void enterComment(String comment) {
        sendKeys(commentBox, comment);
    }
    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }
    public void enterPaymentDetails(String name, String number,
                                    String cvcCode, String month, String year) {

        sendKeys(nameOnCard, name);
        sendKeys(cardNumber, number);
        sendKeys(cvc, cvcCode);
        sendKeys(expiryMonth, month);
        sendKeys(expiryYear, year);
    }
    public void clickPayConfirm() {
        click(payConfirmBtn);
    }
}