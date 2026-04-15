package com.srm.tests;

import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    @Test
    public void contactFormTest() {

        ContactUsPage contact = new ContactUsPage(driver);

        contact.clickContactUs();
        contact.fillForm();
        contact.uploadFile();
        contact.clickSubmit();
        contact.acceptAlert();
        contact.clickHome();

        System.out.println("Contact Us test completed");
    }
}