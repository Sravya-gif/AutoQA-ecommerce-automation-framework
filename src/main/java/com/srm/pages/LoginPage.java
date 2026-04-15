package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By loginSignupBtn = By.linkText("Signup / Login");
    By emailField = By.cssSelector("[data-qa='login-email']");
    By passwordField = By.cssSelector("[data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By logoutBtn = By.linkText("Logout");

    public void clickLoginSignup() {
        click(loginSignupBtn);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginBtn);
    }

    public void login(String email, String password) {
        clickLoginSignup();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoggedIn() {
        waitForElement(loggedInText);
        return driver.findElement(loggedInText).isDisplayed();
    }

    public void clickLogout() {
        click(logoutBtn);
    }
}