package tests;

import base.BaseTest;
import pages.SignupPage;
import org.testng.annotations.Test;
import utils.TestData;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "registerData", dataProviderClass = TestData.class)
    public void testSignup(String name, String emailPrefix) {

        SignupPage signup = new SignupPage(driver);

        signup.openSignupPage();

        String email = emailPrefix + System.currentTimeMillis() + "@gmail.com";

        signup.enterDetails(name, email);

        signup.clickSignup();
    }
}