package com.srm.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        String folderPath = System.getProperty("user.dir") + "/screenshots";

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String path = folderPath + "/"
                + testName + "_"
                + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(path));

            System.out.println("Failed so Screenshot saved at: " + path); 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}