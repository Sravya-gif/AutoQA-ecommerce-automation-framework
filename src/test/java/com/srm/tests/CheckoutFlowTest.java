package com.srm.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ProductsPage;
import com.srm.pages.CartPage;
import com.srm.pages.LoginPage;
import com.srm.pages.CheckoutPage;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void fullCheckoutFlow() {

        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        LoginPage login = new LoginPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        wait.until(d -> {
            products.clickProducts();
            return true;
        });

        wait.until(d -> {
        	products.addTwoProducts();
            return true;
        });

        wait.until(d -> {
            products.clickViewCart();
            return true;
        });

        wait.until(d -> {
            cart.clickProceedToCheckout();
            return true;
        });

        wait.until(d -> {
            cart.clickRegisterLogin();
            return true;
        });

        wait.until(d -> {
            login.login("alasravya@gmail.com", "1234568");
            return true;
        });

        wait.until(d -> {
            cart.openCart();
            return true;
        });

        wait.until(d -> {
            cart.clickProceedToCheckout();
            return true;
        });

        wait.until(d -> {
            checkout.enterComment("please deliver fast");
            return true;
        });

        wait.until(d -> {
            checkout.clickPlaceOrder();
            return true;
        });

        wait.until(d -> {
            checkout.enterPaymentDetails(
                    "Sravya",
                    "1231231231231230",
                    "987",
                    "11",
                    "2036"
            );
            return true;
        });

        wait.until(d -> {
            checkout.clickPayConfirm();
            return true;
        });

        System.out.println("Order placed successfully");
    }
}