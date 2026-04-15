package com.srm.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.srm.driver.DriverFactory;
import com.srm.utils.ConfigReader;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelectorAll('iframe').forEach(e => e.remove());");
        } catch (Exception e) {
            System.out.println("No ads found");
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}