package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By cartMenu = By.xpath("//a[@href='/view_cart']");
    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By loginLink = By.xpath("//u[text()='Register / Login']");
    By cartItem = By.className("cart_info");
    By removeProduct3 = By.xpath("//a[@data-product-id='3']");
    By cartTable = By.id("cart_info_table");

    public void openCart() {
        click(cartMenu);
    }
    public void removeSecondProduct() {
        driver.findElement(removeProduct3).click();
    }
 
    public void clickProceedToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public void clickRegisterLogin() {
        click(loginLink);
    }
    
    public int getCartItemCount() {
        return driver.findElements(cartItem).size();
    }

    public boolean isProductInCart() {
        try {
            waitForElement(cartItem);
            return driver.findElement(cartItem).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}