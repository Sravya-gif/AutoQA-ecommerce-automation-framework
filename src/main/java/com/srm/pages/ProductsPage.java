package com.srm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

public class ProductsPage {

    WebDriver driver;
    FluentWait<WebDriver> wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
    }

    By productsBtn = By.xpath("//a[@href='/products']");
    By allProducts = By.className("product-image-wrapper");
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By continueBtn = By.xpath("//button[text()='Continue Shopping']");
    By viewCartBtn = By.xpath("//u[text()='View Cart']");

    public void clickProducts() {
        wait.until(d -> {
            d.findElement(productsBtn).click();
            return true;
        });
    }

    public int getProductsCount() {
        wait.until(d -> d.findElements(allProducts).size() > 0);
        return driver.findElements(allProducts).size();
    }

    public void searchProduct(String name) {
        wait.until(d -> {
            d.findElement(searchBox).sendKeys(name);
            d.findElement(searchBtn).click();
            return true;
        });
    }

    public void addTwoProducts() {

        wait.until(d -> d.findElements(allProducts).size() > 1);

        List<WebElement> products = driver.findElements(allProducts);
        Actions actions = new Actions(driver);

        WebElement p1 = products.get(0);
        actions.moveToElement(p1).perform();

        WebElement add1 = p1.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
        wait.until(d -> {
            add1.click();
            return true;
        });

        wait.until(d -> {
            d.findElement(continueBtn).click();
            return true;
        });

        WebElement p2 = products.get(1);
        actions.moveToElement(p2).perform();

        WebElement add2 = p2.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
        wait.until(d -> {
            add2.click();
            return true;
        });
    }

    public void clickViewCart() {
        wait.until(d -> {
            d.findElement(viewCartBtn).click();
            return true;
        });
    }
}