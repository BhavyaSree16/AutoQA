package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;

public class ProductsPage extends BasePage {

    // 🔹 Locators
    private By productsMenu = By.xpath("//a[@href='/products']");
    private By searchBox = By.id("search_product");
    private By searchBtn = By.id("submit_search");

    private By searchedProductsText = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By productList = By.cssSelector(".features_items .product-image-wrapper");

    private By viewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By productName = By.xpath("//div[@class='product-information']/h2");
    private By productPrice = By.xpath("//div[@class='product-information']//span/span");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Step 1: Go to Products Page
    public void openProductsPage() {
        waitForElement(productsMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
    }

    //Step 2: Search Product
    public void searchProduct() {
        String keyword = ConfigReader.get("searchKeyword");

        WebElement search = waitForElement(searchBox);
        search.clear();
        search.sendKeys(keyword);

        waitForElement(searchBtn).click();

        System.out.println("✅ Searched for: " + keyword);
    }

    //Step 3: Verify Search Results
    public boolean isSearchResultDisplayed() {
        return waitForElement(searchedProductsText).isDisplayed()
                && driver.findElements(productList).size() > 0;
    }

 // Step 4: CATEGORY FROM CONFIG (FINAL FIXED)
    public void selectCategoryFromConfig() {

        String main = ConfigReader.get("mainCategory");   // Women
        String sub = ConfigReader.get("subCategory");     // Dress

        //Correct locator for main category (collapse menu)
        By mainCategory = By.xpath("//a[@href='#" + main + "']");

        //Correct locator for sub category
        By subCategory = By.xpath("//a[normalize-space()='" + sub + "']");

        // Click main category first (expand)
        waitForElement(mainCategory).click();

        // Then click sub-category
        waitForElement(subCategory).click();

        System.out.println("Category selected: " + main + " → " + sub);
    }

    public boolean isCategoryProductsDisplayed() {
        return driver.findElements(productList).size() > 0;
    }

    //Step 5: Open Product Detail
    public void clickViewProduct() {
        waitForElement(viewProduct).click();
    }

    // Step 6: Get Product Name
    public String getProductName() {
        return waitForElement(productName).getText();
    }

    //Step 7: Get Product Price
    public String getProductPrice() {
        return waitForElement(productPrice).getText();
    }
}