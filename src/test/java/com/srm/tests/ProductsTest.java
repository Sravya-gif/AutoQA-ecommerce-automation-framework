package com.srm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ProductsPage;

public class ProductsTest extends BaseTest {

	@Test
	public void testProducts() {

	    ProductsPage product = new ProductsPage(driver);

	    FluentWait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(15))
	            .pollingEvery(Duration.ofSeconds(2))
	            .ignoring(Exception.class);

	    System.out.println("Opening Products Page");

	    product.clickProducts();

	    wait.until(d -> d.findElements(By.className("product-image-wrapper")).size() > 0);

	    int count = product.getProductsCount();
	    System.out.println("Total products: " + count);

	    product.searchProduct("Tshirt");

	    wait.until(d -> d.findElements(By.className("product-image-wrapper")).size() > 0);

	    product.addTwoProducts();

	    product.clickViewCart();

	    wait.until(d -> d.findElement(By.id("cart_info_table")).isDisplayed());

	    System.out.println("Products added to cart successfully");
	}
}