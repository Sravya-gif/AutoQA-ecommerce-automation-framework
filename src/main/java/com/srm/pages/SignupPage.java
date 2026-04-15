package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    By signupLoginBtn = By.linkText("Signup / Login");

    By nameField = By.name("name");
    By emailField = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    By titleMr = By.id("id_gender1");
    By titleMrs = By.id("id_gender2");

    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");

    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By companyField = By.id("company");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");

    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public void clickSignupLogin() {
        click(signupLoginBtn);
    }

    public void enterSignupNameEmail(String name, String email) {
        sendKeys(nameField, name);
        sendKeys(emailField, email);
        click(signupBtn);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMr);
        } else {
            click(titleMrs);
        }
    }

    public void fillAccountInfo(String passwordValue, String day, String month, String year) {
        sendKeys(password, passwordValue);
        sendKeys(days, day);
        sendKeys(months, month);
        sendKeys(years, year);
    }

    public void fillAddressInfo(String first, String last, String company,
                                String addr, String cityVal,
                                String stateVal, String zip, String mobileVal) {

        sendKeys(firstName, first);
        sendKeys(lastName, last);
        sendKeys(companyField, company);
        sendKeys(address, addr);
        sendKeys(city, cityVal);
        sendKeys(state, stateVal);
        sendKeys(zipcode, zip);
        sendKeys(mobile, mobileVal);
    }

    public void clickCreateAccount() {
        click(createAccountBtn);
    }

    public void clickContinue() {
        click(continueBtn);
    }
}