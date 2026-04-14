package tests;

import base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test
    public void testFullFlow() {

        // 🔹 STEP 1: Go to Signup/Login
        SignupPage signup = new SignupPage(driver);

        System.out.println("STEP 1: Open Signup/Login");
        signup.openSignupPage();

        String name = "Bhavya";
        String email = "bhavya" + System.currentTimeMillis() + "@gmail.com";

        // 🔹 STEP 2: Register
        System.out.println("STEP 2: Enter Name & Email");
        signup.enterDetails(name, email);
        signup.clickSignup();

        // 🔹 STEP 3: Fill Account Info
        System.out.println("STEP 3: Fill Account Information");
        AccountInfoPage account = new AccountInfoPage(driver);
        account.fillAccountDetails();
        account.clickCreateAccount();

        // 🔹 STEP 4: Continue
        System.out.println("STEP 4: Click Continue");
        AccountCreatedPage createdPage = new AccountCreatedPage(driver);
        createdPage.clickContinue();

        HomePage home = new HomePage(driver);

        // 🔹 STEP 5: Logout
        System.out.println("STEP 5: Logout");
        home.clickLogout();

        // 🔹 STEP 6: Login
        System.out.println("STEP 6: Navigate to Login");
        home.clickSignupLogin();

        System.out.println("STEP 7: Valid Login");

        LoginPage login = new LoginPage(driver);
        login.login(email, "Test@123");

        //Validate login
        Assert.assertTrue(login.isLoginSuccessful(), "Valid login failed");

        System.out.println("VALID LOGIN SUCCESSFUL");

        // STEP 7: PRODUCTS MODULE
        System.out.println("STEP 8: Navigate to Products");

        ProductsPage product = new ProductsPage(driver);
        product.openProductsPage();

        //STEP 8: Search Product
        System.out.println("STEP 9: Search Product");
        product.searchProduct();

        Assert.assertTrue(product.isSearchResultDisplayed(), "Search results not displayed");

        //STEP 9: Category Navigation
        System.out.println("STEP 10: Select Category");
        product.selectCategoryFromConfig();

        Assert.assertTrue(product.isCategoryProductsDisplayed(), "Category products not displayed");

        //STEP 10: View Product
        System.out.println("STEP 11: View Product");
        product.clickViewProduct();

        String productName = product.getProductName();
        String productPrice = product.getProductPrice();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);

        // Final Assertions
        Assert.assertFalse(productName.isEmpty(), "Product name is empty");
        Assert.assertFalse(productPrice.isEmpty(), "Product price is empty");

        System.out.println("END-TO-END FLOW PASSED");
    }
}