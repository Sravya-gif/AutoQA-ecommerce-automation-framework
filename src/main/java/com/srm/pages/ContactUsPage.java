package com.srm.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

public class ContactUsPage {

    WebDriver driver;
    FluentWait<WebDriver> wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
    }

    By contactBtn = By.xpath("//a[@href='/contact_us']");
    By name = By.name("name");
    By email = By.name("email");
    By subject = By.name("subject");
    By message = By.name("message");
    By upload = By.name("upload_file");
    By submit = By.name("submit");
    By homeBtn = By.xpath("//span[text()='Home']");

    public void clickContactUs() {
        wait.until(d -> {
            d.findElement(contactBtn).click();
            return true;
        });
    }

    public void fillForm() {
        wait.until(d -> {
            d.findElement(name).sendKeys("Sravya");
            d.findElement(email).sendKeys("sravya11@gmail.com");
            d.findElement(subject).sendKeys("Product details");
            d.findElement(message).sendKeys("When will this product be available in stock?");
            return true;
        });
    }

    public void uploadFile() {

        driver.findElement(By.name("upload_file"))
              .sendKeys("E:\\srmUni\\testfile.txt");
    }

    public void clickSubmit() {
        wait.until(d -> {
            d.findElement(submit).click();
            return true;
        });
    }

    public void acceptAlert() {
        wait.until(d -> {
            try {
                Alert alert = d.switchTo().alert();
                alert.accept();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void clickHome() {

        wait.until(d -> {
            try {
                WebElement home = d.findElement(By.xpath("//a[@href='/']"));
                home.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
}