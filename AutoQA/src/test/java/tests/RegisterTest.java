package tests;

import base.BaseTest;
import pages.SignupPage;
import pages.AccountInfoPage;
import pages.AccountCreatedPage;
import org.testng.annotations.Test;
import utils.TestData;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "registerData", dataProviderClass = TestData.class)
    public void testFullRegistration(String name, String emailPrefix) {

        SignupPage signup = new SignupPage(driver);

        signup.openSignupPage();

        String email = emailPrefix + System.currentTimeMillis() + "@gmail.com";

        signup.enterDetails(name, email);
        signup.clickSignup();

        AccountInfoPage account = new AccountInfoPage(driver);
        account.fillAccountDetails();
        account.clickCreateAccount();

        // 🔥 NEW STEP
        AccountCreatedPage createdPage = new AccountCreatedPage(driver);
        createdPage.clickContinue();
    }
}