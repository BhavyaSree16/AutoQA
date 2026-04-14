package tests;

import base.BaseTest;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void testProductModule() {

        ProductsPage product = new ProductsPage(driver);

        //Step 1: Open Products Page
        System.out.println("STEP 1: Open Products Page");
        product.openProductsPage();

        //Step 2: Search Product
        System.out.println("STEP 2: Search Product");
        product.searchProduct();

        //Step 3: Verify Search Results
        System.out.println("STEP 3: Verify Search Results");
        Assert.assertTrue(product.isSearchResultDisplayed(), "Search results not displayed");

        //Step 4: Category Navigation (UPDATED)
        System.out.println("STEP 4: Select Category");
        product.selectCategoryFromConfig();

        Assert.assertTrue(product.isCategoryProductsDisplayed(), "Category products not displayed");

        //Step 5: Product Detail
        System.out.println("STEP 5: View Product");
        product.clickViewProduct();

        String name = product.getProductName();
        String price = product.getProductPrice();

        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);

//        Assertions
        Assert.assertFalse(name.isEmpty(), "Product name is empty");
        Assert.assertFalse(price.isEmpty(), "Product price is empty");

        System.out.println("✅ PRODUCT MODULE TEST PASSED");
    }
}