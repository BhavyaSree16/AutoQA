package tests;

import base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test
    public void testFullFlow() {

        SignupPage signup = new SignupPage(driver);

        System.out.println("STEP 1: Open Signup/Login");
        signup.openSignupPage();

        String name = "Bhavya";
        String email = "bhavya" + System.currentTimeMillis() + "@gmail.com";

        System.out.println("STEP 2: Enter Name & Email");
        signup.enterDetails(name, email);
        signup.clickSignup();

        System.out.println("STEP 3: Fill Account Information");
        AccountInfoPage account = new AccountInfoPage(driver);
        account.fillAccountDetails();
        account.clickCreateAccount();

        System.out.println("STEP 4: Click Continue");
        AccountCreatedPage createdPage = new AccountCreatedPage(driver);
        createdPage.clickContinue();

        HomePage home = new HomePage(driver);

        System.out.println("STEP 5: Logout");
        home.clickLogout();

        System.out.println("STEP 6: Navigate to Login");
        home.clickSignupLogin();

        System.out.println("STEP 7: Valid Login");

        LoginPage login = new LoginPage(driver);
        login.login(email, "Test@123");

        // CORRECT ASSERTION
        Assert.assertTrue(login.isLoginSuccessful(), "Valid login failed");

        System.out.println("VALID LOGIN SUCCESSFUL");

        System.out.println("STEP 8: Logout again");
        home.clickLogout();

        System.out.println("END-TO-END FLOW PASSED");
    }
}