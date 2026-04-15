package com.srm.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.srm.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver initDriver() {

        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();      
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
            }

            driver.manage().window().maximize();
            int timeout = Integer.parseInt(ConfigReader.getProperty("timeout"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}