package com.srm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.SignupPage;

public class SignupTest extends BaseTest {

    @Test(dataProvider = "signupData", dataProviderClass = DataProviders.class)
    public void signupTest(String name, String lastname, String title,
                           String day, String month, String year,
                           String email, String password,
                           String company, String address,
                           String city, String state,
                           String zip, String mobile) {

        SignupPage signup = new SignupPage(driver);

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        signup.clickSignupLogin();

        wait.until(d -> d.findElement(By.name("name")).isDisplayed());
        signup.enterSignupNameEmail(name, email);

        Assert.assertFalse(driver.getPageSource().contains("Email Address already exist"));

        signup.selectTitle(title);

        wait.until(d -> d.findElement(By.id("password")).isDisplayed());

        signup.fillAccountInfo(password, day, month, year);

        signup.fillAddressInfo(name, lastname, company,
                address, city, state, zip, mobile);

        signup.clickCreateAccount();

        wait.until(d -> d.getPageSource().contains("Account Created"));

        signup.clickContinue();

        System.out.println("Signup completed for: " + email);
    }
}