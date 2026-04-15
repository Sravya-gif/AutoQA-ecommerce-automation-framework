package com.srm.tests;

import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.SignupPage;

public class FormValidationTest extends BaseTest{
	@Test
	public void emptySignupTest() {

	    SignupPage signup = new SignupPage(driver);

	    signup.clickSignupLogin();

	    signup.enterSignupNameEmail("", "");

	    System.out.println("Validation for empty fields is not accepted");
	}
	@Test
	public void invalidLoginTest() {

	    LoginPage login = new LoginPage(driver);

	    login.login("wrong@gmail.com", "wrong");

	    System.out.println("Invalid login details");
	}
}