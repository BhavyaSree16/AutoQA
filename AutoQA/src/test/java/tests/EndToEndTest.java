package tests;

import base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test
    public void testE2E_Register_Login_AddToCart() {

        // 🔹 STEP 1: Register
        SignupPage signup = new SignupPage(driver);
        signup.openSignupPage();

        String name = "Bhavya";
        String email = "bhavya" + System.currentTimeMillis() + "@gmail.com";

        System.out.println("STEP 1: Register");
        signup.enterDetails(name, email);
        signup.clickSignup();

        AccountInfoPage account = new AccountInfoPage(driver);
        account.fillAccountDetails();
        account.clickCreateAccount();

        AccountCreatedPage created = new AccountCreatedPage(driver);
        created.clickContinue();

        HomePage home = new HomePage(driver);

        // STEP 2: Logout
        System.out.println("STEP 2: Logout");
        home.clickLogout();

        // STEP 3: Login
        System.out.println("STEP 3: Login");
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);
        login.login(email, "Test@123");

        Assert.assertTrue(login.isLoginSuccessful(), "Login failed");
        System.out.println("LOGIN SUCCESS");

        // STEP 4: Go to Products
        ProductsPage product = new ProductsPage(driver);
        product.openProductsPage();

        // STEP 5: Add products using config (INDEX/ID)
        System.out.println("STEP 4: Add Products from Config");

        CartPage cart = new CartPage(driver);
        cart.addProductsFromConfig();

        // STEP 6: Go to Cart
        System.out.println("STEP 5: Go to Cart");
        cart.goToCart();

        System.out.println(" END-TO-END TEST PASSED");
    }
}