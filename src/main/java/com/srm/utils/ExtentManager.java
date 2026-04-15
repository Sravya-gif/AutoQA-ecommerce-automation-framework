package com.srm.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/Reports.html");

            spark.config().setReportName("Automation report");
            spark.config().setDocumentTitle("Test results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}