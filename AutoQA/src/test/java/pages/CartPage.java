package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;

public class CartPage extends BasePage {

    private By modal = By.id("cartModal");
    private By continueShopping = By.xpath("//button[text()='Continue Shopping']");
    private By viewCart = By.xpath("//u[text()='View Cart']");

    private By cartMenu = By.xpath("//a[@href='/view_cart']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // 🔥 Add products using config
    public void addProductsFromConfig() {

        String ids = ConfigReader.get("productIds");  // "1,2,3"
        String[] productIds = ids.split(",");

        for (int i = 0; i < productIds.length; i++) {

            String id = productIds[i].trim();

            System.out.println("Adding product with ID: " + id);

            // 🔥 Dynamic locator
            By product = By.cssSelector("a[data-product-id='" + id + "']");

            waitForElement(product).click();

            // Wait for popup
            wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

            // Handle popup
            if (i < productIds.length - 1) {
                waitForElement(continueShopping).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
            } else {
                waitForElement(viewCart).click();
            }
        }

        System.out.println("All config-based products added");
    }

    // 🔹 Go to cart
    public void goToCart() {
        waitForElement(cartMenu).click();
    }
}